package firstproject.demo.service;

import firstproject.demo.entity.CreditCard;
import firstproject.demo.exception.CreditCardException;
import firstproject.demo.mapper.CreditCardMapper;
import firstproject.demo.repository.CreditCardRepository;
import firstproject.demo.transport.CreditCardTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCardTransport> getAll(){
        return creditCardRepository.findAll().stream().map(CreditCardMapper::toTransport).collect(Collectors.toList());
    }

    public CreditCardTransport get(String id) throws CreditCardException {
        if(id == null||id.trim().isEmpty()){
            throw new CreditCardException("Id null");
        }
        final Optional<CreditCard> byId=creditCardRepository.findById(id);
        return CreditCardMapper.toTransport(byId.orElseThrow(() -> new CreditCardException("None CreditCard found")));
    }

    public CreditCardTransport save(CreditCardTransport creditCardTransport) throws CreditCardException {
        if (creditCardTransport == null) {
            throw new CreditCardException("CreditCard null");
        }
        return CreditCardMapper.toTransport(creditCardRepository.save(CreditCardMapper.toEntity(creditCardTransport)));
    }

    public void delete(String id) throws CreditCardException {
        if(id == null||id.trim().isEmpty()){
            throw new CreditCardException("Id null");
        }
        creditCardRepository.deleteById(id);
    }

}
