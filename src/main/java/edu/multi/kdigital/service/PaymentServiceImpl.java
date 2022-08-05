package edu.multi.kdigital.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.dao.PaymentMapper;
import edu.multi.kdigital.repository.MemberRepository;

@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {
	@Inject
	PaymentMapper pservice;
	
	public MemberRepository memberRepository;
	
	@Override
	public int paymentinfo(PaymentDto pay) {
		return pservice.paymentinfo(pay);
	}
	

}
