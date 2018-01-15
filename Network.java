import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


public class Network {
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Edge> edges = new ArrayList<Edge>();
		
	public Network(){
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
	}
	
	
	public Network(String n) throws IOException{
		 BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(n),"UTF8"));
		 String line = null;
		 while((line = in.readLine()) != null) {
			 String[] elements=line.split("\\s+");
			 String[] nice=line.split("\n");
			 for (String e:elements){
				 Node node3=new Node(e);
				 List<String> myList1 = new ArrayList<String>();
				 for (Node r:nodes){
					 myList1.add(r.NodeName());
				 }
				 if ((myList1.contains(node3.NodeName()))==false){
					 nodes.add(node3); 
				 }
			 	 }
			 for (String x:nice){
				 String[] nicer=x.split("\\s+");
				 Arrays.sort(nicer);
				 Node node4=new Node(nicer[0]);
				 Node node5=new Node(nicer[1]);
				 Edge edge2=new Edge(node4,node5);
				 List<String> myList = new ArrayList<String>();
				 for (Edge e :edges){
					myList.add(e.EdgeName()); 
				 }
				 if ((myList.contains(edge2.EdgeName()))==false){
				 edges.add(edge2);
				 }			
				 }
	}
	}
	
	
	
	public void AddEdge(Node x,Node y){
		Edge edge4=new Edge(x,y);
		if ((edges.contains(edge4))==false){
			 edges.add(edge4); 
		 }
		else{
			System.out.println("Node already in place");
		}
	}
	
	
	public ArrayList EdgeList(){
		ArrayList<String> edges1 = new ArrayList<String>();
		for (Edge e:edges){
			String ret=e.EdgeName();
			edges1.add(ret);	
		}
	return edges1;
	}
	
	
	public ArrayList NodeList(){
		ArrayList<String> nodes1 = new ArrayList<String>();
		for (Node e:nodes){
			String ret=e.NodeName();
			nodes1.add(ret);	
		}
	return nodes1;
	}
	
	
	public int NodeDegree(Node z){
		String h=z.NodeName();
		int i=0;
		for (Edge x:edges){
			String m=x.EdgeName();
			if (m.contains(h)){
				i++;
			}
			}
		return i;
		
	}
	public double AverageDegree(){
		double total=0;
		double denom=nodes.size();
		for (Node e:nodes){
			double y=NodeDegree(e);
			total+=y;
		}
		double av=total/denom;
		return av;
	}
	
	public ArrayList Hubs(){
		ArrayList<String> Hubs = new ArrayList<String>();
		int max=0;
		for (Node e:nodes){
			int y=NodeDegree(e);
			if (max<y){
				max=y;
			}
		}	
		for (Node x:nodes){
			int c=NodeDegree(x);
			if (c==max){
				String f=x.NodeName();
				 if ((Hubs.contains(f))==false){
					 Hubs.add(f); 
				 }	
				 }
		}
		return Hubs;
		}
	public HashMap DegreeDistribution(){
		HashMap<String,Integer> Dist=new LinkedHashMap<String,Integer>();
		for (Node e:nodes){
			String x=e.NodeName();
			int y=NodeDegree(e);
			Dist.put(x,y);
		}
		return Dist;
	}
}		



