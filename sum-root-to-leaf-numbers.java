// small passed
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*{5,3,2,7,0,6,#,#,#,0}	1593	6363	** not passed

          5
        /   \
       3    2
      /\    /
     7  0  6 
       /
      0
   
537+5300+526=
*/

/* NOTE:
I think this problem can also be solved by non-recursive method
like post-order traversal of the tree
*/


public class Solution {
    public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		for (String i: numbers(root)) {
			sum += Integer.valueOf(i);
		}
		return sum;
    }
	
	public ArrayList<String> numbers(TreeNode node) {
		ArrayList<String> list = new ArrayList<String>();
		
		if (node.left == null && node.right == null) {
			// this is a leaf
			list.add(Integer.toString(node.val));
			return list;
		}
		if (node.left != null) {
			for (String s: numbers(node.left)) {
				list.add(new String(node.val + s));
			}
		}
		if (node.right != null) {
			for (String s: numbers(node.right)) {
				list.add(new String(node.val + s));
			}
		}
		return list;
	}
}

/* test cases
Run Status: Accepted!
Program Runtime: 572 milli secs
Progress: 10/10 test cases passed.
input	output	expected	
{}	0	0	
   
{0}	0	0	
   
{9}	9	9	
   
{0,1}	1	1	
   
{0,1,3}	4	4	
   
{1,0}	10	10	
   
{2,0,0}	40	40	
   
{1,#,5}	15	15	
   
{1,2,3}	25	25	
   
{4,9,0,#,1}	531	531	
   
Run Status: Accepted!
Program Runtime: 720 milli secs
Progress: 109/109 test cases passed.
input	output	expected	
{}	0	0	
   
{0}	0	0	
   
{9}	9	9	
   
{0,1}	1	1	
   
{0,1,3}	4	4	
   
{1,0}	10	10	
   
{2,0,0}	40	40	
   
{1,#,5}	15	15	
   
{1,2,3}	25	25	
   
{4,9,0,#,1}	531	531	
   
{2,1,#,4,#,7,#,4,#,8,#,3,#,6,#,4,#,7}	2147483647	2147483647	
   
{6,4,1,6,#,#,#,#,4,2,#,6}	646487	646487	
   
{0,#,0,6,#,8,#,7}	687	687	
   
{8,3,5,#,9,#,#,9,5}	16879	16879	
   
{0,8,6}	14	14	
   
{6,8,#,7,3,#,8}	7561	7561	
   
{1,5,1,#,#,#,6}	131	131	
   
{2,7,4,#,4,0,#,#,2,#,#,#,1}	27661	27661	
   
{9,0,3,#,#,2,#,3,4,#,#,#,7}	102660	102660	
   
{3,4,1}	65	65	
   
{3,#,6,#,1}	361	361	
   
{5,3,2,7,0,6,#,#,#,0}	6363	6363	
   
{9,2,7,#,5,#,8,#,#,#,6}	10711	10711	
   
{7,2,4,#,#,#,9}	821	821	
   
{2,4,5,7,#,4,#,9,3}	5206	5206	
   
{3,#,9,8,2,#,#,5,2}	8245	8245	
   
{4,7,6,0,#,6,#,1}	5167	5167	
   
{4,6,4,#,5,#,9,#,0,#,#,#,5}	46954	46954	
   
{1,0,2,8,5}	225	225	
   
{0,7,9}	16	16	
   
{5,4,2,#,#,#,2}	576	576	
   
{4,8,3,5,#,2}	917	917	
   
{5,#,7,8}	578	578	
   
{0,7,4,4,6,#,#,#,2,#,#,3}	7503	7503	
   
{2,7,9}	56	56	
   
{6,5,#,#,0}	650	650	
   
{0,3,6,#,#,1,6,#,#,0}	724	724	
   
{6,3,#,1,6}	1267	1267	
   
{8,5,3,6,4,#,#,#,#,4,#,#,8}	86387	86387	
   
{6,9,4,4}	758	758	
   
{8,4,9,#,#,#,8}	982	982	
   
{5,#,4,7}	547	547	
   
{3,9,#,9,5}	794	794	
   
{8,5,3,1,#,2,#,#,#,#,4}	9175	9175	
   
{4,6,5,8}	513	513	
   
{8,6,5}	171	171	
   
{9,2,0,8,0,0,#,#,#,#,0}	11028	11028	
   
{6,0,1,#,3,9,0,#,#,2}	7405	7405	
   
{4,8,7}	95	95	
   
{9,#,7,6,#,#,8}	9768	9768	
   
{7,6,1,#,3,#,3,#,4,#,8}	14772	14772	
   
{2,5,#,1}	251	251	
   
{0,9,#,#,0}	90	90	
   
{5,6,1,#,#,1,#,#,3,#,7,#,6}	511432	511432	
   
{1,3,8,#,1,#,8,#,6}	1504	1504	
   
{8,8,5,3,#,3,#,#,#,#,1,#,2}	86195	86195	
   
{0,#,9,2,0,#,9,1}	1830	1830	
   
{9,6,#,9}	969	969	
   
{2,#,2,3,#,#,2,5}	22325	22325	
   
{6,1,3,#,#,9,#,#,5}	6456	6456	
   
{8,#,1,0}	810	810	
   
{6,0,3,#,8}	671	671	
   
{9,8,0,#,#,3,#,#,9}	9137	9137	
   
{5,4,4,#,#,3,#,7}	5491	5491	
   
{5,5,2,#,#,5,#,5,#,#,6}	52611	52611	
   
{9,#,0,9,#,6}	9096	9096	
   
{0,4,7}	11	11	
   
{6,#,3,#,6}	636	636	
   
{9,2,#,6,3,#,#,0}	10156	10156	
   
{7,3,8,7,6,#,#,#,#,8}	8183	8183	
   
{5,8,2,9,#,5,#,#,7}	6422	6422	
   
{4,8,2,6,1,#,#,#,#,#,8,3,8,9}	530555	530555	
   
{3,1,4,3,9,#,#,1,5}	6619	6619	
   
{2,2,5,9,#,5}	484	484	
   
{3,3,1,4,1,#,#,#,#,#,8}	3683	3683	
   
{8,#,4,#,6,0,#,#,1}	84601	84601	
   
{3,1,#,0,0,#,7}	3417	3417	
   
{4,6,6,8,9,0,#,#,5,#,1,#,0}	13976	13976	
   
{6,4,4,#,#,#,7,2}	6536	6536	
   
{6,#,7,8,6,9,9,#,#,#,#,#,9}	75364	75364	
   
{6,#,1,5,#,0,#,#,8}	61508	61508	
   
{5,3,8,0,1,3,#,1,8,4,4,2,3,#,#,#,#,5,4,#,#,7,#,#,6,#,#,#,1,#,6,#,#,#,#,8,#,7}	58986532	58986532	
   
{7,4,6,7,2,4,#,5,#,1,1,#,#,8,#,#,#,4,2,3,#,#,#,1,#,#,2,3,1,#,#,#,#,8,2,#,9}	831312745	831312745	
   
{7,8,6,1,8,#,0,9,7,4,#,#,#,6,0,9,#,2,#,#,2,#,4,#,0,#,0,#,#,#,#,#,#,#,6,#,3,#,1}	790767047	790767047	
   
{1,2,9,0,#,5,#,6,7,2,3,#,#,#,#,1,1,#,#,2,6,#,5,2,5,#,#,#,8,#,#,#,5,#,#,#,4,#,9}	1956229411	1956229411	
   
{9,6,3,3,1,8,8,6,#,#,0,#,3,6,#,#,5,7,8,#,#,6,#,#,#,#,#,1,2,#,#,9,#,1,4}	29128185	29128185	
   
{6,1,0,8,4,6,7,5,1,9,3,#,#,3,#,2,#,#,#,#,#,#,#,4,8,6,#,7,1,#,#,#,#,#,#,0,#,0}	62039790	62039790	
   
{6,8,8,4,#,7,4,1,5,3,1,9,8,#,#,#,#,5,0,1,#,#,6,5,#,#,0,#,#,#,#,#,#,#,9,#,#,#,8}	7755571	7755571	
   
{3,4,1,4,1,#,#,7,7,3,1,#,#,1,4,8,6,#,#,8,2,2,#,#,#,8,#,#,#,#,#,#,#,#,8,2,4}	69348965	69348965	
   
{0,8,1,5,8,1,9,#,9,#,#,#,#,7,1,#,9,#,#,0,4,7,2,#,#,#,#,#,6,6,8,#,5,#,#,#,4}	18063095	18063095	
   
{8,2,6,#,8,3,1,1,1,3,8,3,2,#,#,#,#,3,2,#,#,#,#,2,6,#,#,#,1,#,3,5,#,#,#,6}	10456968	10456968	
   
{4,7,1,2,6,9,2,3,#,2,#,8,1,#,#,2,3,#,#,#,0,0,9,#,#,7,#,#,#,3,4,4,0,#,3,#,#,#,#,#,8,#,#,5,#,#,#,#,1}	477881082	477881082	
   
{2,1,3,8,9,9,3,2,1,0,#,#,#,#,3,7,9,0,1,#,#,#,#,#,#,#,4,#,#,8,4,7,5,3,#,#,#,#,#,#,#,5,7,#,#,8,6}	462680994	462680994	
   
{8,7,2,1,5,8,2,#,#,9,#,0,1,9,#,4,0,0,8,#,4,#,#,1,4,5,#,#,#,#,3,#,#,#,6,#,#,#,#,1,4,#,#,#,#,#,3,8}	847050248	847050248	
   
{2,5,9,3,3,0,1,0,2,#,#,#,4,#,#,#,7,6,2,#,0,3,3,2,#,#,#,1,8,8,#,#,2,#,#,4,6,#,#,#,#,0,#,#,#,#,2}	60351770	60351770	
   
{4,8,0,1,4,6,9,5,7,#,#,4,0,#,6,#,#,9,3,8,3,#,3,6,#,#,8,7,#,6,#,#,#,#,#,2,#,#,#,9,4,#,#,6}	14706208	14706208	
   
{3,8,7,4,#,1,2,7,#,7,5,#,3,9,#,9,8,#,2,6,#,1,5,#,#,#,#,6,#,#,#,#,#,6,1,2,#,#,6,#,8,5,#,#,#,#,#,7}	448981725	448981725	
   
{1,8,6,#,2,5,0,#,3,1,#,7,0,5,#,2,#,2,9,#,8,#,#,#,#,8,8,4,#,#,3,2,#,#,#,9,9,#,5,#,#,#,9,#,7}	35562588	35562588	
   
{1,9,3,1,4,1,8,#,3,5,6,#,7,#,4,#,5,0,3,7,#,#,#,7,#,3,0,#,#,#,#,4,#,#,#,#,0,#,5,#,#,4,#,#,#,7,#,3}	1915692719	1915692719	
   
{5,4,4,#,9,0,9,9,7,9,2,6,3,#,#,2,#,#,#,9,#,#,0,0,8,#,#,#,7,4,2,#,1,#,7,1,4,#,#,#,5,#,#,#,#,#,#,5,2,1,3,4}	711364843	711364843	
   
{1,8,7,5,7,4,#,7,#,3,4,5,9,8,#,4,2,9,1,#,#,#,8,#,#,1,6,#,6,7,8,#,#,#,#,#,5,#,8,4,#,#,#,#,#,#,#,1,1,1,#,#,#,#,8,#,#,#,6}	1913240480	1913240480	
   
{7,0,9,1,9,4,1,#,9,0,1,9,#,2,1,4,#,#,#,4,9,#,0,#,#,#,9,#,#,#,#,7,7,2,8,#,#,#,#,6,0,2,1,#,#,#,#,1,#,6,#,#,0,#,#,#,4}	954143485	954143485	
   
{4,4,0,9,6,2,4,#,#,6,5,4,8,#,5,7,#,3,4,7,3,5,5,#,2,#,#,#,#,#,#,5,#,4,#,5,#,9,2,#,2,#,3,#,#,#,6,#,#,7,#,#,#,#,#,#,#,#,8}	49682825	49682825	
   
{8,5,5,6,0,4,3,9,#,6,0,2,5,9,1,#,#,1,6,#,0,#,6,8,#,#,#,#,5,#,1,#,#,0,2,#,#,#,#,9,7,1,#,0,9,#,3,#,#,#,#,#,#,#,#,#,#,3}	112485727	112485727	
   
{2,0,0,1,8,7,9,7,#,#,9,5,8,7,1,#,9,9,2,#,3,6,#,9,1,#,#,#,3,#,#,#,2,#,#,#,#,1,8,#,#,5,#,#,#,4,#,#,#,#,#,7,1,1,#,5}	422105041	422105041	
   
{4,7,2,0,0,2,#,5,0,#,9,1,#,2,#,4,5,5,#,5,9,8,#,1,#,#,9,#,#,#,#,#,#,9,#,#,#,0,3,8,5,7,3,6,8,#,#,#,#,#,7,#,#,5}	1128837646	1128837646	
   
{1,2,3,0,7,3,7,9,1,6,3,0,#,#,0,8,#,#,0,#,4,3,#,5,#,#,9,#,5,#,#,4,#,#,1,#,#,9,9,#,6,#,#,#,#,#,4,0,4,#,#,#,#,#,#,9,#,2}	141331622	141331622	
   
{1,4,0,5,3,4,9,#,8,6,7,9,6,2,4,8,1,7,5,#,#,1,4,#,#,9,8,2,#,#,#,#,0,0,9,#,0,9,4,2,#,0,0,#,8,3,4,#,#,#,#,5,#,#,9,0,#,0,#,#,#,7,#,1,#,#,#,1,#,#,#,#,#,3,9,#,4,#,#,6,#,#,#,#,#,#,1,#,#,#,#,7,9,#,5}	1685251126	1685251126	
   
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,#,0,#,0,0,0,0,0,0,0,0,0,0,0,0,#,#,#,#,#,0,0,0,0,0,0,0,#,0,0,#,0,0,0,0,0,0,0,0,0,0,0,0,0,#,0,0,#,#,#,#,0,0,0,0,0,0,#,0,0,0,0,0,0,#,0,0,0,0,0,0,0,0,0,0,#,#,#,0,#,#,0,0,0,#,#,#,#,#,#,#,0,#,0,0,#,#,#,0,0,0,#,#,0,0,#,#,0,0,0,0,0,0,0,0,0,0,#,0,0,#,0,0,#,0,0,0,0,0,0,0,#,#,#,#,#,#,0,0,0,0,0,0,0,0,0,#,0,#,0,0,0,0,0,0,0,0,0,#,0,0,0,0,0,0,#,0,#,#,0,0,0,0,0,#,#,0,#,0,0,0,#,#,0,0,0,0,0,0,0,#,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,#,#,0,0,0,#,0,0,0,0,#,#,0,0,0,0,#,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,#,0,0,0,0,0,0,0,#,#,#,0,#,0,#,0,0,0,0,0,#,0,0,0,#,0,0,0,0,0,0,0,0,0,0,0,0,#,0,#,#,0,0,0,0,#,#,0,#,0,#,0,0,#,0,0,#,#,#,0,0,0,0,0,0,0,#,0,#,0,0,0,0,#,0,0,0,#,0,0,0,#,0,0,0,#,0,0,0,0,0,#,0,0,0,#,#,#,#,0,#,0,#,#,0,0,#,#,0,0,#,#,#,0,0,#,#,0,0,0,#,#,#,#,#,0,0,0,0,#,#,0,0,0,0,0,0,#,0,0,0,0,0,0,0,0,0,0,0,0,#,#,#,0,0,0,0,0,0,#,#,0,0,#,#,0,0,#,#,#,#,#,#,#,0,#,0,#,#,#,#,#,#,0,0,#,#,0,0,0,0,0,0,#,0,0,0,#,0,#,#,0,0,0,0,0,#,0,0,0,0,0,0,#,#,0,#,0,0,0,0,0,#,0,#,0,0,0,#,0,0,#,#,0,0,0,#,#,0,#,#,#,#,0,0,#,0,0,0,#,#,0,#,0,#,0,#,0,0,#,0,0,0,#,0,#,#,0,0,#,#,#,0,#,#,0,0,0,0,#,#,0,0,#,0,0,0,#,#,#,0,0,0,#,#,0,0,0,0,#,0,#,#,0,0,0,#,0,#,#,#,#,#,0,0,0,0,0,#,#,#,#,0,#,#,0,0,#,#,0,0,#,0,#,#,0,#,0,0,#,0,0,#,#,0,0,0,0,0,#,#,#,0,0,0,#,#,0,0,0,0,0,0,0,0,0,0,0,0,0,#,0,0,0,0,#,0,#,0,0,0,#,#,#,0,0,0,0,#,0,#,0,#,0,#,#,#,#,0,0,#,0,0,0,#,0,#,0,0,0,0,#,#,#,0,0,0,#,0,#,#,0,0,0,0,0,0,#,#,#,#,#,#,0,#,#,#,0,#,#,#,#,#,#,#,0,#,0,#,0,0,0,0,0,0,0,0,#,#,#,#,0,0,0,#,0,0,#,#,#,#,#,0,0,#,0,#,0,#,#,#,0,0,#,0,0,0,0,0,#,0,0,#,0,#,0,0,#,#,#,0,#,#,0,#,0,#,#,#,0,#,#,#,0,0,#,0,#,0,0,#,#,#,#,#,0,#,#,0,#,#,#,#,0,#,#,#,#,0,0,0,0,0,0,#,0,#,#,#,0,#,#,#,#,#,0,#,0,0,#,#,0,0,0,0,0,0,0,#,0,#,0,#,#,#,#,#,0,0,0,0,#,#,0,#,0,#,0,#,0,#,#,#,#,#,#,0,#,0,0,0,0,#,0,0,#,#,0,0,#,0,0,0,0,0,0,0,0,0,#,0,#,0,#,#,0,0,0,0,0,#,0,0,#,#,#,#,0,0,0,0,0,0,0,0,#,0,#,#,0,#,0,0,#,#,#,0,#,#,0,0,0,0,0,0,0,0,#,#,#,#,#,#,0,0,#,#,0,0,#,#,0,0,#,#,0,0,0,0,#,#,0,#,#,#,0,0,#,0,#,#,#,#,0,0,#,0,#,0,0,#,0,0,0,#,#,#,0,0,0,0,#,0,#,#,#,#,#,#,#,#,#,#,0,#,#,0,#,#,#,0,#,#,0,0,0,0,#,#,#,#,#,#,#,#,#,0,#,#,0,#,#,#,0,#,#,0,#,#,#,#,#,#,0,0,0,0,#,#,#,#,0,#,#,#,0,0,#,0,#,0,0,#,0,0,#,#,#,#,#,#,#,#,0,#,#,#,#,#,#,#,0,#,#,0,#,#,0,#,0,#,#,#,#,#,#,0,0,0,0,#,#,0,#,#,#,#,0,0,0,0,0,#,0,0,#,0,#,0,#,#,0,0,0,0,#,#,0,0,#,#,#,0,#,#,0,0,0,#,#,0,#,0,0,0,#,0,0,0,0,0,#,0,0,0,0,0,0,0,#,#,#,#,#,0,0,0,0,#,0,#,0,0,0,#,0,#,#,#,0,#,#,#,#,0,0,0,#,#,#,#,0,0,0,0,#,#,0,#,#,0,0,0,0,0,0,0,#,#,0,#,0,0,0,0,0,#,0,0,0,0,0,#,0,0,0,0,0,0,#,#,#,#,0,#,#,#,0,#,#,#,0,#,0,#,#,0,#,#,#,0,#,#,#,#,0,#,#,#,#,#,#,#,0,#,#,#,#,0,#,0,#,#,#,#,#,#,#,#,#,#,0,#,#,#,#,0,0,0,#,0,0,0,#,#,0,#,#,#,#,#,0,#,#,#,#,#,#,#,0,0,#,0,#,0,0,0,#,#,0,0,0,0,0,#,#,0,#,#,#,#,#,#,#,#,#,#,0,#,#,#,0,#,0,0,0,0,#,0,0,0,0,0,#,0,0,#,#,0,0,#,#,#,0,0,0,0,#,#,0,0,0,#,#,0,0,#,#,#,#,0,#,#,0,#,#,0,0,0,0,0,#,#,#,#,#,0,0,#,0,#,0,#,#,#,#,#,#,0,0,#,#,#,0,0,0,#,#,0,#,#,#,#,#,#,#,0,#,#,#,0,#,#,#,#,#,0,0,#,#,#,#,0,#,#,0,#,#,#,0,0,#,#,#,#,0,#,#,#,#,0,#,#,#,#,#,#,#,#,0,#,#,0,#,#,#,#,#,#,#,#,#,0,#,#,#,0,#,#,#,#,#,0,0,#,#,#,#,#,#,#,#,#,#,0,#,#,0,#,#,#,#,#,#,#,#,#,0,#,0,#,#,0,#,#,#,#,#,#,#,#,0,#,#,#,#,#,0,#,#,#,#,#,#,#,#,#,#,0,#,#,0,0,0,0,0,0,0,0,0,0,0,#,0,0,#,#,0,#,0,#,#,0,0,0,0,0,#,0,#,#,#,0,0,0,0,#,0,#,0,0,0,#,#,#,#,0,0,0,0,0,#,#,#,#,#,#,#,#,#,#,#,#,0,#,0,0,0,#,#,0,#,#,#,#,#,#,#,#,#,#,#,#,#,0,#,#,0,0,#,#,#,#,#,#,#,#,#,#,0,#,#,#,#,#,#,#,0,#,#,#,#,#,0,#,0,#,#,#,#,0,0,0,0,0,#,#,0,0,#,#,#,#,0,0,0,0,0,0,0,0,0,#,0,#,#,#,0,0,#,0,0,0,0,#,#,0,#,#,#,#,#,#,#,#,#,#,#,0,#,#,#,#,0,#,#,#,0,0,0,#,#,#,0,#,0,#,#,#,#,0,0,#,0,#,#,#,#,0,0,#,#,0,#,#,#,#,#,0,#,#,0,#,#,#,#,#,0,0,0,#,0,0,#,#,#,#,0,0,0,0,0,0,#,#,0,#,#,0,#,#,0,0,0,0,#,#,#,#,#,#,#,0,#,#,0,#,#,#,0,#,#,#,0,0,#,0,#,#,#,#,#,#,#,#,0,0,0,0,#,#,#,#,#,#,0,#,#,0,#,#,#,#,0,#,#,#,#,#,#,#,#,0,0,0,0,#,0,2,#,0,#,0,0,#,#,#,#,0,0,0,#,0,#,#,#,#,#,#,#,#,0,#,0,0,#,#,#,#,#,0,0,#,0,0,#,#,#,#,#,#,#,#,#,#,0,#,0,#,#,#,0,#,#,0,0,0,#,#,0,#,#,#,#,#,#,#,#,#,#,0,#,#,#,1,#,#,0,#,#,#,0,0,#,#,#,#,#,#,0,0,#,#,#,#,0,#,#,#,#,#,0,#,#,#,#,#,#,#,#,3}	2204	2204	
  
*/