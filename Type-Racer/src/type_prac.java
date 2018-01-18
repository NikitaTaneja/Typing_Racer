public class type_prac
{
    // variables
    private StringBuilder para;
    private int index;          //For para
    private int mistakes;
    private long startTime;
    private long TimeDuration;
    private long pauseTime;
    //contructor
    // merge both const into one
    // after test is finished delete starttime and all unnecessary variables :P
    type_prac()
    {
        pauseTime=0;
        TimeDuration=-1;
        mistakes=0;
        para.append("C++ implementation to print numbers in the range 1 to n");
    }
    type_prac(String str)
    {
        pauseTime=0;
        TimeDuration=-1;
        mistakes=0;
        para.append(str);
    }
    public void start_test()
    {
       startTime = System.currentTimeMillis();
    }
    public void stop_test()
    {
        TimeDuration = System.currentTimeMillis()-startTime;
    }
    public boolean checkletter(char a)
    {
        // if last char is correct
        //
        if(a==para.charAt(index))
        {
            index++;
            if(index==para.length())TimeDuration = System.currentTimeMillis() - startTime;
            return true;
        }
        else
        {
            mistakes++;
            return false;
        }
    }
    public long getTimeDuration()
    {
        if(TimeDuration==-1)return System.currentTimeMillis() - startTime;
        else return TimeDuration;
    }
    public void pause_Timer()
    {
        pauseTime = System.currentTimeMillis();
    }
    public void start_Timer()
    {
        startTime += System.currentTimeMillis()-pauseTime;
    }
    // statistics (methosds)
    public int getMistakes()
    {
        return mistakes;
    }
    public float getSpeed()
    {
        // speed unit = lpm(letter per minute)
        if(TimeDuration==-1)return -1;
        else return (float) (((float)(index)*60.0)/(TimeDuration*1000.0));
    }
}