import java.util.*;

/**
 * Created by joris on 3/7/18.
 */
public class Main {

    private static Random RANDOM = new Random(System.currentTimeMillis());
    private static Map<Character, List<String>> ANIMALS = load("animals.txt");
    private static Map<Character, List<String>> ADJECTIVES = load("adjectives.txt");

    private static Map<Character, List<String>> load(String path)
    {
        HashMap<Character, List<String>> out = new HashMap<>();
        Scanner sc = new Scanner(Main.class.getClassLoader().getResourceAsStream(path));
        while(sc.hasNextLine())
        {
            String line = sc.nextLine().replaceAll(" +","");
            line = line.substring(0,1).toUpperCase() + line.substring(1).toLowerCase();
            Character ch = line.charAt(0);
            if(!out.containsKey(ch))
                out.put(ch, new ArrayList<String>());
            out.get(ch).add(line);
        }
        return out;
    }

    public static void main(String[] args)
    {
        // random character
        List<Character> characters = new ArrayList<>(ANIMALS.keySet());
        characters.retainAll(ADJECTIVES.keySet());
        Character ch = characters.get(RANDOM.nextInt(characters.size()));

        String animal = ANIMALS.get(ch).get(RANDOM.nextInt(ANIMALS.get(ch).size()));
        String adjective = ADJECTIVES.get(ch).get(RANDOM.nextInt(ADJECTIVES.get(ch).size()));

        System.out.println(adjective + " " + animal);
    }

}
