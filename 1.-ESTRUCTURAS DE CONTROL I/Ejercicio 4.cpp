/*3.7 Desarrollar un programa para calcular la fuerza de atracción entre dos cuerpos, siendo sus
masas y su distancia tecleados por el usuario.Las masas serán introducidas en toneladas, la
distancia en cm., y el resultado se dará en Newtons.Donde G es 6, 67 × 10 11 Nm ^ 2 / kg ^ 2.*/
#include <iostream>
using namespace std;
int main() {
	float masa1, masa2, distancia, NUMEROG, conversion1, conversion2, conversion3, fuerza;
	cout << "Introduzca masa cuerpo 1 (Ton): ";
	cin >> masa1;
	cout << "Introduzca masa cuerpo 2 (Ton): ";
	cin >> masa2;
	cout << "Introduzca la distancia (cm):";
	cin >> distancia;
	NUMEROG = 0.0000000000667;
	conversion1 = masa1 * 1000;
	conversion2 = masa2 * 1000;
	conversion3 = distancia / 100;
	fuerza = (NUMEROG * conversion1 * conversion2) / (conversion3 * conversion3);
	cout << "Fuerza de atracción = " << fuerza << " N. " << endl;
	return 0;
}