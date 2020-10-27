package main;

public class GradeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String grade="..\\GradeAlter\\src\\main\\grade2.txt";
		GradeFunction gradeFunction = new GradeFunction();
		gradeFunction.GetGrade2(grade);
		System.out.println(gradeFunction.GetGrade(grade));
		/**
		 * subject:2:数学，3：语文， 4：英语
		 * 
		 **/
		System.out.println("数学成绩最大值："+gradeFunction.MaxGrade(gradeFunction.getGradeInt(2, gradeFunction.GetGrade(grade))));
		System.out.println("数学成绩平均值："+gradeFunction.AvgGrade(gradeFunction.getGradeInt(2, gradeFunction.GetGrade(grade))));
		System.out.println("按总成绩排序"+gradeFunction.SortGrade(gradeFunction.getSumGrade(gradeFunction.GetGrade(grade))));
		for(int i=0;i<gradeFunction.GetGrade2(grade).size();i++) {
			if(gradeFunction.GetGrade2(grade).get(i).get("姓名").equals("王五")) {
				System.out.println("数学成绩："+gradeFunction.GetGrade2(grade).get(i).get("数学"));
				System.out.println("语文成绩："+gradeFunction.GetGrade2(grade).get(i).get("语文"));
				System.out.println("英语成绩："+gradeFunction.GetGrade2(grade).get(i).get("英语"));
			}
		}
		System.out.println("王五的数学成绩是："+gradeFunction.QueryGrade("姓名","王五","数学", gradeFunction.GetGrade2(grade)).get(0));
	}

}
