print("Funciones en Python ")
print("Funcion basica")

def saludar():
    print("¡Hola, mundo!")

saludar()
print("Funcion con parametros")

def saludarconnombre(nombre):
    print(f"¡Hola, {nombre}, QUE TAL!")

saludarconnombre("Leo")
saludarconnombre("Heymi")


print("Funcion con retorno")
def sumar(a, b):
    return a + b

print(sumar(5, 3))

print("Funcion por posicion y por nombre")
def presentar(nombre, edad, cuidad):
    print(f"Señor (a) {nombre}, tengo {edad} años y vivo en {cuidad}")
presentar("Leo", 25, "Madrid")
presentar("Heymi", 30, "Barcelona")
presentar(edad=25, nombre="Leo", cuidad="Madrid")

print("Funcion con valor por defecto")
def saludo_con_valores(nombre, saludo="¡Hola!", puntuacion="!"):
    print(saludo, nombre, puntuacion)
saludo_con_valores("Leo","Buenas noches","....")
saludo_con_valores("Heymi", puntuacion="....")
saludo_con_valores("Carlos", "Buenas tardes")

print("Funcion con parametros posicionales")
def sumar_todos(*args):
    print(f"Parametros recibidos: {args}")
    return sum(args)
print(sumar_todos(1, 2, 3))
print(sumar_todos(4, 5, 6, 7, 8))
print(sumar_todos(10, 20))

print("Funcion con parametros conbinados")
def mostrar_info(titulo, *datos):
    print(f"Prametros recibidos {datos}, {titulo}")
    print("Titulo:")
    for dato in datos:
        print(f" - {dato}")
print(mostrar_info("Frutas", "Manzana", "Banana", "Naranja"))

print("Funcion parametros claave valor variables")
def crar_perfil(**kwargs):
    print(f"Parametros recibidos: {kwargs}")
    for clave, valor in kwargs.items():
        print(f"{clave}: {valor}")
crar_perfil(nombre="Leo", apellido="Orbe", edad=25, ciudad="Madrid")


print("Funcion parametros conbinacion con todos los tipos")
def configurar(host, *puertos, debug=False, **opciones):
    print(f"Configuracion")
    print(f"Host: {host}")
    print(f"Puertos: {puertos}")
    print(f"Opciones: {opciones}")
    print(f"Debug: {debug}")

configurar("localhost", 8080, 8081, 8082, debug=True, timeout=30, ssl=True)


print("Funcion con multiples valores")
def minmax(numeros):
    return min(numeros), max(numeros)

minimo, maximo = minmax([3, 5, 1, 8, 2])

print(f"Minimo: {minimo}, Maximo: {maximo}")
_,maximo = minmax([3, 5, 1, 8, 2])
print(f"Maximo: {maximo}")
minimo, _ = minmax([3, 5, 1, 8, 2])
print(f"Minimo: {minimo}")


print("Devolver diccionar en el caso de muchos valores0")
def analizar(numeros):
    total = sum(numeros)
    n=len(numeros)
    return {"total": total,
"media": total/n if n > 0 else 0,
"minimo": min(numeros) if numeros else None,
"maximo": max(numeros) if numeros else None,
"count": n}
datos= [3, 5, 1, 8, 2]
stats= analizar(datos)
print(f"Total: {stats['total']}")
print(f"Media: {stats['media']}")
print(f"Rango: {stats['minimo']} - {stats['maximo']}")