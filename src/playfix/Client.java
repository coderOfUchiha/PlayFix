/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playfix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author tariq
 */
public class Client {
     GUI_Design_PlayFix playfix = new GUI_Design_PlayFix();
     Socket socket;
    BufferedReader receivedMassage;
    PrintWriter sendMassage;
    public Client(){
//         
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                
//                
//                
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        }).start();
        
        try{
             
            socket = new Socket("127.0.0.1",6666);
            System.out.println("Server Connected Successfully");
            receivedMassage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMassage = new PrintWriter(socket.getOutputStream());
            readMassage();
            writeMassage();
          }catch(Exception e)
          {
              //e.printStackTrace();
              System.out.println("Connection Closed");
          }
            
            
        
        
    }
    public void readMassage(){
         Runnable r1 = ()->{
                
                try
                {
                  
                    
                    String Massage;
                    
                        Massage = receivedMassage.readLine();
                        if(Massage.equals("Over"))
                         {
                           System.out.println("Server terminated the chat");
                            socket.close();
                          
                        }
                        System.out.println("Server:"+Massage);
                     
                }catch(Exception ex){
                    //ex.printStackTrace();
                    System.out.println("Connection Closed");
                }
                
            };
            new Thread(r1).start();
    }
    public void writeMassage(){
         Runnable r2 =()->{
             try{
                
                String send;
                send = "Toxic Compiler";
                sendMassage.println(send);
                sendMassage.flush();
                if(send.equals("over"))
                {
                    socket.close();
                    
                }
                   
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
        };
         new Thread(r2).start();
        
    }
   
}
