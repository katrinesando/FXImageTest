import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

//import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private GridPane pane;
    public Medie m;
    private static ArrayList<Medie> arr;
    private static String str;

    public void loadFileMovie() {
        //inistatitere felter
        arr = new ArrayList<Medie>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\film.txt"))) //åbner fil og begynder at læse igennem
        {
            String[] line = null;
            //kører hele fil igennem indtil der ikke er mere og tilføjer dem til array
            while ((str = br.readLine()) != null) {
                line = str.trim().split(";");
                m = new Movie(line[0], line[1], line[2], line[3]);
                arr.add(m);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFileSerie(){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\serier.txt"))) //åbner fil og begynder at læse igennem
        {
            String[] line = null;
            //kører hele fil igennem indtil der ikke er mere og tilføjer dem til array
            while ((str = br.readLine()) != null) {
                line = str.trim().split(";");
                m = new Movie(line[0], line[1], line[2], line[3]);
                arr.add(m);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clipChildren(Region region) {
        Rectangle clipPane = new Rectangle();

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            clipPane.setWidth(newValue.getWidth());
            clipPane.setHeight(newValue.getHeight());
        });
        region.setClip(clipPane);

    }

    @FXML
    private void initialize() throws FileNotFoundException {
        int x = 0;
        int y = 3;

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        pane.getColumnConstraints().add(column1);

        for(Medie m : arr){
            FileInputStream fl = new FileInputStream("src\\filmplakater\\"+m.getTitle()+".jpg");
            Image image = new Image(fl);

            ImageView imgTest = new ImageView(image);
            //imgTest.setFitHeight(100);
           // imgTest.setFitWidth(70);

            imgTest.setImage(image);

            pane.add(imgTest,x,y);
            x++;
            //y++;
            if(x==5){
                y++;
                x=0;
            }
            if(x==5&&y==7){
                continue;
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFileMovie();
        loadFileSerie();
        System.out.println(m.getTitle());

        try {
            initialize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        clipChildren(pane);
    }
}
