
public class Edge {
		public String join;
		public Edge(Node x,Node y){
			this.join=x.NodeName()+" "+y.NodeName();
		}
		public String EdgeName(){
			return join;
		}
}
