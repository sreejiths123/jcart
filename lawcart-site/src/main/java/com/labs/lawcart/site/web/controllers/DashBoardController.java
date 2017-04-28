package com.labs.lawcart.site.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.labs.lawcart.customers.CustomerService;
import com.labs.lawcart.entities.Customer;
import com.labs.lawcart.entities.Matter;
import com.labs.lawcart.entities.Order;
import com.labs.lawcart.entities.Product;
import com.labs.lawcart.matter.MatterService;

@Controller
public class DashBoardController extends LawCartSiteBaseController{


	@Autowired private CustomerService customerService;
	@Autowired private MatterService matterService;
	@Autowired protected PasswordEncoder passwordEncoder;
	
	@Override 
	protected String getHeaderTitle()
	{
		return "dashboard/pages/index";
	}

	@RequestMapping(value="/myDashboard", method=RequestMethod.GET)
	protected String myDashboard(Model model)
	{
		String email = getCurrentUser().getCustomer().getEmail();
		Customer customer = customerService.getCustomerByEmail(email);
		model.addAttribute("customer", customer);
		List<Order> orders = customerService.getCustomerOrders(email);
		model.addAttribute("orders", orders);
		return "dashboard/pages/index";
	}
	
	
	@RequestMapping("/matters")
	public String matters( Model model)
	{
		//Category category = catalogService.getCategoryByName(name);
		//model.addAttribute("category", category);
		model.addAttribute("matters",matterService.getAllMatters());
		return "dashboard/pages/matters";
	}
	
	@RequestMapping(value="/matters/new",method=RequestMethod.GET)
	public String newMatterCreationForm(Model model)
	{
		//Category category = catalogService.getCategoryByName(name);
		//model.addAttribute("category", category);
		model.addAttribute("matter", new Matter());
		return "dashboard/pages/matters_new";
	}
	
	@RequestMapping(value="/matters/new",method=RequestMethod.POST)
	public String createMatter(@Valid @ModelAttribute("matter") Matter matter ,BindingResult result, 
			Model model, RedirectAttributes redirectAttributes)
	{
		
		matterService.createMatter(matter);
		
		return "dashboard/pages/matters";
	}
	
	@RequestMapping(value="/matters/{matterId}", method=RequestMethod.GET)
	public String editMatter(@PathVariable(value="matterId")Integer matterId, Model model)
	{
		Matter matter = matterService.getMatterById(matterId);
		model.addAttribute("matter", matter);
		return "dashboard/pages/edit_matter";
	}
	
	@RequestMapping(value="/matters/{id}", method=RequestMethod.POST)
	public String updateMatter(@Valid @ModelAttribute("matter") Matter matter, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		
		Matter persistedMatter = matterService.updateMatter(matter);
		
		logger.debug("Updated matter with id : {} and description : {}", persistedMatter.getId(), persistedMatter.getDescription());
		redirectAttributes.addFlashAttribute("info", "Matter updated successfully");
		return "dashboard/pages/matters";
	}
}
