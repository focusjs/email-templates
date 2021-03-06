package com.emailsending.template.performance;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emailsending.template.TemplateDataExtractor;
import com.emailsending.template.generator.TemplateGenerator;
import com.emailsending.template.generator.TemplateGeneratorFactory;

public class MustacheTemplateTest {

    private static final Logger logger = LoggerFactory.getLogger(MustacheTemplateTest.class);

    private static final int numberOfTemplatesToGenerate = 100000;

    private static final String templateFileName = "Template.mustache";

    public static void main(String[] args) throws IOException {

        List<String> data = TemplateDataExtractor.readData();
        
       TemplateGenerator mustacheTemplateGenerator = TemplateGeneratorFactory.getMustacheTemplateGenerator(data, templateFileName);

        long lStartTime = new Date().getTime(); // start time

        for (int i = 0; i < numberOfTemplatesToGenerate; i++) {
           @SuppressWarnings("unused")
           String generatedString = mustacheTemplateGenerator.generate();
        }

        long lEndTime = new Date().getTime(); // end time

        long difference = lEndTime - lStartTime; // check different

        logger.info("Elapsed milliseconds: " + difference);
    }
}
