import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prob539 {
	public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String[] t1 = s1.split(":");
				String[] t2 = s2.split(":");

				if (Integer.parseInt(t1[0]) < Integer.parseInt(t2[0])) {
					return -1;
				} else if (Integer.parseInt(t1[0]) > Integer.parseInt(t2[0])) {
					return 1;
				} else if (Integer.parseInt(t1[1]) < Integer.parseInt(t2[1])) {
					return -1;
				} else if (Integer.parseInt(t1[1]) > Integer.parseInt(t2[1])) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		int[] hours = new int[timePoints.size()];
		int[] minutes = new int[timePoints.size()];

		for (int i = 0; i < timePoints.size(); i++) {
			String[] time = timePoints.get(i).split(":");
			hours[i] = Integer.parseInt(time[0]);
			minutes[i] = Integer.parseInt(time[1]);
		}

		int thisMinDiff = getMinutesDiff(hours[0], minutes[0], hours[hours.length - 1], minutes[minutes.length - 1],
				true);
		int minDiff = thisMinDiff;
		for (int i = 0; i < timePoints.size() - 1; i++) {
			thisMinDiff = getMinutesDiff(hours[i], minutes[i], hours[i + 1], minutes[i + 1], false);
			if (thisMinDiff < minDiff) {
				minDiff = thisMinDiff;
			}
		}
		return minDiff;
	}

	public int getMinutesDiff(int h1, int min1, int h2, int min2, boolean reverse) {
		if (reverse) {
			return 24 * 60 - ((h2 - h1) * 60 + (min2 - min1));
		}
		return (h2 - h1) * 60 + (min2 - min1);
	}
}