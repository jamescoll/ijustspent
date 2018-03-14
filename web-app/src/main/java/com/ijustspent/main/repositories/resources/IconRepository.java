package com.ijustspent.main.repositories.resources;


import com.ijustspent.main.models.resources.Icon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends MongoRepository<Icon, String> {
    List<Icon> findByIconCategory(String iconCategory);
}
