import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

class User {
    private String name;
    private String email;
    private String password;
    private List<Evaluation> evaluations;
    private List<Actor>favoritesActors;
    private List<Director>favoritesDirectors;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.evaluations = new ArrayList<>();
        this.favoritesActors=new ArrayList<>();
        this.favoritesDirectors=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public List<Actor> getFavoritesActors() {
        return favoritesActors;
    }

    public void setFavoritesActors(List<Actor> favoritesActors) {
        this.favoritesActors = favoritesActors;
    }

    public List<Director> getFavoritesDirectors() {
        return favoritesDirectors;
    }

    public void setFavoritesDirectors(List<Director> favoritesDirectors) {
        this.favoritesDirectors = favoritesDirectors;
    }

    
    public void UsersRatings(User user, List<Spectacle> spectacles) {
        for (Spectacle spectacle : spectacles) {
            System.out.println("\nTITLE : " + spectacle.getName());
            Evaluation userEvaluation = spectacle.getEvaluationByUsername(user.getName());
            if (userEvaluation != null) {
                System.out.println("User : " + userEvaluation.getUsername());
                System.out.println("Rating : " + userEvaluation.getRating());

            }else System.out.println("you have not rate this spectacle\n");

        }

    }


    public void seeAllFavoritesActors(){
        if(favoritesActors.isEmpty()) {
            System.out.println("you do not have actors in your favorites");
            return;
        }
        System.out.println("Actors in your favorites:");
        for (Actor favoritesActor : favoritesActors)
            System.out.println("  "+favoritesActor.getActorName());
    }


    public  void addActorToFavorites(List<Actor>actors){
        Scanner scan = new Scanner(in);
        System.out.println("Enter actor's name ");
        String actorName=scan.nextLine();
        for(Actor favoriteactor:favoritesActors){
            if(Objects.equals(favoriteactor.getActorName(), actorName) ){             //ελεγχει αν υπαρχει ειδη στα αγαπημενα
                System.out.println("Actor exist already in favorites ");
                return;
            }
        }
        for(Actor actor :actors){
            if(Objects.equals(actor.getActorName(), actorName) ){
                favoritesActors.add(actor);
                System.out.println("\nActor added in your favorites");      // προσθετει τον actor στα αγαπημενα
                return;
            }
        }
        System.out.println("\nthe actor does not exist");

    }

    
    public void seeAllFavoritesDirectors(){                                          // βλεπεις κατευθειαν τους αγαπημενου (αν εχεις)
        if(favoritesDirectors.isEmpty()) {
            System.out.println("\nyou do not have directors in your favorites"); 
            return;
        }
        System.out.println("\nDirectors in your favorites:");
        for (Director favoritesDirector : favoritesDirectors)
            System.out.println("  "+favoritesDirector.getName());
    }

  
    public  void addDirectorToFavorites(List<Director>directors){
        Scanner scan = new Scanner(in);
        System.out.println("Enter director's name ");
        String directorName=scan.nextLine();
 for(Director favoriteDirector:favoritesDirectors){
            if(Objects.equals(favoriteDirector.getName(), directorName) ){             //ελεγχει αν υπαρχει ειδη στα αγαπημενα
                System.out.println("Director exist already in favorites ");
                return;
            }
        }
        
        
        for(Director director :directors){
            if(Objects.equals(director.getName(), directorName)){
                favoritesDirectors.add(director);
                System.out.println("\nDirector added in your favorites");          // προσθηκη στα αγαπημενα
                return;
            }
        }
        System.out.println("\nthe Director does not exist");

    }



    
    public  void seeRatingEachUser(List<User>users,String name,int year, List<Spectacle> spectacles) {

        for (Spectacle spectacle : spectacles) {
            if (spectacle instanceof MiniSeries) {
                MiniSeries miniSeries = (MiniSeries) spectacle;                         // Cast the spectacle to series
                if (Objects.equals(name, miniSeries.getName()) || miniSeries.getYear() == year) {
                    System.out.println("\nMINISERIES :");
                    System.out.println("TITLE :" + miniSeries.getName());
                    for (User user : users) {
                        Evaluation userEvaluation = miniSeries.getEvaluationByUsername(user.getName());
                        if (userEvaluation != null) {
                            System.out.println("\nUser : " + userEvaluation.getUsername());
                            System.out.println("Rating : " + userEvaluation.getRating());
                        }
                    }
                }
            }
            else if (spectacle instanceof Series) {
                Series series = (Series) spectacle;                              // Cast the spectacle to series
                if (Objects.equals(name, series.getName()) || series.getYear() == year) {
                    System.out.println("\nSERIES :");
                    System.out.println("TITLE :" + series.getName());
                    for (User user : users) {
                        Evaluation userEvaluation = series.getEvaluationByUsername(user.getName());
                        if (userEvaluation != null) {
                            System.out.println("\nUser : " + userEvaluation.getUsername());
                            System.out.println("Rating : " + userEvaluation.getRating());
                        }
                    }
                }


            } else {
                Spectacle movie = spectacle;                                                   // Cast the spectacle to series
                if (Objects.equals(name, movie.getName()) || movie.getYear() == year) {
                    System.out.println("\nMOVIE : ");
                    for (User user : users) {
                        Evaluation userEvaluation = movie.getEvaluationByUsername(user.getName());
                        if (userEvaluation != null) {
                            System.out.println("\nTITLE :" + movie.getName());
                            System.out.println("User : " + userEvaluation.getUsername());
                            System.out.println("Rating : " + userEvaluation.getRating());
                        }
                    }
                }
            }
        }
    }

}
