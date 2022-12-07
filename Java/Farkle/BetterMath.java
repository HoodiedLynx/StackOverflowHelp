package Java.BetterMath;

import Java.BetterPrint.*;

public class BetterMath
{
    BetterPrint print = new BetterPrint();
    public double floor(int deciPlaces, double x)
    {
        double output;
        int hold;

        output = x * pow(10, deciPlaces);

        hold = (int) output;

        output = hold / pow(10, deciPlaces);

        return output;
    }
    
    public double ceil(int deciPlaces, double x)
    {
        double output;

        output = floor(deciPlaces, x) + (1 / pow(10, deciPlaces));

        return output;
    }

    public double round(int deciPlaces, double x)
    {
        double output, hold;
        boolean roundDir;
        int holdInt;

        output = 0;
        roundDir = false;

        hold = x * pow(10, deciPlaces);
        holdInt = (int) hold;

        //Determines whether to round up or down
        if((hold - holdInt) * 2 > 1)
        {
            roundDir = true;
        }

        //rounds up
        if(roundDir)
        {
            output = ceil(deciPlaces, x);
        }

        //rounds down
        if(!roundDir)
        {
            output = floor(deciPlaces, x);
        }

        return output;
    }
    
    public double pow(double base, int exp)
    {
        double output;
        
        output = 1.0;

        if(exp >= 0)
        {
            for(int i = 0; i < exp; i++)
            {
                output *= base;
            }
        }

        if(exp < 0)
        {
            output = 1 / pow(base, -exp);
        }
        
        return output;
    }

    public int logInt(int base, int x)
    {
        int hold, output;

        hold = x;
        output = 0;

        while(hold >= 1)
        {
            hold = hold / base;
            output++;
        }

        return output;
    }

    public double decLog(int base, int x, int accDecPlaces)
    {
        double hold, output;

        hold = x;
        output = 0.0;

        while(hold >= 1)
        {
            hold = hold / (base / pow(10, accDecPlaces));
            output += 1 / pow(10, accDecPlaces);
        }

        return output;
    }

    public double root(int base, double x, int accDecPlaces)
    {
        double output;
        int count, places;

        output = 0;
        count = 0;

        places = accDecPlaces;

        if(accDecPlaces > 15)
        {
            places = 15;
        }

        do
        {
            if(pow(output + 1/pow(10, count), base) > x)
            {
                count++;
                continue;
            }

            if(pow(output, base) < x)
            {
                output += 1/pow(10, count);
            }

        } while (count <= places);

        return output;
    }
}
