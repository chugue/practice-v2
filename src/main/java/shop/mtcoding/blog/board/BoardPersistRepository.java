package shop.mtcoding.blog.board;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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

    public List<Board> findAll() {
        String q = """
                select b from Board b order by b.id desc
                """;
        Query query = em.createQuery(q, Board.class);
        return query.getResultList();
    }

}
