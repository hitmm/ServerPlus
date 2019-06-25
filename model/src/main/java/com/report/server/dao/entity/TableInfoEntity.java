package com.report.server.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/21-23:52
 *  
 */
@Entity
@Table(name = "table_info", schema = "report")
public class TableInfoEntity implements Serializable, IEntity {
    private Long id;
    private String tableName;
    private String tableAlias;
    private Long tableSize;
    private Long tableRowCount;
    private Long tableOwner;

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
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "table_alias")
    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    @Basic
    @Column(name = "table_size")
    public Long getTableSize() {
        return tableSize;
    }

    public void setTableSize(Long tableSize) {
        this.tableSize = tableSize;
    }

    @Basic
    @Column(name = "table_row_count")
    public Long getTableRowCount() {
        return tableRowCount;
    }

    public void setTableRowCount(Long tableRowCount) {
        this.tableRowCount = tableRowCount;
    }

    @Basic
    @Column(name = "table_owner")
    public Long getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(Long tableOwner) {
        this.tableOwner = tableOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableInfoEntity that = (TableInfoEntity) o;
        return id == that.id &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(tableAlias, that.tableAlias) &&
                Objects.equals(tableSize, that.tableSize) &&
                Objects.equals(tableRowCount, that.tableRowCount) &&
                Objects.equals(tableOwner, that.tableOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableName, tableAlias, tableSize, tableRowCount, tableOwner);
    }
}
