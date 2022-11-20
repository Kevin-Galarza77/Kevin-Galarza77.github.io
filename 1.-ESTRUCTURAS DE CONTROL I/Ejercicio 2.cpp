/*3.3.Escribe un programa que lea un operando(real), un operador(carácter) y otro operando
(real), todo en una misma línea, y muestre el resultado de la operación correspondiente
(operadores contemplados : +, ‐, * y / ).*/
#include <iostream>
using namespace std;
int main() {
	float operando1, operando2, operacion1, operacion2, operacion3, operacion4;
	string operador;
	cout << "Introduzca el primer operando" << endl;
	cin >> operando1;
	cout << "Introduzca el operador (+,-,*,/)" << endl;
	cin >> operador;
	cout << "Introduzca el segundo operando" << endl;
	cin >> operando2;
	operacion1 = operando1 + operando2;
	operacion2 = operando1 - operando2;
	operacion3 = operando1 * operando2;
	operacion4 = operando1 / operando2;
	if (operador == "+") {
		cout << "Operando Operador Operando: " << operando1 << " " <<
			operador << " " << operando2 << endl;
		cout << operando1 << " " << operador << " " << operando2 << " = " <<
			operacion1 << endl;
	}
	else {
		if (operador == "-") {
			cout << "Operando Operador Operando: " << operando1 << " " <<
				operador << " " << operando2 << endl;
			cout << operando1 << " " << operador << " " << operando2 << " = "
				<< operacion2 << endl;
		}
		else {
			if (operador == "*") {
				cout << "Operando Operador Operando: " << operando1 << " " <<
					operador << " " << operando2 << endl;
				cout << operando1 << " " << operador << " " << operando2 << " = "
					<< operacion3 << endl;
			}
			else {
				if (operador == "/") {
					cout << "Operando Operador Operando: " << operando1 << " " <<
						operador << " " << operando2 << endl;
					cout << operando1 << " " << operador << " " << operando2 << " = " << operacion4 << endl;
				}
				else {
					cout << "La opción que seleccionaste, no es válida" << endl;
				}
			}
		}
	}
	return 0;
}