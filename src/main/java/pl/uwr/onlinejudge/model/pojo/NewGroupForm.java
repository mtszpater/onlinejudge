package pl.uwr.onlinejudge.model.pojo;

import org.hibernate.validator.constraints.Length;
import pl.uwr.onlinejudge.model.entity.Account;

public class NewGroupForm {
    private Account account;
    @Length(min = 3, message = "Nazwa grupy powinna mieć conajmniej 3 znaki")
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
