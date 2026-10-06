package Day_8.service;

import Day_8.dto.BookRequest;
import Day_8.dto.BookResponse;
import Day_8.entity.Book;
import Day_8.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // Constructor Injection
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse createBook(BookRequest request) {

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());
        book.setPublishedYear(request.getPublishedYear());

        Book savedBook = bookRepository.save(book);

        return convertToResponse(savedBook);
    }

    @Override
    public List<BookResponse> getAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public BookResponse getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found with id: " + id));

        return convertToResponse(book);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found with id: " + id));

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());
        book.setPublishedYear(request.getPublishedYear());

        Book updatedBook = bookRepository.save(book);

        return convertToResponse(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new RuntimeException(
                    "Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }

    // Entity → Response DTO
    private BookResponse convertToResponse(Book book) {

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                book.getPublishedYear()
        );
    }
}