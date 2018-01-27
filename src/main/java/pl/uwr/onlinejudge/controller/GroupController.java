package pl.uwr.onlinejudge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.uwr.onlinejudge.model.entity.Group;
import pl.uwr.onlinejudge.model.pojo.NewGroupForm;
import pl.uwr.onlinejudge.service.GroupService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/grupy")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        return new ResponseEntity<>(groupService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Group> saveGroup(@RequestBody @Valid NewGroupForm newGroupForm, Principal principal) {
        Group savedGroup = groupService.save(newGroupForm, principal);

        if (savedGroup != null)
            return new ResponseEntity<>(savedGroup, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
