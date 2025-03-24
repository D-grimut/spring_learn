package ch4_notes.repos;

import ch4_notes.model.Comment;

public class DBCommentRepo implements ICommentRepo {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment rn: " + comment.getText());
    }
    
}
