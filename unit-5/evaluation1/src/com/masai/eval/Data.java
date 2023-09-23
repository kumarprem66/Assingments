package com.masai.eval;

public class Data {

	
	private int intVar;
	private float floatVar;
	private String stringVar;
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public float getFloatVar() {
		return floatVar;
	}
	public void setFloatVar(float floatVar) {
		this.floatVar = floatVar;
	}
	public String getStringVar() {
		return stringVar;
	}
	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}
	public Data(int intVar, float floatVar, String stringVar) {
		super();
		this.intVar = intVar;
		this.floatVar = floatVar;
		this.stringVar = stringVar;
	}
	
	
}
