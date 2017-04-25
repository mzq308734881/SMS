package MyForm;
import DBHelper.DBUtil;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
public class FrmStuIDInput extends javax.swing.JFrame {
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    ResultSet rs;
    private int Num;
    private String Name;
    
    private String Sex ;
    private String Birth;
    private String Depart;
    private String Id;
    private String SImage;
    private String Introduce;
    
	private JButton btnSelect;
	private JLabel jLabel2;
	public JRadioButton radbtnName;
	public JRadioButton radbtnNum;
	public JTextField txtStuBase;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStuIDInput inst = new FrmStuIDInput();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuIDInput() {
		super();
		initGUI();
		radbtnNum.setSelected(true);  //默认学号查询
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u4e2a\u4eba\u4fe1\u606f\u67e5\u8be2");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				btnSelect = new JButton();
				getContentPane().add(btnSelect);
				btnSelect.setText("\u67e5\u8be2");
				btnSelect.setBounds(289, 63, 84, 24);
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSelectActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u67e5\u8be2\u65b9\u5f0f\uff1a");
				jLabel1.setBounds(20, 27, 71, 22);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u67e5\u8be2\u4f9d\u636e\uff1a");
				jLabel2.setBounds(20, 63, 71, 20);
			}
			{
				txtStuBase = new JTextField();
				getContentPane().add(txtStuBase);
				txtStuBase.setBounds(98, 63, 164, 24);
			}
			{
				radbtnNum = new JRadioButton();
				getContentPane().add(radbtnNum);
				radbtnNum.setText("\u5b66\u53f7");
				radbtnNum.setBounds(98, 28, 64, 21);
				radbtnNum.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radbtnNumActionPerformed(evt);
					}
				});
			}
			{
				radbtnName = new JRadioButton();
				getContentPane().add(radbtnName);
				radbtnName.setText("\u59d3\u540d");
				radbtnName.setBounds(177, 28, 63, 21);
				radbtnName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radbtnNameActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(424, 156);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//选择学号
	private void radbtnNumActionPerformed(ActionEvent evt) {
		//TODO add your code for radbtnNum.actionPerformed
		radbtnName.setSelected(false);
		radbtnNum.setSelected(true);
	}
	
	//选择姓名
	private void radbtnNameActionPerformed(ActionEvent evt) {
		//TODO add your code for radbtnName.actionPerformed
		radbtnNum.setSelected(false);
		radbtnName.setSelected(true);
		txtStuBase.setText("");
	}
	
	//执行查询
	private void btnSelectActionPerformed(ActionEvent evt) {			
		if(txtStuBase.getText().equals(""))
			JOptionPane.showMessageDialog(this,"查询依据不能为空");
		else if(radbtnName.isSelected()) {
			Name=txtStuBase.getText();
			SelectName(Name);
			this.dispose();
		}
		else {
			Num=Integer.parseInt(txtStuBase.getText());
			SelectNum(Num);
			this.dispose();
		}
	}
	
	//按学号查询
	public void SelectNum(int num){		
        try {
        	int Snum=Integer.parseInt(txtStuBase.getText());
       	    sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo where Snum="+num+"");  //再执行查找操作，取出数据集
			FrmPersonInfo frmPersonInfo=new FrmPersonInfo();			
			frmPersonInfo.txtSnum.setText(this.txtStuBase.getText());
			ShowInfo(Integer.parseInt(this.txtStuBase.getText().trim()));
			frmPersonInfo.txtSname.setText(GetScoreInput(Snum));
			frmPersonInfo.labImage.setIcon(ShowImage());
			frmPersonInfo.txtDepart.setText(Depart);
			frmPersonInfo.txtSbirthday.setText(Birth);
			frmPersonInfo.txtSex.setText(Sex);
			frmPersonInfo.txtSid.setText(Id);
			frmPersonInfo.jEditorPane1.setText(Introduce);
			
			frmPersonInfo.txtSname.setEnabled(false);	   	   
			frmPersonInfo.txtSnum.setEnabled(false);
			frmPersonInfo.setVisible(true);
			frmPersonInfo.setLocationRelativeTo(null);
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "学号查询异常：" + e.getMessage());
		}
	}
	
	//按姓名查询
	public void SelectName(String name){
		FrmPersonInfo frmPersonInfo;
        try {
       	    sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber,SImage ,SIntroduce FROM dbo.T_StudentInfo where Sname='"+name+"'");  //再执行查找操作，取出数据集
		    while (rs.next()) {
				
			}
			JOptionPane.showMessageDialog(this, "查询成功！");
			frmPersonInfo=new FrmPersonInfo();
			frmPersonInfo.setVisible(true);
			frmPersonInfo.txtSname.setText(this.txtStuBase.getText());
			frmPersonInfo.txtSname.setEditable(false);
			frmPersonInfo.txtSnum.setEnabled(false);
	        
			frmPersonInfo.setLocationRelativeTo(null);
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "姓名查询异常：" + e.getMessage());
		}
	}
	
	//调用存储过程返回学生姓名
	CallableStatement cstmt=null;
	public String GetScoreInput(int num)
	{
		String teacherName="";
		try {
			CallableStatement cstmt = dbUtil.ConnectDB()
					.prepareCall("{call dbo.pro_GetStuName(?, ?)}");
			cstmt.setInt(1, num);
			cstmt.registerOutParameter(2, java.sql.Types.CHAR);
			cstmt.execute();
			System.out.println("MANAGER ID: " + cstmt.getString(2));
			teacherName=cstmt.getString(2);
			cstmt.close();
            dbUtil.ConnectClose();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"存储过程异常："+e .getMessage());
		}
		return teacherName;
	}
	
	//展示个人信息
	public void ShowInfo(int num)
	{
		try {
       	    sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber,SImage ,SIntroduce FROM dbo.T_StudentInfo where Snum="+num+"");  //再执行查找操作，取出数据集
			while (rs.next()) {
				Sex=rs.getString(3);
				Birth=(rs.getString(4));
				Depart=(rs.getString(5));
				Id=(rs.getString(6));
				SImage=rs.getString(7);
				Introduce=(rs.getString(8));				
			}
			JOptionPane.showMessageDialog(this, "查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"显示个人信息异常："+e.getMessage());
		}
	}
	
	//展示图片
	public ImageIcon ShowImage(){	
		ImageIcon imageIcon = new ImageIcon(SImage);
		try {
		System.out.println(SImage);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(156,
				127, 10));
		//labImage.setIcon(imageIcon);
	} catch (Exception e) {
		//TODO: handle exception
		JOptionPane.showMessageDialog(this,"图片显示异常："+e.getMessage());
	}
		return imageIcon;
	}
}
