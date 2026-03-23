package com.rays.jdbc.preparedstatement;

public class EmployeeBean {

	private int ID;
	private String NAME;
	private String COMPANY;
	private int SAALARY;
	private int DEPT_NO;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public int getSAALARY() {
		return SAALARY;
	}

	public void setSAALARY(int sAALARY) {
		SAALARY = sAALARY;
	}

	public int getDEPT_NO() {
		return DEPT_NO;
	}

	public void setDEPT_NO(int dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}

}
