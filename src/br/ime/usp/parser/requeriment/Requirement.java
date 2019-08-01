package br.ime.usp.parser.requeriment;
import br.ime.usp.parser.compi.CompUnit;
import br.ime.usp.parser.stmt.StmtIfWhile;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Requirement {

    private ArrayList<String []> listIfRequirements    = new ArrayList<>();
    private ArrayList<String []> listWhileRequirements = new ArrayList<>();

    public void buildListIfRequirement(String fileName) throws FileNotFoundException {

        CompUnit cp = new CompUnit();
        StmtIfWhile stm = new StmtIfWhile();
        String[] out;

        List<IfStmt> listIf       =  stm.buildListIfStmt(cp.buildCompilerUnit(fileName));
        List<WhileStmt> listWhile =  stm.buildListWhileStmt(cp.buildCompilerUnit(fileName));
        StringBuilder requi = new StringBuilder();

        for(IfStmt e: listIf) {

            Expression condition =  e.getCondition();
            requi.append(e.getCondition().toString()).append("\n");

        }

        out = requi.toString().split("\n");

        listIfRequirements.add(out);

        requi = new StringBuilder();

        for(WhileStmt e: listWhile) {

            Expression condition =  e.getCondition();

            requi.append(e.getCondition().toString()).append("\n");

        }

        out = requi.toString().split("\n");
        listWhileRequirements.add(out);

    }

    public ArrayList<String[]> getListIfRequirements() {

        return listIfRequirements;

    }

    public ArrayList<String[]> getListWhileRequirements() {

        return listWhileRequirements;

    }

}
