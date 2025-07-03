package ch6_notes;

public class Comment {
    private String auth;
    private String text;


    Comment(String auth, String text){
        this.auth = auth;
        this.text = text;
    }

    public String getAuth(){
        return this.auth;
    }

    public String getText(){
        return this.text;
    }

    public void setAuth(String auth){
        this.auth= auth;
    }

    public void setText(String text){
        this.text = text;
    }
}
