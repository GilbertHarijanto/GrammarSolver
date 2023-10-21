/**@Gilbert CS145 GrammarSolver
 *@version 1.0 (05/19/2023)
 *@see GrammarSolver class*/
import java.util.*;

public class GrammarSolver {
   private Map < String, String[] > grammarRules;
   
   /*This constructor takes a list of grammar rule and parses them
   @param grammar gets the list of strings which represents a grammar rule*/
   public GrammarSolver(List < String > grammar) {
      grammarRules = new HashMap < > ();
      for (String rule: grammar) {
         String[] parts = rule.split("::=");
         String key = parts[0].trim();
         String[] values = parts[1].split("[|]");
         grammarRules.put(key, values);
      }
   }
   
   /*checks if there are any symbls
   @param symbol checks the existance of a symbol
   @return true if there is a symbol, false if there is none*/
   public boolean contains(String symbol) {
      return grammarRules.containsKey(symbol);
   }
   
   /*retrieves all of the symbols in the grammar rules
   @return a set of symbols inside the grammar rules*/
      public Set < String > getSymbols() {
      return grammarRules.keySet();
   }

   /*Generates a sentence using all of the rules related with symbols
   @param symbol to generate a string
   @return a String generated according to the grammar rules for the symbol*/
   public String generate(String symbol) {
      if (!contains(symbol)) {
         return symbol;
      }

      String[] rules = grammarRules.get(symbol);
      String rule = rules[new Random().nextInt(rules.length)];
      String[] tokens = rule.split("[ \t]+");
      StringBuilder result = new StringBuilder();

      for (String token: tokens) {
         result.append(generate(token));
         result.append(" ");
      }

      return result.toString().trim();
   }
}