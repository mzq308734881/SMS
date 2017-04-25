package MyForm;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
public class FrmCourseInfoGlance extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    public static int Count,n=0;
    public static String[][] stuInfo;
    private int CNum;
    private String CName ;
    private String Credit ;
    private String CTime;
    private String TeacherName;
    private String SelectNum;
	
	
	private JTabbedPane jTabbedPane1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btnNext;
	private JButton btnBack;
	private JTextField txtSelectNum;
	private JLabel jLabel6;
	private JTextField txtTeacherName;
	private JLabel jLabel5;
	private JTextField txtCtime;
	private JLabel jLabel4;
	private JTextField txtCredit;
	private JTextField txtCname;
	private JTextField txtCnum;
	private JLabel jLabel1;
	private JDesktopPane jDesktopPane2;
	private JDesktopPane jDesktopPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmCourseInfoGlance inst = new FrmCourseInfoGlance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmCourseInfoGlance() {
		super();
		initGUI();
		ShowStuInfo();
		SetTextEnable();  //设置文本框为只读
		GetStuInfoText(0);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u8bfe\u7a0b\u4fe1\u606f\u6d4f\u89c8");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1);
				jTabbedPane1.setBounds(5, 6, 553, 263);
				{
					jDesktopPane1 = new JDesktopPane();
					jTabbedPane1.addTab("选修课程浏览", null, jDesktopPane1, null);
					jDesktopPane1.setBackground(new java.awt.Color(255,255,255));
					{
						jLabel1 = new JLabel();
						jDesktopPane1.add(jLabel1, JLayeredPane.DEFAULT_LAYER);
						jLabel1.setText("\u8bfe\u7a0b\u53f7\uff1a");
						jLabel1.setBounds(27, 33, 57, 17);
					}
					{
						txtCnum = new JTextField();
						jDesktopPane1.add(txtCnum, JLayeredPane.DEFAULT_LAYER);
						txtCnum.setBounds(84, 30, 132, 24);
					}
					{
						jLabel2 = new JLabel();
						jDesktopPane1.add(jLabel2, JLayeredPane.DEFAULT_LAYER);
						jLabel2.setText("\u8bfe\u7a0b\u540d\uff1a");
						jLabel2.setBounds(27, 71, 57, 17);
					}
					{
						txtCname = new JTextField();
						jDesktopPane1.add(txtCname, JLayeredPane.DEFAULT_LAYER);
						txtCname.setBounds(84, 68, 132, 24);
					}
					{
						jLabel3 = new JLabel();
						jDesktopPane1.add(jLabel3, JLayeredPane.DEFAULT_LAYER);
						jLabel3.setText("\u5b66\u5206\uff1a");
						jLabel3.setBounds(36, 108, 48, 17);
					}
					{
						txtCredit = new JTextField();
						jDesktopPane1.add(txtCredit, JLayeredPane.DEFAULT_LAYER);
						txtCredit.setBounds(84, 105, 132, 24);
					}
					{
						jLabel4 = new JLabel();
						jDesktopPane1.add(jLabel4, JLayeredPane.DEFAULT_LAYER);
						jLabel4.setText("\u5b66\u65f6\uff1a");
						jLabel4.setBounds(279, 36, 49, 17);
					}
					{
						txtCtime = new JTextField();
						jDesktopPane1.add(txtCtime, JLayeredPane.DEFAULT_LAYER);
						txtCtime.setBounds(328, 33, 142, 24);
					}
					{
						jLabel5 = new JLabel();
						jDesktopPane1.add(jLabel5, JLayeredPane.DEFAULT_LAYER);
						jLabel5.setText("\u6559\u5e08\u540d\uff1a");
						jLabel5.setBounds(260, 74, 66, 17);
					}
					{
						txtTeacherName = new JTextField();
						jDesktopPane1.add(txtTeacherName, JLayeredPane.DEFAULT_LAYER);
						txtTeacherName.setBounds(326, 71, 144, 24);
					}
					{
						jLabel6 = new JLabel();
						jDesktopPane1.add(jLabel6, JLayeredPane.DEFAULT_LAYER);
						jLabel6.setText("\u9650\u9009\u4eba\u6570\uff1a");
						jLabel6.setBounds(248, 108, 75, 17);
					}
					{
						txtSelectNum = new JTextField();
						jDesktopPane1.add(txtSelectNum, JLayeredPane.DEFAULT_LAYER);
						txtSelectNum.setBounds(326, 105, 144, 24);
					}
					{
						btnBack = new JButton();
						jDesktopPane1.add(btnBack, JLayeredPane.DEFAULT_LAYER);
						btnBack.setText("<<\u4e0a\u4e00\u6761");
						btnBack.setBounds(102, 177, 99, 24);
						btnBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnBackActionPerformed(evt);
							}
						});
					}
					{
						btnNext = new JButton();
						jDesktopPane1.add(btnNext, JLayeredPane.DEFAULT_LAYER);
						btnNext.setText("\u4e0b\u4e00\u6761>>");
						btnNext.setBounds(352, 177, 105, 24);
						btnNext.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnNextActionPerformed(evt);
							}
						});
					}
				}
				{
					jDesktopPane2 = new JDesktopPane();
					jTabbedPane1.addTab("实践课程浏览", null, jDesktopPane2, null);
					jDesktopPane2.setBackground(new java.awt.Color(255,255,255));
				}
			}
			pack();
			this.setSize(574, 308);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//上一条
	private void btnBackActionPerformed(ActionEvent evt) {
        Count--;
        btnNext.setEnabled(true);
        GetStuInfoText(Count); 
        if (Count==0) {
			btnBack.setEnabled(false);
		}
	}
	
	//下一条
	private void btnNextActionPerformed(ActionEvent evt) {
		Count++;
		btnBack.setEnabled(true);
		if (Count == n - 1) {
			btnNext.setEnabled(false);
		}
		GetStuInfoText(Count);
	}
	
	//设置文本框为只读
		public void SetTextEnable()
		{
			txtCname.setEditable(false);
			txtCnum.setEditable(false);
			txtCredit.setEditable(false);
			txtCtime.setEditable(false);
			txtSelectNum.setEditable(false);
			txtTeacherName.setEditable(false);
			btnBack.setEnabled(false);
		}
		
		//展示对应学生信息
		public void ShowStuInfo()
		{
			int i=0;
			stuInfo=new String[1000][8];
			try{
				sql=dbUtil.ConnectDB().createStatement();
				String sqString="Select * from T_CourseInfo";
				rs=sql.executeQuery(sqString);		

				while(rs.next()) {
					for (int j = 0; j < 8; j++) {
						stuInfo[i][j]=rs.getString(j+1);
					}
					i++;
					n++;
				} 
				sql.close();
				dbUtil.ConnectClose();			
				JOptionPane.showMessageDialog(this,"受影响条数："+n);		
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
			}
		}
		
		//将信息展示在文本框
		public void GetStuInfoText(int n)
		{
			txtCnum.setText(stuInfo[n][0]);
			txtCname.setText(stuInfo[n][1]);
			txtCredit.setText(stuInfo[n][2]);
			txtCtime.setText(stuInfo[n][3]);
			txtTeacherName.setText(stuInfo[n][4]);
			txtSelectNum.setText(stuInfo[n][5]);			
		}

}
