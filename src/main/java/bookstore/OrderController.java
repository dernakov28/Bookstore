package bookstore;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class OrderController {

    @Autowired
    OrderRepository repository;

    @RequestMapping(value = "/api/createOrder", method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody Order reqOrder) {
        Order order = new Order(reqOrder);

        List<CartItem> cartItems = order.getCartItems();
        int sum = 0;
        for (CartItem item : cartItems) {
            item.setOrder(order);
            sum += item.getAmount() * item.getBook().getPrice();
        }

        order.setSum(sum);
        order.setDatetime(new Date().toString());

        order = repository.save(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/processOrder", method = RequestMethod.POST)
    public ResponseEntity<Order> process(@RequestBody Order reqOrder) {
        Order order = repository.findOne(reqOrder.getId());
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        order.setProcessed(true);
        repository.save(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/readOrder", method = RequestMethod.POST)
    public ResponseEntity<Order> read(@RequestBody Order reqOrder) {
        Order order = repository.findOne(reqOrder.getId());
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping("/api/readOrders")
    public ResponseEntity<ArrayList<Order>> readOrders() {
        ArrayList<Order> orders = (ArrayList<Order>) repository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}