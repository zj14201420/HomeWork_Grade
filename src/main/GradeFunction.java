package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GradeFunction implements GradeInterface{
	
	/**将获取的数据做成特别结构，方便查询操作**/
	@Override
	public ArrayList<HashMap<String,String>> GetGrade2(String filePath) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<HashMap<String,String>> arrayInfo = new ArrayList<>();
		
		File file = new File(filePath);
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader(file));
	        String tempStr;
	        while ((tempStr = reader.readLine()) != null) {
	            arrayList.add(tempStr);
	        }
	        reader.close();
	        //System.out.println(arrayList);
	        for(int i=0;i<arrayList.size();i=i+5) {
	        	HashMap<String,String> gradeMap = new HashMap<>();
	        	gradeMap.put("学号", arrayList.get(i));
	        	gradeMap.put("姓名", arrayList.get(i+1));
	        	gradeMap.put("数学", arrayList.get(i+2));
	        	gradeMap.put("语文", arrayList.get(i+3));
	        	gradeMap.put("英语", arrayList.get(i+4)+"\n");
	        	arrayInfo.add(gradeMap);
	        }
	        //System.out.println(arrayInfo);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
		return arrayInfo;
	}
	
	
/**
 * 
 * 用来最大值平均值等展示成绩的函数
 * 
 * **/
	@Override
	public  ArrayList<String>  GetGrade(String filePath) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		HashMap<String,String> gradeMap = new HashMap<>();
		File file = new File(filePath);
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader(file));
	        String tempStr;
	        while ((tempStr = reader.readLine()) != null) {
	            arrayList.add(tempStr);
	        }
	        reader.close();
	        //return sbf.toString();
	 	  //System.out.println(arrayList);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	    return arrayList;
	}
	/**
	 * 统计每一科最高分
	 * **/
	@Override
	public int MaxGrade(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		Collections.sort(arrayList, new Comparator<Integer>() {

			@Override
			public int compare(Integer grade1, Integer grade2) {
				// TODO Auto-generated method stub
				if(grade1>grade2) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		
		return arrayList.get(arrayList.size()-1);
	}
	/**
	 * 统计每一科平均分
	 * **/
	@Override
	public int AvgGrade(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<arrayList.size();i++) {
			sum+=arrayList.get(i);
		}
		//System.out.println(sum);
		return sum/arrayList.size();
	}
	/**
	 * 根据总成绩排序
	 * **/
	@Override
	public ArrayList<Integer> SortGrade(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		Collections.sort(arrayList, new Comparator<Integer>() {

			@Override
			public int compare(Integer grade1, Integer grade2) {
				// TODO Auto-generated method stub
				if(grade1>grade2) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		return arrayList;
	}
	/*********额外函数****************************************************************/
	/**
	 * 
	 * 根据subject的数字，2:数学，3：语文， 4：英语,将每科成绩做成一张表
	 * 
	 * **/
	public ArrayList<Integer> getGradeInt(int subject, ArrayList<String> arrayList) {
		// TODO Auto-generated method stub
		ArrayList<String> GradeList = new ArrayList<>();
		for(int i=subject;i<arrayList.size();i=i+5) {
			GradeList.add(arrayList.get(i));
		}
		//System.out.println(GradeList);
		ArrayList<Integer> GradeInt = new ArrayList<>();
		for(int i=0;i<GradeList.size();i++) {
			GradeInt.add(Integer.parseInt(GradeList.get(i)));
		}		
		return GradeInt;
	}
	/**
	 * 
	 * 获取所有数据并得到所有成绩
	 * 
	 * **/
	public ArrayList<Integer> getSumGrade(ArrayList<String> arrayList){
		ArrayList<String> GradeList = new ArrayList<>();
		for(int i=0;i<arrayList.size()/5;i++) {
			for(int j=i*5+2;j<i*5+5;j++) {
				GradeList.add(arrayList.get(j));
			}
		}
		System.out.println(GradeList);
		ArrayList<Integer> GradeInt = new ArrayList<>();
		for(int i=0;i<GradeList.size();i++) {
			GradeInt.add(Integer.parseInt(GradeList.get(i)));
		}		
		ArrayList<Integer> GradeSum = new ArrayList<>();
		for(int i=0;i<GradeInt.size();i=i+3) {
			GradeSum.add(GradeInt.get(i)+GradeInt.get(i+1)+GradeInt.get(i+2));
		}
		return GradeSum;
	}
/**
 * 查找操作
 * 参数：name1：表示hash的key值，有"学号"，"姓名"
 * 		 name2：表示要查找的人，可以是这个人的姓名或者学号，如“张三”或“10010”
 *       subject:表示要查找的学科，可以是“数学”，“语文”，“英语”
 *       list：表示操作的这个数据集
 * **/

	@Override
	public ArrayList<String> QueryGrade(String name1, String name2,String subject,ArrayList<HashMap<String, String>> list) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get(name1).equals(name2)) {
				arrayList.add(list.get(i).get(subject));
			}
		}
		return arrayList;
	}
}
