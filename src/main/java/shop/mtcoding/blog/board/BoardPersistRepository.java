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
    public void deleteById(Integer id){
        String q = """
                delete from Board b where b.id = :id
                """;
        Query query = em.createQuery(q);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    public Board findById (int id){
        Board board = em.find(Board.class, id);
        return board;
    }

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
