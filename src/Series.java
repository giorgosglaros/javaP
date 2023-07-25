import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

class Series extends Spectacle {
    private int seasons;
    private List<Integer> episodes;


    public Series(String name, String country, List<String> Kind, int year, List<String> actors, String director, int Id, int seasons, List<Integer> episodes) {
        super(name, country, Kind, year, actors, director, Id);
        this.seasons = seasons;
        this.episodes = episodes;
    }


    public int getSeasons() {
        return seasons;
    }

    public void setEpisodes(List<Integer> episodes) {
        this.episodes = episodes;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public List<Integer> getEpisodes() {
        return episodes;
    }




    public int refresh(String seriesName, List<Spectacle> spectacles,int searchId) {
        Scanner scan = new Scanner(System.in);

        for (Spectacle spectacle : spectacles) {
            if (spectacle instanceof MiniSeries) {
                MiniSeries miniSeries = (MiniSeries) spectacle;
                if (Objects.equals(seriesName, miniSeries.getName()) ||searchId==miniSeries.getId() ) {
                    System.out.println("The Mini-series exists!");
                    System.out.println("Series name: " + miniSeries.getName());
                    System.out.println("Series seasons: " + miniSeries.getSeasons());
                    System.out.println("Series episodes: " + miniSeries.getEpisodes());
                    System.out.println("Director: " + miniSeries.getDirector());
                    System.out.println("Actors: " + miniSeries.getActors());
                    System.out.println("\nAdd the number of seasons if you want, else press 0");
                    int seasonsToAdd = scan.nextInt();                 // αριθμος για επιπλεον σεζον
                    scan.nextLine(); // νεα γραμμη

                    if (seasonsToAdd > 0) {
                        int updatedSeasons = miniSeries.getSeasons() + seasonsToAdd;                      // αριθμος ειδη υπαρχον σεζον και καινουργιος
                        List<Integer> updatedEpisodes = new ArrayList<>(miniSeries.getEpisodes());

                        // Προσθήκη επεισοδίων για τις νέες σεζόν
                        for (int i = updatedEpisodes.size(); i < updatedSeasons; i++) {
                            System.out.println("Enter the number of episodes for season " + (i + 1));
                            int episodes = scan.nextInt();
                            updatedEpisodes.add(episodes);
                        }
                        // ανανεωση σειρας-μινισειρας με νεες τιμες
                        miniSeries.setSeasons(updatedSeasons);
                        miniSeries.setEpisodes(updatedEpisodes);
                        return 1;
                    }
                    return 1;
                }
            } else if (spectacle instanceof Series) {
                Series series = (Series) spectacle;
                if (Objects.equals(seriesName, series.getName()) || searchId==series.getId() ) {
                    System.out.println("The series exists!");
                    System.out.println("Series name: " + series.getName());
                    System.out.println("Series seasons: " + series.getSeasons());
                    System.out.println("Series episodes: " + series.getEpisodes());
                    System.out.println("Director: " + series.getDirector());
                    System.out.println("Actors: " + series.getActors());

                    System.out.println("\nAdd the number of seasons if you want, else press 0");
                    int seasonsToAdd = scan.nextInt();
                    scan.nextLine(); // Consume newline left-over

                    if (seasonsToAdd > 0) {
                        int updatedSeasons = series.getSeasons() + seasonsToAdd;
                        List<Integer> updatedEpisodes = new ArrayList<>(series.getEpisodes());

                        // Προσθήκη επεισοδίων για τις νέες σεζόν
                        for (int i = updatedEpisodes.size(); i < updatedSeasons; i++) {
                            System.out.println("Enter the number of episodes for season " + (i + 1));
                            int episodes = scan.nextInt();
                            updatedEpisodes.add(episodes);
                        }

                        // ανανεωση σειρας με νεες τιμες
                        series.setSeasons(updatedSeasons);
                        series.setEpisodes(updatedEpisodes);
                        return 1;
                    }
                    return 1;

                }
            }



        }
        System.out.println("The series does not exist!");
        return 0;




    }

    public int refreshActorSeries(String SeriesName, List<Spectacle> spectacles, List<Actor> actors, int id,int searchId) {
        Scanner scan = new Scanner(in);
        String b = "t";
        boolean input = true;
        for (Spectacle spectacle : spectacles) {
            if (spectacle instanceof MiniSeries) {
                MiniSeries miniSeries = (MiniSeries) spectacle;
                if (Objects.equals(SeriesName, miniSeries.getName()) || searchId==miniSeries.getId() )  {
                    while (miniSeries.getActors().size() < 10) {                   //ελέγχει αν υπαρχουν μεχρι 10 ηθοποιοι στη σειρα και να υπαρχουν σου εμφανίζει μηνυμα
                        if (Objects.equals(b, "f")) {
                            System.out.println("you press f !");
                            return id;
                        }
                        id = id + 2;                                        // μοναδικο id
                        System.out.println("\nEnter the name actor : ");
                        String ActorName = scan.nextLine();
                        miniSeries.addActor(ActorName);
                        int p = it22022.checkIfActorIsInSystem(ActorName, actors);

                        if (p == 0) {
                            System.out.println("Actor country");
                            String country = scan.nextLine();
                            System.out.println("Actor website");
                            String website = scan.nextLine();
                            System.out.println("Actor year");
                            int year=0;
                            do {                                                   // βροχος μεχρι να βαλει αριθμο
                                try {
                                    year = Integer.parseInt(scan.nextLine());
                                    input = false;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input! Please enter a valid number.");
                                }
                            } while (input);

                            Actor actor = new Actor(ActorName, country, website, year, id);
                            actors.add(actor);
                        }
                        System.out.println("If you want to stop to add actor press f or if do not want something else ");
                        b = scan.nextLine();
                    }
                    System.out.println("Sorry....but the series is full of Actors");
                    return id;
                }
            }

            if (spectacle instanceof Series) {
                Series series = (Series) spectacle;
                if (Objects.equals(SeriesName, series.getName()) || searchId==series.getId()) {
                    while (series.getActors().size() < 10) {                   //ελέγχει αν υπαρχουν μεχρι 10 ηθοποιοι στην σειρα και να υπαρχουν σου εμφανοζει μηνυμα
                        if (Objects.equals(b, "f")) {
                            System.out.println("you press f !");
                            return id;
                        }
                        id = id + 2;                                        // μοναδικο id
                        System.out.println("\nEnter the name actor : ");
                        String ActorName = scan.nextLine();
                        series.addActor(ActorName);
                        int p = it22022.checkIfActorIsInSystem(ActorName, actors);

                        if (p == 0) {
                            System.out.println("Actor country");
                            String country = scan.nextLine();
                            System.out.println("Actor website");
                            String website = scan.nextLine();
                            System.out.println("Actor year");
                            int year = scan.nextInt();
                            scan.nextLine();             // νεα γραμμη
                            Actor actor = new Actor(ActorName, country, website, year, id);
                            actors.add(actor);
                        }
                        System.out.println("If you want to stop to add actor press f or if do not want something else ");
                        b = scan.nextLine();
                    }
                    System.out.println("Sorry....but the series is full of Actors");

                }
            }

        }
        return id;
    }
}








