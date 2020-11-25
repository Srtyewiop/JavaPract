package ru.mirea.t19_20;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Server {

    static int offset = 0;
    static DatagramSocket dSocket;
    static DatagramPacket dpone;
    static DatagramPacket dpsecond;
    static StringBuilder historyStr = new StringBuilder();
    static HashMap<String, String> nickIPMap = new HashMap<>();
    static ArrayList<InetAddress> IPList = new ArrayList<>();
    static ArrayList<Integer> portList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[2048];
        String packetAddr;
        StringBuilder msgStr = new StringBuilder();
        String msg;
        dSocket = new DatagramSocket(9192);
        dpone = new DatagramPacket(buffer, offset, buffer.length);


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy [HH:mm]");
        Date date;
        File f = new File("src/ru/mirea/t19_20/history.txt");
        f.createNewFile();

        while (true) {
            dSocket.receive(dpone);
            msg = new String(buffer, offset, dpone.getLength());
            date = new Date();
            msgStr.append(dateFormat.format(date) + " ");
            packetAddr = dpone.getAddress().getHostAddress() + ":" + dpone.getPort();

            if (nickIPMap.get(packetAddr) == null || !portList.contains(dpone.getPort())) {
                nickIPMap.put(packetAddr, msg);
                System.out.println(packetAddr + " connected!");
                msgStr.append("<Server> Hello, " + msg);

                IPList.add(dpone.getAddress());
                portList.add(dpone.getPort());

            } else
                msgStr.append("<" + nickIPMap.get(packetAddr) + "> " + msg);

            for (int i = 0; i < IPList.size(); i++) {
                dpsecond = new DatagramPacket(
                        msgStr.toString().getBytes(),
                        offset,
                        msgStr.length(),
                        IPList.get(i),
                        portList.get(i));
                dSocket.send(dpsecond);
            }

            System.out.println(msgStr);
            historyStr.append(msgStr.toString() + "\n");
            msgStr = new StringBuilder();
            try (PrintWriter wf = new PrintWriter(f)) {
                wf.write(historyStr.toString());
            } catch (IOException e) {
                e.getStackTrace();
            }

        }
    }
}