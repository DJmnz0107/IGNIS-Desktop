/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Diego
 */
public class BomberoDisplay {
    
    private Bomberos bombero;

    public BomberoDisplay(Bomberos bombero) {
        this.bombero = bombero;
    }

    @Override
    public String toString() {
        return bombero.getNombreCompleto(); // Mostrar el nombre completo
    }

    public Bomberos getBombero() {
        return bombero;
    }
    
    public int getId_bombero() {
        return bombero.getId_bombero(); // Método para obtener el ID del bombero
    }
}
