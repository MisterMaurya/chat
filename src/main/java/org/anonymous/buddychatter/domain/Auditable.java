package org.anonymous.buddychatter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
class Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private java.util.Date createdDate;

    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private java.util.Date lastModifiedDate;

    @Version
    private Long version;

}
