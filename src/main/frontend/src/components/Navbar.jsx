function Navbar({ pestañaActiva, onCambiarPestaña }) {
  const pestañas = [
    { id: "videojuegos", label: "Videojuegos" },
    { id: "consolas", label: "Consolas" },
    { id: "accesorios", label: "Accesorios" },
    { id: "todos", label: "Todos" },
  ];

  return (
    <nav className="navbar">
      <h1 className="navbar-titulo">🎮 GameVault</h1>
      <div className="navbar-tabs">
        {pestañas.map((p) => (
          <button
            key={p.id}
            className={`tab ${pestañaActiva === p.id ? "tab-activa" : ""}`}
            onClick={() => onCambiarPestaña(p.id)}
          >
            {p.label}
          </button>
        ))}
      </div>
    </nav>
  );
}

export default Navbar;