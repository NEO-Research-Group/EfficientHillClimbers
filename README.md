# Gray-Box Optimization Operators and Algorithms

You can find in this repository the source code of the algorithms implemented for the scientific papers listed:

* Gabriela Ochoa and Francisco Chicano, "Local Optima Network Analysis for MAX-SAT", Landscape-Aware Heuristics Search Workshop at GECCO 2019 (https://doi.org/10.1145/3319619.3326855)

* Francisco Chicano, Gabriela Ochoa, Darrell Whitley and Renato Tinós, "Quasi-Optimal Recombination Operator", EvoCOP 2019 (https://doi.org/10.1007/978-3-030-16711-0_9)

* Francisco Chicano, Gabriela Ochoa, Darrell Whitley and Renato Tinós, "Enhancing Partition Crossover with Articulation Points Analysis", GECCO 2018 (https://doi.org/10.1145/3205455.3205561)

* Francisco Chicano, Darrell Whitley, Gabriela Ochoa and Renato Tinós, "Optimizing One Million Variable NK Landscapes by Hybridizing Deterministic Recombination and Local Search", GECCO 2017 (https://doi.org/10.1145/3071178.3071285)

* Francisco Chicano, Darrell Whitley and Renato Tinós, "Efficient Hill Climber for Constrained Pseudo-Boolean Optimization Problems", GECCO 2016 (https://doi.org/10.1145/2908812.2908869)

* Francisco Chicano, Darrell Whitley and Renato Tinós, "Multi-Objective Pseudo-Boolean Optimization", EvoCOP 2016 (http://dx.doi.org/10.1007/978-3-319-30698-8_7)
 
In the following sections you will find instructions to run the algorithms in the papers. The name of the jar file generated by this commit is EfficientHillClimbers-0.7-GECCO2018.jar


# Local Optima Network Analysis for MAX-SAT (LAHS @ GECCO 2019)

In order to run the algorithms you need first to compile and package them into a JAR file (see instructions at the bottom of the page). Then, you can run them with the following commands:

* For random MAX-SAT instances

```
java -jar <jarfile name> drils -problem maxsat -crossover none -Pn=40 -Ppseed=<m> -Pm=<m> -Pmaxk=3 -time 60 -r 1 -mf 0.05 -lon -improvingLo
```

where `<m>` is the number of clauses. The previous command can be repeated 100 times to generate the 100 independent runts. Use the `-aseed` option to establish the algorithm random seed.

* For maxcut instances

```
java -jar <jarfile name> drils -problem maxsat -crossover none -Pinstances=<instance> -time 60 -r 1 -mf 0.05 -lon -improvingLo
```

where `<instance>` is the file of the instance to be used in `wcnf.gz` format. 


# Quasi-Optimal Recombination Operator (EvoCOP 2019)

In order to run the algorithms you need first to compile and package them into a JAR file (see instructions at the bottom of the page). Then, you can run them with the following commands:

* For DRILS+DPX solving NKQ Landscapes

```
java -jar <jarfile name> drils+dpx-nk  <options omitted>
```

The instances were randomly generated using the options. The seed for generating the instances was set using the -pseed option with values from 1 to 10.

* For DRILS+DPX solving MAX-SAT

```
java -jar <jarfile name> drils+dpx-maxsat  <options omitted>
```

For the experiments of the paper some of the MAX-SAT weighted and unweighted incomplete benchmark was used. The ZIP files with the instances can be found at [http://mse17.cs.helsinki.fi/benchmarks.html](http://mse17.cs.helsinki.fi/benchmarks.html). The MAX-SAT weighted instances used in the experiments are listed in file [maxsat-instances-weigthed-evocop2019.txt](maxsat-instances-weigthed-evocop2019.txt). The MAX-SAT unweighted instances used in the experiments are listed in file [maxsat-instances-unweigthed-evocop2019.txt](maxsat-instances-unweigthed-evocop2019.txt).

* For DRILS with PX or APX see the instructions below for the GECCO 2018 paper

To see the options, just run the algorithms without options. 


# Enhancing Partition Crossover with Articulation Points Analysis (GECCO 2018)

In order to run the algorithms you need first to compile and package them into a JAR file (see instructions at the bottom of the page). Then, you can run them with the following commands:

* For DRILS+APX solving NKQ Landscapes

```
java -jar <jarfile name> drils+apx-nk  <options omitted>
```

* For DRILS+APX solving MAX-SAT

```
java -jar <jarfile name> drils+apx-maxsat  <options omitted>
```

* For DRILS (using PX) solving NKQ Landscapes

```
java -jar <jarfile name> drils-nk  <options omitted>
```

* For DRILS (using PX) solving MAX-SAT

```
java -jar <jarfile name> drils-maxsat <options omitted>
```

To see the options, just run the algorithms without options. 


# Optimizing One Million Variable NK Landscapes by Hybridizing Deterministic Recombination and Local Search (GECCO 2017)

In order to run the algorithms you need first to compile and package them into a JAR file (see instructions at the bottom of the page). Then, you can run them with the following commands:

* For HiReLS

```
java -jar <jarfile name> px  <options omitted>
```

* For DRILS

```
java -jar <jarfile name> rball+ils+px  <options omitted>
```

To see the options, just run the algorithms without options. 

# Multi-objective Hamming Ball Hill Climber (GECCO 2016 and EvoCOP 2016)


In order to run the Multi-Objective Hamming Ball Hill Climber of EvoCOP 2016 select the "mo-hbhc" experiment using this string as the first argument after the JAR file name:

```
java -jar <jarfile name> mo-hbhc
```

In order to run the Hill Climber for Constrained Problems (explained in the GECCO 2016 paper), you should select the "moc-hbhc" experiment:

```
java -jar <jarfile name> moc-hbhc
```

If you run without any other argument, a list of all the options will appear with an explanation of their meaning.


**Note**: After submitting the camera-ready of the EvoCOP 2016 paper, a bug was found that could affect the results. In this branch the bug is fixed. The exact version used for the experiments in the EvoCOP 2016 paper is commit: https://github.com/jfrchicanog/EfficientHillClimbers/commit/213036ef593bb25617b48dcb58e81097a3437d71 .


# Instructions to build the software

The repository contains Java code shipped as a maven project. Maven 3 is needed as prerequisite. In order to build the executable JAR file open the command line and write:

```
mvn package
```

This will generate a JAR file in the target directory with all the dependencies included. To run the JAR file write:

```
java -jar <jarfile name>
```

The list of options are the different experiments available.

