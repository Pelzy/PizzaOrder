package firstproject.demo.controller;

import firstproject.demo.entity.CreditCard;
import firstproject.demo.entity.Payment;
import firstproject.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{payWith}/{id}")
    public Payment getPaymentStatus(String payWith, @RequestBody CreditCard card, @PathVariable long id) throws Exception {
        return paymentService.getPaymentStatus(payWith,card,id);
    }
}
