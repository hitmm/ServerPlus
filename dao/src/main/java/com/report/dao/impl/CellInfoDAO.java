package com.report.dao.impl;

import com.report.dao.service.ICellInfoDAO;
import com.report.server.dao.entity.CellInfoEntity;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/19-18:15
 *  
 */
public class CellInfoDAO extends BaseDAO implements ICellInfoDAO {

    private final static String DELETE_ID_HQL = "delete from CellInfoEntity where id = ?";
    private final static String QUERY_COL_ROW_HQL = "from CellInfoEntity where rowId = ? and colId = ?";
    private final static String QUERY_ROW_HQL = "from CellInfoEntity where rowId = ?";
    private final static String QUERY_COL_HQL = "from CellInfoEntity where colId = ?";
    private final static String COUNT_CELL_HQL = "select count(1) from cellInfo;";

    public static void main(String[] args) {
        new CellInfoDAO().deleteCellInfo(2L);
    }

    @Override
    public Long insertCellInfo(CellInfoEntity entity) throws Exception {
        return save(entity);
    }

    @Override
    public Long updateOrInsertCellInfo(CellInfoEntity entity) throws Exception {
        return saveOrUpdate(entity);
    }

    @Override
    public Long updateCellInfo(CellInfoEntity entity) throws Exception {
        return updateCellInfo(entity);
    }

    @Override
    public Integer countCellInfo() throws Exception {
        return count(COUNT_CELL_HQL, null);
    }

    @Override
    public CellInfoEntity queryCellInfoById(Long id) throws Exception {
        return query(id, CellInfoEntity.class);
    }

    @Override
    public CellInfoEntity queryCellInfoByRowColId(Long rowId, Long colId) throws Exception {
        return query(QUERY_COL_ROW_HQL, new Object[]{rowId, colId});
    }

    @Override
    public List<CellInfoEntity> queryCellInfoByRowId(Long rowId) throws Exception {
        return query(QUERY_ROW_HQL, new Object[]{rowId});
    }

    @Override
    public List<CellInfoEntity> queryCellInfoByColId(Long colId) throws Exception {
        return query(QUERY_COL_HQL, new Object[]{colId});
    }

    @Override
    public boolean deleteCellInfo(Long id) {
        delete(DELETE_ID_HQL, new Object[]{id});
        return true;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CellInfoEntity> findAll() {
        return null;
    }

    @Override
    public List<CellInfoEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CellInfoEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CellInfoEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CellInfoEntity cellInfoEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CellInfoEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CellInfoEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends CellInfoEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CellInfoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CellInfoEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<CellInfoEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CellInfoEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends CellInfoEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CellInfoEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CellInfoEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CellInfoEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CellInfoEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CellInfoEntity> boolean exists(Example<S> example) {
        return false;
    }
}
