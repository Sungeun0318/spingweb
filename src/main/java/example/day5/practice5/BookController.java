package example.day5.practice5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice5/book")
public class BookController {
    @Autowired
    private BookService bookService;

    // R
    @GetMapping
    public List<BookDto> getBooks() {
        List<BookDto> result = bookService.getBooks();
        return result;
    }
    // C
    @PostMapping
    public boolean addBook(@RequestBody BookDto bookDto) {
        boolean result = bookService.addBook(bookDto);
        return result;
    }

    // D
    @DeleteMapping
    public boolean deleteBook(@RequestParam int bid) {
        boolean result = bookService.deleteBook(bid);
        return result;
    }

    // U
    @PutMapping
    public boolean updateBook(@RequestBody BookDto bookDto) {
        boolean result = bookService.updateBook(bookDto);
        return result;
    }
}
