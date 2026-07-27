void saludar() {
  print('Hola mundo');
}

void saludoConParametro(String nombre) {
  print('Hola $nombre');
}

int obtenerNumero(){
  return 10;
}

int sumar(int a, int b) {
  return a+b;
}  

int multiplicar(int a, int b)=> a*b;

void saludarOpcional(String nombre, [String apellido='Sin apellido']){
  print('Hola $nombre $apellido');
}

// funcion con parametros nombres
void registroUsuario({
  required String nombre,
  required int edad,
}){
  print("Hola $nombre edad: $edad");
}


void main() {
  saludar();
  saludoConParametro('Pedro Perez');
  int numero = obtenerNumero();
  print(numero);
  print('el numero es : ${obtenerNumero()}');
  print('la suma : ${sumar(5,5)}');
  print('la multiplicacion : ${multiplicar(5, 5)}');
  saludarOpcional('Marcelo','Bacon');
  saludarOpcional('Marcelo');
  registroUsuario(nombre: 'Marcelo', edad: 26);
}