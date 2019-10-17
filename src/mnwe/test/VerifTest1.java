/**
 * 
 */
package mnwe.test;

import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;

public class VerifTest1 extends TestJPF {

    private final String[] JPF_ARGS = {
              // this is definitely the correct format (tried + tested), adapt as needed:
              "+classpath+=./bin;../jpf-core/build/jpf.jar",
              "+vm.insn_factory.class=gov.nasa.jpf.symbc.SymbolicInstructionFactory",
              "+log.level=debug",
              "+report.console.start=config,dtg,jpf,platform,sut",
              "+listener=.listener.ChoiceTracker",
              "+jpf.listener+=,gov.nasa.jpf.symbc.SymbolicListener",
              "+search.properties+=,gov.nasa.jpf.vm.NoUncaughtExceptionsProperty",
              "+listener+=,gov.nasa.jpf.symbc.sequences.SymbolicSequenceListener",
              "+search.properties+=,gov.nasa.jpf.vm.NoUncaughtExceptionsProperty",
              "+symbolic.method=mnwe.test.SuT.helper(sym)",
              //
              "+symbolic.debug=on", // or true
              "+symbolic.lazy=on",
              "+search.class=.search.heuristic.BFSHeuristic", // default is DFS 
              // "+symbolic.heuristicPartition=true",
              // "+symbolic.heuristicRandom=true",
              // "+symbolic.concolic=true",
              // "+symbolic.min_int=-1",
              // "+symbolic.max_int=999",
              // optional:
              // "+symbolic.min_double=-100.0",
              // "+symbolic.max_double=100.0",
              // "+search.depth_limit=25",
              "+report.console.show_source=true",
              // "+symbolic.dp=no_solver",
              // "+symbolic.dp=coral",
              // "+symbolic.dp=choco",
              // "+symbolic.dp=cvc3",
              "+symbolic.dp=z3",
              "+symbolic.fp=true",
              // "+symbolic.undefined=0",
              // "+search.multiple_errors=true"
              // "+cg.enumerate_random=true"
              };
    
    @Test
    public void testFoo() {
        
        if (verifyNoPropertyViolation(JPF_ARGS)) {
            
            boolean result = SuT.helper(42.0);
            assert  result;
            
        }
    }
    
    public static void main(String[] testMethods){
        runTestsOfThisClass(testMethods);
    }

}
