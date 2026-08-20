const BASE_URL = "http://localhost:8080";

async function manejarRespuesta(response) {
  if (!response.ok) {
    throw new Error(`Error en la petición: ${response.status}`);
  }
  // DELETE no devuelve body, evitamos error al parsear JSON vacío
  const texto = await response.text();
  return texto ? JSON.parse(texto) : null;
}

// Genera las funciones CRUD para un endpoint dado, ej: crearApi("videojuegos")
export function crearApi(recurso) {
  const url = `${BASE_URL}/${recurso}`;

  return {
    obtenerTodos: () => fetch(url).then(manejarRespuesta),
    crear: (item) =>
      fetch(url, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item),
      }).then(manejarRespuesta),
    actualizar: (id, item) =>
      fetch(`${url}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item),
      }).then(manejarRespuesta),
    eliminar: (id) =>
      fetch(`${url}/${id}`, { method: "DELETE" }).then(manejarRespuesta),
  };
}

export const videojuegoApi = crearApi("videojuegos");
export const consolaApi = crearApi("consolas");
export const accesorioApi = crearApi("accesorios");
export const productoApi = crearApi("productos"); // solo para el listado general