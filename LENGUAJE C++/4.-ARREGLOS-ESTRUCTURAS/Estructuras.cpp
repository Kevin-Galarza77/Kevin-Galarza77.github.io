#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
using namespace std;
using namespace std;
const int MAXX = 50;
int contador = 0;
typedef struct {
    string nombres;
    int ganados;
    int empatados;
    int puntos;
}tEquipos;
tEquipos equipos[MAXX];
void datos();
void puntosyordenar();
int menuoficial();
typedef struct {
    string nombre;
    int edad;
    string estudios;
    string contrato;
}tBecarios;
void proceso();
typedef struct {
    int dia;
    int mes;
    int ano;
}tFecha;
tFecha fechas[2];
void datosS();
void procesoS();
const int MAX = 100;
typedef struct {
    string nombre;
    int edad;
    double peso;
    string nif;
}tEstudiante;
typedef struct {
    tEstudiante elementos[MAX];
    int contador;
}tLista;
int menu();
void cargar(tLista& lista, bool& ok);
void guardar(const tLista& lista);
void leerEstudiante(tEstudiante& estudiante);
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok);
string nombreCompleto(tEstudiante estudiante);
void listado(const tLista& lista);
void buscar(const tLista& lista, string dato);
int menu() {
    int op;
    do {
        cout << "\t\t\t---------------------------" << endl;
        cout << "\t\t\t|ZOOLOGICO DE GUAYLLABAMBA|" << endl;
        cout << "\t\t\t---------------------------" << endl << endl;
        cout << "1.-Registrar animal" << endl;
        cout << "2.-Base de datos de animales del zoologico" << endl;
        cout << "3.-Buscar animal" << endl;
        cout << "4.-Salir" << endl;
        cout << "Opcion: ";
        cin >> op;
    } while ((op < 0) || (op > 4));
    return op;
}

