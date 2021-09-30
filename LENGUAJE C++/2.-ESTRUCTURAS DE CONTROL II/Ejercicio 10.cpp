//3.9 Escriba un programa para encontrar los números y la suma de todos los enteros entre 100
//y 200 que sean divisibles para 9.
#include <iostream>
using namespace std;
int main() {
	int a, b, c;
	b = 200;
	c = 0;
	for (a = 100; a <= b; a++) {
		if (a % 9 == 0) {
			cout << a << " es divisible para 9" << endl;
			c = c + a;
		}
	}
	cout << "La sumatoria total de los numeros divisibles para 9 entre el 100 y 200 es: "<<c;
		return 0;
}