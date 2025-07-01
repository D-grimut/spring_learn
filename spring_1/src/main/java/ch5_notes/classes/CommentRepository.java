package ch5_notes.classes;

import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    CommentRepository(){
        System.out.println("comment repo does nothing, but immagine here it will interface with some DB");
    }

    public void sendComment(String comment, int threadID){
        System.out.println("Comment " + comment + ", send by thread " + threadID);
    }
}
