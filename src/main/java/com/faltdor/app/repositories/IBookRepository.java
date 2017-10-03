package com.faltdor.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.faltdor.app.model.Book;

public interface IBookRepository extends CrudRepository<Book, Long> {

}
