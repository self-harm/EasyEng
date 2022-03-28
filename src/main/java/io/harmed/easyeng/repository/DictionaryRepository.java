package io.harmed.easyeng.repository;

import io.harmed.easyeng.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

    @Query("select d from Dictionary d join d.user u where u.login = :login")
    List<Dictionary> findByUserLogin(final String login);

    @Modifying
    @Query("update Dictionary d set d.isDeleted = true where d.name = :name")
    void deleteByName(final String name);
}
