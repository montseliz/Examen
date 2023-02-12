# Prova de nivell 
## IT Academy
### Sprint 1 

Control de factures d’una start up.

No hi ha base de dades. Guardem les diferents dades en dos fitxers CSV. 

**CSV 1** -> Tindrem un fitxer de factures amb els següents camps: 

	- número de factura 

	- nom del client

	- direcció postal

	- telèfon 

	- total de la factura

**CSV 2** -> Tindrem un fitxer de les línies de la factura amb els següents camps:
 
	- número de línies de factura

	- número de factura

	- nom del producte

	- descripció

	- quantitat 

	- preu

S’enllacen els dos fitxers amb el número de factura. 


**Menú amb les següents opcions:**

- Crear factura.

- Crear línies de factura a una ja existent. 

- Calcular l’import d’una factura (recórrer la línia de factura, multiplicar la quantitat pel preu i sumar totes les línies de factures). 

- Calcular l’import de totes les factures de l’start up. 

- Mostrar número de factures d’un client. Si no té cap factura, que salti una excepció personalitzada que digui “El client no té factures”. 

- Mostrar factures d’un client (recórrer les factures fetes per un client), utilitzant lambdes.

- Mostrar les factures que tenen un determinat producte, a poder ser, amb lambdes. 

- Eliminar factura d’una forma obsoleta (deprecated). 

- Escriure les factures i les línies de factura en dos fitxers CSV. 



