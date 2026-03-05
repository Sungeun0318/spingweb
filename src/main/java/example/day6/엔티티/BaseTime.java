package example.day6.엔티티;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 1] 엔티티 상속 용도 클래스
@Getter // 2] 상속받은 엔티티가 멤버변수 사용
@Setter
@EntityListeners(AuditingEntityListener.class) // 4] 해당 엔티티 자동 감사 적용
public class BaseTime {
    @CreatedDate // 3] 엔티티 생성날짜/시간 주입
    private LocalDateTime createDate;
    @LastModifiedBy // 4] 엔티티 수정날짜/시간 주입
    private LocalDateTime updateDate;

}
