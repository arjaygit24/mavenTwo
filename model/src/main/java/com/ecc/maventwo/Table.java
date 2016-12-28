package com.ecc.maventwo;

import java.util.List;
import java.util.Map;

public class Table {

	private int row;
	private int col;
	private Map<String,String> rowTable;
	private List<Map<String,String>> table;


	public void setRow(int row){
		this.row=row;
	}

	public int getRow(){
		return row;
	}

	public void setCol(int col){
		this.col=col;
	}

	public int getCol(){
		return col;
	}

	public void setRowTable(Map<String,String> rowTable){
		this.rowTable=rowTable;
	}

	public Map<String,String> getRowTable(){
		return rowTable;
	}

	public void setTable(List<Map<String, String>> table){
		this.table=table;
	}

	public List<Map<String,String>> getTable(){
		return table;
	}

}
