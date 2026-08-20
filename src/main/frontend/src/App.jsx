import { useState, useEffect } from "react";
import Navbar from "./components/Navbar";
import ProductoForm from "./components/ProductoForm";
import ProductoLista from "./components/ProductoLista";
import { videojuegoApi, consolaApi, accesorioApi, productoApi } from "./services/api";
import "./App.css";

const APIS = {
  videojuegos: videojuegoApi,
  consolas: consolaApi,
  accesorios: accesorioApi,
};

const CAMPOS_EXTRA = {
  videojuegos: [
    { name: "genero", label: "Género" },
    { name: "plataforma", label: "Plataforma" },
  ],
  consolas: [
    { name: "marca", label: "Marca" },
    { name: "tipo", label: "Tipo" },
    { name: "soporte", label: "Soporte" },
  ],
  accesorios: [
    { name: "marca", label: "Marca" },
    { name: "compatibilidad", label: "Compatibilidad" },
    { name: "categoria", label: "Categoría" },
  ],
};

function App() {
  const [pestañaActiva, setPestañaActiva] = useState("videojuegos");
  const [productos, setProductos] = useState([]);
  const [productoEditar, setProductoEditar] = useState(null);
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    cargarProductos();
    setProductoEditar(null);
  }, [pestañaActiva]);

  async function cargarProductos() {
    setCargando(true);
    setError(null);
    try {
      const api = pestañaActiva === "todos" ? productoApi : APIS[pestañaActiva];
      const datos = await api.obtenerTodos();
      setProductos(datos);
    } catch (err) {
      setError("No se pudo conectar con el backend. ¿Está corriendo en el puerto 8080?");
    } finally {
      setCargando(false);
    }
  }

  async function handleGuardar(datos) {
    const api = APIS[pestañaActiva];
    try {
      if (productoEditar) {
        await api.actualizar(productoEditar.id, datos);
      } else {
        // id manual mientras no tengas @GeneratedValue en el backend
        const nuevoId = Date.now();
        await api.crear({ ...datos, id: nuevoId });
      }
      setProductoEditar(null);
      cargarProductos();
    } catch (err) {
      setError("Error al guardar el producto.");
    }
  }

  async function handleEliminar(id) {
    if (!confirm("¿Seguro que quieres eliminar este producto?")) return;
    try {
      await APIS[pestañaActiva].eliminar(id);
      cargarProductos();
    } catch (err) {
      setError("Error al eliminar el producto.");
    }
  }

  const esVistaTodos = pestañaActiva === "todos";

  return (
    <div className="app">
      <Navbar pestañaActiva={pestañaActiva} onCambiarPestaña={setPestañaActiva} />

      <main className="contenido">
        {error && <p className="mensaje-error">{error}</p>}

        {!esVistaTodos && (
          <ProductoForm
            tipo={pestañaActiva}
            productoEditar={productoEditar}
            onGuardar={handleGuardar}
            onCancelar={() => setProductoEditar(null)}
          />
        )}

        {cargando ? (
          <p>Cargando...</p>
        ) : (
          <ProductoLista
            productos={productos}
            camposExtra={esVistaTodos ? [] : CAMPOS_EXTRA[pestañaActiva]}
            onEditar={setProductoEditar}
            onEliminar={handleEliminar}
          />
        )}
      </main>
    </div>
  );
}

export default App;