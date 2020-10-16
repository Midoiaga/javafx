package ehu.isad;

import java.util.Arrays;

public class Details {
    String[] publishers;
    Integer number_of_pages;
    String title;

    public String getTitle() {
        return title;
    }

    public String getNumber_of_pages() {
        return number_of_pages.toString();
    }

    public String getPublishers() {
        StringBuffer katea = new StringBuffer();
        for (int x=0;x<this.publishers.length;x++){
            katea =katea.append(this.publishers[x]+" ");
        }
        return katea.toString();
    }

    @Override
    public String toString() {
        return "Details{" +
                "publishers=" + Arrays.toString(publishers) +
                ", number_of_pages=" + number_of_pages +
                ", title='" + title + '\'' +
                '}';
    }
}
