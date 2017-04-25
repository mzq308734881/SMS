package MyForm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

/*
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
*/
import DBHelper.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FrmStuBasicInfoQuery extends javax.swing.JFrame {
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "ѧ��", "����", "�Ա�", "��������", "����ϵ","���֤��","���˼��" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
    private int Num;
    private String Name ;
    private String Sex ;
    private String Birth;
    private String Depart;
    private String Id;
    private String Introduce;
	
	private JButton btnSelect;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton btnSelectFilePath;
	private JTextField txtFilePath;
	private JLabel jLabel4;
	private JTable TStuInfo;
	private JScrollPane jScrollPane1;
	private JButton btnImputExcel;
	public JTextField txtSName;
	public JTextField txtNum;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		/*try {
			//SubstanceSkin skin  =   new  OfficeBlue2007Skin();
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
			//UIManager.setLookAndFeel( new  SubstanceOfficeBlue2007LookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel
					.setCurrentTheme(new SubstanceTerracottaTheme());
			SubstanceLookAndFeel.setSkin(new OfficeBlue2007Skin());
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
				FrmStuBasicInfoQuery inst = new FrmStuBasicInfoQuery();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuBasicInfoQuery() {
		super();
		initGUI();
		this.setResizable(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.setTitle("\u67e5\u770b\u5b66\u751f\u4fe1\u606f");
			{
				btnSelect = new JButton();
				getContentPane().add(btnSelect);
				btnSelect.setText("\u67e5\u627e");
				btnSelect.setBounds(469, 26, 98, 24);
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSelectActionPerformed(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5b66\u53f7\uff1a");
				jLabel1.setBounds(28, 29, 45, 17);
			}
			{
				txtNum = new JTextField();
				getContentPane().add(txtNum);
				txtNum.setBounds(73, 26, 128, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u59d3\u540d\uff1a");
				jLabel2.setBounds(241, 30, 48, 17);
			}
			{
				txtSName = new JTextField();
				getContentPane().add(txtSName);
				txtSName.setBounds(289, 26, 125, 24);
			}
			{
				btnImputExcel = new JButton();
				getContentPane().add(btnImputExcel);
				btnImputExcel.setText("\u5bfc\u51faExcel");
				btnImputExcel.setBounds(469, 101, 98, 24);
				btnImputExcel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnImputExcelActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(27, 136, 540, 201);
				{
					TStuInfo = new JTable();
					TStuInfo.setEnabled(false);
					jScrollPane1.setViewportView(TStuInfo);
					TStuInfo.setModel(model);
				}
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5b66\u751f\u4fe1\u606f\u5217\u8868\uff1a");
				jLabel3.setBounds(27, 111, 112, 17);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9009\u62e9\u6587\u4ef6\u5bfc\u51fa\u8def\u5f84\uff1a");
				jLabel4.setBounds(27, 70, 122, 17);
			}
			{
				txtFilePath = new JTextField();
				getContentPane().add(txtFilePath);
				txtFilePath.setBounds(149, 67, 264, 24);
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
			pack();
			this.setSize(600, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//����ָ��ѧ����Ϣ
	private void btnSelectActionPerformed(ActionEvent evt) {
		if (txtNum.getText().equals("") || txtSName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "ѧ�ź���������Ϊ�գ�");
		} else {
			try {
				Num = Integer.parseInt(txtNum.getText());
				ShowTable(Num);
			} catch (Exception e) {
				if (TStuInfo.getRowCount() > 0) // ɾ����ǰ������
				{
					for (int i = TStuInfo.getRowCount() - 1; i >= 0; i--) {
						((DefaultTableModel) TStuInfo.getModel()).removeRow(i);
					}
				}
				JOptionPane.showMessageDialog(this, "��ʾ�쳣��ѧ�Ż��������" );
			}
		}
	}

	//������Excel���
	private void btnImputExcelActionPerformed(ActionEvent evt) {
        try {
        	String FilePath=txtFilePath.getText();
        	if (FilePath.equals("")) {
				JOptionPane.showMessageDialog(this,"·������Ϊ�գ�");
			}else {
			    exportTable(TStuInfo, new File(FilePath));
			    JOptionPane.showMessageDialog(this,"�����ļ���Exclec�ɹ���");				
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
		}
	}
	
	//ѡ�񱣴��ļ�·��
	private void btnSelectFilePathActionPerformed(ActionEvent evt) {
		txtFilePath.setText(GetSavaPath());       
	}
	
	// JTable���ݱ�����ݿ�
	public void ShowTable(int snum) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Snum,Sname,Ssex, convert(varchar(10),dbo.T_StudentInfo.SBirthday,120),CDepart,SIdNumber ,SIntroduce FROM dbo.T_StudentInfo where snum="+snum+"");  //��ִ�в��Ҳ�����ȡ�����ݼ�
			FreshTable(rs);   //ˢ�����ݱ�
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "��ʾ�쳣��ѧ�Ż��������" );
		}
	}
	
	//�����ݿ��ı�ʱ����JTable��
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TStuInfo.getRowCount() > 0) // ɾ����ǰ������
		{
			for (int i = TStuInfo.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TStuInfo.getModel()).removeRow(i);
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
				v.addElement(rss.getString(7)); // �ܹ���7��
				model.addRow(v);
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable�쳣��" + e.getMessage());
		}
		TStuInfo.setModel(model);
		validate();
		return count;
	}
	
	   public void exportTable(JTable table, File file) throws IOException {  
	        try {  
	            OutputStream out = new FileOutputStream(file);  
	            TableModel model = table.getModel();  
	            WritableWorkbook wwb = Workbook.createWorkbook(out);  
	            // �����ֱ���д������  
	            WritableSheet ws = wwb.createSheet("����", 0);  
	            // ��ӱ���  
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
	            // �����  
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
	            JOptionPane.showMessageDialog(null, "��������ǰ��رչ�����");  
	        }  
	    }  

	    //�õ��ļ�����·�����ļ���
	    public String GetSavaPath()
	    {
	    	JFileChooser fc = new JFileChooser();
	    	//ѡ���ļ�����
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
			fc.setDialogTitle("ѡ���ļ�");
			fc.setMultiSelectionEnabled(false);
			fc.showSaveDialog(fc);
			
			
			if (fc.getSelectedFile()==null) {
				return null;
			}
			String filePath=fc.getSelectedFile().getPath();
			return filePath;
	    }
}
