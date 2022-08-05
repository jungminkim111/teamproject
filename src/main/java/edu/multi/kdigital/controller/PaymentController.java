package edu.multi.kdigital.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.service.PaymentService;


@Controller
public class PaymentController {
	
	@Inject
	PaymentService pservice;

	@RequestMapping("/payment")
	public String payment(PaymentDto pay, Model model) {
		return "/payment";
	}
	
    @PostMapping("/payform")
    public String paymentinfo(PaymentDto pay, Model model) {
    	pservice.paymentinfo(pay);
        return "/payment";
    }
}