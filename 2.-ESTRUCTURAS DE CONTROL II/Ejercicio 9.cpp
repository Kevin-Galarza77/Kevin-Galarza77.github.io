//3.8 Escriba un programa que calcule la factorial de un número ingresado por el usuario.
#include <iostream>
using namespace std;
int main() {
	int i, numero, factorial, fin=0;
	factorial = 1;
	while (fin != 1) {
		cout << "Ingresa el numero para calcular su factorial: ";
		cin >> numero;
		if (numero == 0) {
			cout << "El factorial es 0";
			fin = 1;
		}
		else {
			if (numero < 0) {
				cout << "ADVERTENCIA:**Ingresa un numero positivo o igual a 0**" << endl;
				fin = 0;
			}
			else {
				for (i = 1; i <= numero; i++) {
					factorial = factorial * i;
				}
				cout << "El fatorial es: " << factorial;
				fin = 1;
			}
		}
	}
	return 0;
}