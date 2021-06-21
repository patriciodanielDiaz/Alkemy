package alkemy.challenger.Alkemy.service;

import alkemy.challenger.Alkemy.model.Book;
import alkemy.challenger.Alkemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(long id) {
        return bookRepository.getById(id);
    }

    public Object findAll() {
        return bookRepository.findAll();
    }

    public Object save(Book book) {
        return bookRepository.save(book);
    }
}
