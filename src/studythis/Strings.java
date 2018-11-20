package studythis;


import java.util.*;

public class Strings {

	//alternate solution could be hash map
	//this is O(n)
	static int Anagram(String a, String b) {
		int count = 0, n = Math.min(a.length(), b.length()), found = 0, res = 0;
		
		StringBuilder y = new StringBuilder(a);
		StringBuilder z = new StringBuilder(b);		
		if (y.length() == n) {
			for (int i = 0; i < n; i++) {
				char ch = y.charAt(i);
				if (z.toString().indexOf(ch) == -1) {
					count++;					
				} else {
					found++;
					z.deleteCharAt(z.toString().indexOf(ch));					
				}
			}
			res = b.length() - found;
		} else {
			for (int i = 0; i < n; i++) {
				char ch = z.charAt(i);
				if (y.toString().indexOf(ch) == -1) {
					count++;					
				} else {
					found++;
					y.deleteCharAt(y.toString().indexOf(ch));
				}
			}
			
			res = a.length() - found;
		}
		return res + count;
	}
//________________________________________________________________________________________________________________
	//Sherlock strings
	//THIS IS FAILING ONE TEST CASE
	
	static String isValid(String s){
		int len = s.length(), y = 0, z = 0, i = 0, count_y = 0, count_z=0, count = 0;
		char ch;
		String res = "NO";
		ArrayList<Integer> counts = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		//create the map with counts of each char
		for (i = 0; i < len; i++){
			ch = s.charAt(i);
			if (map.containsKey(ch))
				map.replace(ch, (map.get(ch)+1));
			else
				map.put(ch, 1);
		}			
		
		map.forEach((k,v)->System.out.println("char: " + k + " count : " + v ));
        //remove the values only to an arraylist
		for (Map.Entry<Character,Integer> entry: map.entrySet()){
			counts.add(entry.getValue());
		}
		//sort low to high
		counts.sort(null);
		System.out.println(counts);
		
		for (i=0; i < counts.size()-1; i++){
			if (!counts.get(i).equals(counts.get(i+1))) {
				count++;	
			}						
		}
		if (count > 1){
			return "NO-";	
		} else if (count == 1){

			y = counts.get(0);
			z= counts.get(counts.size()-1);
			
			for (i =0; i < counts.size(); i++){
				if (counts.get(i) == y){
					count_y++;
				} else {
					count_z++;
				}
			}
			if (count_y ==1 || count_z == 1){
				if (Math.abs(y-z)==1){
					res = "YES-";
				}
			} else {
				res = "NO--";
			}
			
				
						
		} else {
			res = "YES---";
		}
		return res;
	}//end method
		
	public static void main(String[] args) {

		String a = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		//String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		System.out.println(isValid(a));

	}
}
