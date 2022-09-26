/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tariq
 */
public class Server {
    ServerSocket server;
    Socket socket;
    BufferedReader receivedMassage;
    PrintWriter sendMassage;
    String recMsg;
    int i=6666;
    GUI_Design_PlayFix playfix = new GUI_Design_PlayFix();
    int sum=600000;
    
    
    
     
    
    public Server(){
        
        try{
            while(true)
            {
                server = new ServerSocket(i);
                System.out.println("Waiting...");
                socket = server.accept();
                receivedMassage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sendMassage = new PrintWriter(socket.getOutputStream());
               readMassage();
            
                recMsg=receivedMassage.readLine();
                sum = sum+5000;
               // System.out.println(recMsg);
                System.out.println(sum);
      
                String msg;
                
                writeMassage();
                socket.close();
                server.close();
        new Thread(new Runnable() {
            @Override
            public void run() {
                  
                Scanner sc = new Scanner(System.in);
                String send;
                System.out.println("Server:");
                send = sc.nextLine();
                if(send.equals("sold"))
                {
                    sum = 600000;
                }

               

//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }).start();

      
     }
            
            //
         
            
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    public void readMassage(){
            Runnable r1 = ()->{
               
                try{
                   
                          String Massage;
                        Massage = receivedMassage.readLine();
                        if(Massage.equals("Over"))
                         {
                           System.out.println("Client terminated the chat");
                           socket.close();  
                        }
                        
                        System.out.println(Massage);  
                    
                }catch(Exception e){
                    //e.printStackTrace();
                    System.out.println("Connection Closed");
                }
                
            };
            new Thread(r1).start();
        }
    public void  writeMassage(){
        Runnable r2;
        r2 = ()->{
            try{
                
                Scanner sc = new Scanner(System.in);
                String send;
                System.out.println("server:");
                send = sc.nextLine();
                
                
//                BufferedReader sendingText = new BufferedReader(new InputStreamReader(System.in));
//                String send;
//                send = sendingText.readLine();
//                sendMassage.println(send);
//                sendMassage.flush(); 
                if(send.equals("sold"))
                {
                     sum =600000;
                       
                    
                }
                
                
            }catch(Exception e){
                //e.printStackTrace();
                System.out.println("Connection Closed");
            }
        };
         new Thread(r2).start();
         
    }

}
