package com.lampiris.library.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_family")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bookFamily", fetch = FetchType.EAGER)
    private List<Book> books;

}
