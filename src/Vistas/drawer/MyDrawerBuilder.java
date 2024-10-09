package Vistas.drawer;

import Controlador.ctrlLogin;
import static Controlador.ctrlLogin.nombreUsuario;
import Modelo.Usuarios;
import Vistas.frmAgregarAspirante;
import Vistas.frmAgregarBomberos;
import Vistas.frmAgregarInventario;
import Vistas.frmAgregarMision;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerEstadisticas;
import Vistas.frmInicio;
import Vistas.frmLogin;
import Vistas.frmVerEmergencias;
import Vistas.frmVerInformes;
import Vistas.frmVerRegistroTransporter;
import javax.swing.JFrame;
import java.awt.Window;
import java.awt.KeyboardFocusManager;
import java.util.function.Supplier;
import javax.swing.JOptionPane;
import raven.drawer.Drawer;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;

public class MyDrawerBuilder extends SimpleDrawerBuilder {
    
    


    @Override
    public SimpleHeaderData getSimpleHeaderData() {
                                    String usuario = ctrlLogin.nombreUsuario;      
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/Vistas/resources/ignisCompleto.png"), 60, 60, 999))
                .setTitle("Bienvenido a IGNIS")
                .setDescription("Hola, " + usuario);
    }

     // Opciones del menú del Drawer
   @Override
public SimpleMenuOption getSimpleMenuOption() {
    String[][] menus = {
        {"~Menu~"},
        {"Dashboard"},
        {"Bomberos"},
        {"Inventario"},
        {"Calendar"},
        {"Transporte"},
        {"Seguimiento"},
        {"Estadisticas"},
        {"Emergencias"},
        {"Misiones"},
        {"Informes"},
        {"~Cuenta~"},
        {"Cerrar sesion"},
        {"Inicio"}
    };

    String[] icons = {
        "dashboard.svg",
        "firefighter1.svg",
        "manguera.svg",
        "calendar.svg",
        "fire-truck.svg",
        "seguimiento.svg",
        "staticircle.svg",
        "emergencia.svg",
        "mision.svg",
        "informe.svg",
        "logout_1.svg",
        "inicio.svg"
    };

    return new SimpleMenuOption()
            .setMenus(menus)
            .setIcons(icons)
            .setBaseIconPath("Vistas/drawer/icon")
            .setIconScale(0.45f)
            .addMenuEvent(new MenuEvent() {
                @Override
                public void selected(MenuAction action, int index, int subIndex) {
                    // Lógica de selección de menú
                    gestionarSeleccionDeMenu(index);
                }
            })
          .setMenuValidation(new MenuValidation() {
    @Override
    public boolean menuValidation(int index, int subIndex) {
        int nivelUsuario = Usuarios.nivelUsuario;

        // Deshabilitar las opciones de los índices 0 y 3 para todos los niveles
        if (index == 0 || index == 3) {
            return false; // Deshabilitar el menú del índice 0 y 3
        }

      if (nivelUsuario == 4) {
            // Si el nivel es 4, habilitar solo las opciones permitidas
            return index == 2 || index == 4 || index == 10 || index == 11; // Habilitar Bomberos, Transporte, Cerrar sesión, Inicio
        }
        
        // Habilitar todo para otros niveles
        return true; // Habilitar todas las opciones para otros niveles
    }
});


}

    
private JFrame abrirVentana(Class<? extends JFrame> ventanaClass) {
    JFrame instancia = null;

    try {
        instancia = ventanaClass.getDeclaredConstructor().newInstance();
        instancia.setVisible(false);  // No mostrar todavía la ventana
    } catch (Exception e) {
        e.printStackTrace();  // Para ver si hay algún problema al crear la ventana
    }

    return instancia;
}

private void gestionarSeleccionDeMenu(int index) {
      Window ventanaActual = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
    JFrame nuevaVentana = null;

    switch (index) {
        
        case 1:  // Bomberos
            frmAgregarBomberos.initfrmAgregarBomberos();
                ventanaActual.dispose();
            break;
            
        case 2:  // Inventario
            frmAgregarInventario.initfrmAgregarInventario();
                ventanaActual.dispose();
            break;
            
        case 5:  // Transporte
            frmAgregarAspirante.initfrmAgregarAspirante();
            ventanaActual.dispose();
        break;

        case 4:  // Transporte
            frmAgregarTransportes.initFrmAgregarTransportes();
                ventanaActual.dispose();
            break;

        case 6: // Estadisticas
            frmVerEstadisticas.InitfrmVerEstadisticas();
                ventanaActual.dispose();
            break;
            
        case 7:  // Emergencias
            frmVerEmergencias.initfrmVerEmergencias();
                ventanaActual.dispose();
            break;
         
        case 8:  // Misiones
            frmAgregarMision.initFrmAgregarMision();
            ventanaActual.dispose();
            break;
        
        case 9:  // Informes
            frmVerInformes.initfrmVerInformes();
            ventanaActual.dispose();
            break;

        case 10:  // Cerrar sesión
            if (confirmarCierreSesion(ventanaActual)) {
                frmLogin.initfrmLogin();
                ventanaActual.dispose();
            }
            break;

        case 11:  // Inicio
            frmInicio.initfrmInicio();
              ventanaActual.dispose();
            break;

        default:
            System.out.println("Menú no manejado: " + index);
            break;
    }

    // Llama a cambiarVentana solo si hay una nueva ventana
    if (nuevaVentana != null) {
        cambiarVentana(ventanaActual, nuevaVentana);
    }
}

private void cambiarVentana(Window ventanaActual, JFrame nuevaVentana) {
    if (ventanaActual instanceof JFrame) {
        System.out.println("Cerrando ventana actual: " + ventanaActual.getClass().getSimpleName());
        ((JFrame) ventanaActual).dispose();  // Cierra la ventana actual
    }
    nuevaVentana.setVisible(true);  // Aquí se muestra la nueva ventana
}












    // Método para confirmar el cierre de sesión
private boolean confirmarCierreSesion(Window ventanaActual) {
    Object[] opciones = {"Sí", "No"}; // Opciones en español
    int opcion = JOptionPane.showOptionDialog(
        ventanaActual,
        "¿Estás seguro de que deseas cerrar sesión?",
        "Confirmar Cierre de Sesión",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[0] // Establecer "Sí" como opción predeterminada
    );

    return opcion == 0; // Devuelve true si se seleccionó "Sí"
}


    @Override
public SimpleFooterData getSimpleFooterData() {
    return new SimpleFooterData()
            .setTitle("IGNIS DEVELOPERS ©") 
            .setDescription("Version 1.1.0");
}

    @Override
    public int getDrawerWidth() {
        return 275;
    }
}
