package com.faltdor.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.faltdor.app.model.Publisher;

public interface IPublisherRepository  extends CrudRepository<Publisher, Long>{

}
