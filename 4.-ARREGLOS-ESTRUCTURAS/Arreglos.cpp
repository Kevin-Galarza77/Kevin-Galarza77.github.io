#include<iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;
void iniciar(int guardar[]);
int lanzar();
void game(int guardar[]);
void imprimir(int guardar[]);
const int veces = 36000;
const int Max = 50;
void calificaciones();
void agregar(double lista[]);
void buscar(double lista[], double dato);
void ordenar(double a[]);
void eliminar(double a[]);
void insertar(double a[]);
int contador = 0;
void pediradatos();
void inversoo(int x[]);
void impresion();
int lista[Max], lista2[Max], lista3[Max], contador2;
double lista5[Max];
const int Maxx = 20;
void duplicado(int lista[]);
void procesounico(int Inicial[], int Aux[], int Final[]);
const int MAX = 20;
int main() {
    int opcionprograma;
    do{
        cout << "  ***BIENVENIDO***" << endl;
        cout << "\tMENU:" << endl;
        cout << "1.-Calificaciones." << endl;
        cout << "2.-Palindromo." << endl;
        cout << "3.-Duplicados." << endl;
        cout << "4.-Dados." << endl;
        cout << "5.-Salir." << endl;
        cout << "SELECIONA: ";
        cin >> opcionprograma;
        switch (opcionprograma) {
        case 1:
        {
            system("cls");
            int op;
            calificaciones();
            agregar(lista5);
            do{
                system("cls");
                cout << "OPCIONES: " << endl;
                cout << "\t1.-Agregar mas calificaciones." << endl;
                cout << "\t2.-Buscar una calificacion." << endl;
                cout << "\t3.-Elimminar una calificacion." << endl;
                cout << "\t4.-Ordenar las calificaciones." << endl;
                cout << "\t5.-Insertar una calificacion." << endl;
                cout << "\t6.-Salir." << endl;
                cout << "SELECCIONE: ";
                cin >> op;
                switch (op)
                {
                case 1:
                    if (contador < 50) {
                        agregar(lista5);
                    }
                    else {
                        cout << "MAXIMO ALCANZADO." << endl;
                    }
                    break;
                case 2:
                    int dato;
                    cout << "\t\tIngresa la calificacion a buscar: ";
                    cin >> dato;
                    buscar(lista5, dato);
                    break;
                case 3:
                    eliminar(lista5);
                    break;
                case 4:
                    ordenar(lista5);
                    break;
                case 5:
                    insertar(lista5);
                    break;
                case 6:
                    cout << "\t***|GRACIAS|***" << endl;
                    contador = 0;
                    break;
                default:
                    cout << "Opcion incorrecta. Intenta nuevamente." << endl;
                }
            } while (op != 6);
            contador = 0;
            op = 0;


            break;
        }
        case 2:
        {
            system("cls");
            cout << "\t\t*****PROGRAMA 2*****" << endl;
            pediradatos();
            inversoo(lista);
            impresion();
            for (int i = 0; i < contador2; i++) {
                lista3[i] = 0;
            }
            contador = 0;

            break;
        }
        case 3:
        {
            system("cls");
            int arreglo1[MAX], arreglo2[MAX], arreglo3[MAX];
            procesounico(arreglo1, arreglo2, arreglo3);
            for (int i = 0; i < MAX; i++) {
                arreglo1[i] = 0;
            }
            break;
        }
        case 4:
        {
            system("cls");
            int x[11];
            srand(time(0));
            iniciar(x);
            game(x);
            imprimir(x);
            break;
        }
        case 5:
        {
            system("cls");
            cout << "\t\tMUCHAS GRACIAS" << endl;
            break;
        }
        default:
        {
            system("cls");
            cout << "Opcion incorrecta. Intenta denuevo" << endl;
        }
        }
    }while (opcionprograma != 5);
}
void calificaciones()
{
    cout << "\t    ***BIENVENIDO***" << endl;
    cout << "\tSISTEMA DE CALIFICACIONES" << endl;
    cout << "INGRESO DE CALIFICACIONES (0-10) " << endl << "(Ingresa solamente el -1 para dejar de ingresar mas calificaciones)" << endl;
}
void agregar(double lista[])
{
    int calif, x;
    do
    {
        do {
            cout << "Ingresa la calificacion Numero " << contador + 1 << ": ";
            cin >> lista[contador];
            if (lista[contador] > 10 || lista[contador] < -1) {
                cout << "El rango de calificaciones es del 0 al 10." << endl;
                cout << "Ingresa nuevamente: " << endl;
            }
        } while (lista[contador] > 10 || lista[contador] < -1);
        if (lista[contador] == -1)
        {
            lista[contador] = lista[contador];
            x = lista[contador];
        }
        else
        {
            x = lista[contador];
            contador++;
        }
    }while (x != -1 && contador < Max);
}
void buscar(double lista[], double dato)
{
    bool c = false;
    for (int i = 0; i < contador; i++)
    {
        if (lista[i] == dato and lista[i] < 11)
        {
            cout << "\t\t\t**DATO ENCONTRADO**" << endl;
            cout << "\t\tLa calificacion esta en la posicion: " << i + 1 << endl;
            c = true;
        }
    }
    if (c == false)
    {
        cout << "\t\tLa calificacion no existe." << endl;
    }
    else {
        cout << "\t\tPosiciones de las calificaciones:" << endl;
        for (int i = 0; i < contador; i++) {
            cout << "\t\t\tCalificacion " << i + 1 << ":";
            if (lista[i]<11 && lista[i]>-1) {
                cout << "[" << lista[i] << "]" << endl;
            }
            else {
                cout << "---" << endl;
            }
        }
    }
}

