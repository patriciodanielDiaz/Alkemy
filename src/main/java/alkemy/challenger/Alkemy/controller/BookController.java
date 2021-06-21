package alkemy.challenger.Alkemy.controller;

import alkemy.challenger.Alkemy.model.Book;
import alkemy.challenger.Alkemy.repository.BookRepository;
import alkemy.challenger.Alkemy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/colletctorPrice/book/{id}")
    public ResponseEntity<?> getCollectorPrice (@PathVariable long id){

        Book book = bookService.findById(id);

        //or by and to enter the condition
        if(book.getEdition()<3 || book.getEdition() > 5 ){
            book.setPrice(book.getPrice()+ book.getPrice()/2);
        }
        return new ResponseEntity<>(book.getPrice(), HttpStatus.OK);
    }

}