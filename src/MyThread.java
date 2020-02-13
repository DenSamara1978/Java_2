public class MyThread extends Thread
{
    private float array [];
    private int startIndex;

    @Override
    public void run ()
    {
        super.run ();
        for ( int i = 0; i < this.array.length; ++i )
        {
            int index = i + this.startIndex;
            this.array[i] = (float) (this.array[i] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        }
    }

    public void setParam ( float array[], int startIndex )
    {
        this.array = array;
        this.startIndex = startIndex;
    }

    public float[] getParam ()
    {
        return this.array;
    }
}
