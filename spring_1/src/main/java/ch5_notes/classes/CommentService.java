package ch5_notes.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ch4_notes.model.Comment;

@Service
public class CommentService {

    // Recall that ApplicationContext is the spring context - it always exist as long as some cfg is loaded inot Spring.
    @Autowired
    private ApplicationContext context;
    
    /*
     * Carefull! CommentService bean is a SINGLETON = Spring injects it's dependencies ONCE when the Bean is created.
     * Therefore, if we autowire the CommentProcessor, then we would only have one instance attached to the CommentService,
     * defeating the purpose of CommentService being a Prototype Bean.
     * 
     * "But Daniel, isn't CommentRepository a singleton Bean? Doesn't is mean that all instances of CommentProcessor share the same instance of the injected CommentRepository?
     * Isn't that a race condition risk?" -> Great question voices in my head! CommentRepository is indeed a singleton Bean, BUT, singleton beans usualy are designed to be IMMUTABLE,
     * meaning their state remains the same, so multiple threads can access the same instance safely. Usualy, singleton Beans will deligate the concurency to some other library, closer to the actual DB!
    */
    public void sendComment(Comment c, int id){
        // If CommentProcessor did not need to autowire the Comment Repo
        // then we would not need to make the CommentProcessor a Prototype Bean, let alone a Bean in the Spring context.
        // CommentProcessor process = new CommentProcessor();

        CommentProcessor process = context.getBean(CommentProcessor.class);

        process.setComment(c, id);
        process.processComment();
        process.sendComment(id);
    }
    
}