void cargar(tLista& lista, bool& ok) {
    tEstudiante estudiante;//VARIABLE AUXILIAR PARA LEER
    ifstream archivo;
    char aux;
    lista.contador = 0;//INICIAMOS LA LISTA
    archivo.open("archivo.txt");
    if (!archivo.is_open()) {
        ok = false;
    }
    else {
        ok = true;
        getline(archivo, estudiante.nombre);//LEEMOS EL PRIMER NOMBRE
        while ((estudiante.nombre != "XXX") && (lista.contador < MAX)) {
            archivo >> estudiante.edad;
            archivo >> estudiante.peso;
            archivo >> estudiante.nif;
            archivo.get(aux);//SALTAMOS INTRO
            lista.elementos[lista.contador] = estudiante;//AL FINAL
            lista.contador++;
            getline(archivo, estudiante.nombre);//SIGUIENTE NOMBRE
        }//SI HAY MAS DE MAX ESTUDIANTES, IGNORAMOS EL RESTO
        archivo.close();
    }
}
void guardar(const tLista& lista) {
    ofstream archivo;
    archivo.open("archivo.txt");
    for (int i = 0; i < lista.contador; i++) {
        archivo << lista.elementos[i].nombre << endl;
        archivo << lista.elementos[i].edad << endl;
        archivo << lista.elementos[i].peso << endl;
        archivo << lista.elementos[i].nif << endl;
    }
    archivo << "XXX" << endl;//CENTINELA
    archivo.close();
}
void leerEstudiante(tEstudiante& estudiante) {
    cin.ignore(80, '\n');//DESCARTAMOS CUALQUIER ENTRADA PENDIENTE
    cout << "Nombre: ";
    getline(cin, estudiante.nombre);
    cout << "Identificacion: ";
    cin >> estudiante.edad;
    cout << "Peso: ";
    cin >> estudiante.peso;
    cout << "Tipo de animal: ";
    cin >> estudiante.nif;
    cin.sync();//DESCARTAMOS CAULQUIER ENTRADA PENDIENTE
}
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok) {
    ok = true;
    if (lista.contador == MAX) {
        ok = false;
    }
    else {
        lista.elementos[lista.contador] = estudiante;
        //insertamos al final
        lista.contador++;
    }
}
string nombreCompleto(tEstudiante estudiante) {
    return estudiante.nombre;
}
void mostrarEstudinates(tEstudiante estudiante) {
    cout << setw(25) << left << estudiante.edad;
    cout << setw(30) << left << nombreCompleto(estudiante);
    cout << setw(15) << left << estudiante.peso;
    cout << setw(30) << left << estudiante.nif << endl;
    cout << endl << endl;
}
void listado(const tLista& lista) {
    cout << setw(25) << left << "----------------" << setw(30) << left << "--------" << setw(15) << left << "----------" << setw(30) << left << "----------------" << endl;
    cout << setw(25) << left << "|IDENTIFICACION|" << setw(30) << left << "|NOMBRE|" << setw(15) << left << "|PESO(kg)|" << setw(30) << left << "|TIPO DE ANIMAL|" << endl;
    cout << setw(25) << left << "----------------" << setw(30) << left << "--------" << setw(15) << left << "----------" << setw(30) << left << "----------------" << endl;

    for (int i = 0; i < lista.contador; i++) {
        mostrarEstudinates(lista.elementos[i]);
    }
}
void buscar(const tLista& lista, string dato) {
    bool a = false;
    for (int i = 0; i < lista.contador; i++) {
        if (lista.elementos[i].nombre == dato) {
            cout << "Elemento encontrado en la posicion: " << i + 1 << endl;
            a = true;
        }
    }
    cout << endl;
    if (a == false) {
        cout << "Elemento no encontrado" << endl;
    }
}
void datosS() {
    cout << "\t\t\t------------" << endl;
    cout << "\t\t\t|BIENVENIDO|" << endl;
    cout << "\t\t\t------------" << endl << endl;
    for (int i = 0; i < 2; i++) {
        cout << "\t---------" << endl;
        cout << "\t|FECHA " << i + 1 << "|" << endl;
        cout << "\t---------" << endl;
        do {
            cout << "Ingresa el dia, mes y anio (Ejemplo: 15 06 2021): ";
            cin >> fechas[i].dia >> fechas[i].mes >> fechas[i].ano;
            if (fechas[i].dia < 1 || fechas[i].dia>31 || fechas[i].mes < 1 || fechas[i].mes>12) {
                cout << "'El dia es en un rango de 1-31. El mes en un rango de 1-12.Intenta nuevamente." << endl;
            }
        } while (fechas[i].dia < 1 || fechas[i].dia>31 || fechas[i].mes < 1 || fechas[i].mes>12);
    }
}
void procesoS() {
    int puntos1, puntos2, punt1, punt2;
    if (fechas[0].dia < fechas[1].dia) {
        puntos1 = 0;
        puntos2 = 1;
    }
    else {
        if (fechas[0].dia > fechas[1].dia) {
            puntos1 = 1;
            puntos2 = 0;
        }
        else {
            puntos1 = 0;
            puntos2 = 0;
        }
    }
    if (fechas[0].mes < fechas[1].mes) {
        punt1 = 0;
        punt2 = 5;
    }
    else {
        if (fechas[0].mes > fechas[1].mes) {
            punt1 = 5;
            punt2 = 0;
        }
        else {
            punt1 = 0;
            punt2 = 0;
        }
    }
    int punts1, punts2;
    if (fechas[0].ano < fechas[1].ano) {
        punts1 = 0;
        punts2 = 20;
    }
    else {
        if (fechas[0].ano > fechas[1].ano) {
            punts1 = 20;
            punts2 = 0;
        }
        else {
            punts1 = 0;
            punts2 = 0;
        }
    }
    int total1, total2;
    total1 = puntos1 + punt1 + punts1;
    total2 = puntos2 + punt2 + punts2;
    if (total1 > total2) {
        cout << endl;
        cout << endl;
        cout << "\t\tLA MAYOR FECHA ES: " << endl;
        cout << "\t\t   ------------" << endl;
        cout << "\t\t   |" << fechas[0].dia << " " << fechas[0].mes << " " << fechas[0].ano << "|" << endl;
        cout << "\t\t   ------------" << endl;
        cout << endl;
        cout << endl;
    }
    else {
        if (total1 < total2) {
            cout << endl;
            cout << endl;
            cout << "\t\tLA MAYOR FECHA ES: " << endl;
            cout << "\t\t   ------------" << endl;
            cout << "\t\t   |" << fechas[1].dia << " " << fechas[1].mes << " " << fechas[1].ano << "|" << endl;
            cout << "\t\t   ------------" << endl;
            cout << endl;
            cout << endl;
        }
        else {
            cout << endl;
            cout << endl;
            cout << "\t\t\t\t--------------------------" << endl;
            cout << "\t\t\t\t|AMBAS FECHAS SON IGUALES|" << endl;
            cout << "\t\t\t\t--------------------------" << endl;
            cout << endl;
            cout << endl;
        }
    }
}

