/*3.5 Escriba un programa que introduzca tres diferentes enteros desde el teclado, después que
imprima la suma, el promedio, el producto, el número más pequeño y el más grande de éstos.
El diálogo en la pantalla debe aparecer de la siguiente forma :*/
#include <iostream>
using namespace std;
int main() {
	int entero1, entero2, entero3, suma, producto, pequenio, grande;
	float promedio;
	cout << "Escriba el primer numero entero." << endl;
	cin >> entero1;
	cout << "Escriba el segundo numero entero." << endl;
	cin >> entero2;
	cout << "Escriba el tercer numero entero." << endl;
	cin >> entero3;
	suma = entero1 + entero2 + entero3;
	promedio = suma / 3;
	producto = entero1 * entero2 * entero3;
	cout << "Los numeros seleccionados son: " << entero1 << " " << entero2 << " "<<entero3<<endl;
		cout << "Su suma es--->" << suma << endl;
	cout << "Su promedio es---->" << promedio << endl;
	cout << "Su producto es---->" << producto << endl;
	if (entero2 < entero1 && entero2 < entero3) {
		cout << "El número mas pequeño es--->" << entero2 << endl;
	}
	else {
		if (entero3 < entero1 && entero3 < entero2) {
			cout << "El número mas pequeño es--->" << entero3 << endl;
		}
		else {
			if (entero1 < entero2 && entero1 < entero3) {
				cout << "El número mas pequeño es--->" << entero1 << endl;
			}
			else {
				cout << "Los numeros son iguales";
			}
		}
	}
	if (entero2 > entero1 && entero2 > entero3) {
		cout << "El número mas grande es--->" << entero2 << endl;
	}
	else {
		if (entero3 > entero1 && entero3 > entero2) {
			cout << "El número mas grande es--->" << entero3 << endl;
		}
		else {
			if (entero1 > entero2 && entero1 > entero3) {
				cout << "El número mas grande es--->" << entero1 << endl;
			}
			else {
				cout << "Los numeros son iguales";
			}
		}
		return 0;
	}
}