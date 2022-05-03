

public class DaoFactory {
    private static Ads adsDao;
    private static Authors authorsDao;
    private static Quotes quotesDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Authors getAuthorsDao() {
        if (authorsDao == null) {
            authorsDao = new AuthorsDao();
        }
        return authorsDao;
    }

    public static Quotes getQuotesDao() {
        if (quotesDao == null) {
            quotesDao = new QuotesDao();
        }
        return quotesDao;
    }
}