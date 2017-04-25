package MyForm;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
/*
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.*;*/

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
public class FrmLogin extends javax.swing.JFrame {
	
	Connection con=null;
	Statement sql=null;
	DBUtil dbUtil=new DBUtil();
	ResultSet rs=null;
	public static int Num;
	public static String Role;
	public static String Pwd;
	
	private JButton btnLogin;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel labImage;
	private JLabel labForgotPwd;
	private JLabel labUserRegiste;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox1;
	private JPasswordField txtPwd;
	private JComboBox cobRole;
	private JTextField txtNum;
	private JLabel jLabel1;
	private JButton btnReset;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		/*try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel
					.setCurrentTheme(new SubstanceTerracottaTheme());
			SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
			// SubstanceLookAndFeel.setCurrentButtonShaper(new
			// ClassicButtonShaper());
			// SubstanceLookAndFeel.setCurrentWatermark(new
			// SubstanceBubblesWatermark());
			// SubstanceLookAndFeel.setCurrentBorderPainter(new
			// StandardBorderPainter());
			// SubstanceLookAndFeel.setCurrentGradientPainter(new
			// StandardGradientPainter());
			// SubstanceLookAndFeel.setCurrentTitlePainter(new
			// FlatTitePainter());
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}*/
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmLogin inst = new FrmLogin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmLogin() {
		super();
		this.setResizable(false);
		initGUI();
		ShowRembPwd();//记住密码
		//DeletePwd();
		if (!txtNum.getText().equals("")) {
			jCheckBox1.setSelected(true);
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u7ba1\u7406\u7cfb\u7edf\u767b\u5f55");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			getContentPane().add(getBtnLogin());
			getContentPane().add(getBtnReset());
			getContentPane().add(getJLabel1());
			getContentPane().add(getTxtNum());
			getContentPane().add(getJLabel2());
			getContentPane().add(getCobRole());
			getContentPane().add(getTxtPwd());
			getContentPane().add(getJLabel3());
			getContentPane().add(getJCheckBox1());
			getContentPane().add(getJCheckBox2());
			getContentPane().add(getJLabel4());
			getContentPane().add(getLabForgotPwd());
			getContentPane().add(getLabImage());
			{
				
			}
			pack();
			this.setSize(479, 347);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	
	private JButton getBtnLogin() {
		if(btnLogin == null) {
			btnLogin = new JButton();
			btnLogin.setText("\u767b\u5f55");
			btnLogin.setBounds(299, 272, 74, 24);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnLoginActionPerformed(evt);
				}
			});
		}
		return btnLogin;
	}
	
	private JButton getBtnReset() {
		if(btnReset == null) {
			btnReset = new JButton();
			btnReset.setText("\u91cd\u7f6e");
			btnReset.setBounds(96, 272, 74, 24);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnResetActionPerformed(evt);
				}
			});
		}
		return btnReset;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("\u8d26\u53f7\uff1a");
			jLabel1.setBounds(84, 126, 41, 17);
		}
		return jLabel1;
	}
	
	private JTextField getTxtNum() {
		if(txtNum == null) {
			txtNum = new JTextField();
			txtNum.setBounds(127, 123, 205, 24);
			txtNum.setForeground(new java.awt.Color(0,0,0));
			txtNum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtNumActionPerformed(evt);
				}
			});
			txtNum.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					txtNumMouseClicked(evt);
				}
			});
		}		
		return txtNum;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("\u89d2\u8272\uff1a");
			jLabel2.setBounds(83, 163, 41, 17);
		}
		return jLabel2;
	}
	
	private JComboBox getCobRole() {
		if(cobRole == null) {
			ComboBoxModel cobRoleModel = 
					new DefaultComboBoxModel(
							new String[] { "","管理员","教师", "学生" });
			cobRoleModel.setSelectedItem("");
			cobRole = new JComboBox();
			cobRole.setModel(cobRoleModel);
			cobRole.setBounds(126, 160, 86, 24);
			cobRole.setSelectedItem(cobRoleModel);
		}
		return cobRole;
	}
	
	private JPasswordField getTxtPwd() {
		if(txtPwd == null) {
			txtPwd = new JPasswordField();
			txtPwd.setBounds(126, 197, 206, 24);
		}
		return txtPwd;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("\u5bc6\u7801\uff1a");
			jLabel3.setBounds(84, 201, 39, 17);
		}
		return jLabel3;
	}
	
	private JCheckBox getJCheckBox1() {
		if(jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setText("\u8bb0\u4f4f\u5bc6\u7801");
			jCheckBox1.setBounds(96, 234, 84, 21);
			jCheckBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jCheckBox1ActionPerformed(evt);
				}
			});
		}
		return jCheckBox1;
	}
	
	private JCheckBox getJCheckBox2() {
		if(jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setText("\u81ea\u52a8\u767b\u5f55");
			jCheckBox2.setBounds(276, 235, 80, 21);
		}
		return jCheckBox2;
	}

	private JLabel getJLabel4() {
		if(labUserRegiste == null) {
			labUserRegiste = new JLabel();
			labUserRegiste.setText("\u7528\u6237\u6ce8\u518c");
			labUserRegiste.setBounds(338, 126, 60, 17);
			labUserRegiste.setForeground(new java.awt.Color(0,0,255));
			labUserRegiste.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			labUserRegiste.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					labUserRegisteMouseClicked(evt);
				}
			});
		}
		return labUserRegiste;
	}
	//响应注册用户
	private void labUserRegisteMouseClicked(MouseEvent evt) {
		System.out.println("labUserRegiste.mouseClicked, event="+evt);
		//TODO add your code for labUserRegiste.mouseClicked
		FrmUserRegiste frmUserRegiste=new FrmUserRegiste();
		frmUserRegiste.setVisible(true);
		//两种方法是Swing窗体居中
		/*int screenWith=Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
		frmUserRegiste.setBounds(screenWith/2-400, screenHeight/2-325, 400, 300);*/
		
		frmUserRegiste.setSize(new Dimension(400,300));
		frmUserRegiste.setLocationRelativeTo(null);
	}
	
	private JLabel getLabForgotPwd() {
		if(labForgotPwd == null) {
			labForgotPwd = new JLabel();
			labForgotPwd.setText("\u5fd8\u8bb0\u5bc6\u7801");
			labForgotPwd.setBounds(339, 200, 62, 17);
			labForgotPwd.setForeground(new java.awt.Color(0,0,255));
			labForgotPwd.setBorder(BorderFactory.createCompoundBorder(
					null, 
					null));
			labForgotPwd.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					labForgotPwdMouseClicked(evt);
				}
			});
		}
		return labForgotPwd;
	}
	//响应忘记密码
	private void labForgotPwdMouseClicked(MouseEvent evt) {
		FrmForgotPwd frmForgotPwd=new FrmForgotPwd();
		frmForgotPwd.setVisible(true);
		frmForgotPwd.setSize(new Dimension(400,300));
		frmForgotPwd.setLocationRelativeTo(null);
	}
	//重置登录信息
	private void btnResetActionPerformed(ActionEvent evt) {
		txtPwd.setText("");
		cobRole.setSelectedIndex(0);
		jCheckBox1.setSelected(false);
		jCheckBox2.setSelected(false);
	}
	//关闭窗体时响应
	private void thisWindowClosing(WindowEvent evt) {
		//TODO add your code for this.windowClosing
		int i = JOptionPane.showConfirmDialog(null, "是否退出？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			System.exit(0);
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	//登录学生管理系统
	private void btnLoginActionPerformed(ActionEvent evt) {
		if (txtNum.getText().trim().equals("") || txtPwd.getText().trim().equals("")
				|| cobRole.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "账号，角色或密码不能为空！");
		} else {
			try {
				Num = Integer.parseInt(txtNum.getText().trim());
				Role = (String) cobRole.getSelectedItem();
				Pwd = txtPwd.getText().trim();
				if (Login(Num,Role,Pwd)==1) {
					System.out.println("登录成功！");
					this.dispose();
					FrmMain frmMain = new FrmMain();
					frmMain.setVisible(true);
					frmMain.setLocationRelativeTo(null);
					frmMain.labUser.setText(txtNum.getText().trim());
					frmMain.labRole.setText((String) cobRole.getSelectedItem());
				}
				else {
					JOptionPane.showMessageDialog(this,"账号或密码错误，请确认后重新登录！");
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "异常："+e .getMessage());
			}
		}
	}
	
	//查询语句验证登录信息(结果证明失败了，还是存储过程来的直接)
	public void GetLoginSelect(int num,String role,String pwd)
	{
		try {
			sql = dbUtil.ConnectDB().createStatement();
			String sqlstr="Select * from T_LoginInfo Where UserNum="+num+" and UserRole='"+role+"' and UserPwd='"+pwd+"'";
			rs = sql.executeQuery(sqlstr);
			
			if (sql.execute(sqlstr)) {
				System.out.println("登录成功！"+rs.toString()+sql.execute(sqlstr));
				this.dispose();
				FrmMain frmMain = new FrmMain();
				frmMain.setVisible(true);
				frmMain.setLocationRelativeTo(null);
				frmMain.labUser.setText(txtNum.getText().trim());
				frmMain.labRole.setText((String) cobRole.getSelectedItem());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示异常：" + e.getMessage());
		}catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "异常："+ex.getMessage());
		}
	}
	
	//通过存储过程验证登录结果，成功为1，失败为0
	CallableStatement cstmt=null;
	public int Login(int num,String role,String pwd)
	{
		int n=0;
		try {
		      cstmt = dbUtil.ConnectDB().prepareCall("{? = call dbo.Pro_Login(?,?,?)}");
		      cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		      cstmt.setInt(2, num);
		      cstmt.setString(3, role);
		      cstmt.setString(4, pwd);
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
	
	private JLabel getLabImage() {
		if(labImage == null) {
			labImage = new JLabel();
			labImage.setBounds(0, 0, 478, 114);
			ImageIcon imageIcon = new ImageIcon("E:\\Pictures\\2.png");
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(478,
					114, 100));			
			labImage.setIcon(imageIcon);
			labImage.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		return labImage;
	}
	
	//显示用户头像
    public String ShowImage(int num){
    	String imageString="";
    	try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="select Simage from dbo.T_StudentInfo where SNum="+num+"";
			rs=sql.executeQuery(sqlString);

			while(rs.next())
			{
				imageString=rs.getString(1).trim();
			 	//JOptionPane.showMessageDialog(this,"显示成功！");
			}	
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "SQL显示失败：" + e.getMessage());
		}
		return imageString;
	}
    
    //文本框改变的时候
	private void txtNumMouseClicked(MouseEvent evt) {
			/*try {
				int Num = Integer.parseInt(txtSNum.getText().trim());
				ImageIcon imageIcon = new ImageIcon(ShowImage(Num));
				System.out.println(ShowImage(Num));
				imageIcon.setImage(imageIcon.getImage().getScaledInstance(154,
						144, 10));
				labImage.setIcon(imageIcon);
			} catch (Exception e) {
				//TODO: handle exception
			}*/
		}   
    
    private void txtNumActionPerformed(ActionEvent evt) {
         if (txtNum.getText()!="") {
        	 JOptionPane.showMessageDialog(this,"响应");
			
		}
    }
    
    private void jCheckBox1ActionPerformed(ActionEvent evt) {
         if (jCheckBox1.isSelected()==true) {
        	 try {
        		int Num=Integer.parseInt(txtNum.getText().trim());
        		String Role=(String)cobRole.getSelectedItem();
        		String Pwd=txtPwd.getText().trim();
        		InserPwd(Num, Role, Pwd);
				//JOptionPane.showMessageDialog(this,"选中了");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
         else {
        	 DeletePwd();
        	// JOptionPane.showMessageDialog(this,"没选中");
		}
    }
    
    //记住密码
    public void InserPwd(int num,String role,String pwd)
    {
    	try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlstring="insert into T_RembPwd values("+num+",'"+role+"','"+pwd+"')";
			sql.executeUpdate(sqlstring);
			dbUtil.ConnectClose();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
    }
    
    //记住密码
    public void DeletePwd()
    {
    	try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlstring="delete T_RembPwd";
			sql.executeUpdate(sqlstring);
			dbUtil.ConnectClose();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
    }
    
    //开启窗体显示记住的用户和密码
    public void ShowRembPwd(){
    	try {
    		int count=0;
			sql=dbUtil.ConnectDB().createStatement();
			String sqlstring="select * from T_RembPwd";
			rs=sql.executeQuery(sqlstring);
			while(rs.next())
			{
				txtNum.setText(rs.getString(1).trim());
				cobRole.setSelectedItem(rs.getString(2).trim());
				txtPwd.setText(rs.getString(3).trim());
				count++;
			}
			dbUtil.ConnectClose();
			if (count>100) {
				DeletePwd();
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
    }
}
