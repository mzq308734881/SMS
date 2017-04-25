package MyForm;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import DBHelper.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FrmScoreInfoManage extends javax.swing.JFrame {
	
    Object header[] = { "选课学生", "学号", "课程号", "课程名", "学分","学时","成绩" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
	
	private JScrollPane jScrollPane1;
	public JComboBox cobCourse;
	private JLabel jLabel2;
	private JLabel jLabel3;
	public JLabel labTeacherName;
	private JLabel jLabel8;
	public JLabel labTeacherNum;
	private JLabel jLabel7;
	private JToolBar jToolBar1;
	private JTable TSC;
	private JTextField txtSelectedNum;
	private JLabel jLabel6;
	private JTextField txtLimitNum;
	private JLabel jLabel5;
	private JTextField txtClassTime;
	private JLabel jLabel4;
	private JTextField txtCredits;
	private JTextField txtCourseNum;
	private JButton btnCancle;
	private JButton btnSubmit;
	private JButton btnSave;
	private JLabel jLabel1;
	private JButton btnEntry;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmScoreInfoManage inst = new FrmScoreInfoManage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmScoreInfoManage() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 136, 458, 201);
				{
					/*TableModel TSCModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });*/
					TSC = new JTable();
					jScrollPane1.setViewportView(TSC);
					TSC.setModel(model);
				}
			}
			{
				btnEntry = new JButton();
				getContentPane().add(btnEntry);
				btnEntry.setText("\u5f55\u5165");
				btnEntry.setBounds(497, 57, 62, 24);
				btnEntry.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEntryActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bfe\u7a0b\u540d\uff1a");
				jLabel1.setBounds(20, 22, 64, 22);
			}
			{
				ComboBoxModel cobCourseModel = 
						new DefaultComboBoxModel(
								new String[] { "","Item One", "Item Two" });
				cobCourse = new JComboBox();
				getContentPane().add(cobCourse);
				cobCourse.setModel(cobCourseModel);
				cobCourse.setBounds(84, 20, 137, 24);
				cobCourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cobCourseActionPerformed(evt);
					}
				});
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(497, 179, 62, 24);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSaveActionPerformed(evt);
					}
				});
			}
			{
				btnSubmit = new JButton();
				getContentPane().add(btnSubmit);
				btnSubmit.setText("\u63d0\u4ea4");
				btnSubmit.setBounds(497, 236, 62, 24);
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSubmitActionPerformed(evt);
					}
				});
			}
			{
				btnCancle = new JButton();
				getContentPane().add(btnCancle);
				btnCancle.setText("\u53d6\u6d88");
				btnCancle.setBounds(497, 296, 62, 24);
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancleActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u8bfe\u7a0b\u53f7\uff1a");
				jLabel2.setBounds(20, 64, 62, 17);
			}
			{
				txtCourseNum = new JTextField();
				getContentPane().add(txtCourseNum);
				txtCourseNum.setBounds(86, 61, 135, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5b66\u5206\uff1a");
				jLabel3.setBounds(32, 104, 50, 17);
			}
			{
				txtCredits = new JTextField();
				getContentPane().add(txtCredits);
				txtCredits.setBounds(86, 101, 135, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u8bfe\u65f6\uff1a");
				jLabel4.setBounds(271, 24, 47, 17);
			}
			{
				txtClassTime = new JTextField();
				getContentPane().add(txtClassTime);
				txtClassTime.setBounds(316, 20, 129, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u9650\u9009\u4eba\u6570\uff1a");
				jLabel5.setBounds(248, 64, 68, 17);
			}
			{
				txtLimitNum = new JTextField();
				getContentPane().add(txtLimitNum);
				txtLimitNum.setBounds(316, 61, 129, 24);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u5df2\u9009\u4eba\u6570\uff1a");
				jLabel6.setBounds(248, 104, 68, 17);
			}
			{
				txtSelectedNum = new JTextField();
				getContentPane().add(txtSelectedNum);
				txtSelectedNum.setBounds(316, 101, 129, 24);
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1);
				jToolBar1.setBounds(0, 356, 584, 25);
				{
					jLabel7 = new JLabel();
					jToolBar1.add(jLabel7);
					jLabel7.setText("\u6559\u5e08\u53f7\uff1a");
					jLabel7.setPreferredSize(new java.awt.Dimension(86, 17));
				}
				{
					labTeacherNum = new JLabel();
					jToolBar1.add(labTeacherNum);
					labTeacherNum.setText("    jLabel8");
					labTeacherNum.setPreferredSize(new java.awt.Dimension(58, 17));
				}
				{
					jLabel8 = new JLabel();
					jToolBar1.add(jLabel8);
					jLabel8.setText("    \u6559\u5e08\u540d\uff1a");
				}
				{
					labTeacherName = new JLabel();
					jToolBar1.add(labTeacherName);
					labTeacherName.setText("   jLabel9");
				}
			}
			pack();
			this.setSize(600, 420);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//当关闭窗体的时候提示是否关闭
	private void thisWindowClosing(WindowEvent evt) {
		// TODO add your code for this.windowClosing
		int i = JOptionPane.showConfirmDialog(null, "是否退出？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			dispose();
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	//当ComboBox显示示该教师讲授的所有课程，选中一门课，展示课程信息和学生选课信息
	private void cobCourseActionPerformed(ActionEvent evt) {

		String cname=(String)cobCourse.getSelectedItem();
		if (cname.trim().equals("")) {
			txtClassTime.setText("");
			txtCourseNum.setText("");
			txtCredits.setText("");
			txtLimitNum.setText("");
			txtSelectedNum.setText("");
		}
		ShowCourseInfo(cname);  //展示课程信息
		ShowSCInfo();         //展示学生选该门课的信息
		TSC.setEnabled(false);
	}
	
	//执行录入
	private void btnEntryActionPerformed(ActionEvent evt) {
		 //TSC.setEditingColumn(6);
         TSC.setEnabled(true);     
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
         JOptionPane.showMessageDialog(this, "保存成功！");
         TSC.repaint();  //界面重绘
         TSC.updateUI();   //更新UI界面
	}
	
	private void btnSubmitActionPerformed(ActionEvent evt) {
		int i = JOptionPane.showConfirmDialog(null, "是否确定录入？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
             save();
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void btnCancleActionPerformed(ActionEvent evt) {
          dispose();
	}
	
	//选一门课展示课程信息
	public void ShowCourseInfo(String cname)
	{
        try {
        	sql = dbUtil.ConnectDB().createStatement();
			rs = sql.executeQuery("SELECT CNum,Ccredit,CclassTime,CLimitNum,CNumSelected FROM dbo.T_CourseInfo WHERE Cname='"+cname+"'");  //再执行查找操作，取出数据集
			while (rs.next()) {
				txtCourseNum.setText(rs.getString(1));
				txtCredits.setText(rs.getString(2));
				txtClassTime.setText(rs.getString(3));
				txtLimitNum.setText(rs.getString(4));
				txtSelectedNum.setText(rs.getString(5));
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	//选一门课展学生选课信息
	public void ShowSCInfo()
	{
		String cname=(String)cobCourse.getSelectedItem();
        try {
       	    sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT SName,T_StudentInfo.Snum,T_SCInfo.Cnum,Cname,Ccredit,CClasstime,Grade FROM dbo.T_CourseInfo,dbo.T_SCInfo,dbo.T_StudentInfo WHERE T_StudentInfo.Snum=T_SCInfo.SNum AND T_CourseInfo.Cnum=T_SCInfo.CNum AND T_CourseInfo.CName='"+cname+"' ORDER BY dbo.T_SCInfo.SNum");  //再执行查找操作，取出数据集
			FreshTable(rs);   //刷新数据表
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}
	}
	
	//当数据库表改变时更新学生选课JTable表
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TSC.getRowCount() > 0) // 删除以前的数据
		{
			for (int i = TSC.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TSC.getModel()).removeRow(i);
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
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable异常：" + e.getMessage());
		}
		TSC.setModel(model);
		validate();
		return count;
	}
	
	//保存修改后的提交 
	public void save() {
		int snum=0;
		int grade;
		String cnum="";
		boolean f=true;
		try {
			for (int i = 0; i < TSC.getRowCount(); ++i) {
				grade = Integer.parseInt((String) TSC.getValueAt(i, 6));
				System.out.println("成绩："+grade);
				if (grade<0||grade>100) {
                    JOptionPane.showMessageDialog(this,"录入的成绩应在0-100之间");
                    f=false;
                    ShowSCInfo();  //录入成功刷新选课表
                    break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常：录入成绩的格式不对！");
		}
		if (f) {
			grade=0;
			try {
				for (int i = 0; i < TSC.getRowCount(); ++i) {
					snum = Integer.parseInt((String) TSC.getValueAt(i, 1));
					grade = Integer.parseInt((String) TSC.getValueAt(i, 6));
					cnum=(String) TSC.getValueAt(i, 2);
					sql=dbUtil.ConnectDB().createStatement();
					String updaString="UPDATE dbo.T_SCInfo SET Grade="+grade+" WHERE CNum='"+cnum+"' AND SNum="+snum+"";
					sql.executeUpdate(updaString);
				}
				dbUtil.ConnectClose();
				JOptionPane.showMessageDialog(this,"录入成功！");
				ShowSCInfo();  //录入成功刷新选课表
			} catch (Exception e) {
                JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
			}
		}
        System.out.println(""+snum);
		ShowSCInfo();  //录入成功刷新选课表
	}
}
