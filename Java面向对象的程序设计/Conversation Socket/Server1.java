
import java.io.*;
import java.net.*;

class Server
{
  public ServerSocket svrSocket = null;
  public Socket socket = null;
  public InputStream inputStream = null;
  public OutputStream outputStream = null;
  public DataInputStream datainputStream = null;
  public PrintStream printStream = null;
  public DataOutputStream dataoutputStream = null;
  public String message;
  public BufferedReader charStream = new BufferedReader(new InputStreamReader(System.in));

  public Server() {
    try {
      svrSocket = new ServerSocket(1053);
      System.out.println("\nInitializing Port...");
      System.out.println("\nListen...");
      socket = svrSocket.accept();
      System.out.println("\nConnect to Client!\n");
      inputStream = socket.getInputStream();
      datainputStream = new DataInputStream(inputStream);
      outputStream = socket.getOutputStream();
      dataoutputStream = new DataOutputStream(outputStream);

      message = datainputStream.readUTF();
      System.out.println(message + "\n");
      System.out.println("Server is built!\n");
    }
    catch( UnknownHostException e) {
      System.out.println("Error : Cannot find server." + e);
    }
    catch( IOException e ) {
      System.out.println("Error : I/O Error." + e);
    }
  }

public void readSocket(){
    try {
      message = datainputStream.readUTF();
      if (message.length() > 0) {
      System.out.println("=> " + message + "\n");
    }
      if(message.equals("Exit")){
        System.exit(0);
      }
    }
    catch( UnknownHostException e) {
      System.out.println("Error : Cannot find server." + e);
    }
    catch( IOException e ) {
      System.out.println("Error : I/O Error." + e);
    }
  }

  public void writeSocket(){
    try {
      message = charStream.readLine();
      dataoutputStream.writeUTF(message);
      if (!message.equals("Exit")) return;
      else { dataoutputStream.writeUTF("Exit");
             System.exit(0); }
    }
    catch( UnknownHostException e) {
      System.out.println("Error : Cannot find server." + e);
    }
    catch( IOException e ) {
      System.out.println("Error : I/O Error." + e);
    }
  }
  public static void main(String args[]) {
    Server svr = new Server();
    for(;;){
      svr.writeSocket();
      svr.readSocket();
    }
  }
}
// End of Server

