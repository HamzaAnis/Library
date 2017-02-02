import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;


public class MyLibrarian
{
static JFrame fr2,fr3,fr4,fr5,fr6,fr7,fr8,fr9,fr10,fr11,fr12,fr13,fr14;
static JPanel p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
JButton LOGIN=new JButton("LOGIN");
JButton ADD,AddNewBook,DELETE,DelOldBook,ADDNEWUSER,AddThisUser,DELEXISTUSER,DelThisUser,CHANGEPW;
JButton MARKEOI,CHANGEMYPW,QUERY,RUNQUERY,REPORT,ISSUE_BOOK,ADD_BORROWER,AddThisBorrower;
JButton CLOSE_BORROWER,CloseThisBorrower,VIEW_REC,MODIFY_REC,showItButton;
JLabel jLabel, jLabel1, jLabel2,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JTextField section,bookname,author,price,availcode,currentborrower,serno,boname,boaddress;
JTextField bophoneno,borrowerNewMagazine,borrowerPhoneNo,borrowerLastMagazine;
JPasswordField loginname,loginpass,oldpw,newpw,newpwc;
JTextField username,password,Designation,loginpassback,usrname,fboserial;
JTextField borrowerSerialno,borrowerName,borrowerAddress,borrowerLastBook,borrowerStatus;
JTextField borrowerNewBook;
//loginname = new JTextField(20);	
//loginpass = new JTextField(20);	
GridBagLayout gridbag = new GridBagLayout();
GridBagConstraints c = new GridBagConstraints();
String t1;
String url="jdbc:odbc:BANK";
String driver="sun.jdbc.odbc.JdbcOdbcDriver";
String sql,sq,sqUsr,sbookd,sdUsr,squpdate,dialogmessage,serialno,squpdate_book,squpdate_mag;
int dialogtype = JOptionPane.PLAIN_MESSAGE;
String dialogs = "SUCCESS";
String dialogf = "FAILURE";
String dialogd = "DELETION OK ?";
String dialogw = "WARNING !!!";
DefaultTableModel defaulttablemodel = new DefaultTableModel();
boolean DelFlag,AddFlag,DelUsrFlag,AddUsrFlag;
Font dataFont = new Font("times new roman",Font.PLAIN,15);
String loginnameback;
//GregorianCalendar gCal;

//Following is required for running a query on database.

JCheckBox jCheckboxq1, jCheckboxq2, jCheckboxq3, jCheckboxq4, jCheckboxq5;
CheckBoxListener myListener = new CheckBoxListener();
JRadioButton jRadiobuttonq1, jRadiobuttonq2;
ActionListener rlistener = new RadioListener();	
ButtonGroup bgq = new ButtonGroup();
GridBagConstraints c5 = new GridBagConstraints();	
JComboBox jComboboxq1, jComboboxq2;
ComboBoxListener cbListener = new ComboBoxListener();
JTextField givencondition;
JTextArea resultArea;
JLabel jLabelq1, jLabelq2;
int SerialNoSel=0,BookNameSel=0,AuthorSel=0,PriceSel=0,CurrentBorrowerSel=0;
String Combo1sel="SerialNo", Combo2sel="=";
String sr;
String condsel="No Condition";
String qry = "";

//Following is required for Book Reports
Object[] data = new Object[5];
//DefaultTableModel defaulttablemodel = new DefaultTableModel();
JTable jtable = new JTable(defaulttablemodel);
String tempname = "";
int tempcnt;

//Following is required to generate proper message
String msgsel1="Are You Sure?";
String msgesel2;
int n;
JFrame frame;

public static void main(String[] args) 
	{
		MyLibrarian c1=new MyLibrarian();
	}

public MyLibrarian()
	{
		//setupMenuBar();
		login();
	}

void login()
	{
	 fr2=new JFrame("Login Panel MyLibrarian v1.0");
     fr2.setVisible(true);
	 fr2.setSize(700,400);
	 fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 p2=new JPanel();
	 p2.setLayout(gridbag);

	 p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Login Panel"));
     
	 jLabel1 = new JLabel("Enter Username : ");	
	 jLabel1.setFont(dataFont);
	                c.weighty = 0.0;   	  //Vertical Space	
					c.ipady = 1;       	  //Height of Component				
					c.ipadx = 1; 		  //Width of Component
			        c.anchor = GridBagConstraints.WEST; 	
			      	c.gridwidth =1;   	  //1 columns wide				
			        c.gridx = 0;       	  //aligned with button 0  -- Very Important 					   
			        c.gridy = 0;       	  //0th Row  -- Very Important 	
					// Add all these features to this Label "jLabel1"	
			        gridbag.setConstraints(jLabel1, c);
                    p2.add(jLabel1);

	loginname = new JPasswordField(10);
    loginname.setEchoChar('*');
	
     		    	c.ipady = 1;       						
					c.ipadx = 1;       						
		        	//c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	
		       		c.gridwidth = 2;   						
		        	c.gridx = 1;       						    
		        	c.gridy = 0;       						
		        	gridbag.setConstraints(loginname, c);
					p2.add(loginname);

    jLabel2 = new JLabel("Enter Password : ");
	jLabel2.setFont(dataFont);
				    c.ipady = 1;       						
					c.ipadx = 1;       						
			        //c.weighty = 0.0;   						
			        //c.anchor = GridBagConstraints.WEST; 	
			        //c.gridwidth = 1;   						
			        c.gridx = 0;       						     
			        c.gridy = 1;       						
			        gridbag.setConstraints(jLabel2, c);
			     p2.add(jLabel2);				

loginpass = new JPasswordField(10);
loginpassback = loginpass;
loginpass.setEchoChar('*');
			    	c.ipady = 1;       						
					c.ipadx = 1;       						
		        	//c.weighty = 0.0;   						
		        	//c.anchor = GridBagConstraints.WEST; 	
		       		//c.gridwidth = 2;   						
		        	c.gridx = 1;       						     
		        	c.gridy = 1;       						
		        	gridbag.setConstraints(loginpass, c);
		        p2.add(loginpass);
				
LOGIN = new JButton("LOGIN");
		        	c.ipady = 1;       						
					c.ipadx = 1;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 0;   						
		        	c.gridx =0;       						      
		        	c.gridy =4;       						
		        	gridbag.setConstraints(LOGIN, c);
		        p2.add(LOGIN);										
				LOGIN.addActionListener(new ButtonHandler());  
				
	 
			
     fr2.getContentPane().add(p2);
	 JFrame.setDefaultLookAndFeelDecorated(true);

	}

