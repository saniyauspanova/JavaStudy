package Models;

import java.time.LocalDateTime;

public class ClientTransaction {
    public int Id;
    public LocalDateTime CreateDate;
    public int ClientId;
    public Client Client;

    public ClientTransaction(int id, int clientId, LocalDateTime createDate) {
        Id = id;
        ClientId = clientId;
        CreateDate = createDate;
    }
}
