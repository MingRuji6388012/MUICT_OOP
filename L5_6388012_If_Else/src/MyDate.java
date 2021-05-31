public class MyDate {
    private int year;
    private int month;
    private int day;
    private int objectNumber;

    static int objectCounter = 0;
    static final String[] strMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    MyDate(){
        this(1900,1,1);
    }

    MyDate(int aYear, int aMonth, int aDay){ //First opening of building
        setDate(aYear,aMonth,aDay);
        objectNumber = ++objectCounter;
    }

    public void setDate (int aYear, int aMonth, int aDay){
        this.year = aYear;
        this.month = aMonth;
        this.day = aDay;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getObjectNumber() {
        return objectNumber;
    }

    /**
     * @return
     */
     MyDate nextDay(){
        if(month == 12 && day == 31){
            year ++;
            month = 1;
            day = 1;
        }else {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day == 30) {
                    month ++;
                    day = 1;
                } else {
                    day ++;
                }
            } else if (month != 2) {
                if (day == 31) {
                    month ++;
                    day = 1;
                } else {
                    day ++;
                }
            }else {
                if (isLeapYear(year) && day == 29) {
                    month ++;
                    day = 1;
                } else if (!isLeapYear(year) && day == 28) {
                    month ++;
                    day = 1;
                } else
                    day ++;
            }
        }
        return this; //return the same object ==> this.MyDate ?
    }

    MyDate nextMonth(){
        if((month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && (day == 31)){
            month ++;
            day = 30;
        }else if(month == 12) {
            month = 1;
            year++;
        }else if(month == 1 && (day >= 29 && day <= 31)){
            if(isLeapYear(year)) {
                month++;
                day = 29;
            }else {
                month++;
                day = 28;
            }
        }else month++;
        return this;
    }

    MyDate nextYear(){
        if(day == 29 && month == 2) {
            day = 28;
        }
         year ++;
        return this;
    }

    MyDate previousDay(){
        if(month == 1 && day == 1){
            year --;
            month = 12;
            day = 31;
        }else {
            if (month == 5 || month == 7 || month == 10 || month == 12) {
                if (day == 1) {
                    month --;
                    day = 30;
                } else {
                    day --;
                }
            } else if (month != 3) {
                if (day == 1) {
                    month --;
                    day = 31;
                } else {
                    day --;
                }
            } else {
                if (isLeapYear(year) && day == 1) {
                    month --;
                    day = 29;
                } else if (day == 1) {
                    month --;
                    day = 28;
                } else day --;
            }
        }
        return this;
    }

    MyDate previousMonth(){
        if((month == 5 || month == 7 || month == 8 || month == 10) && (day == 31)){
            month -= 1;
            day = 30;
        }else if(month == 1) {
            month = 12;
            year--;
        }else if(month == 3 && (day >= 29 && day <= 31)){
            if(isLeapYear(year)) {
                month--;
                day = 29;
            }else {
                month--;
                day = 28;
            }
        }else month--;
        return this;
    }

    MyDate previousYear(){
        if(day == 29 && month == 2) {
            day = 28;
        }
        year --;
        return  this;
    }
    /**
     * @param year
     * @return boolean
     */
    static boolean isLeapYear(int year){
        if(year % 4 != 0){
           return false;
        }else if(year % 100 != 0){
            return true;
        }else if(year % 400 != 0){
            return false;
        }else{
            return true;
        }
    }

    public String toString(){
        if(day <= 9){
            return "0"+day + " "+strMonths[month-1].substring(0,3)+" "+year;
        }else
            return day+ " "+strMonths[month-1].substring(0,3)+" "+year;
    }

    /**
     * Challenge: find the different days between two given dates.
     * @param a
     * @param b
     * @return
     */

    static int dateDiff(MyDate a, MyDate b) {
        int totalDay = 1;
        MyDate endDate = new MyDate(b.getYear(),b.getMonth(),b.getDay());
        while(!(endDate.previousDay().toString().equals(a.toString()))){
            totalDay++;
        }
    return totalDay;
    }
}
