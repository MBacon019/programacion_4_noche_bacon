import 'medicamento_mp.dart';

class MedicamentoDto {
  final int     id;
  final String  name;
  final String  price;
  final bool    isActive;
  final String? categoryName;

  const MedicamentoDto({
    required this.id,
    required this.name,
    required this.price,
    required this.isActive,
    this.categoryName,
  });

  factory MedicamentoDto.fromJson(Map<String, dynamic> json) => MedicamentoDto(
    id:           json['id']    as int,
    name:         json['title'] as String,
    price:        (json['price'] as num).toString(),
    isActive:     json['is_active'] as bool? ?? false,
    categoryName: (json['category'] is Map<String, dynamic>)
        ? (json['category'] as Map<String, dynamic>)['name'] as String?
        : null,
  );

  Medicamento toDomain() => Medicamento(
    id:         id,
    nombre:     name,
    precio:     double.tryParse(price) ?? 0,
    disponible: isActive,
    categoria:  categoryName,
  );
}