void proceso() {
    int n;
    cout << "\t\t\t------------" << endl;
    cout << "\t\t\t|BIENVENIDO|" << endl;
    cout << "\t\t\t------------" << endl << endl;
    cout << "Numero de empleados: ";
    cin >> n;
    tBecarios beca[MAXX];
    for (int i = 0; i < n; i++) {
        cin.ignore(80, '\n');
        cout << "Ingresa el nombre del " << i + 1 << " empleado: ";
        getline(cin, beca[i].nombre);
        cout << "Ingresa la edad de " << beca[i].nombre << ": ";
        cin >> beca[i].edad;
        cin.ignore(80, '\n');
        cout << "Ingresa el grado de estudios de " << beca[i].nombre << ": ";
        getline(cin, beca[i].estudios);
        cout << "Ingresa el tipo de contrato de " << beca[i].nombre << ": ";
        getline(cin, beca[i].contrato);
        cin.sync();
    }
    cout << setw(30) << left << "__________" << setw(15) << left << "______" << setw(35) << left << "___________________" << setw(35) << left << "______________" << endl;
    cout << setw(30) << left << "|EMPLEADO|" << setw(15) << left << "|EDAD|" << setw(35) << left << "|GRADO DE ESTUDIOS|" << setw(35) << left << "|CONTRATACION|" << endl;
    cout << setw(30) << left << "----------" << setw(15) << left << "------" << setw(35) << left << "-------------------" << setw(35) << left << "--------------" << endl;
    cout << endl;
    for (int i = 0; i < n; i++) {
        cout << setw(30) << left << beca[i].nombre << " " << setw(15) << left << beca[i].edad << " " << setw(35) << left << beca[i].estudios << setw(35) << left << beca[i].contrato << endl;
    }
    cout << endl << endl;
}
void datos() {
    string a;
    do {
        cin.ignore(80, '\n');
        cout << "Nombre del equipo " << contador + 1 << ": ";
        getline(cin, a);
        if (a != "*") {
            equipos[contador].nombres = a;
            cout << "Partidos ganados de " << equipos[contador].nombres << ": ";
            cin >> equipos[contador].ganados;
            cout << "Partidos empatados " << equipos[contador].nombres << ": ";
            cin >> equipos[contador].empatados;
            contador += 1;
        }
    } while (a != "*");
}
void puntosyordenar() {
    for (int i = 0; i < contador; i++) {
        equipos[i].puntos = equipos[i].ganados * 3 + equipos[i].empatados * 1;
    }
    cout << "*************************************************************" << endl;
    cout << " ------                                               ------" << endl;
    cout << setw(50) << left << "|EQUIPO|" << "   |PUNTOS|" << endl;
    cout << " ------                                               ------" << endl;
    for (int i = 0; i < contador; i++) {
        cout << setw(50) << left << equipos[i].nombres << "    [" << equipos[i].puntos << "]" << endl;
    }
    int i, j, aux, min;

    for (i = 0; i < contador; i++)
    {
        min = i;
        for (j = i + 1; j < contador; j++)
        {
            if (equipos[j].puntos <= equipos[min].puntos)
            {
                min = j;
            }

        }
        aux = equipos[i].puntos;
        equipos[i].puntos = equipos[min].puntos;
        equipos[min].puntos = aux;
    }
    cout << "\t\tLOS PUNTOS EN ORDEN SON: " << endl;
    for (int i = 0; i < contador; i++) {
        cout << "\t\t   [" << equipos[i].puntos << "]" << endl;
    }
}
int menuoficial() {
    int op;
    cout << "\t\t\t--------------" << endl;
    cout << "\t\t\t|MENU GENERAL|" << endl;
    cout << "\t\t\t--------------" << endl << endl;
    cout << "1.-EQUIPOS DE FUTBOL" << endl;
    cout << "2.-ZOOLOGICO" << endl;
    cout << "3.-BECARIOS" << endl;
    cout << "4.-FECHAS" << endl;
    cout << "0.SALIR" << endl;
    cout << "OPCION: ";
    cin >> op;
    return op;
}
int main() {
    int op;
    do {
        op = menuoficial();
        switch (op) {
        case 1: {
            system("cls");
            cout << "INGRESA '*' EN EL NOMBRE DEL EQUIPO PARA DEJAR DE INGRESAR" << endl;
            datos();
            puntosyordenar();
            int x;
            do {
                cout << "SELECCIONA:" << endl;
                cout << "1.-Agregar equipo" << endl;
                cout << "2.-Salir" << endl;
                cout << "Opcion: ";
                cin >> x;
                if (x == 1)
                {
                    datos();
                    puntosyordenar();
                }
                else {
                    cout << "\t\t---------" << endl;
                    cout << "\t\t|GRACIAS|" << endl;
                    cout << "\t\t---------" << endl;
                }
            } while (x != 2);
            contador = 0;
            break;
        }
        case 2: {
            system("cls");
            cout << endl << endl;
            cout << "***IMPORTANTE***" << endl;
            cout << "'PARA EL EJERCICIO DE ZOOLOGICO,PORFAVOR USAR UN FORMATO TXT CON POR LO MENOS UN COLUMNA DE DATOS EN EL ORDEN DE :" << endl;
            cout << "NOMBRE DEL ANIMAL,NUMERO DE IDENTIFICACION,PESO,TIPO DE ANIMAL y SENTINELA" << endl;
            cout << "***EJEMPLO:***" << endl;
            cout << "LEON(nombre)" << endl;
            cout << "12564352(numero entero de identificacion)" << endl;
            cout << "mamifero(tipo)" << endl;
            cout << "XXX(centinela)" << endl;
            cout << "SI DESEA PUEDE INGRESAR AL REPLIT:   https://replit.com/@KevinGalarza2/CompetitiveJovialRuntimeenvironment#archivo.txt   " << endl;
            tLista lista;
            tEstudiante estudiante;
            bool exito;
            int op, pos;
            cargar(lista, exito);
            if (!exito)
            {
                cout << "No se ha podido cargar la lista" << endl;
            }
            else {
                do {//SE CUMPLE EL CODIGO ALMENOS UNA VEZ
                    op = menu();
                    switch (op)
                    {
                    case 1:
                    {
                        leerEstudiante(estudiante);
                        insertarEstudiante(lista, estudiante, exito);
                        if (!exito)
                        {
                            cout << "Lista llena: imposible insertar" << endl;
                        }
                    }
                    break;
                    case 2:
                    {
                        system("cls");
                        listado(lista);
                    }
                    break;
                    case 3:
                    {
                        system("cls");
                        cout << "\n\n\n\n" << endl;
                        string dat;
                        cout << "Ingresa el animal a buscar: ";
                        cin >> dat;
                        buscar(lista, dat);
                        listado(lista);
                    }
                    break;
                    }
                } while (op != 4);
                guardar(lista);
            }

            break;
        }
        case 3: {
            system("cls");
            proceso();
            break;
        }
        case 4: {
            system("cls");
            datosS();
            procesoS();
            break;
        }
        }
    } while (op != 0);
    cout << "\t\t\t---------" << endl;
    cout << "\t\t\t|GRACIAS|" << endl;
    cout << "\t\t\t---------" << endl << endl;
}
