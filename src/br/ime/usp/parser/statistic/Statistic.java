package br.ime.usp.parser.statistic;

import org.renjin.script.RenjinScriptEngineFactory;
import org.renjin.sexp.SEXP;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Statistic {

    public float[] buildBasicStatistics(String path) {

        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        float resul[] = new float[5];

        try {

            engine.eval("setwd(\"/media/alexandre/MyFiles/projetoGit/javaparser3/\")");
            engine.eval("MyData <- read.csv(file='datafile/" + path + "')");
            engine.eval("df <- data.frame (MyData)");
            engine.eval("colnames(df) <- c(\"Num\")");
            SEXP res = (SEXP) engine.eval("mean(df$Num)");
            resul[0] = Float.valueOf(res.toString());
            res      = (SEXP) engine.eval("sd(df$Num)");
            resul[1] = Float.valueOf(res.toString());
            res      = (SEXP) engine.eval("median(df$Num)");
            resul[2] = Float.valueOf(res.toString());
            res      = (SEXP) engine.eval("as.numeric(max(df$Num))");
            resul[3] = Float.valueOf(res.toString());
            res      = (SEXP) engine.eval("as.numeric(min(df$Num))");
            resul[4] =  Float.valueOf(res.toString());

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return resul;
    }


}
