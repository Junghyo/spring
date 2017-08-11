package spring.a01_basic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Exam;

@Controller
public class A02_Calculation_0601 {
	@RequestMapping("/exam.do")
	public String exam(Model d){
		Exam e = new Exam();
		e.setNum01((int) Math.floor(Math.random()*8+1));
		e.setNum02((int) Math.floor(Math.random()*8+1));
		d.addAttribute("exam", e);
		return "a01_basic/a05_exam_0601";		
	}
	@RequestMapping("/examCheck.do")
	public String examCheck(Exam e, Model d) throws ScriptException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("JavaScript");
		String page="a05_exam_0601";
		d.addAttribute("msg", "오답입니다");
		if( e.getSum()==((int) (se.eval(e.getNum01()+e.getSymbol()+e.getNum02()))) ){
			page="a06_examPass_0601";
			d.addAttribute("msg", "정답! 축하합니다.");
		}
		return "a01_basic/"+page;
		
	}
}
