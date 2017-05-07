/**
 * TestPS
 * testing prodn systems
 * 2013 Version
 * Modified by Simon Fish for use with bagger2
 */

import sheffield.*;
import java.util.*;
import java.math.*;
import pmatch.*;

public class TestPS
{
public static void main(String[] args) {
    // create objects for input and output
    EasyWriter scr = new EasyWriter();
    ArrayList<Prodn> bagger2 = new ArrayList<Prodn>();     //make the bagger2 rules
    bagger2.add(new b2Start());
    bagger2.add(new b2GetNextItem());
    bagger2.add(new b2BagInCurrent());
    bagger2.add(new b2IterateBags()); //bagger2: additional class to cycle through bags
    bagger2.add(new b2StartNewBag());

    //initial facts

    ArrayList<String> stm = new ArrayList<String>();
    stm.add("step is start bagging");
    int seed = Integer.parseInt(args[0]);
    int noOfItems = Integer.parseInt(args[1]);
    TrolleyGen generator = new TrolleyGen(seed,noOfItems);
    String[] trolley = generator.fillTrolley();
    for (String item : trolley) {
        stm.add(item);
    }

    //prod sys engine

    ProdSys ps=new ProdSys(bagger2);

    ArrayList<String> res=ps.RunPS(stm);
    scr.println("final STM ");
    scr.println(res);
}
}
