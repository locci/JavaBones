import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.printer.YamlPrinter;
import com.github.javaparser.*;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        YamlPrinter printer = new YamlPrinter(true);
        FileInputStream in = new FileInputStream("/home/alexandre/Desktop/teste/Main.java");
        FileWriter fw = new FileWriter("/home/alexandre/Desktop/teste/out4");
        CompilationUnit cu = JavaParser.parse(in);
        fw.write(printer.output(cu));

        ClassOrInterfaceDeclaration clazz = Navigator.demandClass(cu,"Main");
        MethodDeclaration method = Navigator.demandMethod(clazz, "main");
        ReturnStmt returnStmt = Navigator.findReturnStmt(method);



        fw.close();

    }



}
