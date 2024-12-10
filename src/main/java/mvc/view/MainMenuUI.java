package mvc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {

    public MainMenuUI() {
        setTitle("Menú Principal - Gestión de Autos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenuBar();
    }

    private void initMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Opciones");

        JMenuItem crearAutoMenuItem = new JMenuItem("Alta de Auto");
        JMenuItem listarAutosMenuItem = new JMenuItem("Listar Autos");


        crearAutoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCrearAuto();
            }
        });

        listarAutosMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListarAutos();
            }
        });

        menu.add(crearAutoMenuItem);
        menu.add(listarAutosMenuItem);

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private void abrirCrearAuto() {
        CrearAutoUI crearAutoUI = new CrearAutoUI();
        crearAutoUI.setVisible(true);
    }

    private void abrirListarAutos() {
        ListarAutosUI listarAutosUI = new ListarAutosUI();
        listarAutosUI.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuUI mainMenuUI = new MainMenuUI();
            mainMenuUI.setVisible(true);
        });
    }
}
