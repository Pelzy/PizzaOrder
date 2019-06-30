package firstproject.demo.controller;

import firstproject.demo.exception.CreditCardException;
import firstproject.demo.service.CreditCardService;
import firstproject.demo.transport.CreditCardTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public List<CreditCardTransport> getAll(){
        return creditCardService.getAll();
    }

    @GetMapping("/{id}")
    public CreditCardTransport get(@PathVariable String id) throws CreditCardException {
        return creditCardService.get(id);
    }

    @PostMapping
    public CreditCardTransport save(@RequestBody CreditCardTransport creditCardTransport) throws CreditCardException {
        return creditCardService.save(creditCardTransport);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) throws CreditCardException{
        creditCardService.delete(id);
    }

}
