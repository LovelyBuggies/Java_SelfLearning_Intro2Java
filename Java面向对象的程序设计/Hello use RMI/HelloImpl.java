

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

public class HelloImpl extends UnicastRemoteObject
    implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return  "OS of stdlss 77 is Mac";
    }

    @SuppressWarnings("deprecation")
	public static void main(String args[]) { 

        // Create and install a security manager 
        if (System.getSecurityManager() == null) { 
        	System.setSecurityManager(new RMISecurityManager()); 
       } 

        try { 
    	    HelloImpl obj = new HelloImpl(); 
    	    LocateRegistry.createRegistry(6600);  
    	    // Bind this object instance to the name "HelloServer" 
    	    Naming.rebind("rmi://127.0.0.1:6600/HelloServer", obj); 
    	    System.out.println("HelloServer bound in registry"); 
            } catch (Exception e) { 
    	    System.out.println("HelloImpl err: " + e.getMessage()); 
    	    e.printStackTrace(); 
            } 
        } 
    }
