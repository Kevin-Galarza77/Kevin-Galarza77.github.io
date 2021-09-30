/*3.8 Escribir un programa que permita convertir dólares en euros y viceversa.El usuario elegirá
la opción : 1. dólares  euros, 2. euros  dólares, 3. Salir.En pantalla se presentará lo
siguiente :*/
#include <iostream>
using namespace std;
int main() {
	float dolares, euros, operacion1, operacion2;
	int conversion;
	cout << "Bienvenido al convertidor de divisas." << endl;
	cout << "1.-De dólares a euros." << endl;
	cout << "2.-De euros a dólares." << endl;
	cout << "3.-Salir." << endl;
	cout << "Seleccione la conversion: ";
	cin >> conversion;
	switch (conversion) {
	case 1:
		cout << "Ingrese la cantidad de dolares a convertir: ";
		cin >> dolares;
		operacion1 = dolares * 0.8423;
		cout << dolares << " dólares son " << operacion1 << " euros." << endl;
		cout << "****Gracias por usar nuestros servicios*****";
		break;
	case 2:
		cout << "Ingrese la cantidad de euros a convertir: ";
		cin >> euros;
		operacion2 = euros * 1.1872;
		cout << euros << " euros son " << operacion2 << " dolares." << endl;
		cout << "****Gracias por usar nuestros servicios*****";
		break;
	case 3:
		cout << "****Gracias por usar nuestros servicios*****";
		break;
	default:
		cout << "La opcion que seleccionaste no es correcta.";
	}
	return 0;
}