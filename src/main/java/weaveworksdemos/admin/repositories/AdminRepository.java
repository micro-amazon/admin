package weaveworksdemos.admin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import weaveworksdemos.admin.entities.Admin;

@RepositoryRestResource
public interface AdminRepository extends MongoRepository<Admin, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);
}
