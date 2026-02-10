package ecommerce_api.Services;

import ecommerce_api.Model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class Serv {

    List<Item> ietms=new ArrayList<>();
    private final AtomicLong idGen=new AtomicLong(0);


    public Item Additem(Item item){
        item.setId(idGen.incrementAndGet());
        ietms.add(item);
        return item;
    }

    public Item getId(Long id){
        return ietms.stream()
                .filter(x->x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