	class ButtonHandler implements ActionListener 
		{
  			public void actionPerformed(ActionEvent ev)
			{
   				String s=ev.getActionCommand(); 	
				//see which button is click accordingly call its method			
				if(s=="LOGIN") 
				{
					// call method getaccess();
					getaccess();	
				}  

				else if(s=="ADD NEW BOOK")
				{
					addnewbook();
				}	
				
				else if(s=="ADD THIS BOOK")
				{
					AddFlag=true;
					LIBCONFIRM();
				}	

				else if(s=="DELETE EXISTING BOOK")
				{
					deloldbook();
				}

				else if(s=="DELETE THIS BOOK")
				{
					DelFlag=true;
					LIBCONFIRM();
				}

				else if(s=="ADD NEW USER")
				{
					addnewuser();
				}

				else if (s=="ADD THIS USER")
				{
				   AddUsrFlag=true;
				   USRCONFIRM();						
				}

				else if(s=="DELETE EXISTING USER")
				{
					delexistuser();
				}

				else if(s=="DELETE THIS USER")
				{
					DelUsrFlag=true;
					USRCONFIRM();
				}

				else if(s=="CHANGE PASSWORD")

				{
					CHPW();
				}

				else if(s=="CHANGE MY PASSWORD")
				{
					PWCHG();
				}


				else if(s=="RUN QUERY")
				{
					QueryBuilder();
				}

				else if(s=="RUN THIS QUERY")
				{
					handleQuery();
				}

				else if(s=="REPORTS")
				{
					BookReports();
				}

				else if(s=="ADD NEW BORROWER")
				{
					addnewborrower();
				}

				else if(s=="ADD THIS BORROWER")
				{
					BORROWER_ADD();
				}

				else if (s=="ISSUE BOOK")
				{
					ISSUE_BOOK();
				}

				else if (s=="VIEW")
				{
					ExtractBookRecord();
				}

				else if (s=="MODIFY")
				{
					UpdateBorrowerRecord();
				}

			}
		}

