package ApplicationWindow;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import MainApplication.ConnectionClass;
import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainApplication {

	private JFrame frame;
	private static Connection connect;
	private Statement statement = null;
	private JTextField textField_laboratoryNew;
	private JTextField textField_groupNew;
	private JTextField textField_weekNew;
	private JTextField textField_coursNew;
	private JTextField textField_weekCours;
	private JTextField textField_teacherCours;
	private JTextField textField_LaboratoryName;
	private JTable table;
	private JTextField textField_StudentName_stud;
	private JTextField textField_name_lab_stud;
	private JTextField textField_CoursName_stud;
	private JTextField textField_TeacherName_stud;
	private JTextField textField_Group_stud;
	private JTextField textField_group_lab_dell;
	private JTextField textField_nume_lab_del;
	private JTextField textField_week_lab_del;
	private JTextField textField_cours_delCours;
	private JTextField textField_week_delCours;
	private JTextField textField_week_lab;
	private JTextField textField_group_lab;
	private JTextField textField_week_stud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frame.setVisible(true);
					connect = ConnectionClass.dbConnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create my useful method
	 */
	public void swichPanels(JPanel panel, JLayeredPane layeredPane_1) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.validate();
	}

	/**
	 * Create the application.
	 */
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ----------------------------------Menu---------------------
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 782, 26);
		frame.getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mnFile.add(mntmOpenFile);

		JMenuItem mntmNew = new JMenuItem("New");

		JMenuItem mntmDeleteList = new JMenuItem("Delete List");

		JMenuItem mntmOpenList = new JMenuItem("Open List");

		JMenuItem mntmExit = new JMenuItem("Exit");

		JMenu mnCreateList = new JMenu("Teacher");
		menuBar.add(mnCreateList);

		JMenu mnStudentOption = new JMenu("Student");
		menuBar.add(mnStudentOption);

		JMenuItem mntmAdd = new JMenuItem("Add");
		mnStudentOption.add(mntmAdd);

		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);

		// ------------------------Main Panel------------------
		JPanel panel = new JPanel();
		panel.setBounds(32, 59, 567, 450);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// ---------------------layered Panel------------------
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(30, 23, 507, 400);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		final JPanel OpenList = new JPanel();
		layeredPane.add(OpenList, "name_11299659143357");
		OpenList.setLayout(null);

		JLabel lblNewLabel = new JLabel("Open and View attendance list");
		lblNewLabel.setBounds(132, 13, 243, 38);
		OpenList.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 64, 382, 149);
		OpenList.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cours", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Week");
		lblNewLabel_6.setBounds(27, 13, 98, 22);
		panel_1.add(lblNewLabel_6);

		textField_weekCours = new JTextField();
		textField_weekCours.setBounds(137, 13, 116, 22);
		panel_1.add(textField_weekCours);
		textField_weekCours.setColumns(10);

		JLabel lblCoursName = new JLabel("Cours name");
		lblCoursName.setBounds(27, 40, 98, 22);
		panel_1.add(lblCoursName);

		textField_teacherCours = new JTextField();
		textField_teacherCours.setBounds(137, 48, 116, 22);
		panel_1.add(textField_teacherCours);
		textField_teacherCours.setColumns(10);

		JButton btnView = new JButton("View");

		btnView.setBounds(265, 12, 97, 25);
		panel_1.add(btnView);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Laboratory", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 377, 119);
		panel_2.add(panel_3);

		JLabel label = new JLabel("Week");
		label.setBounds(27, 13, 98, 22);
		panel_3.add(label);

		JLabel lblLaboratoryName = new JLabel("Laboratory name");
		lblLaboratoryName.setBounds(27, 40, 98, 22);
		panel_3.add(lblLaboratoryName);

		textField_LaboratoryName = new JTextField();
		textField_LaboratoryName.setColumns(10);
		textField_LaboratoryName.setBounds(137, 40, 116, 22);
		panel_3.add(textField_LaboratoryName);

		JButton button = new JButton("View");

		button.setBounds(265, 12, 97, 25);
		panel_3.add(button);

		JLabel lblGroup = new JLabel("Group");
		lblGroup.setBounds(27, 75, 98, 22);
		panel_3.add(lblGroup);

		textField_week_lab = new JTextField();
		textField_week_lab.setBounds(137, 13, 116, 22);
		panel_3.add(textField_week_lab);
		textField_week_lab.setColumns(10);

		textField_group_lab = new JTextField();
		textField_group_lab.setColumns(10);
		textField_group_lab.setBounds(137, 75, 116, 22);
		panel_3.add(textField_group_lab);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 248, 382, 100);
		OpenList.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		final JLabel lblNewLabel_statusView = new JLabel("");
		lblNewLabel_statusView.setBounds(30, 213, 382, 30);
		OpenList.add(lblNewLabel_statusView);

		final JPanel CreateL = new JPanel();
		layeredPane.add(CreateL, "name_11299671425609");
		CreateL.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Laboratory");
		lblNewLabel_2.setBounds(35, 113, 137, 19);
		CreateL.add(lblNewLabel_2);

		JLabel lblCreatelist = new JLabel("Create new Attendance List");
		lblCreatelist.setBounds(184, 5, 157, 16);
		CreateL.add(lblCreatelist);

		textField_laboratoryNew = new JTextField();
		textField_laboratoryNew.setBounds(184, 113, 116, 22);
		CreateL.add(textField_laboratoryNew);
		textField_laboratoryNew.setColumns(10);

		JLabel lblGroupName = new JLabel("Group Name");
		lblGroupName.setBounds(35, 147, 137, 22);
		CreateL.add(lblGroupName);

		textField_groupNew = new JTextField();
		textField_groupNew.setColumns(10);
		textField_groupNew.setBounds(184, 147, 116, 22);
		CreateL.add(textField_groupNew);

		JLabel lblWeek = new JLabel("Week");
		lblWeek.setBounds(35, 183, 137, 19);
		CreateL.add(lblWeek);

		textField_weekNew = new JTextField();
		textField_weekNew.setColumns(10);
		textField_weekNew.setBounds(184, 180, 116, 22);
		CreateL.add(textField_weekNew);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(181, 223, 119, 25);
		CreateL.add(btnNewButton);

		final JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(35, 255, 417, 32);
		CreateL.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Cours");
		lblNewLabel_4.setBounds(35, 81, 106, 16);
		CreateL.add(lblNewLabel_4);

		textField_coursNew = new JTextField();
		textField_coursNew.setColumns(10);
		textField_coursNew.setBounds(184, 78, 116, 22);
		CreateL.add(textField_coursNew);

		final JPanel DeleteList = new JPanel();
		layeredPane.add(DeleteList, "name_11314912569613");
		DeleteList.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(66, 57, 411, 215);
		DeleteList.add(tabbedPane_1);

		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("");
		tabbedPane_1.addTab("Laboratory", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 13, 382, 159);
		panel_4.add(panel_7);
		panel_7.setLayout(null);

		JLabel label_1 = new JLabel("Week");
		label_1.setBounds(12, 14, 98, 22);
		panel_7.add(label_1);

		JLabel label_2 = new JLabel("Laboratory name");
		label_2.setBounds(12, 41, 98, 22);
		panel_7.add(label_2);

		JLabel label_3 = new JLabel("Group");
		label_3.setBounds(12, 76, 98, 22);
		panel_7.add(label_3);

		textField_group_lab_dell = new JTextField();
		textField_group_lab_dell.setColumns(10);
		textField_group_lab_dell.setBounds(110, 76, 116, 22);
		panel_7.add(textField_group_lab_dell);

		textField_nume_lab_del = new JTextField();
		textField_nume_lab_del.setColumns(10);
		textField_nume_lab_del.setBounds(110, 41, 116, 22);
		panel_7.add(textField_nume_lab_del);

		textField_week_lab_del = new JTextField();
		textField_week_lab_del.setColumns(10);
		textField_week_lab_del.setBounds(110, 14, 116, 22);
		panel_7.add(textField_week_lab_del);

		JButton btnDelete_laborator = new JButton("Delete");

		btnDelete_laborator.setBounds(238, 13, 97, 25);
		panel_7.add(btnDelete_laborator);

		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Cours", null, panel_5, null);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 382, 159);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(0, 0, 352, 107);
		panel_6.add(panel_8);

		JLabel label_4 = new JLabel("Week");
		label_4.setBounds(12, 14, 98, 22);
		panel_8.add(label_4);

		JLabel lblCoursName_1 = new JLabel("Cours name");
		lblCoursName_1.setBounds(12, 41, 98, 22);
		panel_8.add(lblCoursName_1);

		textField_cours_delCours = new JTextField();
		textField_cours_delCours.setColumns(10);
		textField_cours_delCours.setBounds(110, 41, 116, 22);
		panel_8.add(textField_cours_delCours);

		textField_week_delCours = new JTextField();
		textField_week_delCours.setColumns(10);
		textField_week_delCours.setBounds(110, 14, 116, 22);
		panel_8.add(textField_week_delCours);

		JButton button_delete_cours = new JButton("Delete");

		button_delete_cours.setBounds(238, 13, 97, 25);
		panel_8.add(button_delete_cours);

		final JLabel lblNewLabel_messageError_Delete = new JLabel("");
		lblNewLabel_messageError_Delete.setBounds(66, 289, 411, 29);
		DeleteList.add(lblNewLabel_messageError_Delete);

		final JPanel StudentAdd = new JPanel();
		layeredPane.add(StudentAdd, "name_1098913359960");
		StudentAdd.setLayout(null);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(127, 25, 119, 27);
		StudentAdd.add(lblStudentName);

		textField_StudentName_stud = new JTextField();
		textField_StudentName_stud.setBounds(255, 27, 116, 22);
		StudentAdd.add(textField_StudentName_stud);
		textField_StudentName_stud.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Laboratory");
		lblNewLabel_5.setBounds(127, 65, 119, 22);
		StudentAdd.add(lblNewLabel_5);

		textField_name_lab_stud = new JTextField();
		textField_name_lab_stud.setBounds(255, 65, 116, 22);
		StudentAdd.add(textField_name_lab_stud);
		textField_name_lab_stud.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Cours");
		lblNewLabel_7.setBounds(127, 99, 119, 27);
		StudentAdd.add(lblNewLabel_7);

		textField_CoursName_stud = new JTextField();
		textField_CoursName_stud.setBounds(255, 101, 116, 22);
		StudentAdd.add(textField_CoursName_stud);
		textField_CoursName_stud.setColumns(10);

		JLabel lblNewLabel_TeacherName = new JLabel("Teacher Name");
		lblNewLabel_TeacherName.setBounds(127, 139, 88, 22);
		StudentAdd.add(lblNewLabel_TeacherName);

		textField_TeacherName_stud = new JTextField();
		textField_TeacherName_stud.setBounds(255, 139, 116, 22);
		StudentAdd.add(textField_TeacherName_stud);
		textField_TeacherName_stud.setColumns(10);

		JLabel lblGroup_1 = new JLabel("Group");
		lblGroup_1.setBounds(127, 174, 56, 16);
		StudentAdd.add(lblGroup_1);

		textField_Group_stud = new JTextField();
		textField_Group_stud.setBounds(255, 174, 116, 22);
		StudentAdd.add(textField_Group_stud);
		textField_Group_stud.setColumns(10);

		JButton btn_insert_attendance_lab = new JButton("Insert laboratory attendance");

		btn_insert_attendance_lab.setBounds(130, 267, 223, 22);
		StudentAdd.add(btn_insert_attendance_lab);

		JButton btnInsertCoursAttendance = new JButton("Insert cours attendance");
		btnInsertCoursAttendance.setBounds(127, 225, 226, 25);
		StudentAdd.add(btnInsertCoursAttendance);

		JLabel lblNewLabel_MessageError = new JLabel("");
		lblNewLabel_MessageError.setBounds(127, 316, 353, 33);
		StudentAdd.add(lblNewLabel_MessageError);

		JLabel lblWeek_1 = new JLabel("Week");
		lblWeek_1.setBounds(127, 203, 56, 16);
		StudentAdd.add(lblWeek_1);

		textField_week_stud = new JTextField();
		textField_week_stud.setBounds(255, 200, 116, 22);
		StudentAdd.add(textField_week_stud);
		textField_week_stud.setColumns(10);

		// -----------------------------------Evenimente pe Menu---------------

		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				swichPanels(CreateL, layeredPane);
			}
		});
		mnCreateList.add(mntmNew);

		mntmDeleteList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swichPanels(DeleteList, layeredPane);
			}
		});
		mnCreateList.add(mntmDeleteList);

		mntmOpenList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swichPanels(OpenList, layeredPane);
			}
		});
		mnCreateList.add(mntmOpenList);

		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				swichPanels(StudentAdd, layeredPane);
			}
		});

		// ---------------------------------------Evenimente pe Butoane-------------
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					statement = connect.createStatement();
					if (!textField_laboratoryNew.getText().isEmpty()) {

						String sql = "insert into liste_prezenta(nume_liste_prezenta,id_grupa,saptamana,id_curs,id_laborator) values ('Prezenta laborator "
								+ textField_laboratoryNew.getText() + " " + textField_groupNew.getText() + " "
								+ textField_weekNew.getText() + "',"
								+ " (select id_grupa from Grupe where nume_grupa = '" + textField_groupNew.getText()
								+ "'" + ")," + textField_weekNew.getText() + ",null,"
								+ " (select id_laborator from Laboratoare where nume_laborator = '"
								+ textField_laboratoryNew.getText() + "')" + ")";
						statement.executeUpdate(sql);
						lblNewLabel_3.setText("The attendance list was created with successful!");
					} else if (!textField_coursNew.getText().isEmpty()) {
						String sql = "insert into liste_prezenta(nume_liste_prezenta,id_grupa,saptamana,id_curs,id_laborator) values ('Prezenta curs "
								+ textField_coursNew.getText() + " " + textField_groupNew.getText() + " "
								+ textField_weekNew.getText() + "'," + "null" + "," + textField_weekNew.getText() + ','
								+ "(select id_curs from Cursuri where nume_curs = '" + textField_coursNew.getText()
								+ "')" + ",null)";
						statement.executeUpdate(sql);
						lblNewLabel_3.setText("The attendance list was created with successful!");
					}

				} catch (SQLException se) {
					// Handle errors for JDBC
					lblNewLabel_3.setText(se.getMessage());
					se.printStackTrace();

				}
			}
		});

		// -------------------------------------- vizuallizare lista laborator
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField_LaboratoryName.getText().isEmpty() && !textField_group_lab.getText().isEmpty()
						&& !textField_week_lab.getText().isEmpty()) {
					try {
						statement = connect.createStatement();

						String sqlListaPrezenta = "select lp.id_liste_prezenta from liste_prezenta lp where"
								+ " lp.saptamana=" + textField_week_lab.getText()
								+ " and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '"
								+ textField_group_lab.getText() + "')"
								+ "and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = '"
								+ textField_LaboratoryName.getText() + "'))";
						// ResultSet resultQuery = statement.executeQuery(sqlListaPrezenta);
						// int idPrezenta=resultQuery.getInt(1);

						String sql = "select l.nume_laborator, t.nume_profesor,s.nume_student, lp.saptamana"
								+ " from liste_prezenta lp, profesori t, prezenta p, studenti s, laboratoare l"
								+ " where lp.id_liste_prezenta=p.id_liste_prezenta and p.id_liste_prezenta= ("
								+ "select lp.id_liste_prezenta from liste_prezenta lp where" + " lp.saptamana="
								+ textField_week_lab.getText()
								+ " and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '"
								+ textField_group_lab.getText() + "')"
								+ "and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = '"
								+ textField_LaboratoryName.getText() + "'))"
								+ " and p.id_student=s.id_student and p.id_profesor=t.id_profesor and p.id_laborator=l.id_laborator"
								+ " order by lp.saptamana asc";
						ResultSet resultQuery2 = statement.executeQuery(sql);
						table.setModel(DbUtils.resultSetToTableModel(resultQuery2));
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_statusView.setText(se.getMessage());
						se.printStackTrace();

					}
				} else {
					lblNewLabel_statusView.setText("Please complet all fields! ");
				}
			}
		});

		// ----------------------------------------vizualizare lista cursuri
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_weekCours.getText().isEmpty() && !textField_teacherCours.getText().isEmpty()) {
					try {
						statement = connect.createStatement();
						String sql = "select t.nume_profesor,s.nume_student, lp.saptamana"
								+ " from liste_prezenta lp, profesori t, prezenta p, studenti s"
								+ " where lp.id_liste_prezenta=p.id_liste_prezenta and lp.saptamana="
								+ textField_weekCours.getText()
								+ " and t.id_profesor= (select id_profesor from Profesori where nume_profesor='"
								+ textField_teacherCours.getText() + "')" + " and p.id_student=s.id_student";
						ResultSet resultQuery = statement.executeQuery(sql);
						table.setModel(DbUtils.resultSetToTableModel(resultQuery));
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_statusView.setText(se.getMessage());
						se.printStackTrace();

					}
				} else {
					lblNewLabel_statusView.setText("Please complet all fields! ");
				}
			}
		});

		// ---------------------Student Adaugare prezenta Curs----------------------
		btnInsertCoursAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField_CoursName_stud.getText().isEmpty()) {
					try {
						statement = connect.createStatement();
						String sql = "insert into prezenta(nota,observatii,id_student,id_profesor,id_curs,id_laborator,id_liste_prezenta) "
								+ "values ('2',null, " + " ( select id_student from studenti where nume_student='"
								+ textField_StudentName_stud.getText()
								+ "'),( select id_profesor from profesori where nume_profesor='"
								+ textField_TeacherName_stud.getText()
								+ "'),( select id_curs from cursuri where nume_curs='"
								+ textField_CoursName_stud.getText()
								+ "'),null,( select lp.id_liste_prezenta from liste_prezenta lp where lp.saptamana='"
								+ textField_week_stud.getText()
								+ "' and lp.id_curs= (select id_curs from cursuri where nume_curs = '"
								+ textField_CoursName_stud.getText() + "')))";

						statement.executeUpdate(sql);
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_statusView.setText(se.getMessage());
						se.printStackTrace();
					}
				}

			}
		});

		// -------------------- Student Adaugare prezenta Laborator-------------------
		btn_insert_attendance_lab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField_name_lab_stud.getText().isEmpty()) {
					try {
						statement = connect.createStatement();
						String sql = "insert into prezenta(nota,observatii,id_student,id_profesor,id_curs,id_laborator,id_liste_prezenta) "
								+ "values ('5',null, " + " ( select id_student from studenti where nume_student='"
								+ textField_StudentName_stud.getText()
								+ "'),( select id_profesor from profesori where nume_profesor='"
								+ textField_TeacherName_stud.getText()
								+ "'),null,( select id_laborator from laboratoare where nume_laborator = '"
								+ textField_name_lab_stud.getText()
								+ "'),( select lp.id_liste_prezenta from liste_prezenta lp where lp.saptamana='"
								+ textField_week_stud.getText()
								+ "' and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '"
								+ textField_Group_stud.getText()
								+ "') and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = '"
								+ textField_name_lab_stud.getText() + "')))";

						statement.executeUpdate(sql);
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_statusView.setText(se.getMessage());
						se.printStackTrace();
					}
				}
			}
		});

		// ---------------------------Sterge lista prezenta curs------------------------
		button_delete_cours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField_cours_delCours.getText().isEmpty() && !textField_week_delCours.getText().isEmpty()) {
					try {
						// statement = connect.createStatement();
						// String stg="select * from profesori";
						// ResultSet res = statement.executeQuery(stg);
						// ResultSet x=res;
						statement = connect.createStatement();
						String sql = "delete from prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where "
								+ "lp.saptamana= " + textField_week_delCours.getText()
								+ " and lp.id_curs= (select id_curs from cursuri where nume_curs = '"
								+ textField_cours_delCours.getText() + "'))";
						statement.executeUpdate(sql);
						String sql1 = "delete  from liste_prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where "
								+ "lp.saptamana= " + textField_week_delCours.getText()
								+ " and lp.id_curs= (select id_curs from cursuri where nume_curs = '"
								+ textField_cours_delCours.getText() + "'))";
						statement.executeUpdate(sql1);
						// if (response)
						lblNewLabel_messageError_Delete.setText("The list was deleted week "
								+ textField_week_delCours.getText() + " Cours: " + textField_cours_delCours.getText());
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_messageError_Delete.setText(se.getMessage());
						se.printStackTrace();

					}
				} else {
					lblNewLabel_messageError_Delete.setText("Please complet all fields! ");
				}

			}
		});

		// ------------------------Sterge lista prezenta laborator----------------------
		btnDelete_laborator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_nume_lab_del.getText().isEmpty() && !textField_group_lab_dell.getText().isEmpty()
						&& !textField_week_lab_del.getText().isEmpty()) {
					try {
						statement = connect.createStatement();
						String sql = "delete  from prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where "
								+ "lp.saptamana= " + textField_week_lab_del.getText()
								+ "  and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '"
								+ textField_group_lab_dell.getText() + "')"
								+ " and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = '"
								+ textField_nume_lab_del.getText() + "'))";
						String sql1 = "delete  from liste_prezenta where id_liste_prezenta= ( select lp.id_liste_prezenta from liste_prezenta lp where "
								+ "lp.saptamana= " + textField_week_lab_del.getText()
								+ "  and lp.id_grupa = (select id_grupa from grupe where nume_grupa = '"
								+ textField_group_lab_dell.getText() + "')"
								+ " and lp.id_laborator= (select id_laborator from laboratoare where nume_laborator = '"
								+ textField_nume_lab_del.getText() + "'))";
						statement.executeUpdate(sql1);
					} catch (SQLException se) {
						// Handle errors for JDBC
						lblNewLabel_messageError_Delete.setText(se.getMessage());
						se.printStackTrace();

					}
				} else {
					lblNewLabel_messageError_Delete.setText("Please complet all fields! ");
				}
			}
		});
	}
}