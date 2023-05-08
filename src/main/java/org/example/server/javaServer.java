package org.example.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

 public  class javaServer {

     public int mul(int x, int y) {
         return x * y;

     }



         public static void main(String[] args) throws Exception {
             try {
                 WebServer server = new WebServer(8082);
                 XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
                 PropertyHandlerMapping handlerMapping = new PropertyHandlerMapping();

                 handlerMapping.addHandler("sample", javaServer.class);
                 xmlRpcServer.setHandlerMapping(handlerMapping);

                 server.start();

                 System.out.println("Server ready to receive requests!");

             } catch (Exception e) {
                 System.err.println("JavaServer error: " + e.getMessage());
             }

         }
     }

