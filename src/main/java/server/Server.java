package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controllers.LogController;

public class Server {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public Server(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    public void serve() {
        try {
            LogController.serverInfo("Сервер запущен на порту " + serverSocket.getLocalPort());
            while (true) {
                pool.execute(new ClientHandler(serverSocket.accept()));
            }
        } catch (IOException ex) {
            LogController.serverError(ex.getMessage());
            LogController.serverInfo("Выключение сервера...");
            pool.shutdown();
        }
    }
}

