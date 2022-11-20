#include <iostream>
#include <fstream>
#include "lineal.h"
#include "binaria.h"
#include "interpolacion.h"

using namespace std;

const int TAM = 50;
int a[TAM], n;
double b;

int main()
{
    int op;

    cout << "¿Cual de las calificaciones ingresadas desea buscar? ";
    cin >> b;

    cout << " \t ¿Que metodo de busqueda desea usar?" << endl;
    cout << "\n\t1.- BUSQUEDA LINEAL" << endl;
    cout << "\t 2.- BUSQUEDA BINARIA" << endl;
    cout << "\t 3.- BUSQUEDA POR INTERPOLACION" << endl;
    cout << "OPCION: ";
    cin >> op;
    switch (op)
    {
    case 1:
    {
        lineal(a,TAM,b);
    }
    break;
    case 2:
    {
        busqueda_binaria(a,TAM,b);
    }
    break;
    case 3:
    {
        interpol(a,TAM,b);
        
    }
    break;
    default:
    {
        cout << "Opcion incorrecta.Intentelo de nuevo." << endl;
    }
    }
}