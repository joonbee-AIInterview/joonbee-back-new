package jb.joonbee.back.model.base;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public class AuditEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2807892287864296182L;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}
