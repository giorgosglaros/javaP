import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

public class Director {
    private  String name;
    private  String country;
    private  String website;
    private  int year;
    private  int id;

    public Director(String name, String country, String website, int year,int id) {
        this.name = name;
        this.country = country;
        this.website = website;
        this.year = year;
        this.id=id;
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



    public  void findDirector (List< Director > directors, List< Spectacle > spectacles){
        Scanner scan = new Scanner(in);
        boolean b=false;
        System.out.println("Enter director name");
        String name=scan.nextLine();
        for(Director director:directors){
            if(Objects.equals(director.getName(), name) ){
                System.out.println("\ndirector exist");
                System.out.println(" director Name : "+director.getName());
                System.out.println(" director Id : "+director.getId());
                b=true;
            }
        }

        if(!b) {
            System.out.println("\nthe director does not exist");
            return;
        }
        double ave=0.0;
        String spectacleAve="";
        System.out.println("\nSPECTACLES:");
        for (Spectacle spectacle : spectacles) {
          if(spectacle instanceof  MiniSeries miniSeries) {
                 if (Objects.equals(miniSeries.getDirector(), name)) {
                    System.out.println("TITLE : " + miniSeries.getName());
                    if (miniSeries.getAverageRating() > ave) {
                        ave = miniSeries.getAverageRating();
                        spectacleAve = miniSeries.getName();
                    }
                }

          }else if (spectacle instanceof Series series) {
                if (Objects.equals(series.getDirector(), name)) {
                    System.out.println("TITLE : " + series.getName());
                    if (series.getAverageRating() > ave) {
                        ave = series.getAverageRating();
                        spectacleAve = series.getName();
                    }
                }

             
            } else if (Objects.equals(spectacle.getDirector(), name)) {
                    System.out.println("TITLE : " + spectacle.getName());
                    if (spectacle.getAverageRating() > ave) {
                        ave = spectacle.getAverageRating();
                        spectacleAve = spectacle.getName();
                    }
                }
            
        }
        System.out.println("if you want to see the spectacle with max averageRating which director points out press 1");
        int option=scan.nextInt();
        if(option!=1)
            return;
        System.out.println("TITLE : "+spectacleAve);
        System.out.println("AverageRating : "+ave);
    }
}











