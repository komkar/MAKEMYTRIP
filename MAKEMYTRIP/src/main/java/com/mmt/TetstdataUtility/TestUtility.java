package com.mmt.TetstdataUtility;

import java.util.ArrayList;

import com.mmt.Utility.Xls_Reader;


public class TestUtility {

	static Xls_Reader reader;
	public static ArrayList<Object[]> getDatafromExcel()
	{
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		reader = new Xls_Reader("/home/mkar/git/MAKEMYTRIP/MAKEMYTRIP/src/main/java/com/mmt/excel/randomradiobutton.xlsx");
		
		for( int Row =2 ; Row<=reader.getRowCount("Sheet1"); Row++)
		{
			String DepartureRadio    =  reader.getCellData("Sheet1", "DepartureRadio", Row);
			String Returnradio    =  reader.getCellData("Sheet1", "Returnradio",    Row);
		
			Object ob[] ={DepartureRadio,Returnradio};
			mydata.add(ob);
			System.out.println(mydata);
		}
		return mydata;
		
	}
}
