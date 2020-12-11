package com.chris.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			count++;
			session.setAttribute("count", count);
		}
		return "welcome.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		model.addAttribute("count", session.getAttribute("count"));
		return "counter.jsp";
	}
}
