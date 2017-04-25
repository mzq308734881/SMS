package ButtonHelper;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import MyForm.FrmStuSelectCourse;

public class ButtonColumn extends AbstractCellEditor implements
	TableCellRenderer, TableCellEditor, ActionListener {
	JTable table;
	JButton renderButton;
	JButton editButton;
	String text;

	public ButtonColumn(JTable table, int column) {
		super();
		this.table = table;
		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);


		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer(this);
		columnModel.getColumn(column).setCellEditor(this);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (hasFocus) {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		} else if (isSelected) {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(table.getSelectionBackground());
		} else {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}

		renderButton.setText((value == null) ? " " : value.toString());
		return renderButton;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		text = (value == null) ? " " : value.toString();
		editButton.setText(text);
		return editButton;
	}

	public Object getCellEditorValue() {
		return text;
	}

	public void actionPerformed(ActionEvent e) {
		fireEditingStopped();
		int row=table.getSelectedRow();
		//int column=table.getSelectedColumn();  得到所选的列
		String valueNum= (String)table. getValueAt( row,0) ;
		String valueName=(String)table.getValueAt(row, 1);
		if (editButton.getText().equals("删除")) {
			int i = JOptionPane.showConfirmDialog(null, "是否确认删除该条选课？",
					"提示：", JOptionPane.YES_NO_OPTION);
			if (i == 0) {
				System.out.println(e.getActionCommand() + "   :    "
						+valueNum);
				
				FrmStuSelectCourse frmStuSelectCourse=new FrmStuSelectCourse();
				frmStuSelectCourse.setVisible(true);	
				frmStuSelectCourse.setLocationRelativeTo(null);
				frmStuSelectCourse.Delete(Integer.parseInt(valueNum),valueName);

			}
		}else if (editButton.getText().equals("添加")) {
			int i = JOptionPane.showConfirmDialog(null, "是否确认添加该条选课？",
					"提示：", JOptionPane.YES_NO_OPTION);
			if (i == 0) {
				System.out.println(e.getActionCommand() + "   :    "
						+valueNum);
				//执行添加操作
				FrmStuSelectCourse frmStuSelectCourse=new FrmStuSelectCourse();
				frmStuSelectCourse.setVisible(true);	
				frmStuSelectCourse.setLocationRelativeTo(null);
				frmStuSelectCourse.Insert(Integer.parseInt(valueNum),valueName);
			}
		}
	}
}
