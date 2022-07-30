package Team4.egg.AfterClass.utility;

import org.springframework.stereotype.Component;

@Component
public interface StringsMethods {

    default String transformString(String str) {
        String Fchar = str.substring(0,1).toUpperCase();
        str = str.substring(1, str.length()).toLowerCase();
        str = Fchar.concat(str);
        return str;
    }

    default String deleteSpaces(String str){
        str = transformString(str).trim();
        return str;
    }
}
