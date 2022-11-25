package usantatecla.intervals.v02;

public class Interval {

  private int min;
  private int max;

  public Interval(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public boolean isIncluded(Interval interval) {
    return min >= interval.min;
  }

}
