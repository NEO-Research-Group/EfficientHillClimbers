package neo.landscape.theory.apps.pseudoboolean.util;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.Assert;

public class DisjointSetsTest {

	@Test
	public void test() {
		Set<Set<Integer>> partition = Stream.of(
				Stream.of(1, 2, 3, 4).collect(Collectors.toSet()),
				Stream.of(5, 6, 7, 8).collect(Collectors.toSet()),
				Stream.of(0, 9, 10, 11).collect(Collectors.toSet()),
				Stream.of(12).collect(Collectors.toSet()),
				Stream.of(13).collect(Collectors.toSet())
				)
				.collect(Collectors.toSet());
		
		Set<Integer> allNumbers = partition.stream().flatMap(Set::stream).collect(Collectors.toSet());
		int [] parent = new int [allNumbers.size()];
		int [] rank = new int [allNumbers.size()];
		
		DisjointSets djs = new DisjointSetArrays(parent, rank);
		djs.clear();
		allNumbers.forEach(n->djs.makeSet(n));
		
		check(djs, partition);
		
	}
	
	@Test
	public void testReuse() {
		Set<Set<Integer>> partition = Stream.of(
				Stream.of(1, 2, 3, 4).collect(Collectors.toSet()),
				Stream.of(5, 6, 7, 8).collect(Collectors.toSet()),
				Stream.of(0, 9, 10, 11).collect(Collectors.toSet()),
				Stream.of(12).collect(Collectors.toSet()),
				Stream.of(13).collect(Collectors.toSet())
				)
				.collect(Collectors.toSet());
		
		Set<Integer> allNumbers = partition.stream().flatMap(Set::stream).collect(Collectors.toSet());
		int [] parent = new int [allNumbers.size()];
		int [] rank = new int [allNumbers.size()];
		
		DisjointSets djs = new DisjointSetArrays(parent, rank);
		djs.clear();
		allNumbers.forEach(n->djs.makeSet(n));
		
		check(djs, partition);
		
		djs.clear();
		allNumbers.forEach(n->djs.makeSet(n));
		
		Set<Set<Integer>> partition2 = Stream.of(
				Stream.of(10, 2, 4).collect(Collectors.toSet()),
				Stream.of(5, 7, 8).collect(Collectors.toSet()),
				Stream.of(0, 9, 6, 1, 11).collect(Collectors.toSet()),
				Stream.of(12, 3).collect(Collectors.toSet()),
				Stream.of(13).collect(Collectors.toSet())
				)
				.collect(Collectors.toSet());
		
		check(djs, partition2);
		
	}
	
	private void check (DisjointSets djs, Set<Set<Integer>> partition) {
		
		
		
		
		
		partition.forEach(set -> {
			Integer previous = null;
			for (Integer x: set) {
				if (previous != null) {
					djs.union(x, previous);
				}
				previous = x;
			}
		});
		
		partition.forEach(set -> {
			Integer previous = null;
			for (Integer x: set) {
				if (previous != null) {
					Assert.assertTrue("Two elements not in same partition", djs.sameSet(x, previous));
				}
				previous = x;
			}
		});
		
		Set<Integer> representatives = new HashSet<>();
		
		for (Set<Integer> set: partition) {
			int r =djs.findSet(set.stream().findAny().get());
			representatives.add(r);
		}
		
		Assert.assertEquals("Size of partitions changes", partition.size(), representatives.size());
		Assert.assertEquals(partition.size(), djs.getNumberOfSets());
		
	}

}
