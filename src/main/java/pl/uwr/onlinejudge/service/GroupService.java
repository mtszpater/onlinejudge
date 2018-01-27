package pl.uwr.onlinejudge.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uwr.onlinejudge.model.entity.Group;
import pl.uwr.onlinejudge.model.pojo.NewGroupForm;
import pl.uwr.onlinejudge.repository.AccountRepository;
import pl.uwr.onlinejudge.repository.GroupRepository;

import java.security.Principal;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private ObjectMapper objectMapper;
    private AccountRepository accountRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, ObjectMapper objectMapper, AccountRepository accountRepository) {
        this.groupRepository = groupRepository;
        this.objectMapper = objectMapper;
        this.accountRepository = accountRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group save(NewGroupForm newGroupForm, Principal principal) {
        newGroupForm.setAccount(accountRepository.findByUsername(principal.getName()).get());

        return groupRepository.save(objectMapper.convertValue(newGroupForm, Group.class));

    }

    public Group findOne(long groupId) {
        return groupRepository.findOne(groupId);
    }
}
