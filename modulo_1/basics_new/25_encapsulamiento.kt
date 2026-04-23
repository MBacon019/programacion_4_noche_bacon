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