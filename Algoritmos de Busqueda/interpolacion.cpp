#include <iostream>
#include<fstream>
#include "interpolacion.h"
using namespace std;

ofstream archivo2;
void interpol(int A[],int tamano,int n){
  
  archivo2.open("BBD/interpolacion.txt",ios::out);
  archivo2<<endl<<"La calificación a buscar es: "<<n<<endl;
    int primero=0;
    int ultimo=tamano-1;
    int medio;
    
    int contador=0;
    while(A[primero]!=n && contador<tamano)
    {   
      
    medio = primero + ((n-A[primero])*(ultimo-primero))/(A[ultimo]-A[primero]);
    
    if(A[medio]<n)
          primero = medio+1; 
          
    else if(A[medio]>n)
    
          ultimo = medio-1;
    else
          primero = medio;
      
      contador++ ; 
      break;
    }
    
    if(A[primero]==n)
    {
        cout<<"La calificación se encuentra en la posicion: "<< primero+1 << endl;
        archivo2 <<"Calificación encontrada en la posición"<< primero+1 << endl;
    }
    else
    {
        cout<<"La calificación no se encuentra en el sistema";
        archivo2<<"Calificación no ingresada previamente";
    }
    archivo2.close();
}