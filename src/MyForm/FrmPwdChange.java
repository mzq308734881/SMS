package MyForm;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
public class FrmPwdChange extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
	int Num;
	String Name;
	String Role;
	String NewPwd;
	
	
	private JButton btnBack;
	private JLabel jLabel3;
	private JTextField txtRole;
	private JPasswordField txtNewPwd;
	private JPasswordField txtOldPwd;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JTextField txtNum;
	private JLabel jLabel1;
	private JButton btnPwdUpdate;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmPwdChange inst = new FrmPwdChange();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmPwdChange() {
		super();
		initGUI();
		txtNum.setEnabled(false);
		txtRole.setEnabled(false);
		txtNum.setText(FrmMain.UserNum);
		txtRole.setText(FrmMain.UserRole);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5bc6\u7801\u4fee\u6539");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(61, 183, 75, 24);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				btnPwdUpdate = new JButton();
				getContentPane().add(btnPwdUpdate);
				btnPwdUpdate.setText("\u4fee\u6539");
				btnPwdUpdate.setBounds(251, 183, 74, 24);
				btnPwdUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnPwdUpdateActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(83, 20, 44, 17);
			}
			{
				txtNum = new JTextField();
				getContentPane().add(txtNum);
				txtNum.setBounds(128, 17, 153, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u89d2\u8272\uff1a");
				jLabel2.setBounds(83, 58, 44, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u539f\u5bc6\u7801\uff1a");
				jLabel3.setBounds(74, 95, 54, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u65b0\u5bc6\u7801\uff1a");
				jLabel4.setBounds(72, 133, 56, 17);
			}
			{
				txtOldPwd = new JPasswordField();
				getContentPane().add(txtOldPwd);
				txtOldPwd.setBounds(128, 94, 153, 24);
			}
			{
				txtNewPwd = new JPasswordField();
				getContentPane().add(txtNewPwd);
				
				txtNewPwd.setBounds(128, 130, 153, 24);
			}
			{
				txtRole = new JTextField();
				getContentPane().add(txtRole);
				txtRole.setBounds(127, 55, 80, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//响应返回
	private void btnBackActionPerformed(ActionEvent evt) {
       dispose();
       FrmMain frmMain=new FrmMain();
       frmMain.setVisible(true);
       frmMain.setLocationRelativeTo(null);
       frmMain.labUser.setText(txtNum.getText());
       frmMain.labRole.setText(txtRole.getText());
	}
	
	//响应修改密码
	private void btnPwdUpdateActionPerformed(ActionEvent evt) {
		if (txtNum.getText().equals("")||txtRole.getText().equals("")||txtOldPwd.getText().equals("")||txtNewPwd.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"账号，角色和密码不能为空！");
		}
		else if (FrmPwdChange.isNumeric(txtNewPwd.getText())|| FrmPwdChange.isChar(txtNewPwd.getText()))
			JOptionPane.showMessageDialog(this, "新密码必须为字符和数字的组合");
		else if (txtNewPwd.getText().length() < 9)
			JOptionPane.showMessageDialog(this, "新密码长度至少为8");
		else if (txtOldPwd.getText().equals(txtNewPwd.getText())) {
			JOptionPane.showMessageDialog(this, "原密码和新密码不能相同");
		} else {
			try {
				Num = Integer.parseInt(txtNum.getText());
				NewPwd = txtNewPwd.getText();
				GetChangePwd(Num, NewPwd);
				dispose();
				FrmLogin frmLogin=new FrmLogin();
				frmLogin.setVisible(true);
				frmLogin.setLocationRelativeTo(null);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	//正则表达式判断是否全为数字
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 }
	//正则表达式判断是否全为字符
	public static boolean isChar(String str){ 
	    Pattern pattern = Pattern.compile("[a-z]*"); 
	    return pattern.matcher(str).matches();    
	 }
	
	//更改密码
	public void GetChangePwd(int num,String newpwd )
	{
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="Update T_LoginInfo Set UserPwd='"+newpwd+"' where UserNum="+num+"";
			sql.executeUpdate(sqlString);
			JOptionPane.showMessageDialog(this,"密码更改成功！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
	}
}
