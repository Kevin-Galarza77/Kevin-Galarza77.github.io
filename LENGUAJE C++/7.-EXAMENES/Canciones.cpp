#include <iostream>
#include <string>
using namespace std;
#include <fstream>
#include <iomanip>

const int N = 10;
typedef struct {
    int numero;
    string titulo;
    string autor;
    string genero;
} tCancion;


typedef struct {
    tCancion canciones[N];
    int contador;
} tLista;

// Prototipos
void mostrarCancion(int pos, tCancion cancion);
void mostrar(tLista lista);
tCancion nuevo();
void insertar(tLista& lista, tCancion cancion, bool& ok);
string insertarGenero();
void eliminar(tLista& lista, int pos, bool& ok); // pos = 1..N
void cargar(tLista& lista, bool& ok);
void guardar(tLista lista);
int menu();
void mostrarPorAutor(tLista lista);

int main() {
    tLista lista;
    bool ok;
    int op, pos;

    cargar(lista, ok);
    if (!ok) {
        cout << "Error al abrir el archivo!" << endl;
    }
    else {
        do {
            op = menu();
            if (op == 1) {
              system("cls");
                tCancion cancion = nuevo();
                insertar(lista, cancion, ok);
                if (!ok) {
                    cout << "Error: Lista llena!" << endl;
                }
            }
            else if (op == 2) {
              system("cls");
                cout << "Posici�n: ";
                cin >> pos;
                eliminar(lista, pos, ok);
                if (!ok) {
                    cout << "Error: Posici�n inexistente!" << endl;
                }
            }
            else if (op == 3) {
              system("cls");
                mostrar(lista);
            }
            else if (op == 4) {
              system("cls");
                mostrarPorAutor(lista);
            }

        } while (op != 0);
        guardar(lista);
    }

    return 0;
}

int menu() {
    cout << endl;
    cout << "1 - Insertar" << endl;
    cout << "2 - Eliminar" << endl;
    cout << "3 - Mostrar la lista" << endl;
    cout << "4 - Mostrar la lista ordenada por autor" << endl;
    cout << "0 - Salir" << endl;
    int op;
    do {
        cout << "Opci�n: ";
        cin >> op;
    } while ((op < 0) || (op > 4));
    return op;
}

void mostrarPorAutor(tLista lista_orginal) {
    tLista listaOrd = lista_orginal;
    for (int i = 1; i < listaOrd.contador; i++) {
        // Desde el segundo elemento hasta el �ltimo
        int pos = i;
        while ((pos > 0) && (listaOrd.canciones[pos - 1].autor > listaOrd.canciones[pos].autor)) {
            // Mientras no se llegue al principio y el anterior sea mayor
            tCancion tmp;
            tmp = listaOrd.canciones[pos];
            listaOrd.canciones[pos] = listaOrd.canciones[pos - 1];
            listaOrd.canciones[pos - 1] = tmp;
            pos--;
        }
    }
    cout << "Despu�s de ordenar:" << endl;
    mostrar(listaOrd);
}

tCancion nuevo() {
    tCancion cancion;
    cin.ignore();
    cout << "Introduce el numero de la cancion: ";
    cin >> cancion.numero;
    cin.ignore();
    cout << "Introduce el titulo de la cancion: ";
    getline(cin, cancion.titulo);
    cout << "Introduce el autor de la cancion: ";
    getline(cin, cancion.autor);
    cancion.genero = insertarGenero();
    return cancion;
}

string insertarGenero() {
    string genero;
    cout << "Seleccione el genero:" << endl;
    cout << "1 - Salsa" << endl;
    cout << "2 - Merengue" << endl;
    cout << "3 - Baladas" << endl;
    cout << "4 - Boleros" << endl;
    cout << "5 - Electronica" << endl;
    cout << "6 - Pop" << endl;

    int op;
    do {
        cout << "Opci�n: ";
        cin >> op;
    } while ((op < 0) || (op > 6));
    
    switch (op)
    {
    case 1:
        genero = "Salsa";
        break;
    case 2:
        genero = "Merengue";
        break;
    case 3:
        genero = "Baladas";
        break;
    case 4:
        genero = "Boleros";
        break;
    case 5:
        genero = "Electronica";
        break;
    case 6:
        genero = "Pop";
        break;
    }
    return genero;
}

void insertar(tLista& lista, tCancion cancion, bool& ok) {
    ok = true;
    if (lista.contador == N) {
        ok = false; // Lista llena
    }
    else {
        int i = 0;
        while ((i < lista.contador) && (lista.canciones[i].numero < cancion.numero)) {
            i++;
        }
        // Insertamos en la posici�n i (primer mayor o igual)
        for (int j = lista.contador; j > i; j--) { // Desplazamos una posici�n a la derecha
            lista.canciones[j] = lista.canciones[j - 1];
        }
        lista.canciones[i] = cancion;
        lista.contador++;
    }
}

void eliminar(tLista& lista, int pos, bool& ok) { // pos = 1, 2, 3, ...
    ok = true;
    if ((pos < 1) || (pos > lista.contador)) {
        ok = false; // Posici�n inexistente
    }
    else {
        pos--; // Pasamos a �ndice del array
        for (int i = pos + 1; i < lista.contador; i++) { // Desplazamos una posici�n a la izquierda
            lista.canciones[i - 1] = lista.canciones[i];
        }
        lista.contador--;
    }
}



void mostrarCancion(int pos, tCancion cancion) {
    cout << setw(3) << cancion.numero
        << setw(20) << cancion.titulo
        << setw(20) << cancion.autor 
        << setw(20) << cancion.genero<< endl;
}

void mostrar(tLista lista) {
    for (int i = 0; i < lista.contador; i++) {
        mostrarCancion(i + 1, lista.canciones[i]);
    }
}

void cargar(tLista& lista, bool& ok) {
    ok = true;
    ifstream archivo;
    lista.contador = 0;
    char aux;
    archivo.open("canciones.txt");
    if (!archivo.is_open()) {
        ok = false;
    }
    else {
        tCancion cancion;
        archivo >> cancion.numero;
        while ((lista.contador < N) && (cancion.numero != -1)) {
            archivo.get(aux);
            getline(archivo, cancion.titulo);
            getline(archivo, cancion.autor);
            archivo >> cancion.genero;
            lista.canciones[lista.contador] = cancion;
            lista.contador++;
            archivo >> cancion.numero;
        }
        archivo.close();
    }
}

void guardar(tLista lista) {
    ofstream archivo;
    archivo.open("canciones.txt");
    for (int i = 0; i < lista.contador; i++) {
        archivo << lista.canciones[i].numero << endl;
        archivo << lista.canciones[i].titulo << endl;
        archivo << lista.canciones[i].autor << endl;
        archivo << lista.canciones[i].genero << endl;
    }
    archivo << -1 << endl;
    archivo.close();
}