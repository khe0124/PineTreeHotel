package net.utility;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class MyAuthenticator extends Authenticator {
	//�궗�슜�븯?�좎?�� �븯�뒗 硫붿?���꽌踰꾩뿉��? �씤利앸컺��? ?�꾩?��/?��꾨쾲
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
