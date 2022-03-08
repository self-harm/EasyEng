package io.harmed.easyeng.repository;

import io.harmed.easyeng.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
