package ma.wafaassurance.common.framework.sit.expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ma.wafaassurance.common.framework.sit.PropertyManager;
import ma.wafaassurance.common.framework.sit.WafaSeleniumTestCase;
import ma.wafaassurance.common.framework.sit.model.Scenario;

public abstract class BaseExpressionEvaluator {
    
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    protected Scenario scenario;
    protected WafaSeleniumTestCase testCase;
    
    protected PropertyManager propertyManager = PropertyManager.getInstance();
    
    public BaseExpressionEvaluator(WafaSeleniumTestCase testCase, Scenario scenario) {
        super();
        this.scenario = scenario;
        this.testCase = testCase;
    }
    
    public abstract boolean matches(String s);
    
    public abstract String eval(String s) throws Exception;
    
}
