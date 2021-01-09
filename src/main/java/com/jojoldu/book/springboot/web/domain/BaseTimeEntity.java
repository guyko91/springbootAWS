package com.jojoldu.book.springboot.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity클래스들이 BaseTimeEntity를 상속할 경우, 아래 필드들을 자동으로 컬럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 클래스에 Auditing기능을 포함시킨다.
public abstract class BaseTimeEntity {

    // 값을 생성할때 자동으로 시간이 저장된다.
    @CreatedDate
    private LocalDateTime createdDate;

    // 값을 변경할때 자동으로 시간이 저장된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}