    void getaccess()
	{

		  try
			  {			   		
					String var1 =  loginname.getText();
						   var1 =  var1.trim();
					loginnameback = var1;
					String var2 =  loginpass.getText();
						   var2 =  var2.trim();	

      sql = "SELECT * FROM login WHERE username='"+var1+"' AND password='"+var2+"'";
	  Class.forName(driver);
	  Connection connection=DriverManager.getConnection(url);
	  Statement statement = connection.createStatement();
	  boolean hasResults = statement.execute(sql);
	  if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						if(result!=null)
						{ 	
								displayResults(result);
			   			}
						connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }
		}	
		void displayResults(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int foundrec = 0;
  				int numColumns=rmeta.getColumnCount();  
				while(r.next())
				{								
						String param3 = r.getString(3).trim();
						// 3rd field in the table 'login' , database 'bank.mdb'						
						if (param3.equals("Accounts")) 
						{
							// for login 'a' , password 'a' , if his deparment is "Accounts"
						    // u found record , so set foundrecord = 1
							foundrec = 1;
							showAccountloginsuccess();
						}
						else if(param3.equals("Main"))
						{
							// for login 'm' , password 'm' , if his deparment is "Main" 
							// u found record , so set foundrecord = 1
							foundrec = 1;
							showMainloginsuccess();	
						}		
  				}		
				if(foundrec==0)
				{
					//if foundrecord is zero , invalid login
					dialogmessage = "Please Re-Login";
					dialogtype = JOptionPane.WARNING_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw, dialogtype);
					//make login and password textboxes empty
					loginname.setText("");
					loginpass.setText("");
				}	
		}	


		void showAccountloginsuccess()
		{
			//fr2.setVisible(false);
			dialogmessage = "Login Succssful !!!";
			dialogtype = JOptionPane.INFORMATION_MESSAGE;
			//show message
			JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);

			loginname.setText("");
			loginpass.setText("");
		    showAccountprograms();

		}

		void showMainloginsuccess()
		{
			dialogmessage = "Login Succssful !!!";
			dialogtype = JOptionPane.INFORMATION_MESSAGE;
			//show message
			JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
			loginname.setText("");
			loginpass.setText("");
		    showMainprograms();

		}


	void showMainprograms()
	     {
	 fr6=new JFrame("Task Performer My Librarian v1.0 ");
     fr6.setVisible(true);
	 fr6.setSize(600,300);
	 p6=new JPanel();
	 p6.setLayout(gridbag);

	 Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	 String DATE_FORMAT="dd-MM-yyyy";
	 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
	 sdf.setTimeZone(TimeZone.getDefault());
	 //System.out.println("Now : "+sdf.format(cal.getTime()));
	 String t1 = sdf.format(cal.getTime());
     
	 p6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Main "+loginnameback+" Logged in"));

	 l2=new JLabel(t1);
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=3;
		c.gridy=0;
		gridbag.setConstraints(l2,c);
		p6.add(l2,c);

	 ADD = new JButton("ADD NEW BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 0;       						
		        	gridbag.setConstraints(ADD, c);
		        p6.add(ADD);										
				ADD.addActionListener(new ButtonHandler()); 
	
	DELETE = new JButton("DELETE EXISTING BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 1;       						
		        	gridbag.setConstraints(DELETE, c);
		        p6.add(DELETE);										
				DELETE.addActionListener(new ButtonHandler()); 

	ADDNEWUSER = new JButton("ADD NEW USER");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(ADDNEWUSER, c);
		        p6.add(ADDNEWUSER);										
				ADDNEWUSER.addActionListener(new ButtonHandler()); 

	DELEXISTUSER = new JButton("DELETE EXISTING USER");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 3;       						
		        	gridbag.setConstraints(DELEXISTUSER, c);
		        p6.add(DELEXISTUSER);										
				DELEXISTUSER.addActionListener(new ButtonHandler()); 


	CHANGEPW = new JButton("CHANGE PASSWORD");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 4;       						
		        	gridbag.setConstraints(CHANGEPW, c);
		        p6.add(CHANGEPW);										
				CHANGEPW.addActionListener(new ButtonHandler()); 

					


	fr6.getContentPane().add(p6);
	JFrame.setDefaultLookAndFeelDecorated(true);

	}
		
	void showAccountprograms()
	     {

     Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	 String DATE_FORMAT="dd-MM-yyyy";
	 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
	 sdf.setTimeZone(TimeZone.getDefault());
	 String t1 = sdf.format(cal.getTime());

	 
	 fr4=new JFrame("Task Performer My Librarian v1.0 ");
     fr4.setVisible(true);
	 fr4.setSize(600,300);
	 //fr4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 p4=new JPanel();
	 p4.setLayout(gridbag);
     p4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"User "+loginnameback+" Logged in"));

      l2=new JLabel(t1);
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=3;
		c.gridy=0;
		gridbag.setConstraints(l2,c);
		p4.add(l2,c);
		
	 ADD = new JButton("ADD NEW BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 0;       						
		        	gridbag.setConstraints(ADD, c);
		        p4.add(ADD);										
				ADD.addActionListener(new ButtonHandler()); 
	
	DELETE = new JButton("DELETE EXISTING BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 1;       						
		        	gridbag.setConstraints(DELETE, c);
		        p4.add(DELETE);										
				DELETE.addActionListener(new ButtonHandler()); 

	
	CHANGEPW = new JButton("CHANGE PASSWORD");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(CHANGEPW, c);
		        p4.add(CHANGEPW);										
				CHANGEPW.addActionListener(new ButtonHandler());
				
	MARKEOI = new JButton("MARK END OF INPUT");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 3;       						
		        	gridbag.setConstraints(MARKEOI, c);
		        p4.add(MARKEOI);										
				MARKEOI.addActionListener(new ButtonHandler());

	QUERY = new JButton("RUN QUERY");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 4;       						
		        	gridbag.setConstraints(QUERY, c);
		        p4.add(QUERY);										
				QUERY.addActionListener(new ButtonHandler());

	REPORT = new JButton("REPORTS");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 2;       						      
		        	c.gridy = 0;       						
		        	gridbag.setConstraints(REPORT, c);
		        p4.add(REPORT);										
				REPORT.addActionListener(new ButtonHandler());

	ISSUE_BOOK = new JButton("ISSUE BOOK");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 2;       						      
		        	c.gridy = 1;       						
		        	gridbag.setConstraints(ISSUE_BOOK, c);
		        p4.add(ISSUE_BOOK);										
				ISSUE_BOOK.addActionListener(new ButtonHandler());

	ADD_BORROWER = new JButton("ADD NEW BORROWER");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 2;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(ADD_BORROWER, c);
		        p4.add(ADD_BORROWER);										
				ADD_BORROWER.addActionListener(new ButtonHandler());


	CLOSE_BORROWER = new JButton("CLOSE BORROWER RECORD");
					c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 2;       						      
		        	c.gridy = 3;       						
		        	gridbag.setConstraints(CLOSE_BORROWER, c);
		        p4.add(CLOSE_BORROWER);										
				CLOSE_BORROWER.addActionListener(new ButtonHandler());
	


	fr4.getContentPane().add(p4);
	JFrame.setDefaultLookAndFeelDecorated(true);

	}



	void addnewbook()

	    {
	 fr3=new JFrame(" My Librarian v1.0 Add-Book ");
     fr3.setVisible(true);
	 fr3.setSize(600,300);
	 //fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 p3=new JPanel();
	 p3.setLayout(gridbag);
	
     //serialno=new JTextField(5);
	 section=new JTextField(10);
	 bookname=new JTextField(30);
	 author=new JTextField(30);
	 price=new JTextField(20);
	 availcode=new JTextField(1);
	 currentborrower=new JTextField(30);

     /*l1=new JLabel("Serial No ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		gridbag.setConstraints(l1,c);
		p3.add(l1,c);
	     
	    serialno= new JTextField("                                           ");
	    c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=0;
		gridbag.setConstraints(serialno,c);
		p3.add(serialno);*/	

	 l2=new JLabel("Section ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p3.add(l2,c);

	section= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(section,c);
		p3.add(section);
	

	l3=new JLabel("Book Name ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=2;
		gridbag.setConstraints(l3,c);
		p3.add(l3,c);

	bookname= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=2;
		gridbag.setConstraints(bookname,c);
		p3.add(bookname);


	l4=new JLabel("Author ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=3;
		gridbag.setConstraints(l4,c);
		p3.add(l4,c);

	author= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=3;
		gridbag.setConstraints(author,c);
		p3.add(author);


	l5=new JLabel("Price ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=4;
		gridbag.setConstraints(l5,c);
		p3.add(l5,c);

	price= new JTextField("                               ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=4;
		gridbag.setConstraints(price,c);
		p3.add(price);


	l6=new JLabel("Avail Code ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=5;
		gridbag.setConstraints(l6,c);
		p3.add(l6,c);

	availcode= new JTextField("         ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=5;
		gridbag.setConstraints(availcode,c);
		p3.add(availcode);




	l7=new JLabel("Current Borrower ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=6;
		gridbag.setConstraints(l7,c);
		p3.add(l7,c);

	currentborrower= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=6;
		gridbag.setConstraints(currentborrower,c);
		p3.add(currentborrower);
	
	AddNewBook = new JButton("ADD THIS BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 7;       						
		        	gridbag.setConstraints(AddNewBook, c);
		        p3.add(AddNewBook);										
				AddNewBook.addActionListener(new ButtonHandler()); 


	fr3.getContentPane().add(p3);
	JFrame.setDefaultLookAndFeelDecorated(true);
	}

	void LIBADD() 
		{
		 	  try
			  {		
					String temp2 =  section.getText();
						   temp2 =  temp2.trim();
				    String temp3 =  bookname.getText();
						   temp3 =  temp3.trim();
					String temp4 =  author.getText();
						   temp4 =  temp4.trim();		
					String temp5 =  price.getText();
						   temp5 =  temp5.trim();
					String temp6 =  availcode.getText();
						   temp6 =  temp6.trim();		
					String temp7 =  currentborrower.getText();
						   temp7 =  temp7.trim();
			
					
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					//Generate new serial number
					String query = "SELECT * FROM book";
					ResultSet rs = statement.executeQuery(query);
					int cnt = 0;
					while (rs.next()) 
					{
    					cnt++;      					
					}
					cnt = cnt+1;
					serialno="000"+cnt;

					

					sq="INSERT INTO book (serialno, section, bookname, author, price, availcode, currentborrower, maker) VALUES ('"+serialno+"','"+temp2+"','"+temp3+"','"+temp4+"','"+temp5+"','"+temp6+"','"+temp7+"','"+loginnameback+"')";
										
					statement.executeUpdate(sq);	

					dialogmessage = "New Serial Number is : "+serialno;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

					dialogmessage = "New Book Added !! "+temp3;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

					connection.close();	
										
					//set other textboxes black to enable new record entry
					//serialno.setText("");
					section.setText("");
					bookname.setText("");
					author.setText("");
					price.setText("");
					availcode.setText("");
					currentborrower.setText("");
					
			  }
			  catch(Exception ex)
			  {

			  }
		}


void deloldbook()
	{

     fr5=new JFrame(" My Librarian v1.0 Delete-Book ");
     fr5.setVisible(true);
	 fr5.setSize(600,300);
	 p5=new JPanel();
	 p5.setLayout(gridbag);


	 l8=new JLabel("Enter Serial No : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		gridbag.setConstraints(l8,c);
		p5.add(l8,c);

	 serno= new JTextField("                                           ");
	    c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=0;
		gridbag.setConstraints(serno,c);
		p5.add(serno);


	DelOldBook = new JButton("DELETE THIS BOOK");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(DelOldBook, c);
		        p5.add(DelOldBook);										
				DelOldBook.addActionListener(new ButtonHandler()); 

	fr5.getContentPane().add(p5);
	JFrame.setDefaultLookAndFeelDecorated(true);

	}

void LIBCONFIRM() 
		{
		 	  try
			  {		
					
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM book";
					ResultSet rs = statement.executeQuery(query);
					boolean hasResults = statement.execute(query);

					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						//JDBC step 7 : if there are results Get the "SET" 
			    		if(result!=null)
						{ 	
							//take this "SET" of results from "SQL"
							//call this method "checkdel(ResultSet r)" and pass ResultSet to it 
							if (DelFlag)
							{
								checkdel(result);
							}

							else if(AddFlag)
							{
								checkadd(result);
							}
							
			   			}
							connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }

		}



void checkadd(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int numColumns=rmeta.getColumnCount();
				String temp3 =  bookname.getText();
					   temp3 =  temp3.trim();
				int foundrec = 0;


	while(r.next())
				{								
						String param3 = r.getString(3).trim();
						// 3rd field i.e. bookname in the table 'book' , database 'bank.mdb'						
						if (param3.equals(temp3))
						{
							foundrec =1;
							dialogmessage = "Book Already exist with Name : "+temp3;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

							section.setText("");
							bookname.setText("");
							author.setText("");
							price.setText("");
							availcode.setText("");
						   	currentborrower.setText("");
									    
						}

				}

						 if(foundrec==0)
						{
							dialogmessage = "Book Not Found,New book : "+temp3;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogf,dialogtype);
							
							String msgsel2 = "Addition OK?";
							int n = JOptionPane.showConfirmDialog(frame,msgsel1,msgsel2,JOptionPane.YES_NO_OPTION);
							if (n==JOptionPane.YES_OPTION)
							{
								LIBADD();
								AddFlag=false;
							}

							/*LIBADD();
							AddFlag=false;*/

						}
			
						
	//System.out.println(temp3);
				 
		}

void checkdel(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int numColumns=rmeta.getColumnCount();
				String temp1 =  serno.getText();
					   temp1 =  temp1.trim();
				int foundrec = 0;


	while(r.next())
				{								
						String param1 = r.getString(1).trim();
						// 1st field in the table 'book' , database 'bank.mdb'						
						if (param1.equals(temp1))
						{
							foundrec =1;
							dialogmessage = "Book Found with Serial no. : "+temp1;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

							//JButton showItButton = null;
							//radioButton = new JRadioButton;
							//showItButton = new JButton("Show It !!");
							String msgsel2 = "Deletion OK?";
							int n = JOptionPane.showConfirmDialog(frame,msgsel1,msgsel2,JOptionPane.YES_NO_OPTION);
							if (n==JOptionPane.YES_OPTION)
							{
								LIBDEL();
								DelFlag=false;
							}

							else return;

							//LIBDEL();
							

						}

				}

						 if(foundrec==0)
						{
							dialogmessage = "Book Not Found For Serial no. : "+temp1;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogf,dialogtype);
							serno.setText("");
						}
			
						
	//System.out.println(temp1);
				 
		}


	void LIBDEL()

	{
		try
		{
			String temp1 =  serno.getText();
				   temp1 =  temp1.trim();
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			sbookd="DELETE FROM book WHERE serialno='"+temp1+"'";
					
			statement.executeUpdate(sbookd);					
			connection.close();

			dialogmessage = "Book Deleted with Serial no. : "+temp1;
			dialogtype = JOptionPane.INFORMATION_MESSAGE;
			//show message
			JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

			serno.setText("");
	
		}
		catch(Exception ex)
			  {

			  }


	}

void addnewuser()

		{

	 fr7=new JFrame(" My Librarian v1.0 Add-New User ");
     fr7.setVisible(true);
	 fr7.setSize(600,300);
	
	 p7=new JPanel();
	 p7.setLayout(gridbag);
	
     username=new JTextField(10);
	 password=new JTextField(30);
	 Designation=new JTextField(30);
		
		
		l2=new JLabel("Enter User Name : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p7.add(l2,c);

		username= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(username,c);
		p7.add(username);
	

		l3=new JLabel("Enter Default Password : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=2;
		gridbag.setConstraints(l3,c);
		p7.add(l3,c);

	    password= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=2;
		gridbag.setConstraints(password,c);
		p7.add(password);


		l4=new JLabel("Designation ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=3;
		gridbag.setConstraints(l4,c);
		p7.add(l4,c);

		Designation= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=3;
		gridbag.setConstraints(Designation,c);
		p7.add(Designation);

		AddThisUser = new JButton("ADD THIS USER");
		        	c.ipady = 3;       						
					c.ipadx = 3;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx =0;       						      
		        	c.gridy =4;       						
		        	gridbag.setConstraints(AddThisUser, c);
		        p7.add(AddThisUser);										
				AddThisUser.addActionListener(new ButtonHandler());  

		

		
     fr7.getContentPane().add(p7);
	 JFrame.setDefaultLookAndFeelDecorated(true);

	}

void delexistuser()

		{

	 fr8=new JFrame(" My Librarian v1.0 Delete-Existing User ");
     fr8.setVisible(true);
	 fr8.setSize(600,300);
	
	 p8=new JPanel();
	 p8.setLayout(gridbag);
	
     username=new JTextField(10);
	 
		
		l2=new JLabel("Enter User Name : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p8.add(l2,c);

		username= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(username,c);
		p8.add(username);
	
		
		DelThisUser = new JButton("DELETE THIS USER");
		        	c.ipady = 3;       						
					c.ipadx = 3;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx =0;       						      
		        	c.gridy =4;       						
		        	gridbag.setConstraints(DelThisUser, c);
		        p8.add(DelThisUser);										
				DelThisUser.addActionListener(new ButtonHandler());  

		

		
     fr8.getContentPane().add(p8);
	 JFrame.setDefaultLookAndFeelDecorated(true);

	}


void USRCONFIRM() 
		{
		 	  try
			  {		
					
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM login";
					ResultSet rs = statement.executeQuery(query);
					boolean hasResults = statement.execute(query);

					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						//JDBC step 7 : if there are results Get the "SET" 
			    		if(result!=null)
						{ 	
							//take this "SET" of results from "SQL"
							//call this method "checkdel(ResultSet r)" and pass ResultSet to it 
							if (DelUsrFlag)
							{
								checkusrdel(result);
							}

							else if(AddUsrFlag)
							{
								checkusradd(result);
							}
							
			   			}
							connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }

		}



void checkusradd(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int numColumns=rmeta.getColumnCount();
				String temp3 =  username.getText();
					   temp3 =  temp3.trim();
				int foundrec = 0;


	while(r.next())
				{								
						String param3 = r.getString(1).trim();
						// 3rd field i.e. bookname in the table 'book' , database 'bank.mdb'						
						if (param3.equals(temp3))
						{
							foundrec =1;
							dialogmessage = "User Already exist with Name : "+temp3;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw,dialogtype);

							username.setText("");
							password.setText("");
							Designation.setText("");
									    
						}

				}

						 if(foundrec==0)
						{
							dialogmessage = "User Not Found,New User : "+temp3;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);


							String msgsel2 = "Addition OK?";
							int n = JOptionPane.showConfirmDialog(frame,msgsel1,msgsel2,JOptionPane.YES_NO_OPTION);
							if (n==JOptionPane.YES_OPTION)
							{
							USERADD();
							AddUsrFlag=false;
							}

							else return;

						}	
	
				 
		}






void checkusrdel(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int numColumns=rmeta.getColumnCount();
				String temp1 =  username.getText();
					   temp1 =  temp1.trim();
				int foundrec = 0;


	while(r.next())
				{								
						String param1 = r.getString(1).trim();
						// 1st field in the table 'book' , database 'bank.mdb'						
						if (param1.equals(temp1))
						{
							foundrec =1;
							dialogmessage = "User Found with Name : "+temp1;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);


							String msgsel2 = "Deletion OK?";
							int n = JOptionPane.showConfirmDialog(frame,msgsel1,msgsel2,JOptionPane.YES_NO_OPTION);
							if (n==JOptionPane.YES_OPTION)
							{
							USERDEL();
							DelUsrFlag=false;
							}

							else return;

						}

				}

						 if(foundrec==0)
						{
							dialogmessage = "User Not Found For Name : "+temp1;
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogf,dialogtype);
							username.setText("");
							password.setText("");
							Designation.setText("");

						}
			
						
	//System.out.println(temp1);
				 
		}

void USERADD() 
		{
		 	  try
			  {		
					String temp2 =  username.getText();
						   temp2 =  temp2.trim();
				    String temp3 =  password.getText();
						   temp3 =  temp3.trim();
					String temp4 =  Designation.getText();
						   temp4 =  temp4.trim();		
								
					
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					//Generate new serial number
					String query = "SELECT * FROM login";
					ResultSet rs = statement.executeQuery(query);
					int cnt = 0;
					while (rs.next()) 
					{
    					cnt++;      					
					}
					cnt = cnt+1;
					serialno="000"+cnt;

					sqUsr="INSERT INTO login (username, password, Designation, usercount) VALUES ('"+temp2+"','"+temp3+"','"+temp4+"','"+serialno+"')";
										
					statement.executeUpdate(sqUsr);	

					dialogmessage = "New User Number is : "+serialno;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

					dialogmessage = "New User Added !! "+temp2;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

					connection.close();	
										
					//set other textboxes black to enable new record entry
					//serialno.setText("");
					password.setText("");
					username.setText("");
					Designation.setText("");
										
			  }
			  catch(Exception ex)
			  {

			  }
		}


void USERDEL()

	{
		try
		{
			String temp1 =  username.getText();
				   temp1 =  temp1.trim();
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			sdUsr="DELETE FROM login WHERE username='"+temp1+"'";

			/*dialogmessage = "Are you sure ?? ";
			dialogtype = JOptionPane.QUESTION_MESSAGE;
			//show message
			JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogd,dialogtype);*/

			statement.executeUpdate(sdUsr);					
			connection.close();

			dialogmessage = "User Deleted with Name : "+temp1;
			dialogtype = JOptionPane.INFORMATION_MESSAGE;
			//show message
			JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

			username.setText("");
	
		}
		catch(Exception ex)
			  {

			  }


	}


void CHPW()
{
	 fr9=new JFrame("Change Password My Librarian v1.0 ");
     fr9.setVisible(true);
	 fr9.setSize(600,300);
	 p9=new JPanel();
	 p9.setLayout(gridbag);

	 
	 l1=new JLabel("Enter User Name : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		gridbag.setConstraints(l1,c);
		p9.add(l1,c);

	usrname= new JTextField("                                           ");
	    c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=0;
		gridbag.setConstraints(usrname,c);
		p9.add(usrname);



	 l2=new JLabel("Enter Old Password : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p9.add(l2,c);

	oldpw= new JPasswordField(10);
	oldpw.setEchoChar('*');
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(oldpw,c);
		p9.add(oldpw);


	l3=new JLabel("Enter New Password : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=2;
		gridbag.setConstraints(l3,c);
		p9.add(l3,c);

	newpw= new JPasswordField(10);
		newpw.setEchoChar('*');
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=2;
		gridbag.setConstraints(newpw,c);
		p9.add(newpw);


	l4=new JLabel("Confirm New Password : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=3;
		gridbag.setConstraints(l4,c);
		p9.add(l4,c);

	newpwc= new JPasswordField(10);
	newpwc.setEchoChar('*');
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=3;
		gridbag.setConstraints(newpwc,c);
		p9.add(newpwc);

	CHANGEMYPW = new JButton("CHANGE MY PASSWORD");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 4;       						
		        	gridbag.setConstraints(CHANGEMYPW, c);
					p9.add(CHANGEMYPW);										
	CHANGEMYPW.addActionListener(new ButtonHandler()); 

	fr9.getContentPane().add(p9);
	JFrame.setDefaultLookAndFeelDecorated(true);

	
   }

	
void PWCHG()

	{
		try
		{
			
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM login";
			ResultSet rs = statement.executeQuery(query);
			boolean hasResults = statement.execute(query);

					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						if(result!=null)
						{ 	
								validatepw(result);
			   			}
						connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }
		}	


void validatepw(ResultSet r) throws SQLException 
		{		
				
			String temp = usrname.getText();
			temp = temp.trim();
    
			//System.out.println(temp);

			String temp1 = oldpw.getText();
				   temp1 = temp1.trim();
			String temp2 = newpw.getText();
	               temp2 = temp2.trim();
			String temp3 = newpwc.getText();
	               temp3 = temp3.trim();

			if (temp1.equals(temp2))
			{
				dialogmessage = "New Password Same as Old one ";
				dialogtype = JOptionPane.INFORMATION_MESSAGE;
				 //show message
				 JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw,dialogtype);

				oldpw.setText("");
				newpw.setText("");
				newpwc.setText("");
				return;
			}

			/*else if (temp2 !=(temp3))
			{
				dialogmessage = "Pls confirm new password again ";
				dialogtype = JOptionPane.INFORMATION_MESSAGE;
				//show message
				JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw,dialogtype);
				//oldpw.setText("");
				newpw.setText("");
				newpwc.setText("");
				return;
				
			}*/
				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int foundrec = 0;
  				//int numColumns=rmeta.getColumnCount();  
				while(r.next())
				{								
						String param1 = r.getString(1).trim();
						String param2 = r.getString(2).trim();
										
						if (param1.equals(temp) && param2.equals(temp1))
						{
							foundrec=1;
							dialogmessage = "Correct Record Found ";
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw,dialogtype);
						}
							

				}

						if(foundrec==0)

						{
							dialogmessage = "Wrong Old Password ";
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogw,dialogtype);
							oldpw.setText("");
							newpw.setText("");
							newpwc.setText("");
							foundrec=0;
						}
		
			
			if (foundrec==1)
						{
							pwdchg();
							oldpw.setText("");
							newpw.setText("");
							newpwc.setText("");
						}

		}

void pwdchg()
{

	try
	{
							String temp = usrname.getText();
			                       temp = temp.trim();
							String temp2 = newpw.getText();
								   temp2 = temp2.trim();

							squpdate = "UPDATE login SET password='"+temp2+"' WHERE username = '"+temp+"'";
							Class.forName(driver);
			   				Connection connection=DriverManager.getConnection(url);
			   				Statement statement = connection.createStatement();
							statement.executeUpdate(squpdate);	
		   					connection.close();
							dialogmessage = "Password Changed ";
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);



	}

	catch(Exception ex)
			  {
			  		
			  }	
			  

		}		


void QueryBuilder() // DYNAMIC QUERY BUILDER TAB
		{
			 fr10=new JFrame(" My Librarian v1.0 Dynamic Query Builder ");
			 fr10.setVisible(true);
			 fr10.setSize(600,300);
			 p10=new JPanel();
			 p10.setLayout(gridbag);
					
						
			
			p10.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Run Your Query"));


					jCheckboxq1 = new JCheckBox("Serial Number");	
					jCheckboxq1.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 0;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq1, c5);
					jCheckboxq1.addItemListener(myListener);
        	   	p10.add(jCheckboxq1);				
				jRadiobuttonq1 = new JRadioButton("No Condition",true);
					jRadiobuttonq1.setFont(dataFont);
			    	c5.gridx = 1;       						
		        	c5.gridy = 0;  
					c5.fill = GridBagConstraints.BOTH;			
		        	gridbag.setConstraints(jRadiobuttonq1, c5);
					jRadiobuttonq1.addActionListener(rlistener);
					bgq.add(jRadiobuttonq1);
		        p10.add(jRadiobuttonq1);				
				jLabelq1 = new JLabel("   WHERE    ");
					jLabelq1.setFont(dataFont);
			    	c5.gridx = 2;       						
		        	c5.gridy = 0; 
					c5.fill = GridBagConstraints.BOTH;	    						
		        	gridbag.setConstraints(jLabelq1, c5);					
		        p10.add(jLabelq1);				
				jComboboxq1 = new JComboBox();
				 		jComboboxq1.addItem("Book Name");
		    			jComboboxq1.addItem("Author"); 
		    			jComboboxq1.addItem("Price");
		    			jComboboxq1.addItem("Current Borrower");
						jComboboxq1.addItem("Availability");
						jComboboxq1.setFont(dataFont);
		       	 		c5.gridx = 3;					
		        		c5.gridy = 0;	
						c5.fill = GridBagConstraints.BOTH;	
						jComboboxq1.addItemListener(cbListener);   				
		        		gridbag.setConstraints(jComboboxq1, c5);
		        p10.add(jComboboxq1);				
				jComboboxq2 = new JComboBox();
				 		jComboboxq2.addItem("=");
		    			jComboboxq2.addItem(">");
		    			jComboboxq2.addItem(">=");
		    			jComboboxq2.addItem("<");
						jComboboxq2.addItem("<=");
						jComboboxq2.addItem("!=");
						jComboboxq2.addItem("LIKE");
						jComboboxq2.addItem("NOT LIKE");
						jComboboxq2.setFont(dataFont);
		       	 		c5.gridx = 4;					
		        		c5.gridy = 0;	
						c5.fill = GridBagConstraints.BOTH;	       				
		       			gridbag.setConstraints(jComboboxq2, c5);
						jComboboxq2.addItemListener(cbListener);  
		        p10.add(jComboboxq2);	    		
				givencondition = new JTextField("                                           ");
		        	c5.gridx = 5;       						    
		        	c5.gridy = 0;       						
		        	gridbag.setConstraints(givencondition, c5);
		        p10.add(givencondition);					
				jCheckboxq2 = new JCheckBox("Book Name");	
					jCheckboxq2.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 1;	
					c5.fill = GridBagConstraints.BOTH;	 
        	   		gridbag.setConstraints(jCheckboxq2, c5);
					jCheckboxq2.addItemListener(myListener);
        	   	p10.add(jCheckboxq2);				
				jRadiobuttonq2 = new JRadioButton("Set Condition",false);
					jRadiobuttonq2.setFont(dataFont);
			    	c5.gridx = 1;       						
		        	c5.gridy = 1;  
					c5.fill = GridBagConstraints.BOTH;			
		        	gridbag.setConstraints(jRadiobuttonq2, c5);
					jRadiobuttonq2.addActionListener(rlistener);
					bgq.add(jRadiobuttonq2);
		        p10.add(jRadiobuttonq2);				
				jCheckboxq3 = new JCheckBox("Author");	
					jCheckboxq3.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 2;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq3, c5);
					jCheckboxq3.addItemListener(myListener);
        	   	p10.add(jCheckboxq3);				
				jCheckboxq4 = new JCheckBox("Price");	
					jCheckboxq4.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 3;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq4, c5);
					jCheckboxq4.addItemListener(myListener);
        	   	p10.add(jCheckboxq4);				
				jCheckboxq5 = new JCheckBox("Currrent Borrower");	
					jCheckboxq5.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 4;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq5, c5);
					jCheckboxq5.addItemListener(myListener);
        	   	p10.add(jCheckboxq5);												
				RUNQUERY = new JButton("RUN THIS QUERY");										
						c5.gridx = 5;       						     
			        	c5.gridy = 4;  
						gridbag.setConstraints(RUNQUERY, c5);						
						RUNQUERY.addActionListener(new ButtonHandler());	
				p10.add(RUNQUERY);				
				jLabelq2 = new JLabel(" Query Result ");
					jLabelq2.setFont(dataFont);
					c5.weighty = 1.0;
		        	c5.gridx = 0;       						
		        	c5.gridy = 5;  
					c5.gridwidth = 6;     						
		        	gridbag.setConstraints(jLabelq2, c5);
		        p10.add(jLabelq2);
				resultArea = new JTextArea(10,60);
					resultArea.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 6;	
					c5.fill = GridBagConstraints.BOTH;		
					c5.gridwidth = 6;  				
        	   		gridbag.setConstraints(resultArea, c5);
        	   		p10.add(resultArea);
				


	fr10.getContentPane().add(p10);
	JFrame.setDefaultLookAndFeelDecorated(true);

		}


class CheckBoxListener implements ItemListener 
		{
    		
			public void itemStateChanged(ItemEvent e) 
    		{
        		Object source = e.getItemSelectable();


				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq1))
       			{
					SerialNoSel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq1))
       			{
					SerialNoSel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq2))
       			{
					BookNameSel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq2))
       			{
					BookNameSel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq3))
       			{
					AuthorSel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq3))
       			{
					AuthorSel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq4))
       			{
					PriceSel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq4))
       			{
					PriceSel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq5))
       			{
					CurrentBorrowerSel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq5))
       			{
					CurrentBorrowerSel = 0;
      			}	
										
    		}			
		}


