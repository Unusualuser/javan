package Practice_19_20;

import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Messenger {
    static DatagramSocket socket;

    static {
        try {
            socket = new DatagramSocket(6666);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    static Runnable receiveThread = () -> {
        while (true) {
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
        }

    };

    static Runnable sendThread = () -> {
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("Listening on 6666");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nickname: ");
        String nickname = scanner.nextLine();
        while (true) {
            String mes = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date currentDate = new Date();
            String fullMessage = formatter.format(currentDate) + " | " + nickname + ": " + mes;
            byte[] data = fullMessage.getBytes();
            DatagramPacket packet_2 = null;
            try {
                packet_2 = new DatagramPacket(
                        data,
                        0, data.length,
                        InetAddress.getByName("25.55.174.180"),
                        6666
                );
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                socket.send(packet_2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileWriter writer = null;
            try {
                writer = new FileWriter("src/Practice_19_20/history.txt", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.write(fullMessage + "\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread send = new Thread(sendThread);
        Thread receive = new Thread(receiveThread);
        send.start();
        receive.start();
        send.join();
        receive.join();
    }
}
