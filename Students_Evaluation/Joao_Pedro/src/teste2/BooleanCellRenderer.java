package teste2;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

public class BooleanCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setText((Boolean.TRUE.equals(value)) ? "Sim" : "Não");
        return this;
    }
}