class ComboBoxListener implements ItemListener  
		{
      		public void itemStateChanged(ItemEvent e) 
			{				
		    	sr = (String)e.getItem();

				if (e.getSource().equals(jComboboxq1))
    			{
					Combo1sel = jComboboxq1.getSelectedItem().toString();
    			}
				if (e.getSource().equals(jComboboxq2))
    			{
					Combo2sel = jComboboxq2.getSelectedItem().toString();
    			}
		    }
		}

		class RadioListener implements ActionListener 
		{
      		public void actionPerformed(ActionEvent e) 
			{
				  condsel = e.getActionCommand();
		    }
		}




void handleQuery()
		{
				qry="SELECT";
				int cnt=0;
				if(SerialNoSel==1)
				{
					cnt++;
					qry+=" serialno,";
				}
				if(BookNameSel==1)
				{
					cnt++;
					qry+=" bookname,";
				}
				if(AuthorSel==1)
				{
					cnt++;
					qry+=" author,";
				}
				if(PriceSel==1)
				{
					cnt++;
					qry+=" price,";
				}
				if(CurrentBorrowerSel==1)
				{
					cnt++;
					qry+=" currentborrower,";
				}		
				int slen=qry.length();
				int tempslen = slen-1;
				qry = qry.substring(0,tempslen);
				qry+=" FROM book";
				if(condsel=="Set Condition")
				{
					qry+=" WHERE "+Combo1sel+" "+Combo2sel+" "+givencondition.getText().trim();
				}
				jLabelq2.setText(qry);
				accessDBquery(qry); 
		}



