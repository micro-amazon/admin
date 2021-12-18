package weaveworksdemos.admin.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Builder
@Getter
public class Admin {
    @Id
    private String id;

    private String username;
    private String password;
}
