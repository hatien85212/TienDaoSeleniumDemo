package javaDesignPattern;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VariableStorage implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> variables = null;

	private VariableStorage() {
		variables = new ConcurrentHashMap<String, String>();
	}

	protected Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return createInstance();
	}

	private static class LazyInit {
		private static final VariableStorage variableStorage = new VariableStorage();
	}

	public static VariableStorage createInstance() {
		return LazyInit.variableStorage;
	}

	public void add(String key, String value) {
		variables.put(key, value);
	}

	public String get(String name){
		if(variables.containsKey(name)){
			return variables.get(name);
		}
		return null;
	}

	public void printAllVariables() {
		System.out.println ("##### PRINTING ALL ITEMS IN VARIABLE STORAGE #####");
		System.out.println ("-----VARS COUNT: " + variables.size());
		for (Map.Entry<String, String> entry : variables.entrySet()) {
			System.out.println("-------NAME= " + entry.getKey() + ", VALUE= " + entry.getValue());
		}
	}
}