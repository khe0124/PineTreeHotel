package kr.co.pinetree.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller //������ ���� Ŭ����
@SessionAttributes("id")
public class SpringSession {
	@RequestMapping("/Session.sp") //������ ��Ʈ�ѷ� �ּ�
    public String gender(Model model) {
        //Spring���� �����ϴ� ������� �Ķ���͸� gender ������ ����
        
        model.addAttribute("id", "admin");
        //Ű�� id�� "admin"�� model��ü�� ����
            
        model.addAttribute("className", this.getClass());
        //model ��ü�� ���� Ŭ�����̸��� className�̶�� Ű�� ����
        
        return "/"; //������
	}
}
