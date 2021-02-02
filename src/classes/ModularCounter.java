package classes;

/*******************************
 * @author: Tobias Mitterwallner
 * @date: 02.02.2021
 * @version: 2.0
 * @class: ModularCounter.java
 ******************************/

public class ModularCounter {


    public ModularCounter (int value, int modulus)
            throws IllegalArgumentException
    {
        if (modulus < 1)
            throw new IllegalArgumentException("ModularCounter - modulus("+modulus+") non-positive");
        if (value < 0 || value >= modulus)
            throw new IllegalArgumentException("ModularCounter - value("+value+") not in range [0,"+(modulus-1)+"]");

        this.value = value;
        this.modulus = modulus;
    }

    public ModularCounter (int modulus)
    {this(0,modulus);}

    public int getValue()
    {return value;}

    public int getModulus()
    {return modulus;}

    public boolean equals(Object other)
    {
        if ( !(other instanceof ModularCounter) )
            return false;
        if (this == other)
            return true;

        ModularCounter otherMC = (ModularCounter)other;

        return value == otherMC.value && modulus == otherMC.modulus;
    }

    public boolean isZero()
    {return value == 0;}

    public int compareTo(ModularCounter mc)
    {return value - mc.value;}

    public String toString ()
    {return value + "(mod " + modulus + ")";}

    public void reset()
    {value = 0;}

    public void inc()
    {
        if (value < modulus-1)
            value++;
        else
            value = 0;
    }

    public void inc (int delta)
            throws IllegalArgumentException
    {
        if (delta < 0)
            throw new IllegalArgumentException("ModularCounter: inc - delta("+delta+") non-positive");
        for (int i=1; i <= delta; i++)
            inc();
    }


    public void dec()
    {
        if (value == 0)
            value = modulus-1;
        else
            value--;
    }

    public void dec (int delta)
            throws IllegalArgumentException
    {
        if (delta < 0)
            throw new IllegalArgumentException("ModularCounter: inc - delta("+delta+") non-positive");
        for (int i=1; i <= delta; i++)
            dec();
    }

    public void update (int delta)
    {
        if (delta >= 0)
            for (int i=1; i <= delta; i++)
                inc();
        else
            for (int i=1; i <= -delta; i++)
                dec();
    }
    private int value;

    private final int modulus;
}




