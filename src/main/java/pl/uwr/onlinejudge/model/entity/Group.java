package pl.uwr.onlinejudge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<Registration> registrations = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonIgnore
    List<TaskList> taskLists = new LinkedList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }
}