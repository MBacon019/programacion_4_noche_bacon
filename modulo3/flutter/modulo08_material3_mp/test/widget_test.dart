import 'package:flutter_test/flutter_test.dart';

import 'package:modulo08_material3_mp/main.dart';

void main() {
  testWidgets('App renders without error', (WidgetTester tester) async {
    await tester.pumpWidget(const AppConsultasMedicas());
    expect(find.text('SnackBar y Dialog'), findsOneWidget);
  });
}
