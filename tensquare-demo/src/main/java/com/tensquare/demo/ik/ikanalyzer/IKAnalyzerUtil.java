package com.tensquare.demo.ik.ikanalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IKAnalyzerUtil {
    
    private static List<String> splition(String sentence) throws IOException {
        Analyzer analyzer = new IKAnalyzer(false);
        StringReader reader = new StringReader(sentence);
        TokenStream tokenStream = analyzer.tokenStream("", reader);
        CharTermAttribute charTerm = tokenStream.getAttribute(CharTermAttribute.class);
        tokenStream.reset();
        Set<String> words = new HashSet<>();
        words.add(sentence);
        while (tokenStream.incrementToken()) {
            String word = charTerm.toString();
            words.add(word);
        }
        tokenStream.close();
        reader.close();
        return new ArrayList<>(words);
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(IKAnalyzerUtil.splition("你喜欢吃鱼吗？"));
        System.out.println(IKAnalyzerUtil.splition("我非常的喜欢吃鱼！"));
    }
    
}
    