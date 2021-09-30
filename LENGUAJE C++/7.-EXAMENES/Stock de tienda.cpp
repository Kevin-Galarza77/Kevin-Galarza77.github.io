#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
using namespace std;
const int MAX = 100;
typedef struct {
    string nombre;
    int edad;
    double nota;
    int unidades;
    int activos;
}tEstudiante;
typedef struct {
    tEstudiante elementos[MAX];
    int contador;
}tLista;
void ordenar_productos(tLista& lista);
int menu();
void listado(const tLista& lista);
void cargar(tLista& lista, bool& ok);
void guardar(const tLista& lista);
void leerEstudiante(tEstudiante& estudiante);
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok);
string nombreCompleto(tEstudiante estudiante);
void calificar(tLista& lista);
int mayorNota(const tLista& lista);
void mostrarEstudinates(tEstudiante estudiante);
void listado(const tLista& lista);
void ordenarBurburja(tLista& lista, tEstudiante& stock);
bool operator<(tEstudiante opIzq, tEstudiante opDer);

void ordenarBurburja(tLista& lista, tEstudiante& stock) {
    int i = 0;
    bool inter = true;
    tEstudiante temp;
    if (lista.contador == 0) {
        cout << endl << "ERROR! No existen productos en el registro" << endl << endl;
    }
    else {
        while ((i < lista.contador - 1) && inter) {
            inter = false;
            for (int j = lista.contador - 1; j > i; j--) {
                if (lista.elementos[j] < lista.elementos[j - 1]) {
                    temp = lista.elementos[j];
                    lista.elementos[j] = lista.elementos[j - 1];
                    lista.elementos[j - 1] = temp;
                    inter = true;
                }
            }
            if (inter) {
                i++;
            }
        }
        cout << endl << "Se ha ordenado el registro de acuerdo a los nombres de los productos! " << endl << endl;
    }
}
bool operator<(tEstudiante opIzq, tEstudiante opDer) {
    return (opIzq.nombre < opDer.nombre);
}
int menu() {
    int op;
    do {
        cout << "\t\t    -------------------" << endl;
        cout << "\t\t:::::SUPERMERCADO TIA:::::" << endl;
        cout << "\t\t    -------------------" << endl << endl << endl;
        cout << "1.-Añadir un nuevo producto" << endl;
        cout << "2.-Mostrar productos." << endl;
        cout << "3.-Ordenar productos por orden alfabetico." << endl;
        cout << "0.-Salir" << endl;
        cout << "Opcion: ";
        cin >> op;
    } while ((op < 0) || (op > 3));
    return op;
}

void cargar(tLista& lista, bool& ok) {
    tEstudiante estudiante;
    ifstream archivo;
    char aux;
    lista.contador = 0;
    archivo.open("stock.txt");
    if (!archivo.is_open()) {
        ok = false;
    }
    else {
        ok = true;
        archivo >> estudiante.edad;
        do {
            archivo.get(aux);
            getline(archivo, estudiante.nombre);
            archivo.get(aux);
            archivo >> estudiante.nota;
            archivo.get(aux);
            archivo >> estudiante.unidades;
            archivo.get(aux);
            lista.elementos[lista.contador] = estudiante;
            lista.contador++;
            archivo >> estudiante.edad;
            archivo.get(aux);
        } while ((estudiante.edad != -1) && (lista.contador < MAX));
        archivo.close();
    }
}
void guardar(const tLista& lista) {
    ofstream archivo;
    archivo.open("stock.txt");
    for (int i = 0; i < lista.contador; i++) {
        archivo << lista.elementos[i].edad << endl;
        archivo << lista.elementos[i].nombre << endl;
        archivo << lista.elementos[i].nota << endl;
        archivo << lista.elementos[i].unidades << endl;
    }
    archivo <<-1<< endl;
    archivo.close();
}
void leerEstudiante(tEstudiante& estudiante) {
    system("cls");
    cout << endl << endl << endl;
    cout << "\t\t     -------------------" << endl;
    cout << "\t\t  :::::NUEVO REGISTRO:::::" << endl;
    cout << "\t\t     -------------------" << endl << endl << endl;
    cin.ignore(80, '\n');
    cout << "Nombre del producto: ";
    getline(cin, estudiante.nombre);
    cout << "Codigo del producto: ";
    cin >> estudiante.edad;
    cout << "Precio: ";
    cin >> estudiante.nota;
    cout << "Unidades: ";
    cin >> estudiante.unidades;
    cin.sync();
}
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok) {
    ok = true;
    if (lista.contador == MAX) {
        ok = false;
    }
    else {
        lista.elementos[lista.contador] = estudiante;
        lista.contador++;
    }
}
string nombreCompleto(tEstudiante estudiante) {
    return estudiante.nombre;
}
void mostrarEstudinates(tEstudiante estudiante) {
    cout << setw(6) << right << estudiante.edad << "   ";
    cout << setw(32) << left << nombreCompleto(estudiante);
    cout << setw(4) << right << fixed << setprecision(2) << estudiante.nota << " $ ";
    cout << setw(4) << right << estudiante.unidades << " unidades" << endl;
}
void listado(const tLista& lista) {
    system("cls");
    cout << endl << endl << endl;
    cout << "----------------------------------------------------------------" << endl;
    cout << setw(6) << right << "|CODIGO |" << setw(30) << left << "NOMBRE" << setw(10) << left << "|PRECIO  " << setw(14) << left << "|UNIDADES" << "|" << endl;
    cout << "----------------------------------------------------------------" << endl;
    for (int i = 0; i < lista.contador; i++) {
        mostrarEstudinates(lista.elementos[i]);
    }
    cout << endl << endl;
}
void activototal(const tLista& lista) {
    double suma = 0;
    for (int i = 0; i < lista.contador; i++) {
        suma += (lista.elementos[i].nota * lista.elementos[i].unidades);
    }
    cout << "EL TOTAL DE LOS ACTIVOS ES: " << suma << "$" << endl;
    cout << endl << endl;
}

int main() {
    tLista lista;
    tEstudiante estudiante;
    bool exito;
    int op, pos;
    cargar(lista, exito);
    if (!exito) {
        cout << "No se ha podido cargar la lista" << endl;
    }
    else {
        listado(lista);
        activototal(lista);
        do {//SE CUMPLE EL CODIGO ALMENOS UNA VEZ
            op = menu();
            switch (op) {
            case 1:
            {
                leerEstudiante(estudiante);
                insertarEstudiante(lista, estudiante, exito);
                if (!exito) {
                    cout << "Lista llena: imposible insertar" << endl;
                }
            }
            break;
            case 2:
            {
                listado(lista);
                activototal(lista);
            }
            break;
            case 3: {
                ordenarBurburja(lista, estudiante);
                listado(lista);
            }
            }
        } while (op != 0);
        guardar(lista);
    }
    return 0;
}
void ordenar_productos(tLista& lista)
{
    tEstudiante aux;
    for (int i = 0; i < lista.contador; i++)
    {
        for (int j = i + 1; j < lista.contador; j++)
        {
            if (lista.elementos[i].edad < lista.elementos[j].edad)
            {
                aux = lista.elementos[i];
                lista.elementos[i] = lista.elementos[j];
                lista.elementos[j] = aux;
            }
        }
    }
    cout << endl;
    cout << "SE HAN ORDENADO LOS PRODUCTOS POR CODIGO" << endl;
}

