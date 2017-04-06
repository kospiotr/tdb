/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "technologies")
public class Technologies implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Technologies.class.getName());

    // Raw attributes
    private Integer id;
    private String unit;
    private String department;
    private String type;
    private String name;
    private String targets;
    private String description;
    private String goodsInnovation;
    private String goodsConcurency;
    private String benefits;
    private String keywords;
    private String requestnumber;
    private LocalDate requestdate;
    private String requestcountries;
    private String patentnumber;
    private LocalDate patentdate;
    private String patentcountries;
    private String scientists;
    private LocalDate modificationdate;
    private Integer scientistId;
    private Boolean published;
    private String state;
    private String info;

    @Override
    public String entityClassName() {
        return Technologies.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "id", precision = 10)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Technologies id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [unit] ------------------------

    @Size(max = 1024)
    @Column(name = "unit", length = 1024)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Technologies unit(String unit) {
        setUnit(unit);
        return this;
    }
    // -- [department] ------------------------

    @Size(max = 1024)
    @Column(name = "department", length = 1024)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Technologies department(String department) {
        setDepartment(department);
        return this;
    }
    // -- [type] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "`type`", nullable = false, length = 128)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Technologies type(String type) {
        setType(type);
        return this;
    }
    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "name", nullable = false, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Technologies name(String name) {
        setName(name);
        return this;
    }
    // -- [targets] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "targets", nullable = false, length = 512)
    public String getTargets() {
        return targets;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    public Technologies targets(String targets) {
        setTargets(targets);
        return this;
    }
    // -- [description] ------------------------

    @NotEmpty
    @Size(max = 10000)
    @Column(name = "description", nullable = false, length = 10000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Technologies description(String description) {
        setDescription(description);
        return this;
    }
    // -- [goodsInnovation] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "goods-innovation", nullable = false, length = 1024)
    public String getGoodsInnovation() {
        return goodsInnovation;
    }

    public void setGoodsInnovation(String goodsInnovation) {
        this.goodsInnovation = goodsInnovation;
    }

    public Technologies goodsInnovation(String goodsInnovation) {
        setGoodsInnovation(goodsInnovation);
        return this;
    }
    // -- [goodsConcurency] ------------------------

    @Size(max = 1024)
    @Column(name = "goods-concurency", length = 1024)
    public String getGoodsConcurency() {
        return goodsConcurency;
    }

    public void setGoodsConcurency(String goodsConcurency) {
        this.goodsConcurency = goodsConcurency;
    }

    public Technologies goodsConcurency(String goodsConcurency) {
        setGoodsConcurency(goodsConcurency);
        return this;
    }
    // -- [benefits] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "benefits", nullable = false, length = 1024)
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Technologies benefits(String benefits) {
        setBenefits(benefits);
        return this;
    }
    // -- [keywords] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "keywords", nullable = false, length = 1024)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Technologies keywords(String keywords) {
        setKeywords(keywords);
        return this;
    }
    // -- [requestnumber] ------------------------

    @Size(max = 64)
    @Column(name = "requestnumber", length = 64)
    public String getRequestnumber() {
        return requestnumber;
    }

    public void setRequestnumber(String requestnumber) {
        this.requestnumber = requestnumber;
    }

    public Technologies requestnumber(String requestnumber) {
        setRequestnumber(requestnumber);
        return this;
    }
    // -- [requestdate] ------------------------

    @Column(name = "requestdate", length = 10)
    public LocalDate getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(LocalDate requestdate) {
        this.requestdate = requestdate;
    }

    public Technologies requestdate(LocalDate requestdate) {
        setRequestdate(requestdate);
        return this;
    }
    // -- [requestcountries] ------------------------

    @Size(max = 200)
    @Column(name = "requestcountries", length = 200)
    public String getRequestcountries() {
        return requestcountries;
    }

    public void setRequestcountries(String requestcountries) {
        this.requestcountries = requestcountries;
    }

    public Technologies requestcountries(String requestcountries) {
        setRequestcountries(requestcountries);
        return this;
    }
    // -- [patentnumber] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "patentnumber", nullable = false, length = 128)
    public String getPatentnumber() {
        return patentnumber;
    }

    public void setPatentnumber(String patentnumber) {
        this.patentnumber = patentnumber;
    }

    public Technologies patentnumber(String patentnumber) {
        setPatentnumber(patentnumber);
        return this;
    }
    // -- [patentdate] ------------------------

    @NotNull
    @Column(name = "patentdate", nullable = false, length = 10)
    public LocalDate getPatentdate() {
        return patentdate;
    }

    public void setPatentdate(LocalDate patentdate) {
        this.patentdate = patentdate;
    }

    public Technologies patentdate(LocalDate patentdate) {
        setPatentdate(patentdate);
        return this;
    }
    // -- [patentcountries] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "patentcountries", nullable = false, length = 1024)
    public String getPatentcountries() {
        return patentcountries;
    }

    public void setPatentcountries(String patentcountries) {
        this.patentcountries = patentcountries;
    }

    public Technologies patentcountries(String patentcountries) {
        setPatentcountries(patentcountries);
        return this;
    }
    // -- [scientists] ------------------------

    @NotEmpty
    @Size(max = 2048)
    @Column(name = "scientists", nullable = false, length = 2048)
    public String getScientists() {
        return scientists;
    }

    public void setScientists(String scientists) {
        this.scientists = scientists;
    }

    public Technologies scientists(String scientists) {
        setScientists(scientists);
        return this;
    }
    // -- [modificationdate] ------------------------

    @NotNull
    @Column(name = "modificationdate", nullable = false, length = 10)
    public LocalDate getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(LocalDate modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Technologies modificationdate(LocalDate modificationdate) {
        setModificationdate(modificationdate);
        return this;
    }
    // -- [scientistId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "scientist_id", nullable = false, precision = 10)
    public Integer getScientistId() {
        return scientistId;
    }

    public void setScientistId(Integer scientistId) {
        this.scientistId = scientistId;
    }

    public Technologies scientistId(Integer scientistId) {
        setScientistId(scientistId);
        return this;
    }
    // -- [published] ------------------------

    @NotNull
    @Column(name = "published", nullable = false, length = 0)
    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Technologies published(Boolean published) {
        setPublished(published);
        return this;
    }
    // -- [state] ------------------------

    @NotEmpty
    @Size(max = 10)
    @Column(name = "`state`", nullable = false, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Technologies state(String state) {
        setState(state);
        return this;
    }
    // -- [info] ------------------------

    @NotEmpty
    @Size(max = 32)
    @Column(name = "info", nullable = false, length = 32)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Technologies info(String info) {
        setInfo(info);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Technologies withDefaults() {
        setState("waiting");
        setInfo("w ofercie");
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Technologies && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Technologies instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("unit", getUnit()) //
                .add("department", getDepartment()) //
                .add("type", getType()) //
                .add("name", getName()) //
                .add("targets", getTargets()) //
                .add("description", getDescription()) //
                .add("goodsInnovation", getGoodsInnovation()) //
                .add("goodsConcurency", getGoodsConcurency()) //
                .add("benefits", getBenefits()) //
                .add("keywords", getKeywords()) //
                .add("requestnumber", getRequestnumber()) //
                .add("requestdate", getRequestdate()) //
                .add("requestcountries", getRequestcountries()) //
                .add("patentnumber", getPatentnumber()) //
                .add("patentdate", getPatentdate()) //
                .add("patentcountries", getPatentcountries()) //
                .add("scientists", getScientists()) //
                .add("modificationdate", getModificationdate()) //
                .add("scientistId", getScientistId()) //
                .add("published", getPublished()) //
                .add("state", getState()) //
                .add("info", getInfo()) //
                .toString();
    }
}