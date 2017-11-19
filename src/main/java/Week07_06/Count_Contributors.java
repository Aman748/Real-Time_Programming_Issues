package Week07_06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Aman
 */
public class Count_Contributors {
    static ArrayList<GHContent> folder = new ArrayList<>();
    static ArrayList<GHContent> file = new ArrayList<>();
    public static void main (String[] args) throws IOException{
        GitHub github = GitHub.connectAnonymously();
        
        GHUser user = github.getUser("zhamri");
        GHRepository repository = user.getRepository("STIW3054-RT-Programming");
//        for (Object Content : repository.getIssue(15).getComments().get(1).getUser())
            System.out.println(repository.getIssue(15).getComments().get(1).getUser().getName());
        
//        getContent(repository, "");
//        
//        System.out.println("Total folders in this repository: " + folder.size());
//        System.out.println("\nFolders in repository \'STIW3054-RT-Programming\': ");
//        folder.forEach((folderName) -> {
//            System.out.println(folderName.getName());
//        });
//        
//        System.out.println("\nTotal files in this repository: " + file.size());
//        System.out.println("\nFolders in repository \'STIW3054-RT-Programming\': ");
//        file.forEach((fileName) -> {
//            System.out.println(fileName.getName());
//        });
//        
//    }   
//    
//    public static void getContent(GHRepository repository, String dirName) throws IOException{
//        List<GHContent> content = repository.getDirectoryContent(dirName);
//        
//        for (GHContent foundContent : content) {
//            if (foundContent.isFile()) {
//                file.add(foundContent);
//            } else if (foundContent.isDirectory()) {
//                folder.add(foundContent);
//                getContent(foundContent.getOwner(), foundContent.getPath());
//            }
//        }
    }
}
