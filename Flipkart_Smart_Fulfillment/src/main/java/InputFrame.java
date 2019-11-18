import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class InputFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	private JTextField pickId;    
	
	public static void main(String []args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					InputFrame frame=new InputFrame();
					frame.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public InputFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,517,557);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeading = new JLabel("Flipkart Smart Fulfillment");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(161,17,149,29);
		contentPane.add(lblHeading);
		
		JLabel lblUserid=new JLabel("User Id");
		lblUserid.setBounds(91,100,61,16);
		contentPane.add(lblUserid);
		
		id = new JTextField();
		id.setBounds(171,100,188,26);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblPassword=new JLabel("Password");
		lblPassword.setBounds(91,150,61,16);
		contentPane.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(30);
		password.setBounds(171,150,188,26);
		contentPane.add(password);
		
		JLabel pickLid=new JLabel("PICK ID");
		pickLid.setBounds(91,200,61,16);
		contentPane.add(pickLid);
		
		pickId=new JTextField();
		pickId.setColumns(30);
		pickId.setBounds(171,200,188,26);
		contentPane.add(pickId);
		
//		String emailId=id.getText();
//		String pwd=password.getText();
//		String pickid=pickId.getText();

		
		JButton btnSubmit=new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				fillDetails();
				
			} catch (IOException | AWTException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			Selenium2Example webView=new Selenium2Example();
		}
		});
		btnSubmit.setBounds(171,250,129,35);
		contentPane.add(btnSubmit);

	}
	public void fillDetails() throws IOException, AWTException, InterruptedException{
//		String emailId=id.getText();
//		String pwd=password.getText();
//		String pickid=pickId.getText();

		String emailId="inquirytandul@gmail.com";
		String pwd="9873403201";
		String pickid="P080519-F80DD3CEB26C";
		
//		Form form=new Form(emailId,pwd);
//		System.out.println(emailId+pwd);
		if (emailId.equals("inquirydarzi@gmail.com") || emailId.equals("inquirytandul@gmail.com")){
			Login login=new Login();
			login.loginFunction(emailId,pwd,pickid);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please fill the correct email address");

		}
	}

	
	
	
		
	
}

	

