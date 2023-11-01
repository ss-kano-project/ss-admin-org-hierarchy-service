package co.deepmindz.adminorghierservice.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/oh")
@CrossOrigin
public class DocController {
	@GetMapping("/docs")
	public RedirectView getidentityDocs() {
		return new RedirectView("/swagger-ui/index.html");
	}

}