void accessDBquery(String sqlq) 
		{
  			try
			{
   				Class.forName(driver);
	   			Connection connection=DriverManager.getConnection(url);
	   			Statement statement = connection.createStatement();
	   			boolean hasResults = statement.execute(sqlq);
	   			if(hasResults)
				{
	    			ResultSet result = statement.getResultSet();
		    		if(result!=null) 
					{
						displayResultsQ(result);
					}
					else 
					{
						resultArea.setText("");
					}   				
				}
				connection.close();
  			}
			catch(Exception ex)
			{
   				resultArea.setText(ex.toString());
  			}
 		}
		void displayResultsQ(ResultSet r) throws SQLException 
		{
	  		ResultSetMetaData rmeta = r.getMetaData();
	  		int numColumns=rmeta.getColumnCount();
	  		String text="";
	  		for(int i=1;i<=numColumns;++i) 
			{
	   		if(i<numColumns)
	    		text+=rmeta.getColumnName(i)+" | ";
	   		else
	    		text+=rmeta.getColumnName(i);
	  		}
	  		text+="\n";
	  		while(r.next())
			{
	   			for(int i=1;i<=numColumns;++i) 
				{
	    			if(i<numColumns)
	     				text+=r.getString(i)+" | ";
	    			else
	     				text+=r.getString(i).trim();
	   			}
	   			text+="\n";
	  		}
	  		resultArea.setText(text);
	 	}




