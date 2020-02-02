public enum DayOfWeek
{
    MONDAY ( false, 8 ),
    TUESDAY ( false, 8 ),
    WEDNESDAY ( false, 8 ),
    THIRSDAY ( false, 8 ),
    FRIDAY ( false, 7 ),
    SATURDAY ( true, 0 ),
    SUNDAY ( true, 0 );

    private boolean isWeekEndDay;
    private int workingHours;

    DayOfWeek ( boolean isWeekEndDay, int workingHours )
    {
        this.isWeekEndDay = isWeekEndDay;
        this.workingHours = workingHours;
    }

    public int getWorkingHours ()
    {
        return this.workingHours;
    }

    public boolean isWeekEndDay ()
    {
        return this.isWeekEndDay;
    }
}
