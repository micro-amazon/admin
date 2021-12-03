package weaveworksdemos.admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
    @Id
    private String id;

    private String username;
    private String password;
}
