// lib/widget/tarjeta_log_mp.dart
import 'package:flutter/material.dart';

class TarjetaEvolucion extends StatelessWidget {
  final String   nivel;        // RUTINA, CONTROL, ALERTA, CRÍTICO
  final String   paciente;
  final String   observacion;
  final DateTime timestamp;

  const TarjetaEvolucion({
    super.key,
    required this.nivel,
    required this.paciente,
    required this.observacion,
    required this.timestamp,
  });

  Color get _colorNivel => switch (nivel) {
    'RUTINA'  => Colors.grey,
    'CONTROL' => Colors.blue,
    'ALERTA'  => Colors.orange,
    'CRÍTICO' => Colors.red,
    _         => Colors.grey,
  };

  @override
  Widget build(BuildContext context) {
    return Container(
      margin:  const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
      padding: const EdgeInsets.all(12),
      decoration: BoxDecoration(
        color:        _colorNivel.withOpacity(0.15),
        borderRadius: BorderRadius.circular(8),
        border:       Border(left: BorderSide(color: _colorNivel, width: 6)),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisSize:       MainAxisSize.max,
        children: [
          // Fila superior: nivel + paciente + hora
          Row(
            children: [
              Container(
                padding:    const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                decoration: BoxDecoration(
                  color: _colorNivel, borderRadius: BorderRadius.circular(4)),
                child: Text(nivel,
                    style: const TextStyle(
                        color: Colors.white, fontSize: 10, fontWeight: FontWeight.bold)),
              ),
              const SizedBox(width: 8),
              Text(paciente,
                  style: TextStyle(
                      fontSize: 12, color: Colors.grey.shade700, fontWeight: FontWeight.w600)),
              const Spacer(),
              Text(
                '${timestamp.hour.toString().padLeft(2, '0')}:'
                '${timestamp.minute.toString().padLeft(2, '0')}:'
                '${timestamp.second.toString().padLeft(2, '0')}',
                style: TextStyle(fontSize: 11, color: Colors.grey.shade500),
              ),
            ],
          ),
          const SizedBox(height: 6),
          Text(observacion, style: TextStyle(fontSize: 13, color: Colors.grey.shade800)),
        ],
      ),
    );
  }
}
