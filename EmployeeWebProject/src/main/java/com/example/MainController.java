package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.EmployeeDTO;
import com.example.service.EmployeeService;

@Controller
public class MainController {
	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String main() {
		return "employee_search";
	}
	
	@RequestMapping("/search.do")
	public void search(String kind, String search, HttpServletResponse response) throws JSONException, IOException {
		List<EmployeeDTO> list = service.searchEmployee(kind, search);
		JSONObject obj = new JSONObject();
		if(list.size() == 0) {
			obj.put("code", 500);
			obj.put("message", "조회된 데디터가 없습니다.");
			obj.put("result", "none");
		}else {
			obj.put("code", 200);
			obj.put("message", "정상적으로 조회되었습니다..");
			obj.put("result", new JSONArray(list));
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(obj.toString());
	}
	
}
