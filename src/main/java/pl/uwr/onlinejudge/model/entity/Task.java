package pl.uwr.onlinejudge.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.uwr.onlinejudge.util.Language;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private TaskList taskList;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Lob
    private String description;

    @Lob
    private String comment;

    @ElementCollection(targetClass = Language.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "task_languages")
    private Collection<Language> languages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<Language> languages) {
        this.languages = languages;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}