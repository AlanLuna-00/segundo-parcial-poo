package mvc.view;

import mvc.controller.AutoController;
import mvc.dto.AutoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarAutosUI extends JFrame {

    private final AutoController autoController;
    private JTable table;
    private DefaultTableModel tableModel;

    public ListarAutosUI() {
        setTitle("Para que me creas que existen autos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        autoController = AutoController.getInstance();
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Patente", "Modelo", "Capacidad", "Precio por Km", "Precio Adicional"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        List<AutoDTO> autosDTO = autoController.listarAutos();

        for (AutoDTO auto : autosDTO) {
            Object[] rowData = {
                    auto.getPatente(),
                    auto.getModelo(),
                    auto.getCapacidad(),
                    auto.getPrecioPorKm(),
                    auto.getPrecioAdicional() != null ? auto.getPrecioAdicional() : "N/A"
            };
            tableModel.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListarAutosUI ui = new ListarAutosUI();
            ui.setVisible(true);
        });
    }
}
