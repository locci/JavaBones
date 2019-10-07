package br.ime.usp.parser;

import org.renjin.script.RenjinScriptEngineFactory;

import javax.script.ScriptEngine;

public class Statistic {

    public static void main(String[] args) throws Exception {
        // create a script engine manager:
        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        // create a Renjin engine:
        ScriptEngine engine = factory.getScriptEngine();

        // ... put your Java code here ...
        engine.eval("df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10))");
        engine.eval("print(df)");
        engine.eval("print(lm(y ~ x, df))");

    }

}
