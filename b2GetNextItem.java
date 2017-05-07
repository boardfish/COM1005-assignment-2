/**
 * b2GetNextItem
 * bagger 2 prodns
 * get the next item from the trolley
 * based on b1GetNextItem, 2013 version
 * Modified by Simon Fish for use with bagger2
 */

import java.util.*;
import java.io.*;
import sheffield.*;

public class b2GetNextItem extends Prodn {
final static String name = "GET-NEXT-ITEM";
final static String[] antes = {"step is get next item",
                               "trolley contains ?I space ?S",
                               "current bag no ?N"};
final static String[] adds = {"step is bag item",
                              "item to bag ?I space ?S",
                              "current bag no 1"}; /* resets the current bag so
															that b2IterateBags can step through all bags*/
final static String[] dels = {"step is get next item",
                              "trolley contains ?I space ?S",
                              "current bag no ?N"};
final static String[] remarks = {"bagging ?I"};


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
    return true;
}
public HashMap modifyContext(HashMap c){
    return c;
}

}
