
package org.showcase.datakeep.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewpoint", schema = "crossroad@mongo")
public class Viewpoint{
	
	@Id
	@Column(name="_id")
	@GeneratedValue()
    private String id;
	
	@Embedded
	private Center center;
	@Column(name="city")
    private String city;
	@Column(name="elevation")
    private Float elevation;
	@Column(name="level")
    private Integer level;
	@Embedded
    private Location location;
	@Column(name="viewpoint")
    private String viewpoint;
    @Column(name="rate")
    private int rate;
    public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	@Column(name="search")
	private String search;

    
    
    
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getElevation() {
        return elevation;
    }

    public void setElevation(Float elevation) {
        this.elevation = elevation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(String viewpoint) {
        this.viewpoint = viewpoint;
    }

    public String toString(){
        return viewpoint;
    }

}
