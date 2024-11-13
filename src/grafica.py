import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# Leer el archivo CSV
df = pd.read_csv('tiempos_ejecucion.csv')

# Crear un gráfico lineal para cada función
funciones = df['Funcion'].unique()
plt.figure(figsize=(12, 8))

# Definir una lista de colores
colores = plt.cm.get_cmap('tab20', len(funciones))

# Definir un desplazamiento vertical mayor
desplazamiento = 5000  # Aumentar el valor del desplazamiento

# Funciones a las que se les aplicará el desplazamiento
funciones_con_desplazamiento = ['topFront', 'topBack', 'pushBack', 'popBack']

for i, funcion in enumerate(funciones):
    subset = df[df['Funcion'] == funcion]
    x = subset['n']
    y = subset['Tiempo (microsegundos)']
    
    # Añadir un mayor desplazamiento vertical solo a las funciones especificadas
    if funcion in funciones_con_desplazamiento:
        y_desplazado = y + i * desplazamiento
    else:
        y_desplazado = y
    
    # Graficar los puntos con un color diferente para cada función
    plt.plot(x, y_desplazado, label=funcion, linewidth=2, marker='o', color=colores(i))

# Configurar etiquetas y título con tamaños de fuente más grandes
plt.xlabel('tamaño del arreglo (n)', fontsize=14)
plt.ylabel('Tiempo (microsegundos)', fontsize=14)
plt.title('Tiempo de Ejecución de las Funciones de List', fontsize=16)

# Agrandar el cuadro de la leyenda
plt.legend(loc='upper left', bbox_to_anchor=(1, 1), fontsize='large')
plt.grid(True)
plt.tight_layout()

# Guardar el gráfico como una imagen
plt.savefig('Grafico_Complejidad.png', bbox_inches='tight')

# Mostrar el gráfico
plt.show()