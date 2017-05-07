/**
 * b2Start
 * bagger 2 prodns
 * start the production system
 * based on b2Start, 2013 version
 * Modified by Simon Fish for use with bagger2
 */

import java.util.*;
import java.io.*;
import sheffield.*;

public class b2Start extends Prodn {
final static String name = "START-BAGGING";
final static String[] antes = {"step is start bagging"};
final static String[] adds = {"step is get next item",
                              "current bag no 1", //defines starting bag
                              "bag no 1 space 100", //creates starting bag
                              "number of bags is 1"};/*initial total, increments
																										 when a new bag is started*/
final static String[] dels = {"step is start bagging"};
final static String[] remarks = {"starting to bag"};


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
