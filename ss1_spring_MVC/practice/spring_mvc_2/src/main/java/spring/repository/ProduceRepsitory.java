package spring.repository;

import org.springframework.stereotype.Repository;
import spring.model.Produce;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProduceRepsitory implements IproduceRepository{
  private static List<Produce> produceList;
  static {
      produceList = new ArrayList<>();
      produceList.add(new Produce(1,"omo",15.00,new String[]{"Bot giac cua truoc","Bot giac cua tren"}));
      produceList.add(new Produce(2,"Sting",1.00,new String[]{"huong dau","huong sam"}));
      produceList.add(new Produce(3,"pessi",20.00,new String[]{"co duong","khong duong"}));

  }
    @Override
    public List<Produce> findAll() {
        return produceList;
    }
}
