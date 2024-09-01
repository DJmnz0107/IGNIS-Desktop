package Vistas.drawer;

import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import javax.swing.JFrame;
import java.awt.Window;
import java.awt.KeyboardFocusManager;
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
            {"~MAIN~"},
            {"Dashboard"},
            {"~WEB APP~"},
            {"Bomberos"},
            {"Inventario"},
            {"Transporte"},
            {"~COMPONENT~"},
            {"Seguimientp",},
            {"Estadisticas",},
            {"~OTHER~"},
            {"Estadisticas",},
            {"Emergencias",},
            {"Misiones",},
            {"Informes"},
            {"Cerrar sesion"}};

        String icons[] = {
            "dashboard.svg",
            "email.svg",
            "chat.svg",
            "calendar.svg",
            "ui.svg",
            "forms.svg",
            "chart.svg",
            "icon.svg",
            "page.svg",
            "logout.svg",
            "logout.avg"};
        
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

                    if (index == 2) {
                        frmVerRegistroTransporter.initFrmVerRegistroTransportes();
                        JFrame nuevaVentana = frmVerRegistroTransporter.getInstance();

                        if (ventanaActual != null && !ventanaActual.equals(nuevaVentana)) {
                            ventanaActual.dispose(); 
                        }
                        ventanaActual = nuevaVentana; 
                    }


                       
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
