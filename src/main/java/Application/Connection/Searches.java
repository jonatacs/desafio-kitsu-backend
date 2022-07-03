package Application.Connection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Searches {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String type;

	private String action;

	private String slug;
 
    public Searches() {
    }
 
    public Searches(Integer id, String type, String action, String slug) {
        this.id = id;
        this.type = type;
        this.action = action;
        this.slug = slug;
    }

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getAction() {
		return action;
	}

	public String getSlug() {
		return slug;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}