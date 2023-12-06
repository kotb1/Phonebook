package Program;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
class HuffmanNode {

	int data;
	char c;

	HuffmanNode left;
	HuffmanNode right;
}
class charachter
{
	int F;
	char c;
} // x>y
class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y)
	{
		return x.data - y.data;
	}
}
//
public class Huffman {
	public static void printCode(HuffmanNode root, String s,ArrayList<charachter> encoded) 
	{
		if (root.left== null&& root.right== null&& Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			charachter C = new charachter();
			C.c=root.c;
			C.F=Integer.parseInt(s);
			encoded.add(C);
			return;
		}
		printCode(root.left, s + "0",encoded);
		printCode(root.right, s + "1",encoded);
	}
	public static ArrayList<charachter> sort(ArrayList<charachter> g)
	{
		for (int i = 0; i < g.size(); i++) {
            for (int j = i + 1; j < g.size(); j++) {
            	charachter temp = new charachter();
                if (g.get(j).F < g.get(i).F) {
                    temp = g.get(i);
                    g.set(i,g.get(j));
                    g.set(j,temp);
                }
            }
        }
		return g;
	}
	public static ArrayList<charachter> unique (ArrayList<charachter> g)
	{
		for(int i=0;i<g.size();i++) 
		{
			for(int j=i+1;j<g.size();j++) 
			{
				if(!(g.get(j)== null) && !(g.get(i)== null)) 
				{
					if(g.get(i).c == g.get(j).c) 
					{
						g.set(j, null);
					}
				}
			}
		}
		return g;
	}
	public static int Counter(String input,char c) 
	{
		int count = 0;
		 
		for (int i = 0; i < input.length(); i++) {
		    if (input.charAt(i) == c) {
		        count++;
		    }
		}
		return count;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the String: ");
		String input = s.nextLine();
		ArrayList <charachter> charachters= new ArrayList();
		char[] charArray2 = input.toCharArray();//hello h-e-l-l-o
		int n = charArray2.length;
		for(int i=0;i<n;i++) 
		{
			int frequency = Counter(input,charArray2[i]);
			charachter k = new charachter();
			k.c=charArray2[i];
			k.F=frequency;
			charachters.add(k);
		}
		charachters=sort(charachters);
		charachters=unique(charachters);
		PrintWriter writer = new PrintWriter("Frequency.txt");
		writer.print("Charachter:Frequency");
		writer.write("\n");
		for(int i=0;i<charachters.size();i++) 
		{
			if(!(charachters.get(i)==null)) 
			{
				writer.write(charachters.get(i).c+":"+charachters.get(i).F);
				writer.write("\n");
			}	
		}
		writer.close();
		n=0;
		for(int i=0;i<charachters.size();i++) 
		{
			if(!(charachters.get(i) == null))
			{
				n++;
			}
		}
		int[] charfreq=new int [n];
		char[] charArray=new char [n];
		for(int i=0;i<charachters.size();i++) 
		{
			if((charachters.get(i)==null))
				charachters.remove(i);
		}
		for(int i=0;i<n;i++) 
		{
			if(!(charachters.get(i)==null)) 
			{
				charArray[i]=charachters.get(i).c;
				charfreq[i]=charachters.get(i).F;
			}
		}
		PriorityQueue<HuffmanNode> q
			= new PriorityQueue<HuffmanNode>(n, new MyComparator());

		for (int i = 0; i < n; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.data = charfreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
		HuffmanNode root = null;
		while (q.size() > 1) {

			HuffmanNode x = q.peek();
			q.poll();
			HuffmanNode y = q.peek();
			q.poll();
			HuffmanNode f = new HuffmanNode();
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		}
		ArrayList<charachter> encode = new ArrayList();
		printCode(root, "",encode);
		String encode_text="";
		for(int i=0;i<charArray2.length;i++) 
		{
			for(int j=0;j<encode.size();j++) 
			{
				if(charArray2[i] == encode.get(j).c) 
				{
					encode_text+=Integer.toString(encode.get(j).F);
				}
			}
		}
		PrintWriter writer2 = new PrintWriter("Encode.txt");
		System.out.println("Encoded Text: "+encode_text);
		writer2.print("Encoded Text: "+encode_text);
		System.out.print("Decoded Text: ");
		PrintWriter writer3 = new PrintWriter("Decode.txt");
		writer3.print("Decoded Text: ");
		for(int i=0;i<charArray2.length;i++) 
		{
			System.out.print(charArray2[i]);
			writer3.write(charArray2[i]);
		}
		writer2.close();
		writer3.close();
	}
}
