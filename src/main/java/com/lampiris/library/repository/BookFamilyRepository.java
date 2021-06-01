package com.lampiris.library.repository;

import com.lampiris.library.entity.BookFamily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookFamilyRepository extends JpaRepository<BookFamily, Integer> {

    BookFamily findByName(String name);

}
