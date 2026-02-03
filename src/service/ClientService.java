package service;

import exceptions.ClientAlreadyRegisteredException;
import exceptions.NoClientFoundException;
import model.Client;
import java.util.*;

public class ClientService {

    private final List<Client> clients;

    public ClientService(List<Client> clients) { this.clients = clients; }

    public void registerClient(Client client) {
        Client filter = this.clients.stream().filter(client1 -> client1.getCpf().equals(client.getCpf())).findFirst().orElse(null);
        if(!(filter == null)) throw new ClientAlreadyRegisteredException("CLIENT ALREADY REGISTERED.");
        this.clients.add(client);
    }
    public Client searchByCpf(String cpf){
        Client filter = this.clients.stream().filter(client -> client.getCpf().equals(cpf)).findFirst().orElse(null);
        if(filter == null) throw new NoClientFoundException("CLIENT NOT FOUND.");
        return filter;
    }
    public void removeClient(String cpf){
        this.clients.remove(searchByCpf(cpf));
    }
    public List<Client> listAll(){ return List.copyOf(this.clients); }
    public List<Client> listActives(){
        List<Client> filter = this.clients.stream().filter(client -> client.getQtdLoansNow() > 0).toList();
        if(filter.isEmpty()) throw new NoClientFoundException("NO CLIENT FOUND.");
        return filter;
    }

}
