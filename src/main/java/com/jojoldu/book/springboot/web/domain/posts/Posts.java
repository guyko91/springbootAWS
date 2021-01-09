package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 주요 어노테이션을 클래스와 가깝게 배치.
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    // @Entity
    // 1. 테이블과 링크될 클래스임을 나타냄.
    // 2. 기본값으로 클래스의 카멜케이스이름을 언더스코어 네이밍으로 테이블 이름을 매핑한다. (SalesManager -> sales_manager table)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
