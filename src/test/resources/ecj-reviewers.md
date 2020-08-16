# Dynastic Potential Crossover Operator (paper submitted to Evolutionary Computation)

In this file we provide instructions to build and run the code associated to the paper "Dynastic Potential Crossover Operator" by F. Chicano, G. Ochoa, D: Whitley and R. Tinós. This paper is currently under review. 
This paper is an extension of the paper Quasi-Optimal Recombination Operator (EvoCOP 2019). The source code of the EvoCOP paper can be found in this repository in the [EvoCOP2019 tag](https://github.com/jfrchicanog/EfficientHillClimbers/tree/EvoCOP2019).

Please, be sure that you select the correct branch before running the commands (otherwise you will not generate the same binary file). The branch is [dpx-ecj](https://github.com/jfrchicanog/EfficientHillClimbers/tree/dpx-ecj).


# Instructions to build the software

The repository contains Java code shipped as a maven project. Maven 3 is needed as prerequisite. In order to build the executable JAR file open the command line and write:

```
mvn package
```

You can use the `-DskipTests` option to speed up the construction. This will generate a JAR file in the target directory with all the dependencies included. To run the JAR file write:

```
java -jar <jarfile name>
```

The list of options are the different experiments available. We describe here options for the jar file EfficientHillClimbers-0.15-DPX.jar


# Options to run DRILS

In order to run DRILS you need first to compile and package them into a JAR file (see instructions above). Then, you can run them with the following commands:

```
java -jar <jarfile name> drils  <options omitted>
```

Two important options are `-problem` and `-crossover`, which determine the problem to be solved (`nk` for NK Landscapes and `maxsat` for MAX-SAT) and the crossover operator used (the options are `ux`, `nx`, `spx`, `px`, `apx`, `dpx` for uniform, network, single-point, partition, articulation points partition and dynastic potential crossovers, respectively). Running the command above with options will generate a message with all the options and their meaning. The options for the problem are given using the format `-P<key>=<value>`. The options for the crossover operator are given using the format `-X<key>=<value>`. For example, running `java -jar EfficientHillClimbers-0.15-DPX.jar drils -problem nk -crossover dpx` will generate the next output:
```
usage: drils
 -aseed <arg>          random seed for the algorithm (optional)
 -crossover <arg>      crossover operator to use: [ux, apx, px, spx, nx,
                       dpx]
 -debug                enable debug information
 -expSols <arg>        explored solutions limit
 -improvingLo          accept only non disimproving local optima in ILS
 -lon                  print the PX Local Optima Network
 -lonmin <arg>         minimum fitness to consider a LON (optional)
 -mf <arg>             proportion of variables used for the random walk in
                       the perturbation
 -P <property=value>   properties for the problem
 -problem <arg>        problem to be solved: [maxsat, nk]
 -r <arg>              radius of the Hamming Ball hill climber
 -time <arg>           execution time limit (in seconds)
 -X <property=value>   properties for the crossover operator
usage: Problem: nk
 -k <arg>       number of subfunction arguments
 -model <arg>   NK-model: adjacent, random, <number>->Localized
 -n <arg>       number of variables
 -pseed <arg>   random seed for generating the problem
 -q <arg>       cardinality of subfunction domain
usage: Crossover: dpx
 -debug          enable debug information
 -exhexp <arg>   maximum number of variables to exhaustively explore in
                 crossover (DPX): negative value is equivalent to no limit
``` 


# Options to run EA

In order to run EA you need first to compile and package them into a JAR file (see instructions above). Then, you can run them with the following commands:

```
java -jar <jarfile name> ea  <options omitted>
```

Two important options are `-problem` and `-crossover`, which determine the problem to be solved (`nk` for NK Landscapes and `maxsat` for MAX-SAT) and the crossover operator used (the options are `ux`, `nx`, `spx`, `px`, `apx`, `dpx` for uniform, network, single-point, partition, articulation points partition and dynastic potential crossovers, respectively). Running the command above with options will generate a message with all the options and their meaning. The options for the problem are given using the format `-P<key>=<value>`. The options for the crossover operator are given using the format `-X<key>=<value>`. For example, running `java -jar EfficientHillClimbers-0.15-DPX.jar ea -problem nk -crossover dpx` will generate the next output:
```
usage: ea
 -alpha <arg>          alpha/N is the mutation probability, except if it
                       is stablished by mutationProb (optional, default=1)
 -aseed <arg>          random seed for the algorithm (optional)
 -crossover <arg>      crossover operator to use: [ux, apx, px, spx, nx,
                       dpx]
 -debug                enable debug information
 -expSols <arg>        explored solutions limit
 -mutationProb <arg>   bit flip mutation probability (optional)
 -P <property=value>   properties for the problem
 -population <arg>     number of solution in the population
 -problem <arg>        problem to be solved: [maxsat, nk]
 -time <arg>           execution time limit (in seconds)
 -X <property=value>   properties for the crossover operator
usage: Problem: nk
 -k <arg>       number of subfunction arguments
 -model <arg>   NK-model: adjacent, random, <number>->Localized
 -n <arg>       number of variables
 -pseed <arg>   random seed for generating the problem
 -q <arg>       cardinality of subfunction domain
usage: Crossover: dpx
 -debug          enable debug information
 -exhexp <arg>   maximum number of variables to exhaustively explore in
                 crossover (DPX): negative value is equivalent to no limit
``` 

# MAX-SAT instances

For the experiments of the paper some of the MAX-SAT weighted and unweighted incomplete benchmark was used. The ZIP files with the instances can be found at [http://mse17.cs.helsinki.fi/benchmarks.html](http://mse17.cs.helsinki.fi/benchmarks.html). The MAX-SAT weighted instances used in the experiments are listed in file [maxsat-instances-weigthed-evocop2019.txt](../../../maxsat-instances-weigthed-evocop2019.txt). The MAX-SAT unweighted instances used in the experiments are listed in file [maxsat-instances-unweigthed-evocop2019.txt](../../../maxsat-instances-unweigthed-evocop2019.txt).
