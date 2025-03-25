package ch4_notes.repos;

import org.springframework.stereotype.Component;

import ch4_notes.model.Comment;

@Component
public class DBCommentRepo implements ICommentRepo {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment rn: " + comment.getText());
    }
    
}
