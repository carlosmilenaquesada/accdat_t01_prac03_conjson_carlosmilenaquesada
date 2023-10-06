package modelo;

import java.io.Serializable;

public class AlumnoAD implements Serializable {

    //DECLARACIÓN DE VARIABLES
    //--------------------------------------------------------------------------
    private int nMatricula;
    private String nombre;
    private float not1Ev, nota2Ev, notaFinal, notaExtra;

    //CONSTRUCTORES
    //--------------------------------------------------------------------------
    //Por defecto
    public AlumnoAD() {
        nMatricula = Integer.MIN_VALUE;
        nombre = null;
        not1Ev = nota2Ev = notaFinal = notaExtra = 0f;
    }

    //Por parámetros
    public AlumnoAD(int nMatricula, String nombre, float not1Ev, float nota2Ev,
            float notaFinal, float notaExtra) {
        this.nMatricula = nMatricula;
        this.nombre = nombre;
        this.not1Ev = not1Ev;
        this.nota2Ev = nota2Ev;
        this.notaFinal = notaFinal;
        this.notaExtra = notaExtra;
    }

    //SETTERS
    //--------------------------------------------------------------------------
    public void setNMatricula(int nMatricula) {
        this.nMatricula = nMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNot1Ev(float not1Ev) {
        this.not1Ev = not1Ev;
    }

    public void setNota2Ev(float nota2Ev) {
        this.nota2Ev = nota2Ev;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public void setNotaExtra(float notaExtra) {
        this.notaExtra = notaExtra;
    }

    //GETTERS
    //--------------------------------------------------------------------------
    public int getNMatricula() {
        return this.nMatricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getNot1Ev() {
        return this.not1Ev;
    }

    public float getNota2Ev() {
        return this.nota2Ev;
    }

    public float getNotaFinal() {
        return this.notaFinal;
    }

    public float getNotaExtra() {
        return this.notaExtra;
    }

    //SOBRECARGAS
    //--------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        boolean esIgual = false;
        if (o instanceof AlumnoAD) {
            AlumnoAD alumnoAD = (AlumnoAD) o;
            if (this.nMatricula == alumnoAD.nMatricula) {
                esIgual = true;
            }
        }
        return esIgual;
    }

    @Override
    public int hashCode() {
        return this.nMatricula;
    }

    @Override
    public String toString() {
        return "Matrícula: " + this.nMatricula
                +"\nNombre: " + this.nombre
                + "\nNota 1ª evaluación: " + this.not1Ev
                + "\nNota 2ª evaluación: " + this.nota2Ev
                + "\nNota final: " + this.notaFinal
                + "\nNota extra: " + this.notaExtra;

    }
}
