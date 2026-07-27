import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

// ── Menú principal ─────────────────────────────────────────────────────────────
class PantallaMenuMp extends StatelessWidget {
  const PantallaMenuMp({super.key});

  @override
  Widget build(BuildContext context) {
    const pasos = [
      _PasoInfoMp(
        ruta: '/paso1',
        titulo: 'Paso 1',
        subtitulo: 'FutureBuilder crudo',
        detalle: 'http.get() + FutureBuilder · Pendiente del consultorio',
        icono: Icons.network_ping,
        color: Colors.blue,
      ),
      _PasoInfoMp(
        ruta: '/paso2',
        titulo: 'Paso 2',
        subtitulo: 'DTO simple',
        detalle: 'TareaDto.fromJson · lista de tareas médicas',
        icono: Icons.data_object,
        color: Colors.green,
      ),
      _PasoInfoMp(
        ruta: '/paso3',
        titulo: 'Paso 3',
        subtitulo: 'API real + modelo de dominio',
        detalle: 'MedicamentoDto · toDomain() · catálogo de medicamentos',
        icono: Icons.medical_services,
        color: Colors.orange,
      ),
      _PasoInfoMp(
        ruta: '/paso4',
        titulo: 'Paso 4',
        subtitulo: 'Errores tipados',
        detalle: 'sealed ApiError · Result<T>',
        icono: Icons.error_outline,
        color: Colors.red,
      ),
      _PasoInfoMp(
        ruta: '/paso5',
        titulo: 'Paso 5',
        subtitulo: 'Arquitectura completa',
        detalle: 'HttpClient · Repository · Riverpod Notifier',
        icono: Icons.architecture,
        color: Colors.purple,
      ),
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Módulo 12 — Consultorio · API REST'),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
      ),
      body: ListView.separated(
        padding: const EdgeInsets.all(16),
        itemCount: pasos.length,
        separatorBuilder: (_, __) => const SizedBox(height: 8),
        itemBuilder: (context, i) {
          final p = pasos[i];
          return Card(
            child: ListTile(
              contentPadding:
                  const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              leading: CircleAvatar(
                backgroundColor: p.color,
                radius: 24,
                child: Icon(p.icono, color: Colors.white),
              ),
              title: Text(
                '${p.titulo} · ${p.subtitulo}',
                style: const TextStyle(fontWeight: FontWeight.bold),
              ),
              subtitle: Padding(
                padding: const EdgeInsets.only(top: 4),
                child: Text(
                  p.detalle,
                  style: TextStyle(color: Colors.grey[600], fontSize: 12),
                ),
              ),
              trailing: const Icon(Icons.chevron_right),
              onTap: () => context.go(p.ruta),
            ),
          );
        },
      ),
    );
  }
}

class _PasoInfoMp {
  final String ruta;
  final String titulo;
  final String subtitulo;
  final String detalle;
  final IconData icono;
  final Color color;
  const _PasoInfoMp({
    required this.ruta,
    required this.titulo,
    required this.subtitulo,
    required this.detalle,
    required this.icono,
    required this.color,
  });
}
