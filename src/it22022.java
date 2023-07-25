import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


import static java.lang.System.in;

public class it22022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Λιστα για θεαματα,σκηνοθετες,ηθοποιους,χρηστες   στο συστημα
        List<Spectacle> spectacles = new ArrayList<>();
        List<Director> directors = new ArrayList<>();
        List<Actor> actors = new ArrayList<>();
        List<User> users = new ArrayList<>();

        Spectacle movie;
        Series series;
        MiniSeries miniSeries;
        Actor actor;
        Director director;
        User user = null;

        List<String> spectacleActors = new ArrayList<>();         // ηθοποιοι των θεαματων
        List<String> SpectacleKind = new ArrayList<>();              // ειδος θεαματων
        List<Integer> episodes = new ArrayList<>();             // λιστα για επισοδεια
        List<Actor> favoritesActors=new ArrayList<>();          // αγαπημενη ηθοποιοι

        actor = new Actor("Vin Diesel", "usa", "VinDiesel.com", 1967, 100);         //define actor

        actors.add(actor);                                                                                               // προσθηκη ηθοποιου στη λιστα του συστηματος
        actor = new Actor("Michelle Rodriguez", "usa", "Rodriguez.com", 1978, 101);       //define actor
        actors.add(actor);                                                                                           // προσθηκη ηθοποιου στη λιστα του συστηματος

        director = new Director("rob cohen", "usa", "-", 1960, 103);   //define director
        directors.add(director);          // προσθηκη σκηνοθέτη στη λιστα του συστηματος

        spectacleActors.add("Vin Diesel");
        spectacleActors.add("Michelle Rodriguez ");
        SpectacleKind.add("drama");
        SpectacleKind.add("happy");


        movie = new Spectacle("fast and furious 1", "usa", SpectacleKind, 2001, spectacleActors, "rob cohen", 1);
        spectacles.add(movie);  // προσθηκη θεαματος στο συστημα

        // define-users
        User user1 = new User("John", "john@.com", "password");
        users.add(user1);                                                                //προσθηκη user στο συστημα
        User user2 = new User("Emma", "emma@.com", "password2");
        users.add(user2);                                                                //προσθηκη user στο συστημα

        // define-evaluation
        Evaluation eval1 = new Evaluation(user1.getName(), 8);    // evaluation εχει χρηστη και βαθμολογια
        Evaluation eval2 = new Evaluation(user2.getName(), 7);

        spectacleActors=new ArrayList<>();
        SpectacleKind = new ArrayList<>();

        movie.addEvaluation(eval1);    //προσθηκη evaluation θεαματος
        movie.addEvaluation(eval2);



        actor = new Actor("Tom Ellis", "usa", "Tom Ellis.com", 1978, 105);   //define actor
        actors.add(actor);                                                                                             // προσθηκη ηθοποιου στην λιστα του συστηματος
        favoritesActors.add(actor);                                                                                    //προσθηκη ηθοποιου στα αγαπημενα

        actor = new Actor("Lauren German", "usa", "Lauren.com", 1978, 106);   //define actor
        actors.add(actor);                                                                                     // προσθηκη ηθοποιου στη λιστα του συστηματος

        favoritesActors.add(actor);               // προσθηκη ηθοποιού στα αγαπημένα ενος user (φαίνεται παρακάτω)
        director = new Director("Len Wise man", "usa", "-", 1973, 108);
        directors.add(director);

        spectacleActors.add("Tom Ellis");
        spectacleActors.add("Lauren German");

        SpectacleKind.add("happy");
        SpectacleKind.add("drama");

        episodes.add(21);            //define episodes at Lucifer
        episodes.add(18);


        series = new Series("Lucifer", "usa", SpectacleKind, 2021, spectacleActors, "Len Wise man", 7, 2, episodes);

        spectacleActors=new ArrayList<>();
        SpectacleKind = new ArrayList<>();

        spectacleActors.add("Michelle Rodriguez");
        spectacleActors.add("Lauren German");
        SpectacleKind.add("horror");
        SpectacleKind.add("funny");


        miniSeries = new MiniSeries("night-spy", "usa", SpectacleKind, 2021, spectacleActors, "Len Wise man", 9, 2, episodes);

        user1.setFavoritesActors(favoritesActors);   //προσθηκη ηθοποιων στα αγαπημενα του user1 του  email:john@.com--password:password



        spectacles.add(series);                       // προσθηκη σειρας στο συστημα
        spectacles.add(miniSeries);                    // προσθηκη Μινι-σειρας στο συστημα

        series.addEvaluation(eval1);                 //προσθήκη βαθμολογίας του χρηστή john@.com στη σειρά Lucifer
        series.addEvaluation(eval2);                   //προσθήκη βαθμολογίας του χρηστή emma@.com στη σειρά Lucifer
        int spectacleId = 11;
        int id = 110;
        while (!exit) {
            System.out.println("\nEnter 1 to add a MOVIE");
            System.out.println("Enter 2 to view all spectacles");
            System.out.println("Enter 3 to add series");
            System.out.println("Enter 4 to refresh series or mini-series");
            System.out.println("Enter 5 to exit");
            System.out.println("Enter 6 to search actors and directors");
            System.out.println("Enter 7 to rate spectacle");
            System.out.println("Enter 8 to see all your ratings");
            System.out.println(("Enter 9 to add actors-directors to your favorites"));
            System.out.println(("Enter 10 to add Mini-Series "));
            boolean input = true;
            int i ;
            int p;
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }

            switch (choice) {
                case 1:
                    spectacleId = spectacleId + 1;
                    SpectacleKind=new ArrayList<>();
                    spectacleActors=new ArrayList<>();
                    System.out.println("Enter the Movie name:");
                    String movieName = scanner.nextLine();
                      if(movieName.isEmpty())return;                             // αν το ονομα ταινιας ειναι κενο τερματιζεται η εφαρμογη
                   
                   System.out.println("Enter the Country:");
                    String movieCountry = scanner.nextLine();
                           
                      if(movieCountry.isEmpty())return;  
                    movie.addKind(SpectacleKind);

                    System.out.println("Enter the Movie Year:");
                    int movieYear = 0;
                    do {                                                                 // βροχος μεχρι να δωσει αριθμο
                        try {
                            movieYear = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    } while (input);

                    System.out.println("Enter the Director's name :");
                    String DirectorName = scanner.nextLine();
                        if(DirectorName.isEmpty()) return;                              // αν πατησετε κατευθειαν enter χωρις να εχει τιμη μεσα θα τερματιζεται η εφαρμογη
                            
                       
                    p = checkIfDirectorIsInSystem(DirectorName, directors);                        // ελενχει αν υπαρχει ο σκηνοθετης. Επιστρεφει 0 αν δεν υπαρχει
                    if (p == 0) {                                                                //αν το p ειναι 0 ζηταει στοιχεια για τον σκηνοθετη
                        System.out.println("\ndirector there is no in the system! ");
                        id = id + 1;                                                                    // μοναδικο id
                        createDirector(DirectorName, directors, id);
                    }
                    id=id+1;
                    id= createActor(actors, spectacleActors, id);                    //καλουμε την κλαση createActor φτιαχνει οσους καινουργιους Actor(μεχρι 10) θελει ο χρηστης και τους αποθηκευει
                      if(id==1)return;                                 // αν το ονομα ειναι κενο τερματιζεται η εφαρμογη                                                        
                    
                    movie = new Spectacle(movieName, movieCountry, SpectacleKind, movieYear, spectacleActors, DirectorName, spectacleId);  //δημηουργει θεαμα
                    spectacles.add(movie);                                                                                             // το προσθετει

                    break;

                case 2:
                    movie.allSpectaclesPrint(spectacles);
                    break;

                case 3:
                  
                    spectacleId = spectacleId + 1;
                    episodes=new ArrayList<>() ;       //Καινούργια λίστα για εισαγωγή καινούργιων τιμών
                    SpectacleKind=new ArrayList<>();         // >>          >>           >>
                    spectacleActors=new ArrayList<>() ;       //         >>       >>       >>     >>

                    System.out.println("Enter the series name:");
                    String seriesName = scanner.nextLine();
                    if(seriesName.isEmpty())return;                               //αν ειναι κενο τερματιζει η εφαρμογη
                   
                    System.out.println("Enter the Country:");
                    String seriesCountry = scanner.nextLine();
                    if(seriesCountry.isEmpty()) return;                            //αν ειναι κενο τερματιζει η εφαρμογη
                    series.addKind(SpectacleKind);

                    System.out.println("Enter the Year:");
                    int seriesYear = 0;
                    do {                                                   // βροχος μεχρι να βαλει αριθμο
                        try {
                            seriesYear = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    } while (input);

                    System.out.println("Enter the Director:");
                    DirectorName = scanner.nextLine();
                   if(DirectorName.isEmpty())return;                                          //αν ειναι κενο τερματιζει η εφαρμογη
                   
                   p= checkIfDirectorIsInSystem(DirectorName, directors);               // ελενχει αν υπαρχει ο σκηνοθετης επιστρεφει 0 αν δεν υπαρχει
                    if (p == 0) {                                                               //αν το p ειναι 0 ζηταει στοιχεια για τον σκηνοθετη
                        System.out.println("\ndirector there is no in the system! ");
                        id = id + 1;                                                           // μοναδικο id
                        createDirector(DirectorName,directors,id);  }
                    System.out.println("\nput the sezon");
                    int sezon = 0;
                    input = true;

                    do {
                        try {
                            sezon = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");             // έλεγχος
                        }
                    } while (input);

                    for (i = 0; i < sezon; i++) {
                        System.out.println("put the episodes of" + " " + (i + 1) + " " + "sezon");
                        episodes.add(scanner.nextInt());
                    }
                    scanner.nextLine();             // νεα γραμμή για το buffer
                    id=id+1;
                    id=createActor(actors, spectacleActors, id);
                       if(id==1)return;
                    series = new Series(seriesName, seriesCountry, SpectacleKind, seriesYear, spectacleActors, DirectorName, spectacleId, sezon, episodes);
                    spectacles.add(series);
                    break;
                case 4:
                    String SeriesName=null;
                    int searchId=0;
                    System.out.println(" if you want search series-MiniSeries to refresh with id press 'id' or press 'name' ");  // βάλε το id ή το όνομα
                    String choice2 = scanner.nextLine();
                    if(Objects.equals(choice2, "id")){
                        System.out.println("press series-MiniSeries id ");
                        searchId= scanner.nextInt();
                        scanner.nextLine();                          // νέα γραμμή
                    }else if(Objects.equals(choice2, "name")){
                        System.out.println("press series-MiniSeries name");
                        SeriesName = scanner.nextLine();
                    }else
                    { System.out.println("wrong input");
                        return;
                    }

                    p = series.refresh(SeriesName, spectacles,searchId);
                    if (p == 1) {
                        System.out.println("\nif you want to add actor enter 'yes' else something else  ");
                        choice2=scanner.nextLine();
                        if (Objects.equals(choice2, "yes")) {
                            id = series.refreshActorSeries(SeriesName, spectacles, actors, id,searchId);        // προσθήκη ηθοποιών
                        } else System.out.println("you do not want to add actor");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                case 6: System.out.println("\n Enter 'actor' or 'director' to search");                // αναζήτηση ηθοποιού η σκηνοθέτη
                    String option=scanner.nextLine() ;
                    if(option.isEmpty()) return;                                                   //αν ειναι κενο τερματιζει η εφαρμογη   
                    if(Objects.equals(option, "actor") )  actor.findActor(actors,spectacles);
                    else if (Objects.equals(option, "director") ) director.findDirector(directors,spectacles);
                    else System.out.println("wrong!!");
                        break;
                  
                case 7:
                    System.out.println("Log in to rate");
                    List<Spectacle> spectacleForRating = new ArrayList<>();         // λιστα για τα θεαματα που ειναι για βαθμολογηση
                    user = LogIn(users);                                            //κανει log in με την σηναρτηση που επιστρεφει user για να κανει βαθμολογησει
                    if (user == null)
                        break;
                    System.out.println("if you do not remember spectacle name or you want to search with year press '-' ");
                    System.out.println(" spectacle name  ");
                    String spectacleName = scanner.nextLine();
                    System.out.println("if you do not want to search with spectacle year press 0");    //Αν εχετε βαλει ονομα πατηστε 0 γιατι ισως ερθουν θεαματα που δεν θελετε
                    int year = 0;
                    do {
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    } while (input);


                    movie.search(spectacleName, year, spectacles, spectacleForRating);       // σηναρτηση για αναζητηση θεαματος
                    if (!spectacleForRating.isEmpty()) {                                     //επιστρεφει λιστα με τα θεαματα που ειναι για βαθμολογηση (spectacleForRating)
                        for (i = 0; i < spectacleForRating.size(); i++) {
                            System.out.println("\n" + spectacleForRating.get(i).getName());
                            System.out.println("Rate this spectacle from 0-10");
                            int ratingForSpectacle = scanner.nextInt();
                            scanner.nextLine();
                            Evaluation evaluation = new Evaluation(user.getName(), ratingForSpectacle);
                            spectacleForRating.get(i).addEvaluation(evaluation);
                        }
                    }
                    user.seeRatingEachUser(users, spectacleName, year, spectacles);            // οταν βαθμολογησεις τα θεαματα θα εμφανιστουν ολες οι βαθμολογιες
                    break;                                                                                    // και τα ονοματα των users για τα θεαματα αυτα

                case 8: System.out.println("Log in to see all ratings");
                    user = LogIn(users);
                    if (user == null)
                        break;
                    user.UsersRatings(user,spectacles);
                    break;
               
                case 9:  System.out.println("log in and add actors/directors in your favorites");
                    user=LogIn(users);
                    if (user == null)
                        break;
                    user.seeAllFavoritesActors();                                          //οταν κανεις log in βλεπεις αυτοματα τους αγαπημενους ηθοποιους/σκηνοθετες
                    user.seeAllFavoritesDirectors();
                    System.out.println("\nadd actor/director Enter 'actor' or 'director' ");
              
                    option=scanner.nextLine() ;                                            // διαλεγεις αν θελεις να προσθεσεις actor η director
                   if(option.isEmpty())return;                                   //αν ειναι κενο τερματιζει η εφαρμογη
                    
                   if(Objects.equals(option, "actor") )  user.addActorToFavorites(actors);
                    else if (Objects.equals(option, "director") ) user.addDirectorToFavorites(directors);
                    else System.out.println("wrong!!");
                    break;

                case 10:
                    spectacleId = spectacleId + 1;
                    episodes=new ArrayList<>();            //Νεα λίστα για εισαγωγή καινούργιων τιμών
                    SpectacleKind=new ArrayList<>();         // >>          >>           >>
                    spectacleActors=new ArrayList<>();       //         >>       >>       >>     >>

                    System.out.println("Enter the Mini-series name:");
                    String miniSeriesName = scanner.nextLine();
                   if(miniSeriesName.isEmpty()) return;                  //Αν ειναι κενο τερματιζει η εφαρμογη
                    System.out.println("Enter the Country:");
                    String miniSeriesCountry = scanner.nextLine();
                    if(miniSeriesCountry.isEmpty()) return;               //Αν ειναι κενο τερματιζει η εφαρμογη
                    series.addKind(SpectacleKind);

                    System.out.println("Enter the Year:");
                    int  miniSeriesYear = 0;
                    do {                                                   // βροχος μεχρι να βαλει αριθμο
                        try {
                            miniSeriesYear = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    } while (input);

                    System.out.println("Enter the Director:");
                    DirectorName = scanner.nextLine();
                    p= checkIfDirectorIsInSystem(DirectorName, directors);               // ελεγχει αν υπαρχει ο σκηνοθετης. Επιστρεφει 0 αν δεν υπαρχει.
                    if (p == 0) {                                                         //αν το p ειναι 0 ζηταει στοιχεια για τον σκηνοθετη
                        id = id + 1;                                                           // μοναδικο id
                        createDirector(DirectorName, directors, id);
                    }

                    System.out.println("put the sezon");
                    sezon = 0;
                    input = true;
                    do {
                        try {
                            sezon = Integer.parseInt(scanner.nextLine());
                            input = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                    } while (input);

                    for (i = 0; i < sezon; i++) {
                        System.out.println("put the episodes of" + " " + (i + 1) + " " + "sezon");
                        episodes.add(scanner.nextInt());
                    }
                    scanner.nextLine();             // Consume newline left-over
                    id=id+2;
                    id = createActor(actors, spectacleActors, id);
                    miniSeries = new MiniSeries(miniSeriesName, miniSeriesCountry, SpectacleKind,miniSeriesYear, spectacleActors, DirectorName, spectacleId, sezon, episodes);
                    spectacles.add(miniSeries);
                    break;

            }
        }
    }
    private static void SignIn(List<User>users){                       // κάνει εγγραφή ο χρηστής
        Scanner scan = new Scanner(in);
        System.out.println("\nwelcome you can sign in in the system!");
        System.out.println("Enter your name");
         String userName=scan.nextLine();
            if(userName.isEmpty()) System.exit(0);                                        // Αν ειναι κενο τερματιζει
        
            System.out.println("Enter your Email");
         String Email=scan.nextLine();
          if(Email.isEmpty()) System.exit(0);                                             // Αν ειναι κενο τερματιζει
        
          System.out.println("Enter your password");                          
         String password=scan.nextLine();
           if(password.isEmpty()) System.exit(0);                                             // Αν ειναι κενο τερματιζει
       
           User user=new User(userName,Email,password);                  // φτιάχνει εναν καινούργιο User με τα στοιχειά που δέθηκαν παραπάνω και τον προσθέτει στο σύστημα
        users.add(user);
        System.out.println("\nyou sing in successfully !!! ");
    }

    private static User LogIn(List<User> users){
        Scanner scan = new Scanner(in);
        int choice;
        System.out.print("email : ");
        String userEmail = scan.nextLine();
                                                 
        System.out.print("password : ");
        String password = scan.nextLine();
        for(User user:users){
            if (Objects.equals(userEmail, user.getEmail() ) && Objects.equals(password,user.getPassword())) {
                System.out.println("successful log in in system\n ");
                return user;
            }
        }
        System.out.println("!! your email or your password is mistake try again or sign in\n ! if you want to sign in Enter 1 or other number to try again");
        choice=0;
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }

        if(choice==1){
            SignIn(users);
        }
        return null;
    }

    public static int checkIfActorIsInSystem (String name, List < Actor > actors){
        for (int i = 0; i < actors.size(); i++) {
            if (Objects.equals(actors.get(i).getActorName(), name)) {
                System.out.println("actors is in the system:");
                System.out.println("  ActorName : "+actors.get(i).getActorName());
                System.out.println("  Actor country: "+actors.get(i).getCountry());
                System.out.println("  Actor id : "+actors.get(i).getId());
                return 1;
            }
        }
        return 0;
    }

    private static int checkIfDirectorIsInSystem (String name, List < Director > directors){
        for (int i = 0; i < directors.size(); i++) {
            if (Objects.equals(directors.get(i).getName(), name)) {
                System.out.println("director is in the system:");
                System.out.println("  Director name : "+directors.get(i).getName());
                System.out.println("  Director country : "+directors.get(i).getCountry());
                System.out.println("  Director id : "+directors.get(i).getId());

                return 1;
            }
        }
        return 0;
    }

    private static int createActor(List <Actor> actors, List<String> spectacleActors, int id){
        int p,k=0;
        String b; boolean input;

        do {
            input=true;
            System.out.println("Enter actor's name until 10 actors: ");
            Scanner scan = new Scanner(in);
            String ActorName = scan.nextLine();
              if(ActorName.isEmpty()) return 1;
          
              p = checkIfActorIsInSystem(ActorName, actors);                           //check if Actor is in  System
            if (p == 0) {
                System.out.println("Enter actor's data : ");
                k = k + 1;
                id = id + 1;
                System.out.println("Actor country");
                String country = scan.nextLine();
                System.out.println("Actor website");
                String website = scan.nextLine();
                System.out.println("Actor year");
                int year=0;
                do {
                    try {
                        year=Integer.parseInt(scan.nextLine());
                        input=false;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                }while(input);

                Actor  actor = new Actor(ActorName, country, website, year, id);    //δημιουργία actor
                actors.add(actor);                                                  // προσθήκη στο σύστημα
            }
            spectacleActors.add(ActorName);
            System.out.println("\nto continue input t or to exit input f");
            b = scan.nextLine();

        } while (k < 9 && Objects.equals(b, "t"));

        return id;
    }

    private static int createDirector(String DirectorName,List <Director> directors,int id){
      
        boolean input;

        input=true;
        System.out.println("Enter director's data : ");
        Scanner scan = new Scanner(in);
        System.out.println("Director country");
        String country = scan.nextLine();
        System.out.println("Director website");
        String website = scan.nextLine();
        System.out.println("Director year");
        int year=0;
        do {
            try {
                year=Integer.parseInt(scan.nextLine());
                input=false;
            } catch (NumberFormatException e) {                                              //έλεγχος μέχρι να δώσει αριθμό
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }while(input);

        Director  director = new Director(DirectorName, country, website, year, id);
        directors.add(director);
      

        return id;
    }





}

