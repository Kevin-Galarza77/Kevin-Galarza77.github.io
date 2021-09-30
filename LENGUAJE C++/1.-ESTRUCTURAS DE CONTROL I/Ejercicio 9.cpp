/*3.4 Escribe un programa en C++ que empiece solicitando dos números, uno que represente el
precio de un producto y otro que represente las unidades del producto que se adquieren, un
carácter que indique si se tiene derecho a descuento del 15 % antes del I.V.A. (S / N), una cadena
que será el nombre completo(varias palabras) del cliente, otra cadena con la cédula del
cliente, otra más con la dirección(varias palabras) y una última con el nombre del producto.A
continuación, el programa generará en la pantalla una factura de la compra realizada : nombre
del cliente, dirección y cédula, nombre del producto, unidades adquiridas, precio unitario, total
(unidades por precio), descuento aplicado, total tras descuento, tanto por ciento de I.V.A.
aplicado(12 %), cantidad de I.V.A.y precio final(añadiendo el I.V.A.al total).Cada dato irá en
una línea, precedido de su nombre, y ocupará exactamente 10 espacios, estará ajustado a la
derecha y mostrará 2 decimales.Ejemplo de ejecución del programa :*/
#include <iostream>
using namespace std;
int main()
{
	float precio, unidades, descuento, total, totaldescuento, iva, pagar, pagar2;
	char nombre[50];
	char direccion[100];
	char producto[50];
	char cedula[50];
	cout << "Por favor introdusca su nombre: ";
	cin.getline(nombre, 50, '\n');
	cout << "Por favor introduzca su direccion: ";
	cin.getline(direccion, 100, '\n');
	cout << "Por favor introduzca su numero de cedula: ";
	cin.getline(cedula, 50, '\n');
	cout << "Ingrese el nombre del producto:";
	cin.getline(producto, 50, '\n');
	cout << "Ingrese el precio del producto: ";
	cin >> precio;
	cout << "**PROMOCIÓN** Por la compra de 15 o mas unidades del mismo prodructo, recibiras un descuento del 15 % ." << endl;
	cout << "¿Cuantas unidades?: ";
	cin >> unidades;
	total = precio * unidades;
	descuento = total * -0.15;
	totaldescuento = total + descuento;
	iva = total * 0.12;
	pagar = totaldescuento + iva;
	pagar2 = total + iva;
	cout << "**********FACTURA**********" << endl;
	cout << "\t\t\t\t\t\t\t\t\t" << nombre << endl;
	cout << "\t\t\t\t\t\t\t\t\t" << direccion << endl;
	cout << "\t\t\t\t\t\t\t\t\t" << cedula << endl;
	cout << "Producto: " << producto << endl;
	cout << "Precio unitario\t\t\t\t\t\t" << "$" << precio << endl;
	cout << "Unidades \t\t\t\t\t\t" << unidades << endl;
	cout << "Total \t\t\t\t\t\t" << "$" << total << endl;
	if (unidades >= 15) {
		cout << "Descuento \t\t\t\t\t\t" << "$" << descuento << endl;
		cout << "Total tras descuento\t\t\t\t" << "$" << totaldescuento << endl;
		cout << "I.V.A. \t\t\t\t\t" << "$" << iva << endl;
		cout << "Precio final \t\t\t\t\t" << "$" << pagar << endl;
		cout << "**********Gracias por visitarnos*********";
	}
	else {
		cout << "Descuento \t\t\t\t\t\t" << 0 << endl;
		cout << "Total tras descuento\t\t\t\t" << "$" << total << endl;
		cout << "I.V.A. \t\t\t\t\t" << "$" << iva << endl;
		cout << "Precio final \t\t\t\t\t" << "$" << pagar2 << endl;
		cout << "**********Gracias por visitarnos*********";
	}
	return 0;
}