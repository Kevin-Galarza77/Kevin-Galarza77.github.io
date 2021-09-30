#include <iostream>
#include <stdio.h>
#include<math.h>
using namespace std;
void pedirdatostaylor();
double procesotaylor(double respuestataylor);
void segundo_despues(int x, int y, int z);
void segundo_despuesprocesoeimpresion(int x, int y, int z);
float hipotenusa();
void pedirdatoscubo();
void procesocubo(int x);
void comprobacioncubo(int x, int y);
void pediradatos();
int inversoo(int x);
void impresion();
void calculohora(int x);
void datos();
int calculomin(int x);
int calculototal();
int num, resto, inverso, num2;
int numcub, numcub2 = numcub, igualdadcub, hora, minu, seg, seg1, seg2, seg3;
int h, m, s;
double x;
int main() {
    int op;
   do{
        cout << "****BIENVENIDO****" << endl;
        cout << "SELECCIONE EL PROGRAMA A EJECUTAR" << endl;
        cout << "1.-PROGRAMA 1." << endl;
        cout << "2.-PROGRAMA 2." << endl;
        cout << "3.-PROGRAMA 3." << endl;
        cout << "4.-PROGRAMA 4." << endl;
        cout << "5.-PROGRAMA 5." << endl;
        cout << "6.-PROGRAMA 6." << endl;
        cout << "7.-Salir" << endl;
        cout << "Ingrese: ";
        cin >> op;
        switch (op) {
        case 1:
            system("cls");
            cout << "*****PROGRAMA 1*****" << endl;
            pedirdatostaylor();
            cout << "La respuesta en serie de Taylor es: " << procesotaylor(x) << endl;
            break;
        case 2:
            system("cls");
            cout << "*****PROGRAMA 2*****" << endl;
            cout << "**La hora un segundo despues**" << endl;
            segundo_despues(h, m, s);
            segundo_despuesprocesoeimpresion(h, m, s);
            break;
        case 3:
            system("cls");
            //Entiendo que haga un programa para calcular por pitagoras la hipotenusa de tres triangulos rectangulos.
            cout << "*****PROGRAMA 3*****" << endl;
            cout << "**Teorema de pitagoras de 3 triangulos**" << endl;
            float contador, d;
            contador = 1;
            while (contador <= 3) {
                system("cls");
                cout << "*** Triangulo numero " << contador << " ***" << endl;
                d = hipotenusa();
                cout << "La hipotenusa es: " << d << endl;
                contador = contador + 1;
            }
            break;
        case 4:
            system("cls");
            //Pido al usuario qe ingrese el numero, ya que si mostraba todos los numeros, el bucle fuera infinito;
            cout << "*****PROGRAMA 4*****" << endl;
            pedirdatoscubo();
            procesocubo(numcub);
            comprobacioncubo(numcub, igualdadcub);
            igualdadcub = 0;
            break;
        case 5:
            system("cls");
            cout << "*****PROGRAMA 5*****" << endl;
            cout << "**Funcion inversa**" << endl;
            pediradatos();
            inversoo(num);
            impresion();
            inverso = 0;
            break;
        case 6:
            system("cls");
            cout << "*****PROGRAMA 6*****" << endl;
            datos();
            calculohora(hora);
            cout << "El total de los segundos transcurridos desde las 12 del medio dia son: " << calculototal() << " segundos." << endl;
            break;
        case 7:
            system("cls");
            cout << "*****Gracias*****" << endl;
            op = 7;
            break;
        default:
            system("cls");
            cout << "Ejercicio seleccionado incorrecto. Pruebe con otro.";
            break;
        }
    }while (op != 7);
}
void datos() {
    cout << "**Tiempo Transcurrido en segundos**" << endl;
    cout << "Ingrese los siguientes datos(Ejemplo:15:30:06)): " << endl;
    cout << "Hora: ";
    cin >> hora;
    cout << "Minutos: ";
    cin >> minu;
    cout << "Segundos: ";
    cin >> seg;
}
void calculohora(int x) {
    int retornohor;
    if (x == 12) {
        seg1 = 0;
    }
    else {
        if (x > 12 && x < 24) {
            retornohor = x - 12;
            seg1 = retornohor * 3600;
        }
        else {
            if (x < 12 && x>0) {
                retornohor = (x - 12) + 24;
                seg1 = retornohor * 3600;
            }
            else {
                cout << "Hora incorrecta" << endl;
            }
        }
    }
}
int calculomin(int x) {
    int seg2;
    if (x <= 60 && x >= 0) {
        seg2 = x * 60;
    }
    else {
        cout << "Minutos incorrectos" << endl;
    }
    return seg2;
}
int calculototal() {
    int total;
    total = seg1 + calculomin(minu) + seg;
    return total;
}
void pediradatos() {
    cout << "ingrese el numero: ";
    cin >> num;
    num2 = num;
}
int inversoo(int x) {
    while (num > 0) {
        resto = num % 10;
        num = num / 10;
        inverso = inverso * 10 + resto;
    }
    return inverso;
}
void impresion() {
    if (inverso == num2) {
        cout << "El numero es capicua ya que " << num2 << " es igual al su invertido " << inverso << endl;
    }
    else {
        cout << "El inverso es: " << inverso << endl;
    }
}
void pedirdatoscubo() {
    cout << "**Comprobacion de si un numero es igual a la suma de sus digitos al cubo**" << endl;
    cout << "Ingrese: ";
    cin >> numcub;
}
void procesocubo(int x) {
    int i, cifras[10];
    i = 0;
    while (x > 0) {
        cifras[i] = x % 10;
        x = x / 10;
        i++;
    }
    for (int s = i - 1; s >= 0; s--) {
        igualdadcub = igualdadcub + pow(cifras[s], 3);
    }
    cout << numcub << "=" << igualdadcub << endl;
}
void comprobacioncubo(int x, int y) {
    if (x == y) {
        cout << "El numero si es igual a la suma de los cubos de sus digitos" << endl;
    }
    else {
        cout << "El numero no es igual a la suma de los cubos de sus digitos" << endl;
    }
}
float hipotenusa() {
    float l1, l2;
    float hipotenusa, c;
    cout << "Ingrese el Lado 1: ";
    cin >> l1;
    cout << "Ingrese el Lado 2: ";
    cin >> l2;
    c = pow(l1, 2) + pow(l2, 2);
    hipotenusa = sqrt(c);
    return hipotenusa;
}
void pedirdatostaylor() {
    cout << "*****BIENVENIDO*****" << endl;
    cout << "**Calculo de la funcion exponencial mediante Taylor**" << endl;
    cout << "La formula es: e^x--->Ingrese el valor de x: ";
    cin >> x;
}
double procesotaylor(double respuestataylor) {
    double repeticion, exponente, denominador, i, division, total, respuesta;
    i = 0;
    repeticion = 1;
    denominador = 1;
    total = 0;
    while (repeticion <= 10) {
        i = i + 1;
        exponente = pow(respuestataylor, i);
        denominador = denominador * i;
        division = exponente / denominador;
        total = total + division;
        repeticion = repeticion + 1;
    }
    respuesta = 1 + total;
    return respuesta;
}
void segundo_despues(int x, int y, int z) {
    cout << "Introduzca horas: " << endl;
    cin >> h;
    cout << "Introduzca minutos: " << endl;
    cin >> m;
    cout << "Introduzca segundos: " << endl;
    cin >> s;
}
void segundo_despuesprocesoeimpresion(int x, int y, int z) {
    if (x >= 0 && x <= 23 && y >= 0 && y <= 59 && z >= 0 && z <= 59)
    {
        z++;
        if (z == 60)
        {
            z = 00;
            y++;
            if (y == 60)
            {
                y = 00;
                x++;
                if (x == 24)
                    x = 0;
            }
        }
        cout << "Un segundo despues la hora es: " << x << ":" << y << ":" << z << endl;
    }
    else
        cout << "ERROR: La hora es incorrecta." << endl;
}
