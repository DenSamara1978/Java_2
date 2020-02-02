public class Main
{
    public static void main(String[] args)
    {
        String [][][] arr = {
                {{"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}},

                {{"11", "12", "13", "14"},
                {"21", "22", "23"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}},

                {{"11", "12", "13", "14"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}},

                {{"11.1", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}},

                {{"11", "12", "13", "14"},
                {"21", "22", "asd", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}}};

        for ( int i = 0; i < 5; i++ ) {
            try {
                System.out.println(calculate(arr [i]));
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage() + " Row: " + e.getRow() + ", col: " + e.getCol());
            }
        }

        System.out.println();
        
        for ( DayOfWeek day: DayOfWeek.values())
            System.out.println( "На " + day + " осталось рабочих часов: "+ getWorkingHours( day ) + ".");
    }


    private static int calculate ( String [][] arr ) throws MyArrayDataException, MyArraySizeException
    {
        int result = 0;
        if ( arr.length != 4 )
            throw new MyArraySizeException( "Incorrect size of array." );
        for ( int row = 0; row < 4; ++row )
        {
            if ( arr [row].length != 4 )
                throw new MyArraySizeException( "Incorrect size of array." );
            for ( int col = 0; col < 4; ++col )
            {
                try
                {
                    result += Integer.parseInt ( arr [row][col] );
                }
                catch ( NumberFormatException e )
                {
                    throw new MyArrayDataException ( "Incorrect format of cell data.", row, col );
                }
            }
        }
        return result;
    }

    private static String getWorkingHours( DayOfWeek day )
    {
        if ( day.isWeekEndDay())
            return "выходной день";
        int result = 0;
        boolean calculating = false;
        for ( DayOfWeek _day : DayOfWeek.values ())
        {
            if ( day == _day )
                calculating = true;
            if ( calculating )
                result += _day.getWorkingHours ();
        }
        return String.valueOf(result);
    }
}
