public class QuickSort extends InternalSort{
	public QuickSort(){
		super();
	}

	public QuickSort(int arraySize){
		super(arraySize);
	}

	@Override
	public void sort(){
		beginTime = now();
		quicksort(0, n - 1);
		endTime = now();
	}

	@Override
	public void partialSort(int k){
		beginTime = now();
		partialQuicksort(0, n - 1, k);
		endTime = now();
	}

	private void quicksort(int left, int right){
		int i = left, j = right, pivot = array[(left + right)/2];
		//partitioning
		while(i <= j){
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			if(i <= j){
				swap(i, j);
				i++;
				j--;
			}
		}
		//recursion
		if(left < j){
			quicksort(left, j);
		}
		if(i < right)
			quicksort(i, right);
	}

	private void partialQuicksort(int left, int right, int k){
		int i = left, j = right, pivot = array[(left + right)/2];
		//partitioning
		while(i <= j){
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			if(i <= j){
				swap(i, j);
				i++;
				j--;
			}
		}
		//recursion
		if(left < j){
			quicksort(left, j);
		}
		if(i < k && i < right)
			quicksort(i, right);
	}
}