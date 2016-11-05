import model.Client;
import model.IndexedModel;
import org.junit.Assert;
import org.junit.Test;
import repository.BaseRepository;

/**
 * Created by Paul on 11/5/2016.
 */
public class RepoTests {

    @Test
    public void repoTest() {
        BaseRepository<Client> repo = new BaseRepository<>();
        repo.add(new Client(1, "Paul", "Repulicii"));
        Assert.assertEquals(1,repo.listAll().size());
        repo.add(new Client(2, "Paul2", "Repulicii"));
        repo.add(new Client(3, "Paul3", "Repulicii"));
        Assert.assertEquals(3,repo.listAll().size());
        repo.update(new Client(3,"Raul","Raul"));
        Assert.assertEquals("Raul",repo.listAll().get(2).getName());
        repo.remove(2);
        Assert.assertEquals(2,repo.listAll().size());
    }

    public void controllerTest(){

    }
}
