import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
         while (true) {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
                if (input.equals("exit")) 
                {
                    break;
                }
                else if (input.startsWith("echo ")) 
                {
                    System.out.println(input.substring(5));

                }
                else if (input.startsWith("type "))
                {
                    if (input.substring(5).equals("echo") || input.substring(5).equals("exit") || input.substring(5).equals("type"))
                    {
                        System.out.println(input.substring(5)+" is a shell builtin");
                    }              
                    else 
                    {
                        Path path = FileSystems.getDefault().getPath("/bin/" + input.substring(5));
                        System.out.println(path);
                        if(Files.isExecutable(path))
                        {
                            System.out.println(input.substring(5) + " is " + path);
                        }
                        else


                        System.out.println(input.substring(5) + ": not found");
                    }      
                                       
                }
                else 
                {
                    System.out.println(input + ": command not found");
                }
        }
    }
}
