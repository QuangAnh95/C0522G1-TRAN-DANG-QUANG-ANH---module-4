package vn.mailbox.service;

import vn.mailbox.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> findAll();
    Void upDate(MailBox mailBox);
    List<String> findLanguages();
    List<Integer> findPageSize();
    MailBox findId(int id);
}
