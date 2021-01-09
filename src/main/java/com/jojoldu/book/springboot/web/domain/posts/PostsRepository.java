package com.jojoldu.book.springboot.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Mybatis 에서 dao로 불리는 DB Layer 접근자 = JPA Repository
// JpaRepository<Entity 클래스, PK 타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
