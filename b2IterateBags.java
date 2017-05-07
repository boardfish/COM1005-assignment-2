/**
 * b2IterateBags
 * bagger 2 prodns
 * iterate through bags to find one that has enough space for the current item
 * Written by Simon Fish for use with bagger2
 */

import java.util.HashMap;

public class b2IterateBags extends Prodn {

final static String name = "ITERATE-BAGS";
final static String[] antes = {"step is bag item",
                               "item to bag ?I space ?S",
                               "current bag no ?N",
                               "number of bags is ?NB",
                               "bag no ?N space ?BS"};
final static String[] adds = {"current bag no ?NN"};
final static String[] dels = {"current bag no ?N"};
final static String[] remarks = {"Moving on to bag no ?NN"};

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

@Override
boolean pred(HashMap c) {
    // TODO Auto-generated method stub
    Integer itemSpace = Integer.valueOf((String) c.get("?S"));
    Integer space = Integer.valueOf((String)c.get("?BS"));
    Integer currentBag = Integer.valueOf((String)c.get("?N"));
    Integer totalBags = Integer.valueOf((String)c.get("?NB"));
    return space-itemSpace<0 && totalBags-currentBag>0; /*item doesn't fit
		and this isn't the last bag recognised by the system*/
}

@Override
HashMap modifyContext(HashMap c) {
    Integer bagno = Integer.valueOf((String) c.get("?N"));
    c.put("?NN", String.valueOf(bagno.intValue()+1));
    return c;
}

}
