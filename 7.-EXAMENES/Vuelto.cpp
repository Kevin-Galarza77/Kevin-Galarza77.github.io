#include <iostream>
#include <iomanip>
using namespace std;

void DevolverCambio(double precio_prod, double dinero_pag);

int main()
{
	double precio_producto, pago_producto;
	cout << endl << "__________________________________________________________" << endl << endl;
	cout << setw(51) << "M A Q U I N A   E X P E N D E D O R A" << endl;
	cout << endl << "__________________________________________________________" << endl;
  do{
	do {
		cout << endl << "PRECIO DEL PRODUCTO QUE VA A COMPRAR: ";
		cin >> precio_producto;
	} while (precio_producto < 0);
	do {
		cout << "DINERO QUE HA PAGADO POR EL PRODUCTO: ";
		cin >> pago_producto;
	} while (pago_producto < 0);
  if(pago_producto<precio_producto){
    cout<<"DINERO INCOMPLETO. INTENTA DENUEVO."<<endl;
  }
  }while(pago_producto<precio_producto);
	if (precio_producto == pago_producto) {
		cout << endl << "No tiene cambio, su valor es exacto..." << endl;
	}
	else {
		cout << endl << "Su cambio es..." << endl;
		DevolverCambio(precio_producto, pago_producto);
	}
	return 0;
}

void DevolverCambio(double precio_prod, double dinero_pag) {
	double valor = dinero_pag - precio_prod;
	double centavos, div;
	int dolar, division;
	dolar = int(valor);
	cout << "Monedas de 1 dolar = " << dolar << endl;
	centavos = (valor - dolar) * 100;
	division = centavos / 50;
	if (division != 0) {
		cout << "Monedas de 50 centavos = " << division << endl;
		centavos -= 50;
	}
	else {
		cout << "Monedas de 50 centavos = 0" << endl;
	}
	division = centavos / 25;
	if (division != 0) {
		cout << "Monedas de 25 centavos = " << division << endl;
		centavos -= 25;
	}
	else {
		cout << "Monedas de 25 centavos = 0" << endl;
	}
	div = centavos / 10;
	if (div != 0) {
		cout << "Monedas de 10 centavos = " << int(div) << endl;
		centavos -= int(div) * 10;
	}
	else {
		cout << "Monedas de 10 centavos = 0" << endl;
	}
	division = centavos / 5;
	if (division != 0) {
		cout << "Monedas de 5 centavos = " << division << endl;
		centavos -= 5;
	}
	else {
		cout << "Monedas de 5 centavos = 0" << endl;
	}
	division = centavos / 1;
	if (division != 0) {
		cout << "Monedas de 1 centavo = " << centavos << endl;
	}
	else {
		cout << "Monedas de 1 centavo = 0" << endl;
	}
}
