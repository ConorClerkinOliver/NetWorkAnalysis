import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {
		Network net1=new Network("PPInetwork.txt");
		double x = net1.AverageDegree();
		System.out.println(x);
		Node node1 = new Node("String");
		int y=net1.NodeDegree(node1);
		System.out.print(y);
	}

}
