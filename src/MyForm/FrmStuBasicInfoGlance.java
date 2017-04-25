package MyForm;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
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
public class FrmStuBasicInfoGlance extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    public static int Count,n=0;
    public static String[][] stuInfo;
    private int Num;
    private String Name ;
    private String Sex ;
    private String Birth;
    private String Depart;
    private String Id;
    private String Introduce;
	
	
	private JTabbedPane jTabbedPane1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JEditorPane txtIntroduce;
	private JLabel jLabel7;
	private JTextField txtId;
	private JTextField txtDepart;
	private JTextField txtSbirth;
	private JTextField txtSSex;
	private JTextField txtSName;
	private JTextField txtSNum;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;
	private JButton btnNext;
	private JButton btnBack;
	private JDesktopPane jDesktopPane2;
	private JDesktopPane jDesktopPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStuBasicInfoGlance inst = new FrmStuBasicInfoGlance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuBasicInfoGlance() {
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
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.setTitle("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u6d4f\u89c8");
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1);
				jTabbedPane1.setBounds(0, 0, 533, 286);
				jTabbedPane1.setTabPlacement(JTabbedPane.RIGHT);
				{
					jDesktopPane1 = new JDesktopPane();
					jTabbedPane1.addTab("学生基本信息", null, jDesktopPane1, null);
					jDesktopPane1.setPreferredSize(new java.awt.Dimension(352, 277));
					jDesktopPane1.setBackground(new java.awt.Color(255,255,255));
					{
						btnBack = new JButton();
						jDesktopPane1.add(btnBack, JLayeredPane.DEFAULT_LAYER);
						btnBack.setText("<<\u4e0a\u4e00\u6761");
						btnBack.setBounds(79, 241, 94, 24);
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
						btnNext.setBounds(262, 241, 93, 24);
						btnNext.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnNextActionPerformed(evt);
							}
						});
					}
					{
						jLabel1 = new JLabel();
						jDesktopPane1.add(jLabel1, JLayeredPane.DEFAULT_LAYER);
						jLabel1.setText("\u5b66\u53f7\uff1a");
						jLabel1.setBounds(24, 28, 48, 15);
					}
					{
						jLabel2 = new JLabel();
						jDesktopPane1.add(jLabel2, JLayeredPane.DEFAULT_LAYER);
						jLabel2.setText("\u59d3\u540d\uff1a");
						jLabel2.setBounds(24, 68, 48, 15);
					}
					{
						jLabel3 = new JLabel();
						jDesktopPane1.add(jLabel3, JLayeredPane.DEFAULT_LAYER);
						jLabel3.setText("\u6027\u522b\uff1a");
						jLabel3.setBounds(24, 110, 48, 15);
					}
					{
						jLabel4 = new JLabel();
						jDesktopPane1.add(jLabel4, JLayeredPane.DEFAULT_LAYER);
						jLabel4.setText("\u51fa\u751f\u5e74\u6708\uff1a");
						jLabel4.setBounds(198, 27, 72, 17);
					}
					{
						jLabel5 = new JLabel();
						jDesktopPane1.add(jLabel5, JLayeredPane.DEFAULT_LAYER);
						jLabel5.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
						jLabel5.setBounds(198, 67, 72, 17);
					}
					{
						jLabel6 = new JLabel();
						jDesktopPane1.add(jLabel6, JLayeredPane.DEFAULT_LAYER);
						jLabel6.setText("\u4e13\u4e1a\uff1a");
						jLabel6.setBounds(222, 109, 48, 17);
					}
					{
						txtSNum = new JTextField();
						jDesktopPane1.add(txtSNum, JLayeredPane.DEFAULT_LAYER);
						txtSNum.setBounds(65, 25, 117, 24);
					}
					{
						txtSName = new JTextField();
						jDesktopPane1.add(txtSName, JLayeredPane.DEFAULT_LAYER);
						txtSName.setBounds(65, 64, 117, 24);
					}
					{
						txtSSex = new JTextField();
						jDesktopPane1.add(txtSSex, JLayeredPane.DEFAULT_LAYER);
						txtSSex.setBounds(67, 106, 63, 24);
					}
					{
						txtSbirth = new JTextField();
						jDesktopPane1.add(txtSbirth, JLayeredPane.DEFAULT_LAYER);
						txtSbirth.setBounds(263, 24, 134, 24);
					}
					{
						txtDepart = new JTextField();
						jDesktopPane1.add(txtDepart, JLayeredPane.DEFAULT_LAYER);
						txtDepart.setBounds(262, 102, 133, 24);
					}
					{
						txtId = new JTextField();
						jDesktopPane1.add(txtId, JLayeredPane.DEFAULT_LAYER);
						txtId.setBounds(262, 64, 131, 24);
					}
					{
						jLabel7 = new JLabel();
						jDesktopPane1.add(jLabel7, JLayeredPane.DEFAULT_LAYER);
						jLabel7.setText("\u4e2a\u4eba\u7b80\u4ecb\uff1a");
						jLabel7.setBounds(24, 151, 73, 17);
					}
					{
						txtIntroduce = new JEditorPane();
						jDesktopPane1.add(txtIntroduce, JLayeredPane.DEFAULT_LAYER);
						txtIntroduce.setBounds(24, 174, 382, 51);
					}
				}
				{
					jDesktopPane2 = new JDesktopPane();
					jTabbedPane1.addTab("学生个人事迹", null, jDesktopPane2, null);
					jDesktopPane2.setBackground(new java.awt.Color(255,255,255));
				}
			}
			pack();
			this.setSize(549, 325);
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
		txtDepart.setEditable(false);
		txtId.setEditable(false);
		txtIntroduce.setEditable(false);
		txtSbirth.setEditable(false);
		txtSName.setEditable(false);
		txtSNum.setEditable(false);
		txtSSex.setEditable(false);
		btnBack.setEnabled(false);
	}
	
	//展示对应学生信息
	public void ShowStuInfo()
	{
		int i=0;
		stuInfo=new String[1000][8];
		try{
			sql=dbUtil.ConnectDB().createStatement();
			String sqString="Select Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,Simage,SIntroduce from T_StudentInfo";
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
		txtSNum.setText(stuInfo[n][0]);
		txtSName.setText(stuInfo[n][1]);
		txtSSex.setText(stuInfo[n][2]);
		txtSbirth.setText(stuInfo[n][3]);
		txtDepart.setText(stuInfo[n][4]);
		txtId.setText(stuInfo[n][5]);
		txtIntroduce.setText(stuInfo[n][7]);			
	}
}
