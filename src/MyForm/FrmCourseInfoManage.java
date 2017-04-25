package MyForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import DBHelper.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class FrmCourseInfoManage extends javax.swing.JFrame {
	//Ĭ��ѡ����к���Ϊ��
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "�γ̺�", "�γ���", "ѧ��", "ѧʱ", "�ον�ʦ","��ѡ����"};
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
	private  String CNum;   //��ѡ�����
	private  String CName;   //��ѡ�����
    private int CCredit;
    private String CTime ;
    private String TeacherName ;
    private int CLimitNum;
	private  int selectedRow;   //��ѡ�����
	private  int selectedCol;   //��ѡ�����	
	
	private JLabel jLabel1;
	private JTextField txtCnum;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTable TCourse;
	private JScrollPane jScrollPane1;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JTextField txtLimitNum;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JTextField txtCtime;
	private JTextField txtTeacherName;
	private JLabel jLabel4;
	private JTextField txtCredit;
	private JTextField txtCname;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmCourseInfoManage inst = new FrmCourseInfoManage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmCourseInfoManage() {
		super();
		initGUI();
		ShowTable();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u8bfe\u7a0b\u4fe1\u606f\u7ba1\u7406");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bfe\u7a0b\u53f7\uff1a");
				jLabel1.setBounds(42, 25, 66, 17);
			}
			{
				txtCnum = new JTextField();
				getContentPane().add(txtCnum);
				txtCnum.setBounds(108, 22, 146, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u8bfe\u7a0b\u540d\uff1a");
				jLabel2.setBounds(42, 62, 66, 17);
			}
			{
				txtCname = new JTextField();
				getContentPane().add(txtCname);
				txtCname.setBounds(108, 59, 146, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5b66\u5206\uff1a");
				jLabel3.setBounds(307, 25, 54, 17);
			}
			{
				txtCredit = new JTextField();
				getContentPane().add(txtCredit);
				txtCredit.setBounds(361, 22, 146, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u4efb\u8bfe\u6559\u5e08\uff1a");
				jLabel4.setBounds(29, 103, 79, 17);
			}
			{
				txtTeacherName = new JTextField();
				getContentPane().add(txtTeacherName);
				txtTeacherName.setBounds(108, 99, 146, 24);
			}
			{
				txtCtime = new JTextField();
				getContentPane().add(txtCtime);
				txtCtime.setBounds(361, 59, 146, 24);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u5b66\u65f6\uff1a");
				jLabel5.setBounds(307, 62, 54, 17);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u9650\u9009\u4eba\u6570\uff1a");
				jLabel6.setBounds(283, 102, 78, 17);
			}
			{
				txtLimitNum = new JTextField();
				getContentPane().add(txtLimitNum);
				txtLimitNum.setBounds(361, 99, 146, 24);
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(80, 146, 70, 24);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnUpdate = new JButton();
				getContentPane().add(btnUpdate);
				btnUpdate.setText("\u4fee\u6539");
				btnUpdate.setBounds(260, 146, 69, 24);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnUpdateActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(436, 146, 70, 24);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(18, 186, 551, 163);
				{
					TCourse = new JTable();
					jScrollPane1.setViewportView(TCourse);
					TCourse.setModel(model);
					GetSelectInfo();
					TCourse.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							TCourseMouseClicked(evt);
						}
					});
				}
			}
			pack();
			this.setSize(600, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void TCourseMouseClicked(MouseEvent evt) {
		PrintInfo();
	}
	
	//���ѡ����Ϣ�¼�
	private void btnAddActionPerformed(ActionEvent evt) {
        CNum=txtCnum.getText();
        CName=txtCname.getText();
        CCredit=Integer.parseInt(txtCredit.getText());
        CTime=txtCtime.getText();
        TeacherName=txtTeacherName.getText();
        CLimitNum=Integer.parseInt(txtLimitNum.getText());
        
        Insert(CNum, CName, CCredit, CTime, TeacherName, CLimitNum);
        TCourse.repaint();  //�����ػ�
		TCourse.updateUI();  //����UI����
	}
	
	//����ѡ����Ϣ�¼�
	private void btnUpdateActionPerformed(ActionEvent evt) {
        CNum=txtCnum.getText();
        CName=txtCname.getText();
        CCredit=Integer.parseInt(txtCredit.getText());
        CTime=txtCtime.getText();
        TeacherName=txtTeacherName.getText();
        CLimitNum=Integer.parseInt(txtLimitNum.getText());
        
        Update(CNum, CName, CCredit, CTime, TeacherName, CLimitNum);
        TCourse.repaint();  //�����ػ�
		TCourse.updateUI();  //����UI����       
	}
	
	//ɾ��ѡ����Ϣ�¼�
	private void btnDeleteActionPerformed(ActionEvent evt) {
		CNum=txtCnum.getText();
		int i = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ���ÿγ̣�", "��ʾ��",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			if (DelectCount(CNum)>15) {
				JOptionPane.showMessageDialog(this,"�ÿγ�ѡ����������15��ֹɾ��������");
			}else {
			Delete(CNum);
			// ����ı�������
			txtCname.setText("");
			txtCnum.setText("");
			txtCredit.setText("");
			txtCtime.setText("");
			txtLimitNum.setText("");
			txtTeacherName.setText("");
			}
		}
        TCourse.repaint();  //�����ػ�
		TCourse.updateUI();  //����UI����    
	}
	
	//�����Ӧ�е���Ϣ��ӳ�䵽�ı�����
	public void PrintInfo()
	{
		Vector data = ((DefaultTableModel)TCourse.getModel()).getDataVector();
		Vector rowData =(Vector)data.get(selectedRow);
        String field = (String)rowData.get(selectedCol);
        txtCnum.setText((String)rowData.get(0));
        txtCname.setText((String)rowData.get(1));
        txtCredit.setText((String)rowData.get(2));        
        txtCtime.setText((String)rowData.get(3));
        txtLimitNum.setText((String)rowData.get(5));
        txtTeacherName.setText((String)rowData.get(4));

        System.out.println("��ѡ����ǣ�"+field);
	}
	
	public void GetSelectInfo()  //�õ���ѡ����к��е�ֵ
	{		
		TCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (ALLOW_ROW_SELECTION) {      // true by default
			ListSelectionModel rowSM = TCourse.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No rows are selected. ");
					} else {
					    selectedRow = lsm.getMinSelectionIndex();
						System.out.println("Row " + selectedRow
								+ " is now selected. ");
					}
				}
			});
		}
		else {
			TCourse.setRowSelectionAllowed(false);
		}
		if (ALLOW_COLUMN_SELECTION) { // false by default
			if (ALLOW_ROW_SELECTION) {
				// We allow both row and column selection, which
				// implies that we *really* want to allow individual
				// cell selection.
				TCourse.setCellSelectionEnabled(true);
			}
			TCourse.setColumnSelectionAllowed(true);
			ListSelectionModel colSM = TCourse.getColumnModel()
					.getSelectionModel();
			colSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No columns are selected. ");
					} else {
					    selectedCol = lsm.getMinSelectionIndex();
						System.out.println("Column " + selectedCol
								+ " is now selected. ");
					}
				}
			});
		}
	}
	
	// JTable���ݱ�����ݿ�
	public void ShowTable() {
         try {
        	sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT Cnum,Cname,Ccredit,CClassTime,CTeacherName,CLimitNum from T_CourseInfo");  //��ִ�в��Ҳ�����ȡ�����ݼ�
			FreshTable(rs);   //ˢ�����ݱ�
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "��ʾ�쳣��" + e.getMessage());
		}
	}
	
	
	//�����ݿ��ı�ʱ����JTable��
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TCourse.getRowCount() > 0) // ɾ����ǰ������
		{
			for (int i = TCourse.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TCourse.getModel()).removeRow(i);
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
				v.addElement(rss.getString(6));// �ܹ���6��
				model.addRow(v);
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable�쳣��" + e.getMessage());
		}
		TCourse.setModel(model);
		validate();
		return count;
	}
	
	//JTable���ݱ�����ݿ⣬ִ�в������
	public int Insert(String cnum, String cname,int ccredit,String cclassTime,String cteacherName,int climitNum ) {
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="insert into T_CourseInfo(CNum,CName,CCredit,CClassTime,CTeacherName ,CLimitNum) Values('"+cnum+"','"+cname+"',"+ccredit+",'"+cclassTime+"','"+cteacherName+"',"+climitNum+")";// �������			
			sql.executeUpdate(sqlString);  //��ִ�в������
			
			ShowTable();  //ˢ���б�
			JOptionPane.showMessageDialog(this, "��ӳɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "����쳣��" + e.getMessage());
		}
         return n;
	}
	
	//JTable���ݱ�����ݿ⣬ִ�и��²���
	public void Update(String cnum, String cname,int ccredit,String cclassTime,String cteacherName,int climitNum ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Update T_CourseInfo set Cname='"+cname+"',Ccredit="+ccredit+",CclassTime='"+cclassTime+"',CTeacherName='"+cteacherName+"', ClimitNum="+climitNum+" where CNum='"+cnum+"'";// �������			
			sql.executeUpdate(sqlString);  //��ִ�и��²���
			
			ShowTable();  //ˢ���б�
			JOptionPane.showMessageDialog(this, "���³ɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "�����쳣��" + e.getMessage());
		}
	}
	
	//JTable���ݱ�����ݿ⣬ִ��ɾ������(ɾ��ѧ��������Ϣ��ѧ��ѡ����Ϣ)
	public void Delete(String cnum) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();	
 			String sqlString="Delete T_CourseInfo  where cnum='"+cnum+"'";    // ɾ��������Ϣ���	
			sql.executeUpdate(sqlString);  //��ִ��ɾ������
            
			
			ShowTable();  //ˢ���б�
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "ɾ���쳣��" + e.getMessage());
		}
	}
	
	public int DelectCount(String num)
	{
		int count=0;
		try {
		sql=dbUtil.ConnectDB().createStatement();
		String sqlString="Select CNumSelected from T_CourseInfo where CNum='"+num+"'";
		rs=sql.executeQuery(sqlString);
		while(rs.next())
		{
			count=Integer.parseInt(rs.getString(1));
		}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"ѡ�������쳣��"+e.getMessage());
		}
		return count;		
	}
	
	

}