void ordenar(double a[])
{
    int i, j, aux;
    for (i = 0; i < contador; i++)
    {
        for (j = i + 1; j < contador; j++)
        {
            if (a[j] <= a[i])
            {
                aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
    }
    cout << "\t\tLas calificaciones en orden son:" << endl;
    for (int i = 0; i < contador; i++)
    {

        if (a[i]<11 && a[i]>-1) {
            cout << "\t\t\tCalificacion " << i + 1 << ": [" << a[i] << "]" << endl;
        }
    }
}

void eliminar(double a[])
{
    int eliminar;
    cout << "\t\tLas calificaciones son: " << endl;
    for (int i = 0; i < contador; i++)
    {
        cout << "\t\t\tCalificacion " << i + 1 << ":";
        if (a[i]<11 && a[i]>-1) {
            cout << "[" << a[i] << "]" << endl;
        }
        else {
            cout << "---" << endl;
        }
    }
    cout << "\t\tIngresa la posicion de la calificacion que deseas eliminar: ";
    cin >> eliminar;
    cout << "\t\tDATOS ACTUALIZADOS:" << endl;
    a[eliminar - 1] = 12;
    for (int i = 0; i < contador; i++)
    {
        cout << "\t\t\tCalificacion " << i + 1 << ":";
        if (a[i]<11 && a[i]>-1) {
            cout << "[" << a[i] << "]" << endl;
        }
        else {
            cout << "---" << endl;
        }
    }
}
void insertar(double a[])
{
    bool c = false;
    int dato;
    cout << "\t\tLas calificaciones son:" << endl;
    for (int i = 0; i < contador; i++)
    {
        cout << "\t\t\tCalificacion " << i + 1 << ":";
        if (a[i]<11 && a[i]>-1) {
            cout << "[" << a[i] << "]" << endl;
        }
        else {
            cout << "---" << endl;
        }
    }
    int x;
    cout << "\t\tInserta la posicion de la calificacion a modificar: ";
    cin >> dato;
    if (dato > contador) {
        cout << "\t\tLa posicion no existe." << endl;
    }
    else {
        x = a[dato - 1];
        cout << "\t\tIngresa la nueva calificacion: ";
        cin >> a[dato - 1];
        if (a[dato - 1] > 10 || a[dato - 1] < 0) {
            cout << "\t\tIngresa la calificacion en el rango solicitado" << endl;
            a[dato - 1] = x;
        }
        cout << "\t\tDATOS ACTUALIZADOS:" << endl;
        for (int i = 0; i < contador; i++)
        {
            cout << "\t\t\tCalificacion " << i + 1 << ":";
            if (a[i]<11 && a[i]>-1) {
                cout << "[" << a[i] << "]" << endl;
            }
            else {
                cout << "---" << endl;
            }
        }
    }
}
void pediradatos() {
    cout << "\tCuantos numeros vas a ingresar: ";
    cin >> contador2;
    for (int i = 0; i < contador2; i++) {
        cout << "Ingrese el numero " << i + 1 << ":";
        cin >> lista[i];
        lista2[i] = lista[i];
    }
}
void inversoo(int x[]) {
    int resto;
    for (int i = 0; i < contador2; i++) {
        while (lista[i] > 0) {
            resto = lista[i] % 10;
            lista[i] = lista[i] / 10;
            lista3[i] = lista3[i] * 10 + resto;
        }
    }
}
void impresion() {
    cout << "\tDATOS INGRESADOS;" << endl;
    for (int i = 0; i < contador2; i++) {
        if (lista2[i] == lista3[i]) {
            cout << "\t\t[" << lista2[i] << "]-->" << "Palindrommo." << endl;
        }
        else {
            cout << "\t\t[" << lista2[i] << "]-->" << "No es un Palindrommo." << endl;
        }
    }
    cout << "\t  **|GRACIAS|**" << endl;
}

void iniciar(int guardar[]) {
    for (int i = 0; i < 11; i++) {
        guardar[i] = 0;
    }


}
int lanzar() {
    return (rand() % 6) + 1;
}
void game(int guardar[]) {
    int datos1;
    for (int i = 0; i < veces; i++) {
        datos1 = lanzar() + lanzar();
        guardar[datos1 - 2]++;
    }
}
void imprimir(int guardar[]) {
    cout << "\t***LANZAMIENTO DE UN DADO**" << endl;
    for (int i = 0; i < 11; i++) {
        cout << "\t\t[" << i + 2 << "]-->[" << guardar[i] << "]" << endl;
    }
}
void procesounico(int Inicial[], int Aux[], int Final[]) {
    int n, i, j = 0, z = 0, k, cont, num;

    cout << "\tBIENVENIDO" << endl;
    cout << "Numeros 10-100" << endl;

    for (i = 0; i < MAX; i++)
    {
        do {
            cout << "Ingresa el numero " << i + 1 << ": ";
            cin >> Inicial[i];
            if (Inicial[i] < 10 || Inicial[i]>100) {
                cout << "Ingresa un numero en el rango solicitado." << endl;
            }
        } while (Inicial[i] < 10 || Inicial[i]>100);
    }

    for (i = 0; i < MAX; i++)
    {
        cont = 0;

        num = Inicial[i];

        Aux[j] = num;

        j++;

        for (k = 0; k < MAX; k++)
        {
            if (Aux[k] == num)
            {
                cont++;
            }
        }

        if (cont == 1)
        {
            Final[z] = num;

            z++;
        }
    }

    cout << "\tLISTA DE NUMEROS SIN REPETIRSE" << endl;

    for (i = 0; i < z; i++)
    {
        cout << "[" << Final[i] << "]";
    }
    cout << endl;
    cont = 0;
}

