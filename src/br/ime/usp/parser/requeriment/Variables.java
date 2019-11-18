package br.ime.usp.parser.requeriment;
import com.github.javaparser.ast.stmt.IfStmt;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;
import org.mariuszgromada.math.mxparser.parsertokens.Token;

import java.util.List;

public class Variables {

    public String[] getVariables(IfStmt code) {

        String exp = code.getCondition().toString();
        Expression e = new Expression(exp);
        mXparser mXparser = null;
        //mXparser.consolePrintTokens(e.getCopyOfInitialTokens());
        List<Token> tokens = e.getCopyOfInitialTokens();
        //Object[] str = tokens.toArray();
       System.out.println(tokens.size() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
       for(int i=0; i < tokens.size(); i++) {
           System.out.println(tokens.get(i).tokenStr  + "  " + tokens.get(i).tokenLevel + " " + tokens.get(i).looksLike + " " + tokens.get(i).keyWord);
        }
       return null;

    }
}
