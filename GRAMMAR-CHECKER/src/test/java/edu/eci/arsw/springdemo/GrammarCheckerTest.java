package edu.eci.arsw.springdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GrammarCheckerTest {
    GrammarChecker grammarChecker;
    @Before
    public void setup(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        grammarChecker = ac.getBean(GrammarChecker.class);
    }
    @Test
    public void isSpanishChecker(){
        SpellChecker sc = grammarChecker.getSpellChecker();
        String spell = sc.checkSpell("Español");
        if(spell.endsWith("espanol")){
            Assert.assertTrue(true);
        }else{
            Field[] fields = grammarChecker.getClass().getFields();
            for(Field f: fields){
                String qualifier = f.getAnnotation(Qualifier.class).value();
                if (qualifier.equals("spanishSpellChecker")){
                    Assert.fail();
                }else if(qualifier.equals("englishSpellChecker")){
                    Assert.assertTrue(true);
                }
            }
        }
    }
    @Test
    public void isEnglishChecker(){
        SpellChecker sc = grammarChecker.getSpellChecker();
        String spell = sc.checkSpell("english");
        if(spell.endsWith("english")){
            Assert.assertTrue(true);
        }else{
            Field[] fields = grammarChecker.getClass().getFields();
            for(Field f: fields){
                String qualifier = f.getAnnotation(Qualifier.class).value();
                if (qualifier.equals("englishSpellChecker")){
                    Assert.fail();
                }else if(qualifier.equals("spanishSpellChecker")){
                    Assert.assertTrue(true);
                }
            }
        }
    }
}
