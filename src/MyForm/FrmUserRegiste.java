package MyForm;
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
public class FrmUserRegiste extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
	int Num;
	String Name;
	String Sex;
	String Role;
	String Pwd;
	
	private JLabel jLabel1;
	private JTextField txtUserNum;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btnRegiste;
	private JButton btnBack;
	private JTextField txtConfirmPwd;
	private JLabel jLabel6;
	private JTextField txtUserPwd;
	private JLabel jLabel5;
	private JComboBox cobSex;
	private JLabel jLabel4;
	private JTextField txtUserName;
	private JComboBox cobRole;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmUserRegiste inst = new FrmUserRegiste();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	//窗体构造方法
	public FrmUserRegiste() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7528\u6237\u6ce8\u518c");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.addWindowListener(new WindowAdapter() {
				public void windowDeactivated(WindowEvent evt) {
					System.out.println("this.windowDeactivated, event="+evt);
					//TODO add your code for this.windowDeactivated
				}
			});
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(78, 14, 41, 17);
			}
			{
				txtUserNum = new JTextField();
				getContentPane().add(txtUserNum);
				txtUserNum.setBounds(123, 12, 173, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u89d2\u8272\uff1a");
				jLabel2.setBounds(75, 84, 48, 24);
			}
			{
				ComboBoxModel cobRoleModel = 
						new DefaultComboBoxModel(
								new String[] { "","管理员", "教师","学生" });
				cobRole = new JComboBox();
				getContentPane().add(cobRole);
				cobRole.setModel(cobRoleModel);
				cobRole.setBounds(123, 84, 88, 24);
			}
			{
				txtUserName = new JTextField();
				getContentPane().add(txtUserName);
				txtUserName.setBounds(122, 48, 173, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u59d3\u540d\uff1a");
				jLabel3.setBounds(75, 48, 47, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u6027\u522b\uff1a");
				jLabel4.setBounds(75, 121, 48, 24);
			}
			{
				ComboBoxModel cobSexModel = 
						new DefaultComboBoxModel(
								new String[] { "男","女"});
				cobSex = new JComboBox();
				getContentPane().add(cobSex);
				cobSex.setModel(cobSexModel);
				cobSex.setBounds(123, 121, 55, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u5bc6\u7801\uff1a");
				jLabel5.setBounds(75, 157, 48, 20);
			}
			{
				txtUserPwd = new JTextField();
				getContentPane().add(txtUserPwd);
				txtUserPwd.setBounds(123, 154, 172, 24);
				txtUserPwd.setToolTipText("\u81f3\u5c118\u4f4d\u6570\u5b57\u548c\u5b57\u7b26\u7ec4\u5408");
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
				jLabel6.setBounds(51, 189, 72, 17);
			}
			{
				txtConfirmPwd = new JTextField();
				getContentPane().add(txtConfirmPwd);
				txtConfirmPwd.setBounds(123, 186, 172, 24);
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(65, 226, 72, 24);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				btnRegiste = new JButton();
				getContentPane().add(btnRegiste);
				btnRegiste.setText("\u6ce8\u518c");
				btnRegiste.setBounds(261, 226, 78, 24);
				btnRegiste.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnRegisteActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//响应返回登录界面
	private void btnBackActionPerformed(ActionEvent evt) {
		dispose();
	}
	
	//响应注册事件
	private void btnRegisteActionPerformed(ActionEvent evt) {
		System.out.println("btnRegiste.actionPerformed, event="+evt);
		// TODO add your code for btnRegiste.actionPerformed
		if (txtUserNum.getText().equals("") || txtUserName.getText().equals("")|| txtUserPwd.getText().equals("")|| cobRole.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "账号，姓名，角色和密码不能为空！");
		}
		else if (FrmUserRegiste.isNumeric(txtUserPwd.getText())|| FrmUserRegiste.isChar(txtUserPwd.getText()))
			JOptionPane.showMessageDialog(this, "密码必须为字符和数字的组合");
		else if (txtUserPwd.getText().length() < 9)
			JOptionPane.showMessageDialog(this, "密码长度至少为8");
		else if (!txtUserPwd.getText().equals(txtConfirmPwd.getText()))
			JOptionPane.showMessageDialog(this, "两次输入的密码不同，请重新输入");
		else if (true/*GetUserRegiste(String num,String name,String role,String pwd)*/) {
			JOptionPane.showMessageDialog(this, "注册成功！");
			this.setVisible(false);    //注册成功，返回登录界面
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
	
	public void  GetUserRegiste(int num,String name,String sex,String role,String pwd)
	{
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="";
			sql.executeUpdate(sqlString);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
