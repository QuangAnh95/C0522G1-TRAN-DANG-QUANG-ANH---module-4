package vn.mailbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mailbox.model.MailBox;
import vn.mailbox.repository.IMailBoxRepository;
import vn.mailbox.service.IMailBoxService;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private IMailBoxRepository mailBoxRepository;

    @Override
    public List<MailBox> findAll() {
        return mailBoxRepository.findAll();
    }

    @Override
    public Void upDate(MailBox mailBox) {
        return mailBoxRepository.upDate(mailBox);
    }

    @Override
    public List<String> findLanguages() {
        return mailBoxRepository.findLanguages();
    }

    @Override
    public List<Integer> findPageSize() {
        return mailBoxRepository.findPageSize();
    }

    @Override
    public MailBox findId(int id) {
        return mailBoxRepository.findId(id);
    }
}
