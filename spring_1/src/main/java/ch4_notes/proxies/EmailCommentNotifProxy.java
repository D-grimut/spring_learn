package ch4_notes.proxies;

import org.springframework.stereotype.Component;

import ch4_notes.model.Comment;

@Component
public class EmailCommentNotifProxy implements ICommentNotifiProxy{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending EMAIL for comment: " + comment.getText());
    }
    
}
