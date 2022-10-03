package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.EmployeeDataRepository;

@Controller
public class TestController {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	 @Autowired
    EmployeeDataRepository repository;
    
	 @RequestMapping(value="/", method = RequestMethod.GET)
	 public ModelAndView index(@ModelAttribute("formModel")EmployeeData woker, ModelAndView mav) {
		 mav.setViewName("index");
		 List<EmployeeData> list = repository.findAll();
		 mav.addObject("testlist", list);
		 return mav;
		 
	 }
	 
	 @RequestMapping(value="/", method=RequestMethod.POST)
	 @Transactional(readOnly=false)
	 public ModelAndView form(@ModelAttribute("formModel")EmployeeData worker, ModelAndView mav) {
		 repository.saveAndFlush(worker);
		 return new ModelAndView("redirect:/");
		 
	 }
	 
}


/*@RequestMapping()
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/")
    public String index(Model model) {
        String sql = "SELECT * FROM worker";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("testList", list);
        return "index";
    }
}*/