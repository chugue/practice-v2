package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@RequiredArgsConstructor
@Repository
public class BoardPersistRepository {
    private final EntityManager em;

    @Transactional
    public Board save (Board board){
        // board는 여기에서는 비영속 객체
        em.persist(board);
        // board는 한번 담겨서 영속 객체
        return board;
    }
}
