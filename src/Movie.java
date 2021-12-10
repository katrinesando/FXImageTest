import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Movie extends Medie{
    String title, year, genre,rating;
    ArrayList<BufferedImage> poster;

    public Movie(String title,String year,String genre, String rating) {
        super(title,year,genre,rating);
        this.title = title;
    }
//    public void test(){
//        String str = null;
//        try (BufferedReader br = new BufferedReader(new FileReader("src\\film.txt"))) //åbner fil og begynder at læse igennem
//        {
//            //kører hele fil igennem indtil der ikke er mere og tilføjer dem til array
//            while ((str = br.readLine()) != null) {
//                String[] line = str.trim().split(";");
//                medie = new Movie(line[0],line[1],line[2],line[3],poster);
//                arr.add(medie);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void poster(ArrayList<Medie>arr) {
        //System.out.println("Før: " + poster.size());
        for(Medie m : arr){
            poster.add(getImage(m.getTitle()));
        }
        System.out.println("Succees: " + poster.size());
    }

    public Image getImageFX(String title){
        File file = new File("src\\filmplakater\\" + title+".jpg");
        Image image = new Image(file.toURI().toString());
        return image;
    }
    @Override
    public BufferedImage getImage(String title) {
        try
        {
            // Grab the InputStream for the image and save in img
            File file = new File("src\\filmplakater\\" + title+".jpg");
            BufferedImage img = ImageIO.read(file);
            //java.awt.Desktop.getDesktop().open(file);
            return img;

        } catch (IOException e) {
            System.out.println("The serie image was not loaded for: "+title);
            //System.exit(1);
        }
        return null;
    }

    //getters
    public String getGenre(){
        return genre;
    }
    public String getTitle(){
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
