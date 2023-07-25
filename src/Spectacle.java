import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;


public class Spectacle {
    private int id;
    private String name;
    private String country;
    private List<String> kind;
    private int year;
    private List<String> actors;
    private String director;
    private int rating;
    private List<Evaluation> evaluations;

    public Spectacle(String name, String country, List<String> kind, int year, List<String> actors,String director , int id) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.kind = kind;
        this.year = year;
        this.actors = actors;
        this.director = director;
        this.rating = 0;
        this.evaluations = new ArrayList<>();
    }

    public void addActor(String actorName) {
        actors.add(actorName);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getKind() {
        return kind;
    }


    public int getYear() {
        return year;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void addEvaluation(Evaluation evaluation) {                         // ελεγχει αν καποιος χρηστης εχει βαθμολογισει καποιο θεαμα ειδη
        String username = evaluation.getUsername();                            // τοτε διωχνει την παλια βαθμολογια και βαζει την καινουργια

        Evaluation OldEvaluation = getEvaluationByUsername(username);
        if (OldEvaluation != null) {
            evaluations.remove(OldEvaluation);
        }
        evaluations.add(evaluation);
    }


    public Evaluation getEvaluationByUsername(String username) {
        for (Evaluation evaluation : evaluations) {
            if (evaluation.getUsername().equals(username)) {
                return evaluation;
            }
        }
        return null;
    }
   
    
    public double getAverageRating() {
        if (evaluations.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Evaluation evaluation : evaluations) {
            sum += evaluation.getRating();
        }

        return (double) sum / evaluations.size();
    }


    public void search(String name, int year, List<Spectacle> spectacles, List<Spectacle> spectacleForRating) {

        for (Spectacle spectacle : spectacles) {
            if (spectacle instanceof MiniSeries) {
                MiniSeries miniSeries = (MiniSeries) spectacle;
                if (Objects.equals(name, miniSeries.getName()) || miniSeries.getYear() == year) {
                    System.out.println("\nthe spectacle exist!!");
                    System.out.println("\nMINI-SERIES ");
                    System.out.println("TITLE : " + miniSeries.getName());
                    System.out.println("ID : " + miniSeries.getId());
                    System.out.println("Actors : " + miniSeries.getActors());
                    System.out.println("sezon : " + miniSeries.getSeasons());
                    System.out.println("episodes : " + miniSeries.getEpisodes());
                    System.out.println("director : " + miniSeries.getDirector());
                    System.out.println("Average Rating: " + miniSeries.getAverageRating());
                    spectacleForRating.add(miniSeries);

                }

            } else if (spectacle instanceof Series) {
                Series series = (Series) spectacle;  // Cast the spectacle to series
                if (Objects.equals(name, series.getName()) || series.getYear() == year) {
                    System.out.println("\nthe spectacle exist!!");
                    System.out.println("\nSERIES ");
                    System.out.println("TITLE : " + series.getName());
                    System.out.println("ID : " + series.getId());
                    System.out.println("Actors : " + series.getActors());
                    System.out.println("sezon : " + series.getSeasons());
                    System.out.println("episodes : " + series.getEpisodes());
                    System.out.println("director : " + series.getDirector());
                    System.out.println("Average Rating: " + series.getAverageRating());
                    spectacleForRating.add(series);


                }

            } else {
             
                if (Objects.equals(name, spectacle.getName()) || spectacle.getYear() == year) {
                    System.out.println("\nthe spectacle exist!!");
                    System.out.println("MOVIE  ");
                    System.out.println("TITLE : " + spectacle.getName());
                    System.out.println("ID : " + spectacle.getId());
                    System.out.println("Actors : " + spectacle.getActors());
                    System.out.println("director : " + spectacle.getDirector());
                    System.out.println("AverageRating : " + spectacle.getAverageRating());
                    spectacleForRating.add(spectacle);


                }
            }


        }

        System.out.println(spectacleForRating.size());
        if (spectacleForRating.isEmpty()) {
            System.out.println("the spectacle(s) does not exist");

        }
    }

    public void addKind( List<String> SpectacleKind){                                 //βαζει το ειδος του θεαματος(drama,happy ...)
        Scanner scan = new Scanner(in);
        int i=0; String b="";
        do {
            System.out.println("input kind of movie (drama,happy...clt) until 3");
            SpectacleKind.add(scan.nextLine());
            i = i + 1;
            System.out.println("to continue input t or to exit input f");
            b = scan.nextLine();

        } while (i <= 2 && Objects.equals(b, "t"));
    }



    public void allSpectaclesPrint(List<Spectacle> spectacles) {
        for (Spectacle spectacle : spectacles) {
            if(spectacle instanceof MiniSeries){
                MiniSeries miniSeries= (MiniSeries) spectacle;
                System.out.println("\nminiSeries:");
                System.out.println("miniSeries NAME : "+miniSeries.getName());
               System.out.println("Kind:"+miniSeries.getKind());
                System.out.println("id : "+miniSeries.getId());
                System.out.println("Actors : "+miniSeries.getActors());
                System.out.println("Episodes : "+miniSeries.getEpisodes());
                System.out.println("Director : "+miniSeries.getDirector());
                System.out.println("Average rating "+miniSeries.getAverageRating());
            }
            else if (spectacle instanceof Series) {
                Series series = (Series) spectacle;  // Cast the spectacle to series
                System.out.println("\nSERIES :");
                System.out.println("SERIES NAME : "+series.getName());
                 System.out.println("Kind:"+series.getKind());
                System.out.println("id : "+series.getId());
                System.out.println("Actors : "+series.getActors());
                System.out.println("Episodes : "+series.getEpisodes());
                System.out.println("Director : "+series.getDirector());
                System.out.println("Average rating "+series.getAverageRating());
            } else {
                System.out.println("\nMOVIE : ");
                System.out.println("TITLE "+spectacle.getName());
                System.out.println("Id : "+spectacle.getId());
                System.out.println("Kind:"+spectacle.getKind());
                System.out.println("ACTORS : "+spectacle.getActors());
                System.out.println("Director : "+spectacle.getDirector());
                System.out.println("Average rating "+spectacle.getAverageRating());

            }
        }

    }


}


