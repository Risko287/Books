package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAll();

    Author findAuthorById(Long id); //tomuto vobec nerozumiem
    // ze ako to vie najst toho autora ked som si to sa vytvoril a nie zdedil

    Author deleteAuthorById(Long id); //povodne som chcel pouzit toto ale neviem ako to funguje
    // tak som spravil cez findAuthorById, ale ak je toto lepsie tak to mozem prerobit
}
