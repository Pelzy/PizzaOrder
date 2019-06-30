package firstproject.demo.mapper;


import firstproject.demo.entity.CreditCard;
import firstproject.demo.transport.CreditCardTransport;

public class CreditCardMapper {

    public static CreditCardTransport toTransport(CreditCard creditCard){
        if(creditCard == null){
            return null;
        }

        CreditCardTransport creditCardTransport=new CreditCardTransport();
        creditCardTransport.setId(creditCard.getId());
        creditCardTransport.setNrCc(creditCard.getNrCc());
        creditCardTransport.setCcv(creditCard.getCcv());
        creditCardTransport.setExpDd(creditCard.getExpDd());
        creditCardTransport.setBalance(creditCard.getBalance());
        creditCardTransport.setPayment(creditCard.getPayment());
        creditCardTransport.setUser(creditCard.getUser());

        return  creditCardTransport;
    }

    public static CreditCard toEntity(CreditCardTransport creditCardTransport) {
        if (creditCardTransport == null) {
            return null;
        }
        CreditCard creditCard = new CreditCard();
        creditCard.setId(creditCardTransport.getId());
        creditCard.setNrCc(creditCardTransport.getNrCc());
        creditCard.setExpDd(creditCardTransport.getExpDd());
        creditCard.setCcv(creditCardTransport.getCcv());
        creditCard.setBalance(creditCardTransport.getBalance());
        creditCard.setPayment(creditCardTransport.getPayment());
        creditCard.setUser(creditCardTransport.getUser());

        return creditCard;
    }
}
