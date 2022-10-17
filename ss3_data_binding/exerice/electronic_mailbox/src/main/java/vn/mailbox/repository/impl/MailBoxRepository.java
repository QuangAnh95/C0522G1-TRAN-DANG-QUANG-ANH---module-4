package vn.mailbox.repository.impl;

import org.springframework.stereotype.Repository;
import vn.mailbox.model.MailBox;
import vn.mailbox.repository.IMailBoxRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailBoxRepository implements IMailBoxRepository {
   private static List<MailBox> mailBoxList;
   static {
       mailBoxList = new ArrayList<>();
       mailBoxList.add(new MailBox(1,"EngLish",10,true,"no"));
       mailBoxList.add(new MailBox(2,"Vietnamese",15,false,"no"));
       mailBoxList.add(new MailBox(3," Japanese",25,true,"no"));
       mailBoxList.add(new MailBox(4," Chinese",50,false,"no"));
       mailBoxList.add(new MailBox(5,"Vietnamese",100,true,"no"));
   }

    @Override
    public List<MailBox> findAll() {
        return mailBoxList;
    }

    @Override
    public Void upDate(MailBox mailBox) {
       for (MailBox item : mailBoxList){
           if (mailBox.getId() == item.getId()){
               item.setLanguages(mailBox.getLanguages());
               item.setPageSize(mailBox.getPageSize());
               item.setSpamsFilter(mailBox.isSpamsFilter());
               item.setSignature(mailBox.getSignature());

           }
       }
        return null;
    }

    @Override
    public List<String> findLanguages() {
       List<String> languagesList = new ArrayList<>();
       languagesList.add(" English");
       languagesList.add("Vietnamese");
       languagesList.add(" Japanese");
       languagesList.add("Chinese");
        return languagesList;
    }

    @Override
    public List<Integer> findPageSize() {
       List<Integer> pageSizeList = new ArrayList<>();
       pageSizeList.add(5);
       pageSizeList.add(10);
       pageSizeList.add(15);
       pageSizeList.add(25);
       pageSizeList.add(50);
       pageSizeList.add(100);
        return pageSizeList;
    }

    @Override
    public MailBox findId(int id) {
       for (MailBox item : mailBoxList){
           if (item.getId()==id){
               return item;
           }
       }
        return null;
    }
}
