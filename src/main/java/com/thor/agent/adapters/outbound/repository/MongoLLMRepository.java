package com.thor.agent.adapters.outbound.repository;

import com.thor.agent.domain.document.LLMDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoLLMRepository extends MongoRepository<LLMDocument, ObjectId> {

}
