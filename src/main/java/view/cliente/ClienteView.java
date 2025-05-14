package view.cliente;

import view.MainView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClienteView extends JFrame {
    private JTable tabela;

    public ClienteView() {
        setTitle("Clientes");
        setSize(800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnVoltar = new JButton("Voltar");
        JButton btnNovoCliente = new JButton("Novo Cliente");
        btnVoltar.addActionListener(this::voltar);
        btnNovoCliente.addActionListener(this::novoCliente);
        topo.add(btnVoltar);
        topo.add(btnNovoCliente);

        String[] colunas = {"ID", "Nome", "Tipo", "Documento", "Email", "Telefone", "Ações"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        tabela.setRowHeight(30);
        tabela.getColumn("Ações").setCellRenderer(new ClienteAcoesRenderer());
        tabela.getColumn("Ações").setCellEditor(new ClienteAcoesEditor(this));

        add(topo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        carregarClientes(); // mock por enquanto
    }

    private void voltar(ActionEvent e) {
        dispose();
        new MainView().setVisible(true);
    }

    private void novoCliente(ActionEvent e) {
        new ClienteFormView().setVisible(true);
    }

    private void carregarClientes() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        // model.addRow(new Object[]{1, "João da Silva", "NACIONAL", "123.456.789-00", "joao@email.com", "+55 61 99999-0000", "Ações"});
        // model.addRow(new Object[]{2, "Maria Lopez", "ESTRANGEIRO", "XY123456", "maria@exemplo.com", "+34 91234-5678", "Ações"});
    }
}

