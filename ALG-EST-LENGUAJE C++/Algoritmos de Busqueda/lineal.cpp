#include <iostream>
#include <fstream>
#include "lineal.h"
using namespace std;
ofstream archivo;

void lineal(int a[], int n, int dato)
{
  archivo.open("Lineal.txt",ios::out);

    archivo<<"\nLa calificación a buscar es: "<<dato<<endl;
    int igual = busqueda(a,n,dato);
    if(busqueda(a,n,dato)==-1)
    {
        cout<<"ESTA CALIFICACION NO SE ENCUENTRA DENTRO DEL SISTEMA";
        archivo<<"Calificación no ingresada previamente"<<endl;
    }
    else
    {
        archivo<<"La calificación se encuentra en la posicion: "<<igual;
        cout<<"La calificación fue encontrada en la posición: "<<busqueda(a,n,dato);
    }
    cout<<endl<<"***BUSQUEDA ALMACENADA EN [Lineal.txt]***";
    archivo.close();
}
int busqueda (int a[], int n, int dato)
{
    for (int i=0; i<=n; i++)
    {
        if(a[i]==dato)
        {
            return i+1;
        }
    }
        return -1;
}