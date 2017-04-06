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
@Table(name = "research")
public class Research implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Research.class.getName());

    // Raw attributes
    private Integer id;
    private Integer scientistId;
    private String departments;
    private String unit;
    private String name;
    private String type;
    private String projecttarget;
    private String description;
    private String projecttime;
    private Integer cost;
    private String foundingsources;
    private String partners;
    private String results;
    private String industries;
    private String keywords;
    private String benefits;
    private String injBenefits;
    private String scientists;
    private LocalDate modificationdate;
    private Boolean published;
    private String state;

    @Override
    public String entityClassName() {
        return Research.class.getSimpleName();
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

    public Research id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
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

    public Research scientistId(Integer scientistId) {
        setScientistId(scientistId);
        return this;
    }
    // -- [departments] ------------------------

    @Size(max = 1024)
    @Column(name = "departments", length = 1024)
    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public Research departments(String departments) {
        setDepartments(departments);
        return this;
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

    public Research unit(String unit) {
        setUnit(unit);
        return this;
    }
    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "name", nullable = false, length = 512)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Research name(String name) {
        setName(name);
        return this;
    }
    // -- [type] ------------------------

    @Size(max = 128)
    @Column(name = "`type`", length = 128)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Research type(String type) {
        setType(type);
        return this;
    }
    // -- [projecttarget] ------------------------

    @Size(max = 512)
    @Column(name = "projecttarget", length = 512)
    public String getProjecttarget() {
        return projecttarget;
    }

    public void setProjecttarget(String projecttarget) {
        this.projecttarget = projecttarget;
    }

    public Research projecttarget(String projecttarget) {
        setProjecttarget(projecttarget);
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

    public Research description(String description) {
        setDescription(description);
        return this;
    }
    // -- [projecttime] ------------------------

    @NotEmpty
    @Size(max = 64)
    @Column(name = "projecttime", nullable = false, length = 64)
    public String getProjecttime() {
        return projecttime;
    }

    public void setProjecttime(String projecttime) {
        this.projecttime = projecttime;
    }

    public Research projecttime(String projecttime) {
        setProjecttime(projecttime);
        return this;
    }
    // -- [cost] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "cost", precision = 10)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Research cost(Integer cost) {
        setCost(cost);
        return this;
    }
    // -- [foundingsources] ------------------------

    @Size(max = 512)
    @Column(name = "foundingsources", length = 512)
    public String getFoundingsources() {
        return foundingsources;
    }

    public void setFoundingsources(String foundingsources) {
        this.foundingsources = foundingsources;
    }

    public Research foundingsources(String foundingsources) {
        setFoundingsources(foundingsources);
        return this;
    }
    // -- [partners] ------------------------

    @Size(max = 512)
    @Column(name = "partners", length = 512)
    public String getPartners() {
        return partners;
    }

    public void setPartners(String partners) {
        this.partners = partners;
    }

    public Research partners(String partners) {
        setPartners(partners);
        return this;
    }
    // -- [results] ------------------------

    @Size(max = 512)
    @Column(name = "results", length = 512)
    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Research results(String results) {
        setResults(results);
        return this;
    }
    // -- [industries] ------------------------

    @Size(max = 1024)
    @Column(name = "industries", length = 1024)
    public String getIndustries() {
        return industries;
    }

    public void setIndustries(String industries) {
        this.industries = industries;
    }

    public Research industries(String industries) {
        setIndustries(industries);
        return this;
    }
    // -- [keywords] ------------------------

    @Size(max = 512)
    @Column(name = "keywords", length = 512)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Research keywords(String keywords) {
        setKeywords(keywords);
        return this;
    }
    // -- [benefits] ------------------------

    @Size(max = 512)
    @Column(name = "benefits", length = 512)
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Research benefits(String benefits) {
        setBenefits(benefits);
        return this;
    }
    // -- [injBenefits] ------------------------

    @Size(max = 1000)
    @Column(name = "inj_benefits", length = 1000)
    public String getInjBenefits() {
        return injBenefits;
    }

    public void setInjBenefits(String injBenefits) {
        this.injBenefits = injBenefits;
    }

    public Research injBenefits(String injBenefits) {
        setInjBenefits(injBenefits);
        return this;
    }
    // -- [scientists] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "scientists", nullable = false, length = 512)
    public String getScientists() {
        return scientists;
    }

    public void setScientists(String scientists) {
        this.scientists = scientists;
    }

    public Research scientists(String scientists) {
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

    public Research modificationdate(LocalDate modificationdate) {
        setModificationdate(modificationdate);
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

    public Research published(Boolean published) {
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

    public Research state(String state) {
        setState(state);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Research withDefaults() {
        setState("waiting");
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Research && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Research instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("scientistId", getScientistId()) //
                .add("departments", getDepartments()) //
                .add("unit", getUnit()) //
                .add("name", getName()) //
                .add("type", getType()) //
                .add("projecttarget", getProjecttarget()) //
                .add("description", getDescription()) //
                .add("projecttime", getProjecttime()) //
                .add("cost", getCost()) //
                .add("foundingsources", getFoundingsources()) //
                .add("partners", getPartners()) //
                .add("results", getResults()) //
                .add("industries", getIndustries()) //
                .add("keywords", getKeywords()) //
                .add("benefits", getBenefits()) //
                .add("injBenefits", getInjBenefits()) //
                .add("scientists", getScientists()) //
                .add("modificationdate", getModificationdate()) //
                .add("published", getPublished()) //
                .add("state", getState()) //
                .toString();
    }
}