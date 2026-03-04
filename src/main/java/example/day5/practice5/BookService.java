package example.day5.practice5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // R
    public List<BookDto> getBooks() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        bookEntityList.forEach(bookEntity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBid(bookEntity.getBid());
            bookDto.setBname(bookEntity.getBname());
            bookDto.setBauthor(bookEntity.getBauthor());
            bookDto.setBpublisher(bookEntity.getBpublisher());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;

    }

    // C
    public boolean addBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBname(bookDto.getBname());
        bookEntity.setBauthor(bookDto.getBauthor());
        bookEntity.setBpublisher(bookDto.getBpublisher());
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        if(savedBookEntity.getBid() >= 1) {
            return true;
        }
        return false;
    }

    // D
    public boolean deleteBook(int bId) {
        bookRepository.deleteById(bId);
        return true;
    }

    // U
    @Transactional
    public boolean updateBook(BookDto bookDto) {
        Optional<BookEntity> optional = bookRepository.findById(bookDto.getBid());
        if (optional.isPresent()) {
            BookEntity bookEntity = optional.get();
            bookEntity.setBname(bookDto.getBname());
            bookEntity.setBauthor(bookDto.getBauthor());
            bookEntity.setBpublisher(bookDto.getBpublisher());
            return true;
        }
        return false;
    }
}
