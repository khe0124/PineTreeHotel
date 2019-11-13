package net.utility;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class MyAuthenticator extends Authenticator {
	//ï¿½ê¶—ï¿½ìŠœï¿½ë¸¯?¨ì¢?˜„ ï¿½ë¸¯ï¿½ë’— ï§ë¶¿?”ªï¿½ê½Œè¸°ê¾©ë¿‰ï¿½ê½? ï¿½ì”¤ï§ì•¸ì»ºï¿½ï¿? ?¨ê¾©? ™/?®ê¾¨ì¾²
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
