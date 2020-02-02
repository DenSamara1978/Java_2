public class MyArrayDataException extends RuntimeException
{
    private int row;
    private int col;

    public MyArrayDataException ( String name, int row, int col )
    {
        super ( name );
        this.row = row;
        this.col = col;
    }

    public int getRow ()
    {
        return this.row;
    }

    public int getCol ()
    {
        return this.col;
    }
}
