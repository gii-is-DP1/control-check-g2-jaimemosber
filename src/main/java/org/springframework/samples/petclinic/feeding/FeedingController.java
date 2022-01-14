package org.springframework.samples.petclinic.feeding;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
    @Autowired
    private FeedingService feedingService;
    
    private static final String view = "feedings/createOrUpdateFeedingForm";
    
    @GetMapping(path="/create")
    public String initCreationForm(ModelMap modelMap) {
    	String vista = view;
    	modelMap.addAttribute("feeding", new Feeding());
    	modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
    	return vista;
    }
    
    @PostMapping(path="/create")
    public String processCreationForm(@Valid Feeding feeding, BindingResult result, ModelMap modelMap) throws UnfeasibleFeedingException {
    	String vista="welcome";
    	if(result.hasErrors()) {
    		modelMap.addAttribute("feeding", feeding);
    		modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
    		return view;
    	}else {
    		feedingService.save(feeding);
    		modelMap.addAttribute("message", "Feeding succesfully saved!");
    	}
    	return vista;
    }
}
