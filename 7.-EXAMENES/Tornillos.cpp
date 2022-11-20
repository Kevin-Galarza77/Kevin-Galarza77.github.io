#include <iostream>
using namespace std;
typedef struct {
	float longitud;
	float diametro;
}tTornillos;
const int TAMANIO_MUESTRA = 5;
void datos(tTornillos tornillo[]);
void calculos(tTornillos tornillos[]);


void datos(tTornillos tornillos[]) {
	for (int i = 0; i < TAMANIO_MUESTRA; i++) {
		cout << endl << endl << endl;
		cout << "\t ------------------" << endl;
		cout << "\t :   BIENVENIDO   :" << endl;
		cout << "\t ------------------" << endl << endl;
		cout << "INGRESA LA LONGITUD DEL " << i + 1 << " TORNILLO: ";
		cin >> tornillos[i].longitud;
		cout << "INGRESE EL DIAMETRO DEL " << i + 1 << " TORNILLO: ";
		cin >> tornillos[i].diametro;
		system("cls");
	}
}
void calculos(tTornillos tornillos[]) {
	float logitudprom = 0;
	float diametroprom = 0;
	for (int i = 0; i < TAMANIO_MUESTRA; i++) {
		logitudprom += tornillos[i].longitud;
		diametroprom += tornillos[i].diametro;
	}
	system("cls");
	cout << endl << endl << endl;
	cout << " ------------------" << endl;
	cout << " :   RESULTADOS   :" << endl;
	cout << " ------------------" << endl;
	cout << "LA LONGITUD MEDIA DE TODOS LOS TORNILLOS ES: " << logitudprom / TAMANIO_MUESTRA << endl;
	cout << "EL MEDIA DEL DIAMETRO DE TODOS LOS TORNILLOS ES: " << diametroprom / TAMANIO_MUESTRA << endl;
}
int main() {
	tTornillos tornillos[TAMANIO_MUESTRA];
	datos(tornillos);
	calculos(tornillos);
	return 0;
}
