import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User {
    String name;
    String age;
    //Have en dropdown menu hvor man kan vælge farve ens "avatar" skal have
    ArrayList<Medie> myList;

    public User(String name, String age){
        this.name=name;
        this.age=age;
        //myList= new ArrayList<>();
    }
    public String getName(){
        return name;
    }

//    public void addMedie(Medie m) throws MedieAlreadyAddedException{
////        if(!myList.contains(m)){
////            myList.add(m);}
////        else {
////            if(m instanceof Movie a) {
////                throw new MedieAlreadyAddedException(a.getTitle() +" has already been added to your list");
////            } else if (m instanceof Serie b){
////                throw new MedieAlreadyAddedException(b.getTitle() +" has already been added to your list");
////            }
////        }
////    }
//    public void removeMedie(Medie m){
//        myList.remove(m);
//    }
//    public void displayMyList(){
//        for(Medie m:myList){
//            if(m instanceof Movie a) {
//                System.out.println(a.getTitle() + " " + a.getYear() + " " + a.getGenre() + " " + a.getRating());
//            } else if (m instanceof Serie b){
//                System.out.println(b.getTitle() + " " + b.getYear() + " " + b.getGenre() + " " + b.getRating()+" "+b.getEpisode());
//            }
//        }
//    }
    public void initializeMyList(ArrayList<ImageView> images, GridPane paneMyList,ArrayList<Medie> myList) throws FileNotFoundException {

        int x = 0;//1 virker
        int y = 0;//3 virker
        //tilføjer en masse tilfældeige medier til MyList

        for (Medie m : myList) {
            if (m instanceof Movie) {
                FileInputStream fl = new FileInputStream("src/filmplakater/" + m.getTitle() + ".jpg");
                Image image = new Image(fl);

                ImageView img = new ImageView(image);
                img.setImage(image);
                images.add(img);
                paneMyList.add(img, x, y);
                x++;
                //y++;
                if (x == 10) {
                    y++;
                    x = 0;
                }
            }
            if (m instanceof Serie) {
                FileInputStream fl = new FileInputStream("src/serieforsider/" + m.getTitle() + ".jpg");
                javafx.scene.image.Image image = new Image(fl);

                javafx.scene.image.ImageView img = new javafx.scene.image.ImageView(image);
                img.setImage(image);
                images.add(img);
                paneMyList.add(img, x, y);
                x++;
                //y++;
                if (x == 10) {
                    y++;
                    x = 0;
                }
            }
        }
    }

}

