package model.client;

public class ClientImpl implements Client {
    

    @Override
    public void insertClient(String name, String surname, String id) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getClient(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean searchClient(String id) {
        if(getClient(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public String getRoom(String id) {
        // TODO Auto-generated method stub
        //ci dovrà esssere un file con idcliente e id stanza
        return null;
    }

}
