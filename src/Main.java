import java.util.LinkedHashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        String[] array = { "Third", "Eleventh", "Fifth", "Secondary", "Fourth", "Twelfth", "Tenth", "Primary", "Sixth", "Secondary", "Eighth", "Secondary", "Primary", "Ninth", "Seventh" };

        Map<String, Integer> map = new LinkedHashMap<String, Integer> ();
        for ( String str: array )
            map.put ( str, map.containsKey ( str ) ? map.get ( str ) + 1 : 1 );
        for ( Map.Entry<String, Integer> entry : map.entrySet ())
            System.out.println ( "Слово " + entry.getKey () + " встретилось " + entry.getValue () + " раз(а).");


        System.out.println ();

        PhoneBook book = new PhoneBook ();
        book.add ( "Ivanov", "+71112223344" );
        book.add ( "Petrov", "+71112223355" );
        book.add ( "Ivanov", "+71112223366" );
        book.add ( "Boshirov", "+71112223377" );

        String family = "Ivanov";
        System.out.println ( "The phone number(s) of " + family + " is(are) " + book.get ( family ));
        family = "Petrov";
        System.out.println ( "The phone number(s) of " + family + " is(are) " + book.get ( family ));
        family = "Sidorov";
        System.out.println ( "The phone number(s) of " + family + " is(are) " + book.get ( family ));
    }
}
