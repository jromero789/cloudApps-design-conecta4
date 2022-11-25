package usantatecla.intervals.v03;

public class Interval {

  private int min;
  private int max;

  public Interval(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public boolean isIncluded(Interval interval) {
    return this.min >= interval.min && this.max <= interval.max;
  }

}
