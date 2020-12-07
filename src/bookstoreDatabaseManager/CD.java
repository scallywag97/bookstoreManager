package bookstoreDatabaseManager;

/**
 * This is the CD class and its fields. It extends Product
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class CD extends Product {

    private String artist;  //artist name
    private int numTracks;  //number of tracks
    private String tracks[];    //list of track titles

    /**
     * This is the constructor of the CD class
     *
     * @param price price of cd
     * @param id id number of cd
     * @param title title of cd
     * @param amountInStock amount in stock of cd
     * @param artist artist name of cd
     * @param numTracks number of tracks on cd
     * @param tracks list of tracks on cd
     */
    public CD(double price, int id, String title, int amountInStock, String artist, int numTracks, String[] tracks) {
        super(price, id, title, amountInStock);
        this.artist = artist;
        this.numTracks = numTracks;
        this.tracks = tracks;
    }

    /**
     * Gets artist name of cd
     *
     * @return returns artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets number of tracks on cd
     *
     * @return returns number of tracks
     */
    public int getNumTracks() {
        return numTracks;
    }

    /**
     * Gets list of tracks on cd
     *
     * @return list of tracks
     */
    public String[] getTracks() {
        return tracks;
    }
}
