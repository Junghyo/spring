/*
 # Model 확인예제
 구매 금액 누적 확인
 물건 가격: [	  ]
 물건 갯수: [  ]
 [구매완료]
 현재 누적 금액: [	]
*/
package spring.a01_basic;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Code;
import spring.dto.Emp;
import spring.dto.Product;
import spring.z01_database.A01_EmpDB;

@Controller
public class A09_ModelAttriExp_0602 {
	@ModelAttribute("deptList")
	public ArrayList<Code> deptList(){
		ArrayList<Code> list = new ArrayList<Code>();
		list.add(new Code("10", "인사"));
		list.add(new Code("20", "재무"));
		list.add(new Code("30", "it사업부"));
		list.add(new Code("40", "총무"));
		return list;
	}
	@RequestMapping("/buy2.do")
	public String save(@ModelAttribute("prod") Product prod){
		prod.setSum(prod.getPrice()*prod.getCnt()+prod.getSum());
		return "a01_basic/a21_callPord_0602";
	}
//	화면단 호출
//	http://localhost:7080/spring_web/emplist.do
	@RequestMapping("/emplist.do")
	public String empList(
			@ModelAttribute("sch") Emp sch, Model m){
		if(sch.getEname()!=null){
			m.addAttribute("list", new A01_EmpDB().searchPre(sch));
		}
		return "a01_basic/a22_empList_0602";
		
	}
}
