import java.util.ArrayList;

public class SalesItem {

    private String name;
    private int price;
    private ArrayList<Comment> comments;

    public SalesItem(String name, int price) {
        this.name = name;
        this.price = price;
        comments = new ArrayList<Comment>();
    }

    public boolean addComment(String author, String text, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }

        for (Comment c : comments) {
            if (c.getAuthor().equals(author)) {
                return false;
            }
        }

        comments.add(new Comment(author, text, rating));
        return true;
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }

    public int getNumberOfComments() {
        return comments.size();
    }

    public Comment findMostHelpfulComment() {
        if (comments.isEmpty()) {
            return null;
        }

        Comment best = comments.get(0);
        for (Comment current : comments) {
            if (current.getVoteBalance() > best.getVoteBalance()) {
                best = current;
            }
        }
        return best;
    }
}
