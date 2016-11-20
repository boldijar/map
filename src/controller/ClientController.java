package controller;

import model.Client;
import model.Movie;
import model.Rent;
import repository.BaseRepository;
import repository.ClientRepository;
import repository.MovieRepository;
import repository.RentRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Paul on 10/8/2016.
 */
public class ClientController implements IClientController {
    private final BaseRepository<Client> clientRepository;

    private int lastClientId = 0;

    public ClientController(BaseRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
        lastClientId = clientRepository.listAll().size();
    }

    @Override
    public void addClient(String name, String address) {
        clientRepository.add(new Client(lastClientId++, name, address));
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.remove(id);
    }

    @Override
    public void updateClient(int id, String name, String address) {
        clientRepository.update(new Client(id, name, address));
    }

    @Override
    public List<Client> getClientsByAddress(String address) {
        List<Client> clients = clientRepository.listAll();
        return clients.stream().filter(client -> client.getAddress().equals(address)).collect(Collectors.toList());
    }

    @Override
    public List<Client> getClientsByName(String name) {
        List<Client> clients = clientRepository.listAll();
        return clients.stream().filter(client -> client.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.listAll();
    }

    @Override
    public List<Client> getClientsSortedBy(boolean byName, boolean byAddress, boolean ascending) {
        List<Client> clients = getClients();
        Stream<Client> stream = clients.stream();
        if (byName) {
            stream = stream.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()));
        }
        if (byAddress) {
            stream = stream.sorted((o1, o2) -> o1.getAddress().compareTo(o2.getAddress()));
        }
        clients = stream.collect(Collectors.toList());
        if (ascending) {
            Collections.reverse(clients);
        }
        return clients;
    }
}
