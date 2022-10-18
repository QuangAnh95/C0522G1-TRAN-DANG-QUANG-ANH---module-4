package vn.product.repository.impl;

import org.springframework.stereotype.Repository;
import vn.product.model.Produce;
import vn.product.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    static private Map<Integer,Produce> productlist;
    static {
        productlist = new HashMap<>();
        productlist.put(1,new Produce(1,"chocopie",5000,"no","socola"));
        productlist.put(2,new Produce(2,"omo",6000,"no","bot giac"));
        productlist.put(3,new Produce(3,"comfor",3000,"no","nuoc xa vai"));
        productlist.put(4,new Produce(4,"Wonderfam",5000,"no","nuoc giai khat"));
        productlist.put(5,new Produce(5,"pesi",2000,"no","nuoc giai khat"));
    }


    @Override
    public List<Produce> findAll() {
        return new ArrayList<>(productlist.values());
    }

    @Override
    public void save(Produce produce) {
        productlist.put(produce.getId(),produce);

    }

    @Override
    public void update(Produce produce) {
productlist.put(produce.getId(),produce);
    }

    @Override
    public void delete(int id) {
productlist.remove(id);
    }

    @Override
    public Produce findById(int id) {
        return productlist.get(id);
    }

    @Override
    public List<Produce> findByName(String name) {
        List<Produce> produces = new ArrayList<>();
        for (Produce item : productlist.values()){
            if (item.getName().contains(name)){
                produces.add(item);
            }
        }
        return produces;
    }
}
