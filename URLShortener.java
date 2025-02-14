import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortener {

    private static Map<String, String> urlMap = new HashMap<>();
    
    private static final String BASE_URL = "http://short.ly/";

    private static int counter = 1;

    public static String shortenURL(String originalURL) {
        String shortenedKey = Integer.toString(counter++, 36); 
        urlMap.put(shortenedKey, originalURL);
        
        return BASE_URL + shortenedKey;
    }

    public static String retrieveURL(String shortURL) {
        String key = shortURL.replace(BASE_URL, "");
        
        return urlMap.getOrDefault(key, "URL not found");
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the URL Shortener!");
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Retrieve original URL");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            if (choice == 1) {
                
                System.out.print("Enter the original URL: ");
                String longURL = scanner.nextLine();
                String shortURL = shortenURL(longURL);
                System.out.println("Shortened URL: " + shortURL);
                
            } else if (choice == 2) {
                
                System.out.print("Enter the shortened URL: ");
                String shortURL = scanner.nextLine();
                String originalURL = retrieveURL(shortURL);
                System.out.println("Original URL: " + originalURL);
                
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break; 
                
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}
