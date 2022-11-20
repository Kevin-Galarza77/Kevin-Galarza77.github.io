/*3.7 Escriba un programa que pida al usuario que introduzca el tamaño del lado de un cuadrado
y que muestre un cuadrado hueco de ese tamaño, compuesto de asteriscos y espacios en
blanco.Su programa debe funcionar con cuadrados que tengan lados de todas las longitudes
entre 1 y 20. Por ejemplo, si su programa lee un tamaño de 5, debe imprimir :*/
#include<iostream>
using namespace std;
int main() {
	int lado;
	cout << "Ingresa el tamaño del cuadrado: ";
	cin >> lado;
	for (int i = 0; i < lado; i++) {
		for (int j = 0; j < lado; j++) {
			if (i == 0 || j == 0 || i == lado - 1 || j == lado - 1) {
				cout << "*";
			}
			else {
				cout << " ";
			}
		}
		cout << endl;
	}
	return 0;
}