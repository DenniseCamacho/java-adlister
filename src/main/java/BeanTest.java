

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        ArrayList<Quote> quotes = new ArrayList<>();
        Author Paul = new Author(1L, "Paul");
        Author LisaBevere = new Author(2L, "Lisa Bevere");

        Quote quote1 = new Quote(1L, "You reap what you sow", Paul);
        Quote quote2 = new Quote(2L, "As faith without works is dead, so is works without love",LisaBevere);

        quotes.add(quote1);
        quotes.add(quote2);

        for(Quote quote : quotes){
            System.out.println(quote.getAuthor().getAuthor_name() + " said: " + quote.getContent() );
        }
    }
}