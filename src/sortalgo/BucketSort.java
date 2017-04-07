package sortalgo;

import java.util.ArrayList;
import java.util.Comparator;

public class BucketSort {
	
	public float []  inputArray;
	
	public BucketSort(float [] arr){
		inputArray = arr;
	}
	
	public class Comp implements Comparator{
		@Override
		public int compare(Object arg0, Object arg1) {
			Float t1 = (Float)arg0;
			Float t2 = (Float)arg1;
			if(t1 < t2){
				return -1;
			}
			if(t1 > t2){
				return 1;
			}
			return 0;
		}
	}
	public void print(ArrayList<ArrayList<Float>> b){
		for(int i = 0; i < b.size();i++){
			ArrayList<Float> tmp = b.get(i);
			for(Float e:tmp){
				System.out.print((float)e + " ");				
			}
		}
		System.out.println();
	}
	public void bucketSort(){
		ArrayList<ArrayList<Float>> b = new ArrayList<ArrayList<Float>>();
		for(int i = 0; i < inputArray.length;i++){
			ArrayList<Float> tmp = new ArrayList<Float>();
			b.add(tmp);
		}
		for(int i = 0; i < inputArray.length;i++){
			b.get((int)(inputArray.length*inputArray[i])).add(new Float(inputArray[i]));
		}
		for(int i = 0; i < b.size();i++){
			b.get(i).sort(new Comp());
		}
		print(b);
	}
}
