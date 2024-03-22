package shop.mtcoding.blog.blog;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.board.BoardPersistRepository;

import java.util.List;

@Import(BoardPersistRepository.class)
@DataJpaTest
public class BoardPersistRepositoryTest {
    @Autowired
    private BoardPersistRepository boardPersistRepository;
    @Autowired
    private EntityManager em;


    @Test
    public void findAll_test(){
        // given

        // when
        List<Board> boardList = boardPersistRepository.findAll();
        // then
        System.out.println("findAll_test/size : " + boardList.size());


    }

    @Test
    public void save_test(){
        // given
        Board board = new Board("제목5", "내용5", "ssar");
        // when
        boardPersistRepository.save(board);
        // then
        System.out.println("save_test : " + board);

    }
}
