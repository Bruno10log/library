package com.lampiris.library.service;

import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.entity.BookFamily;

import java.util.List;

public interface BookFamilyService {

    List<BookFamily> getAll();
    BookFamily save(BookFamily bookFamily);
    BookFamily fromDTO(BookFamilyDTO dto);
    BookFamily update(BookFamily bookFamily);
    BookFamily find(Integer id);
    String generateExcel();

}
