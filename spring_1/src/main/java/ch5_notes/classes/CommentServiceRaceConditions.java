package ch5_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch4_notes.model.Comment;

@Service
public class CommentServiceRaceConditions {
    
    /*
     * Here I am autowiring the prototype bean, which will cause concurency issues in a multithreading env, 
     * since only one instance of CommentProcessor will exist when CommentServiceRaceConditions is created (since it's a singleton Bean!)
    */
    @Autowired
    private CommentProcessor process;
    
    public void sendComment(Comment c, int id){

        process.setComment(c, id);
        process.processComment();
        process.sendComment(id);
    }
}
