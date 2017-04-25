package MyForm;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
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
public class FrmHangUp extends javax.swing.JFrame {
	private JLabel jLabel1;
	public JLabel LabUserNum;
	private JLabel jLabel3;
	private JButton btnExit;
	private JButton btnUnlock;
	private JPasswordField txtUserPwd;
	private JLabel jLabel5;
	public JLabel LabUserRole;
	
	Connection con=null;
	Statement sql=null;
	DBUtil dbUtil=new DBUtil();
	ResultSet rs;
	public static String Num;
	public static String Role;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmHangUp inst = new FrmHangUp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmHangUp() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			getContentPane().setLayout(null);
			this.setTitle("\u6302\u673a\u9501");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d\uff1a");
				jLabel1.setBounds(19, 33, 55, 17);
			}
			{
				LabUserNum = new JLabel();
				getContentPane().add(LabUserNum);
				LabUserNum.setText("****");
				LabUserNum.setBounds(70, 33, 63, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u89d2\u8272\uff1a");
				jLabel3.setBounds(144, 33, 48, 17);
			}
			{
				LabUserRole = new JLabel();
				getContentPane().add(LabUserRole);
				LabUserRole.setText("****");
				LabUserRole.setBounds(192, 33, 63, 17);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u5bc6\u7801\uff1a");
				jLabel5.setBounds(29, 71, 40, 17);
			}
			{
				txtUserPwd = new JPasswordField();
				getContentPane().add(txtUserPwd);
				txtUserPwd.setBounds(70, 70, 163, 19);
			}
			{
				btnUnlock = new JButton();
				getContentPane().add(btnUnlock);
				btnUnlock.setText("\u89e3\u9501");
				btnUnlock.setBounds(277, 66, 86, 24);
				btnUnlock.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUnlockActionPerformed(evt);
					}
				});
			}
			{
				btnExit = new JButton();
				getContentPane().add(btnExit);
				btnExit.setText("\u9000\u51fa\u7cfb\u7edf");
				btnExit.setBounds(277, 30, 86, 24);
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnExitActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 150);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//解锁事件
	private void btnUnlockActionPerformed(ActionEvent evt) {
		if (GetUnclock()==1) {
			JOptionPane.showMessageDialog(this, "解锁成功，欢迎还来");
			
			dispose();
			FrmMain frmMain=new FrmMain();
			frmMain.setVisible(true);
			frmMain.labUser.setText(Num);
			frmMain.labRole.setText(Role);
			frmMain.setLocationRelativeTo(null);
		}else {
			JOptionPane.showMessageDialog(this, "密码错误！！！");
		}
	}
	//退出系统事件
	private void btnExitActionPerformed(ActionEvent evt) {
		//TODO add your code for this.windowClosing
		int i = JOptionPane.showConfirmDialog(null, "是否确认退出？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			System.exit(0);
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	//通过存储过程验证登录结果，成功为1，失败为0
	CallableStatement cstmt=null;
	public int GetUnclock()
	{
		int n=0;
		try {
			  Num = LabUserNum.getText();
			  Role = LabUserRole.getText();
			  int num = Integer.parseInt(Num);
			  String Pwd = txtUserPwd.getText();
		      cstmt = dbUtil.ConnectDB().prepareCall("{? = call dbo.Pro_Login(?,?,?)}");
		      cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		      cstmt.setInt(2, num);
		      cstmt.setString(3, Role);
		      cstmt.setString(4, Pwd);
		      cstmt.execute();
		      System.out.println("RETURN STATUS: " + cstmt.getInt(1));
		      n=cstmt.getInt(1);
			  cstmt.close();
			  dbUtil.ConnectClose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "存储过程异常："+e.getMessage());
		} finally {

		}
		return n;
	}
}
