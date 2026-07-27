// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:modulo09_formularios_mp/screens/pantalla_busqueda_citas_mp.dart';

void main() {
  testWidgets('Pantalla de búsqueda de turnos se construye', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(home: PantallaBusquedaCitasMp()));

    expect(find.byType(PantallaBusquedaCitasMp), findsOneWidget);
    expect(find.text('Turnos (4)'), findsOneWidget);
  });
}
