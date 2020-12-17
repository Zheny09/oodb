package ru.icmit.lab6;

import ru.icmit.lab6.graph.GraphModel;


import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static final String PATH = "ru.icmit.lab6.domain";

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<Class<?>> classList = find();
        System.out.println("GraphML");
        String graphXML = export(classList);
        System.out.println(graphXML);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("graphML")));
            writer.write(graphXML);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String export(List<Class<?>> classList){
        GraphModel graphModel = new GraphModel();
        graphModel.fetchEntities(classList);
        graphModel.fetchEdges();
        return graphModel.toString();
    }

    public static List<Class<?>> find() throws UnsupportedEncodingException{
        String scannedPath = Graph.PATH.replace(".", "/");
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null){
            throw new IllegalArgumentException("Bad Package " + Graph.PATH);
        }
        File scannedDir = new File(URLDecoder.decode(scannedUrl.getFile(), "UTF-8"));
        List<Class<?>> classList = new ArrayList<>();
        for (File file : scannedDir.listFiles()){
            classList.addAll(find(file, Graph.PATH));
        }
        return classList;
    }

    private static List<Class<?>> find(File file, String path){
        List<Class<?>> classList = new ArrayList<>();
        String resource = path + "." + file.getName();
        if (file.isDirectory()){
            for (File child : file.listFiles()){
                classList.addAll(find(child, resource));
            }
        } else if (resource.endsWith(".class")){
            String className = resource.substring(0, resource.length() - 6);
            try {
                classList.add(Class.forName(className));
            } catch (ClassNotFoundException ignore){
            }
        }
        return classList;
    }
}


