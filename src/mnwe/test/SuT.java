package mnwe.test;

import java.util.logging.Logger;

import gov.nasa.jpf.JPF;

public class SuT {

    static Logger log = JPF.getLogger("mnwe.test");
    
    static public boolean helper(double d1) {

        // "ignore" values <0
        if (d1 < 0) { return true; }
 
        // let certain possible values trigger the error
        if (d1 > 21000) {
            return false;
        }
        
        return d1 == d1;
    }

}
