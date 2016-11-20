package controller;

import model.Client;

import java.util.List;

/**
 * Created by Paul on 11/18/2016.
 */
public interface IClientController {
    void addClient(String name, String address);

    void deleteClient(int id);

    void updateClient(int id, String name, String address);

    List<Client> getClientsByAddress(String address);

    List<Client> getClientsByName(String name);

    List<Client> getClients();

    List<Client> getClientsSortedBy(boolean byName, boolean byAddress, boolean ascending);
}
