package net.utility;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class MyAuthenticator extends Authenticator {
	private PasswordAuthentication pa;
	
	public MyAuthenticator(){
		pa=new PasswordAuthentication("soldesk@pretyimo.cafe24.com", "soldesk6901");
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return pa;
	}
}//class end
