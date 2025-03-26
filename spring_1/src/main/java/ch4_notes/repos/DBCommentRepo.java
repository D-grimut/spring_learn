package ch4_notes.repos;

import org.springframework.stereotype.Repository;

import ch4_notes.model.Comment;

@Repository
public class DBCommentRepo implements ICommentRepo {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment rn: " + comment.getText());
    }
    
}
