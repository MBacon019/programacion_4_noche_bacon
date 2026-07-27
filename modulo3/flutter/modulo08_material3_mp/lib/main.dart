// lib/main.dart
import 'package:flutter/material.dart';
import 'screens/paso1_principal_mp.dart';
import 'screens/pantalla_tema_mp.dart';
import 'screens/pantalla_appbar_mp.dart';
import 'screens/pantalla_navegacion_mp.dart';
import 'screens/pantalla_dialogs_mp.dart';
import 'widgets/catalogo_botones_mp.dart';

void main() => runApp(const AppConsultasMedicas());

class AppConsultasMedicas extends StatefulWidget {
  const AppConsultasMedicas({super.key});

  @override
  State<AppConsultasMedicas> createState() => _AppConsultasMedicasState();
}

class _AppConsultasMedicasState extends State<AppConsultasMedicas> {
  int paso = 1;

  ThemeMode _themeMode = ThemeMode.system;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF003893),
          primary: const Color(0xFF003893),
          secondary: const Color(0xFFFFD100),
          tertiary: const Color(0xFFED1C24),
        ),
        useMaterial3: true,
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF003893),
          primary: const Color(0xFF003893),
          secondary: const Color(0xFFFFD100),
          tertiary: const Color(0xFFED1C24),
          brightness: Brightness.dark,
        ),
        useMaterial3: true,
      ),
      themeMode: _themeMode,
      home: paso == 1
          ? const PantallaPrincipalMedica()
          : paso == 2
              ? PantallaTemaMedica(
                  themeMode: _themeMode,
                  onToggle: (mode) => setState(() => _themeMode = mode),
                )
              : paso == 3
                  ? const PantallaAppBarMedica()
                  : paso == 4
                      ? const CatalogoBotonesMedico()
                      : paso == 5
                          ? const PantallaNavegacionMedica()
                          : const PantallaDialogsMedica(),
    );
  }
}
