package cihan.kurs.flow.model;

import java.io.Serializable;

public class Flow implements Serializable{
	private static final long serialVersionUID = 244906026612031345L;
	private int flowseviye;
	private int flowlevel;
	private String flowrenk;
	private int flowposition;
	private int renk1;
	private int renk2;
	private int renk3;

	public int getFlowseviye() {
		return flowseviye;
	}
	public void setFlowseviye(int flowseviye) {
		this.flowseviye = flowseviye;
	}
	public int getFlowlevel() {
		return flowlevel;
	}
	public void setFlowlevel(int flowlevel) {
		this.flowlevel = flowlevel;
	}
	public String getFlowrenk() {
		return flowrenk;
	}
	public void setFlowrenk(String flowrenk) {
		this.flowrenk = flowrenk;
	}
	public int getFlowposition() {
		return flowposition;
	}
	public void setFlowposition(int flowposition) {
		this.flowposition = flowposition;
	}
	public int getRenk1() {
		return renk1;
	}
	public void setRenk1(int renk1) {
		this.renk1 = renk1;
	}
	public int getRenk2() {
		return renk2;
	}
	public void setRenk2(int renk2) {
		this.renk2 = renk2;
	}
	public int getRenk3() {
		return renk3;
	}
	public void setRenk3(int renk3) {
		this.renk3 = renk3;
	}
}
