// lib/main.dart
import 'package:flutter/material.dart';
import 'package:modulo06_widgets_mp/widgets/catalogo_basicos_mp.dart';
import 'package:modulo06_widgets_mp/widgets/paso1_saludo_mp.dart';
import 'package:modulo06_widgets_mp/widgets/etiqueta_mp.dart';
import 'package:modulo06_widgets_mp/widgets/pantalla_contexto_mp.dart';
import 'package:modulo06_widgets_mp/widgets/reloj_mp.dart';
import 'package:modulo06_widgets_mp/widgets/servicio_estado_mp.dart';
import 'package:modulo06_widgets_mp/widgets/contador_limitado_mp.dart';
import 'package:modulo06_widgets_mp/widgets/indicador_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1   StatelessWidget mínimo                             │
// │  2  Paso 1b  Widgets básicos — catálogo                        │
// │  3  Paso 2   StatelessWidget con parámetros                     │
// │  4  Paso 3   StatefulWidget / setState / cambio de estatus      │
// │  5  Paso 3b  Parámetros en StatefulWidget                       │
// │  6  Paso 4   Ciclo de vida con Timer                            │
// │  7  Paso 5   BuildContext                                        │
// │  8  Paso 6   Composición de widgets                              │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 6;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme:  ThemeData(colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple, brightness: Brightness.dark)),
  home: switch (paso) {
    1 => const Scaffold(body: Center(child: BienvenidaConsultorio())),
    2 => const CatalogoBasicosMedico(),
    3 => const Scaffold(
      body: Center(
        child: Wrap(
          spacing:    12,
          runSpacing: 8,
          children: [
            EtiquetaMedica(texto: 'Confirmado', color: Colors.green),
            EtiquetaMedica(texto: 'Cancelado',  color: Colors.red,    relleno: true),
            EtiquetaMedica(texto: 'En espera',  color: Colors.orange),
            EtiquetaMedica(texto: 'Urgente',    color: Colors.red,    fontSize: 16, relleno: true),
            EtiquetaMedica(texto: 'Información', color: Colors.blue,  fontSize: 11),
          ],
        ),
      ),
    ),
    4 => const Scaffold(
      body: Center(
        child: ConsultorioEstado(nombre: 'Consultorio 3 — Dra. Gómez'),
      ),
    ),
    5 => Scaffold(                               // Paso 3b
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ContadorPacientes(
              etiqueta: 'Signos de alarma reportados',
              limite:   3,
              color:    Colors.red,
              onLimite: () => debugPrint('¡Protocolo de emergencia activado!'),
            ),
            const SizedBox(height: 40),
            ContadorPacientes(
              etiqueta: 'Pacientes en sala de espera',
              limite:   10,
              color:    Colors.indigo,
            ),
          ],
        ),
      ),
    ),
    6 => Scaffold(                              // Paso 4
      appBar: AppBar(title: const Text('Tiempo de consulta')),
      body: const Center(child: CronometroConsulta()),
    ),
     7 => const PantallaContextoMedica(),    // Paso 5 — ya tiene su propio Scaffold
     8 => Scaffold(                             // Paso 6
      body: Center(
        child: Wrap(
          spacing:    32,
          runSpacing: 24,
          alignment:  WrapAlignment.center,
          children: const [
            IndicadorClinico(label: 'Pacientes atendidos hoy', valor: '8',
                      color: Colors.green, icono: Icons.local_hospital),
            IndicadorClinico(label: 'Alertas críticas',        valor: '2',
                      color: Colors.red,   icono: Icons.warning_amber,
                      subtitulo: 'Requieren atención'),
            IndicadorClinico(label: 'Turnos pendientes',       valor: '12',
                      color: Colors.indigo),
            IndicadorClinico(label: 'Disponibilidad Consultorio A', valor: '99.8%',
                      color: Colors.teal, subtitulo: 'Últimos 30 días',
                      icono: Icons.event_available),
            IndicadorClinico(label: 'Disponibilidad Consultorio B', valor: '97.2%',
                      color: Colors.orange, subtitulo: 'Turno tarde',
                      icono: Icons.event_available),
          ],
        ),
      ),
    ),
    _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));
