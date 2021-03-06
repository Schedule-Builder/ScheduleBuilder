package com.example.schedulebuilder;

// takes care of the times, such as time operations and displaying time
public class Time {
  private int time;
  private boolean morning; // if true, AM- if false, PM
  private boolean systemSetting = true; // if true, displays standard time- if false, displays military time
  
  public Time(){
    
  }
  
  public Time(int time){
    this.time = time;
  }
  
  public Time(int time, boolean systemSetting){
    this.time = time;
    this.sysetmSetting = systemSetting;
  }
  
  public Time(int time, boolean morning, boolean systemSetting){
    this.time = time;
    this.morning = morning;
    this.sysetmSetting = systemSetting;
  }
  
  public int getTime(){
    return time;
  }
  
  public void setTime(int time){
    this.time = time;
  }
  
  public void setSystemSetting(boolean systemSetting){
    this.systemSetting = systemSetting;
  }
  
  public int add(int time){
    return Time.toOperate(this.time) + Time.toOperate(time);
  }
  
  public int difference(int time){
    if (this.time > time)
      return Time.toOperate(this.time)-Time.toOperate(time);
    return Time.toOperate(time)-Time.toOperate(this.time);
  }
  
  public static int add(int time1, int time2){
    return Time.toOperate(time1) + Time.toOperate(time2);
  }
  
  public static int difference(int time1, int time2){
    if (time1 > time2)
      return Time.toOperate(time1)-Time.toOperate(time2);
    return Time.toOperate(time2)-Time.toOperate(time1);
  }
  
  // converts times into an addable format
  public static int toOperate(int time){
    return time/100*60+time%100;
  }
  
  // converts times to a presentable format
  public static int fromOperate(int time){
    return time/60*100+time%60;
  }
  
  // converts the time to whatever it is not
  public void convert(){
    if (systemSetting){
      this = Time.toMilitary(time,morning);
    else
      this = Time.toStandard(time);
  }
  
  // converts from standard time to military time
  public static Time toMilitary(int time, boolean morning){
    if (morning && time >= 1200)
      time -= 1200;
    else if (!morning && time < 1200)
      time += 1200;
    Time t = new Time(time, false);
    return t;
  }
  
  // converts from military time to standard time
  public static Time toStandard(int time){
    boolean morning;
    if (time >= 1200){
      morning = false;
      if (time >= 1300)
        time -= 1200;
    }
    else if (time < 1200){
      morning = true;
      if (time < 100)
        time += 1200;
    }
    Time t = new Time(time, morning, true)
  }
    
  @Override
  public String toString(){
    String daytime = "PM";
    if (systemSetting){
      if (morning)
        daytime = "AM";
      return time / 100 + ":" + time % 100 + " " + daytime;
    }
    return time / 100 + ":" + time % 100;
  }
}
