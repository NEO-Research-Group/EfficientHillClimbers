package neo.landscape.theory.apps.pseudoboolean.util.graphs;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import neo.landscape.theory.apps.pseudoboolean.PBSolution;
import neo.landscape.theory.apps.pseudoboolean.problems.EmbeddedLandscape;
import neo.landscape.theory.apps.pseudoboolean.px.VariableProcedence;

public interface VariableClique {
	VariableClique getParent();
	void setParent(VariableClique parent);
	List<Integer> getVariables();
	void addVariable(int var);
	void addAllVariables(Collection<Integer> vars);
	int getId();
	void prepareStructuresForComputation(Set<Integer> nonExhaustivelyExplored, int[] marks,
			Function<Integer, Integer> indexAssignment);
	int getVariablesOfSeparator();
	void markSeparator();
	void applyDynamicProgrammingToClique(PBSolution red, EmbeddedLandscape embeddedLandscape,
			List<Integer>[] subFunctionPartitions, double[] summaryValue, int[] variableValue);
	void reconstructSolutionInClique(PBSolution child, PBSolution red, VariableProcedence variableProcedence,
			int[] variableValue);
}