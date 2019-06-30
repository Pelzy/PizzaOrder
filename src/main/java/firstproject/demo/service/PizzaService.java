package firstproject.demo.service;

import firstproject.demo.entity.Pizza;
import firstproject.demo.exception.PizzaException;
import firstproject.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getPizza() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepository.findAll().forEach(pizzas::add);
        return pizzas;
    }

    @PostMapping("/create")
    public Pizza createPizza(Pizza pizza) throws PizzaException {
        if (pizza.getSize() != 30 && pizza.getSize() != 40 && pizza.getSize() != 60) {
            throw new PizzaException("Size should be 30,40 or 60 cm");
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza addPizza(Pizza pizza) throws PizzaException {
        if (pizza.getSize() != 30 && pizza.getSize() != 40 && pizza.getSize() != 60) {
            throw new PizzaException("Size should be 30,40 or 60 cm");
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza getPrice(String type,double size) throws PizzaException {
        final Pizza pizza = pizzaRepository.findAllByTypeAndSize(type, size);
        if(pizza == null) {
            throw new PizzaException("No pizza found");
        }
        return pizza;
    }
}
