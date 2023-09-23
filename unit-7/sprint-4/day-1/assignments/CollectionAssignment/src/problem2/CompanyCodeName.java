package problem2;

import java.util.HashMap;
import java.util.Map;

final public class CompanyCodeName {

    public static final Map<String,String> companyCode;

    static {
        companyCode = new HashMap<>();
        companyCode.put("EKP","Ekoplay");
        companyCode.put("EXP","Explore");
        companyCode.put("FSK","Funskool");
        companyCode.put("NKT","Natkhat");
        companyCode.put("SLD","Sunlord");
        companyCode.put("TZN","ToyZone");
    }
}
