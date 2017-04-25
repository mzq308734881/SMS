package MyForm;
import DBHelper.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
public class FrmStudentInfoManage extends javax.swing.JFrame {
	//默认选择的行和列为真
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "学号", "名字", "性别", "出生年月", "所在系","身份证号","个人简介" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
	private  int selectedRow;   //所选择的行
	private  int selectedCol;   //所选择的列
    private int Num;
    private String Name ;
    private String Sex ;
    private String Birth;
    private String Depart;
    private String Id;
    private String Introduce;
    
	private JTable TStudentInfo;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField txtSex;
	private JTextField txtDepart;
	private JScrollPane jScrollPane1;
	private JButton btbFresh;
	private JButton btnDelete;
	private JButton btnUpdate;
	public JButton btnAdd;
	private JEditorPane jEditorPane1;
	private JLabel jLabel7;
	private JTextField txtSid;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JTextField txtSbirthday;
	private JLabel jLabel4;
	public JTextField txtSname;
	public JTextField txtSnum;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStudentInfoManage inst = new FrmStudentInfoManage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStudentInfoManage() {
		super();
		initGUI();
		txtSnum.setEnabled(false);
		ShowTable();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5b66\u53f7\uff1a");
				jLabel1.setBounds(29, 12, 52, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d\uff1a");
				jLabel2.setBounds(27, 55, 52, 17);
			}
			{
				txtSnum = new JTextField();
				getContentPane().add(txtSnum);
				txtSnum.setBounds(81, 9, 130, 24);
			}
			{
				txtSname = new JTextField();
				getContentPane().add(txtSname);
				txtSname.setBounds(81, 52, 130, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6027\u522b\uff1a");
				jLabel3.setBounds(27, 98, 54, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u51fa\u751f\u5e74\u6708\uff1a");
				jLabel4.setBounds(234, 12, 66, 17);
			}
			{
				txtSbirthday = new JTextField();
				getContentPane().add(txtSbirthday);
				txtSbirthday.setBounds(300, 9, 114, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6240\u5728\u7cfb\uff1a");
				jLabel5.setBounds(246, 55, 54, 17);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
				jLabel6.setBounds(234, 98, 66, 17);
			}
			{
				txtSid = new JTextField();
				getContentPane().add(txtSid);
				txtSid.setBounds(300, 95, 114, 24);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u4e2a\u4eba\u7b80\u4ecb\uff1a");
				jLabel7.setBounds(437, 12, 73, 17);
			}
			{
				jEditorPane1 = new JEditorPane();
				getContentPane().add(jEditorPane1);
				jEditorPane1.setBounds(437, 35, 235, 84);
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(591, 149, 74, 24);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnUpdate = new JButton();
				getContentPane().add(btnUpdate);
				btnUpdate.setText("\u4fee\u6539");
				btnUpdate.setBounds(591, 204, 74, 24);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUpdateActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(591, 265, 74, 24);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btbFresh = new JButton();
				getContentPane().add(btbFresh);
				btbFresh.setText("\u5237\u65b0");
				btbFresh.setBounds(591, 320, 74, 24);
				btbFresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btbFreshActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(27, 136, 545, 213);
				{
					TStudentInfo = new JTable();
					jScrollPane1.setViewportView(TStudentInfo);
					//TStudentInfo.setModel(TStudentInfoModel);
					TStudentInfo.setModel(model);
					TStudentInfo.setBounds(301, 131, 113, 176);
					TStudentInfo.setPreferredSize(new java.awt.Dimension(526, 345));
					TStudentInfo.setSize(400, 405);
					GetSelectInfo();
					
					TStudentInfo.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							TStudentInfoMouseClicked(evt);
						}
					});
				}
			}
			{
				txtDepart = new JTextField();
				getContentPane().add(txtDepart);
				txtDepart.setBounds(300, 52, 114, 24);
			}
			{
				txtSex = new JTextField();
				getContentPane().add(txtSex);
				txtSex.setBounds(81, 94, 63, 24);
			}
			pack();
			this.setSize(700, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}	
		
	private void TStudentInfoMouseClicked(MouseEvent evt) {	
		PrintInfo();
	}
	
	public void GetSelectInfo()  //得到所选择的行和列的值
	{		
		TStudentInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (ALLOW_ROW_SELECTION) {      // true by default
			ListSelectionModel rowSM = TStudentInfo.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No rows are selected. ");
					} else {
					    selectedRow = lsm.getMinSelectionIndex();
						System.out.println("Row " + selectedRow
								+ " is now selected. ");
					}
				}
			});
		}
		else {
			TStudentInfo.setRowSelectionAllowed(false);
		}
		if (ALLOW_COLUMN_SELECTION) { // false by default
			if (ALLOW_ROW_SELECTION) {
				// We allow both row and column selection, which
				// implies that we *really* want to allow individual
				// cell selection.
				TStudentInfo.setCellSelectionEnabled(true);
			}
			TStudentInfo.setColumnSelectionAllowed(true);
			ListSelectionModel colSM = TStudentInfo.getColumnModel()
					.getSelectionModel();
			colSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No columns are selected. ");
					} else {
					    selectedCol = lsm.getMinSelectionIndex();
						System.out.println("Column " + selectedCol
								+ " is now selected. ");
					}
				}
			});
		}
	}
	
	//输出对应行的信息并映射到文本框中
	public void PrintInfo()
	{
		Vector data = ((DefaultTableModel)TStudentInfo.getModel()).getDataVector();
		Vector rowData =(Vector)data.get(selectedRow);
        String field = (String)rowData.get(selectedCol);
        txtSnum.setText((String)rowData.get(0));
        txtSname.setText((String)rowData.get(1));
        txtSbirthday.setText((String)rowData.get(3));        
        txtSex.setText((String)rowData.get(2));
        jEditorPane1.setText((String)rowData.get(6));
        txtSid.setText((String)rowData.get(5));
        txtDepart.setText((String)rowData.get(4));

        System.out.println("你选择的是："+field);
	}
	
	//更新表格中的数据	
	private void btbFreshActionPerformed(ActionEvent evt) {
		System.out.println("btbFresh.actionPerformed, event="+evt);
		//TODO add your code for btbFresh.actionPerformed
		ShowTable();
		JOptionPane.showMessageDialog(this, "刷新成功！");
		TStudentInfo.repaint();  //界面重绘
		TStudentInfo.updateUI();  //更新UI界面
	}
	//向表格添加数据，先向数据库添加然后显示到Table中
	private void btnAddActionPerformed(ActionEvent evt) {
		Vector data = model.getDataVector();
		//Num=txtSnum.getText();
		Name=txtSname.getText();
		Sex=txtSex.getText();
		Birth=txtSbirthday.getText();
		Depart=txtDepart.getText();
		Id=txtSid.getText();
		Introduce=jEditorPane1.getText();

		// 显示新增加的学号
		try {
			txtSnum.setText("");
			Vector rowData = (Vector) data.get(Insert(Name, Sex, Birth, Depart,Id, Introduce)-1);
			txtSnum.setText((String)rowData.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"显示异常:"+e .getMessage());
		}
        
		TStudentInfo.repaint();  //界面重绘
		TStudentInfo.updateUI();  //更新UI界面
	}
	
	//更改表格数据，先向数据库更改然后显示到Table中
	private void btnUpdateActionPerformed(ActionEvent evt) {
		//TODO add your code for btnUpdate.actionPerformed
		Num=Integer.parseInt(txtSnum.getText()) ;
		Name=txtSname.getText();
		Sex=txtSex.getText();
		Birth=txtSbirthday.getText();
		Depart=txtDepart.getText();
		Id=txtSid.getText();
		Introduce=jEditorPane1.getText();
		Update(Num,Name,Sex,Birth,Depart,Id,Introduce);	
		TStudentInfo.repaint();  //界面重绘
		TStudentInfo.updateUI();  //更新UI界面
	}
	
	//删除表格数据，先向数据库删除然后显示到Table中
	private void btnDeleteActionPerformed(ActionEvent evt) {
		//TODO add your code for btnDelete.actionPerformed
		Num=Integer.parseInt(txtSnum.getText());
		int i = JOptionPane.showConfirmDialog(null, "是否确认删除该学生个人信息和选课信息？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			if (GetGradeNum(Num)) {
				JOptionPane.showMessageDialog(this,"该学生已有成绩禁止删除！！");
			}
			else {
			Delete(Num);
			// 清除文本框数据
			txtSnum.setText("");
			txtDepart.setText("");
			txtSbirthday.setText("");
			txtSex.setText("");
			txtSid.setText("");
			txtSname.setText("");
			jEditorPane1.setText("");
			}

		}
		TStudentInfo.repaint(); // 界面重绘
		TStudentInfo.updateUI(); // 更新UI界面
	}

	// JTable数据表绑定数据库
	public void ShowTable() {
		//String sql = "insert into people values(" + id + ",'" + name+ "','" + introduction + "')";
         try {
        	 sql = dbUtil.ConnectDB().createStatement();
			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo");  //再执行查找操作，取出数据集
			FreshTable(rs);   //刷新数据表
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	//JTable数据表绑定数据库，执行插入操作
	public int Insert(String name,String sex,String birth,String depart,String id ,String introduce ) {
		//String sql = "insert into people values(" + id + ",'" + name+ "','" + introduction + "')";
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="insert into T_StudentInfo(Sname,Ssex,SBirthday,CDepart,SIdNumber ,SIntroduce) Values('"+name+"','"+sex+"','"+birth+"','"+depart+"','"+id+"','"+introduce+"')";// 插入语句
 			//String sqlString="insert into T_StudentInfo(CDepart) Values('"+depart+"')";// 插入语句			
			sql.executeUpdate(sqlString);  //先执行插入操作
			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex,convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo");  //再执行查找操作，取出数据集
			n=FreshTable(rs);   //刷新数据表
			JOptionPane.showMessageDialog(this, "添加成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "添加异常：" + e.getMessage());
		}
         System.out.println("n="+n);
         return n;
	}
	
	//JTable数据表绑定数据库，执行更新操作
	public void Update(int num, String name,String sex,String birth,String depart,String id ,String introduce ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			//String sqlString="insert into T_StudentInfo(Sname,Ssex,SBirthday,CDepart,SIdNumber ,SIntroduce) Values('"+name+"','"+sex+"','"+birth+"','"+depart+"','"+id+"','"+introduce+"')";// 插入语句
 			String sqlString="Update T_StudentInfo set Sname='"+name+"',Ssex='"+sex+"',SBirthday='"+birth+"',CDepart='"+depart+"',SIdNumber='"+id+"',SIntroduce='"+introduce+"' where Snum="+num+"";// 更新语句			
			sql.executeUpdate(sqlString);  //先执行更新操作
			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex,convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo");  //再执行查找操作，取出数据集
			FreshTable(rs);   //刷新数据表
			JOptionPane.showMessageDialog(this, "更新成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "更新异常：" + e.getMessage());
		}
	}
	
	//JTable数据表绑定数据库，执行删除操作(删除学生基本信息和学生选课信息)
	public void Delete(int num) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
        	sqlSC=dbUtil.ConnectDB().createStatement();
 			//String sqlString="insert into T_StudentInfo(Sname,Ssex,SBirthday,CDepart,SIdNumber ,SIntroduce) Values('"+name+"','"+sex+"','"+birth+"','"+depart+"','"+id+"','"+introduce+"')";// 插入语句
 			//String sqlString="Update T_StudentInfo set Sname='"+name+"',Ssex='"+sex+"',SBirthday='"+birth+"',CDepart='"+depart+"',SIdNumber='"+id+"',SIntroduce='"+introduce+"' where Snum="+num+"";// 更新语句	
 			String sqlString="Delete T_StudentInfo  where Snum="+num+"";// 删除个人信息语句	
 			String sqlSCInfo="Delete T_SCInfo where Snum="+num+"";  //删除学生选课信息
			sql.executeUpdate(sqlString);  //先执行删除操作
			sqlSC.executeUpdate(sqlSCInfo);
			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex,convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo");  //再执行查找操作，取出数据集
			FreshTable(rs);   //刷新数据表
			JOptionPane.showMessageDialog(this, "删除成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "删除异常：" + e.getMessage());
		}
	}
	
	
	//当数据库表改变时更新JTable表
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TStudentInfo.getRowCount() > 0) // 删除以前的数据
		{
			for (int i = TStudentInfo.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TStudentInfo.getModel()).removeRow(i);
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
				v.addElement(rss.getString(7)); // 总共有7列
				model.addRow(v);
				count++;
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable异常：" + e.getMessage());
		}
		TStudentInfo.setModel(model);
		validate();
		return count;
	}
	
	public boolean GetGradeNum(int num) {
		boolean f=false;
		int Grade=0;
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="Select COUNT(Grade) from T_SCInfo where Snum="+num+"";
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
}
