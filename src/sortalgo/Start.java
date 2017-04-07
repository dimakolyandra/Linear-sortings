package sortalgo;

public class Start {
	public static void main(String [] args){
		
		int [] arrRadix={1230000,4321234,1240000,5122054,1230012,7540045,1230001,4530001,3520001,6310004,7541234,1201045,2131111,8972222,1233333,6574444,4441122,4561133,1262345,5741234,3671234,9081234,6431253};
		float [] arrBucket = {0.53f,0.52f,0.12f,0.4f,0.51f,0.78f,0.83f,0.63f,0.531f,0.56f,0.012f,0.04f,0.50f,0.79f,0.81f,0.65f};
		
		BucketSort buck = new BucketSort(arrBucket);
		System.out.println("Bucket sort:");
		buck.bucketSort();
		
		CountingSort count = new CountingSort(arrRadix);
		System.out.println("Counting sort:");
		count.sort();
		
		RadixSort radix = new RadixSort(arrRadix);
		System.out.println("Radix sort:");
		radix.sort(7);
	}
}
