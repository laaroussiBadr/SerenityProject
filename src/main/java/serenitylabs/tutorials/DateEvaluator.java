package ma.wafaassurance.common.framework.sit.expression;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ma.wafaassurance.common.framework.sit.WafaSeleniumTestCase;
import ma.wafaassurance.common.framework.sit.model.Scenario;

import org.joda.time.DateTime;

public class DateEvaluator extends BaseExpressionEvaluator {
    
    private static final Pattern P = Pattern
            .compile("\\#\\s*DT(\\s*\\[\\s*(\\d+)\\s*(:\\s*(\\S.*))?\\s*\\])?((\\s*([\\+\\-])\\s*(\\d+)([dMyHms]))*)(\\s*\\:\\s*(\\S.*))?\\s*\\#");
    
    public DateEvaluator(WafaSeleniumTestCase testCase, Scenario scenario) {
        super(testCase, scenario);
    }
    
    @Override
    public boolean matches(String s) {
        return s.matches(P.pattern());
    }
    
    @Override
    public String eval(String s) {
        Matcher m = P.matcher(s);
        
        m.find();
        
        String format = m.groupCount() >= 11 && m.group(11) != null ? m.group(11) : "dd/MM/yyyy";
        
        String opExpr = m.group(5);
        
        Date baseDate = new Date();
        
        DateTime dt = new DateTime(baseDate);
        
        if (opExpr != null) {
            Pattern P2 = Pattern.compile("\\s*([\\+\\-])\\s*(\\d+)([dMyHms])");
            Matcher M2 = P2.matcher(opExpr);
            
            while (M2.find()) {
                String op = M2.group(1);
                String v = M2.group(2);
                String u = M2.group(3);
                
                int n = Integer.parseInt(v);
                
                if (n > 0) {
                    if (op.equals("-")) {
                        n = -n;
                    }
                    
                    if (u.equals("d")) {
                        dt = dt.plusDays(n);
                    }
                    if (u.equals("y")) {
                        dt = dt.plusYears(n);
                    }
                    if (u.equals("H")) {
                        dt = dt.plusHours(n);
                    }
                    if (u.equals("s")) {
                        dt = dt.plusSeconds(n);
                    }
                    if (u.equals("M")) {
                        dt = dt.plusMonths(n);
                    }
                    if (u.equals("m")) {
                        dt = dt.plusMinutes(n);
                    }
                } else {
                    if (op.equals("+")) {
                        if (u.equals("d")) {
                            dt = dt.dayOfMonth().withMaximumValue();
                        }
                        if (u.equals("y")) {
                            dt = dt.yearOfCentury().withMaximumValue();
                        }
                        if (u.equals("H")) {
                            dt = dt.hourOfDay().withMaximumValue();
                        }
                        if (u.equals("s")) {
                            dt = dt.secondOfMinute().withMaximumValue();
                        }
                        if (u.equals("M")) {
                            dt = dt.monthOfYear().withMaximumValue();
                        }
                        if (u.equals("m")) {
                            dt = dt.minuteOfHour().withMaximumValue();
                        }
                    } else if (op.equals("-")) {
                        if (u.equals("d")) {
                            dt = dt.dayOfMonth().withMinimumValue();
                        }
                        if (u.equals("y")) {
                            dt = dt.yearOfCentury().withMinimumValue();
                        }
                        if (u.equals("H")) {
                            dt = dt.hourOfDay().withMinimumValue();
                        }
                        if (u.equals("s")) {
                            dt = dt.secondOfMinute().withMinimumValue();
                        }
                        if (u.equals("M")) {
                            dt = dt.monthOfYear().withMinimumValue();
                        }
                        if (u.equals("m")) {
                            dt = dt.minuteOfHour().withMinimumValue();
                        }
                    }
                }
            }
        }
        
        return new SimpleDateFormat(format).format(dt.toDate());
    }
}
