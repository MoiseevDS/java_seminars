// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package seminar_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class program_2_1 {
    public static void main(String[] args) {
        String requestStart = "select * from students";
        String jsonStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String emptyValue = "null";
        boolean whereStrUsed = false;
        StringBuilder sqlString = new StringBuilder(requestStart);
        // trim string and delete external {} symbols
        jsonStr = jsonStr.trim().replaceAll("^\\{|}$", "");
        for (String element : jsonStr.split(",")) {
            Pattern regexpPat = Pattern.compile("\"(.*)\":\"(.*)\"");
            Matcher items = regexpPat.matcher(element.trim());
            if (items.matches()) {
                String key = items.group(1);
                String val = items.group(2);
                if (!val.equals(emptyValue)) {
                    if (whereStrUsed) {
                        sqlString.append(String.format(" and %s='%s'", key, val));
                    } else {
                        sqlString.append(" where");
                        whereStrUsed = true;
                        sqlString.append(String.format(" %s='%s'", key, val));
                    }
                }
            }
        }
        System.out.println(sqlString);
    }
}
