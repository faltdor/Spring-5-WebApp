package com.faltdor.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.faltdor.app.model.Author;

public interface IAuthorRepository extends CrudRepository<Author, Long> {

}
