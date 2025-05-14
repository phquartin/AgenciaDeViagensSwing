package view.cliente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class ClienteFormView extends JFrame {
    private JComboBox<String> tipoCombo;
    private JTextField nomeField, emailField, telefoneField, documentoField;
    private JLabel documentoLabel, exemploLabel;
    private JPanel documentoPanel;
    private MaskFormatter mascaraCPF;

    public ClienteFormView() {
        setTitle("Novo Cliente");
        setSize(400, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Definindo o layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        tipoCombo = new JComboBox<>(new String[]{"NACIONAL", "ESTRANGEIRO"});
        nomeField = new JTextField(20);
        emailField = new JTextField(20);
        telefoneField = new JTextField(20);
        documentoField = new JTextField(20);

        documentoLabel = new JLabel("CPF:");
        exemploLabel = new JLabel("Ex: 123.456.789-00");

        documentoPanel = new JPanel(new BorderLayout());
        documentoPanel.add(documentoLabel, BorderLayout.NORTH);
        documentoPanel.add(documentoField, BorderLayout.CENTER);
        documentoPanel.add(exemploLabel, BorderLayout.SOUTH);

        tipoCombo.addActionListener(this::ajustarDocumento);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(this::salvar);

        // Definindo as posições no GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Tipo:"), gbc);

        gbc.gridx = 1;
        add(tipoCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Documento:"), gbc);

        gbc.gridx = 1;
        add(documentoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        add(telefoneField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(salvarBtn, gbc);

        ajustarDocumento(null);
    }

    private void ajustarDocumento(ActionEvent e) {
        String tipo = (String) tipoCombo.getSelectedItem();
        if ("NACIONAL".equals(tipo)) {
            documentoLabel.setText("CPF:");
            exemploLabel.setText("Ex: 123.456.789-00");
            aplicarMascaraDocumento("###.###.###-##");
        } else {
            documentoLabel.setText("Passaporte:");
            exemploLabel.setText("Ex: AB123456");
            removerMascaraDocumento();
        }
    }

    private void aplicarMascaraDocumento(String mascara) {
        try {
            if (mascaraCPF == null) {
                mascaraCPF = new MaskFormatter(mascara);
                mascaraCPF.setPlaceholderCharacter('_');
            }
            mascaraCPF.setMask(mascara);
            mascaraCPF.setValidCharacters("0123456789");
            documentoField.setText("");
            JFormattedTextField formatField = new JFormattedTextField(mascaraCPF);
            formatField.setText(documentoField.getText());
            documentoPanel.remove(documentoField);
            documentoField = formatField;
            documentoPanel.add(documentoField, BorderLayout.CENTER);
            documentoPanel.revalidate();
            documentoPanel.repaint();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void removerMascaraDocumento() {
        JTextField novoCampo = new JTextField();
        documentoPanel.remove(documentoField);
        documentoField = novoCampo;
        documentoPanel.add(documentoField, BorderLayout.CENTER);
        documentoPanel.revalidate();
        documentoPanel.repaint();
    }

    private void salvar(ActionEvent e) {
        // lógica de validação e envio dos dados
        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
    }
}

