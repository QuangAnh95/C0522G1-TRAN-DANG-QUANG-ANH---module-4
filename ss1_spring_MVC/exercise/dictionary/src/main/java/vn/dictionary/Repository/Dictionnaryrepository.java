package vn.dictionary.Repository;

import org.springframework.stereotype.Repository;
import vn.dictionary.model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class Dictionnaryrepository implements IDictionnaryRepository{
    static Map<Integer,Dictionary> dictionaryMap = new HashMap<>();
    static {
        dictionaryMap.put(1,new Dictionary("Trái táo","apple"));
        dictionaryMap.put(2,new Dictionary("cây viết ","Pen"));
        dictionaryMap.put(3,new Dictionary("ngôi nhà","house"));
        dictionaryMap.put(4,new Dictionary("điện thoại","mobile phone"));
        dictionaryMap.put(5,new Dictionary("quyển vở","book"));
        dictionaryMap.put(6,new Dictionary("máy tính","computer"));
    }


    @Override
    public List<Dictionary> findAll() {
        return new ArrayList<>(dictionaryMap.values());
    }
}