/*void setupMenuBar() 
		{
  			  MenuBar menuBar = new MenuBar();
			  // Main Menu will be "File"
			  Menu fileMenu = new Menu("File");		
			  		// Sub menu under it will be "Exit"	  		
			  		MenuItem fileExit = new MenuItem("Exit");		
						// Handle this submenu item clcik event to Exit 	  			  
			  			fileExit.addActionListener(new MenuItemHandler()); 
			  			fileMenu.add(fileExit);					
			  		menuBar.add(fileMenu);
			  setMenuBar(menuBar);
 		}	




class MenuItemHandler implements ActionListener 
		{
  			public void actionPerformed(ActionEvent ev)
			{
   				String s=ev.getActionCommand();
   				if(s=="Exit")
				{
					//close window on menuitem exit
    				System.exit(0);
   				}								
  			}					
 		}*/


void BookReports() // REPORTS TAB WITH JTABLE
		{
			 
			  fr11=new JFrame("Book Reports My Librarian v1.0 ");
			  fr11.setVisible(true);
			  fr11.setSize(600,300);
			  p11=new JPanel();
			  p11.setLayout(gridbag);
			  JPanel p11 = new JPanel();			
			  p11.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Book Reports"));
			  try
			  {			  					
					Class.forName(driver);					
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();	
					String query = "SELECT serialno, bookname, author, price FROM book";
					ResultSet rs = statement.executeQuery(query);	
					ResultSetMetaData rmeta = rs.getMetaData();
					int numColumns=rmeta.getColumnCount();					
					for(int i=1;i<=numColumns;++i) 
					{
   						if(i<=numColumns)
						{
							defaulttablemodel.addColumn(rmeta.getColumnName(i));
						}   					
  					}					
					while(rs.next())
					{   						
						for(int i=1;i<=numColumns;++i)   
						{		
							if(i<=numColumns)
							{				 	
								tempname = rs.getString(i);
								tempcnt=i-1;
								data[tempcnt] = tempname;		
							}			
	   					}   
						defaulttablemodel.addRow(data);						
   					}
			  }
			  catch(Exception ex)
			  {
			  		//
			  }
	        p11.add(new JScrollPane(jtable));
			fr11.getContentPane().add(p11);
			JFrame.setDefaultLookAndFeelDecorated(true);
		}


