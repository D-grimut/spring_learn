package ch6_notes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch5_notes.config.ProjectCfg;

public class Main {
    public static void main(String[] args) {
        var conetxt = new AnnotationConfigApplicationContext(ProjectCfg.class);
        Comment comment = new Comment("Spring", "aspect aspect aspect aspect aspect aspect aspect");

        CommentService cs = conetxt.getBean(CommentService.class);
        cs.publishComment(comment);
    }
}
