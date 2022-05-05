package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {
    //AuthorResponse findById(Long id);

    //List<Author> findAll();

    Author findAuthorById(Long id);
}
