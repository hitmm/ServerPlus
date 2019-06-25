package com.report.server.dao.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/21-23:50
 *  
 */
@Entity
@Table(name = "reference_info", schema = "report")
public class ReferenceInfoEntity implements IEntity {
    private Long id;
    private String referenceName;
    private String referenceAlias;
    private byte referenceType;
    private long referenceLength;
    /**
     * 0-short,1-int,2-long,3-double,4-float,5-String,6-boolean,7-byte,8-others
     */
    private int referenceDataType;
    private String referenceIndex;
    private long tableId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Transient
    public Long getIdent() {
        return id;
    }

    public void setIdent(Long id) {
        this.id = id;
    }

    @Override
    @Transient
    public String getVersion() {
        return null;
    }

    public void setVersion(String version) {

    }
    @Basic
    @Column(name = "reference_name")
    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    @Basic
    @Column(name = "reference_alias")
    public String getReferenceAlias() {
        return referenceAlias;
    }

    public void setReferenceAlias(String referenceAlias) {
        this.referenceAlias = referenceAlias;
    }

    @Basic
    @Column(name = "reference_type")
    public byte getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(byte referenceType) {
        this.referenceType = referenceType;
    }

    @Basic
    @Column(name = "reference_length")
    public long getReferenceLength() {
        return referenceLength;
    }

    public void setReferenceLength(long referenceLength) {
        this.referenceLength = referenceLength;
    }

    @Basic
    @Column(name = "reference_data_type")
    public int getReferenceDataType() {
        return referenceDataType;
    }

    public void setReferenceDataType(int referenceDataType) {
        this.referenceDataType = referenceDataType;
    }

    @Basic
    @Column(name = "reference_index")
    public String getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(String rowIndex) {
        this.referenceIndex = rowIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReferenceInfoEntity that = (ReferenceInfoEntity) o;
        return id == that.id &&
                referenceType == that.referenceType &&
                referenceLength == that.referenceLength &&
                referenceDataType == that.referenceDataType &&
                Objects.equals(referenceName, that.referenceName) &&
                Objects.equals(referenceAlias, that.referenceAlias) &&
                Objects.equals(referenceIndex, that.referenceIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceName, referenceAlias, referenceType, referenceLength, referenceDataType, referenceIndex);
    }

    @Basic
    @Column(name = "table_id")
    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }
}
