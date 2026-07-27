class TareaDto {
  final int    id;
  final String titulo;
  final bool   completada;

  const TareaDto({
    required this.id,
    required this.titulo,
    required this.completada,
  });

  factory TareaDto.fromJson(Map<String, dynamic> json) => TareaDto(
    id:         json['id']        as int,
    titulo:     json['title']     as String,
    completada: json['completed'] as bool,
  );
}
