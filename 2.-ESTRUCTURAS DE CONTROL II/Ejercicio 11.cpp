/*3.10 Escriba un programa que presente un menú para realizar las operaciones de una
calculadora, utilizando como plantilla el código de un menú con funciones que se encuentra en
el aula virtual.*/
#include<iostream>
#include<cmath>
using namespace std;
int main() {
	float a;
	int opcionn, primernu, segundonu;
	opcionn = 0;
	while ((opcionn != 5)) {
		cout << "Bienvenido" << endl;
		cout << "Que deseas hacer:" << endl;
		cout << "1.Sumar dos numeros" << endl;
		cout << "2.Restar dos numeros" << endl;
		cout << "3.Multiplicar dos numeros" << endl;
		cout << "4.Dividir dos numeros" << endl;
		cout << "5.Salir" << endl;
		cout << "Ingresa lo que deseas hacer: ";
		cin >> opcionn;
		system("cls");
		switch ((opcionn)) {
		case 1:
			cout << "Ingrese el primer numero: " << endl;
			cin >> primernu;
			cout << "Ingrese el segundo numero:" << endl;
			cin >> segundonu;
			a = primernu + segundonu;
			cout << "La respuesta de su suma es: " << a << endl;
			cout << endl;
			break;
		case 2:
			cout << "Ingrese el primer numero:" << endl;
			cin >> primernu;
			cout << "Ingrese el segundo numero:" << endl;
			cin >> segundonu;
			cout << "La respuesta de su resta es: " << primernu - segundonu <<
				endl;
			cout << endl;
			break;
		case 3:
			cout << "Ingrese el primer numero:" << endl;
			cin >> primernu;
			cout << "Ingrese el segundo numero:" << endl;
			cin >> segundonu;
			cout << "La respuesta de su multiplicacion es: " << primernu * segundonu
				<< endl;
			cout << endl;
			break;
		case 4:
			cout << "Ingrese el primer numero:" << endl;
			cin >> primernu;
			cout << "Ingrese el segundo numero:" << endl;
			cin >> segundonu;
			cout << "La respuesta de su division es: " << primernu / segundonu <<
				endl;
			cout << endl;
			break;
		case 5:
			cout << "*****Gracias por usar nuestros servicios*****" << endl;
			opcionn = 5;
			break;
		default:
			cout << "Opcion no valida" << endl;
		}
	}
	return 0;
}
