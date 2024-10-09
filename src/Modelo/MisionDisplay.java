/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Diego
 */
public class MisionDisplay {
    private Misiones mision;

    public MisionDisplay(Misiones mision) {
        this.mision = mision;
    }

    public Misiones getMision() {
        return mision; // Este método devuelvve la misión correctamente
    }

  public int getIdMision() {
    return mision != null ? mision.getIdMision() : 0; // Asegúrate de que no sea nulo
}

    @Override
public String toString() {
    return mision.getDescripcionMision(); // O el campo que desees mostrar
}
}


