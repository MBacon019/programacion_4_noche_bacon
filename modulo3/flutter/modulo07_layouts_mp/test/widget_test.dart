// Smoke test adaptado — el main.dart de este módulo es un selector de pasos
// (const int paso) y no expone una única clase de app raíz para testear.
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:modulo07_layouts_mp/widget/paso1_contenedor_mp.dart';

void main() {
  testWidgets('paso1Contenedor muestra la tarjeta del paciente', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(home: paso1Contenedor()));

    expect(find.text('Paciente: Juan Pérez — Sala 204'), findsOneWidget);
  });
}
