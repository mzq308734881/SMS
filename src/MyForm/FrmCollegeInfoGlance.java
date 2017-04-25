package MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
public class FrmCollegeInfoGlance extends javax.swing.JFrame {
	//默认选择的行和列为真
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "院系", "简介", "人数", "动态新闻" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
	private  int selectedRow;   //所选择的行
	private  int selectedCol;   //所选择的列
	private int PeopleNum=0;
	private String DepartName;
	private String DepIntroduce;
	private String DepNews;
	
	
	private JLabel jLabel1;
	private JTextField txtDepartName;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTable TCollege;
	private JButton btnDelete;
	private JButton btnFresh;
	private JButton btnAdd;
	private JScrollPane jScrollPane1;
	private JEditorPane txtNews;
	private JLabel jLabel4;
	private JEditorPane txtIntroduce;
	private JTextField txtPeopleNum;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmCollegeInfoGlance inst = new FrmCollegeInfoGlance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmCollegeInfoGlance() {
		super();
		initGUI();
		ShowTable();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u9662\u7cfb\u4fe1\u606f\u7ba1\u7406");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u9662\u7cfb\uff1a");
				jLabel1.setBounds(39, 18, 50, 17);
			}
			{
				txtDepartName = new JTextField();
				getContentPane().add(txtDepartName);
				txtDepartName.setBounds(89, 15, 171, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u4eba\u6570\uff1a");
				jLabel2.setBounds(39, 58, 52, 17);
			}
			{
				txtPeopleNum = new JTextField();
				getContentPane().add(txtPeopleNum);
				txtPeopleNum.setBounds(89, 55, 91, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9662\u7cfb\u7b80\u4ecb\uff1a");
				jLabel3.setBounds(16, 99, 68, 17);
			}
			{
				txtIntroduce = new JEditorPane();
				getContentPane().add(txtIntroduce);
				txtIntroduce.setText("jEditorPane1");
				txtIntroduce.setBounds(87, 99, 173, 115);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u65b0\u95fb\u52a8\u6001\uff1a");
				jLabel4.setBounds(16, 230, 67, 17);
			}
			{
				txtNews = new JEditorPane();
				getContentPane().add(txtNews);
				txtNews.setText("jEditorPane1");
				txtNews.setBounds(85, 228, 174, 122);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(283, 15, 289, 213);
				{
					TCollege = new JTable();
					jScrollPane1.setViewportView(TCollege);
					TCollege.setModel(model);
					TCollege.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							TCollegeMouseClicked(evt);
						}
					});
					GetSelectInfo();
				}
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(283, 282, 67, 24);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnFresh = new JButton();
				getContentPane().add(btnFresh);
				btnFresh.setText("\u5237\u65b0");
				btnFresh.setBounds(388, 282, 69, 24);
				btnFresh.setOpaque(false);
				btnFresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnFreshActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(493, 282, 70, 24);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(600, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	// 单击表格响应事件
	private void TCollegeMouseClicked(MouseEvent evt) {
		PrintInfo();
	}

	//添加学院信息事件
	private void btnAddActionPerformed(ActionEvent evt) {
		try {
			PeopleNum = Integer.parseInt(txtPeopleNum.getText());
			DepartName = txtDepartName.getText();
			DepIntroduce = txtIntroduce.getText();
			DepNews = txtNews.getText();
			Insert(PeopleNum, DepartName, DepNews, DepIntroduce);
			TCollege.repaint(); // 界面重绘
			TCollege.updateUI(); // 更新UI界面
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
	}

	//刷新事件
	private void btnFreshActionPerformed(ActionEvent evt) {
		try {
			PeopleNum = Integer.parseInt(txtPeopleNum.getText());
			DepartName = txtDepartName.getText();
			DepIntroduce = txtIntroduce.getText();
			DepNews = txtNews.getText();
			Update(PeopleNum, DepartName, DepNews, DepIntroduce);
			TCollege.repaint(); // 界面重绘
			TCollege.updateUI(); // 更新UI界面
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
	}
	
	//删除学院信息事件
	private void btnDeleteActionPerformed(ActionEvent evt) {
		DepartName=txtDepartName.getText();
		int i = JOptionPane.showConfirmDialog(null, "是否确认删除该院系？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			if (GetCollegeLimit(DepartName)) {
				JOptionPane.showMessageDialog(this,"该系已有多人选课禁止删除！！！");
			}
			else {
			Delete(DepartName);
			// 清除文本框数据
			txtPeopleNum.setText("");
			txtDepartName.setText("");
			txtIntroduce.setText("");
			txtNews.setText("");
			}

		}
		TCollege.repaint(); // 界面重绘
		TCollege.updateUI(); // 更新UI界面
	}
	
	public void GetSelectInfo()  //得到所选择的行和列的值
	{		
		TCollege.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (ALLOW_ROW_SELECTION) {      // true by default
			ListSelectionModel rowSM = TCollege.getSelectionModel();
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
			TCollege.setRowSelectionAllowed(false);
		}
		if (ALLOW_COLUMN_SELECTION) { // false by default
			if (ALLOW_ROW_SELECTION) {
				// We allow both row and column selection, which
				// implies that we *really* want to allow individual
				// cell selection.
				TCollege.setCellSelectionEnabled(true);
			}
			TCollege.setColumnSelectionAllowed(true);
			ListSelectionModel colSM = TCollege.getColumnModel()
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
		Vector data = ((DefaultTableModel)TCollege.getModel()).getDataVector();
		Vector rowData =(Vector)data.get(selectedRow);
        String field = (String)rowData.get(selectedCol);
        txtDepartName.setText((String)rowData.get(0));
        txtIntroduce.setText((String)rowData.get(1));
        txtPeopleNum.setText((String)rowData.get(2));        
        txtNews.setText((String)rowData.get(3));
        System.out.println("你选择的是："+field);
	}	
	
	// JTable数据表绑定数据库
	public void ShowTable() {
		//String sql = "insert into people values(" + id + ",'" + name+ "','" + introduction + "')";
         try {
        	sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT DDepart,DIntroduce,DPeopleNumber,DNews from T_CollegeInfo");  //再执行查找操作，取出数据集
			FreshTable(rs);   //刷新数据表
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	//当数据库表改变时更新JTable表
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TCollege.getRowCount() > 0) // 删除以前的数据
		{
			for (int i = TCollege.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TCollege.getModel()).removeRow(i);
			}
		}
		try {
			while (rss.next()) {
				Vector<Object> v = new Vector<Object>();
				v.addElement(rss.getString(1));
				v.addElement(rss.getString(2));
				v.addElement(rss.getString(3));
				v.addElement(rss.getString(4));// 总共有7列
				model.addRow(v);
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable异常：" + e.getMessage());
		}
		TCollege.setModel(model);
		validate();
		return count;
	}
	
	//JTable数据表绑定数据库，执行插入操作
	public int Insert(int num,String depart,String news ,String introduce ) {
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="insert into T_CollegeInfo(DDepart,DIntroduce,DPeopleNumber,DNews) Values('"+depart+"','"+introduce+"','"+num+"','"+news+"')";// 插入语句	
			sql.executeUpdate(sqlString);  //先执行插入操作
			ShowTable();
			JOptionPane.showMessageDialog(this, "添加成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "添加异常：" + e.getMessage());
		}
         return n;
	}
	
	//JTable数据表绑定数据库，执行删除操作(删除学生基本信息和学生选课信息)
	public void Delete(String depart ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Delete T_CollegeInfo  where  DDepart='"+depart+"'";// 删除个人信息语句	
			sql.executeUpdate(sqlString);  //先执行删除操作
			
			ShowTable();
			JOptionPane.showMessageDialog(this, "删除成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "删除异常：" + e.getMessage());
		}
	}
	
	//JTable数据表绑定数据库，执行更新操作
	public void Update(int num,String depart , String news ,String introduce ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Update T_CollegeInfo set DPeopleNumber='"+num+"',DIntroduce='"+introduce+"',DNews='"+news+"' where DDepart='"+depart+"' ";// 更新语句			
			sql.executeUpdate(sqlString);  //先执行更新操作
			
			ShowTable();
			JOptionPane.showMessageDialog(this, "更新成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "更新异常：" + e.getMessage());
		}
	}
	
	public boolean GetCollegeLimit(String depart)
	{
		boolean f=false;
		int count=0;
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="select * from T_StudentInfo where CDepart='"+depart+"'";
			rs=sql.executeQuery(sqlString);
			while(rs.next())
			{
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (count>0) {
			f=true;
		}
		return f;
	}
}
