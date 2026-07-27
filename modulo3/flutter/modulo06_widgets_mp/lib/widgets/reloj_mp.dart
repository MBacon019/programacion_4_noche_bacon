import 'dart:async';
import 'package:flutter/material.dart';

class CronometroConsulta extends StatefulWidget {
  const CronometroConsulta({super.key});

  @override
  State<CronometroConsulta> createState() => _CronometroConsultaState();
}

class _CronometroConsultaState extends State<CronometroConsulta> {
  Timer? _timer;
  int _segundos = 0;
  bool _pausado = false;
  int _pacientesAtendidos = 0;
  final List<int> _tiemposConsulta = [];

  @override
  void initState() {
    super.initState();    // ← siempre primero
    _iniciarTimer();
  }

  void _iniciarTimer() {
    _timer = Timer.periodic(const Duration(milliseconds: 100), (_) {
      if (!mounted) return;
      setState(() => _segundos++);
    });
  }

  void _togglePausa() {
    setState(() {
      _pausado = !_pausado;
      if (_pausado) {
        _timer?.cancel();
      } else {
        _iniciarTimer();
      }
    });
  }

  void _registrarPaciente() {
    setState(() {
      _pacientesAtendidos++;
      _tiemposConsulta.add(_segundos);
    });
  }

  @override
  void dispose() {
    // _timer?.cancel();  // comentado para observar fuga de memoria
    super.dispose();
  }

  String _formatear(int s) {
    final h = s ~/ 3600;
    final m = (s % 3600) ~/ 60;
    final sec = s % 60;
    return '$h:${m.toString().padLeft(2, '0')}:${sec.toString().padLeft(2, '0')}';
  }

  String get _formato => _formatear(_segundos);

  Color get _colorTiempo {
    if (_segundos > 120) return Colors.deepPurple;
    if (_segundos > 60) return Colors.red;
    if (_segundos > 30) return Colors.orange;
    return Colors.green;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          _formato,
          style: TextStyle(
            fontSize:   40,
            fontFamily: 'monospace',
            fontWeight: FontWeight.bold,
            color:      _colorTiempo,         // cambia automáticamente con el tiempo
          ),
        ),
        const SizedBox(height: 16),
        Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            FilledButton.icon(
              onPressed: _togglePausa,
              icon:  Icon(_pausado ? Icons.play_arrow : Icons.pause),
              label: Text(_pausado ? 'Reanudar' : 'Pausar'),
            ),
            const SizedBox(width: 8),
            TextButton(
              onPressed: () => setState(() {
                _timer?.cancel();
                _segundos = 0;
                _pausado = false;
                _pacientesAtendidos = 0;
                _tiemposConsulta.clear();
                _iniciarTimer();
              }),
              child: const Text('Reiniciar'),
            ),
            const SizedBox(width: 8),
            FilledButton.tonalIcon(
              onPressed: _pausado ? null : _registrarPaciente,
              icon: const Icon(Icons.flag),
              label: const Text('Paciente atendido'),
            ),
          ],
        ),
        const SizedBox(height: 8),
        Text(
          _pausado ? 'En pausa' : 'En consulta',
          style: TextStyle(fontSize: 12, color: Colors.grey.shade600),
        ),
        if (_tiemposConsulta.isNotEmpty) ...[
          const SizedBox(height: 8),
          Text(
            'Última consulta: ${_formatear(_tiemposConsulta.last)}',
            style: const TextStyle(fontSize: 16),
          ),
          Text(
            'Pacientes atendidos: $_pacientesAtendidos',
            style: TextStyle(fontSize: 12, color: Colors.grey.shade600),
          ),
        ],
      ],
    );
  }
}
