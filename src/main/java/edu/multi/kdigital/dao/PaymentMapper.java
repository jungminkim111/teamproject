package edu.multi.kdigital.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.multi.kdigital.dto.PaymentDto;

@Mapper
@Repository("payment")
public interface PaymentMapper {


	public int paymentinfo(PaymentDto pay);

	
}