package com.kdn.kevcs.mobile.domain;


// import org.springframework.hateoas.Identifiable;

/**
 * Base class for entity implementations. Uses a {@link Long} id.
 *
 * @since 2015.11.11
 * @author 박영규
 */
public class AbstractEntity {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}