void addnewborrower()
	    {
	 fr12=new JFrame(" My Librarian v1.0 Add-Borrower ");
     fr12.setVisible(true);
	 fr12.setSize(600,300);
	 //fr12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 p12=new JPanel();
	 p12.setLayout(gridbag);
	
      
	 boname=new JTextField(30);
	 boaddress=new JTextField(50);
	 //bostatuscode=new JTextField(20);
	

	 l2=new JLabel("Borrower Name :  ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p12.add(l2,c);

	boname= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(boname,c);
		p12.add(boname);
	

	l3=new JLabel("Borrower Address : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=2;
		gridbag.setConstraints(l3,c);
		p12.add(l3,c);

	boaddress= new JTextField("                                                                              ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=2;
		gridbag.setConstraints(boaddress,c);
		p12.add(boaddress);

     l4=new JLabel("Phone No : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=3;
		gridbag.setConstraints(l4,c);
		p12.add(l4,c);

	 bophoneno= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=3;
		gridbag.setConstraints(bophoneno,c);
		p12.add(bophoneno);


	
	AddThisBorrower = new JButton("ADD THIS BORROWER");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 4;       						
		        	gridbag.setConstraints(AddThisBorrower, c);
		        p12.add(AddThisBorrower);										
				AddThisBorrower.addActionListener(new ButtonHandler()); 


	fr12.getContentPane().add(p12);
	JFrame.setDefaultLookAndFeelDecorated(true);
	}


void BORROWER_ADD() 
		{
		 	  try
			  {		
					String temp2 =  boname.getText();
						   temp2 =  temp2.trim();
				    String temp3 =  boaddress.getText();
						   temp3 =  temp3.trim();
				    String temp5 =  bophoneno.getText();
						   temp5 =  temp5.trim();
				    
							
					
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					//Generate new serial number
					String query = "SELECT * FROM borrower_record";
					ResultSet rs = statement.executeQuery(query);
					int cnt = 0;
					while (rs.next()) 
					{
    					cnt++;      					
					}
					cnt = cnt+1;
					serialno="000"+cnt;

					String temp4 = "O";

					sq="INSERT INTO borrower_record (boserial, boname, boaddress, bophoneno, bostatuscode) VALUES ('"+serialno+"','"+temp2+"','"+temp3+"','"+temp5+"','"+temp4+"')";
										
					statement.executeUpdate(sq);	

					dialogmessage = "New Serial Number is : "+serialno;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);
					

					dialogmessage = "New Borrower Record Added !! "+temp2;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);

					connection.close();	
										
					//set other textboxes black to enable new record entry
					//serialno.setText("");
					boname.setText("");
					boaddress.setText("");
					bophoneno.setText("");
										
			  }
			  catch(Exception ex)
			  {

			  }
		}

	void ISSUE_BOOK()
	     {
	 fr13=new JFrame("Task Performer My Librarian v1.0 ");
     fr13.setVisible(true);
	 fr13.setSize(600,300);
	 p13=new JPanel();
	 p13.setLayout(gridbag);
     
	 p13.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"ISSUE BOOK"));

	 
	  l2=new JLabel("Enter Serials No: ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p13.add(l2,c);

	  fboserial= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(fboserial,c);
		p13.add(fboserial);
	 
	 VIEW_REC = new JButton("VIEW");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 0;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(VIEW_REC, c);
		        p13.add(VIEW_REC);										
				VIEW_REC.addActionListener(new ButtonHandler()); 

	fr13.getContentPane().add(p13);
	JFrame.setDefaultLookAndFeelDecorated(true);


	 }


void ExtractBookRecord() 
		{
		 	  try
			  {		

					String temp3 =  fboserial.getText();
	 					   temp3 =  temp3.trim();	
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url);
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM borrower_record WHERE boserial ='"+temp3+"'";
					boolean hasResults = statement.execute(query);
							
					//System.out.println(temp3);

					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						//JDBC step 7 : if there are results Get the "SET" 
			    		if(result!=null)
						{ 	
							GetRecord(result);
						}

						connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }

		}




