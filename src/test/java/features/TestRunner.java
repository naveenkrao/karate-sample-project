package features;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.core.ScenarioResult;
import net.masterthought.cucumber.Configuration;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import com.intuit.karate.junit5.Karate;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunner {
//@Karate.Test

    private static final Logger log = LoggerFactory.getLogger(TestRunner.class);
  //  ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
//log.setLevel(Level.toLevel("error"));
    @Test
     void testAll(){
         Results results = Runner.path("classpath:features")
                 .outputCucumberJson(true)
                 .tags("~@ignore").parallel(5);
        generateReport(results.getReportDir());
         Stream<ScenarioResult> scenarioResults =  results.getScenarioResults();

         assertEquals(0, results.getFailCount(), results.getErrorMessages());
     }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }



}
