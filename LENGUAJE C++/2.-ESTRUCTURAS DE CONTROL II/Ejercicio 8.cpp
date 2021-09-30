//3.8 Escriba un programa que calcule la factorial de un número ingresado por el usuario.
#include <iostream>
using namespace std;
int main() {
	int i, numero, factorial;
	factorial = 1;
	cout << "Ingresa el numero para calcular su factorial: ";
	cin >> numero;
	for (i = 1; i <= numero; i++) {
		factorial = factorial * i;
	}
	cout << "El fatorial es: " << factorial;
}