package mk.ukim.finki.lab.bookmanager.repository;

import mk.ukim.finki.lab.bookmanager.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
