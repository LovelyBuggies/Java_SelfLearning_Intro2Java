
import java.net.*;
import java.io.*;

class Client {

  public static void main(String args[]) {
  // Initialize the stream 
  OutputStream outputStream = null;
  DataOutputStream dataoutputStream = null;
  InputStream inputStream = null;
  DataInputStream datainputStream = null;
  BufferedReader charStream = null;

  // Initialize Socket
  Socket socket = null;
  String message;

  try {
      charStream = new BufferedReader(new InputStreamReader(System.in));
      message = new String("Hi! I am a client");
      socket = new Socket("127.0.0.1", 1053);
      datainputStream = new DataInputStream(inputStream);
      outputStream = socket.getOutputStream();
      dataoutputStream = new DataOutputStream(outputStream);
      dataoutputStream.writeUTF(message);
   } catch(UnknownHostException e) {
        System.out.println("Error : Cannot find server." + e);
     }
     catch(IOException e) {
       System.out.println("Error : I/O Error." + e);
     }

 while(true) {
   try {
        inputStream = socket.getInputStream();
        datainputStream = new DataInputStream(inputStream);
        message = charStream.readLine();
        dataoutputStream.writeUTF(message);
        message = datainputStream.readUTF();
        if (message.length() > 0) {
          System.out.println("=> " + message + "\n");
      }
        if(message.equals("Exit")){
          System.exit(0);
        }
    } catch(UnknownHostException e) {
        System.out.println("Error : Cannot find server." + e);
      }
      catch(IOException e) {
        System.out.println("Error : I/O Error." + e);
        return;
      }
  } // end of while
 } // end of main method
} // end of Client Constructor
