package com.report.dao.service;


import com.report.server.dao.entity.CellInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description 单元格信息
 * @Author huguangyin
 * @Date 2019/6/19-18:12
 *  
 */
public interface ICellInfoDAO extends JpaRepository<CellInfoEntity,Long> {
    /**
     * 插入单元格信息
     *
     * @param entity
     * @return
     * @throws Exception
     */
    Long insertCellInfo(CellInfoEntity entity) throws Exception;

    /**
     * 更新或者新增单元格信息
     *
     * @param entity
     * @return
     * @throws Exception
     */
    Long updateOrInsertCellInfo(CellInfoEntity entity) throws Exception;

    /**
     * 更新单元格信息
     *
     * @param entity
     * @return
     * @throws Exception
     */
    Long updateCellInfo(CellInfoEntity entity) throws Exception;

    /**
     * 计数
     *
     * @return
     * @throws Exception
     */
    Integer countCellInfo() throws Exception;

    /**
     * 查询单元格信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    CellInfoEntity queryCellInfoById(Long id) throws Exception;

    /**
     * 查询单元格信息
     *
     * @param rowId
     * @param colId
     * @return
     * @throws Exception
     */
    CellInfoEntity queryCellInfoByRowColId(Long rowId, Long colId) throws Exception;

    /**
     * 查询单元格信息
     *
     * @param rowId
     * @return
     * @throws Exception
     */
    List<CellInfoEntity> queryCellInfoByRowId(Long rowId) throws Exception;

    /**
     * 查询单元格信息
     *
     * @param colId
     * @return
     * @throws Exception
     */
    List<CellInfoEntity> queryCellInfoByColId(Long colId) throws Exception;

    /**
     * 删除单元格信息
     *
     * @param id
     * @return
     */
    boolean deleteCellInfo(Long id);
}
