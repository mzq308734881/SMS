package MyForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JEditorPane;
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
public class FrmCollegeInfoGlance extends javax.swing.JFrame {
	//Ĭ��ѡ����к���Ϊ��
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    Object header[] = { "Ժϵ", "���", "����", "��̬����" };
	Object str[][] = new String[0][0];
	DefaultTableModel model = new DefaultTableModel(str, header);
	private  int selectedRow;   //��ѡ�����
	private  int selectedCol;   //��ѡ�����
	private int PeopleNum=0;
	private String DepartName;
	private String DepIntroduce;
	private String DepNews;
	
	
	private JLabel jLabel1;
	private JTextField txtDepartName;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTable TCollege;
	private JButton btnDelete;
	private JButton btnFresh;
	private JButton btnAdd;
	private JScrollPane jScrollPane1;
	private JEditorPane txtNews;
	private JLabel jLabel4;
	private JEditorPane txtIntroduce;
	private JTextField txtPeopleNum;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmCollegeInfoGlance inst = new FrmCollegeInfoGlance();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmCollegeInfoGlance() {
		super();
		initGUI();
		ShowTable();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u9662\u7cfb\u4fe1\u606f\u7ba1\u7406");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u9662\u7cfb\uff1a");
				jLabel1.setBounds(39, 18, 50, 17);
			}
			{
				txtDepartName = new JTextField();
				getContentPane().add(txtDepartName);
				txtDepartName.setBounds(89, 15, 171, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u4eba\u6570\uff1a");
				jLabel2.setBounds(39, 58, 52, 17);
			}
			{
				txtPeopleNum = new JTextField();
				getContentPane().add(txtPeopleNum);
				txtPeopleNum.setBounds(89, 55, 91, 24);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9662\u7cfb\u7b80\u4ecb\uff1a");
				jLabel3.setBounds(16, 99, 68, 17);
			}
			{
				txtIntroduce = new JEditorPane();
				getContentPane().add(txtIntroduce);
				txtIntroduce.setText("jEditorPane1");
				txtIntroduce.setBounds(87, 99, 173, 115);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u65b0\u95fb\u52a8\u6001\uff1a");
				jLabel4.setBounds(16, 230, 67, 17);
			}
			{
				txtNews = new JEditorPane();
				getContentPane().add(txtNews);
				txtNews.setText("jEditorPane1");
				txtNews.setBounds(85, 228, 174, 122);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(283, 15, 289, 213);
				{
					TCollege = new JTable();
					jScrollPane1.setViewportView(TCollege);
					TCollege.setModel(model);
					TCollege.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							TCollegeMouseClicked(evt);
						}
					});
					GetSelectInfo();
				}
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(283, 282, 67, 24);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnFresh = new JButton();
				getContentPane().add(btnFresh);
				btnFresh.setText("\u5237\u65b0");
				btnFresh.setBounds(388, 282, 69, 24);
				btnFresh.setOpaque(false);
				btnFresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnFreshActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(493, 282, 70, 24);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
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

	// ���������Ӧ�¼�
	private void TCollegeMouseClicked(MouseEvent evt) {
		PrintInfo();
	}

	//���ѧԺ��Ϣ�¼�
	private void btnAddActionPerformed(ActionEvent evt) {
		try {
			PeopleNum = Integer.parseInt(txtPeopleNum.getText());
			DepartName = txtDepartName.getText();
			DepIntroduce = txtIntroduce.getText();
			DepNews = txtNews.getText();
			Insert(PeopleNum, DepartName, DepNews, DepIntroduce);
			TCollege.repaint(); // �����ػ�
			TCollege.updateUI(); // ����UI����
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
		}
	}

	//ˢ���¼�
	private void btnFreshActionPerformed(ActionEvent evt) {
		try {
			PeopleNum = Integer.parseInt(txtPeopleNum.getText());
			DepartName = txtDepartName.getText();
			DepIntroduce = txtIntroduce.getText();
			DepNews = txtNews.getText();
			Update(PeopleNum, DepartName, DepNews, DepIntroduce);
			TCollege.repaint(); // �����ػ�
			TCollege.updateUI(); // ����UI����
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"�쳣��"+e.getMessage());
		}
	}
	
	//ɾ��ѧԺ��Ϣ�¼�
	private void btnDeleteActionPerformed(ActionEvent evt) {
		DepartName=txtDepartName.getText();
		int i = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ����Ժϵ��", "��ʾ��",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			if (GetCollegeLimit(DepartName)) {
				JOptionPane.showMessageDialog(this,"��ϵ���ж���ѡ�ν�ֹɾ��������");
			}
			else {
			Delete(DepartName);
			// ����ı�������
			txtPeopleNum.setText("");
			txtDepartName.setText("");
			txtIntroduce.setText("");
			txtNews.setText("");
			}

		}
		TCollege.repaint(); // �����ػ�
		TCollege.updateUI(); // ����UI����
	}
	
	public void GetSelectInfo()  //�õ���ѡ����к��е�ֵ
	{		
		TCollege.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (ALLOW_ROW_SELECTION) {      // true by default
			ListSelectionModel rowSM = TCollege.getSelectionModel();
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
			TCollege.setRowSelectionAllowed(false);
		}
		if (ALLOW_COLUMN_SELECTION) { // false by default
			if (ALLOW_ROW_SELECTION) {
				// We allow both row and column selection, which
				// implies that we *really* want to allow individual
				// cell selection.
				TCollege.setCellSelectionEnabled(true);
			}
			TCollege.setColumnSelectionAllowed(true);
			ListSelectionModel colSM = TCollege.getColumnModel()
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
	
	//�����Ӧ�е���Ϣ��ӳ�䵽�ı�����
	public void PrintInfo()
	{
		Vector data = ((DefaultTableModel)TCollege.getModel()).getDataVector();
		Vector rowData =(Vector)data.get(selectedRow);
        String field = (String)rowData.get(selectedCol);
        txtDepartName.setText((String)rowData.get(0));
        txtIntroduce.setText((String)rowData.get(1));
        txtPeopleNum.setText((String)rowData.get(2));        
        txtNews.setText((String)rowData.get(3));
        System.out.println("��ѡ����ǣ�"+field);
	}	
	
	// JTable���ݱ�����ݿ�
	public void ShowTable() {
		//String sql = "insert into people values(" + id + ",'" + name+ "','" + introduction + "')";
         try {
        	sql = dbUtil.ConnectDB().createStatement();			
			rs = sql.executeQuery("SELECT DDepart,DIntroduce,DPeopleNumber,DNews from T_CollegeInfo");  //��ִ�в��Ҳ�����ȡ�����ݼ�
			FreshTable(rs);   //ˢ�����ݱ�
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "��ʾ�쳣��" + e.getMessage());
		}
	}
	
	//�����ݿ��ı�ʱ����JTable��
	public int FreshTable(ResultSet rss) {
		int count=0;
		if (TCollege.getRowCount() > 0) // ɾ����ǰ������
		{
			for (int i = TCollege.getRowCount() - 1; i >= 0; i--) {
				((DefaultTableModel) TCollege.getModel()).removeRow(i);
			}
		}
		try {
			while (rss.next()) {
				Vector<Object> v = new Vector<Object>();
				v.addElement(rss.getString(1));
				v.addElement(rss.getString(2));
				v.addElement(rss.getString(3));
				v.addElement(rss.getString(4));// �ܹ���7��
				model.addRow(v);
			}
			dbUtil.ConnectClose();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,
					"FreshTable�쳣��" + e.getMessage());
		}
		TCollege.setModel(model);
		validate();
		return count;
	}
	
	//JTable���ݱ�����ݿ⣬ִ�в������
	public int Insert(int num,String depart,String news ,String introduce ) {
		int n=0;
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="insert into T_CollegeInfo(DDepart,DIntroduce,DPeopleNumber,DNews) Values('"+depart+"','"+introduce+"','"+num+"','"+news+"')";// �������	
			sql.executeUpdate(sqlString);  //��ִ�в������
			ShowTable();
			JOptionPane.showMessageDialog(this, "��ӳɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "����쳣��" + e.getMessage());
		}
         return n;
	}
	
	//JTable���ݱ�����ݿ⣬ִ��ɾ������(ɾ��ѧ��������Ϣ��ѧ��ѡ����Ϣ)
	public void Delete(String depart ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Delete T_CollegeInfo  where  DDepart='"+depart+"'";// ɾ��������Ϣ���	
			sql.executeUpdate(sqlString);  //��ִ��ɾ������
			
			ShowTable();
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "ɾ���쳣��" + e.getMessage());
		}
	}
	
	//JTable���ݱ�����ݿ⣬ִ�и��²���
	public void Update(int num,String depart , String news ,String introduce ) {
         try {
        	sql = dbUtil.ConnectDB().createStatement();
 			String sqlString="Update T_CollegeInfo set DPeopleNumber='"+num+"',DIntroduce='"+introduce+"',DNews='"+news+"' where DDepart='"+depart+"' ";// �������			
			sql.executeUpdate(sqlString);  //��ִ�и��²���
			
			ShowTable();
			JOptionPane.showMessageDialog(this, "���³ɹ���");
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "�����쳣��" + e.getMessage());
		}
	}
	
	public boolean GetCollegeLimit(String depart)
	{
		boolean f=false;
		int count=0;
		try {
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="select * from T_StudentInfo where CDepart='"+depart+"'";
			rs=sql.executeQuery(sqlString);
			while(rs.next())
			{
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (count>0) {
			f=true;
		}
		return f;
	}
}
