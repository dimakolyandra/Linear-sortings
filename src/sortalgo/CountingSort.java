package sortalgo;

public class CountingSort {
	public int [] inputArr;
	public int [] outputArr;
	
	public CountingSort(int [] array){
		inputArr = array;
		outputArr = new int[inputArr.length];
		for(int i = 0; i < outputArr.length;i++){
			outputArr[i] = 0;
		}
	}
	
	public int findMax(){
		int max = 0;
		for(int i = 0; i < inputArr.length;i++){
			if(inputArr[i] > max){
				max = inputArr[i];
			}
		}
		return max;
	}
	public void print(int [] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
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
