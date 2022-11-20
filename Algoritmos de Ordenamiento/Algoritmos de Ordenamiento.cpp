#include<iostream>
#include <ctime>
using namespace std;
int menubusqueda();
void mostrar(float a[], int tamanio);
void seleccion(float a[], int tamanio);
void dividir(float a[], int inicial, int final);
void Fusionar(float a[], int pinicial, int pfinal, int medio);
float mitad(float a[], int pinicial, int pfinal);
void ordenar(float a[], int pinicial, int pfinal);
void inserccion(float a[], int n);
void burbuja(float a[], int n);



int main() {
	int op, n;
	cout << "INGRESA EL TAMA�O DEL ARREGLO: " << endl;
	cin >> n;
	float arreglo[n];
	srand(time(0));
	for (int i = 0; i < n; i++)
	{
		arreglo[i] = 1.89 + rand() % (20 - 1);
	}
	cout << "SIN ORDEN" << endl;
	mostrar(arreglo, n);
	op = menubusqueda();
	cout << "EN ORDEN" << endl;
	switch (op) {
	case 1:
	{
		burbuja(arreglo, n);
		mostrar(arreglo, n);
		break;
	}
	case 2:
	{
		seleccion(arreglo, n);
		mostrar(arreglo, n);
		break;
	}
	case 3:
	{
		inserccion(arreglo, n);
		mostrar(arreglo, n);
		break;
	}
	case 4:
	{
		dividir(arreglo, 0, n - 1);
		mostrar(arreglo, n);
		break;
	}
	case 5:
	{
		ordenar(arreglo, 0, n - 1);
		mostrar(arreglo, n);
		break;
	}
	case 0:
	{
		cout << "GRACIAS" << endl;
		break;
	}
	}
}
int menubusqueda() {
	int op;
	cout << "SELECIONA EL ALGORITMOS DE ORDENAMIENTO" << endl;
	do {
		cout << "1.-BURBUJA" << endl;
		cout << "2.-SELECCION" << endl;
		cout << "3.-INSERCION" << endl;
		cout << "4.-MERGESORT" << endl;
		cout << "5.-QUICKSORT" << endl;
		cout << "0.-SALIR" << endl;
		cin >> op;
	} while (op == 0);
	return op;
}
void seleccion(float a[], int tamanio) {
	int i, j, minn;
	float  aux;
	for (i = 0; i < tamanio; i++)
	{
		minn = i;
		for (j = i + 1; j < 5; j++)
		{
			if (a[j] < a[minn])
			{
				minn = j;
			}
		}
		aux = a[i];
		a[i] = a[minn];
		a[minn] = aux;
	}
}
void dividir(float a[], int inicial, int final)
{
	int mitad;
	if (inicial < final)
	{
		mitad = (inicial + final) / 2;

		dividir(a, inicial, mitad);
		dividir(a, mitad + 1, final);
		Fusionar(a, inicial, final, mitad);
	}
}

void Fusionar(float a[], int pinicial, int pfinal, int medio)
{
	int i, j, k;
	float temp[pfinal - pinicial + 1];
	i = pinicial;
	k = 0;
	j = medio + 1;

	while (i <= medio && j <= pfinal)
	{
		if (a[i] < a[j])
		{
			temp[k] = a[i];
			k++;
			i++;
		}
		else
		{
			temp[k] = a[j];
			k++;
			j++;
		}
	}

	while (i <= medio)
	{
		temp[k] = a[i];
		k++;
		i++;
	}

	while (j <= pfinal)
	{
		temp[k] = a[j];
		k++;
		j++;
	}

	for (i = pinicial; i <= pfinal; i++)
	{
		a[i] = temp[i - pinicial];
	}
}
void mostrar(float a[], int tamanio) {
	for (int i = 0; i < tamanio; i++) {
		cout << "[" << a[i] << "]";
	}
	cout << endl;
}
float mitad(float a[], int pinicial, int pfinal)
{
	return a[(pinicial + pfinal) / 2];
}
void ordenar(float a[], int pinicial, int pfinal)
{

	int i = pinicial;
	int j = pfinal;
	float temp;
	float piv = mitad(a, pinicial, pfinal);

	do
	{
		while (a[i] < piv)
		{
			i++;
		}
		while (a[j] > piv)
		{
			j--;
		}
		if (i <= j)
		{
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	} while (i <= j);
	if (pinicial < j)
	{
		ordenar(a, pinicial, j);
	}
	if (i < pfinal)
	{
		ordenar(a, i, pfinal);
	}
}
void inserccion(float a[], int num) {
	float aux;
	int aux2;
	for (int i = 0; i < num; i++) {
		aux = a[i];
		aux2 = i;

		while (aux2 > 0) {
			if (a[aux2 - 1] > aux) {
				a[aux2] = a[aux2 - 1];
				a[aux2 - 1] = aux;
			}
			aux2--;
		}

	}
}
void burbuja(float a[], int n)
{
	int i, j;
	float aux;
	for (i = 0; i < n; i++)
	{
		for (j = i + 1; j < n; j++)
		{
			if (a[j] < a[i])
			{
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
			}

		}
	}
}


