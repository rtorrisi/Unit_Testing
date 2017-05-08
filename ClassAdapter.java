package se.designpatterns;

public class ClassAdapter {
	//Target
		public interface ILabel {
			public String getNextLabel();
		}
		
		//Adaptee 
		public class LabelServer {
			private int nextLabelNum = 1;
			private String labelPrefix;
			public LabelServer(String prefix) { labelPrefix = prefix; }
			
			public String serveNextLabel() { return labelPrefix+nextLabelNum++; }
		}
		
		//Adapter
		public class Label extends LabelServer implements ILabel{
			public Label(String prefix) { super(prefix); }
			public String getNextLabel() { return serveNextLabel(); }
		}
		
		public void testObjectAdapter() {
			System.out.println("\nClass Adapter\n");
			ILabel s = new Label("LAB");
			String l = s.getNextLabel();
			
			if(l.equals("LAB1")) System.out.println("Test 1: Passed");
			else System.out.println("Test 1: Failed");
		}
}
