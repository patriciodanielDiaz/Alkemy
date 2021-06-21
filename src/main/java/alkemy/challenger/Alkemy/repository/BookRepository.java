package alkemy.challenger.Alkemy.repository;

import alkemy.challenger.Alkemy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
