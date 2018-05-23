package json.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int STARTING_VERSION = -1;

    public static final String $version = "version";
    public static final String $id = "id";

    @Version
    private Integer version = STARTING_VERSION;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @PrePersist
    protected void onCreate() {
	updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
	updated = new Date();
    }

    @PreRemove
    protected void onRemove() {
	deletedDate = new Date();
    }

    // @Column(columnDefinition = "boolean default false")
    @Column(name = "deleted")
    private Boolean deleted = false;

    @Column(name = "deleted_date")
    private Date deletedDate;

    @Column(name = "deleted_comment")
    private String deletedComment;

    /**
     * Indicates whether this persistable entity has been persisted yet. Determine
     * based on whether the {@link #getInternalId()} returns <code>null</code> or a
     * non-<code>null</code> value.
     *
     * @return <code>true</code> if the instance has not been persisted,
     *         <code>false</code> otherwise
     */
    public boolean isNew() {
	return (getVersion() == STARTING_VERSION);
    }

    /**
     * Returns the version number, which should be managed by the persistence layer.
     * <p>
     * Initially all <code>PersistableEntity</code>s will commence with the version
     * number defined by {@link #STARTING_VERSION}.
     * </p>
     *
     * @return the version
     */
    public Integer getVersion() {
	return version;
    }

    public void setVersion(Integer version) {
	this.version = version;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * Gets the id of the entity.
     */
    public Long getId() {
	return id;
    }

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }

    public Boolean getDeleted() {
	return deleted;
    }

    public void setDeleted(Boolean deleted) {
	this.deleted = deleted;
    }

    public Date getDeletedDate() {
	return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
	this.deletedDate = deletedDate;
    }

    public String getDeletedComment() {
	return deletedComment;
    }

    public void setDeletedComment(String deletedComment) {
	this.deletedComment = deletedComment;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	BaseEntity other = (BaseEntity) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return getClass().getName() + (id != null ? id.toString() : "");
    }

}