void GetRecord(ResultSet r) throws SQLException 
		{
  				
				String temp3 =  fboserial.getText();
	 				   temp3 =  temp3.trim();
			//	System.out.println(temp3);

				ResultSetMetaData rmeta = r.getMetaData();
				int foundrec = 0;
  				int numColumns=rmeta.getColumnCount();
				String text2="";	
				String text3="";	
				String text4="";	
				String text5="";
				String text7="";
				String text6="";	
				

				while(r.next())
				{
					text2+=r.getString(1);
  					text3+=r.getString(2);
					text4+=r.getString(3);
					text5+=r.getString(4);
					text6+=r.getString(5);
					text7+=r.getString(7);
				}

	//	System.out.println(text3);
		
	  fr14=new JFrame("Borrower Last Details ");
      fr14.setVisible(true);
	  fr14.setSize(600,300);
	  p14=new JPanel();
	  p14.setLayout(gridbag);
     
	  p14.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Borrower "+text3+" Details"));

	 
	  l2=new JLabel("Serials No: ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=1;
		gridbag.setConstraints(l2,c);
		p14.add(l2,c);

	  borrowerSerialno= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=1;
		gridbag.setConstraints(borrowerSerialno,c);
		p14.add(borrowerSerialno);
	  borrowerSerialno.setText(text2);


	 l4=new JLabel("Name : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=2;
		gridbag.setConstraints(l4,c);
		p14.add(l4,c);

		borrowerName= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=2;
		gridbag.setConstraints(borrowerName,c);
		p14.add(borrowerName);	
		borrowerName.setText(text3);


		l5=new JLabel("Address : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=3;
		gridbag.setConstraints(l5,c);
		p14.add(l5,c);

		borrowerAddress= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=3;
		gridbag.setConstraints(borrowerAddress,c);
		p14.add(borrowerAddress);	
		borrowerAddress.setText(text4);

		l10=new JLabel("Phone No : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=4;
		gridbag.setConstraints(l10,c);
		p14.add(l10,c);

		borrowerPhoneNo= new JTextField("                                   ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=4;
		gridbag.setConstraints(borrowerPhoneNo,c);
		p14.add(borrowerPhoneNo);	
		borrowerPhoneNo.setText(text5);

		
		l6=new JLabel("Last Book : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=5;
		gridbag.setConstraints(l6,c);
		p14.add(l6,c);

		borrowerLastBook= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=5;
		gridbag.setConstraints(borrowerLastBook,c);
		p14.add(borrowerLastBook);	
		borrowerLastBook.setText(text6);


		l7=new JLabel("Last Magazine : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=6;
		gridbag.setConstraints(l7,c);
		p14.add(l7,c);

		borrowerLastMagazine= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=6;
		gridbag.setConstraints(borrowerLastMagazine,c);
		p14.add(borrowerLastMagazine);	
		//borrowerLastMagazine.setText(text6);


		l8=new JLabel("Borrower status : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=7;
		gridbag.setConstraints(l8,c);
		p14.add(l8,c);

		borrowerStatus= new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=1;
		c.gridy=7;
		gridbag.setConstraints(borrowerStatus,c);
		p14.add(borrowerStatus);	
		borrowerStatus.setText(text7);


		l9=new JLabel("New Book : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=2;
		c.gridy=4;
		gridbag.setConstraints(l9,c);
		p14.add(l9,c);

		borrowerNewBook = new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=3;
		c.gridy=4;
		gridbag.setConstraints(borrowerNewBook,c);
		p14.add(borrowerNewBook);

		
		l10=new JLabel("New Magazine : ");
	    c.ipady=2;
		c.ipadx=2;
		c.anchor=GridBagConstraints.WEST;
		c.gridx=2;
		c.gridy=5;
		gridbag.setConstraints(l10,c);
		p14.add(l10,c);

		borrowerNewMagazine = new JTextField("                                           ");
		c.ipady=2;
		c.ipadx=2;
		c.gridx=3;
		c.gridy=5;
		gridbag.setConstraints(borrowerNewMagazine,c);
		p14.add(borrowerNewMagazine);


		MODIFY_REC = new JButton("MODIFY");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.EAST; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 2;       						      
		        	c.gridy = 6;       						
		        	gridbag.setConstraints(MODIFY_REC, c);
		        p14.add(MODIFY_REC);										
				MODIFY_REC.addActionListener(new ButtonHandler());

	fr14.getContentPane().add(p14);
	JFrame.setDefaultLookAndFeelDecorated(true);

		}


void UpdateBorrowerRecord()

	{
		try
		{
			
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM borrower_record";
			ResultSet rs = statement.executeQuery(query);
			boolean hasResults = statement.execute(query);

					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						if(result!=null)
						{ 	
								Update_BorrowerDB();
			   			}
						connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }

		}	

void Update_BorrowerDB()
{

	try
	{
							String temp = borrowerSerialno.getText();
							       temp = temp.trim();							
							String temp1 = borrowerNewBook.getText();
			                       temp1 = temp1.trim();
							String temp2 = borrowerNewMagazine.getText();
								   temp2 = temp2.trim();
							String temp5 = borrowerStatus.getText();
							       temp5 = temp5.trim();
						    int foundclosedrec = 0;


							System.out.println(temp5);

						     if (temp5.equals("C"))
						     {
								foundclosedrec = 1;
								dialogmessage = "Cannot Update.Closed Record";
								dialogtype = JOptionPane.INFORMATION_MESSAGE;
								//show message
								JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogf,dialogtype);
								return;
						     }

						    //System.out.println(temp);
							//System.out.println(temp1);
							//System.out.println(temp2);

							if (foundclosedrec==0)
							{
							squpdate_book = "UPDATE borrower_record SET bolastbook='"+temp1+"' WHERE boserial = '"+temp+"'";
							squpdate_mag = "UPDATE borrower_record SET bolastmagazine='"+temp2+"' WHERE boserial = '"+temp+"'";
							Class.forName(driver);
			   				Connection connection=DriverManager.getConnection(url);
			   				Statement statement = connection.createStatement();
							statement.executeUpdate(squpdate_book);	
							statement.executeUpdate(squpdate_mag);
		   					connection.close();

							dialogmessage = "Borrower Record Updated";
							dialogtype = JOptionPane.INFORMATION_MESSAGE;
							//show message
							JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs,dialogtype);
					
							borrowerNewBook.setText("");
							borrowerNewMagazine.setText("");

							}
					
							fr14.setVisible(false);
							ISSUE_BOOK();

	}

	catch(Exception ex)
			  {
			  		
			  }	
			  

		}		


void getDate()
		{
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT="dd-MM-yyyy";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		//System.out.println("Now : "+sdf.format(cal.getTime()));
		String t1 = sdf.format(cal.getTime());
		}


}

