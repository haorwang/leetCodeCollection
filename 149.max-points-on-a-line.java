/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/**
 * for point (x1, y1) use slop dy/dx could represent a unique line
 *
 */
 
class Solution {
    public int maxPoints(Point[] points) {
		
		if (points.length <= 2) {
			return points.length;
		}

		int maxRes = 0;
		
		for (int i = 0; i < points.length; i++) {
			
			//  dx			dy		  cnt(*OtherPointsOnOneLine)
			Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
			int selfCnt = 1;
			int maxOtherPointsOnOneLine = 0;	

			for (int j = i + 1; j < points.length; j++) {
				
				int dx = points[j].x - points[i].x;
				int dy = points[j].y - points[i].y;
				
				if (dx == 0 && dy == 0) { //same points as point i
					selfCnt++;
				} else { //not same points as point i

					int gcd = calcGcd(dx, dy);
					dx = dx/gcd;
					dy = dy/gcd;
				
					if (map.containsKey(dx)) {
						if (map.get(dx).containsKey(dy)) {
							int oldCnt = map.get(dx).get(dy);
							map.get(dx).put(dy, oldCnt + 1);
						} else {	
							map.get(dx).put(dy, 1);
						}
					} else {
						Map<Integer, Integer> newMap = new HashMap<>();
						newMap.put(dy, 1);
						map.put(dx, newMap);	
					}
					maxOtherPointsOnOneLine = Math.max(maxOtherPointsOnOneLine,
						map.get(dx).get(dy));
				}

				maxRes = Math.max(maxRes, selfCnt + maxOtherPointsOnOneLine);
			}
		}
		return maxRes;
	}

	private int calcGcd(int a, int b) {
		if (b == 0) {
			return a;	
		}
		return calcGcd(b, a % b);
	}
}
