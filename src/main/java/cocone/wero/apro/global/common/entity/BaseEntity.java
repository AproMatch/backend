package cocone.wero.apro.global.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate    // 엔티티가 생성되는 시간 자동 저장
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate   // 엔티티가 수정되는 시간 자동 저장
    private LocalDateTime modifiedAt;
}