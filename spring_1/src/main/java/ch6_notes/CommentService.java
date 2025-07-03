package ch6_notes;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment){
        logger.info("Published commenr: " + comment.getText());
    }
}
