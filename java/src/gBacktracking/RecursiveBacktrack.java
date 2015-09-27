package gBacktracking;

public class RecursiveBacktrack {
/**
 *  bool Solve(configuration conf)
  {
     if (no more choices)     // BASE CASE
           return (conf is goal state);
     for (all available choices) {
       try one choice c;
                                  // recursively solve after making choice
       ok = Solve(conf with choice c made);
if (ok)
            return true;
        else
            unmake choice c;
      }
      return false;   // tried all choices, no soln found
  }
 */
	
	/* BACKTRACKING STRATEGIES
	 * When solving a backtracking problem, ask these questions:
Ð What are the "choices" in this problem?
¥ What is the "base case"? (How do I know when I'm out of choices?)
Ð How do I "make" a choice?
¥ Do I need to create additional variables to remember my choices? ¥ Do I need to modify the values of existing variables?
Ð How do I explore the rest of the choices?
¥ Do I need to remove the made choice from the list of choices?
Ð Once I'm done exploring, what should I do? Ð How do I "un-make" a choice?
	 */
}
