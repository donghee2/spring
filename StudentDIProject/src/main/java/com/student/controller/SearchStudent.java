package com.student.controller;

import java.util.Scanner;

import com.student.exception.StudentException;
import com.student.service.StudentService;
import com.student.vo.StudentVO;

public class SearchStudent implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.print("검색할 학생의 학번 입력 : ");
		String sno = sc.nextLine();
		
		try {
			StudentVO vo = StudentService.getInstance().selectStudent(sno);
			System.out.println(vo.toString());
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
