package com.lampiris.library.service;

import com.lampiris.library.dto.BookDTO;
import com.lampiris.library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book save(Book bookFamily);
    Book fromDTO(BookDTO dto);
    Book update(Book bookFamily);
    String generateExcel();

}
