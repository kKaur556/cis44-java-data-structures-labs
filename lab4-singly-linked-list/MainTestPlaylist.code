import java.util.*;
public class MainTestPlaylist {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Playlist newPlaylist = new Playlist();
        int input;
        
        do
        {
            menu();
            System.out.print("Your choice: ");
            input = console.nextInt();
            
            // Consume the leftover newline character
            console.nextLine(); 
            switch(input)
            {
                case 1:
                    System.out.print("Enter song title: ");
                    String title  = console.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = console.nextLine();
                    newPlaylist.addSong(new Song(title, artist));
                    break;
                
                case 2:
                    System.out.print("Enter song title to remove: ");
                    String removeT  = console.nextLine();
                    newPlaylist.removeSong(removeT);
                    break;
                
                case 3: 
                    newPlaylist.playNext();
                    break;
                    
                case 4:
                    newPlaylist.displayPlaylist();
                    break;
                    
                case 5:
                    System.out.print("Thank you for using the program.");
                    break;
                
                default:
                    System.out.print("Invalid option. Enter numbers 1-5 accordingly.");
                
            }
            System.out.println();
        }while(input != 5);
    }
    
    //static method menu to call without the need of a object
    private static void menu()
    {
        System.out.println("Choose and enter the corresponding number:");
        System.out.println("1 - Add a song");
        System.out.println("2 - Remove a song");
        System.out.println("3 - Play next song");
        System.out.println("4 - Display playlist");
        System.out.println("5 - Exit");
    }
}
