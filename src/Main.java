import controller.ClientController;
import controller.IClientController;
import controller.IMovieController;
import controller.MovieController;
import repository.ClientRepository;
import repository.MovieRepository;
import repository.RentRepository;
import view.ConsoleView;

/**
 * Created by Paul on 10/8/2016.
 */
public class Main {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        MovieRepository movieRepository = new MovieRepository();
        RentRepository rentRepository = new RentRepository();
        IClientController clientController = new ClientController(clientRepository);
        IMovieController movieController = new MovieController(movieRepository);
        ConsoleView consoleView = new ConsoleView(clientController, movieController);
        consoleView.start();
    }
}
