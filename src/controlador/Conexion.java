package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.AlumnoAD;
import static vista.Mensajes.MENSAJES;

public class Conexion {

    private static final File FILE = new File("bd.txt");

    private Conexion() {
    }

    public static ArrayList<AlumnoAD> importarColeccion() {
        ArrayList<AlumnoAD> coleccion = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            if (FILE.exists() && FILE.isFile()) {
                fis = new FileInputStream(FILE);
                ois = new ObjectInputStream(fis);
                coleccion = (ArrayList<AlumnoAD>) ois.readObject();
            }
        } catch (SecurityException ex) {
            JOptionPane.showMessageDialog(null, MENSAJES[0][1]);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, MENSAJES[0][2]);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, MENSAJES[0][2]);
        } finally {
            if (coleccion == null) {
                coleccion = new ArrayList<>();
                JOptionPane.showMessageDialog(null, MENSAJES[0][36]);
            }
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, MENSAJES[0][4]);
            }
        }
        return coleccion;
    }

    public static void exportarColecion(ArrayList<AlumnoAD> coleccionModificada) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if ((FILE.exists() && FILE.isFile()) || !FILE.exists()) {
                fos = new FileOutputStream(FILE);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(coleccionModificada);
            }

        } catch (SecurityException ex) {
            JOptionPane.showMessageDialog(null, MENSAJES[0][5]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, MENSAJES[0][6]);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, MENSAJES[0][7]);
            }
        }
    }

}
