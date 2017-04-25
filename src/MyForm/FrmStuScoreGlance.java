package MyForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import DBHelper.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FrmStuScoreGlance extends javax.swing.JFrame {
	ResultSet rs;	
	private JTable TScore;
	private JScrollPane jScrollPane1;
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "ѧ��", "����", "�γ̺�", "�γ���", "�ον�ʦ","ѧ��","�ɼ�" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
    public static int Count,n=0;
    public static String[][] stuScoreInfo;
    private int SNum;
    private String SName ;
    private String CNum ;
    private String CName;
    private String Credit;
    private int Grade;
	
	
	private JTabbedPane jTabbedPane1;
	public JButton btnBack;
	private JLabel jLabel1;
	public JTextField txtSNum;
	public JTextField txtSName;
	private JLabel jLabel2;
	public JButton btnNext;
	private JDesktopPane jDesktopPane1;
	private JDesktopPane jDesktopPane2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmStuScoreGlance inst = new FrmStuScoreGlance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmStuScoreGlance() {
		super();
		initGUI();
		this.setResizable(false);
		TScore.setEnabled(false);
		ShowStuScoreInfo();
		SetTextEnable();  //�����ı���Ϊֻ��
		GetStuScoreInfoText(0);
		try {
			SNum=Integer.parseInt(txtSNum.getText().trim());
			SName=txtSName.getText().trim();
			ShowTable(SNum,SName);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u6210\u7ee9\u6d4f\u89c8");
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1);
				jTabbedPane1.setBounds(0, 0, 625, 278);
				{
					jDesktopPane1 = new JDesktopPane();
					jTabbedPane1.addTab("ѡ�޿γɼ�", null, jDesktopPane1, null);
					jDesktopPane1.setBackground(new java.awt.Color(255,255,255));
					jDesktopPane1.setPreferredSize(new java.awt.Dimension(628, 241));
					{
						btnNext = new JButton();
						jDesktopPane1.add(btnNext, JLayeredPane.DEFAULT_LAYER);
						btnNext.setText("\u4e0b\u4e00\u6761>>");
						btnNext.setBounds(430, 207, 87, 24);
						btnNext.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnNextActionPerformed(evt);
							}
						});
					}
					{
						btnBack = new JButton();
						jDesktopPane1.add(btnBack, JLayeredPane.DEFAULT_LAYER);
						btnBack.setText("<<\u4e0a\u4e00\u6761");
						btnBack.setBounds(79, 207, 87, 24);
						btnBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnBackActionPerformed(evt);
							}
						});
					}
					{
						jLabel2 = new JLabel();
						jDesktopPane1.add(jLabel2, JLayeredPane.DEFAULT_LAYER);
						jLabel2.setText("\u59d3\u540d\uff1a");
						jLabel2.setBounds(323, 22, 50, 17);
					}
					{
						txtSName = new JTextField();
						jDesktopPane1.add(txtSName, JLayeredPane.DEFAULT_LAYER);
						txtSName.setBounds(373, 19, 121, 24);
					}
					{
						txtSNum = new JTextField();
						jDesktopPane1.add(txtSNum, JLayeredPane.DEFAULT_LAYER);
						txtSNum.setBounds(102, 20, 121, 24);
					}
					{
						jLabel1 = new JLabel();
						jDesktopPane1.add(jLabel1, JLayeredPane.DEFAULT_LAYER);
						jLabel1.setText("\u5b66\u53f7\uff1a");
						jLabel1.setBounds(52, 23, 50, 17);
					}
					{
						jScrollPane1 = new JScrollPane();
						jDesktopPane1.add(jScrollPane1, JLayeredPane.DEFAULT_LAYER);
						jScrollPane1.setBounds(20, 56, 577, 139);
						{
							TScore = new JTable();
							jScrollPane1.setViewportView(TScore);
							TScore.setModel(model);
						}
					}
				}
				{
					jDesktopPane2 = new JDesktopPane();
					jTabbedPane1.addTab("����ɼ�", null, jDesktopPane2, null);
					jDesktopPane2.setBackground(new java.awt.Color(255,255,255));
				}
			}
			pack();
			this.setSize(631, 307);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	//��һ��
	private void btnBackActionPerformed(ActionEvent evt) {
        Count--;
        btnNext.setEnabled(true);
        GetStuScoreInfoText(Count); 
        if (Count==0) {
			btnBack.setEnabled(false);
		}
		try {
			SNum=Integer.parseInt(txtSNum.getText().trim());
			SName=txtSName.getText().trim();
			ShowTable(SNum, SName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
		}       
	}
	//��һ��
	private void btnNextActionPerformed(ActionEvent evt) {
		Count++;
		btnBack.setEnabled(true);
		if (Count == n - 1) {
			btnNext.setEnabled(false);
		}
		GetStuScoreInfoText(Count);
		try {
			SNum=Integer.parseInt(txtSNum.getText().trim());
			SName=txtSName.getText().trim();
			ShowTable(SNum, SName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
		}
	}
	
	//�����ı���Ϊֻ��
		public void SetTextEnable()
		{
		/*	txtCName.setEditable(false);
			txtCNum.setEditable(false);
			txtCredit.setEditable(false);
			txtGrade.setEditable(false);*/
			txtSName.setEditable(false);
			txtSNum.setEditable(false);
			btnBack.setEnabled(false);
		}
		
		//չʾ��Ӧѧ����Ϣ
		public void ShowStuScoreInfo()
		{
			int i=0;
			stuScoreInfo=new String[1000][2];
			try{
				sql=dbUtil.ConnectDB().createStatement();
				String sqlString="SELECT DISTINCT T_SCInfo.Snum,dbo.T_StudentInfo.Sname FROM T_StudentInfo,dbo.T_SCInfo,dbo.T_CourseInfo WHERE dbo.T_StudentInfo.SNum=dbo.T_SCInfo.SNum AND dbo.T_CourseInfo.CNum=dbo.T_SCInfo.CNum ORDER BY T_SCInfo.Snum";
				rs=sql.executeQuery(sqlString);		

				while(rs.next()) {
					for (int j = 0; j < 2; j++) {
						stuScoreInfo[i][j]=rs.getString(j+1);
					}
					i++;
					n++;
				} 
				sql.close();
				dbUtil.ConnectClose();			
				JOptionPane.showMessageDialog(this,"��Ӱ��������"+n);		
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
			}
		}
		
		//����Ϣչʾ���ı���
		public void GetStuScoreInfoText(int n)
		{
		    txtSNum.setText(stuScoreInfo[n][0]);
			txtSName.setText(stuScoreInfo[n][1]);
			/*txtCNum.setText(stuScoreInfo[n][2]);
			txtCName.setText(stuScoreInfo[n][3]);
			txtCredit.setText(stuScoreInfo[n][5]);
			txtGrade.setText(stuScoreInfo[n][6]);*/	
		}
		
		// JTable���ݱ�����ݿ�
		public void ShowTable(int snum,String sname) {
	         try {
	        	sql = dbUtil.ConnectDB().createStatement();	
	        	String sqlString="SELECT T_SCInfo.Snum,dbo.T_StudentInfo.Sname,T_SCInfo.Cnum,Cname,CTeacherName,Ccredit,Grade FROM T_StudentInfo,dbo.T_SCInfo,dbo.T_CourseInfo WHERE dbo.T_StudentInfo.SNum=dbo.T_SCInfo.SNum AND dbo.T_CourseInfo.CNum=dbo.T_SCInfo.CNum AND T_SCInfo.Snum="+snum+" AND dbo.T_StudentInfo.Sname='"+sname+"'";
				rs = sql.executeQuery(sqlString);  //��ִ�в��Ҳ�����ȡ�����ݼ�
				FreshTable(rs);   //ˢ�����ݱ�
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "��ʾ�쳣��ѧ�Ż��������" );
			}
		}
		
		//�����ݿ��ı�ʱ����JTable��
		public int FreshTable(ResultSet rss) {
			int count=0;
			if (TScore.getRowCount() > 0) // ɾ����ǰ������
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
					v.addElement(rss.getString(7)); // �ܹ���7��
					model.addRow(v);
				}
				dbUtil.ConnectClose();
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,
						"FreshTable�쳣��" + e.getMessage());
			}
			TScore.setModel(model);
			validate();
			return count;
		}
}
