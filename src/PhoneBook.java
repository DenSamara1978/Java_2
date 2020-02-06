import java.util.Map;
import java.util.TreeMap;

public class PhoneBook
{
    Map<String, String> phones;

    public PhoneBook ()
    {
        this.phones = new TreeMap<String, String>();
    }

    public void add ( String family, String phone )
    {
        if ( this.phones.containsKey ( family ))
            this.phones.put ( family, this.phones.get ( family ) + "," + phone );
        else
            this.phones.put ( family, phone );
    }

    public String get ( String family )
    {
        return this.phones.getOrDefault(family, "no");
    }
}
