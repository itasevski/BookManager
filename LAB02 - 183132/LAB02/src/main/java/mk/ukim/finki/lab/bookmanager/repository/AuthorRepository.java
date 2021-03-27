package mk.ukim.finki.lab.bookmanager.repository;

import mk.ukim.finki.lab.bookmanager.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
