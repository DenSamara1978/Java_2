import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    static ServerSocket server = null;
    static Socket socket = null;
    static DataInputStream in = null;
    static DataOutputStream out = null;
    static Thread consoleThread = null;

    public static void main(String[] args)
    {
        try
        {
            server = new ServerSocket ( 4000 );
            System.out.println ( "Сервер запустился" );
            socket = server.accept ();
            System.out.println ( "Клиент поключился" );
            in = new DataInputStream ( socket.getInputStream ());
            out = new DataOutputStream ( socket.getOutputStream ());

            consoleThread = new Thread (() ->
            {
                Scanner sc = new Scanner ( System.in );
                while ( true )
                {
                    try
                    {
                        String message = sc.nextLine();
                        out.writeUTF(message);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            });

            consoleThread.start ();

            while ( true )
            {
                String message = in.readUTF ();
                if ( message.equals ( "/end" ))
                {
                    System.out.println ( "Клиент отключился" );
                    break;
                }
                System.out.println ( message );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( in != null )
                    in.close ();
                if ( out != null )
                    out.close ();
                if ( socket != null )
                    socket.close ();
                if ( server != null )
                    server.close ();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println ( "Сервер остановлен" );
    }

}
