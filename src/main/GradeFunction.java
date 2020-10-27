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
	
	/**����ȡ�����������ر�ṹ�������ѯ����**/
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
	        	gradeMap.put("ѧ��", arrayList.get(i));
	        	gradeMap.put("����", arrayList.get(i+1));
	        	gradeMap.put("��ѧ", arrayList.get(i+2));
	        	gradeMap.put("����", arrayList.get(i+3));
	        	gradeMap.put("Ӣ��", arrayList.get(i+4)+"\n");
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
 * �������ֵƽ��ֵ��չʾ�ɼ��ĺ���
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
	 * ͳ��ÿһ����߷�
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
	 * ͳ��ÿһ��ƽ����
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
	 * �����ܳɼ�����
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
	/*********���⺯��****************************************************************/
	/**
	 * 
	 * ����subject�����֣�2:��ѧ��3�����ģ� 4��Ӣ��,��ÿ�Ƴɼ�����һ�ű�
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
	 * ��ȡ�������ݲ��õ����гɼ�
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
 * ���Ҳ���
 * ������name1����ʾhash��keyֵ����"ѧ��"��"����"
 * 		 name2����ʾҪ���ҵ��ˣ�����������˵���������ѧ�ţ��硰��������10010��
 *       subject:��ʾҪ���ҵ�ѧ�ƣ������ǡ���ѧ���������ġ�����Ӣ�
 *       list����ʾ������������ݼ�
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
