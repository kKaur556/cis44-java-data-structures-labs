import java.util.*;
public class TextEditorTest {

    public static void main(String[] args) {
        TextEditor myTextEditor = new TextEditor();
        Scanner console = new Scanner(System.in);
        int userInput;
        do
        {
            menu();
            System.out.print("Enter your choice: ");
            userInput = console.nextInt();
            console.nextLine();
            
            switch(userInput)
            {
                case 1:
                    String text;
                    System.out.println("Enter a text to add: ");
                    text = console.nextLine();
                    myTextEditor.add(text);
                    myTextEditor.printCurrent();
                    break;
                    
                case 2:
                    myTextEditor.undo();
                    myTextEditor.printCurrent();
                    break;
                    
                case 3:
                    myTextEditor.redo();
                    myTextEditor.printCurrent();
                    break;
                    
                case 4:
                    myTextEditor.printCurrent();
                    break;
                    
                case 5:
                    System.out.println("Thank you for using this program!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Choose 1-5 from the menu.");
            }
            System.out.println();
        }while(userInput != 5);
    }
    
    private static void menu()
    {
        System.out.println("Choose the corresponding number from the menu: ");
        System.out.println("1 - Add Text");
        System.out.println("2 - Undo");
        System.out.println("3 - Redo");
        System.out.println("4 - Display Text");
        System.out.println("5 - Exit");
    }
}
