package br.ime.usp.parser.stmt;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

import java.util.List;


public class StmtIfWhile {

    public List<IfStmt> buildListIfStmt (CompilationUnit cu) {

        return cu.getChildNodesByType(IfStmt.class);


    }

    public List<WhileStmt> buildListWhileStmt (CompilationUnit cu) {

        return cu.getChildNodesByType(WhileStmt.class);

    }

}
