import java.util.ArrayList;
import java.util.Scanner;

public class ideaAdrianna {
    public static void main(String[] args) {
        // Declaración de un array bidimensional para calificaciones (5 estudiantes, 3 asignaturas)
        int[][] calificaciones = new int[5][3];


        // Inicialización de calificaciones (solo un ejemplo)
        calificaciones[0][0] = 85;
        calificaciones[0][1] = 90;
        calificaciones[0][2] = 78;


        // Acceso a las calificaciones (ejemplo: estudiante 1, asignatura 2)
        int calificacionEstudiante1Asignatura2 = calificaciones[0][1];


        // Imprimir calificación
        System.out.println("La calificación del estudiante 1 en la asignatura 2 es: " + calificacionEstudiante1Asignatura2);
    }

}
