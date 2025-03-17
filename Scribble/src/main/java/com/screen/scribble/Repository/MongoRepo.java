package com.screen.scribble.Repository;

import com.screen.scribble.model.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<LogModel, String> {
}
