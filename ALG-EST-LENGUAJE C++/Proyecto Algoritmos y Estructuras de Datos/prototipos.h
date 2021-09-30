#include <iostream>
#include <iomanip>
#include<string>
#include<fstream>
#include<windows.h>
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
using namespace std;
const int MAXX = 100;
typedef struct {
    string nombre;
    string apellido;
    string correo;
    float notas[MAXX];
    float total;
    string conducta;
}tEstudiantes;
struct {
    string nombredocente;
    string materia;
    string colegio;
    int numeroest;
    int numerocal;
    float total;
    int aprobados;
    int suspenso;
    int reprobados;
    string cedula;
}docente;
tEstudiantes estudiantes[MAXX];
void guardar();
void guardarordenamiento();
void datos();
void mostrar();
int menugeneral();
int menuordenamiento();
void seleccion(tEstudiantes a[], int tamanio);
void burbuja(tEstudiantes a[], int n);
void inserccion(tEstudiantes a[], int n);
void dividir(tEstudiantes a[], int inicial, int final);
void Fusionar(tEstudiantes a[], int pinicial, int pfinal, int medio);
tEstudiantes mitad(tEstudiantes a[], int pinicial, int pfinal);
void ordenar(tEstudiantes a[], int pinicial, int pfinal);
void HeapSort(tEstudiantes b[], int n);
int menubusqueda();
void encontrado(int i);
void noencontrado();
float cantidadabuscar();
void lineal(tEstudiantes a[], int n, float dato);
void busqueda_binaria(tEstudiantes a[], int n, float dato);
void interpol(tEstudiantes A[], int tamano, float n);
void presentarcalificaciones();
void listado();
void totales();
void promediototal();
void detalles();

