package main.java.calculator_utility;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
---> This class is used to check internet and VPN connectivity
 */

public class InternetAvailabilityChecker {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static boolean isInternetAvailable() throws IOException {
        //specifying vpn hostname and google hostname
        return isHostAvailable("https://webvpn.mobiquityinc.com") && isHostAvailable("google.com");

    }

    //method to check socket connectivity to the host
    private static boolean isHostAvailable(String hostName) throws IOException {
        try (Socket socket = new Socket()) {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        } catch (IOException e) {
            System.out.println(ANSI_RED + "\nInternet or VPN is not connected or very slow : " + ANSI_RESET + e);
            System.exit(0);
            return false;
        }
    }
}