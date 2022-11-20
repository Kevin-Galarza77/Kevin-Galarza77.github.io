/*3.3 Hacer un programa para una tienda de ropa que tiene una promoción de descuento para
vender al mayor, esta dependerá del número de prendas que se compren.Se ponen a
disposición de la promoción tres prendas : vestidos($ 80 c / u), zapatos($ 50 c / u) y carteras($
	40 c / u).Si son más de diez, se les dará un 10 % de descuento sobre el total de la compra; si el
	número de prendas es mayor de veinte, pero menor de treinta, se le otorga un 20 % de
	descuento; y si son más treinta prendas se otorgará un 40 % de descuento.Indicar el resumen
	de la compra y el total a pagar.*/
#include <iostream>
	using namespace std;
int main() {
	int zapatos, vestidos, carteras, articulos;
	float total;
	cout << "**Bienvenido**" << endl;
	cout << "Ingrese la cantidad de vestidos que desea comprar: " << endl;
	cin >> vestidos;
	cout << "Ingrese la cantidad de pares de zapatos que desea comprar: " << endl;
	cin >> zapatos;
	cout << "Ingrese la cantidad de carteras que desea comprar: " << endl;
	cin >> carteras;
	articulos = vestidos + zapatos + carteras;
	total = (vestidos * 80) + (zapatos * 50) + (carteras * 40);
	if (articulos >= 10 && articulos <= 20) {
		cout << "El numero total de articulos es: " << articulos << endl;
		cout << "Por un valor a pagar de: " << total << " dolares." << endl;
		cout << "Total a pagar con descuento del 10%: " << total * 0.90 << " dolares."<<endl;
			cout << "*****Gracias por visitarnos*****";
	}
	else {
		if (articulos > 20 && articulos < 30) {
			cout << "El numero total de articulos es: " << articulos << endl;
			cout << "Por un valor a pagar de: " << total << " dolares." << endl;
			cout << "Total a pagar con descuento del 20%: " << total * 0.80 << " dolares."<<endl;
				cout << "*****Gracias por visitarnos*****";
		}
		else {
			if (articulos > 30) {
				cout << "El numero total de articulos es: " << articulos << endl;
				cout << "Por un valor a pagar de: " << total << " dolares." << endl;
				cout << "Total a pagar con descuento del 40%: " << total * 0.60 << " dolares."<<endl;
					cout << "*****Gracias por visitarnos*****";
			}
			else {
				cout << "El numero total de articulos es: " << articulos << endl;
				cout << "Por un valor a pagar de: " << total << " dolares." << endl;
				cout << "*****Gracias por visitarnos*****";
			}
		}
	}
	return 0;
}