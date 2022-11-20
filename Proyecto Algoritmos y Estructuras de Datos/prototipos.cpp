#include <iostream>
#include <iomanip>
#include<string>
#include<fstream>
#include "prototipos.h"

#define color SetConsoleTextAttribute

using namespace std;
void guardarordenamiento() {
    ofstream  archivo;
    archivo.open("BBDCalificaciones/ordenamiento.txt", ios::out);
    archivo << "\t\t\t\t\t   COLEGIO " << docente.colegio << endl;
    archivo << "\t\t\t\t       REPORTE DE CALIFICACIONES" << endl << endl << endl;
    archivo << "\t\tCALIFICACIONES ORDENADAS:" << endl;
    archivo << endl << "\t\t\t\tNº-";
    for (int i = 0; i < docente.numeroest; i++) {
        archivo << "[" << estudiantes[i].total << "]-";
    }
    archivo << endl << endl << endl;
    archivo << "\t\t\t\t_______________________________________" << endl;
    archivo << "\t\t\t\t\t      Docente" << endl;
    archivo << "\t\t\t\t\t" << docente.nombredocente << endl;
    archivo << "\t\t\t\t\t  " << docente.cedula << endl << endl << endl << endl;
    archivo.close();
}
void listado() {
    cout << endl << endl << endl << endl;
    color(hConsole, 14);
    cout <<"\t\t\t\t\t\t"<< setw(5) << left << "#" << setw(25) << left << "ESTUDIANTE" << setw(30) << left << "CORREO ELECTRONICO";
    for (int i = 0; i < docente.numerocal; i++) {
        cout << setw(10) << right << "NOTA " << i + 1;
    }
    cout << setw(10) << right << "TOTAL" << setw(15) << right << "CONDUCTA";
    cout << endl;
    color(hConsole, 8);
    for (int i = 0; i < docente.numeroest; i++) {
        cout <<"\t\t\t\t\t\t"<< setw(5) << left << i + 1 << setw(25) << left << estudiantes[i].nombre << setw(30) << left << estudiantes[i].correo;
        for (int j = 0; j < docente.numerocal; j++) {
            cout << setw(10) << right << estudiantes[i].notas[j];
        }
        cout << setw(11) << right << estudiantes[i].total << setw(12) << right << estudiantes[i].conducta;
        cout << endl;
    }
    cout << endl << endl << endl << endl << endl;
    color(hConsole, 7);
}
void modificar() {
    int op, estud;
    system("cls");
    listado();
    cout << "\t\t\t\t\tIngresa la posicion del estudiante a modificar: ";
    cin >> estud;
    if (estud<1 || estud>docente.numeroest) {
        cout << endl;
        system("cls");
        color(hConsole, 4);
        cout << "\n\n\n\n";
        cout << "\t\t\t\t\t\t\t\t\t\t    ------------------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    |Posicion de estudiante inexistente|" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    ------------------------------------" << endl;
        color(hConsole, 7);
    }
    else {
        do {
            cout<<endl;
            cout << "\t\t\t\t\t\t\t\t\t\t  1.-Modificar nombre" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t  2.-Modificar correo" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t  3.-Modificar calificacion" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t  4.-Modificar conducta" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t  0.-Salir" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\tSeleccione: ";
            cin >> op;
            switch (op) {
            case 1:
            {
                system("cls");
                cout << endl << endl << endl;
                cin.ignore(80, '\n');
                cout << "\t\t\t\t\tIngrese el nuevo nombre: ";
                getline(cin, estudiantes[estud - 1].nombre);
                color(hConsole, 10);
                cout << endl << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t ----------------------------------- " << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t |NUEVO DATO GUARDADO CORRECTAMENTE|" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t ------------------------------------ " << endl;
                color(hConsole, 7);
                listado();
                break;
            }
            case 2:
            {
                system("cls");
                cout << endl << endl << endl;
                cin.ignore(80, '\n');
                cout << "\t\t\t\t\tIngrese el nuevo correo: ";
                getline(cin, estudiantes[estud - 1].correo);
                color(hConsole, 10);
                cout << endl << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t ----------------------------------- " << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t |NUEVO DATO GUARDADO CORRECTAMENTE|" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t ----------------------------------- " << endl;
                color(hConsole, 7);
                listado();
                break;
            }
            case 3:
            {
                system("cls");
                int cal;
                cout << endl << endl << endl;
                cout << "\t\t\t\t\tIngrese el numero de la calificacion : ";
                cin >> cal;
                if (cal<1 || cal>docente.numerocal) {
                    color(hConsole, 4);
                    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t|EL NUMERO DE NOTA INGRESADO NO EXISTE|" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                    color(hConsole, 7);
                }
                else {
                    do {
                        cout << "\t\t\t\t\tIngrese la nueva calificacion : ";
                        cin >> estudiantes[estud - 1].notas[cal - 1];
                        if (estudiantes[estud - 1].notas[cal - 1] < 0 || estudiantes[estud - 1].notas[cal - 1]>20) {
                            color(hConsole, 4);
                            cout << "\t\t\t\t\t\t\t\t\t\t-------------------------------- " << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t|RANGO DE CALIFICACIONES (0-20)|" << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t-------------------------------- " << endl;
                            color(hConsole, 7);
                        }
                    } while (estudiantes[estud - 1].notas[cal - 1] < 0 || estudiantes[estud - 1].notas[cal - 1]>20);
                    color(hConsole, 10);
                    cout << endl << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t----------------------------------- " << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t|NUEVO DATO GUARDADO CORRECTAMENTE|" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t----------------------------------- " << endl;
                    color(hConsole, 7);
                    totales();
                    promediototal();
                    detalles();
                    listado();
                }
                break;
            }
            case 4:
            {
                system("cls");
                cout << endl << endl << endl;
                bool a = false;
                while (a == false) {
                    cout << "\t\t\t\t\tIngrese la nueva conducta: ";
                    cin >> estudiantes[estud - 1].conducta;
                    if (estudiantes[estud - 1].conducta == "A" || estudiantes[estud - 1].conducta == "B" || estudiantes[estud - 1].conducta == "C") {
                        a = true;
                    }
                    else {
                        color(hConsole, 4);
                        cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------------------" << endl;
                        cout << "\t\t\t\t\t\t\t\t\t\t|Opcion incorrecta. A=Muy buena | B=Buena | C=Mala|" << endl;
                        cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------------------" << endl;
                        color(hConsole, 7);
                    }
                }
                color(hConsole, 10);
                cout << endl << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t------------------------------------ " << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t|NUEVO DATO GUARDADO CORRECTAMENTE.|" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t------------------------------------ " << endl;
                color(hConsole, 7);
                listado();
                break;
            }
            }
        } while (op != 0);
    }
}
void presentarcalificaciones() {
    system("cls");
    cout << endl << endl << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t COLEGIO " << docente.colegio << endl;
    cout << "\t\t\t\t\t\t\t\t\t     REPORTE DE CALIFICACIONES" << endl << endl << endl;
    color(hConsole, 14);
    cout << "\t\t\t\t\t\tCALIFICACIONES ORDENADAS:" << endl;
    cout << endl << "\t\t\t\t\t\t\t\tNº-";
    color(hConsole, 7);
    for (int i = 0; i < docente.numeroest; i++) {
        cout << "[" << estudiantes[i].total << "]-";
    }
    cout << endl << endl << endl;
    cout << "\t\t\t\t\t\t\t\t\t_______________________________________" << endl;
    cout << "\t\t\t\t\t\t\t\t\t               Docente" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t       " << docente.nombredocente << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t          " << docente.cedula << endl << endl << endl << endl;
}
void interpol(tEstudiantes A[], int tamano, float n) {
    int primero = 0;
    int ultimo = tamano - 1;
    int medio;

    int contador = 0;
    while (A[primero].total != n && contador < tamano)
    {

        medio = primero + ((n - A[primero].total) * (ultimo - primero)) / (A[ultimo].total - A[primero].total);

        if (A[medio].total < n)
            primero = medio + 1;

        else if (A[medio].total > n)

            ultimo = medio - 1;
        else
            primero = medio;

        contador++;
        break;
    }

    if (A[primero].total == n)
    {
        encontrado(primero);
    }
    else
    {
        noencontrado();
    }
}



