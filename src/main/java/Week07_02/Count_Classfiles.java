package Week07_02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aman
 */
public class Count_Classfiles {
    public static void main(String[]args){
        File Path = new File(System.getProperty("user.dir"));
        List<File> Classlsf = new ArrayList();
        Classlsf = getJavaFiles(Path,Classlsf);  
        System.out.println("Number of Class Files = " + Classlsf.size() + "\n");  
        for(int c=0; c<Classlsf.size(); c++){
            System.out.println(c+1 + "." + Classlsf.get(c).getName());
        }
    }
    public static List<File> getJavaFiles (File Path, List<File> Classlsf){  
        if (!Path.exists()){  
                System.out.println("文件名称不存在!");  
            }else{  
                if (Path.isFile()){  
                    String firName = Path.getName(); 
                    if(firName.substring(firName.lastIndexOf(".")+1) .equals("class")){  
                        Classlsf.add(Path);  
                    }  
                } else{  
                    File[] files = Path.listFiles();  
                    for (File file : files) {
                        getJavaFiles(file, Classlsf);
                    }  
                }  
            }  
        return Classlsf;  
    } 
}
