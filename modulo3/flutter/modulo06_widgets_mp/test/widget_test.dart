// Smoke test adaptado — el main.dart de este módulo es un selector de pasos
// (const int paso) y no expone una única clase de app raíz para testear.
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:modulo06_widgets_mp/widgets/paso1_saludo_mp.dart';

void main() {
  testWidgets('BienvenidaConsultorio muestra el texto de bienvenida', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(
      home: Scaffold(body: Center(child: BienvenidaConsultorio())),
    ));

    expect(find.text('Consultorio San Rafael'), findsOneWidget);
  });
}
