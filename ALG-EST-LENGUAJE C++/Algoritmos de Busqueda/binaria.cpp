#include <iostream>
#include <fstream>
#include "binaria.h"
using namespace std;

void busqueda_binaria(int a[], int n, int dato)
{
    ofstream archivo1;
    archivo1.open("BDD/BINARIO.txt", ios::out);
    
    archivo1 << "\nLa calificacion a buscar es: " << dato;
    archivo1 << endl;
    int k, i, j;
    i = 0;
    j = n - 1;
    do
    {
        k = (i + j) / 2;
        if (a[k] <= dato)
        {
            i = k + 1;
        }
        if (a[k] >= dato)
        {
            j = k - 1;
        }

    } while (i <= j);
    if (a[k] == dato)
    {
        cout << "Calificacion encontrada en la posicion " << k + 1 << endl;
        archivo1 << "La calificación fue encontrada en la posicion : " << k + 1 << endl;
    }
    else
    {
        cout << "La calificación no se encuentra en el sistema" << endl;
        archivo1 << "Calificacipon no ingresada previamente" << endl;
    }

    archivo1.close();
}