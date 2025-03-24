package ch4_notes.proxies;

import ch4_notes.model.Comment;

public class EmailCommentNotifProxy implements ICommentNotifiProxy{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending EMAIL for comment: " + comment.getText());
    }
    
}
