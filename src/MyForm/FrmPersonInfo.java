package MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
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
public class FrmPersonInfo extends javax.swing.JFrame {
	//默认选择的行和列为真
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
	private  int selectedRow;   //所选择的行
	private  int selectedCol;   //所选择的列
    public int Num;
    public String Name ;
    private String Sex ;
    private String Birth;
    private String Depart;
    private String Id;
    public static String SImage;
    private String Introduce;
	
	
    public JEditorPane jEditorPane1;
	private JLabel jLabel7;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JButton btnUpdate;
	private JButton btnUpLoad;
	public JLabel labImage;
	private JLabel jLabel1;
	public JTextField txtSnum;
	private JLabel jLabel2;
	public JTextField txtSex;
	public JTextField txtSname;
	private JLabel jLabel4;
	public JTextField txtSbirthday;
	private JLabel jLabel6;
	public JTextField txtSid;
	public JTextField txtDepart;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmPersonInfo inst = new FrmPersonInfo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});				
	}
	
	public FrmPersonInfo() {
		super();
		initGUI();
		/*try {
			//int SNum = Integer.parseInt(txtSnum.getText().trim());
			//System.out.println(Integer.parseInt(txtSnum.getText().trim()));
			ShowInfo(Num); // 显示个人信息
			ShowImage(); // 显示图片
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"这里异常："+e.getMessage());
		}*/
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				jEditorPane1 = new JEditorPane();
				getContentPane().add(jEditorPane1);
				jEditorPane1.setBounds(207, 172, 469, 64);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u4e2a\u4eba\u7b80\u4ecb\uff1a");
				jLabel7.setBounds(207, 149, 87, 17);
			}
			{
				txtDepart = new JTextField();
				getContentPane().add(txtDepart);
				txtDepart.setBounds(505, 62, 131, 23);
			}
			{
				txtSid = new JTextField();
				getContentPane().add(txtSid);
				txtSid.setBounds(505, 105, 130, 23);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
				jLabel6.setBounds(437, 106, 69, 23);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u6240\u5728\u7cfb\uff1a");
				jLabel5.setBounds(451, 62, 54, 23);
			}
			{
				txtSbirthday = new JTextField();
				getContentPane().add(txtSbirthday);
				txtSbirthday.setBounds(505, 19, 131, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u51fa\u751f\u5e74\u6708\uff1a");
				jLabel4.setBounds(439, 20, 66, 21);
			}
			{
				txtSname = new JTextField();
				getContentPane().add(txtSname);
				txtSname.setBounds(251, 62, 116, 23);
			}
			{
				txtSex = new JTextField();
				getContentPane().add(txtSex);
				txtSex.setBounds(252, 105, 73, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6027\u522b\uff1a");
				jLabel3.setBounds(207, 106, 45, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d\uff1a");
				jLabel2.setBounds(207, 63, 45, 23);
			}
			{
				txtSnum = new JTextField();
				getContentPane().add(txtSnum);
				txtSnum.setBounds(251, 19, 117, 23);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5b66\u53f7\uff1a");
				jLabel1.setBounds(209, 20, 42, 21);
			}
			{
				labImage = new JLabel();
				getContentPane().add(labImage);
				labImage.setBounds(24, 12, 156, 127);
				labImage.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				btnUpLoad = new JButton();
				getContentPane().add(btnUpLoad);
				btnUpLoad.setText("\u4e0a\u4f20");
				btnUpLoad.setBounds(59, 160, 78, 24);
				btnUpLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUpLoadActionPerformed(evt);
					}
				});
			}
			{
				btnUpdate = new JButton();
				getContentPane().add(btnUpdate);
				btnUpdate.setText("\u4fee\u6539");
				btnUpdate.setBounds(59, 212, 78, 24);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUpdateActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(722, 302);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//上传图像
	private void btnUpLoadActionPerformed(ActionEvent evt) {
		try {

				int Num = Integer.parseInt(txtSnum.getText());   
            	UpLoadImage(GetSavaPath(), Num); //上传照片
            	ShowImage();   //显示照片
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示失败：" + e.getMessage());
		}
	}
	
	//修改个人信息
	private void btnUpdateActionPerformed(ActionEvent evt) {
		Num=Integer.parseInt(txtSnum.getText()) ;
		Name=txtSname.getText();
		Sex=txtSex.getText();
		Birth=txtSbirthday.getText();
		Depart=txtDepart.getText();
		Id=txtSid.getText();
		Introduce=jEditorPane1.getText();
		Update(Num,Name,Sex,Birth,Depart,Id,Introduce);	
	}

	//展示个人信息
	public void ShowInfo(int num)
	{
		try {
       	    sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber,SImage ,SIntroduce FROM dbo.T_StudentInfo where Snum="+num+"");  //再执行查找操作，取出数据集
			while (rs.next()) {
				txtSex.setText(rs.getString(3));
				txtSbirthday.setText(rs.getString(4));
				txtDepart.setText(rs.getString(5));
				txtSid.setText(rs.getString(6));
				SImage=rs.getString(7);
				jEditorPane1.setText(rs.getString(8));				
			}
			JOptionPane.showMessageDialog(this, "查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"显示个人信息异常："+e.getMessage());
		}
	}
	
	// 展示图片
	public void ShowImage() {
		try {
			ImageIcon imageIcon = new ImageIcon(SImage);
			System.out.println(SImage);
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(156, 127,
					100));
			labImage.setIcon(imageIcon);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "图片显示异常：" + e.getMessage());
		}
	}
	
	//上传
    public void UpLoadImage(String imageString,int num){   	
    	try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="Update dbo.T_StudentInfo set Simage='"+imageString+"' where SNum="+num+"";
			sql.executeUpdate(sqlString);
			JOptionPane.showMessageDialog(this,"上传成功！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"SQL上传失败："+e.getMessage());
		}
    }
    
    //得到文件保存路径和文件名
    public String GetSavaPath()
    {
    	JFileChooser fc = new JFileChooser();
    	//选择文件类型
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("TXT and INI Files (.txt, .ini)", "txt","ini");
		FileNameExtensionFilter txt = new FileNameExtensionFilter("TXT Files (.txt)", "txt");
		FileNameExtensionFilter ini = new FileNameExtensionFilter("INI Files (.ini)", "ini");
		FileNameExtensionFilter xls = new FileNameExtensionFilter("XLS Files (.lxs)", "xls");
		FileNameExtensionFilter doc = new FileNameExtensionFilter("DOC Files (.doc)", "doc");
		
		fc.addChoosableFileFilter(fnef);
		fc.addChoosableFileFilter(txt);
		fc.addChoosableFileFilter(ini);
		fc.addChoosableFileFilter(xls);
		fc.addChoosableFileFilter(doc);

		fc.setDialogType(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("选择文件");
		fc.setMultiSelectionEnabled(false);
		fc.showOpenDialog(fc);
		
		if (fc.getSelectedFile()==null) {
			return null;
		}
		String filePath=fc.getSelectedFile().getPath();
		SImage=filePath;
		return filePath;
    }
    
	//JTable数据表绑定数据库，执行更新操作
	public void Update(int num, String name,String sex,String birth,String depart,String id ,String introduce ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			//String sqlString="insert into T_StudentInfo(Sname,Ssex,SBirthday,CDepart,SIdNumber ,SIntroduce) Values('"+name+"','"+sex+"','"+birth+"','"+depart+"','"+id+"','"+introduce+"')";// 插入语句
 			String sqlString="Update T_StudentInfo set Sname='"+name+"',Ssex='"+sex+"',SBirthday='"+birth+"',CDepart='"+depart+"',SIdNumber='"+id+"',SIntroduce='"+introduce+"' where Snum="+num+"";// 更新语句			
			sql.executeUpdate(sqlString);  //先执行更新操作
			
			JOptionPane.showMessageDialog(this, "修改成功！");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "修改异常：" + e.getMessage());
		}
	}
}
