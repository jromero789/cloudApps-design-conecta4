package usantatecla.intervals.v04;

public class Interval {

  private int min;
  private int max;

  public Interval(int min, int max) {
    assert max >= min;
    
    this.min = min;
    this.max = max;
  }

  public boolean isIncluded(Interval interval) {
    return this.min >= interval.min && this.max <= interval.max;
  }

}
