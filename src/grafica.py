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

for i, funcion in enumerate(funciones):
    subset = df[df['Funcion'] == funcion]
    x = subset['n']
    y = subset['Tiempo (microsegundos)']
    
    # Añadir un mayor desplazamiento vertical a los valores de y
    y_desplazado = y + i * desplazamiento
    
    # Graficar los puntos con un color diferente para cada función
    plt.plot(x, y_desplazado, label=funcion, linewidth=2, marker='o', color=colores(i))

plt.xlabel('n')
plt.ylabel('Tiempo (microsegundos)')
plt.title('Tiempo de Ejecución de las Funciones de ListAPI')
plt.legend()
plt.grid(True)
plt.tight_layout()

# Guardar el gráfico como una imagen
plt.savefig('tiempos_ejecucion_grafico_lineal.png')

# Mostrar el gráfico
plt.show()