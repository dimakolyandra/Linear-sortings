package sortalgo;

public class RadixSort {
	
	public int [] inputArr;
	public int [] outputArr;

	public RadixSort(int [] array){
		inputArr = array;
		outputArr = new int[inputArr.length];
		for(int i = 0; i < outputArr.length;i++){
			outputArr[i] = 0;
		}
	}

	public int getRadix(int x,int radix){
		if(radix==1){
			return x % 10;
		}
		else {
			return (int) ((x%(Math.pow(10,radix)))/(Math.pow(10,radix-1)));
		}
	}
	public void print(int [] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public int findMax(int radix){
		int max = 0;
		for(int i = 0; i < inputArr.length;i++){
			if((getRadix(inputArr[i],radix) > max)){
				max = getRadix(inputArr[i],radix);
			}
		}
		return max;
	}
	
	public void copy(){
		for(int i = 0; i < outputArr.length;i++){
			inputArr[i] = outputArr[i];
		}
	}
	
	public void countingSort(int radix){
		int [] c = new int[findMax(radix) + 1];
		for(int i = 0; i < c.length; i++){
			c[i] = 0;
		}	
		for(int i = 0; i < inputArr.length;i++){
			c[getRadix(inputArr[i],radix)]+=1;
		}
		for(int i = 1; i < c.length;i++){
			c[i] += c[i-1];
		}
		for(int i = inputArr.length - 1; i >= 0 ;i--){
			outputArr[c[getRadix(inputArr[i],radix)]-1] = inputArr[i];
			c[getRadix(inputArr[i],radix)]-=1;
		}
		copy();
	}
	
	public void sort(int numbRadix){
		for(int i = 1; i < numbRadix + 1;i++){
			countingSort(i);
		}
		print(outputArr);
	}
		
}
