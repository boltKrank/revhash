package com.revhash.revhash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class RevhashController {

	@GetMapping("/")
	public String revHashForm(Model model) {
		model.addAttribute("revhash", new Revhash());
		return "revhash_input";
	}

	@PostMapping("/")
	public String greetingSubmit(@ModelAttribute Revhash revhash, Model model) {
	  if(revhash.isEncrypt()){
		revhash.revHashEncrypt();
	  }
	  else if(revhash.isDecrypt()){
		revhash.revHashDecrypt();
	  }
	  model.addAttribute("revhash", revhash);
	  return "revhash_output";
	}

	
}
