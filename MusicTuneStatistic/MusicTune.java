
/**
 * Statistic each tune in the matrices end with 0 0
 */
class MusicTune {
	
	public static void main(String[] args) {
		while(true){
		int[] a = new int[5];
		int m = StdIn.readInt();
		int n = StdIn.readInt();
		for (int i = 0; i <= m; i++) {
			String ln = StdIn.readLine(); 
			for (int j = 0; j < ln.length(); j++) {
				char tune = ln.charAt(j);
				if (tune == '0' && ln.charAt(j + 1) == '0') return;
				switch (tune) {
				case 'C' : {
					a[0]++;
					break;
				}
				case 'D' : {
					a[1]++;
					break;
				}
				case 'E' : {
					a[2]++;
					break;
				}
				case 'G' : {
					a[3]++;
					break;
				}
				case 'A' : {
					a[4]++;
					break;
				}
				default : break;
				}
			}
		}
		StdOut.print("C " + a[0] + " D " + a[1] + " E ");
		StdOut.println(a[2] + " G " + a[3] + " A " + a[4]);
	}
	}

}