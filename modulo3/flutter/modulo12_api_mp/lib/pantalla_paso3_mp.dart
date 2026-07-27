import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;

import 'medicamento_mp.dart';
import 'medicamento_dto_mp.dart';

class PantallaPaso3Mp extends StatelessWidget {
  const PantallaPaso3Mp({super.key});

  Future<List<Medicamento>> _fetchMedicamentos() async {
    final res = await http.get(
      Uri.parse(
          'https://api.escuelajs.co/api/v1/products?limit=20&offset=0'),
    );
    final lista = jsonDecode(res.body) as List<dynamic>;
    return lista
        .map((e) => MedicamentoDto.fromJson(e as Map<String, dynamic>).toDomain())
        .toList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Paso 3 · API real'),
        leading: BackButton(onPressed: () => context.go('/')),
      ),
      body: FutureBuilder<List<Medicamento>>(
        future: _fetchMedicamentos(),
        builder: (context, snap) {
          if (snap.connectionState != ConnectionState.done) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snap.hasError) {
            return Center(child: Text('Error: ${snap.error}'));
          }

          final medicamentos = snap.data!;
          return ListView.builder(
            padding: const EdgeInsets.all(8),
            itemCount: medicamentos.length,
            itemBuilder: (context, i) {
              final m = medicamentos[i];
              return Card(
                child: ListTile(
                  leading: CircleAvatar(
                    backgroundColor:
                        m.disponible ? Colors.green[100] : Colors.grey[200],
                    child: Text(
                      m.id.toString(),
                      style: TextStyle(
                        color: m.disponible ? Colors.green[800] : Colors.grey,
                        fontWeight: FontWeight.bold,
                        fontSize: 12,
                      ),
                    ),
                  ),
                  title: Text(m.nombre),
                  subtitle: Text(m.categoria ?? 'Sin categoría'),
                  trailing: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.end,
                    children: [
                      Text(
                        '\$${m.precio.toStringAsFixed(2)}',
                        style: const TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 14),
                      ),
                      const SizedBox(height: 2),
                      Text(
                        m.disponible ? 'Disponible' : 'Agotado',
                        style: TextStyle(
                          color: m.disponible ? Colors.green : Colors.grey,
                          fontSize: 11,
                        ),
                      ),
                    ],
                  ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}
