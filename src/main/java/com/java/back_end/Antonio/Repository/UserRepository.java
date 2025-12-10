package com.java.back_end.Antonio.Repository;

import com.java.back_end.Antonio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User , Long> {

    Optional <User> findByCpf(String cpf);
    Optional<List<User>> queryByNameLike(String name);
}
