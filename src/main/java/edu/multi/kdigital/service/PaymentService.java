package edu.multi.kdigital.service;

import javax.servlet.http.HttpSession;

import edu.multi.kdigital.dto.PaymentDto;

public interface PaymentService {
	// 회원가입
	public int paymentinfo(PaymentDto pay);
	

}
