/**
 * b2StartNewBag
 * bagger 2 prodns
 * start a new bag
 * based on b1StartNewBag, 2013 version
 * Modified by Simon Fish for use with bagger2
 */

import java.util.*;
import java.io.*;
import sheffield.*;

public class b2StartNewBag extends Prodn {
final static String name = "START-NEW-BAG";
final static String[] antes = {"step is bag item",
                               "current bag no ?N",
                               "bag no ?N space ?BS",
                               "number of bags is ?ONB"};
final static String[] adds = {"bag no ?NB space 100",
                              "current bag no ?NB",
                              "number of bags is ?NB"};
final static String[] dels = {"current bag no ?N",
                              "number of bags is ?ONB"};
final static String[] remarks = {"Starting bag ?NB"};


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
    Integer bagno = Integer.valueOf((String) c.get("?N"));
    c.put("?NB", String.valueOf(bagno.intValue()+1));
    return c;
}

}
