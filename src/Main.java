import controller.Controller;
import repository.ClientRepository;
import repository.MovieRepository;
import view.ConsoleView;

/**
 * Created by Paul on 10/8/2016.
 */
public class Main {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        MovieRepository movieRepository = new MovieRepository();
        Controller controller = new Controller(clientRepository, movieRepository);
        ConsoleView consoleView = new ConsoleView(controller);
        consoleView.start();
    }
}
