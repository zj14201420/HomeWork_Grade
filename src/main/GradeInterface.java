package main;

import java.util.ArrayList;
import java.util.HashMap;

public interface GradeInterface {
	public ArrayList<HashMap<String,String>> GetGrade2(String filePath);
	public ArrayList<String> GetGrade(String filePath);
	public int MaxGrade(ArrayList<Integer> arrayList);
	public int AvgGrade(ArrayList<Integer> arrayList);
	public ArrayList<Integer> SortGrade(ArrayList<Integer> arrayList);
	public ArrayList<String> QueryGrade(String name1,String name2,String subject,ArrayList<HashMap<String,String>> list);
}
