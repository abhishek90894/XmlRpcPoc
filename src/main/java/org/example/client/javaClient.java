package org.example.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Vector;


public class javaClient {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Attempting to call XML-RPC Server...");


            // Create an instance of the XML-RPC client
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8082"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            // Create a Vector with the arguments to our method
            Vector<Integer> params = new Vector<>();
            params.addElement(10);
            params.addElement(27);

            // Call the remote method on the server and retrieve the result
            int result = (int) client.execute("sample.mul", params);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}
