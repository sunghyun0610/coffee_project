package com.grepp.coffee_project.global;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass// 직접적으로 테이블로 매핑되지 않으며, 이 클래스를 상속받는 엔티티들은 이 클래스에 정의된 필드와 매핑 정보를 자신의 테이블에 포함시킨다.
@EntityListeners(AuditingEntityListener.class)// 자동으로 생성시간 수정시간 기록해준다.
@Getter
public class BaseEntity {
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}

//BaseEntity 사용 이유 : 공통 필드인 createdAt, updatedAt, deletedAt를 BaseEntity 클래스로 분리하여 재사용할 수 있다.
// 이렇게 하면 다른 도메인 모델에서도 이러한 공통 속성을 쉽게 상속받아 사용할 수 있다.