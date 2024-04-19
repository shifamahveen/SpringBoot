package com.example.demo;

public class Trig {
	private int id;
	private String func;
	private int angle;
	private double result;
	
	// parameterized constructor	
	public Trig(String func, int angle, double result) {
		super();
		this.func = func;
		this.angle = angle;
		this.result = result;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
}
