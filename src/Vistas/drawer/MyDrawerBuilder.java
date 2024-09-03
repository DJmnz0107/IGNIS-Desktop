package Vistas.drawer;

import Vistas.frmAgregarInventario;
import Vistas.frmAgregarTransportes;
import Vistas.frmLogin;
import Vistas.frmVerRegistroTransporter;
import javax.swing.JFrame;
import java.awt.Window;
import java.awt.KeyboardFocusManager;
import javax.swing.JOptionPane;
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
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/Vistas/resources/iconoLogin.png"), 60, 60, 999))
                .setTitle("Ignis")
                .setDescription("ignissoftwaredevelopers@gmail.com");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
             {"~Menu~"},
            {"Dashboard"},
     
            {"Bomberos"},
            {"inventario"},
            {"Calendar"},
            
            {"Transporte"},
            {"Seguimiento"},
            
            {"Estadisticas",},
            {"Emergencias"},
            {"Misiones"},
            {"Informes"},
            {"~Cuenta~"},
            {"Cerrar sesion"},
            {"Inicio"}};

        String icons[] = {
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
            "inicio.svg"};
        
        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("Vistas/drawer/icon")
                .setIconScale(0.45f)
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        Window ventanaActual = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();

                        Class<? extends JFrame> nuevaVentanaClass = null;

                    if (index == 4) {
                        frmAgregarTransportes.initfrmAgregarTransportes();
                       JFrame NuevaVentana = frmAgregarTransportes.getInstance();

                        if (ventanaActual != null && !ventanaActual.equals(NuevaVentana)) {
                            ventanaActual.dispose(); 
                        }
                        ventanaActual = NuevaVentana; 
                    }
                    if(index == 2) {
                        frmAgregarInventario.initfrmAgregarInventario();
                        JFrame nuevaVentana = frmAgregarInventario.getInstance();
                       
                       if (ventanaActual !=null && !ventanaActual.equals(nuevaVentana)) {
                           ventanaActual.dispose();
                       }
                        
                    }
                    if (index==10){
                     int opcion = JOptionPane.showConfirmDialog(ventanaActual, 
                "¿Estás seguro de que deseas cerrar sesión?", 
                "Confirmar Cierre de Sesión", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

               if (opcion == JOptionPane.YES_OPTION) {
               frmLogin.initfrmLogin();
               ventanaActual.dispose();
                }}


                       
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }
                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
                        if (index == 0) {
                            return false;
                        } else if (index == 3) {
                            return false;
                        }
                        return true;
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Java Swing Drawer")
                .setDescription("Version 1.1.0");
    }

    @Override
    public int getDrawerWidth() {
        return 275;
    }
}
