package spring.exercise;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class aaa {

	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engin = mgr.getEngineByName("JavaScript");
		int num01=2;
		int num02=3;
		String symbol="+";
		System.out.println(engin.eval(num01+symbol+num02));
	}

}
