package Week07_04;

import java.io.IOException;
import java.util.List;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Aman
 */
public class Count_Contents {
    static GitHub github;
    public static void main (String[] args) throws IOException{
        github = GitHub.connectAnonymously();
        tree("","");
    }
    
    public static void tree(String path,String level) throws IOException {
        List<GHContent> Contents = github.getUser("zhamri").getRepository("STIW3054-RT-Programming").getDirectoryContent(path);
        int c=0;
        for(GHContent Content : Contents){
            if(Content.isFile()){
                c++;
                System.out.println(level + c + ". " + Content.getName());
            }else if(Content.isDirectory()){
                System.out.println(level + "-" + Content.getName());
                String level2 = level + "  ";
                tree(Content.getPath(),level2);
            }
            
        }
    }
}
