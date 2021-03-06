import com.beust.jcommander.internal.Lists;
import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        TestNG testng = new TestNG();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("testng.xml");
        SuiteXmlParser parser = new SuiteXmlParser();
        XmlSuite suite = parser.parse("testng.xml", inputStream, true);
        System.out.println(suite);
        testng.setXmlSuites(new ArrayList<>(Collections.singleton(suite)));
        testng.run();
    }
}
