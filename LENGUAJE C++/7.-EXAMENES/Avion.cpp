#include <iostream>
#include <string>
#include <ctime>
using namespace std;
int menu();
void proces1();
void proces2();
void mostrar();
int asientospri = 0;
int asientosseg = 5, ac = 0, acx = 5;
int a[10];
int main() {
    int opcion;
    do {
        opcion = menu();
        switch (opcion)
        {
        case 1:
        {
            proces1();
            break;
        }
        case 2:
        {
            proces2();
            break;
        }
        case 3:
        {
            mostrar();
            break;
        }
        }

    } while (opcion != 0);
}
int menu() {
    int op;
    cout << endl << endl << endl;
    cout << "\t\t\tAEROLINEAS ECUADOR" << endl;
    cout << "1.-PRIMERA CLASE." << endl;
    cout << "2.-SEGUNDA CLASE" << endl;
    cout << "3.-MOSTRAR" << endl;
    cout << "0.-Salir" << endl;
    cin >> op;
    return op;
}
void proces1() {
    string asien;
    int x = asientospri + 1, y;
    bool ax = false;
    if (asientospri < 5) {
        for (int i = asientospri; i < x; i++) {
            srand(time(0));
            y = (rand() % 5) + 1;
            cout << "Has obtenido el asiento " << y << endl;
            cout << "Lo aceptas? s/n: ";
            cin >> asien;
            system("cls");
            for (int j = 0; j < 5; j++) {
                if (a[j] == y)
                {
                    ax = true;
                }
            }
        }
        if (asien == "s") {
            if (ax == true) {
                cout << "\t\tASIENTO NO DISPONIBLE" << endl;
            }
            else {
                a[ac] = y;
                cout << "------------------------------------------------" << endl;
                cout << "PERSONA NUMERO " << ac + 1 << endl;
                cout << "ASIENTO: " << y << endl;
                cout << "------------------------------------------------" << endl;
                asientospri += 1;
                ac += 1;
            }
        }
    }
    else {
        system("cls");
        cout << endl << endl;
        cout << "YA NO HAY ASIENTOS DISPONIBLES EN 1RA CLASE" << endl;
        cout << "EL PROXIMO VUELO SALE EN 3 HORAS" << endl;
    }
}
void proces2() {
    string asien;
    int x = asientosseg + 1, y;
    bool ax = false;
    if (asientosseg < 10 && asientosseg>4) {
        for (int i = asientosseg; i < x; i++) {
            srand(time(0));
            y = (rand() % 5) + 6;
            cout << "Has obtenido el asiento " << y << endl;
            cout << "Lo aceptas? s/n: ";
            cin >> asien;
            system("cls");
            for (int j = 5; j < 10; j++) {
                if (a[j] == y)
                {
                    ax = true;
                }
            }
        }
        if (asien == "s") {
            if (ax == true) {
                cout << "\t\tASIENTO NO DISPONIBLE" << endl;
            }
            else {
                a[acx] = y;
                cout << "------------------------------------------------" << endl;
                cout << "PERSONA NUMERO " << acx + 1 << endl;
                cout << "ASIENTO: " << y << endl;
                cout << "------------------------------------------------" << endl;
                asientosseg += 1;
                acx += 1;
            }
        }
    }
    else {
        system("cls");
        cout << endl << endl;
        cout << "YA NO HAY ASIENTOS DISPONIBLES EN 1RA CLASE" << endl;
        cout << "EL PROXIMO VUELO SALE EN 3 HORAS" << endl;
    }
}
void mostrar() {
    system("cls");
    cout << "\t\t\t" << endl;
    cout << "\t\t-----------------------" << endl;
    cout << "\t\t: LISTADO DE PASAJES  :" << endl;
    cout << "\t\t-----------------------" << endl;
    for (int i = 0; i < 10; i++) {
        cout << "PERSONA NUMERO " << i + 1 << " :" << endl;
        cout << "ASIENTO " << a[i] << endl;
        cout << "----------------------------------" << endl;
    }
}
