package controller.Client;


import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import model.client.Client;
import model.client.ClientImpl;
import model.file.MyFile;
import model.file.MyFileImpl;

public class ControllerClientImpl implements ControllerClient {

    private final List<Client> list = new LinkedList<>();
    private Set<String> lists = new TreeSet<>();
    private final URL clientUrl;
    private final String nameFile = "Clients.txt";
    private MyFile myfile;

    public ControllerClientImpl() {
        clientUrl = ClassLoader.getSystemResource(nameFile);
        myfile = new MyFileImpl(clientUrl);
        lists = myfile.fileReader();
        for (var i: lists) {
            list.add(new ClientImpl(i));
        }
    }
 
    @Override
    public final Set<String> getAllClient() {
        return lists;
    }

    @Override
    public final void insertClient(final String name, final String surname, final String id) {
        lists.add(name + "." + surname + "." + id);
        list.add(new ClientImpl(name, surname, id));
        myfile.fileWriter(name + "." + surname + "." + id);
    }

    @Override
    public final Client getClient(final String id) {
        for (var i: list) {
            if ((i.getId()).equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public final Boolean searchClient(final String id) {
       if (myfile.fileSearch(id) != null) {
           return true;
       }
        return false;
    }

    @Override
    public final Boolean deleteLine(final String id) {
        if (this.searchClient(id)) {
            if (myfile.deleteline(id)) {
                return true;
            }
        }
        return false;
    }

}
