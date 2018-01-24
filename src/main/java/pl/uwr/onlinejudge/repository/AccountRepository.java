package pl.uwr.onlinejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uwr.onlinejudge.entities.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);
}

