package view.cliente;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ClienteAcoesRenderer extends JPanel implements TableCellRenderer {
    public ClienteAcoesRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        add(new JButton("Visualizar"));
        add(new JButton("Excluir"));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

