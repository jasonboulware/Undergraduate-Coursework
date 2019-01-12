package edu.cofc.csci230;

public class Test {

	public static void main(String[] args) {
		int h_k = 0;
		int M = 307;

		String key = "introduced";
		int hashKey = 0;
		for (int i = 0; i < key.length(); i++) {
			char cha = key.charAt(i);
			hashKey += (int) cha;
		}
		h_k = hashKey % M;
		// h_k = (1 + 2 * ((hashKey % M) + 1)) % M;
		System.out.println(h_k);

		String s = "^^^^cat";
		System.out.println(s.substring(0, s.lastIndexOf("^") + 1));

		String[] a = new String[10];

		a[0] = "Fuck";

		System.out.println(Math.pow(12, 2));

		String st = "honya";
		System.out.println(st.toCharArray().length);

		// System.out.println();
		//
		// int index = calcHash(key);
		//
		// if (hash_table[index] == null)
		//
		// throw new HashTableKeyException("'" + key + "' not in table");
		//
		// else {
		//
		// if (hash_table[index].contains("^")) {
		//
		// probes++;
		//
		// String temp = hash_table[index].replaceAll("\\^", "");
		//
		// if (temp.equals(key)) {
		//
		// hash_table[index] = hash_table[index].substring(0,
		// hash_table[index].lastIndexOf("^") + 1);
		//
		// return probes;
		// }
		// index++;
		// }
		//
		// while (hash_table[index] != null) {
		//
		// probes++;
		//
		// if (hash_table[index].contains("^")) {
		//
		// String temp = hash_table[index].replaceAll("\\^", "");
		//
		// if (temp.equals(key)) {
		//
		// hash_table[index] = hash_table[index].substring(0,
		// hash_table[index].lastIndexOf("^") + 1);
		//
		// hash_table[calcHash(key)] = hash_table[calcHash(key)]
		// .substring(1);
		//
		// return probes;
		// }
		// index++;
		// }
		//
		// else if (hash_table[index] == key) {
		//
		// hash_table[index] = null;
		//
		// hash_table[calcHash(key)] = hash_table[calcHash(key)]
		// .substring(1);
		//
		// return probes;
		//
		// }
		//
		// else {
		//
		// if (index == hash_table.length - 1)
		//
		// index = 0;
		//
		// else
		//
		// index++;
		//
		// }
		//
		// }
		//
		// throw new HashTableKeyException("'" + key + "' not in table");
		//
		// }
		// }

		// try {
		// hashDS.insert("cat");
		// hashDS.insert("cta");
		// hashDS.insert("tac");
		// hashDS.insert("dat");
		//
		// System.out.println(hashDS.loadFactor());
		// hashDS.insert("cta");
		// hashDS.insert("tca");
		// System.out.println(hashDS.delete("cat"));
		// hashDS.insert("cat");
		// hashDS.insert("act");
		// hashDS.insert("atc");
		// hashDS.insert("dat");
		// System.out.println(hashDS.delete("dat"));
		// System.out.println(hashDS.delete("cat"));
		// System.out.println(hashDS.delete("cta"));
		// System.out.println(hashDS.delete("tca"));
		// System.out.println(hashDS.delete("act"));
		// System.out.println(hashDS.delete("atc"));
		// hashDS.insert("cat");
		// System.out.println(hashDS.delete("cat"));
		// System.out.println(hashDS.search("tca"));
		// } catch (HashTableKeyException e) {
		//
		// e.printStackTrace();
		// }

		// DELETE METHOD!!!
		// int keyNum = calcHash(key);
		// int index = calcHash(key);
		// int collision = 0;
		//
		// if (hash_table[index] == null)
		//
		// throw new HashTableKeyException("'" + key + "' not in table");
		//
		// else {
		//
		// if (hash_table[index].contains("^")) {
		//
		// probes++;
		//
		// String temp = hash_table[index].replaceAll("\\^", "");
		//
		// String carat = hash_table[index].substring(0,
		// hash_table[index].lastIndexOf("^") + 1);
		//
		// collision = carat.toCharArray().length;
		//
		// if (temp.equals(key)) {
		//
		// hash_table[index] = hash_table[index].substring(0,
		// hash_table[index].lastIndexOf("^") + 1);
		//
		// return probes;
		// }
		// index++;
		// }
		//
		// int count = 0;
		//
		// while (collision > count) {
		// // (hash_table[index] != null) {
		//
		// probes++;
		//
		// if (hash_table[index] == null) {
		//
		// if (index == hash_table.length - 1)
		//
		// index = 0;
		//
		// else
		//
		// index++;
		// }
		//
		// else if (hash_table[index].contains("^")) {
		//
		// String temp = hash_table[index].replaceAll("\\^", "");
		//
		// if (calcHash(temp) == keyNum) {
		// count++;
		// if (temp.equals(key)) {
		//
		// hash_table[index] = hash_table[index].substring(0,
		// hash_table[index].lastIndexOf("^") + 1);
		//
		// hash_table[calcHash(key)] = hash_table[calcHash(key)]
		// .substring(1);
		//
		// return probes;
		// }
		// }
		// }
		//
		// else if (calcHash(hash_table[index]) == keyNum) {
		// count++;
		//
		// if (hash_table[index] == key) {
		//
		// hash_table[index] = null;
		//
		// hash_table[calcHash(key)] = hash_table[calcHash(key)]
		// .substring(1);
		//
		// return probes;
		// }
		//
		// }
		//
		// if (index == hash_table.length - 1)
		//
		// index = 0;
		//
		// else
		//
		// index++;
		//
		// }
		//
		// }
		//
		// throw new HashTableKeyException("'" + key + "' not in table");

		// SEARCH METHOD WORKS...I THINK
		// int index = calcHash(key);
		//
		// if (hash_table[index] == null)
		//
		// throw new HashTableKeyException("'" + key + "' not found! "
		// + probes + " probe(s)");
		//
		// else
		//
		// while (hash_table[index] != null) {
		//
		// probes++;
		//
		// if (hash_table[index].contains("^")) {
		//
		// String temp = hash_table[index].replaceAll("\\^", "");
		//
		// if (temp.equals(key)) {
		//
		// return probes;
		//
		// }
		//
		// }
		//
		// else if (hash_table[index] == key)
		//
		// return probes;
		//
		// if (index == hash_table.length - 1)
		//
		// index = 0;
		//
		// else
		//
		// index++;
		//
		// hash_table[index] = hash_table[index];
		//
		// if (hash_table[index] == null)
		//
		// throw new HashTableKeyException("'" + key + "' not found! "
		// + probes + " probe(s)!");
		//
		// }

		/**
		 * Stuff
		 */

		// try {
		// hashDS.insert("cat");
		// hashDS.insert("cta");
		// hashDS.insert("tac");
		// hashDS.insert("dat");
		// hashDS.insert("tca");
		// System.out.println(hashDS.delete("cat"));
		// hashDS.insert("cat");
		// hashDS.insert("act");
		// hashDS.insert("atc");
		// System.out.println(hashDS.delete("dat"));
		// System.out.println(hashDS.delete("cat"));
		// System.out.println(hashDS.delete("cta"));
		// System.out.println(hashDS.delete("tca"));
		// System.out.println(hashDS.delete("act"));
		// System.out.println(hashDS.delete("atc"));
		// System.out.println(hashDS.delete("tac"));
		// hashDS.insert("cat");
		// System.out.println(hashDS.delete("cat"));
		// hashDS.search("hem");
		// // System.out.println(hashDS.search("tca"));
		// } catch (HashTableKeyException e) {
		//
		// e.printStackTrace();
		// }

		// try {
		// hashDS.insert("cat");
		// hashDS.insert("cta");
		// hashDS.insert("tac");
		// // hashDS.insert("cat");
		// hashDS.insert("dat");
		//
		// System.out.println(hashDS.search("cat"));
		// System.out.println(hashDS.search("cta"));
		// System.out.println(hashDS.search("tac"));
		// // hashDS.insert("cat");
		// System.out.println(hashDS.search("dat"));
		//
		// System.out.println(hashDS.delete("cta"));
		// System.out.println(hashDS.delete("tac"));
		// System.out.println(hashDS.delete("cat"));
		// // System.out.println(hashDS.search("dat"));
		// System.out.println(hashDS.delete("dat"));
		// // System.out.println(hashDS.delete("dat"));
		//
		// } catch (HashTableKeyException e) {
		//
		// e.printStackTrace();
		// }
	}
}
