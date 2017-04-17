package sortalgo;

/** Class which implements counting sort
 * @author User
 */
public class CountingSort {
	
	/** Input array of number */
	public int [] inputArr;
	
	/** Output array of number */
	public int [] outputArr;
	
	public CountingSort(int [] array){
		inputArr = array;
		outputArr = new int[inputArr.length];
		for(int i = 0; i < outputArr.length;i++){
			outputArr[i] = 0;
		}
	}
	
	/** Method that find maximum in array */
	public int findMax(){
		int max = 0;
		for(int i = 0; i < inputArr.length;i++){
			if(inputArr[i] > max){
				max = inputArr[i];
			}
		}
		return max;
	}
	
	/** Print results */
	public void print(int [] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	/** Counting sort algorithm */
	public void sort(){
		int [] c = new int[findMax() + 1];
		for(int i = 0; i < c.length; i++){
			c[i] = 0;
		}	
		for(int i = 0; i < inputArr.length;i++){
			c[inputArr[i]] += 1;
			
		}
		for(int i = 1; i < c.length;i++){
			c[i] += c[i-1];
		}
		for(int i = inputArr.length - 1; i >= 0 ;i--){
			outputArr[c[inputArr[i]]-1] = inputArr[i];
			c[inputArr[i]] -= 1;
		}
		print(outputArr);
	}
}
