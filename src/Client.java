import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    static Socket socket = null;
    static DataInputStream in = null;
    static DataOutputStream out = null;

    public static void main(String[] args)
    {
        try
        {
            socket = new Socket ( "localhost", 4000 );
            in = new DataInputStream ( socket.getInputStream ());
            out = new DataOutputStream ( socket.getOutputStream ());

            new Thread (() ->
            {
                Scanner sc = new Scanner ( System.in );
                while ( true )
                {
                    try
                    {
                        String message = sc.nextLine ();
                        out.writeUTF ( message );
                        if ( message.equals ( "/end" ))
                            break;
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start ();

            while ( true )
            {
                System.out.println ( in.readUTF ());
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
                if ( socket != null )
                    socket.close ();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
