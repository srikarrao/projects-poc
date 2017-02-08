package com.java.iq.core.miscelleanous;

import java.util.*;

public class HitCounter_Map {

	Map<Long, Long> map = new HashMap<Long, Long>();
	Long hits = 0L, earliestTime = 0L;
	int SLOTS = 300 * 60;

	public void logHits(long time) { // time in seconds
		if (map.containsKey(time)) {
			map.put(time, map.get(time) + 1);
		} else {
			map.put(time, 1L);
		}
		cleanUp(time);
		hits++;
	}

	public Long getHits(long time) { // time in seconds
		cleanUp(time);
		return hits;
	}

	public void cleanUp(long time) {
		while (time - earliestTime >= SLOTS) {
			if (map.containsKey(earliestTime)) {
				hits -= map.get(earliestTime);
				map.remove(earliestTime);
			}
			earliestTime = earliestTime + 1;
		}
	}
}
