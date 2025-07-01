package ch5_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch4_notes.model.Comment;

/*
 * In general, in any case where we want Spring to augment the object with a specific capability, it needs to be a bean.
 * This means if you wan't DI or IoC, you need to make the desired component a Bean.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    private Comment comment;

    @Autowired
    private CommentRepository commentRepository;

    public void setComment(Comment comment, int id){
        if(this.comment != null){
            System.out.println("Wait what! This object changed by thread " + id);
        }
        this.comment = comment;
    }

    public Comment getComment(){
        return this.comment;
    }

    public void processComment(){
        this.comment.setText(this.comment.getText() + " - processed");
    }

    public void sendComment(int id){
        commentRepository.sendComment(this.comment.getText(), id);
    }
    
    
}
