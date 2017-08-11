
package spring.a01_basic;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Code;
import spring.dto.Exam3;

@Controller
public class A11_ModelCal_0602 {
	@ModelAttribute("calcu")
	public ArrayList<Code> calList(){
		ArrayList<Code> list = new ArrayList<Code>();
		list.add(new Code("0","+"));
		list.add(new Code("1","-"));
		list.add(new Code("2","*"));
		list.add(new Code("3","/"));
		return list;
	}
	@RequestMapping("/exam3.do")
	public String calcu(@ModelAttribute("cal") Exam3 ex3){
		System.out.println("num01: "+ex3.getNum01());
		System.out.println("calIdx: "+ex3.getCalIdx());
		System.out.println("num01: "+ex3.getNum02());
		int results[]={ex3.getNum01()+ex3.getNum02(),
				ex3.getNum01()-ex3.getNum02(),
				ex3.getNum01()*ex3.getNum02(),
				ex3.getNum02()==0?0:ex3.getNum01()/ex3.getNum02(),		
		};
		ex3.setResult(results[ex3.getCalIdx()]);
		return "a01_basic/a15_exam2_0602";
	}
}
