package MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

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
public class FrmForgotPwd extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
	int Num;
	String Name;
	String Answer;
	String Role;
	String Question;
	String strPwd="";
	
	private JButton btnBack;
	private JLabel jLabel3;
	private JTextField txtAnwser;
	private JLabel jLabel5;
	private JComboBox cobQuestion;
	private JLabel jLabel4;
	private JComboBox cobRole;
	private JTextField txtName;
	private JLabel jLabel2;
	private JTextField txtNum;
	private JLabel jLabel1;
	private JButton btnFind;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmForgotPwd inst = new FrmForgotPwd();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmForgotPwd() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.setTitle("\u627e\u56de\u5bc6\u7801");
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(67, 212, 79, 24);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				btnFind = new JButton();
				getContentPane().add(btnFind);
				btnFind.setText("\u627e\u56de");
				btnFind.setBounds(232, 212, 77, 24);
				btnFind.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnFindActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(67, 15, 47, 17);
			}
			{
				txtNum = new JTextField();
				getContentPane().add(txtNum);
				txtNum.setBounds(114, 12, 175, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d\uff1a");
				jLabel2.setBounds(67, 55, 47, 17);
			}
			{
				txtName = new JTextField();
				getContentPane().add(txtName);
				txtName.setBounds(114, 52, 175, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u89d2\u8272\uff1a");
				jLabel3.setBounds(67, 95, 47, 17);
			}
			{
				ComboBoxModel txtRoleModel = 
						new DefaultComboBoxModel(
								new String[] { "","管理员", "教师","学生" });
				cobRole = new JComboBox();
				getContentPane().add(cobRole);
				cobRole.setModel(txtRoleModel);
				cobRole.setBounds(114, 91, 83, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u5bc6\u4fdd\u95ee\u9898\uff1a");
				jLabel4.setBounds(47, 133, 66, 17);
			}
			{
				ComboBoxModel cobQuestionModel = 
						new DefaultComboBoxModel(
								new String[] { "","喜欢吃什么？", "大学学校？","什么专业毕业？" });
				cobQuestion = new JComboBox();
				getContentPane().add(cobQuestion);
				cobQuestion.setModel(cobQuestionModel);
				cobQuestion.setBounds(114, 129, 175, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u56de\u7b54\uff1a");
				jLabel5.setBounds(69, 171, 43, 17);
			}
			{
				txtAnwser = new JTextField();
				getContentPane().add(txtAnwser);
				txtAnwser.setBounds(114, 166, 175, 24);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//返回登录界面
	private void btnBackActionPerformed(ActionEvent evt) {
        dispose();
	}
	
	//找回密码
	private void btnFindActionPerformed(ActionEvent evt) {
		strPwd = "";
		if (txtNum.getText().equals("") || txtName.getText().equals("")
				|| cobRole.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "账号，姓名和角色不能为空！");
		} else if (cobQuestion.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "密保问题不能为空！");
		} else {
			try {
				Num = Integer.parseInt(txtNum.getText());
				Name = txtName.getText();
				Answer = txtAnwser.getText();
				Role = (String) cobRole.getSelectedItem();
				Question = (String) cobQuestion.getSelectedItem();
				strPwd = GetQuestionAnswer(Num, Name, Role, Answer, Question);
				if (strPwd == "") {
					JOptionPane.showMessageDialog(this, "回答错误！");
				} else {
					JOptionPane.showMessageDialog(this, "密码找回成功原密码为：" + strPwd+" ");
					JOptionPane.showMessageDialog(this," 请返回返回登录界面重新登录");
					dispose();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "异常：" + e.getMessage());
			}
		}
	}

	//得到问题答案
	public String GetQuestionAnswer(int num,String name,String role,String answer,String question )
	{
		String sqlString="";
		String pwdString="";
		
		switch (question) {
		case "喜欢吃什么？":
			sqlString="Select UserAnswer1 ,UserPwd from T_LoginInfo where UserNum="+num+" ";
			break;
        case "大学学校？":
        	sqlString="Select UserAnswer2 ,UserPwd from T_LoginInfo where UserNum="+num+" ";
        	break;
        case "什么专业毕业？":
        	sqlString="Select UserAnswer3  ,UserPwd from T_LoginInfo where UserNum="+num+" ";
        	break;
		default:
			break;
		}
		try {
			sql=dbUtil.ConnectDB().createStatement();
			rs=sql.executeQuery(sqlString);
			
			while(rs.next())
			{		
				pwdString=rs.getString(2);		
				if (rs.getString(1).trim().equals(answer)) {
					JOptionPane.showMessageDialog(this,"回答正确！");		
					break;
				}
				else {
					JOptionPane.showMessageDialog(this,"回答错误！");
					strPwd="";
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"Sql异常："+e.getMessage());
		}			
		return pwdString;
	}
}
