print("Manipulación de listas")
print("Crear una lista")
vacia = []
print(vacia)
numeros = [1, 2, 3, 4, 5]
print(numeros)
nombres = ["Alice", "Bob", "Charlie"]
print(nombres)
mixta = [1, "Hola", 3.14, True]
print(mixta)
anidada = [[1, 2], [3, 4], [5, 6]]
print(anidada)
print("Acceso a loselementos de una lista con lambda")
print(nombres[1])
print(nombres[-1])
print(nombres[1:3])
print(nombres[::-1])

print("Crud de listas")
frutas = ["manzana", "banana", "cereza"]
# Agregar elementos
frutas.insert(3, "naranja")
frutas.append("pera")
print(frutas)
frutas.extend(["kiwi", "mango"])
#modificar 
frutas[0] = "plátano"
print(frutas)
#eliminar
frutas.remove("banana")
print(frutas)
eliminado = frutas.pop(2)
print(eliminado)
print(frutas)
del frutas[0]
print(frutas)


print("Bucasr valoires en una lista")
print("banana" in frutas)
print(frutas.index("cereza"))
print(frutas.index("cereza"))

print("Ordenar  en una lista")
numeros_desordenados = [5, 2, 9, 1, 5, 6]
print(numeros_desordenados)
numeros_desordenados.sort()
print(numeros_desordenados)
numeros_desordenados.sort(reverse=True)
print(numeros_desordenados)
ordenada = sorted(numeros_desordenados)
print(ordenada) 
print(numeros_desordenados)

print("Diccionarios")
print("Crear un diccionario")
vacio = {}
persona = {"nombre": "Alice", "edad": 30, "ciudad": "Madrid"}
config=dict(host="localhost", port=8080, debug=True)
#ACCWESO
print(persona["nombre"])
#modificar
persona["nombre"] = "Bob"
print(persona["nombre"])
del persona["edad"]
print(persona)
#verificar
print("nombre" in persona)
print("ciudad" in persona)
#metodos esenciales
print(persona.keys())
print(persona.values())
print(persona.items())
#iterar
for clave, valor in persona.items():
    print(f"{clave}: {valor}")