/*3.6 Una aplicación interesante de las computadoras es dibujar gráficos convencionales y de
barra.Escriba un programa que lea cinco números(cada uno entre 1 y 30).Suponga que el
usuario sólo introduce valores válidos.Por cada número leído, su programa debe imprimir una
línea que contenga ese número de asteriscos adyacentes.Por ejemplo, si su programa lee el
número 7, debe mostrar lo siguiente :*/
#include<iostream>
using namespace std;
int main() {
	int i, contador, op, nume1;
	op = 0;
	contador = 1;
	while (contador <= 5) {
		cout << contador << ".-Ingrese el numero:";
		cin >> nume1;
		if (nume1 >= 1 && nume1 <= 30) {
			for (i = 1; i <= nume1; i++) {
				cout << "*";
			}contador = contador + 1;
		}
		else {
			cout << "Ingrese un numero entre el 1 y el 30.";
		}
		cout << endl;
	}
	return 0;
}