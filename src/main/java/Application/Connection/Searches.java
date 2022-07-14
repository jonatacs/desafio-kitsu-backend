package Application.Connection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Searches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(nullable = false)
	private String type;

    @Column(nullable = false)
	private String action;

    @Column(nullable = false)
	private String slug;

	private Integer count;

	public Searches() {
	}
 
    public Searches(String type, String action, String slug, Integer count) {
        this.type = type;
        this.action = action;
        this.slug = slug;
		this.count = count;
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

	public Integer getCount() {
		return count;
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

	public void setCount(Integer count) {
		this.count = count;
	}
}