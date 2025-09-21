#!/usr/bin/python3

from pylab import *

import ltspy3
import matplotlib.pyplot as plt


sd = ltspy3.SimData('netlist.raw')

# Índices de las variables
# Asumimos que la variable de tiempo se llama 'time' en el .raw
ntime = sd.variables.index(b'time')  
nvout = sd.variables.index(b'V(x)')

nsteps = sd.nosteps

# Generamos un array de colores
colors = plt.cm.viridis(np.linspace(0, 1, nsteps))

plt.figure(figsize=(8,5))

# Trazamos cada step con un color distinto
for i in range(nsteps):
    t = sd.values[ntime][i]
    v = sd.values[nvout][i]
    plt.plot(t, v,
             color=colors[i],
             label=f'Step {i+1}')

# Etiquetas de ejes
plt.xlabel('t (s)')
plt.ylabel('V(x) (V)')

# Leyenda y rejilla
plt.legend(title='Runs', loc='best')
plt.grid(True)

# Guardar y mostrar
plt.tight_layout()
plt.savefig("grafico.png", dpi=300)
plt.show()



#sd=ltspy3.SimData('netlist.raw')

#nvout = sd.variables.index(b'V(x)')
#ntime = 0

#for nrun in range(sd.nosteps):
#    plt.plot(sd.values[ntime][nrun],sd.values[nvout][nrun])

#plt.savefig("grafico.png")
#show()
