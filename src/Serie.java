import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Serie extends Medie {
    String episode;

    public Serie(String title, String year, String genre, String rating, String episode) {
        super(title,year, genre, rating);
        this.episode =  episode;
    }

    @Override
    public void poster(ArrayList<Medie> arr) {
        try{
            for(Medie s : arr){
                poster.add(getImage(s.getTitle()));
            }
        }catch(NullPointerException e){
            e.getMessage();
        }

    }

    @Override
    public BufferedImage getImage(String title) {
        try
        {
            // Grab the InputStream for the image.
            BufferedImage img = ImageIO.read(new File("src\\serieforsider\\" + title+".jpg"));
            return img;
        } catch (IOException e) {
            System.out.println("The serie image was not loaded for: "+title);
            //System.exit(1);
        }
        return null;
    }

    //getters unikt for Serie
    public String getEpisode(){
        return episode;
    }
    //getters fra Medie
    @Override
    public String getGenre() {
        return genre;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getYear() {
        return year;
    }
    @Override
    public String getRating() {
        return rating;
    }
}
