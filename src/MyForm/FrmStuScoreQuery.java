package MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import DBHelper.DBUtil;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


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
public class FrmStuScoreQuery extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "学号", "姓名", "课程号", "课程名", "任课教师","学分","成绩" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
    private int SNum;
    private String SName ;
    private String CNum ;
    private String CName;
    private String Credit;
    private int Grade;
	
	private JScrollPane jScrollPane1;
	private JTable TScore;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel1;
	public JTextField txtSNum;
	private JLabel jLabel2;
	public JTextField txtSName;
	private JButton btnSelect;
	private JTextField txtFilePath;
	private JButton btnSelectFilePath;
	private JButton btnImputExcel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStuScoreQuery inst = new FrmStuScoreQuery();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuScoreQuery() {
		super();
		initGUI();
		this.setResizable(false);
		TScore.setEnabled(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u6210\u7ee9\u67e5\u8be2");
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 134, 596, 159);
				{
					TScore = new JTable();
					jScrollPane1.setViewportView(TScore);
					TScore.setModel(model);
				}
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5b66\u751f\u6210\u7ee9\u5217\u8868\uff1a");
				jLabel3.setBounds(12, 111, 112, 17);
			}
			{
				btnImputExcel = new JButton();
				getContentPane().add(btnImputExcel);
				btnImputExcel.setText("\u5bfc\u51faExcel");
				btnImputExcel.setBounds(487, 99, 98, 24);
				btnImputExcel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnImputExcelActionPerformed(evt);
					}
				});
			}
			{
				btnSelectFilePath = new JButton();
				getContentPane().add(btnSelectFilePath);
				btnSelectFilePath.setText("***");
				btnSelectFilePath.setBounds(411, 67, 61, 24);
				btnSelectFilePath.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSelectFilePathActionPerformed(evt);
					}
				});
			}
			{
				txtFilePath = new JTextField();
				getContentPane().add(txtFilePath);
				txtFilePath.setBounds(149, 67, 264, 24);
			}
			{
				btnSelect = new JButton();
				getContentPane().add(btnSelect);
				btnSelect.setText("\u67e5\u627e");
				btnSelect.setBounds(481, 26, 98, 24);
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSelectActionPerformed(evt);
					}
				});
			}
			{
				txtSName = new JTextField();
				getContentPane().add(txtSName);
				txtSName.setBounds(289, 26, 125, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d\uff1a");
				jLabel2.setBounds(241, 30, 48, 17);
			}
			{
				txtSNum = new JTextField();
				getContentPane().add(txtSNum);
				txtSNum.setBounds(73, 26, 128, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5b66\u53f7\uff1a");
				jLabel1.setBounds(28, 29, 45, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9009\u62e9\u6587\u4ef6\u5bfc\u51fa\u8def\u5f84\uff1a");
				jLabel4.setBounds(27, 68, 123, 23);
			}
			pack();
			this.setSize(626, 334);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//查找学生成绩
    private void btnSelectActionPerformed(ActionEvent evt) {
		if (txtSNum.getText().equals("") || txtSName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "学号和姓名不能为空！");
		} else {
			try {
				SNum = Integer.parseInt(txtSNum.getText().trim());
				SName=txtSName.getText().trim();
				ShowTable(SNum,SName);
			} catch (Exception e) {
				if (TScore.getRowCount() > 0) // 删除以前的数据
				{
					for (int i = TScore.getRowCount() - 1; i >= 0; i--) {
						((DefaultTableModel) TScore.getModel()).removeRow(i);
					}
				}
				JOptionPane.showMessageDialog(this, "显示异常：学号或密码错误！" );
			}
		}
    }
    //导出
    private void btnImputExcelActionPerformed(ActionEvent evt) {
        try {
        	String FilePath=txtFilePath.getText();
        	if (FilePath.equals("")) {
				JOptionPane.showMessageDialog(this,"路径不能为空！");
			}else {
			    exportTable(TScore, new File(FilePath));
			    JOptionPane.showMessageDialog(this,"导出文件到Exclec成功！");				
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"异常："+e.getMessage());
		}
    }
    //选择保存路径
    private void btnSelectFilePathActionPerformed(ActionEvent evt) {
    	txtFilePath.setText(GetSavaPath());  
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
		fc.showSaveDialog(fc);
		
		
		if (fc.getSelectedFile()==null) {
			return null;
		}
		String filePath=fc.getSelectedFile().getPath();
		return filePath;
    }
    
	   public void exportTable(JTable table, File file) throws IOException {  
	        try {  
	            OutputStream out = new FileOutputStream(file);  
	            TableModel model = table.getModel();  
	            WritableWorkbook wwb = Workbook.createWorkbook(out);  
	            // 创建字表，并写入数据  
	            WritableSheet ws = wwb.createSheet("中文", 0);  
	            // 添加标题  
	            for (int i = 0; i < model.getColumnCount(); i++) {  
	                jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));  
	                try {  
	                    ws.addCell(labelN);  
	                } catch (RowsExceededException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                } catch (WriteException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  
	            }  
	            // 添加列  
	            for (int i = 0; i < model.getColumnCount(); i++) {  
	                for (int j = 1; j <= model.getRowCount(); j++) {  
	                    jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());  
	                    try {  
	                        ws.addCell(labelN);  
	                    } catch (RowsExceededException e) {  
	                        e.printStackTrace();  
	                    } catch (WriteException e) {  
	                        e.printStackTrace();  
	                    }  
	                }  
	            }  
	            wwb.write();  
	            try {  
	                wwb.close();  
	            } catch (WriteException e) {  
	                e.printStackTrace();  
	            }  
	        } catch (FileNotFoundException e) {  
	            JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");  
	        }  
	    } 
	   
	// JTable数据表绑定数据库
		public void ShowTable(int snum,String sname) {
	         try {
	        	sql = dbUtil.ConnectDB().createStatement();	
	        	String sqlString="SELECT T_SCInfo.Snum,dbo.T_StudentInfo.Sname,T_SCInfo.Cnum,Cname,CTeacherName,Ccredit,Grade FROM T_StudentInfo,dbo.T_SCInfo,dbo.T_CourseInfo WHERE dbo.T_StudentInfo.SNum=dbo.T_SCInfo.SNum AND dbo.T_CourseInfo.CNum=dbo.T_SCInfo.CNum AND T_SCInfo.Snum="+snum+" AND dbo.T_StudentInfo.Sname='"+sname+"'";
				rs = sql.executeQuery(sqlString);  //再执行查找操作，取出数据集
				FreshTable(rs);   //刷新数据表
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "显示异常：学号或密码错误！" );
			}
		}
		
		//当数据库表改变时更新JTable表
		public int FreshTable(ResultSet rss) {
			int count=0;
			if (TScore.getRowCount() > 0) // 删除以前的数据
			{
				for (int i = TScore.getRowCount() - 1; i >= 0; i--) {
					((DefaultTableModel) TScore.getModel()).removeRow(i);
				}
			}
			try {
				while (rss.next()) {
					Vector<Object> v = new Vector<Object>();
					v.addElement(rss.getString(1));
					v.addElement(rss.getString(2));
					v.addElement(rss.getString(3));
					v.addElement(rss.getString(4));
					v.addElement(rss.getString(5));
					v.addElement(rss.getString(6));
					v.addElement(rss.getString(7)); // 总共有7列
					model.addRow(v);
				}
				dbUtil.ConnectClose();
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,
						"FreshTable异常：" + e.getMessage());
			}
			TScore.setModel(model);
			validate();
			return count;
		}
}
