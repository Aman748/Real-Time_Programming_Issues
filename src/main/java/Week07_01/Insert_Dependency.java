package Week07_01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 *
 * @author Aman
 */
public class Insert_Dependency {
    public static void main(String[]arg) throws FileNotFoundException, IOException, XmlPullParserException{
        
        String Path = System.getProperty("user.dir") + "/pom.xml";

        MavenXpp3Reader Reader = new MavenXpp3Reader();
        
        Model model = Reader.read(new FileReader(Path));
        
        LinkedList<Dependency> dependencies = new LinkedList();

        MavenXpp3Writer Writer = new MavenXpp3Writer();

        Dependency dependency = new Dependency();

        dependency.setGroupId("net.sourceforge.jexcelapi");
        dependency.setArtifactId("jxl");
        dependency.setVersion("2.6.12");

        dependencies.add(dependency);
        model.addDependency(dependency);

        Writer.write(new FileWriter(Path),model);
    }
}
