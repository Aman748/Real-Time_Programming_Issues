package Week07_05;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Aman
 */
public class Count_Issues {
     public static void main (String[] args) throws IOException{
        GitHub github = GitHub.connectAnonymously();
        Object [] Repositories =  github.getUser("zhamri").getRepositories().keySet().toArray();
        int total=0;
        for (Object Repository : Repositories) {
            List<GHIssue> Issues = github.getUser("zhamri").getRepository(Repository.toString()).getIssues(GHIssueState.ALL);
            Iterator<GHIssue> issues = Issues.iterator();
            while (issues.hasNext()) {  
                GHIssue Issue = issues.next();  
                if (Issue.isPullRequest())  
                    issues.remove();
            }
            System.out.println("\n" + "Repository " + Repository.toString() + " (" + Issues.size() + ")");
            int c=1;            
            for(GHIssue Issue:Issues){
                System.out.println("  " + c + ". " + Issue.getTitle() + " (" + github.getUser("zhamri").getRepository(Repository.toString()).getIssue(Issue.getNumber()).getState().toString() + ");");
                c++;
            }
            total += Issues.size();
        }
        System.out.println("There has " + Repositories.length + " Repositories and total " + total + " Issues.");
    } 
}
