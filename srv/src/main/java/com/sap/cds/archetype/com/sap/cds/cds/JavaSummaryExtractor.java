package com.sap.cds.archetype.com.sap.cds.cds;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class JavaSummaryExtractor {

    public static void main(String[] args) {
        // 👇 Customize this path to point to your Java file
        String javaFilePath = "srv/BookService.java";
        String outputFilePath = "generated_summary.txt";

        try {
            // Initialize parser and parse the file
            JavaParser parser = new JavaParser();
            ParseResult<CompilationUnit> result = parser.parse(new File(javaFilePath));

            if (!result.isSuccessful()) {
                System.err.println("Failed to parse Java file.");
                result.getProblems().forEach(problem -> System.err.println(problem.getMessage()));
                return;
            }

            Optional<CompilationUnit> optionalCU = result.getResult();
            if (optionalCU.isEmpty()) {
                System.err.println("No CompilationUnit returned.");
                return;
            }

            CompilationUnit cu = optionalCU.get();

            // Start building a readable summary
            StringBuilder summary = new StringBuilder();
            summary.append("🔍 Java Class Summary (").append(javaFilePath).append(")\n\n");

            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(clazz -> {
                summary.append("📘 Class: ").append(clazz.getName()).append("\n");

                clazz.getMethods().forEach(method -> {
                    summary.append("  🔹 Method: ")
                           .append(method.getName())
                           .append(" → Return Type: ")
                           .append(method.getType())
                           .append("\n");

                    if (!method.getParameters().isEmpty()) {
                        summary.append("Params: ");
                        method.getParameters().forEach(p ->
                            summary.append(p.getType()).append(" ").append(p.getName()).append(", ")
                        );
                        // remove trailing comma
                        summary.setLength(summary.length() - 2);
                        summary.append("\n");
                    }
                });

                summary.append("\n");
            });

            // Write to output file
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(summary.toString());
            writer.close();

            System.out.println("Summary written to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
