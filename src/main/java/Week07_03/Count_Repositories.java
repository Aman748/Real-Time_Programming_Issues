package Week07_03;

import java.io.IOException;
import java.util.Set;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Aman
 */
public class Count_Repositories {
    public static void main (String[] args) throws IOException{
        GitHub github = GitHub.connectAnonymously();
        Set<String> Repositories =  github.getUser("zhamri").getRepositories().keySet();
        int c = 0;
        System.out.println("There all repositories in \"https://github.com/zhamri\": \n");
        for(String Repository : Repositories){
            c++;
            System.out.println(c + ". " + Repository);
        }
    }
}
