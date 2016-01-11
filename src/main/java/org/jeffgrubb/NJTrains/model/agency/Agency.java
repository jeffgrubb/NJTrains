package org.jeffgrubb.NJTrains.model.agency;

/**
 * Created by jgrubb on 1/10/16.
 */

public class Agency {

    private String agency_id;
    private String agency_name;
    private String agency_url;
    private String agency_timezone;
    private String agency_lang;
    private String agency_phone;

    public String getId() { return agency_id; }
    public String getName() { return agency_name; }
    public String getUrl() { return agency_url; }
    public String getTimezone() { return agency_timezone; }
    public String getLang() { return agency_lang; }
    public String getPhone() { return agency_phone; }

    public void setId(String id) { agency_id = id; }
    public void setName(String name) { agency_name = name; }
    public void setUrl(String url) { agency_url = url; }
    public void setTimezone(String timezone) { agency_timezone = timezone; }
    public void setLang(String lang) { agency_lang = lang; }
    public void setPhone(String phone) { agency_phone = phone; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Agency\n")
                .append("---------------\n")
                .append( String.format( "Id: %s\n", agency_id ) )
                .append( String.format( "Name: %s\n", agency_name ) )
                .append( String.format( "Url: %s\n", agency_url) )
                .append( String.format( "Timezone: %s\n", agency_timezone) )
                .append( String.format( "Lang: %s\n", agency_lang) )
                .append( String.format( "Phone: %s\n", agency_phone) )
                .toString();
    }
}
