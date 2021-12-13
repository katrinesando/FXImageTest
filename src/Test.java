//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.geometry.HPos;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.*;
//import javafx.scene.text.Font;
//import javafx.stage.Popup;
//
//import java.io.*;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.stream.Collectors;
//
//public class FXController implements Initializable {
//    @FXML
//    private GridPane pane;
//    @FXML
//    private GridPane paneMyList;
//    @FXML
//    private GridPane paneUsers;
//    @FXML
//    private ScrollPane scrollPane;
//    @FXML
//    private GridPane paneSerie;
//    @FXML
//    private Pane userPane;
//    @FXML
//    private Button btn;
//    @FXML
//    private TabPane tab;
//    @FXML
//    private AnchorPane root;
//    @FXML
//    private TextField username;
//    @FXML
//    private TextField age;
//    @FXML
//    private TextField searchMovieBar;
//    @FXML
//    private Button changeUserMovieButton;
//    @FXML
//    private Button searchMovieButton;
//    @FXML
//    private Button RefreshButton;
//
//    @FXML
//    private Button searchSerieButton;
//    @FXML
//    private TextField searchSerieBar;
//    @FXML
//    private Button searchMyListButton;
//    @FXML
//    private TextField searchMyListBar;
//
//
//    public Medie m;
//    private static ArrayList<Medie> arr;
//    private static String str;
//    private static ArrayList<Medie> myList;
//    private static ArrayList<Medie> searchList;
//    private static ArrayList<ImageView> images;
//    //private static ArrayList<User> users;
//
//    public void loadFileMovie() {
//        //inistatitere felter
//        try (BufferedReader br = new BufferedReader(new FileReader("src/film.txt"))) //åbner fil og begynder at læse igennem
//        {
//            String[] line = null;
//            //kører hele fil igennem indtil der ikke er mere og tilføjer dem til array
//            while ((str = br.readLine()) != null) {
//                line = str.trim().split(";");
//                m = new Movie(line[0], line[1], line[2], line[3]);
//                arr.add(m);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void loadFileSerie() {
//        try (BufferedReader br = new BufferedReader(new FileReader("src/serier.txt"))) //åbner fil og begynder at læse igennem
//        {
//            String[] line = null;
//            //kører hele fil igennem indtil der ikke er mere og tilføjer dem til array
//            while ((str = br.readLine()) != null) {
//                line = str.trim().split(";");
//                m = new Serie(line[0], line[1], line[2], line[3], line[4]);
//                arr.add(m);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void initializeMovie() throws FileNotFoundException {
//        int x = 0;//1 virker
//        int y = 3;//3 virker
//
//        ImageView imgTest = new ImageView();
//        images = new ArrayList<>();
//
//        for (Medie m : arr) {
//            if (m instanceof Movie) {
//                FileInputStream fl = new FileInputStream("src/filmplakater/" + m.getTitle() + ".jpg");
//                Image image = new Image(fl);
//
//                imgTest = new ImageView(image);
//                imgTest.setImage(image);
//                images.add(imgTest);
//
//                pane.add(imgTest, x, y);
//                x++;
//                //y++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//            getInfo(imgTest,m);
//        }
//    }
//
//    @FXML
//    private void initializeSerie() throws FileNotFoundException {
//        int x = 0;
//        int y = 3;
//
//        ImageView imgTest = new ImageView();
//        for (Medie m : arr) {
//            if (m instanceof Serie) {
//                FileInputStream fl = new FileInputStream("src/serieforsider/" + m.getTitle() + ".jpg");
//                Image image = new Image(fl);
//
//                imgTest = new ImageView(image);
//                imgTest.setImage(image);
//                paneSerie.add(imgTest, x, y);
//                x++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//            getInfo(imgTest,m);
//        }
//    }
//
//    @FXML
//    private void userBtn() throws FileNotFoundException {
//        userPane.setVisible(false);
//        tab.setVisible(true);
//        //users.add(new User((username.getText()),(age.getText())));
//    }
//
//    @FXML
//    private void changeUserMovieButton() throws FileNotFoundException {
//        tab.setVisible(false);
//        userPane.setVisible(true);
//    }
//
//    private void initializeMyList() throws FileNotFoundException {
//
//        int x = 0;//1 virker
//        int y = 0;//3 virker
//        //tilføjer en masse tilfældeige medier til MyList
//        myList.add(arr.get(1));
//        myList.add(arr.get(14));
//        myList.add(arr.get(27));
//        myList.add(arr.get(40));
//        myList.add(arr.get(102));
//        myList.add(arr.get(150));
//        myList.add(arr.get(170));
//
//        for (Medie m : myList) {
//            if (m instanceof Movie) {
//                FileInputStream fl = new FileInputStream("src/filmplakater/" + m.getTitle() + ".jpg");
//                Image image = new Image(fl);
//
//                ImageView imgTest = new ImageView(image);
//                imgTest.setImage(image);
//
//                paneMyList.add(imgTest, x, y);
//                x++;
//                //y++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//            if (m instanceof Serie) {
//                FileInputStream fl = new FileInputStream("src/serieforsider/" + m.getTitle() + ".jpg");
//                javafx.scene.image.Image image = new Image(fl);
//
//                javafx.scene.image.ImageView imgTest = new javafx.scene.image.ImageView(image);
//                imgTest.setImage(image);
//                paneMyList.add(imgTest, x, y);
//                x++;
//                //y++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//        }
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        arr = new ArrayList<Medie>();
//        myList = new ArrayList<Medie>();
//        loadFileMovie();
//        loadFileSerie();
//        //System.out.println(m.getTitle());
//        try {
//            initializeMovie();
//            initializeSerie();
//            initializeMyList();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        //clipChildren(pane);
//    }
//
//    public void searchInput() throws FileNotFoundException {
//        searchList = new ArrayList<>();
//
//        int x=0;
//        int y=3;
//
//        //leder efter den film/serie man har søgt på
//        for (Medie m : arr) {
//            if (m.getTitle().toLowerCase().contains(searchMovieBar.getText().toLowerCase())) {
//                searchList.add(m);
//            }
//
//        }
//
//        //leder om medie er søgt efter og ellers sætter det til null
//        for (Medie m : arr) {
//            if (!searchList.contains(m)) {
//                System.out.println(m.getTitle()+" --- "+x);
//                //sætter alle images i array til null
//                for (int i = 0; i < images.size(); i++) {
//                    images.get(i).imageProperty().set(null);
//                    //pane.add(images.get(i), x, y);
//                }
//                x++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//        }
//        //finder det medie man har søgt på og viser det
//        x=0;
//        y=0;
//        for (Medie m : searchList) {
//            if (m instanceof Movie) {
//                System.out.println("Search: " + m.getTitle());
//                FileInputStream fl = new FileInputStream("src/filmplakater/" + m.getTitle() + ".jpg");
//                Image image = new Image(fl);
//
//                ImageView imgTest = new ImageView(image);
//                imgTest.setImage(image);
//
//                pane.add(imgTest, x, y);
//                x++;
//                //y++;
//                if (x == 10) {
//                    y++;
//                    x = 0;
//                }
//            }
//        }
//    }
//
//    //pop-up window
//    private void getInfo(ImageView imgTest,Medie m){
//        Font myFont = new Font("Serif", 16);
//
//        imgTest.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            System.out.println("Tile pressed "+m.getTitle() + " --- "+m.getRating());
//            // create a popup
//            Popup popup = new Popup();
//            Label lbl = new Label("Title: " +m.getTitle()
//                    +'\n'+"Year: "+m.getYear()
//                    +'\n'+"Genre: "+m.getGenre()
//                    +'\n'+"Rating: "+m.getRating());
//            lbl.setStyle(" -fx-background-color: white;");
//            // set size of label
//            lbl.setFont(myFont);
//            lbl.setMinWidth(70);
//            lbl.setMinHeight(100);
//
//            popup.getContent().add(lbl);
//            //popup.getContent().add(popUpPane);
//            //popUpPane.setVisible(true);
//            // set auto hide
//            popup.setAutoHide(true);
//            if (!popup.isShowing()){
//                System.out.println(scrollPane.getHeight());
//                System.out.println(scrollPane.getWidth());
//                popup.show(pane,(scrollPane.getHeight()),(scrollPane.getWidth()/3));
//            }
//            event.consume();
//        });
//    }
//}
//
//
//