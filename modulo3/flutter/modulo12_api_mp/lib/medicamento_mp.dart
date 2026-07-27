class Medicamento {
  final int     id;
  final String  nombre;
  final double  precio;
  final bool    disponible;
  final String? categoria;

  const Medicamento({
    required this.id,
    required this.nombre,
    required this.precio,
    required this.disponible,
    this.categoria,
  });
}
