/**
 * b2BagInCurrent
 * bagger 2 prodns
 * bag the currently selected item in the current bag
 * based on b1BagInCurrent, 2013 version
 * Modified by Simon Fish for use with bagger2
 */

import java.util.*;
import java.io.*;
import sheffield.*;

public class b2BagInCurrent extends Prodn {

final static String name = "BAG-IN-CURRENT";
final static String[] antes = {"step is bag item",
                               "item to bag ?I space ?S",
                               "current bag no ?N",
                               "bag no ?N space ?BS"};
final static String[] adds = {"step is get next item",
                              "bag ?N contains ?I",
                              "bag no ?N space ?NBS", /*updates the space in the
															current bag for the next loop*/
                              "current bag no 1"};
final static String[] dels = {"step is bag item",
                              "item to bag ?I space ?S",
                              "bag no ?N space ?BS",
                              "current bag no ?N"};
final static String[] remarks = {"?I in bag no ?N"};

public String getName(){
    return name;
}
public String[] getAntes() {
    return antes;
}
public String[] getAdds() {
    return adds;
}
public String[] getDels() {
    return dels;
}
public String[] getRemarks(){
    return remarks;
}


public boolean pred(HashMap c){
    Integer spaceLeft = Integer.valueOf((String) c.get("?BS"));
    Integer spaceNeeded = Integer.valueOf((String) c.get("?S"));
    return (spaceLeft.intValue()>=
            spaceNeeded.intValue());
}

public HashMap modifyContext(HashMap c){
    Integer spaceLeft = Integer.valueOf((String) c.get("?BS"));
    Integer spaceNeeded = Integer.valueOf((String) c.get("?S"));
    String spaceLeftOver = String.valueOf(spaceLeft.intValue()-spaceNeeded.intValue());
    c.put("?NBS", spaceLeftOver);
    return c;
}

}
