// ParseJavaFiles.java
import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ParseJavaFiles {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("integration-tests/src/main/java/"); // adjust path to your .java files
        List<String> summaries = new ArrayList<>();

        Files.walk(src).filter(p -> p.toString().endsWith(".java")).forEach(file -> {
            try {
                CompilationUnit cu = JavaParser.parse(file);
                summaries.add("File: " + file.getFileName());
                cu.findAll(com.github.javaparser.ast.body.ClassOrInterfaceDeclaration.class)
                        .forEach(c -> summaries.add("Class: " + c.getName()));
                cu.findAll(com.github.javaparser.ast.body.MethodDeclaration.class)
                        .forEach(m -> summaries.add("  Method: " + m.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Files.write(Paths.get("code_summary.txt"), summaries);
    }
}
