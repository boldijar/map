import controller.ClientController;
import controller.MovieController;
import model.Client;
import model.IndexedModel;
import org.junit.Assert;
import org.junit.Test;
import repository.BaseRepository;
import repository.ClientRepository;

/**
 * Created by Paul on 11/5/2016.
 */
public class RepoTests {

    @Test
    public void repoTest() {
        BaseRepository<Client> repo = new BaseRepository<>();
        repo.add(new Client(1, "Paul", "Repulicii"));
        Assert.assertEquals(1, repo.listAll().size());
        repo.add(new Client(2, "Paul2", "Repulicii"));
        repo.add(new Client(3, "Paul3", "Repulicii"));
        Assert.assertEquals(3, repo.listAll().size());
        repo.update(new Client(3, "Raul", "Raul"));
        Assert.assertEquals("Raul", repo.listAll().get(2).getName());
        repo.remove(2);
        Assert.assertEquals(2, repo.listAll().size());
    }

    @Test
    public void controllerTest() {
        ClientController clientController = new ClientController(new BaseRepository<>());
        clientController.addClient("Paul", "Cluj");
        clientController.addClient("Raul", "Cluj");
        clientController.addClient("Paul", "Brasov");
        clientController.addClient("Naul", "Cluj");
        Assert.assertEquals("Brasov", clientController.getClientsByAddress("Brasov").get(0).getAddress());
        Assert.assertEquals(2, clientController.getClientsByName("Paul").size());


        MovieController movieController = new MovieController(new BaseRepository<>());
        movieController.addMovie("Paul", "Cluj");
        movieController.addMovie("Raul", "Cluj");
        movieController.addMovie("Paul", "Brasov");
        movieController.addMovie("Naul", "Cluj");
        Assert.assertEquals("Brasov", movieController.getMoviesByType("Brasov").get(0).getType());
        Assert.assertEquals(2, movieController.getMoviesByDirector("Paul").size());
    }

    @Test
    public void sortTest() {
        ClientController clientController = new ClientController(new BaseRepository<>());
        clientController.addClient("Baul", "Cluj");
        clientController.addClient("Aaul", "Cluj");
        clientController.addClient("Zaul", "Cluj");

        Assert.assertEquals("Aaul", clientController.getClientsSortedBy(true, false, false).get(0).getName());

    }
}
