package com.jojoldu.book.springboot.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // 단위 테스트가 끝날 때마다 수행되는 메소드를 지정.
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시물저장_블러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // posts 테이블에 insert/update 쿼리를 실행한다.
        // id 값이 있으면 update, 없으면 insert를 수행.
        postsRepository.save(Posts.builder()
                                    .title(title)
                                    .content(content)
                                    .author("guyko91@gmail.com")
                                    .build());

        // when
        // posts 테이블의 모든 rows를 가져오는 메서드.
        List<Posts> postList = postsRepository.findAll();

        // then
        Posts posts = postList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {

        // given
        LocalDateTime now = LocalDateTime.of(2020,1,9,21,35,0);
        postsRepository.save(Posts.builder().author("guyko").title("title").content("content").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>> createdDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
