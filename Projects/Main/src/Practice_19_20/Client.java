package Practice_19_20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        sendMessage("Message", "255.255.255.255", 6666);
        sendMessage("Hi", "255.255.255.255", 6666);
        sendMessage("How are you?", "255.255.255.255", 6666);
        sendMessage("Andrew, are you here?", "255.255.255.255", 6666);
    }

    public static void sendMessage(
            String message,
            String address,
            int port) throws IOException {
        String nickname = "Andrew";
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        Date currentDate = new Date();
        message = formater.format(currentDate) + " | " + nickname + ": " + message;
        DatagramSocket socket = new DatagramSocket();
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(
                data,
                0, data.length,
                InetAddress.getByName(address),
                port
        );
        socket.send(packet);
        byte[] buffer = new byte[2024];
        DatagramPacket packetToReceive = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        socket.receive(packetToReceive);
        System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
    }
}
