package demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class MyTest extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
	
	private JButton btnOpenImage;
	private JButton btnUpLoad;
	private JButton btnShow;
	private JTextField txtNum;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField txtImagePath;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyTest inst = new MyTest();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyTest() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("JavaDemo\u4e4b\u6570\u636e\u5e93Image\u663e\u793a\u4e0a\u4f20");
			{
				btnOpenImage = new JButton();
				getContentPane().add(btnOpenImage);
				btnOpenImage.setText("\u9009\u62e9\u56fe\u7247\u6587\u4ef6");
				btnOpenImage.setBounds(429, 280, 92, 24);
				btnOpenImage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnOpenImageActionPerformed(evt);
					}
				});
			}
			{
				txtImagePath = new JTextField();
				getContentPane().add(txtImagePath);
				txtImagePath.setBounds(61, 280, 368, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(61, 60, 461, 193);
				jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5b66\u53f7\uff1a");
				jLabel2.setBounds(45, 25, 60, 17);
			}
			{
				txtNum = new JTextField();
				getContentPane().add(txtNum);
				txtNum.setBounds(108, 22, 143, 24);
			}
			{
				btnShow = new JButton();
				getContentPane().add(btnShow);
				btnShow.setText("\u663e\u793a");
				btnShow.setBounds(309, 22, 69, 24);
				btnShow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnShowActionPerformed(evt);
					}
				});
			}
			{
				btnUpLoad = new JButton();
				getContentPane().add(btnUpLoad);
				btnUpLoad.setText("\u4e0a\u4f20");
				btnUpLoad.setBounds(421, 22, 67, 24);
				btnUpLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUpLoadActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(597, 362);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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
		return filePath;
    }
    
    private void btnOpenImageActionPerformed(ActionEvent evt) {
    	JOptionPane.showMessageDialog(this,"打开");
    	String pathString=GetSavaPath();
        txtImagePath.setText(pathString);
        jLabel1.setIcon(new ImageIcon(pathString));
    }
    //读取数据库Image
    private void btnShowActionPerformed(ActionEvent evt) {
		try {
			if (txtNum.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "学号不能为空！");
			} else {
				int Num = Integer.parseInt(txtNum.getText());   
            	jLabel1.setIcon(new ImageIcon(ShowImage(Num)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "显示失败：" + e.getMessage());
		}
    }
    //上传Image至数据库
	private void btnUpLoadActionPerformed(ActionEvent evt) {
		try {
			if (txtNum.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "学号不能为空！");
			} else {
				String imageString = txtImagePath.getText();
				int Num = Integer.parseInt(txtNum.getText());
				UpLoadImage(imageString, Num);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "上传失败：" + e.getMessage());
		}
	}
    
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
    
    public String ShowImage(int num){
    	String imageString="";
    	try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="select Simage from dbo.T_StudentInfo where SNum="+num+"";
			rs=sql.executeQuery(sqlString);
            dbUtil.ConnectClose();
            rs.close();
			while(rs.next())
			{
				imageString=rs.getString(1).trim();
			 	JOptionPane.showMessageDialog(this,"显示成功！");
			}	
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"SQL上传失败："+e.getMessage());
		}
    	return imageString;
    }

}
