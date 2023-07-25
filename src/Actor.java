import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

public class Actor  {
    private String ActorName;
    private String country;
    private String website;
    private int year;
    private int id;

    public Actor(String ActorName, String country, String website, int year,int id) {
        this.ActorName = ActorName;
        this.country = country;
        this.website = website;
        this.year = year;
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public String getCountry() {
        return country;
    }
    public String getActorName() {
        return ActorName;
    }

    public  void findActor (List< Actor > actors,List< Spectacle > spectacles){
        Scanner scan = new Scanner(in);
        boolean b=false;
        System.out.println("Enter actor name");
        String name=scan.nextLine();
            if(name.isEmpty()) System.exit(0);                                 // αν ειναι κενο τερματιζει
        for(Actor actor:actors){
            if(Objects.equals(actor.getActorName(), name) ){
                System.out.println("\nActor exist");
                System.out.println(" Actor Name : "+actor.getActorName());
                System.out.println(" Actor Id : "+actor.getId());
                b=true;
            }
        }

        if(!b) {
            System.out.println("\nthe actor does not exist");
            return;
        }
        double ave=0.0;
        String spectacleAve="";
        System.out.println("\nSPECTACLES:");
        for (Spectacle spectacle : spectacles) {
            if(spectacle instanceof  MiniSeries miniSeries) {
                for (int i=0;i<miniSeries.getActors().size();i++) {
                    if (Objects.equals(miniSeries.getActors().get(i), name)) {
                        System.out.println("TITLE : " + miniSeries.getName());
                        if (miniSeries.getAverageRating() > ave) {
                            ave = miniSeries.getAverageRating();
                            spectacleAve = miniSeries.getName();
                        }
                    }
                }

            }  else if (spectacle instanceof Series series) {
                for (int i=0;i<series.getActors().size();i++) {
                    if (Objects.equals(series.getActors().get(i), name)) {
                        System.out.println("TITLE : " + series.getName());
                        if (series.getAverageRating() > ave) {
                            ave = series.getAverageRating();
                            spectacleAve = series.getName();
                        }
                    }
                }
            } else
            {
                for (int i=0;i<spectacle.getActors().size();i++) {
                    if (Objects.equals(spectacle.getActors().get(i), name)) {
                        System.out.println("TITLE : " + spectacle.getName());

                        if (spectacle.getAverageRating() > ave) {
                            ave = spectacle.getAverageRating();
                            spectacleAve = spectacle.getName();
                        }
                    }
                }

            }
        }
        System.out.println("if you want to see the spectacle with max averageRating which actor points out press 1");
        int option=scan.nextInt();
        if(option!=1)
            return;
        System.out.println("TITLE : "+spectacleAve);
        System.out.println("AverageRating : "+ave);
    }


}
