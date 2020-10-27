package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import main.GradeFunction;

public class GetGradeTest {
	GradeFunction gradeFunction = new GradeFunction();
	@Test
	public void GetGradeTest() {
		ArrayList<String> report = new ArrayList<>();
		report.add("10010");
		report.add("����");
		report.add("100");
		report.add("90");
		report.add("85");
		String grade="..\\GradeAlter\\src\\test\\test.txt";
		assertEquals(report,gradeFunction.GetGrade(grade));
	}
	@Test
	public void GetGrade2Test() {
		HashMap<String,String> map = new HashMap<>();
		map.put("ѧ��","10010");
		map.put("����","����");
		map.put("��ѧ","100");
		map.put("����","90");
		map.put("Ӣ��","85");
		ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
		arrayList.add(map);
		String grade="..\\GradeAlter\\src\\test\\test.txt";
		assertEquals(arrayList,gradeFunction.GetGrade2(grade));
	}
}
