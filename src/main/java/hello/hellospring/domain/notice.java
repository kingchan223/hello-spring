package hello.hellospring.domain;

public class notice {
    private int id;
    private String title;
    private String content;
    public static int cnt = 0;

    public notice(String title, String content){
        this.id = cnt++;
        this.title = title;
        this.content = content;
    }

}
