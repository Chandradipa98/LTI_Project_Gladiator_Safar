package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Payment;
import com.lti.service.PaymentService;

@RestController
@RequestMapping(path = "Pay")
@CrossOrigin
public class PaymentAppController {

	@Autowired
	private PaymentService service3;

	@PostMapping(path = "/")
	public void addPayment(@RequestBody Payment pay) {
		service3.addPayment(pay);
	}

	@GetMapping(path = "/")
	public List<Payment> getAllPayment() {
		List<Payment> pay = service3.findAllPayment();
		return pay;
	}

	@PutMapping(path = "/")
	public Payment updatePaymentByPaymentId(@RequestBody Payment pay) {
		boolean result = service3.modifyPayment(pay);
		if (result)
			pay = service3.findPaymentByPaymentId(pay.getPaymentId());
		return pay;
	}

	@DeleteMapping(path = "{id}")
	public void deletePaymentByPaymentId(@PathVariable("id") int paymentId) {
		service3.removePayment(paymentId);
	}

}
