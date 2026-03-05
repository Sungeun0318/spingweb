package example.day6.practice6;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter

@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedBy
    private LocalDateTime updateDate;

}