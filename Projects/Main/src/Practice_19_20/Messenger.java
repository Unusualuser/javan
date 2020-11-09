package Practice_19_20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Messenger {

    public static void main(String[] args) throws IOException {
        int port = 6666;
        DatagramSocket socket = new DatagramSocket(port);
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("Listening on " + port);
        File myFile = new File("src/Practice_19_20/history.txt");
        if (myFile.exists()) {
            myFile.delete();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nickname: ");
        String nickname = scanner.nextLine();
        while (true) {
            String mes = scanner.nextLine();

            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date currentDate = new Date();

            String fullMessage = formatter.format(currentDate) + " | " + nickname + ": " + mes;

            byte[] data = fullMessage.getBytes();
            DatagramPacket packet_2 = new DatagramPacket(
                    data,
                    0, data.length,
                    InetAddress.getByName("192.168.0.109"),
                    port
            );
            socket.send(packet_2);
            try {
                byte[] bufferForReceive = new byte[2024];
                DatagramPacket packetToReceive = new DatagramPacket(
                        bufferForReceive,
                        0,
                        bufferForReceive.length);
                socket.receive(packetToReceive);
                System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
                FileWriter writer = new FileWriter("src/Practice_19_20/history.txt", true);
                try {
                    writer.write(new String(packetToReceive.getData(), 0, packetToReceive.getLength()) + "\n");
                }
                catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            FileWriter writer = new FileWriter("src/Practice_19_20/history.txt", true);
            try {
                writer.write(fullMessage + "\n");
            }
             catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }
}
