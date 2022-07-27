package com.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.student.exception.StudentException;
import com.student.service.StudentService;
import com.student.vo.StudentVO;

public class SelectTopStudentController implements Controller {

	@Override
	public void execute(Scanner sc) {
		try {
			ArrayList<StudentVO> list = StudentService.getInstance().selectRankOne();
			
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}

}
