
package org.showcase.datakeep.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {
	@Column(name="lat")
    private Float lat;
	@Column(name="lng")
    private Float lng;

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

}
