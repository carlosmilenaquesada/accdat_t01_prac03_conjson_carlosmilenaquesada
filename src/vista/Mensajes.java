package vista;

public class Mensajes {

    public static final String[][] MENSAJES = initMensajes();

    public static String[][] initMensajes() {
        String[][] mensajes = new String[1][41];
        mensajes[0][0] = "No tiene permisos para manipular el fichero."
                + " Se cerrará el programa.";

        mensajes[0][1] = "Fichero no encontrado o ilegible."
                + " No se pueden los cargar datos.";

        mensajes[0][2] = "Fichero ilegible."
                + " No se pueden los cargar datos.";

        mensajes[0][3] = "Fichero inaccesible."
                + " No se pueden los cargar datos.";

        mensajes[0][4] = "Ocurrió un problema."
                + "\nEs posible que los datos no se carguen correctamente";

        mensajes[0][5] = "No tiene permisos para manipular el fichero."
                + "\nSe perderá la información guardada.";

        mensajes[0][6] = "Fichero innaccesible."
                + "\nSe perderá la información guardada.";

        mensajes[0][7] = "Ocurrió un problema."
                + "\nEs posible que los datos no se guarden correctamente";

        mensajes[0][37] = "El archivo contiene información corrupta o incompatible con JSON.";

        mensajes[0][9] = "El archivo está vacío, no hay nada que leer.";

        mensajes[0][36] = "Actualmente no existe fichero de dato o es ilegible."
                + "\nSe creará uno automáticamente cuando se guarden los cambios.";
        mensajes[0][40] = "Ocurrió un problema y no se pudo exportar el fichero.";
                
        
        mensajes[0][8] = "Algunos campos contienen"
                + " información no válida";

        mensajes[0][10] = "Debe introducir un número de matrícula válido.";
        mensajes[0][11] = "No existe ningún alumno con esa matrícula.";
        mensajes[0][12] = "Introduzca una matrícula válida.";
        mensajes[0][13] = "Seleccione una matrícula de la lista.";
        mensajes[0][14] = "No existe ningún alumno con esa matrícula.";

        mensajes[0][16] = "Debe elegir una matrícula de la lista.";
        mensajes[0][17] = "Indique primero una matrícula para modificar al alumno.";

        mensajes[0][20] = "El número de matrícula elegido ya expiró.";
        mensajes[0][21] = "Se borrarán de la base de datos todos los alumnos que aparecen en la tabla,"
                + "\n¿desea continuar?";
        mensajes[0][22] = "Inserte alumnos en la tabla para empezar a borrar";
        mensajes[0][23] = "Se perderán todos los cambios que no hayan sido guardados."
                + "\n¿Desea deshacer los cambios y volver al estado inicial?";
        mensajes[0][24] = "Se dispone a salir del programa sin guardar ningún cambio. "
                + "¿Está seguro?";
        mensajes[0][25] = "Se dispone a guardar todo los cambios realizados hasta ahora."
                + "\nEste proceso es IRREVERSIBLE. También se saldrá del programa."
                + " ¿Desea continuar?";
        mensajes[0][26] = "¿Está seguro?";

        mensajes[0][27] = "El alumno: \n";
        mensajes[0][28] = "\nHa sido modificado correctamente";
        mensajes[0][29] = "Ya existe un alumno con el"
                + " número de matrícula: ";
        mensajes[0][30] = "." + "\nNo se puede crear el alumno. Pruebe otro número de matrícula.";
        mensajes[0][35] = "¿Desea salir del programa? \nSe perderán los cambios que no haya guardado.";

        mensajes[0][31] = "Borrado de alumnos";
        mensajes[0][32] = "Deshacer cambios";
        mensajes[0][33] = "Salir del programa";
        mensajes[0][34] = "Salir y guardar";
        mensajes[0][38] = "Debe seleccionar algún registro para exportar el archivo JSON";
        mensajes[0][39] = "Exportación realizada con éxito";

        return mensajes;

    }

}
