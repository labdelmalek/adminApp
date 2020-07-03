package org.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ereurpageController {

	@RequestMapping(value = "/{[path:[^.]*}")
      public ModelAndView redirect() {

          return new ModelAndView("redirect:/test/agences" );
              } 

    @RequestMapping(value = "")
      public ModelAndView redd() {
         
          return new ModelAndView("redirect:/test/agences" );
              } 

}
