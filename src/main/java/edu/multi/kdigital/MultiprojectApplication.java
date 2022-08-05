package edu.multi.kdigital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.multi.kdigital.controller.LoginController;
import edu.multi.kdigital.controller.MainController;
import edu.multi.kdigital.dao.PaymentMapper;
import hotel.HotelDAO;
import market.MarketController;
import market.MarketDAO;
import market.MarketadminController;
import hotel.HotelController;
import upload.UploadController;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = MainController.class)
@ComponentScan(basePackageClasses = LoginController.class)
@ComponentScan(basePackageClasses = HotelController.class)
@ComponentScan(basePackageClasses = MarketadminController.class)
@ComponentScan(basePackageClasses = UploadController.class)
@MapperScan(basePackageClasses = HotelDAO.class)
@MapperScan(basePackageClasses = PaymentMapper.class)
@MapperScan(basePackageClasses = MarketDAO.class)
public class MultiprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiprojectApplication.class, args);
	}

}
