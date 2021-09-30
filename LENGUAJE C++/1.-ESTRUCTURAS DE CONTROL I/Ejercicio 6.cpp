/*3.10 Escriba un programa que lea tres valores double distintos de cero, y que determine e
imprima si podrían representar los lados de un triángulo.*/
#include <iostream>
using namespace std;
int main() {
	double lado1, lado2, lado3;
	cout << "Ingresa el largo del lado 1: ";
	cin >> lado1;
	cout << "Ingresa el largo del lado 2: ";
	cin >> lado2;
	cout << "Ingresa el largo del lado 3: ";
	cin >> lado3;
	cout << endl;
	if (lado1 + lado2 < lado3 || lado1 + lado3 < lado2 || lado2 + lado3 < lado1) {
		cout << "Con los datos numericos ingresados no se puede formar un triangulo." << endl;
	}
	else {
		if (lado1 == lado2 && lado2 == lado3) {
			cout << "Si se puede formar un triangulo y los tres lados corresponden a un TRIANGULO EQUILATERO" << endl;
		}
		else {
			if (lado1 == lado2 && lado1 == lado3) {
				cout << "Si se puede formar un triangulo y los tres lados corresponden a un TRIANGULO ISOCELES" << endl;
			}
			else {
				cout << "Si se puede formar un triangulo y los tres lados corresponden a un TRIANGULO ESCALENO" << endl;
			}
		}
	}
	return 0;
}