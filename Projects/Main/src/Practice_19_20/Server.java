package Practice_19_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("Listening on 6666");
        File myFile = new File("src/Practice_19_20/history.txt");
        if (myFile.exists()) {
            myFile.delete();
        }
        while (true) {
            socket.receive(packet);
            String message = new String(buffer, 0, packet.getLength());
            FileWriter writer = new FileWriter("src/Practice_19_20/history.txt", true);
            try {
                writer.write(message + "\n");
            }
             catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }

            System.out.println(message);

            byte[] data = ("Echo " + message).getBytes();
            DatagramPacket packetToSend = new DatagramPacket(
                    data,
                    0, data.length,
                    packet.getAddress(),
                    packet.getPort()
            );
            socket.send(packetToSend);
        }
    }
}
