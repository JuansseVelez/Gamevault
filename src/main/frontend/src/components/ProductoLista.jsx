function ProductoLista({ productos, camposExtra, onEditar, onEliminar }) {
  if (productos.length === 0) {
    return <p className="mensaje-vacio">No hay productos registrados todavía.</p>;
  }

  return (
    <table className="tabla-productos">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Precio</th>
          {camposExtra.map((c) => (
            <th key={c.name}>{c.label}</th>
          ))}
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        {productos.map((p) => (
          <tr key={p.id}>
            <td>{p.nombre}</td>
            <td>${p.precio?.toLocaleString("es-CO")}</td>
            {camposExtra.map((c) => (
              <td key={c.name}>{p[c.name]}</td>
            ))}
            <td>
              <button className="btn-icono" onClick={() => onEditar(p)}>✏️</button>
              <button className="btn-icono" onClick={() => onEliminar(p.id)}>🗑️</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default ProductoLista;