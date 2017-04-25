package MyForm;
import DBHelper.DBUtil;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import javax.swing.*;
/*
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;
import org.jvnet.substance.skin.ChallengerDeepSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;*/

import java.applet.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class FrmMain extends JFrame {
	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String UserNum;
	public static String UserRole;
	ResultSet rs;	
	DBUtil dbUtil=new DBUtil();
    Statement sql=null;
    Statement sqlSC=null;
    ComboBoxModel cobCourseModel=null;
	public static String[]  CourseName;
    
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenuItem btnPwdChange;
	private JMenuItem btnStuBasicInfoQuery;
	private JMenuItem btnStuBasicInfoGlance;
	private JLabel labTime;
	private JLabel JLable8;
	public JLabel labRole;
	private JLabel jLabel6;
	public JLabel labUser;
	private JLabel jLabel4;
	private JToolBar jToolBar1;
	private JLabel labImage;
	private JMenuItem btnCollegeInfoGlance;
	private JMenu jMenu11;
	private JMenuItem btnCourseGradeInfo;
	private JMenu jMenu10;
	private JMenuItem btnCourseInfoQuery;
	private JMenuItem btnCourseInfoGlance;
	private JMenuItem btnStuScoreQuery;
	private JMenuItem btnStuScoreGlance;
	private JMenu jMenu9;
	private JMenu jMenu5;
	private JMenu jMenu4;
	private JMenuItem btnPersonInfoManage;
	private JMenuItem btnStudentInfoAdd;
	private JMenu jMenu3;
	private JSeparator jSeparator11;
	private JSeparator jSeparator10;
	private JSeparator jSeparator9;
	private JSeparator jSeparator8;
	private JSeparator jSeparator7;
	private JSeparator jSeparator6;
	private JSeparator jSeparator5;
	private JMenuItem btnSelectCourseManage;
	private JMenuItem btnCourseManage;
	private JMenuItem btnAbout;
	private JSeparator jSeparator4;
	private JMenuItem btnCheckUpdate;
	private JMenuItem btnUserBack;
	private JSeparator jSeparator3;
	private JMenuItem btnExemple;
	private JSeparator jSeparator2;
	private JMenuItem btnManageHelpe;
	private JMenuItem btnSeeHelp;
	private JMenu jMenu8;
	private JMenu jMenu7;
	private JMenu jMenu6;
	private JMenuItem btnExit;
	private JSeparator jSeparator1;
	private JMenuItem btnHangeUp;
	private JMenuItem btnLogBack;
	private JMenu jMenu2;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {	
		/*JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");

			SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
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
				FrmMain inst = new FrmMain();				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});		
	}

	public FrmMain() {
		super();
		initGUI();
		this.setResizable(false);
		UserNum=labUser.getText();
		UserRole=labRole.getText();
		System.out.println(UserRole);	
	//	SetQX();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz17w.png")).getImage());
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				ImageIcon img = new ImageIcon("F:\\Eclipse IDE for Java EE Developers\\FirstForm\\src\\image\\2.png");//这是背景图片
				img.setImage(img.getImage().getScaledInstance(733,
						351, 100));
				labImage = new JLabel(img);//将背景图放在标签里。
				getContentPane().add(labImage);				
				labImage.setBounds(2, 0, 730, 350);
				labImage.setText("          ");
				labImage.setSize(730, 350);
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1);
				BoxLayout jToolBar1Layout = new BoxLayout(jToolBar1, javax.swing.BoxLayout.X_AXIS);
				//jToolBar1.setOpaque(false);
				jToolBar1.setBounds(0, 346, 733, 28);
				jToolBar1.setLayout(jToolBar1Layout);
				jToolBar1.setSize(733, 33);
				{
					jLabel4 = new JLabel();
					jToolBar1.add(jLabel4);
					jLabel4.setText("\u7528\u6237\uff1a");
					jLabel4.setPreferredSize(new java.awt.Dimension(42,15));
				}
				{
					labUser = new JLabel();
					jToolBar1.add(labUser);
					labUser.setText("    labUser");
					labUser.setPreferredSize(new java.awt.Dimension(63,15));
				}
				{
					jLabel6 = new JLabel();
					jToolBar1.add(jLabel6);
					jLabel6.setText("   \u89d2\u8272\uff1a");
				}
				{
					labRole = new JLabel();
					jToolBar1.add(labRole);
					labRole.setText("    labRole");
					labRole.setPreferredSize(new java.awt.Dimension(65,15));
				}
				{
					JLable8 = new JLabel();
					jToolBar1.add(JLable8);
					JLable8.setText("                                                    \u65f6\u95f4\uff1a");
					JLable8.setOpaque(true);
					JLable8.setPreferredSize(new java.awt.Dimension(40,15));
				}
				{
					labTime = new JLabel();
					jToolBar1.add(labTime);
					//labTime.setText("labTime");
					this.setTimer(labTime);
					labTime.setPreferredSize(new java.awt.Dimension(0,1));
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u7cfb\u7edf\u7ba1\u7406  ");
					{
						btnPwdChange = new JMenuItem();
						jMenu1.add(btnPwdChange);
						btnPwdChange.setText("\u5bc6\u7801\u4fee\u6539");
						btnPwdChange.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("MyForm/chinaz12w.ico")));
						btnPwdChange.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("MyForm/chinaz12w.ico")));
						btnPwdChange.setRolloverSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("MyForm/chinaz12w.ico")));
						btnPwdChange.setDisabledIcon(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz13x.png")));
						btnPwdChange.setDisabledSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("image/chinaz13x.png")));
						btnPwdChange.setIconTextGap(2);
						btnPwdChange.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/Disk2.ICO")));
						btnPwdChange.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnPwdChangeActionPerformed(evt);
							}
						});
					}
					{
						jSeparator5 = new JSeparator();
						jMenu1.add(jSeparator5);
					}
					{
						btnLogBack = new JMenuItem();
						jMenu1.add(btnLogBack);
						btnLogBack.setText("\u6ce8\u9500");
						btnLogBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnLogBackActionPerformed(evt);
							}
						});
					}
					{
						jSeparator11 = new JSeparator();
						jMenu1.add(jSeparator11);
					}
					{
						btnHangeUp = new JMenuItem();
						jMenu1.add(btnHangeUp);
						btnHangeUp.setText("\u6302\u673a");
						btnHangeUp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnHangeUpActionPerformed(evt);
							}
						});
					}
					{
						jSeparator1 = new JSeparator();
						jMenu1.add(jSeparator1);
					}
					{
						btnExit = new JMenuItem();
						jMenu1.add(btnExit);
						btnExit.setText("\u9000\u51fa");
						btnExit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnExitActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("\u4fe1\u606f\u7ba1\u7406  ");
					{
						jMenu3 = new JMenu();
						jMenu2.add(jMenu3);
						jMenu3.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
						{
							btnStudentInfoAdd = new JMenuItem();
							jMenu3.add(btnStudentInfoAdd);
							btnStudentInfoAdd.setText("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539");
							btnStudentInfoAdd.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnStudentInfoAddActionPerformed(evt);
								}
							});
						}
						{
							btnPersonInfoManage = new JMenuItem();
							jMenu3.add(btnPersonInfoManage);
							btnPersonInfoManage.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
							btnPersonInfoManage.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnPersonInfoManageActionPerformed(evt);
								}
							});
						}
					}
					{
						jSeparator7 = new JSeparator();
						jMenu2.add(jSeparator7);
					}
					{
						jMenu10 = new JMenu();
						jMenu2.add(jMenu10);
						jMenu10.setText("\u6210\u7ee9\u4fe1\u606f\u7ba1\u7406");
						{
							btnCourseGradeInfo = new JMenuItem();
							jMenu10.add(btnCourseGradeInfo);
							btnCourseGradeInfo.setText("\u5f55\u5165\u5b66\u751f\u4fe1\u606f");
							btnCourseGradeInfo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnCourseGradeInfoActionPerformed(evt);
								}
							});
						}
					}
					{
						jSeparator8 = new JSeparator();
						jMenu2.add(jSeparator8);
					}
					{
						jMenu11 = new JMenu();
						jMenu2.add(jMenu11);
						jMenu11.setText("\u5b66\u9662\u4fe1\u606f\u7ba1\u7406");
						{
							btnCollegeInfoGlance = new JMenuItem();
							jMenu11.add(btnCollegeInfoGlance);
							btnCollegeInfoGlance.setText("\u5b66\u9662\u4fe1\u606f\u7ba1\u7406");
							btnCollegeInfoGlance.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnCollegeInfoGlanceActionPerformed(evt);
								}
							});
						}
					}
				}
				{
					jMenu6 = new JMenu();
					jMenuBar1.add(jMenu6);
					jMenu6.setText("\u8bfe\u7a0b\u7ba1\u7406  ");
					{
						btnCourseManage = new JMenuItem();
						jMenu6.add(btnCourseManage);
						btnCourseManage.setText("\u8bfe\u7a0b\u4fe1\u606f\u7ba1\u7406");
						btnCourseManage.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnCourseManageActionPerformed(evt);
							}
						});
					}
					{
						jSeparator6 = new JSeparator();
						jMenu6.add(jSeparator6);
					}
					{
						btnSelectCourseManage = new JMenuItem();
						jMenu6.add(btnSelectCourseManage);
						btnSelectCourseManage.setText("\u5b66\u751f\u9009\u8bfe\u7ba1\u7406");
						btnSelectCourseManage.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnSelectCourseManageActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenu7 = new JMenu();
					jMenuBar1.add(jMenu7);
					jMenu7.setText("\u6570\u636e\u67e5\u8be2  ");
					{
						jMenu4 = new JMenu();
						jMenu7.add(jMenu4);
						jMenu4.setText("\u5b66\u751f\u4fe1\u606f\u67e5\u8be2");
						{
							btnStuBasicInfoGlance = new JMenuItem();
							jMenu4.add(btnStuBasicInfoGlance);
							btnStuBasicInfoGlance.setText("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u6d4f\u89c8");
							btnStuBasicInfoGlance.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnStuBasicInfoGlanceActionPerformed(evt);
								}
							});
						}
						{
							btnStuBasicInfoQuery = new JMenuItem();
							jMenu4.add(btnStuBasicInfoQuery);
							btnStuBasicInfoQuery.setText("\u5b66\u751f\u57fa\u672c\u4fe1\u606f\u67e5\u8be2");
							btnStuBasicInfoQuery.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnStuBasicInfoQueryActionPerformed(evt);
								}
							});
						}
					}
					{
						jSeparator9 = new JSeparator();
						jMenu7.add(jSeparator9);
					}
					{
						jMenu5 = new JMenu();
						jMenu7.add(jMenu5);
						jMenu5.setText("\u5b66\u751f\u6210\u7ee9\u67e5\u8be2");
						{
							btnStuScoreGlance = new JMenuItem();
							jMenu5.add(btnStuScoreGlance);
							btnStuScoreGlance.setText("\u5b66\u751f\u6210\u7ee9\u6d4f\u89c8");
							btnStuScoreGlance.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnStuScoreGlanceActionPerformed(evt);
								}
							});
						}
						{
							btnStuScoreQuery = new JMenuItem();
							jMenu5.add(btnStuScoreQuery);
							btnStuScoreQuery.setText("\u5b66\u751f\u6210\u7ee9\u67e5\u8be2");
							btnStuScoreQuery.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnStuScoreQueryActionPerformed(evt);
								}
							});
						}
					}
					{
						jSeparator10 = new JSeparator();
						jMenu7.add(jSeparator10);
					}
					{
						jMenu9 = new JMenu();
						jMenu7.add(jMenu9);
						jMenu9.setText("\u8bfe\u7a0b\u4fe1\u606f\u67e5\u8be2");
						{
							btnCourseInfoGlance = new JMenuItem();
							jMenu9.add(btnCourseInfoGlance);
							btnCourseInfoGlance.setText("\u8bfe\u7a0b\u4fe1\u606f\u6d4f\u89c8");
							btnCourseInfoGlance.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnCourseInfoGlanceActionPerformed(evt);
								}
							});
						}
						{
							btnCourseInfoQuery = new JMenuItem();
							jMenu9.add(btnCourseInfoQuery);
							btnCourseInfoQuery.setText("\u8bfe\u7a0b\u4fe1\u606f\u67e5\u8be2");
							btnCourseInfoQuery.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									btnCourseInfoQueryActionPerformed(evt);
								}
							});
						}
					}
				}
				{
					jMenu8 = new JMenu();
					jMenuBar1.add(jMenu8);
					jMenu8.setText("\u5e2e\u52a9");
					{
						btnSeeHelp = new JMenuItem();
						jMenu8.add(btnSeeHelp);
						btnSeeHelp.setText("\u67e5\u770b\u5e2e\u52a9");
					}
					{
						btnManageHelpe = new JMenuItem();
						jMenu8.add(btnManageHelpe);
						btnManageHelpe.setText("\u7ba1\u7406\u5e2e\u52a9\u8bbe\u7f6e");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu8.add(jSeparator2);
					}
					{
						btnExemple = new JMenuItem();
						jMenu8.add(btnExemple);
						btnExemple.setText("\u793a\u4f8b");
					}
					{
						jSeparator3 = new JSeparator();
						jMenu8.add(jSeparator3);
					}
					{
						btnUserBack = new JMenuItem();
						jMenu8.add(btnUserBack);
						btnUserBack.setText("\u5ba2\u6237\u53cd\u9988");
					}
					{
						btnCheckUpdate = new JMenuItem();
						jMenu8.add(btnCheckUpdate);
						btnCheckUpdate.setText("\u68c0\u67e5\u66f4\u65b0");
					}
					{
						jSeparator4 = new JSeparator();
						jMenu8.add(jSeparator4);
					}
					{
						btnAbout = new JMenuItem();
						jMenu8.add(btnAbout);
						btnAbout.setText("\u5173\u4e8e\u5b66\u751f\u7ba1\u7406\u7cfb\u7edf");
					}
				}
			}
			pack();
			this.setSize(734, 429);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	//修改密码	
	private void btnPwdChangeActionPerformed(ActionEvent evt) {
		UserNum=labUser.getText();
		UserRole=labRole.getText();
        dispose();   //修改密码关闭主窗体，使可以重新登录主界面
		FrmPwdChange frmPwdChange=new FrmPwdChange();
		frmPwdChange.setVisible(true);
		frmPwdChange.setSize(new Dimension(400,300));
		frmPwdChange.setLocationRelativeTo(null);
	}
	//注销
	private void btnLogBackActionPerformed(ActionEvent evt) {
        dispose();
		FrmLogin frmLogin=new FrmLogin();
		frmLogin.setVisible(true);
		frmLogin.setLocationRelativeTo(null);
	}
	
	//挂机
	private void btnHangeUpActionPerformed(ActionEvent evt) {
		UserNum=labUser.getText();
		UserRole=labRole.getText();
     	dispose();
		FrmHangUp frmHangUp=new FrmHangUp();
		frmHangUp.setVisible(true);
		frmHangUp.LabUserNum.setText(UserNum);
		frmHangUp.LabUserRole.setText(UserRole);
		frmHangUp.setSize(new Dimension(400,150));
		frmHangUp.setLocationRelativeTo(null);
	}
	
	//退出系统
	private void btnExitActionPerformed(ActionEvent evt) {
		System.out.println("btnExit.actionPerformed, event="+evt);
		//TODO add your code for btnExit.actionPerformed
		System.exit(-1);
	}
	//关闭窗口事件
	private void thisWindowClosing(WindowEvent evt) {
		int i = JOptionPane.showConfirmDialog(null, "是否确认退出？", "提示：",
				JOptionPane.YES_NO_OPTION);
		if (i == 0) {
			System.exit(0);
		}
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	// 课程信息管理
	private void btnCourseManageActionPerformed(ActionEvent evt) {	
		
		if (labRole.getText().equals("管理员") || labRole.getText().equals("教师")) {
			FrmCourseInfoManage frmCourseInfoManage = new FrmCourseInfoManage();
			frmCourseInfoManage.setVisible(true);
			frmCourseInfoManage.setLocationRelativeTo(null);
		}else {
			btnCourseManage.setEnabled(false);
		}
	}
	
	//学生选课管理
	private void btnSelectCourseManageActionPerformed(ActionEvent evt) {
		FrmStuSelectCourse frmStuSelectCourse = new FrmStuSelectCourse();
		frmStuSelectCourse.setVisible(true);
		try {
			UserNum=labUser.getText();
		    UserRole=labRole.getText();
		if (UserRole == "学生") {
			frmStuSelectCourse.txtNum.setText(UserNum);
			frmStuSelectCourse.txtNum.setEnabled(false);
			
			frmStuSelectCourse.txtName.setText(GetScoreInput(Integer.parseInt(UserNum)));
			frmStuSelectCourse.txtName.setEnabled(false);
		}else {
			frmStuSelectCourse.labSelected.setText("0");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
        frmStuSelectCourse.setLocationRelativeTo(null);
	}
	
	// 学院信息管理
	private void btnCollegeInfoGlanceActionPerformed(ActionEvent evt) {

		if (labRole.getText().equals("管理员")) {
			FrmCollegeInfoGlance frmCollegeInfoGlance = new FrmCollegeInfoGlance();
			frmCollegeInfoGlance.setVisible(true);
			frmCollegeInfoGlance.setLocationRelativeTo(null);
		} else {
			btnCollegeInfoGlance.setEnabled(false);
		}
	}
	
	//学生成绩录入
	private void btnCourseGradeInfoActionPerformed(ActionEvent evt) {
		GetTeacherCourse();
		if (labRole.getText().equals("教师")) {
			cobCourseModel = new DefaultComboBoxModel(CourseName);
			try {
			    int num = Integer.parseInt(labUser.getText());
				FrmScoreInfoManage frmScoreInfoManage = new FrmScoreInfoManage();
				frmScoreInfoManage.labTeacherNum.setText(labUser.getText());
				frmScoreInfoManage.labTeacherName.setText(GetScoreInput(num));
				frmScoreInfoManage.cobCourse.setModel(cobCourseModel);
				frmScoreInfoManage.setVisible(true);
				frmScoreInfoManage.setLocationRelativeTo(null);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "异常" + e.getMessage());
			}
		} else {
			btnCourseGradeInfo.setEnabled(false);
		}
		
	}
	//查找学生信息
	private void btnStudentInfoAddActionPerformed(ActionEvent evt) {

        if (labRole.getText().equals("学生")) {   
        	FrmStuIDInput frmStuIDInput=new FrmStuIDInput();
            frmStuIDInput.setVisible(true);
            frmStuIDInput.txtStuBase.setEnabled(false);
		    frmStuIDInput.txtStuBase.setText(labUser.getText());
		    frmStuIDInput.radbtnName.setEnabled(false); 
		    frmStuIDInput.setLocationRelativeTo(null);
		}
        else {
			btnStudentInfoAdd.setEnabled(false);
		}
	}
	
	//个人信息管理
	private void btnPersonInfoManageActionPerformed(ActionEvent evt) {
		if (labRole.getText().equals("管理员") || labRole.getText().equals("教师")) {
			FrmStudentInfoManage frmStudentInfoManage = new FrmStudentInfoManage();
			frmStudentInfoManage.setVisible(true);
			frmStudentInfoManage.setLocationRelativeTo(null);
		}else {
			btnPersonInfoManage.setEnabled(false);
		}
	}
	
	
	//调用存储过程返回教师姓名
	CallableStatement cstmt=null;
	public String GetScoreInput(int num)
	{
		String teacherName="";
		try {
			CallableStatement cstmt = dbUtil.ConnectDB()
					.prepareCall("{call dbo.pro_GetTeacherName(?, ?)}");
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
	 
	// 设置Timer 1000ms实现一次动作 实际是一个线程
	private void setTimer(JLabel time) {
		final JLabel varTime = time;
		Timer timeAction = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
	
	//获得教师所有任课
	public void GetTeacherCourse()
	{  
		String[] teamp=new String[100];
		int count =0;
		String string="";
		try {
			int num = Integer.parseInt(labUser.getText());
			sql=dbUtil.ConnectDB().createStatement();
			String sqlString="select Cname from T_CourseInfo where CTeacherName='"+GetScoreInput(num)+"'";
			rs=sql.executeQuery(sqlString);
			for (int i = 0; rs.next(); i++) {
				count++;
				string=string+" "+rs.getString(1);
				teamp[i]=rs.getString(1);
			}
			CourseName=new String[count+1];
			CourseName[0]="";
			for (int i = 0;i<count; i++) {
                CourseName[i+1]=teamp[i];
			}
			dbUtil.ConnectClose();
			//JOptionPane.showMessageDialog(this,"计数："+count+string);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "获得教师任课异常："+e.getMessage());
		}
	}	

	// 学生基本信息浏览
	private void btnStuBasicInfoGlanceActionPerformed(ActionEvent evt) {
		if (labRole.getText().trim().equals("学生")) {
			btnStuBasicInfoGlance.setEnabled(false);
		} else {
			FrmStuBasicInfoGlance frmStuBasicInfoGlance = new FrmStuBasicInfoGlance();
			frmStuBasicInfoGlance.setVisible(true);
			frmStuBasicInfoGlance.setLocationRelativeTo(null);
		}
	}

	//学生基本信息查询
	private void btnStuBasicInfoQueryActionPerformed(ActionEvent evt) {
        FrmStuBasicInfoQuery frmStuBasicInfoQuery=new FrmStuBasicInfoQuery();
        frmStuBasicInfoQuery.setVisible(true);
		try {
			UserNum=labUser.getText();
		    UserRole=labRole.getText();
		if (UserRole == "学生") {
			frmStuBasicInfoQuery.txtNum.setText(UserNum);
			frmStuBasicInfoQuery.txtNum.setEnabled(false);
			
			frmStuBasicInfoQuery.txtSName.setText(GetScoreInput(Integer.parseInt(UserNum)));
			frmStuBasicInfoQuery.txtSName.setEnabled(false);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
        frmStuBasicInfoQuery.setLocationRelativeTo(null);
	}
	
	//学生成绩浏览
	private void btnStuScoreGlanceActionPerformed(ActionEvent evt) {
		FrmStuScoreGlance frmStuScoreGlance = new FrmStuScoreGlance();
		frmStuScoreGlance.setVisible(true);
		if (labRole.getText().equals("学生")) {
            frmStuScoreGlance.btnBack.setEnabled(false);
            frmStuScoreGlance.btnNext.setEnabled(false);
            try {
    			UserNum=labUser.getText();
    		    UserRole=labRole.getText();
            	frmStuScoreGlance.txtSNum.setText(UserNum);
            	frmStuScoreGlance.txtSNum.setEnabled(false);
    			
            	frmStuScoreGlance.txtSName.setText(GetScoreInput(Integer.parseInt(UserNum)));
            	frmStuScoreGlance.txtSName.setEnabled(false);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {

		}
		frmStuScoreGlance.setLocationRelativeTo(null);
	}

	//学生成绩查询
	private void btnStuScoreQueryActionPerformed(ActionEvent evt) {
		FrmStuScoreQuery frmStuScoreQuery=new FrmStuScoreQuery();
		frmStuScoreQuery.setVisible(true);
		try {
			UserNum=labUser.getText();
		    UserRole=labRole.getText();
		if (UserRole == "学生") {
			frmStuScoreQuery.txtSNum.setText(UserNum);
			frmStuScoreQuery.txtSNum.setEnabled(false);
			
			frmStuScoreQuery.txtSName.setText(GetScoreInput(Integer.parseInt(UserNum)));
			frmStuScoreQuery.txtSName.setEnabled(false);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		frmStuScoreQuery.setLocationRelativeTo(null);        
	}
	
	//课程信息浏览
	private void btnCourseInfoGlanceActionPerformed(ActionEvent evt) {
		FrmCourseInfoGlance frmCourseInfoGlance=new FrmCourseInfoGlance();
		frmCourseInfoGlance.setVisible(true);
		frmCourseInfoGlance.setLocationRelativeTo(null);
	}
	
	//课程信息查询
	private void btnCourseInfoQueryActionPerformed(ActionEvent evt) {
        FrmCourseInfoQuery frmCourseInfoQuery=new FrmCourseInfoQuery();
        frmCourseInfoQuery.setVisible(true);
        frmCourseInfoQuery.setLocationRelativeTo(null);
	}
	
	/*public void SetQX()
	{
		if (UserRole.equals("学生")) {
			btnPersonInfoManage.setEnabled(false);
			btnCourseGradeInfo.setEnabled(false);
			btnCollegeInfoGlance.setEnabled(false);
			btnCourseManage.setEnabled(false);
			btnStuBasicInfoGlance.setEnabled(false);
		}else  if (UserRole.equals("教师")) {
			btnCollegeInfoGlance.setEnabled(false);
			btnStudentInfoAdd.setEnabled(false);
		}else {
			btnCourseGradeInfo.setEnabled(false);
		}	
	}*/
}
