// lib/providers/citas_provider_mp.dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_riverpod/legacy.dart';
import '../models/cita_mp.dart';

// NotifierProvider — estado complejo con métodos propios
class CitasNotifier extends Notifier<List<Cita>> {
  @override
  List<Cita> build() => [
    Cita(id:'1', paciente:'Juan Pérez',  fecha:'27/07/2026', hora:'09:00', urgente:true,  confirmada:true),
    Cita(id:'2', paciente:'María Gómez', fecha:'27/07/2026', hora:'10:30', urgente:false, confirmada:true),
    Cita(id:'3', paciente:'Carlos Ruiz', fecha:'28/07/2026', hora:'11:15', urgente:false, confirmada:false),
  ];

  void toggleConfirmada(String id) {
    state = state.map((c) =>
        c.id == id
          ? Cita(id:c.id, paciente:c.paciente, fecha:c.fecha,
                 hora:c.hora, urgente:c.urgente,
                 confirmada:!c.confirmada)
          : c
    ).toList();
  }

  void eliminar(String id) {
    state = state.where((c) => c.id != id).toList();
  }

  void agregar(Cita cita) {
    state = [...state, cita];
  }
}

final citasProvider =
    NotifierProvider<CitasNotifier, List<Cita>>(
  CitasNotifier.new,
);

// Filtro de búsqueda — estado primitivo
final busquedaProvider = StateProvider<String>((ref) => '');

// Provider DERIVADO — se recalcula cuando cualquiera de sus dependencias cambia
final citasFiltradasProvider = Provider<List<Cita>>((ref) {
  final todas    = ref.watch(citasProvider);
  final busqueda = ref.watch(busquedaProvider);

  if (busqueda.isEmpty) return todas;

  final q = busqueda.toLowerCase();
  return todas.where((c) =>
      c.paciente.toLowerCase().contains(q) || c.fecha.contains(q)
  ).toList();
});