void busqueda_binaria(tEstudiantes a[], int n, float dato)
{

    int k, i, j;
    i = 0;
    j = n - 1;
    do
    {
        k = (i + j) / 2;
        if (a[k].total <= dato)
        {
            i = k + 1;
        }
        if (a[k].total >= dato)
        {
            j = k - 1;
        }
    } while (i <= j);
    if (a[k].total == dato)
    {
        encontrado(k);
    }
    else
    {
        noencontrado();
    }
}
float cantidadabuscar() {
    float cantidad;
    cout << "\n\n\n\n\n";
    color(hConsole, 10);
    cout << "\t\t\t\t\t\t\t\t\t\t  ------------------------" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t  |ALGORITMOS DE BUSQUEDA|" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t  ------------------------" << endl << endl;
    color(hConsole, 7);
    cout << "\t\t\t\t\t\t\t\tIngresa la calificcion total del estudiante a buscar: ";
    cin >> cantidad;
    system("cls");
    return cantidad;
}
void lineal(tEstudiantes a[], int n, float dato)
{
    bool aa = false;
    for (int i = 0; i <= n; i++)
    {
        if (a[i].total == dato)
        {
            encontrado(i);
            aa = true;
        }
    }
    if (aa == false) {
        noencontrado();
    }
}
void noencontrado() {
    system("cls");
    ofstream  archivo;
    cout << "\n\n\n\n ";
    color(hConsole, 4);
    cout << "\t\t\t\t\t\t\t\t\t\t----------------------------" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t|CALIFICACION NO ENCONTRADA|" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t----------------------------" << endl << endl;
    color(hConsole, 7);
    archivo.close();
}
void mostrar() {
    system("cls");
    cout << "\t\t\t\t\t\t\t\t\t\t COLEGIO " << docente.colegio << endl;
    cout << "\t\t\t\t\t\t\t\t\t     REPORTE DE CALIFICACIONES" << endl << endl;
    cout << "\t\t\t\t\t\tAño Lectivo: 2021-2022" << endl;
    cout << "\t\t\t\t\t\tMateria:  " << docente.materia << endl << endl;
    color(hConsole, 14);
    cout << "\t\t\t\t\t\t" << setw(5) << left << "#" << setw(25) << left << "ESTUDIANTE" << setw(30) << left << "CORREO ELECTRONICO";
    for (int i = 0; i < docente.numerocal; i++) {
        cout << setw(10) << right << "NOTA " << i + 1;
    }
    cout << setw(10) << right << "TOTAL" << setw(15) << right << "CONDUCTA";
    cout << endl;
    color(hConsole, 8);
    for (int i = 0; i < docente.numeroest; i++) {
        cout << "\t\t\t\t\t\t" << setw(5) << left << i + 1 << setw(25) << left << estudiantes[i].nombre << setw(30) << left << estudiantes[i].correo;
        for (int j = 0; j < docente.numerocal; j++) {
            cout << setw(10) << right << estudiantes[i].notas[j];
        }
        cout << setw(11) << right << estudiantes[i].total << setw(12) << right << estudiantes[i].conducta;
        cout << endl;
    }
    color(hConsole, 14);
    cout << endl << endl << endl;
    cout << "\t\t\t\t\t\tRESUMEN" << endl << endl;
    color(hConsole, 15);
    cout << "\t\t\t\t\t\tPromedio\t\t\t\t " << docente.total << endl;
    cout << "\t\t\t\t\t\tdel curso:" << endl << endl << endl;
    cout << "\t\t\t\t\t\tTOTAL" << endl << endl;
    color(hConsole, 10);
    cout << "\t\t\t\t\t\t     \t\t\t\tAprobados (14-20)\t\t\t\t\t" << docente.aprobados << endl;
    color(hConsole, 6);
    cout << "\t\t\t\t\t\t     \t\t\t\tSuspenso  (09-13)\t\t\t\t\t" << docente.suspenso << endl;
    color(hConsole, 4);
    cout << "\t\t\t\t\t\t     \t\t\t\tReprobado (01-08)\t\t\t\t\t" << docente.reprobados << endl << endl << endl;
    color(hConsole, 8);
    cout << "\t\t\t\t\t\t\t\t\t_______________________________________" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t       Docente" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t    " << docente.nombredocente << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t     " << docente.cedula << endl << endl << endl << endl;
    color(hConsole, 7);
}
void encontrado(int i) {
    ofstream  archivo;
    archivo.open("BBDCalificaciones/busqueda.txt", ios::app);
    cout << endl << endl << endl << endl;
    archivo << endl << endl << endl << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t   COLEGIO " << docente.colegio << endl;
    archivo << "\t\t\t\t\t\t   COLEGIO " << docente.colegio << endl;
    cout << "\t\t\t\t\t\t\t\t\t\tREPORTE DE CALIFICACIONES" << endl << endl << endl;
    archivo << "\t\t\t\t\t\t\t\t\t\t\t\t\t\t       REPORTE DE CALIFICACIONES" << endl << endl << endl;
    color(hConsole, 10);
    cout << "\t\t\t\t\t\t\t\t        La calificacion total a buscar fue de [" << estudiantes[i].total << "]" << endl << endl;
    color(hConsole, 14);
    archivo << "\t\t\t\tLa calificacion total a buscar fue de [" << estudiantes[i].total << "]" << endl << endl;
    cout << "\t\t\t\t\t\tDATOS DEL ESTUDIANTES:  " << endl << endl;
    archivo << "\t\t\t\tDATOS DEL ESTUDIANTES  " << endl << endl;
    cout <<"\t\t\t\t\t\t"<< setw(5) << left << "#" << setw(25) << left << "ESTUDIANTE" << setw(30) << left << "CORREO ELECTRONICO";
    archivo << setw(5) << left << "#" << setw(25) << left << "ESTUDIANTE" << setw(30) << left << "CORREO ELECTRONICO";
    for (int i = 0; i < docente.numerocal; i++) {
        cout << setw(10) << right << "NOTA " << i + 1;
        archivo << setw(10) << right << "NOTA " << i + 1;
    }
    cout << setw(10) << right << "TOTAL" << setw(15) << right << "CONDUCTA";
    archivo << setw(10) << right << "TOTAL" << setw(15) << right << "CONDUCTA" << endl;
    cout << endl;
    color(hConsole, 8);
    cout << "\t\t\t\t\t\t"<<setw(5) << left << i + 1 << setw(25) << left << estudiantes[i].nombre << setw(30) << left << estudiantes[i].correo;
    archivo << setw(5) << left << i + 1 << setw(25) << left << estudiantes[i].nombre << setw(30) << left << estudiantes[i].correo;
    for (int j = 0; j < docente.numerocal; j++) {
        cout << setw(10) << right << estudiantes[i].notas[j];
        archivo << setw(10) << right << estudiantes[i].notas[j];
    }
    cout << setw(11) << right << estudiantes[i].total << setw(12) << right << estudiantes[i].conducta;
    archivo << setw(11) << right << estudiantes[i].total << setw(12) << right << estudiantes[i].conducta;
    cout << endl << endl << endl;
    archivo << endl << endl << endl;
    color(hConsole, 7);
    cout << "\t\t\t\t\t\t\t\t\t\t_______________________________________" << endl;
    archivo << "\t\t\t\t\t\t\t\t\t\t_______________________________________" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t\t     Docente" << endl;
    archivo << "\t\t\t\t\t     Docente" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t\t  " << docente.nombredocente << endl;
    archivo << "\t\t\t\t\t  " << docente.nombredocente << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t\t   " << docente.cedula << endl << endl << endl << endl;
    archivo << "\t\t\t\t\t   " << docente.cedula << endl << endl << endl << endl;
    archivo.close();
}


