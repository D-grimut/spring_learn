package ch4_notes.proxies;

import ch4_notes.model.Comment;

public interface ICommentNotifiProxy {
    void sendComment(Comment comment);

    // Recall default methods in Java!
    // When an interface with default method is implemented, then we can do the following with the default functions:
    // - Not mention the default method at all, which lets your extended interface inherit the default method.
    // - Redeclare the default method, which makes it abstract.
    // - Redefine the default method, which overrides it.
    default void hi(){
        System.out.println("hehe");
    }
}
