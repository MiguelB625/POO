package Ficha4.FBFeed;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TesteFBFeed {
    public static void main(String[] args) {
        FBPost f1 = new FBPost();
        FBPost f2 = new FBPost("Miguel", LocalDateTime.now(), "Experiência", 10);
        FBPost f3 = new FBPost(f2);

        List<FBPost> l = new ArrayList<>();
        l.add(f1);
        l.add(f2);
        l.add(f3);

        FBFeed feed1 = new FBFeed(l);
        System.out.println("Feed original: \n\n" + feed1 + "\n\n");

        // i
        System.out.println(feed1.nrPosts("Miguel"));

        // ii
        List<FBPost> list = feed1.postsOf("Miguel");
        System.out.println(list);

        // iii
        LocalDateTime inicio = LocalDateTime.of(2022, 1, 2, 10, 10, 10);
        LocalDateTime fim = LocalDateTime.of(2022, 3, 2, 10, 10, 10);
        List<FBPost> list2 = feed1.postsOf("Miguel", inicio, fim);
        System.out.println(list2);

        // iv
        FBPost postFound = feed1.getPost(1);
        System.out.println(postFound);

        // v
        feed1.comment(f1, "Incrível");
        System.out.println(feed1);

        // vi
        feed1.comment(1, "Adoro");
        System.out.println(feed1);

        // vii
        feed1.like(f3); // Vai alterar o f2 porque é cópia do f3 e aparece primeiro
        System.out.println(feed1);

        // viii
        feed1.like(1);
        System.out.println(feed1);

        // ix
        List<Integer> l1 = feed1.top5Comments();
        System.out.println(l1);
    }
}
