package Ficha4.FBFeed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;

    /**
     * Construtor padrão
     */
    public FBFeed(){
        this.posts = new ArrayList<FBPost>();
    }

    /**
     * Construtor que recebe uma lista de posts
     * @param l
     */
    public FBFeed(List<FBPost> l) {
        this.posts = new ArrayList<FBPost>(l.size());

        for(FBPost post: l){
            this.posts.add(post.clone());
        }
    }

    /**
     * Construtor de cópia
     * @param f
     */
    public FBFeed(FBFeed f){
        this.posts = new ArrayList<FBPost>(f.numPosts());

        for(FBPost post: f.getPosts()){
            this.posts.add(post);
        }
    }

    /**
     * Método que devolve o feed como uma string
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FBFeed{");
        sb.append("posts=").append(posts);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Devolve uma lista com os posts de um feed (fazendo clone)
     * @return
     */
    public List<FBPost> getPosts() {
        List<FBPost> dup = new ArrayList<FBPost>();

        for(FBPost post: this.posts){
            dup.add(post.clone());
        }

        return dup;
    }

    /**
     * Altera os posts do feed (estratégia composição)
     * @param posts
     */
    public void setPosts(List<FBPost> posts) {
        for(FBPost post: posts){
            this.posts.add(post.clone());
        }
    }

    /**
     * Faz o clone de um feed
     * @return
     */
    public FBFeed clone(){
        return new FBFeed(this);
    }

    /**
     * Devolve o número de posts de um feed
     * @return
     */
    public int numPosts(){
        return this.posts.size();
    }

    //i
    /**
     * Determina o número de posts de um user
     * @param user
     * @return
     */
    public int nrPosts(String user){
        int numPosts=0;

        for(FBPost post: this.posts){
            if (post.getUser()==user){
                numPosts++;
            }
        }

        return numPosts;
    }

    // ii
    /**
     * Devolve a lista de posts de um user (cópia)
     * @param user
     * @return
     */
    public List<FBPost> postsOf(String user) {
        List<FBPost> posts = new ArrayList<FBPost>();
        Iterator<FBPost> it = this.posts.iterator();
        FBPost post;

        while (it.hasNext()) {
            post = it.next();
            if (post.getUser() == user){
                posts.add(post.clone());
            }
        }

        return posts;
    }

    //iii

    /**
     * Determina a lista de posts de um user num determinado intervalo de tempo
     * @param user
     * @param inicio
     * @param fim
     * @return
     */
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return this.posts.stream().filter(p -> p.getUser() == user && p.getDate().isAfter(inicio) && p.getDate().isBefore(fim)).collect(Collectors.toList());
    }

    // iv
    /**
     * Obtém o primeiro post com um dado identificador
     * Na prática todos os posts vão ter ids diferentes
     * @param id
     * @return o primeiro post com esse id ou null se não encontrado
     */
    public FBPost getPost(int id){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost post=null;
        boolean found = false;

        while (it.hasNext() && !found) {
            post = it.next();
            if (post.getId() == id) {
                found = true;
            }
        }
        if (!found) post = null;

        return post;
    }

    //v

    /**
     * Inserir um comentário num post
     * @param post
     * @param comentario
     */
    public void comment(FBPost post, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        boolean found = false;
        FBPost currPost;

        while (it.hasNext() && !found) {
            currPost = it.next();
            if (currPost.equals(post)){
                found = true;
                currPost.addComment(comentario);
            }
        }

    }

    // vi

    /**
     * Inserir um comentário num post com um dado post Id
     * @param postId
     * @param comentario
     */
    public void comment(int postId, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        boolean found = false;
        FBPost currPost;

        while (it.hasNext() && !found) {
            currPost = it.next();
            if (currPost.getId() == postId){
                found = true;
                currPost.addComment(comentario);
            }
        }
    }

    /**
     * Adiciona um like a um post
     * @param post
     */
    public void like(FBPost post){
        Iterator<FBPost> it = this.posts.iterator();
        boolean found = false;
        FBPost currPost;

        while (it.hasNext() && !found) {
            currPost = it.next();
            if (currPost.equals(post)){
                found = true;
                currPost.setNumLikes(currPost.getNumLikes() + 1);
            }
        }
    }

    /**
     * Adiciona um like a um post com base no id
     * @param
     */
    public void like(int postId){
        Iterator<FBPost> it = this.posts.iterator();
        boolean found = false;
        FBPost currPost;

        while (it.hasNext() && !found) {
            currPost = it.next();
            if (currPost.getId() == postId){
                found = true;
                currPost.setNumLikes(currPost.getNumLikes() + 1);
            }
        }
    }

    /**
     * Determina a lista dos 5 posts(identificador) com mais comentários
     * @return
     */
    /*
    public List<Integer> top5Comments(){
        List<Integer> ids = new ArrayList<Integer>();
        Iterator<FBPost> it = this.posts.iterator();
        FBPost post;

        while (it.hasNext()) {
            post = it.next();
            ids.add((int)(post.getId()));
        }

        Collections.sort(ids);

        List<Integer> ids5 = new ArrayList<>(5);
        Iterator<Integer> it2 = ids.iterator();
        int i=0;

        while (it2.hasNext() && i<5){
            ids5.add(it2.next());
            i++;
        }

        return ids5;
    }*/

    // Versão com streams
    public List<Integer> top5Comments() {
        return this.posts.stream().sorted(FBPost::compareTo).map(p -> p.getComments().size()).limit(5).collect(Collectors.toList());
    }
}
