package vn.mailbox.repository;

import vn.mailbox.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    List<MailBox> findAll();
    Void upDate(MailBox mailBox);
    List<String> findLanguages();
    List<Integer> findPageSize();
    MailBox findId(int id);
}
