import { useState, useEffect } from "react";

// Define qué campos extra tiene cada tipo, además de nombre y precio
const CAMPOS_POR_TIPO = {
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

function ProductoForm({ tipo, productoEditar, onGuardar, onCancelar }) {
  const camposExtra = CAMPOS_POR_TIPO[tipo] || [];
  const [formData, setFormData] = useState({ nombre: "", precio: "" });

  useEffect(() => {
    if (productoEditar) {
      setFormData(productoEditar);
    } else {
      const vacio = { nombre: "", precio: "" };
      camposExtra.forEach((c) => (vacio[c.name] = ""));
      setFormData(vacio);
    }
  }, [productoEditar, tipo]);

  function handleChange(e) {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  }

  function handleSubmit(e) {
    e.preventDefault();
    const datos = { ...formData, precio: parseFloat(formData.precio) };
    onGuardar(datos);
  }

  return (
    <form className="formulario" onSubmit={handleSubmit}>
      <h3>{productoEditar ? "Editar" : "Agregar"} {tipo.slice(0, -1)}</h3>

      <input
        name="nombre"
        placeholder="Nombre"
        value={formData.nombre || ""}
        onChange={handleChange}
        required
      />
      <input
        name="precio"
        type="number"
        placeholder="Precio"
        value={formData.precio || ""}
        onChange={handleChange}
        required
      />

      {camposExtra.map((campo) => (
        <input
          key={campo.name}
          name={campo.name}
          placeholder={campo.label}
          value={formData[campo.name] || ""}
          onChange={handleChange}
          required
        />
      ))}

      <div className="formulario-botones">
        <button type="submit" className="btn btn-primario">
          Guardar
        </button>
        {productoEditar && (
          <button type="button" className="btn btn-secundario" onClick={onCancelar}>
            Cancelar
          </button>
        )}
      </div>
    </form>
  );
}

export default ProductoForm;