package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controllers.ClientRequestController;
import controllers.LogController;
import request.ClientRequest;
import response.ServerResponse;

class ClientHandler implements Runnable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void run() {
        try {
            ClientRequest clientRequest = (ClientRequest) in.readObject();
            ServerResponse serverResponse = ClientRequestController.executeClientRequest(clientRequest);
            out.writeObject(serverResponse);
            LogController.info("Запрос клиента " + clientRequest.getStringParam("client_name") + " обработан!");
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            LogController.error(e.getMessage());
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                LogController.error(e.getMessage());
            }
        }
    }
}
