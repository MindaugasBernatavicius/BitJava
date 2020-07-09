import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class _7_th_Lecture_ComparatorLambdaStreams {
    public static void main(String[] args) {
        List<TravelOffering> travelOfferings = new ArrayList<>();
        travelOfferings.add(new TravelOffering(901.99, "Azerbaijan", parseDate("2020-08-14"), parseDate("2020-09-14")));
        travelOfferings.add(new TravelOffering(1001.99, "Mongolia", parseDate("2021-08-14"), parseDate("2021-09-14")));
        travelOfferings.add(new TravelOffering(501.99, "Zambabwae", parseDate("2020-11-14"), parseDate("2020-12-14")));

        // // 0. Deault sorting by price, implemented inside the TravelOffering class
        // System.out.println("Before sorting: " + travelOfferings);
        // Collections.sort(travelOfferings);
        // System.out.println("After sorting: " + travelOfferings);

        // // 1. Additional sorting order, implemented as a comparator object
        // System.out.println("Before sorting: " + travelOfferings);
        // Collections.sort(travelOfferings, new TravelOfferingDateComparator());
        // System.out.println("After sorting: " + travelOfferings);

        // // 2. Anonymous class implementation of comparator
        // System.out.println("Before sorting: " + travelOfferings);
        // Collections.sort(travelOfferings, new Comparator<TravelOffering>() {
        //     @Override
        //     public int compare(TravelOffering o1, TravelOffering o2) {
        //         if(o1.getStartDate().compareTo(o2.getStartDate()) > 0) {
        //             return 1;
        //         } else if(o1.getStartDate().compareTo(o2.getStartDate()) < 0){
        //             return -1;
        //         } else {
        //             return 0;
        //         }
        //     }
        // });
        // System.out.println("After sorting: " + travelOfferings);

        // 3. Lambda expression
        System.out.println("Before sorting: " + travelOfferings);
        Collections.sort(travelOfferings, (o1, o2) -> {
            if(o1.getStartDate().compareTo(o2.getStartDate()) > 0) {
                return 1;
            } else if(o1.getStartDate().compareTo(o2.getStartDate()) < 0){
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("After sorting: " + travelOfferings);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}

class TravelOffering implements Comparable<TravelOffering>{
    private double price;
    private String country;
    private Date startDate;
    private Date endDate;

    public TravelOffering(double price, String country, Date startDate, Date endDate) {
        this.price = price;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "{ price=" + price +
                ", country='" + country + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public int compareTo(TravelOffering o) {
        return Double.compare(this.price, o.price);
    }
}

class TravelOfferingDateComparator implements Comparator<TravelOffering> {
    @Override
    public int compare(TravelOffering o1, TravelOffering o2) {
        if(o1.getStartDate().compareTo(o2.getStartDate()) > 0) {
            return 1;
        } else if(o1.getStartDate().compareTo(o2.getStartDate()) < 0){
            return -1;
        } else {
            return 0;
        }
    }
}
