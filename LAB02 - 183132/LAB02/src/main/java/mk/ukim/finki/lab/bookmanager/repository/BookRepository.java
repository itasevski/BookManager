package mk.ukim.finki.lab.bookmanager.repository;

import mk.ukim.finki.lab.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
