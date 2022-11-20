/*3.1 Escribe un programa en C++ que pida al usuario tres valores enteros y los muestre de
menor a mayor separados por comas.Por ejemplo, si el usuario introduce 10, 4 y 6, el
resultado será : 4, 6, 10.*/
#include <iostream>
using namespace std;
int main() {
	int a, b, c;
	cout << "Ingrese 3 numeros enteros: ";
	cin >> a >> b >> c;
	if (a < b && a < c) {
		if (b < c) {
			cout << a << "," << b << "," << c;
		}
		else {
			cout << a << "," << c << "," << b;
		}
	}
	else {
		if (b < a && b < c) {
			if (a < c) {
				cout << b << "," << a << "," << c;
			}
			else {
				cout << b << "," << c << "," << a;
			}
		}
		else {
			if (c < a && c < b) {
				if (a < b) {
					cout << c << "," << a << "," << b;
				}
				else {
					cout << c << "," << b << "," << a;
				}
			}
		}
		return 0;
	}
}