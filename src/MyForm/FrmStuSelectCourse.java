package MyForm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import DBHelper.DBUtil;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FrmStuSelectCourse extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel txtSelectable;
	private JLabel jLabel6;
	public JLabel labSelected;
	private JLabel jLabel5;
	private JButton btnSelect;
	public JTextField txtName;
	private JLabel jLabel4;
	public JTextField txtNum;
	private JTable TAllowSelect;
	private JTable TSelected;
	private JLabel jLabel1;
	private JScrollPane jScrollPane2;
	
	Connection con=null;
	Statement sql=null;
	DBUtil dbUtil=new DBUtil();
	ResultSet rs;
	Object header1[] ={"学号", "课程号","课程名", "学分","课时","任课教师","限选人数","已选人数","删除" };
	Object header2[] ={"学号", "课程号","课程名", "学分","课时","任课教师","限选人数","已选人数","添加" };
	Object str[][] = new String[0][0];	
	DefaultTableModel modelA	 = 
					new DefaultTableModel(
							str,
							header1);
	DefaultTableModel modelB	 = 
			new DefaultTableModel(
					str,
					header2);
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStuSelectCourse inst = new FrmStuSelectCourse();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuSelectCourse() {
		super();
		initGUI();
		// 将添加和删除按钮添加到JTable
		if (FrmMain.UserRole == "学生") {
			txtNum.setText(FrmMain.UserNum);
			txtNum.setEnabled(false);
		}
		ButtonColumn buttonsColumnA = new ButtonColumn(TSelected, 8);
		ButtonColumn buttonsColumnB = new ButtonColumn(TAllowSelect, 8);
		try {
			int Num = Integer.parseInt(txtNum.getText());
			ShowTableA(header1, Num);
			ShowTableB(header2, Num);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u9009\u8bfe\u7ba1\u7406");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(27, 86, 588, 168);
				{
					
					TSelected = new JTable(modelA);
					jScrollPane1.setViewportView(TSelected);
					TSelected.setModel(modelA);
					TSelected.setPreferredSize(new java.awt.Dimension(575, 189));
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(27, 283, 588, 171);
				{
					//model = new DefaultTableModel(str,header2);
					TAllowSelect = new JTable(modelB);
					jScrollPane2.setViewportView(TAllowSelect);
					//TAllowSelect.setModel(model);
					TAllowSelect.setBounds(17, 411, 403, 171);
					TAllowSelect.setPreferredSize(new java.awt.Dimension(570, 185));
				}
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5df2\u9009\u8bfe\u7a0b\u5217\u8868\uff1a");
				jLabel1.setBounds(27, 63, 104, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u53ef\u9009\u8bfe\u7a0b\u5217\u8868\uff1a");
				jLabel2.setBounds(27, 260, 97, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5b66\u53f7\uff1a");
				jLabel3.setBounds(24, 24, 56, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u59d3\u540d\uff1a");
				jLabel4.setBounds(231, 23, 56, 17);
			}
			{
				txtName = new JTextField();
				getContentPane().add(txtName);
				txtName.setBounds(287, 20, 129, 24);
			}
			{
				btnSelect = new JButton();
				getContentPane().add(btnSelect);
				btnSelect.setText("\u67e5\u770b\u9009\u8bfe");
				btnSelect.setBounds(441, 20, 97, 24);
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSelectActionPerformed(evt);
					}
				});
			}
			{
				txtNum = new JTextField();
				getContentPane().add(txtNum);
				txtNum.setBounds(80, 21, 121, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u5df2\u9009\u8bfe\u7a0b\u5b66\u5206\uff1a");
				jLabel5.setBounds(152, 63, 100, 17);
			}
			{
				labSelected = new JLabel();
				getContentPane().add(labSelected);
				labSelected.setText("jLabel6");
				labSelected.setBounds(252, 63, 52, 17);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u4e13\u4e1a\u53ef\u9009\u5b66\u5206\uff1a");
				jLabel6.setBounds(341, 63, 93, 17);
			}
			{
				txtSelectable = new JLabel();
				getContentPane().add(txtSelectable);
				txtSelectable.setText("26.5");
				txtSelectable.setBounds(436, 63, 54, 17);
			}
			pack();
			this.setSize(658, 511);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//查看学生选课
	private void btnSelectActionPerformed(ActionEvent evt) {
		//TODO add your code for btnSelect.actionPerformed
		if (txtNum.getText().equals("")||txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "学号或姓名不能为空！");
		}
		else {
			try {
				int Num = Integer.parseInt(txtNum.getText());
				ShowTableA(header1, Num);
				ShowTableB(header2, Num);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "学号或姓名不正确！");
			}
		}
	}
	
	//当添加或删除后需要刷新界面(本来想自动刷新的，
	//本人能力有限加上时间仓促等有时间再行研究)
	private void btnFreshActionPerformed(ActionEvent evt) {
		//TODO add your code for btnFresh.actionPerformed
		btnSelectActionPerformed(evt);		
	}
	
	// JTable已选课数据表绑定数据库
	private void ShowTableA(Object Header[],int num) {
		// String sql = "insert into people values(" + id + ",'" + name+ "','" +
		// introduction + "')";
		try {
			sql = dbUtil.ConnectDB().createStatement();

			rs = sql.executeQuery("SELECT SNum,T_CourseInfo.Cnum,Cname,Ccredit, CClassTime,CTeacherName,ClimitNum ,CNumSelected FROM dbo.T_CourseInfo,dbo.T_SCInfo WHERE T_CourseInfo.CNum=dbo.T_SCInfo.CNum AND dbo.T_SCInfo.SNum="+num+""); // 再执行查找操作，取出数据集
			FreshTableA(rs,Header); // 刷新数据表
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	// JTable可选课数据表绑定数据库
	private void ShowTableB(Object Header[],int num) {
		try {
			sql = dbUtil.ConnectDB().createStatement();

			rs = sql.executeQuery("SELECT distinct SNum, T_CourseInfo.Cnum,Cname,Ccredit, CClassTime,CTeacherName,ClimitNum ,CNumSelected FROM dbo.T_CourseInfo,dbo.T_SCInfo where T_CourseInfo.CNum NOT in(SELECT CNum FROM dbo.T_SCInfo WHERE SNum="+num+") AND dbo.T_SCInfo.SNum="+num+" "); // 再执行查找操作，取出数据集
			FreshTableB(rs,Header); // 刷新数据表
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	//JTable数据表绑定数据库，执行添加操作
	public  int Insert(int num, String name ) {
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="insert into T_ScInfo(SNum,Cnum) VALUES("+num+",'"+name+"')";// 插入语句
 			String sqlUpdate="UPDATE dbo.T_CourseInfo SET CNumSelected=(SELECT COUNT(*) FROM dbo.T_SCInfo WHERE CNum='"+name+"') WHERE dbo.T_CourseInfo. CNum='"+name+"'";//更新选课人数
			sql.executeUpdate(sqlString);  //先执行插入操作
			sql.executeUpdate(sqlUpdate);
			JOptionPane.showMessageDialog(this, "添加成功！");
			
			//添加成功后，刷新数据表
			ShowTableA(header1,num);
			ShowTableB(header2,num);
			this.dispose();
					
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "添加异常：" + e.getMessage());
		}
         return n;
	}
	
	
	
	//JTable数据表绑定数据库，执行删除操作
	public  int Delete(int num, String name ) {
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Delete  T_ScInfo where SNum="+num+" and Cnum='"+name+"'";// 删除语句
 			String sqlUpdate="UPDATE dbo.T_CourseInfo SET CNumSelected=(SELECT COUNT(*) FROM dbo.T_SCInfo WHERE CNum='"+name+"') WHERE dbo.T_CourseInfo. CNum='"+name+"'";//更新选课人数
			sql.executeUpdate(sqlString);  //先执行删除操作
			sql.executeUpdate(sqlUpdate);
			JOptionPane.showMessageDialog(this, "删除成功！");
			
			//添加成功后，刷新数据表
			ShowTableA(header1,num);
			ShowTableB(header2,num);
			this.dispose();
					
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "删除异常：" + e.getMessage());
		}
         return n;
	}
			
	// 当数据库表改变时更新JTable表
	private int FreshTableA(ResultSet rss,Object[] header) {
		int count = 0;
		if (TSelected.getRowCount() > 0) // 删除以前的数据
		{
			for (int i = TSelected.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TSelected.getModel()).removeRow(i);
			}
		}
		try {
			while (rss.next()) {
				Vector<Object> v = new Vector<Object>();
				v.addElement(rss.getString(1));
				v.addElement(rss.getString(2));
				v.addElement(rss.getString(3));
				v.addElement(rss.getString(4));
				v.addElement(rss.getString(5));
				v.addElement(rss.getString(6));
				v.addElement(rss.getString(7)); // 总共有8列
				v.addElement(rss.getString(8));
				v.addElement((header[8]=="删除")?"删除" :"添加");
				modelA.addRow(v);
				count=count+Integer.parseInt(rss.getString(4));
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable异常：" + e.getMessage());
		}
		TSelected.setModel(modelA);
		validate();
		labSelected.setText(""+count);
		return count;
	}
	
	// 当数据库表改变时更新JTable表
	private int FreshTableB(ResultSet rss, Object[] header) {
		int count = 0;
		if (TAllowSelect.getRowCount() > 0) // 删除以前的数据
		{
			for (int i = TAllowSelect.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TAllowSelect.getModel()).removeRow(i);
			}
		}
		try {
			while (rss.next()) {
				Vector<Object> v = new Vector<Object>();
				v.addElement(rss.getString(1));
				v.addElement(rss.getString(2));
				v.addElement(rss.getString(3));
				v.addElement(rss.getString(4));
				v.addElement(rss.getString(5));
				v.addElement(rss.getString(6));
				v.addElement(rss.getString(7)); // 总共有8列
				v.addElement(rss.getString(8));
				v.addElement((header[8] == "删除") ? "删除" : "添加");
				modelB.addRow(v);
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable异常：" + e.getMessage());
		}
		TAllowSelect.setModel(modelB);
		validate();
		return count;
	}
	
	public boolean GetGradeNum(int Snum,String Cnum) {
		boolean f=false;
		int Grade=0;
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="Select COUNT(Grade) from T_SCInfo where Snum="+Snum+" and Cnum='"+Cnum+"'";
			rs=sql.executeQuery(sqlString);
			while (rs.next()) {
				Grade=Integer.parseInt(rs.getString(1).trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (Grade>0) {
			f=true;
		}
		return f;
	}
    //添加表格按钮	
	class ButtonColumn extends AbstractCellEditor implements TableCellRenderer,
			TableCellEditor, ActionListener {
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

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (hasFocus) {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground(UIManager
						.getColor("Button.background"));
			} else if (isSelected) {
				renderButton.setForeground(table.getSelectionForeground());
				renderButton.setBackground(table.getSelectionBackground());
			} else {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground(UIManager
						.getColor("Button.background"));
			}

			renderButton.setText((value == null) ? " " : value.toString());
			return renderButton;
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			text = (value == null) ? " " : value.toString();
			editButton.setText(text);
			return editButton;
		}

		public Object getCellEditorValue() {
			return text;
		}

		public void actionPerformed(ActionEvent e) {
			fireEditingStopped();
			int row = table.getSelectedRow();
			//int column=table.getSelectedColumn(); 得到所选的列
			String valueNum = (String) table.getValueAt(row, 0);
			String valueName = (String) table.getValueAt(row, 1);
			FrmStuSelectCourse frmStuSelectCourse = new FrmStuSelectCourse();
			if (editButton.getText().equals("删除")) {
				int i = JOptionPane.showConfirmDialog(null, "是否确认删除该条选课？",
						"提示：", JOptionPane.YES_NO_OPTION);
				if (i == 0) {	
					System.out.println(e.getActionCommand() + "   :    "
							+ valueNum+valueName);
					// 执行删除操作

					if (GetGradeNum(Integer.parseInt(valueNum.trim()),valueName)) {
						JOptionPane.showMessageDialog(null,"该课程已有成绩禁止删除！！！");
					}
					else {
					// frmStuSelectCourse.setVisible(true);
					frmStuSelectCourse.setLocationRelativeTo(null);
					frmStuSelectCourse.Delete(Integer.parseInt(valueNum),
							valueName);					
					try {
						int Num = Integer.parseInt(txtNum.getText());
						ShowTableA(header1, Num);
						ShowTableB(header2, Num);
					} catch (Exception e1) {
						// TODO: handle exception
					}
				  }
				}
			} else if (editButton.getText().equals("添加")) {
				if (Integer.parseInt(labSelected.getText()) > 23) {
					JOptionPane.showMessageDialog(null, "学分超出禁止添加");
				} else {
					int i = JOptionPane.showConfirmDialog(null, "是否确认添加该条选课？",
							"提示：", JOptionPane.YES_NO_OPTION);
					if (i == 0) {
						System.out.println(e.getActionCommand() + "   :    "
								+ valueNum);

						// 执行添加操作
						//FrmStuSelectCourse frmStuSelectCourse = new FrmStuSelectCourse();
						//frmStuSelectCourse.setVisible(true);
						frmStuSelectCourse.setLocationRelativeTo(null);
						frmStuSelectCourse.Insert(Integer.parseInt(valueNum),valueName);
						try {
							int Num = Integer.parseInt(txtNum.getText());
							ShowTableA(header1, Num);
							ShowTableB(header2, Num);
						} catch (Exception e1) {
							// TODO: handle exception
						}
					}
				}
			}
		}
	}
}
