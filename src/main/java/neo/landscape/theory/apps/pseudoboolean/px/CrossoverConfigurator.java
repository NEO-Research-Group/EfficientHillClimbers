package neo.landscape.theory.apps.pseudoboolean.px;

import java.io.PrintStream;
import java.util.Properties;

import org.apache.commons.cli.Options;

import neo.landscape.theory.apps.pseudoboolean.problems.EmbeddedLandscape;

public interface CrossoverConfigurator {
    public void prepareOptionsForCrossover(Options options);
    public Crossover configureCrossover(Properties properties, EmbeddedLandscape el, PrintStream ps);
}