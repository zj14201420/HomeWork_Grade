package main;

public class GradeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String grade="..\\GradeAlter\\src\\main\\grade2.txt";
		GradeFunction gradeFunction = new GradeFunction();
		gradeFunction.GetGrade2(grade);
		System.out.println(gradeFunction.GetGrade(grade));
		/**
		 * subject:2:��ѧ��3�����ģ� 4��Ӣ��
		 * 
		 **/
		System.out.println("��ѧ�ɼ����ֵ��"+gradeFunction.MaxGrade(gradeFunction.getGradeInt(2, gradeFunction.GetGrade(grade))));
		System.out.println("��ѧ�ɼ�ƽ��ֵ��"+gradeFunction.AvgGrade(gradeFunction.getGradeInt(2, gradeFunction.GetGrade(grade))));
		System.out.println("���ܳɼ�����"+gradeFunction.SortGrade(gradeFunction.getSumGrade(gradeFunction.GetGrade(grade))));
		for(int i=0;i<gradeFunction.GetGrade2(grade).size();i++) {
			if(gradeFunction.GetGrade2(grade).get(i).get("����").equals("����")) {
				System.out.println("��ѧ�ɼ���"+gradeFunction.GetGrade2(grade).get(i).get("��ѧ"));
				System.out.println("���ĳɼ���"+gradeFunction.GetGrade2(grade).get(i).get("����"));
				System.out.println("Ӣ��ɼ���"+gradeFunction.GetGrade2(grade).get(i).get("Ӣ��"));
			}
		}
		System.out.println("�������ѧ�ɼ��ǣ�"+gradeFunction.QueryGrade("����","����","��ѧ", gradeFunction.GetGrade2(grade)).get(0));
	}

}
