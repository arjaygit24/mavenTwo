package com.ecc.maventwo;


import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class App {

	public static void main(String[] args) {
		TableService tableService = new TableService();
		Table table = new Table();
		Scanner read = new Scanner(System.in);
		int choice=0;
		if(tableService.readFromText()==false){
			System.out.println("File not found. New file created");
			choice=4;
		}
		while(choice!=7){
			switch(choice){
			case 1:
				tableService.print();
				break;
			case 2:
				String searchStr=checkString("Enter the string to search",1,3);
				tableService.search(searchStr);
				break;
			case 3:
				int rowEdit = checkNumber("Enter row of the coordinate. ",0,tableService.getRow()-1);
				int colEdit = checkNumber("Enter col of the coordinate. ",0,tableService.getCol()-1);
				String editStr= checkString("Enter string to edit. ",3,3);
				int keyOrValue = checkNumber("Which one do you want to edit. ",1,2);
				tableService.edit(editStr,rowEdit,colEdit,keyOrValue);
				break;
			case 4:
				int nRow=checkNumber("Enter row. ",0,9);
				int nCol=checkNumber("Enter column. ",0,9);
				tableService.reset(nRow, nCol);
				break;
			case 5:
				int addNumRow = checkNumber("Enter number of rows to add. ",0,100);
				tableService.addRow(addNumRow);
				break;
			case 6:
				tableService.sort();
			default:
				break;
			}
			printOptions();
			choice=checkNumber("Choose from the following. ",1,8);
		}
	}

	public static String checkString(String message, int min, int max){
		Scanner read = new Scanner(System.in);
		String result="";
		while(result.length()<min || result.length()>max){
			System.out.println(message);
			result = StringUtils.deleteWhitespace(read.nextLine()); // deleting whitespace inputs using stringutils
		}
		return result;
	}

	public static void printOptions(){
		System.out.println("Choose from the following ");
		System.out.println("1. Print 2. Search 3. Edit 4. Reset 5. Add Row 6. Sort Table 7. Exit ");
	}

	public static int checkNumber(String message,int min, int max){
		Scanner read = new Scanner(System.in);
		int number=0;
		boolean correct=false;
		while(!correct){
			try{
				System.out.print(message);
				number=Integer.parseInt(read.next());
				if(number<min || number>max){
					System.out.print("Input number not in range ");
				}
				else{
					correct=true;
				}
			}
			catch(NumberFormatException e){
				System.out.print("Input not an integer. ");
			}
		}
		return number;
	}

}
