package ecommerce_api.Controller;

import ecommerce_api.Model.Item;
import ecommerce_api.Services.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @Autowired
    private Serv serv;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody Item item){

        if (item.getName() == null || item.getName().isEmpty()){
            return ResponseEntity.badRequest().body("Name Must Required");
        }
        if (item.getPrice() == null || item.getPrice()<=0){
            return ResponseEntity.badRequest().body("Price must be greater than 0");
        }
        return ResponseEntity.ok(serv.Additem(item));
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<?>GetByID(@PathVariable Long id){
        Item id1 = serv.getId(id);
        if (id1 == null){
            return ResponseEntity.status(404).body("Item not found");
        }
        return ResponseEntity.ok(id1);
    }

}
