package firstproject.demo.service;

import firstproject.demo.entity.CreditCard;
import firstproject.demo.entity.Payment;
import firstproject.demo.entity.Pizza;
import firstproject.demo.entity.User;
import firstproject.demo.exception.PizzaException;
import firstproject.demo.repository.PaymentRepository;
import firstproject.demo.transport.CreditCardTransport;
import firstproject.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    UserService userService;

    public Payment getPaymentStatus(String payWith, CreditCard card, long id) throws Exception {
        if (pizzaService.getPizza() == null) {
            throw new Exception("No pizza found");
        }
        Payment payment=new Payment();
        CreditCard creditCard=new CreditCard();
        User user=new User();
        for(Pizza p:pizzaService.getPizza()){
            if(p.getId()==id){
                for(CreditCardTransport creditCardTransport:creditCardService.getAll()){
                    if(creditCardTransport.getNrCc()==card.getNrCc() && card.getBalance() >= p.getPrice()) {
                        if(p.getPrice()>card.getBalance()) {
                            throw new PizzaException("You do not have credit to order pizza");
                        }
                        card.setBalance(card.getBalance()-p.getPrice());
                        for(UserTransport userTransport:userService.getAll()){
                            if (userTransport.getCreditCard().equals(card)) {
                                user.setFullName(userTransport.getFullName());
                                user.setUsername(userTransport.getUsername());
                                user.setPassword(userTransport.getPassword());
                                user.setPayment(userTransport.getPayment());
                                userTransport.getCreditCard().add(creditCard);
                                user.setCreditCard(userTransport.getCreditCard());
                                creditCard.setNrCc(creditCardTransport.getNrCc());
                                creditCard.setId(creditCardTransport.getId());
                                creditCard.setCcv(creditCardTransport.getCcv());
                                creditCard.setExpDd(creditCardTransport.getExpDd());
                                creditCard.setBalance(creditCardTransport.getBalance());
                                creditCard.setPayment(creditCardTransport.getPayment());
                                creditCard.setUser(user);
                                payment.setId(payment.getId());
                                payment.setStatus(true);
                                payment.getPizza().add(p);
                                p.setPayment(payment);
                                payment.setCreditCard(creditCard);
                                payment.setUser(user);
                                return paymentRepository.save(payment);
                            }
                        }
                    }
                }
            }
        }
        return paymentRepository.save(payment);
    }
}
