#include <iostream>
#include "prototipos.cpp"


int main() {
    int op;
    do {
        op = menugeneral();//MENU GENERAL DONDE SE SELECCIONARA EL QUE HACER
        switch (op)
        {
        case 1://INGRESAR DATOS DE LOS ESTUDIANTES
        {
            datos();
            break;
        }
        case 2://MODIFICAR CUALQUIER COSA DE LOS ESTUDIANTES, DESDE LOS NOMBRES HASTA SU CONDUCTA
        {
            modificar();
            break;
        }
        case 3:
        {
            mostrar();//MOSTRAR TODOS LOS DATOS REGISTRADOS
            break;
        }
        case 4:
        {
            int ord;
            ord = menuordenamiento();//PEDIR POR CUAL ALGORITMO REALIZAR EL ORDENAMIENTO
            switch (ord) {
                //LA FUNCION ESTA CON EL NOMBRE DE CADA ALGORITMO DE ORDENAMIENTO
                //SEGUIDO DE LA PRESENTACION DE LAS NOTAS EN ORDEN
            case 1:
            {
                burbuja(estudiantes, docente.numeroest);
                presentarcalificaciones();
                break;
            }
            case 2:
            {
                seleccion(estudiantes, docente.numeroest);
                presentarcalificaciones();
                break;
            }
            case 3:
            {
                inserccion(estudiantes, docente.numeroest);
                presentarcalificaciones();
                break;
            }

            case 4:
            {
                dividir(estudiantes, 0, docente.numeroest - 1);
                presentarcalificaciones();
                break;
            }
            case 5:
            {
                ordenar(estudiantes, 0, docente.numeroest - 1);
                presentarcalificaciones();
                break;
            }
            case 6:
            {
                HeapSort(estudiantes, docente.numeroest);
                presentarcalificaciones();
                break;
            }
            default:
            {
                cout << endl << "\t\t\t\tOPCION INCORRECTA." << endl << endl;
            }
            }
            break;
        }
        case 5:
        {
            int buscar;
            do {
                buscar = menubusqueda();//MENU PARA BUSCAR MEDIANTE EL  ALGORITMO QUE SE INTRODUZCA
                switch (buscar) {
                    //CADA FUNCION TIENE LE NOMBRE DE SU ALGORIRMO
                    //LA FUNCION cantidadabuscar-->hace la funcion de buscar al alumno con esa nota final ingresada por el usuario
                case 1:
                {
                    lineal(estudiantes, docente.numeroest, cantidadabuscar());
                    break;
                }
                case 2:
                {
                    busqueda_binaria(estudiantes, docente.numeroest, cantidadabuscar());
                    break;
                }
                case 3:
                {
                    interpol(estudiantes, docente.numeroest, cantidadabuscar());
                    break;
                }
                }

            } while (buscar != 0);
        }
        default:
            break;
        }
    } while (op != 0);
    //GUARDAMOS LOS DATOS INGRESADOS
    guardar();
    guardarordenamiento();
    return 0;
}

