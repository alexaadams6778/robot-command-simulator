/*
 * Written by Alexa Adams
 */

public class Robot //robot object class
{
	private int row;
    private int col;
    private String symbol;

    public Robot(int r, int c, String sym)
    {
        row = r;
        col = c;
        symbol = sym;
    }
    
    public int getRow()
    {
    	return row;
    }
    
    public int getCol()
    {
    	return col;
    }
    
    public String getSymbol()
    {
    	return symbol;
    }

    public void moveTo(int r, int c) 
    {
        row = r;
        col = c;
    }
}
