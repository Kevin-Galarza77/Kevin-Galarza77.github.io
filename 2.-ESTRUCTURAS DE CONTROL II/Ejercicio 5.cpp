/*3.5 Un almacén de pedidos por correo vende cinco productos distintos, cuyos precios de venta
son los siguientes : producto 1, $2.98; producto 2, $4.50; producto 3, $9.98; producto 4, $4.49
y producto 5, $6.87.Escriba un programa que lea una serie de pares de números, como se
muestra a continuación :
a) número del producto
b) cantidad vendida
Su programa debe utilizar una instrucción switch para determinar el precio de venta de cada
producto.Debe calcular y mostrar el valor total de venta de todos los productos vendidos.Use
un ciclo controlado por centinela(ej: “Ingrese 0 para finalizar”) para determinar cuándo debe
el programa deja de iterar para mostrar los resultados finales.*/
#include<iostream>
#include<cmath>
using namespace std;
int main() {
	float a;
	int opcionn, cant1, cant2, cant3, cant4, cant5;
	opcionn = 0;
	cant1 = 0;
	cant2 = 0;
	cant3 = 0;
	cant4 = 0;
	cant5 = 0;
	while ((opcionn != 6)) {
		cout << "Bienvenido" << endl;
		cout << "Seleccione el producto (1-5): " << endl;
		cout << "Para salir y presentar los resultados precione 6: ";
		cin >> opcionn;
		switch ((opcionn)) {
		case 1:
			cout << "Seleccionaste el producto 1, con un precio de $2.98 c / u"<<endl;
				cout << "Ingresa la cantidad vendida: ";
			cin >> cant1;
			break;
		case 2:
			cout << "Seleccionaste el producto 2, con un precio de $4.50 c / u"<<endl;
				cout << "Ingresa la cantidad vendida: ";
			cin >> cant2;
			break;
		case 3:
			cout << "Seleccionaste el producto 3, con un precio de $9.98 c / u"<<endl;
				cout << "Ingresa la cantidad vendida: ";
			cin >> cant3;
			break;
		case 4:
			cout << "Seleccionaste el producto 4, con un precio de $4.49 c / u"<<endl;
				cout << "Ingresa la cantidad vendida: ";
			cin >> cant4;
			break;
		case 5:
			cout << "Seleccionaste el producto 5, con un precio de $6.87 c / u"<<endl;
				cout << "Ingresa la cantidad vendida: ";
			cin >> cant5;
			break;
		case 6:
			cout << "--------------------------------------------------" << endl;
			cout << "El total de productos son :"<<cant1+cant2+cant3+cant4+cant5<<endl;
				cout << "Por un total a pagar de:"<<(cant1*2.98)+(cant2*4.5)+(cant3*9.98)+(cant4*4.49)+(cant5*6.87)<<"dolares."<<endl;
				cout << "*****Gracias por visitarnos***** " << endl;
		default:
			cout << "Opcion no valida. Vuevla a intentarlo: " << endl;
		}
	}
	return 0;
}