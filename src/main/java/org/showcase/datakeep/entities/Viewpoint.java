
package org.showcase.datakeep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.impetus.kundera.gis.geometry.Point;

@Entity
@Table(name="viewpoint", schema = "crossroad@mongo")
public class Viewpoint{
	
	@Id
	@Column(name="_id")
	@GeneratedValue()
    private String id;
	
	@Column(name="center")
	private Point center;
	@Column(name="city")
    private String city;
	@Column(name="elevation")
    private Float elevation;
	@Column(name="level")
    private Integer level;
	@Column(name="location")
	private Point location;
	@Column(name="viewpoint")
    private String viewpoint;
    @Column(name="rate")
    private int rate;
    @Column(name="search")
	private String search;
	

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
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

}
