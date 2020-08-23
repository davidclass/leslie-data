/*
	Despliegue
	El reenvío al puerto local 443 o un URL local https: // solo está disponible después de que se registre.
Regístrese en: https://ngrok.com/signup

Si ya se ha registrado, asegúrese de que su authtoken esté instalado.
Su authtoken está disponible en su tablero: https://dashboard.ngrok.com/auth/your-authtoken

Para windows:
ngrok authtoken 1f4Z7eyUG7mGymERGU37u4epLHr_77uKiUjaFaGDxyqnHTzEF

Para Linux
./ngrok authtoken 1f4Z7eyUG7mGymERGU37u4epLHr_77uKiUjaFaGDxyqnHTzEF

*/

//Ubicarse en la ruta del ngrock  y ejecutar lo siguiente:


//Desplegar en el puerto 8181 sin seguridad
ngrok http 8181

//Desplegar en el puerto 8443 con seguridad
ngrok http https://localhost:8443 


/* Ventilador  . switch*/
from gpio import *
from time import *

def main():
	while True:
		value = digitalRead(1)
		if value > 0 :
			customWrite(0,2)
		else :
			customWrite(0,0)
		delay(500)

if __name__ == "__main__":
	main()

/* SENSOR LCD*/
from gpio import *
from time import *
from math import *

def handleSensorData():
	value = str(int(ceil(255.0 * analogRead(A0)/1023.0)))
	customWrite(0, value)

def main():
	add_event_detect(A0, handleSensorData) 
	
	while True:
		delay(1000)

if __name__ == "__main__":
	main()

/* Luis Chavez*/
from gpio import *
from time import *
def main():
pinMode(0, IN) # Controlador del sencor de movimiento
pinMode(4, IN) # Controlador del switch
while True:
	if digitalRead(0) == HIGH:
		print("Bienvenido");
		customWrite(2, "1"); #Abriendo la cochera
		digitalWrite(1, HIGH) #Prendemos la luz que avisa que se esta abriendo la cochera
	else:
		digitalWrite(1, LOW) #APAGAMOS la luz que avisa que se esta abriendo la cochera
		customWrite(2, "0"); #Cerrando la cochera
	sleep(1) #Tiempo que demora en estar abierta la cochera
		
	if digitalRead(4) == HIGH: # Consultamos el estado del switch para prende rla lampara
		customWrite(3, "1"); #Prendo la luz
	else:
		customWrite(3, "0"); #Apago la Luz

if __name__ == "__main__":
	main()

