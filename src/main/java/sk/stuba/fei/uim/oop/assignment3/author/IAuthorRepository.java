package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    //List<Author> findAll(); // toto tu mam iba preto aby som vedel ktore funkcie z Jpa pouzivam

    Author findAuthorById(Long id);

}
