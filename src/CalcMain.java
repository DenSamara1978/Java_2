import java.lang.reflect.Array;

public class CalcMain
{
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args)
    {
        System.out.println( "Single threaded method have worked " + singleThreadMethod () + " milliseconds." );
        System.out.println( "Double threaded method have worked " + doubleThreadMethod () + " milliseconds." );
    }

    private static long singleThreadMethod ()
    {
        float[] arr = new float[size];
        for ( int i = 0; i < size; ++i )
            arr [i] = 1.0f;

        long start = System.currentTimeMillis();

        for ( int i = 0; i < size; ++i )
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        return System.currentTimeMillis() - start;
    }

    private static long doubleThreadMethod ()
    {
        float[] arr = new float[size];
        for ( int i = 0; i < size; ++i )
            arr [i] = 1.0f;

        long start = System.currentTimeMillis();

        float[] arr1 = new float [h];
        float[] arr2 = new float [h];
        System.arraycopy ( arr, 0, arr1, 0, h );
        System.arraycopy ( arr, h, arr2, 0, h );

        MyThread t1 = new MyThread ();
        MyThread t2 = new MyThread ();
        t1.setParam ( arr1, 0 );
        t2.setParam ( arr2, h );
        t1.start ();
        t2.start ();
        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.arraycopy ( arr1, 0, arr, 0, h );
        System.arraycopy ( arr2, 0, arr, h, h );

        return System.currentTimeMillis() - start;
    }
}
