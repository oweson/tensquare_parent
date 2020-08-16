package com.tensquare.demo.ik.ikanalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;

/**
 * @Author: ShrekerNil
 * @Date: 2018-11-10 14:44
 * @Description:
 */
public class TestIKAnalyzer {
    
    @Test
    public void testik() throws Exception {
        String text = "你的梦想是什么，请告诉我！";
        // 1 创建分词对象
        Analyzer analyzer = new IKAnalyzer(false);
        // true　用智能分词，false细粒度
        Configuration cfg = DefaultConfig.getInstance();
        Dictionary.initial(cfg);
        StringReader reader = new StringReader(text);
        // 2 分词
        TokenStream tokenStream = analyzer.tokenStream("", reader);
        CharTermAttribute charTerm = tokenStream.getAttribute(CharTermAttribute.class);
        // 3 遍历分词数据
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            System.out.print(charTerm.toString() + "|");
        }
        tokenStream.close();
        reader.close();
        System.out.println();
    }
    
}