int menubusqueda() {
    int op;
    do {
        cout << "\n\n\n\n";
        color(hConsole, 10);
        cout << "\t\t\t\t\t\t\t\t\t\t  ------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  |ALGORITMOS DE BUSQUEDA|" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  ------------------------" << endl;
        color(hConsole, 7);
        cout << "\t\t\t\t\t\t\t\t\t\t   OPCIONES:" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    1.-LINEAL" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    2.-BINARIA" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    3.-INTERPOLACION" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    0.-SALIR" << endl;
        color(hConsole, 6);
        cout << "\t\t\t\t\t\t\t\t\t\t Seleccione: ";
        cin >> op;
        color(hConsole, 7);
        if (op < 0 || op>4) {
            system("cls");
            color(hConsole, 4);
            cout << "\n\n\n\n";
            cout << "\t\t\t\t\t\t\t\t\t   --------------------------------------" << endl;
            cout << "\t\t\t\t\t\t\t\t\t   |Opcion incorrecta. Vuelve a intentar|" << endl;
            cout << "\t\t\t\t\t\t\t\t\t   --------------------------------------" << endl;
            color(hConsole, 7);
        }
    } while (op < 0 || op>4);
    system("cls");
    return op;
}
void HeapSort(tEstudiantes b[], int n)
{
    tEstudiantes valor, temp;
    int a;

    for (int i = n; i > 0; i--)
    {
        for (int j = 1; j <= i; j++)
        {
            valor = b[j];
            a = j / 2;
            while (a > 0 && b[a].total < valor.total)
            {
                b[j] = b[a];
                j = a;
                a = a / 2;
            }
            b[j] = valor;
        }
        temp = b[1];
        b[1] = b[i];
        b[i] = temp;
    }

}
tEstudiantes mitad(tEstudiantes a[], int pinicial, int pfinal)
{
    return a[(pinicial + pfinal) / 2];
}
void ordenar(tEstudiantes a[], int pinicial, int pfinal)
{

    int i = pinicial;
    int j = pfinal;
    tEstudiantes temp;
    tEstudiantes piv = mitad(a, pinicial, pfinal);

    do
    {
        while (a[i].total < piv.total)
        {
            i++;
        }
        while (a[j].total > piv.total)
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


void dividir(tEstudiantes a[], int inicial, int final)
{

    if (inicial >= final)
    {
        return;
    }
    int m = inicial + (final - inicial) / 2;
    dividir(a, inicial, m);
    dividir(a, m + 1, final);
    Fusionar(a, inicial, m, final);
}
void Fusionar(tEstudiantes arr[], int pinicial, int medio, int pfinal)
{
    int n1 = medio - pinicial + 1;
    int n2 = pfinal - medio;

    tEstudiantes L[MAXX], R[MAXX];
    L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[pinicial + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[medio + 1 + j];
    int i = 0;

    int j = 0;

    int k = pinicial;

    while (i < n1 && j < n2) {
        if (L[i].total <= R[j].total) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void inserccion(tEstudiantes a[], int num) {
    tEstudiantes aux;
    int aux2;
    for (int i = 0; i < num; i++) {
        aux = a[i];
        aux2 = i;

        while (aux2 > 0) {
            if (a[aux2 - 1].total > aux.total) {
                a[aux2] = a[aux2 - 1];
                a[aux2 - 1] = aux;
            }
            aux2--;
        }

    }
}

void burbuja(tEstudiantes a[], int n)
{
    int i, j;
    tEstudiantes aux;
    for (i = 0; i < n; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (a[j].total < a[i].total)
            {
                aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }

        }
    }
}

void seleccion(tEstudiantes a[], int tamanio) {
    int i, j, minn;
    tEstudiantes  aux;
    for (i = 0; i < tamanio; i++)
    {
        minn = i;
        for (j = i + 1; j < tamanio; j++)
        {
            if (a[j].total < a[minn].total)
            {
                minn = j;
            }
        }
        aux = a[i];
        a[i] = a[minn];
        a[minn] = aux;
    }
}
int menuordenamiento() {
    int op;
    do {
        cout << "\n\n\n\n ";
        color(hConsole,10);
        cout << "\t\t\t\t\t\t\t\t\t\t  ----------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  |ALGORITMOS DE ORDENAMIENTO|" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  ----------------------------" << endl;
        color(hConsole, 7);
        cout << "\t\t\t\t\t\t\t\t\t\t  OPCIONES:" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    1.-BURBUJA" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    2.-SELECCION" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    3.-INSERCION" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    4.-MERGESORT" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    5.-QUICKSORT" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t    6.-HEAPSORT" << endl;
        color(hConsole, 6);
        cout << "\t\t\t\t\t\t\t\t\tSeleccione: ";
        color(hConsole, 7);
        cin >> op;
        if (op < 0 || op>6) {
            system("cls");
            color(hConsole, 4);
            cout << "\n\n\n\n ";
            cout << "\t\t\t\t\t\t\t\t\t   --------------------------------------" << endl;
            cout << "\t\t\t\t\t\t\t\t\t  ::Opcion incorrecta. Vuelve a intentar::" << endl;
            cout << "\t\t\t\t\t\t\t\t\t   --------------------------------------" << endl;
            color(hConsole, 7);
        }
    } while (op < 0 || op>6);
    system("cls");
    return op;

}
int menugeneral() {
    int op;
    do {
        color(hConsole, 11);
        cout << "\n\n\n\n ";
        cout << "\t\t\t\t\t\t\t\t\t\t       ---------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t::::::::SISTEMA DE CALIFICACIONES:::::::::" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t       ---------------------------" << endl << endl;
        color(hConsole, 7);
        cout << "\t\t\t\t\t\t\t\t\t\t  OPCIONES:" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  1.-INGRESAR DATOS" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  2.-MODIFICAR REGISTRO" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  3.-MOSTRAR CALIFICACIONES" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  4.-ORDENAR CALIFICACIONES" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  5.-BUSCAR CALIFICACION" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t  0.-SALIR" << endl;
        color(hConsole, 6);
        cout << "\t\t\t\t\t\t\t\t\tSeleccione: ";
        color(hConsole, 7);
        cin >> op;
        if (op < 0 || op>5) {
            system("cls");
            cout << "\n\n\n\n ";
            color(hConsole, 4);
            cout << "\t\t\t\t\t\t\t\t\t\t--------------------------------------" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t|Opcion incorrecta. Vuelve a intentar|" << endl;
            cout << "\t\t\t\t\t\t\t\t\t\t--------------------------------------" << endl;
            color(hConsole, 7);
        }
    } while (op < 0 || op>5);
    system("cls");
    return op;
}
void datos() {
    system("cls");
    cout << "\n\n\n\n ";
    color(hConsole, 11);
    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t|::::::::::::::REGISTRO:::::::::::::::|" << endl;
    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl << endl << endl << endl;
    color(hConsole, 7);
    cin.ignore(80, '\n');
    cout << "\t\t\t\t\t\tNOMBRE DE LA UNIDAD EDUCATIVA: ";
    getline(cin, docente.colegio);
    cout << "\t\t\t\t\t\tNOMBRE DEL DOCENTE: ";
    getline(cin, docente.nombredocente);
    cout << "\t\t\t\t\t\tCEDULA DEL DOCENTE: ";
    cin >> docente.cedula;
    cin.ignore(80, '\n');
    cout << "\t\t\t\t\t\tMATERIA: ";
    getline(cin, docente.materia);
    cout << "\t\t\t\t\t\tNUMERO DE ESTUDIANTES: ";
    cin >> docente.numeroest;
    cout << "\t\t\t\t\t\tNUMERO DE NOTAS: ";
    cin >> docente.numerocal;
    for (int i = 0; i < docente.numeroest; i++) {
        system("cls");
        cout << "\n\n\n\n ";
        color(hConsole, 11);
        cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t|::::::::::::::REGISTRO:::::::::::::::|" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl << endl << endl << endl;
        color(hConsole, 7);
        cin.ignore(80, '\n');
        cout << "\t\t\t\t\t\tINGRESA EL NOMBRE DEL " << i + 1 << " ESTUDIANTE: ";
        getline(cin, estudiantes[i].nombre);
        cout << "\t\t\t\t\t\tCORREO ELECTRONICO DEL ESTUDIANTE: ";
        getline(cin, estudiantes[i].correo);
        bool a = false;
        while (a == false) {
            cout << "\t\t\t\t\t\tCONDUCTA DEL ESTUDIANTES (A/B/C): ";
            cin >> estudiantes[i].conducta;
            if (estudiantes[i].conducta == "A" || estudiantes[i].conducta == "B" || estudiantes[i].conducta == "C") {
                a = true;
            }
            else {
                system("cls");
                cout << "\n\n\n\n ";
                color(hConsole, 11);
                cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t|::::::::::::::REGISTRO:::::::::::::::|" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl << endl;
                color(hConsole, 4);
                cout << "\t\t\t\t\t\t\t\t\t   ---------------------------------------------------" << endl;
                cout << "\t\t\t\t\t\t\t\t\t   |Opcion incorrecta. A=Muy buena | B=Buena | C=Mala|" << endl;
                cout << "\t\t\t\t\t\t\t\t\t   ---------------------------------------------------" << endl << endl;
                color(hConsole, 7);
            }
        }
        for (int j = 0; j < docente.numerocal; j++) {
            do {
                cout << "\t\t\t\t\t\tNOTA " << j + 1 << ": ";
                cin >> estudiantes[i].notas[j];
                if (estudiantes[i].notas[j] < 0 || estudiantes[i].notas[j]>20) {
                    color(hConsole, 11);
                    system("cls");
                    cout << "\n\n\n\n ";
                    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t|::::::::::::::REGISTRO:::::::::::::::|" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl << endl ;
                    color(hConsole, 4);
                    cout << "\t\t\t\t\t\t\t\t\t\t   -------------------------------- " << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t   |RANGO DE CALIFICACIONES (0-20)|" << endl;
                    cout << "\t\t\t\t\t\t\t\t\t\t   -------------------------------- " << endl<<endl;
                    color(hConsole, 7);
                }
            } while (estudiantes[i].notas[j] < 0 || estudiantes[i].notas[j]>20);
        }
    }
    totales();
    promediototal();
    detalles();
    system("cls");
}
void totales() {
    float suma = 0;
    for (int i = 0; i < docente.numeroest; i++) {
        for (int j = 0; j < docente.numerocal; j++) {
            suma += estudiantes[i].notas[j];
        }
        estudiantes[i].total = suma / docente.numerocal;
        suma = 0;
    }
}
void promediototal() {
    float promedio = 0;
    for (int i = 0; i < docente.numeroest; i++) {
        promedio += estudiantes[i].total;
    }
    docente.total = promedio / docente.numeroest;
}
void detalles() {
    docente.aprobados = 0;
    docente.reprobados = 0;
    docente.suspenso = 0;
    for (int i = 0; i < docente.numeroest; i++) {
        if (estudiantes[i].total > 13 && estudiantes[i].total < 21) {
            docente.aprobados += 1;
        }
        else {
            if (estudiantes[i].total > 8 && estudiantes[i].total < 14) {
                docente.suspenso += 1;
            }
            else {
                if (estudiantes[i].total > -1 && estudiantes[i].total < 9) {
                    docente.reprobados += 1;
                }
            }
        }
    }
}
void guardar() {
    ofstream  archivo;
    archivo.open("BBDCalificaciones/calificaciones.txt", ios::out);
    archivo << "\t\t\t\t\t COLEGIO " << docente.colegio << endl;
    archivo << "\t\t\t\t\tREPORTE DE CALIFICACIONES" << endl << endl;
    archivo << "Año Lectivo: 2021-2022" << endl;
    archivo << "Materia:  " << docente.materia << endl << endl;
    archivo << setw(5) << left << "#" << setw(25) << left << "ESTUDIANTE" << setw(30) << left << "CORREO ELECTRONICO";
    for (int i = 0; i < docente.numerocal; i++) {
        archivo << setw(10) << right << "NOTA " << i + 1;
    }
    archivo << setw(10) << right << "TOTAL" << setw(15) << right << "CONDUCTA";
    archivo << endl;
    for (int i = 0; i < docente.numeroest; i++) {
        archivo << setw(5) << left << i + 1 << setw(25) << left << estudiantes[i].nombre << setw(30) << left << estudiantes[i].correo;
        for (int j = 0; j < docente.numerocal; j++) {
            archivo << setw(10) << right << estudiantes[i].notas[j];
        }
        archivo << setw(11) << right << estudiantes[i].total << setw(12) << right << estudiantes[i].conducta;
        archivo << endl;
    }
    archivo << endl << endl << endl;
    archivo << "RESUMEN" << endl << endl;
    archivo << "Promedio\t\t\t\t " << docente.total << endl;
    archivo << "del curso:" << endl << endl << endl;
    archivo << "TOTAL" << endl << endl;
    archivo << "     \t\t\t\tAprobados (14-20)\t\t\t\t\t" << docente.aprobados << endl;
    archivo << "     \t\t\t\tSuspenso  (09-13)\t\t\t\t\t" << docente.suspenso << endl;
    archivo << "     \t\t\t\tReprobado (01-08)\t\t\t\t\t" << docente.reprobados << endl << endl << endl;
    archivo << "\t\t\t_______________________________________" << endl;
    archivo << "\t\t\t\t     Docente" << endl;
    archivo << "\t\t\t\t  " << docente.nombredocente << endl;
    archivo << "\t\t\t\t   " << docente.cedula << endl << endl << endl << endl;
    archivo.close();
}