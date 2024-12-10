package mvc.view;

import mvc.controller.AutoController;
import mvc.dto.AutoDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class CrearAutoUI extends JFrame {

    private final AutoController autoController;
    private JTextField patenteField;
    private JTextField modeloField;
    private JTextField capacidadField;
    private JTextField precioPorKmField;
    private JCheckBox chkDeportivo;
    private JLabel labelPrecioAdicional;
    private JTextField precioAdicionalField;

    public CrearAutoUI() {
        setTitle("Alta de autos [los 2 tipos ;)]");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        autoController = AutoController.getInstance();
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel patenteLabel = new JLabel("Patente:");
        patenteField = new JTextField();

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloField = new JTextField();

        JLabel capacidadLabel = new JLabel("Capacidad:");
        capacidadField = new JTextField();

        JLabel precioPorKmLabel = new JLabel("Precio por Km:");
        precioPorKmField = new JTextField();

        chkDeportivo = new JCheckBox("¿Es deportivo?");
        labelPrecioAdicional = new JLabel("Precio adicional:");
        precioAdicionalField = new JTextField();

        labelPrecioAdicional.setVisible(false);
        precioAdicionalField.setVisible(false);

        chkDeportivo.addItemListener(e -> {
            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
            labelPrecioAdicional.setVisible(isSelected);
            precioAdicionalField.setVisible(isSelected);
        });

        JButton aceptarButton = new JButton("Aceptar");
        JButton cancelarButton = new JButton("Cancelar");

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarAction();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarAction();
            }
        });

        panel.add(patenteLabel);
        panel.add(patenteField);
        panel.add(modeloLabel);
        panel.add(modeloField);
        panel.add(capacidadLabel);
        panel.add(capacidadField);
        panel.add(precioPorKmLabel);
        panel.add(precioPorKmField);
        panel.add(chkDeportivo);
        panel.add(new JLabel());
        panel.add(labelPrecioAdicional);
        panel.add(precioAdicionalField);
        panel.add(aceptarButton);
        panel.add(cancelarButton);

        add(panel);
    }

    private void aceptarAction() {
        try {
            AutoDTO autoDTO;
            if (chkDeportivo.isSelected()) {
                float precioAdicional = Float.parseFloat(precioAdicionalField.getText());
                autoDTO = new AutoDTO(
                        patenteField.getText(),
                        modeloField.getText(),
                        Integer.parseInt(capacidadField.getText()),
                        Float.parseFloat(precioPorKmField.getText()),
                        precioAdicional
                );
            } else {
                autoDTO = new AutoDTO(
                        patenteField.getText(),
                        modeloField.getText(),
                        Integer.parseInt(capacidadField.getText()),
                        Float.parseFloat(precioPorKmField.getText())
                );
            }
            autoController.crearAuto(autoDTO);
            JOptionPane.showMessageDialog(this, "Auto creado exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarAction() {
        patenteField.setText("");
        modeloField.setText("");
        capacidadField.setText("");
        precioPorKmField.setText("");
        precioAdicionalField.setText("");
        chkDeportivo.setSelected(false);
        labelPrecioAdicional.setVisible(false);
        precioAdicionalField.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CrearAutoUI ui = new CrearAutoUI();
            ui.setVisible(true);
        });
    }
}
