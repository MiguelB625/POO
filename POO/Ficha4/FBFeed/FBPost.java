package Ficha4.FBFeed;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class FBPost {
    private long id;
    private String user;
    private LocalDateTime date;
    private String content;
    private int numLikes;
    private List<String> comments;

    public static int idCounter = 1; // Id é incrementado
    // sempre que é criada uma nova instância


    /**
     * Construtor padrão
     */
    public FBPost(){
        this.id = FBPost.idCounter++;
        this.user = "Default";
        this.date = LocalDateTime.now();
        this.content = "Default";
        this.numLikes = 0;
        this.comments = new ArrayList<String>();
    }

    /**
     * Construtor que recebe todos os campos da classe, exceto id
     * @param user
     * @param date
     * @param content
     * @param numLikes
     * @param comments
     */
    public FBPost(String user, LocalDateTime date, String content, int numLikes, List<String> comments){
        this.id = FBPost.idCounter++;
        this.user = user;
        this.date = date;
        this.content = content;
        this.numLikes = numLikes;
        this.comments = new ArrayList<String>();

        for(String comment : comments){
            this.comments.add(comment);
        }
    }

    /**
     * Construtor que recebe todos os campos da classe exceto id e lista de comentários
     * @param user
     * @param date
     * @param content
     * @param numLikes
     */
    public FBPost(String user, LocalDateTime date, String content, int numLikes){
        this.id = FBPost.idCounter++;
        this.user = user;
        this.date = date;
        this.content = content;
        this.numLikes = numLikes;
        this.comments = new ArrayList<String>();
    }

    /**
     * Construtor de cópia
     * @param f
     */
    public FBPost(FBPost f){
        this.id = f.getId();
        this.user = f.getUser();
        this.date = f.getDate();
        this.content = f.getContent();
        this.numLikes = f.getNumLikes();
        this.comments = f.getComments();
    }

    /**
     * Devolve o id do post
     * @return
     */
    public long getId(){
        return this.id;
    }

    /**
     * Altera o id do post
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Devolve o user do post
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     * Altera o user do post
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Devolve a data do post
     * @return
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Altera a data do post
     * @param date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Devolve o conteúdo do post
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Altera o conteúdo do post
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Devolve o nº de likes do post
     * @return
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * Altera o nº de likes do post
     * @param numLikes
     */
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * Devolve a lista de comentários do post
     * @return
     */
    public List<String> getComments() {
        List<String> commentsDup = new ArrayList<String>();

        for(String c: this.comments){
            commentsDup.add(c);
        }

        return commentsDup;
    }

    /**
     * Altera a lista de comentários do post
     * @param comments
     */
    public void setComments(List<String> comments) {
        for(String c: this.comments){
            this.comments.add(c);
        }
    }

    /**
     * Adiciona um comentário à lista de comentários do post
     * @param comment
     */
    public void addComment(String comment){
        this.comments.add(comment);
    }

    /**
     * Devolve o conteúdo do post como um String
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FBPost{");
        sb.append("id=").append(id);
        sb.append(", user='").append(user).append('\'');
        sb.append(", date=").append(date);
        sb.append(", content='").append(content).append('\'');
        sb.append(", numLikes=").append(numLikes);
        sb.append(", comments=").append(comments);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Faz clone do post usando o construtor de cópia
     * @return
     */
    public FBPost clone(){
        return new FBPost(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FBPost fbPost = (FBPost) o;
        return id == fbPost.id && numLikes == fbPost.numLikes && Objects.equals(user, fbPost.user) && Objects.equals(date, fbPost.date) && Objects.equals(content, fbPost.content) && Objects.equals(comments, fbPost.comments);
    }

    public int compareTo(FBPost f){
        int numC1 = this.comments.size(), numC2 = f.getComments().size();

        if (numC1 == numC2) return 0;
        if (numC1 > numC2) return -1;
        else return 1;
    }

}

