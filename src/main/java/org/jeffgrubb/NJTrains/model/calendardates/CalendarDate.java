package org.jeffgrubb.NJTrains.model.calendardates;

/**
 * Created by jgrubb on 1/10/16.
 */

import java.sql.Date;

public class CalendarDate {
    private int serviceId;
    private Date serviceDate;
    private int exceptionType;

    public int getServiceId() { return serviceId; }
    public Date getServiceDate() { return serviceDate; }
    public int getExceptionType() { return exceptionType; }

    public void setServiceId(int serviceId) { this.serviceId = serviceId; }
    public void setServiceDate(Date serviceDate) { this.serviceDate = serviceDate; }
    public void setExceptionType(int exceptionType) { this.exceptionType = exceptionType; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("CalendarDate\n")
                .append("---------------\n")
                .append( String.format( "serviceId: %s\n", serviceId ) )
                .append( String.format( "serviceDate: %s\n", serviceDate ) )
                .append( String.format( "exceptionType: %s\n", exceptionType) )
                .toString();
    }

}
