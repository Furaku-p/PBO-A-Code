import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SalesItemTest {

    private SalesItem item;

    @Before
    public void setUp() {
        item = new SalesItem("Laptop Asus", 15000000);
    }

    @Test
    public void testAddValidComments() {
        assertTrue(item.addComment("Fajar", "Bagus banget", 5));
        assertTrue(item.addComment("Andi", "Lumayan puas", 4));
        assertEquals(2, item.getNumberOfComments());
    }

    @Test
    public void testAddInvalidRating() {
        assertFalse(item.addComment("Sari", "Rating rendah", 0));
        assertFalse(item.addComment("Tono", "Rating tinggi", 6));
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    public void testAddDuplicateAuthor() {
        item.addComment("Fajar", "Komentar pertama", 5);
        assertFalse(item.addComment("Fajar", "Komentar kedua", 4));
    }

    @Test
    public void testFindMostHelpfulComment() {
        item.addComment("Fajar", "Good", 5);
        item.addComment("Rina", "Mantap", 4);

        Comment c = item.findMostHelpfulComment();
        c.upvote();
        c.upvote();
        c.downvote(); 

        assertNotNull(item.findMostHelpfulComment());
        assertEquals(1, c.getVoteBalance());
    }

    @Test
    public void testRemoveComment() {
        item.addComment("Fajar", "Produk bagus!", 5);
        Comment comment = item.findMostHelpfulComment();
        assertTrue(item.removeComment(comment));
        assertEquals(0, item.getNumberOfComments());
    }
}
