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
@Table(name = "cell_info", schema = "report")
public class CellInfoEntity implements IEntity {
    private Long id;
    private int cellType;
    private String cellValue;
    private String rowIndex;
    private String colIndex;
    private long rowId;
    private long colId;
    private long tableId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cell_type")
    public int getCellType() {
        return cellType;
    }

    public void setCellType(int cellType) {
        this.cellType = cellType;
    }

    @Basic
    @Column(name = "cell_value")
    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    @Basic
    @Column(name = "row_index")
    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Basic
    @Column(name = "col_index")
    public String getColIndex() {
        return colIndex;
    }

    public void setColIndex(String colIndex) {
        this.colIndex = colIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CellInfoEntity that = (CellInfoEntity) o;
        return id == that.id &&
                cellType == that.cellType &&
                Objects.equals(cellValue, that.cellValue) &&
                Objects.equals(rowIndex, that.rowIndex) &&
                Objects.equals(colIndex, that.colIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cellType, cellValue, rowIndex, colIndex);
    }

    @Basic
    @Column(name = "row_id")
    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "table_id")
    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "col_id")
    public long getColId() {
        return colId;
    }

    public void setColId(long colId) {
        this.colId = colId;
    }
}
