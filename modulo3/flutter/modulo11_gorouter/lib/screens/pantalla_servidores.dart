// lib/screens/pantalla_servidores.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../models/servidor_ssh.dart';

class PantallaServidores extends StatelessWidget {
  const PantallaServidores({super.key});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    final servidores = servidoresSimulados;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Servidores'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: ListView.builder(
        itemCount:   servidores.length,
        itemBuilder: (context, i) {
          final servidor = servidores[i];
          return ListTile(
            leading: const Icon(Icons.dns),
            title:   Text(servidor.nombre),
            onTap: () {
              // context.push() — apila la pantalla (aparece botón "atrás")
              context.push(
                '/servidores/${servidor.id}',
                extra: servidor,
              );
            },
          );
        },
      ),
    );
  }
}