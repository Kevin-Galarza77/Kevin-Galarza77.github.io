/*3.4 Realizar un programa para que los alumnos puedan visualizar si fueron aceptados o no, en
las carreras en las que se inscribieron, luego de rendir el examen de admisión.Los alumnos
seleccionarán desde un menú la carrera a la que se inscribieron y a continuación ingresarán la
calificación obtenida en el examen de admisión.Si el alumno es aceptado teniendo en cuenta
las especificaciones que se listan abajo se debe imprimir su calificación, carrera y la palabra
“Aceptado”, caso contrario únicamente la palabra “No aceptado”.
Medicina Calificación >= 8.8
Mecánica Calificación > 8.5
Robótica Calificación >= 8.3
Administración Calificación >= 7.8*/
#include <iostream>
using namespace std;
int main() {
	int opcion;
	float puntajecarrera;
	cout << "****Bienvenido al Sistema de Admision*****" << endl;
	cout << "Selecciona la carrera que elegiste:" << endl;
	cout << "1.-Medicina" << endl;
	cout << "2.-Mecanica" << endl;
	cout << "3.-Robotica" << endl;
	cout << "4.-Administracion" << endl;
	cin >> opcion;
	switch (opcion) {
	case 1:
		cout << "Ingresa tu puntaje: ";
		cin >> puntajecarrera;
		if (puntajecarrera >= 8.8) {
			cout << "Aceptado" << endl;
		}
		else {
			cout << "No aceptado";
		}
		break;
	case 2:
		cout << "Ingresa tu puntaje: ";
		cin >> puntajecarrera;
		if (puntajecarrera >= 8.5) {
			cout << "Aceptado" << endl;
		}
		else {
			cout << "No aceptado";
		}
		break;
	case 3:
		cout << "Ingresa tu puntaje: ";
		cin >> puntajecarrera;
		if (puntajecarrera >= 8.3) {
			cout << "Aceptado" << endl;
		}
		else {
			cout << "No aceptado";
		}
		break;
	case 4:
		cout << "Ingresa tu puntaje: ";
		cin >> puntajecarrera;
		if (puntajecarrera >= 7.8) {
			cout << "Aceptado" << endl;
		}
		else {
			cout << "No aceptado";
		}
		break;
	default:
		cout << "La opcion que seleccionaste es incorrecta";
	}
	return 0;
}