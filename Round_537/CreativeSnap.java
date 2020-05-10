import java.util.*;

public class CreativeSnap {
	int n, k, A, B;
	long[] base;

	public static void main(String[] args) {
		CreativeSnap cs = new CreativeSnap();
		Scanner in = new Scanner(System.in);
		cs.n = in.nextInt();
		cs.k = in.nextInt();
		cs.A = in.nextInt();
		cs.B = in.nextInt();
		cs.base = new long[cs.k];

		for (int i = 0; i < cs.k; i++) {
			cs.base[i] = in.nextInt();
		}
		Arrays.sort(cs.base);
		System.out.println(cs.destroyAvengersBase(1, 1 << cs.n));
		in.close();
	}

	public long destroyAvengersBase(long start, long end) {
		long i = lowerBound(base, 0, base.length, start);
		long j = upperBound(base, 0, base.length, end) - 1;

		long num = j - i + 1;
		long destroyEntireBase;
		if (num == 0) {
			destroyEntireBase = A;
		} else {
			destroyEntireBase = B * num * (end - start + 1);
		}

		if (start == end || num == 0) {
			return destroyEntireBase;
		}

		long mid = (start + end) / 2;
		long destroyHalves = destroyAvengersBase(start, mid) + destroyAvengersBase(mid + 1, end);
		return Math.min(destroyEntireBase, destroyHalves);
	}

	public int lowerBound(long[] a, int fromIndex, int toIndex, long key) {
		int index = binarySearch(a, fromIndex, toIndex, key);
		if (index >= fromIndex && index < toIndex && a[index] == key) {
			while (index >= fromIndex && a[index] == key) {
				index--;
			}
			return index + 1;
		}
		return index;
	}

	public int upperBound(long[] a, int fromIndex, int toIndex, long key) {
		int index = binarySearch(a, fromIndex, toIndex, key);
		while (index >= fromIndex && index < toIndex && a[index] == key) {
			index++;
		}
		return index;
	}

	public int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			long midVal = a[mid];

			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
	}
}