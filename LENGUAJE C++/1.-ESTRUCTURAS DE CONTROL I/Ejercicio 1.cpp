/*3.2 Escribe un programa que muestre en la pantalla la tabla de multiplicación(de 1 a 10) del
número que introduzca el usuario(entre 1 y 100); Presentar la salida con un formato elegante.*/
#include <iostream>
using namespace std;
int main() {
	int numero, a, b, c, d, e, f, g, h, i, j;
	cout << "Por favor ingrese un numero:";
	cin >> numero;
	a = numero * 1;
	b = numero * 2;
	c = numero * 3;
	d = numero * 4;
	e = numero * 5;
	f = numero * 6;
	g = numero * 7;
	h = numero * 8;
	i = numero * 9;
	j = numero * 10;
	if (numero >= 1 & numero <= 100) {
		cout << "El numero seleccionado es el " << numero << endl;
		cout << "1*" << numero << "=" << a << endl;
		cout << "2*" << numero << "=" << b << endl;
		cout << "3*" << numero << "=" << c << endl;
		cout << "4*" << numero << "=" << d << endl;
		cout << "5*" << numero << "=" << e << endl;
		cout << "6*" << numero << "=" << f << endl;
		cout << "7*" << numero << "=" << g << endl;
		cout << "8*" << numero << "=" << h << endl;
		cout << "9*" << numero << "=" << i << endl;
		cout << "10*" << numero << "=" << j << endl;
	}
	else {
			cout << "Por favor introduzca un numero del 1 al 100.";
	}
}