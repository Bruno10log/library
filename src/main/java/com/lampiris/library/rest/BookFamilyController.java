package com.lampiris.library.rest;

import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.entity.BookFamily;
import com.lampiris.library.service.BookFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/book-families")
public class BookFamilyController {

    @Autowired
    private BookFamilyService service;

    @GetMapping
    public ResponseEntity<List<BookFamilyDTO>> getAll() {
        List<BookFamily> list = service.getAll();
        List<BookFamilyDTO> listDTO = list.stream().map(
                bookFamily -> new BookFamilyDTO(bookFamily)).collect(Collectors.toList()
        );
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody BookFamilyDTO dto) {
        BookFamily bookFamily = service.fromDTO(dto);
        bookFamily = service.save(bookFamily);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookFamily.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody BookFamilyDTO dto, @PathVariable Integer id) {
        BookFamily bookFamily = service.fromDTO(dto);
        bookFamily.setId(id);
        service.update(bookFamily);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/report")
    public ResponseEntity<String> report() {
        String fileName = service.generateExcel();
        return ResponseEntity.ok().body(fileName);
    }

}
