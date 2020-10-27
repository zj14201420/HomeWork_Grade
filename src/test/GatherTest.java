package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.GradeFunction;

public class GatherTest {
	GradeFunction gradeFunction = new GradeFunction();
	@Test
	public void MaxTest() {
		ArrayList<Integer> report = new ArrayList<>();
		report.add(40);
		report.add(10);
		report.add(20);
		assertEquals(40,gradeFunction.MaxGrade(report));
	}
	@Test
	public void AvgTest() {
		ArrayList<Integer> report = new ArrayList<>();
		report.add(40);
		report.add(30);
		report.add(20);		
		assertEquals(30,gradeFunction.AvgGrade(report));
	}
	@Test
	public void SortTest() {
		ArrayList<Integer> report = new ArrayList<>();
		report.add(40);
		report.add(30);
		report.add(20);	
		ArrayList<Integer> report2 = new ArrayList<>();
		report2.add(20);
		report2.add(30);
		report2.add(40);
		assertEquals(report2,gradeFunction.SortGrade(report));
	}
	@Test
	public void GetSumTest() {
		ArrayList<String> report = new ArrayList<>();
		report.add("mark");
		report.add("10010");
		report.add("40");
		report.add("30");
		report.add("20");
		ArrayList<Integer> report2 = new ArrayList<>();
		report2.add(90);
		assertEquals(report2,gradeFunction.getSumGrade(report));
	}
	@Test
	public void GetIntTest() {
		ArrayList<String> report = new ArrayList<>();
		report.add("mark");
		report.add("10010");
		report.add("40");
		report.add("30");
		report.add("20");
		report.add("jack");
		report.add("10020");
		report.add("50");
		report.add("30");
		report.add("20");
		ArrayList<Integer> report2 = new ArrayList<>();
		report2.add(40);
		report2.add(50);
		assertEquals(report2,gradeFunction.getGradeInt(2, report));
	}
}
