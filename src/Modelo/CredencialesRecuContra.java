
 
package Modelo;

/**
 *
 * @author USUARIO
 */
public class CredencialesRecuContra {

    /**
     * @return the UUID_usuario
     */
    public String getUUID_usuario() {
        return UUID_usuario;
    }

    /**
     * @param UUID_usuario the UUID_usuario to set
     */
    public void setUUID_usuario(String UUID_usuario) {
        this.UUID_usuario = UUID_usuario;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the Clave
     */
    public String getClave() {
        return Clave;
    }

    /**
     * @param Clave the Clave to set
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    private String UUID_usuario;
    private String Correo;
    private String Clave;
}
