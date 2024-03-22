package shop.mtcoding.blog.blog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.board.BoardPersistRepository;

@Import(BoardPersistRepository.class)
@DataJpaTest
public class BoardPersistRepositoryTest {
    @Autowired
    private BoardPersistRepository boardPersistRepository;

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
