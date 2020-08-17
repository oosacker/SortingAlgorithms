

public class Main {

	int[] myData;

	double time = 0;
	long start = 0;

	long comps = 0;
	long moves = 0;



	public void generateArray(int size, int max) {

		//System.out.println("\nGenerateArray");

		myData = new int[size];		


		for(int i=0; i<size; i++) {
			myData[i] = (int) (Math.random() * max + 1);
		}
	}

	public void printArray() {
		System.out.println("\n-------------------------");
		for(int i=0; i<myData.length; i++) {
			System.out.println(myData[i]);
		}
	}

	
	public void dumbSort(int[] data) {


		int length = data.length;

			
		for(int i=0; i<length-1; i++) {
			
			
			int first = data[i];
			
			int second = data[i];
			
			if(first > second) {
				
				data[i] = second;
				data[i+1] = first;
				
			}
			
		}

	}

	public void bubbleSort(int[] data){
		for (int pos = data.length-1; pos >= 0; pos--) {
			for (int scan = 0; scan <= pos-1; scan++){		
				if (data[scan] > data[scan+1]){
					int temp = data[scan];
					data[scan] = data[scan+1];
					data[scan+1] = temp;
					moves++;
				}
				comps++;
			}
		}
	}


	public void insertionSort(int[] data){
		for (int i = 1; i<data.length; i++){
			int item = data[i];
			int place = i;
			while ( place > 0 && (item > data[place-1]) ){
				comps++;
				data[place] = data[place-1];
				place--;
			}
			data[place] = item;
			moves++;
		}
	}

	public void mergeSort(int[] a, int n) {
		
		if (n < 2) {
			return;
		}
		
		int mid = n / 2;
		
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
			moves++;
		}
		
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
			moves++;
		}
		
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	public void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		
		while (i < left && j < right) {
			
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			
			else {
				a[k++] = r[j++];
			}
			comps++;
		}
		
		while (i < left) {
			//comps++;
			a[k++] = l[i++];
		}
		
		while (j < right) {
			//comps++;
			a[k++] = r[j++];
		}
	}


	/**
	 * 
	 */
	public Main() {

		time = 0;
		start = 0;

		comps = 0;
		moves = 0;
		

		generateArray(100, 13);

		//dumbSort(myData);
		
		
//		System.out.println("\nSort");
//		start = System.currentTimeMillis();
//		dumbSort(myData);
//		time = (System.currentTimeMillis() - start);

//		System.out.println("\nBubble Sort");
//		start = System.currentTimeMillis();
//		bubbleSort(myData);
//		time = (System.currentTimeMillis() - start);
		
//		System.out.println("Insertion Sort");
//		start = System.currentTimeMillis();
//		insertionSort(myData);
//		time = (System.currentTimeMillis() - start);
		
		System.out.println("Merge Sort");
		start = System.currentTimeMillis();
		mergeSort(myData, myData.length);
		time = (System.currentTimeMillis() - start);
		
		System.out.println("Comps: "+comps);
		System.out.println("Moves: "+moves);
		System.out.println("Time (ms): "+time);
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
