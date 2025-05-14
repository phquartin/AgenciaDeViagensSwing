package view.cliente;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EventObject;

public class ClienteAcoesEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel painel;
    private final JButton btnVisualizar;
    private final JButton btnExcluir;
    private final ClienteView view;

    public ClienteAcoesEditor(ClienteView view) {
        this.view = view;
        painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnVisualizar = new JButton("Visualizar");
        btnExcluir = new JButton("Excluir");

        btnVisualizar.addActionListener(this::visualizar);
        btnExcluir.addActionListener(this::excluir);

        painel.add(btnVisualizar);
        painel.add(btnExcluir);
    }

    private void visualizar(ActionEvent e) {
        // abrir visualização do cliente e pacotes
    }

    private void excluir(ActionEvent e) {
        // lógica para excluir cliente
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return painel;
    }

    public Object getCellEditorValue() {
        return null;
    }

    public boolean isCellEditable(EventObject e) {
        return true;
    }
}

