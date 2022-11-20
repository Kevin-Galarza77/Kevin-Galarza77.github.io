/*3.1 Desarrolla un conversor de medidas anglosajonas a internacionales.El programa leerá un
número real seguido de un espacio y una letra.La letra indicará la medida que se quiere
convertir(p pulgadas; m  millas; f  grados Fahrenheit; g  galones líquidos; o
	onzas; l libras).Mostrará la cantidad en la nueva unidad seguida de un espacio y otras
	letras representando la nueva unidad(respectivamente, cm  centímetros; m  metros; c
		 grados Celsius; l litros; gr  gramos; kg  kilogramos).Definir los factores de
	conversión como constantes.*/
#include <iostream>
using namespace std;
int main() {
	float numero, conversor1, conversor2, conversor3, conversor4, conversor5, conversor6;
	string convertidor;
	cout << "Selecione una letra para elegir la conversion : p - pulgadas; m - millas; f - grados Fahrenheit; g - galones líquidos; o - onzas; l - libras; seguido de un espacio y luego la cantidad a convertir." << endl;
	cin >> convertidor >> numero;
	conversor1 = numero * 2.54;
	conversor2 = numero * 1609.34;
	conversor3 = numero * (-17.22);
	conversor4 = numero * 3.78541;
	conversor5 = numero * 28.3495;
	conversor6 = numero / 2.20462;
	if (convertidor == "p" || convertidor == "P") {
		cout << numero << " pulgadas es " << conversor1 << endl;
	}
	else {
		if (convertidor == "m" || convertidor == "M") {
			cout << numero << " millas es " << conversor2 << " metros." << endl;
		}
		else {
			if (convertidor == "f" || convertidor == "F") {
				cout << numero << " grados Fahrenheit es " << conversor3 << " grados Celsius." << endl;
			}
			else {
				if (convertidor == "g" || convertidor == "G") {
					cout << numero << " galones liquidos es " << conversor4 << "litros." << endl;
				}
				else {
					if (convertidor == "o" || convertidor == "O") {
						cout << numero << " onzas es " << conversor5 << " gramos." << endl;
					}
					else {
						if (convertidor == "l" || convertidor == "L") {
							cout << numero << " libras es " << conversor6 << "kilogramos." << endl;
						}
						else {
							cout << "Opcion no disponible.";
						}
					}
				}

			}

		}

	}
	return 0;
}