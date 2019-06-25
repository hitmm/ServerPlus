package com.report.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.report.server.common.DataTypeEnum;
import com.report.server.common.PageEntity;
import com.report.server.dao.entity.CellInfoEntity;
import com.report.server.dao.entity.ReferenceInfoEntity;
import com.report.server.dao.entity.TableInfoEntity;
import com.report.server.service.dto.TableContentDTO;
import com.report.server.service.result.TableContentListResult;
import com.report.server.service.result.TableContentResult;
import com.report.service.service.ITableContentService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableContentServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(TableContentServiceImplTest.class);

    private ITableContentService contentService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.service.xml", "classpath:dubbo.xml");
        this.contentService = applicationContext.getBean(ITableContentService.class);
        PropertyConfigurator.configure("D:\\codingData\\Server\\web\\src\\main\\resources\\log4j2.xml");
        logger.warn("1111111111111111111L");
    }

    @Test
    public void insertNewTable() throws Exception {
        TableContentDTO dto = new TableContentDTO();
        ReferenceInfoEntity entity = null;
        List<ReferenceInfoEntity> rows = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            entity = new ReferenceInfoEntity();
            entity.setReferenceIndex("row:" + i + "");
            entity.setReferenceAlias("姓名");
            entity.setReferenceDataType(DataTypeEnum.STRING.getDataType());
            entity.setReferenceName("name");
            entity.setReferenceLength(20);
            entity.setReferenceType((byte) 0);
            rows.add(entity);
        }
        List<ReferenceInfoEntity> cols = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            entity = new ReferenceInfoEntity();
            entity.setReferenceIndex("col:" + i + "");
            entity.setReferenceAlias("A" + i);
            entity.setReferenceDataType(DataTypeEnum.STRING.getDataType());
            entity.setReferenceName("" + i);
            entity.setReferenceLength(20);
            entity.setReferenceType((byte) 1);
            cols.add(entity);
        }
        dto.setCols(cols);
        dto.setRows(rows);
        Map<Long, CellInfoEntity> cellInfoEntityMap = new HashMap<>();
        CellInfoEntity cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:0");
        cellInfoEntity.setRowIndex("row:0");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("aaaa");
        cellInfoEntityMap.put(1L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:0");
        cellInfoEntity.setRowIndex("row:1");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("bbbb");
        cellInfoEntityMap.put(2L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:1");
        cellInfoEntity.setRowIndex("row:0");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("cccc");
        cellInfoEntityMap.put(3L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:1");
        cellInfoEntity.setRowIndex("row:1");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("dddd");
        cellInfoEntityMap.put(4L, cellInfoEntity);

        dto.setCellInfoEntityMap(cellInfoEntityMap);

        TableInfoEntity tableInfoEntity = new TableInfoEntity();
        tableInfoEntity.setTableAlias("测试表");
        tableInfoEntity.setTableName("TEST_TABLE");
        tableInfoEntity.setTableOwner(1212L);
        tableInfoEntity.setTableRowCount((long) 2);
        tableInfoEntity.setTableSize((long) cellInfoEntityMap.size());
        dto.setTableInfoEntity(tableInfoEntity);

        TableContentResult result = contentService.insertNewTable(dto);

        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    public void queryTableContentByUserId() throws Exception {
        PageEntity page = new PageEntity();
        page.setPageNum(1);
        page.setPageSize(10);
        TableContentListResult result = contentService.queryTableContentByUserId(1212L, page);
        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    public void queryTableContentById() throws Exception {
        TableContentResult result = contentService.queryTableContentById(29L);
        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    public void deleteTable() throws Exception {
        TableContentResult result = contentService.deleteTable(29L);
        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    public void insertNewRow() throws Exception {
        TableContentResult result = contentService.queryTableContentById(31L);
        TableContentDTO data = result.getData();
        TableContentDTO dto = new TableContentDTO();
        List<ReferenceInfoEntity> rows = new ArrayList<>();
        ReferenceInfoEntity entity = new ReferenceInfoEntity();
        entity.setReferenceType((byte) 0);
        entity.setReferenceIndex("row:33");
        entity.setReferenceLength(21);
        entity.setReferenceDataType(DataTypeEnum.STRING.getDataType());
        entity.setReferenceName("name1");
        entity.setReferenceAlias("性别");
        rows.add(entity);
        dto.setRows(rows);
        Map<Long, CellInfoEntity> cellInfoEntityMap = new HashMap<>();
        CellInfoEntity cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:0");
        cellInfoEntity.setRowIndex("row:33");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("eeee");
        cellInfoEntityMap.put(1L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:1");
        cellInfoEntity.setRowIndex("row:33");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("ffff");
        cellInfoEntityMap.put(2L, cellInfoEntity);
        dto.setCellInfoEntityMap(cellInfoEntityMap);
        dto.setTableInfoEntity(data.getTableInfoEntity());
        dto.setTableId(data.getTableId());
        TableContentResult result1 = contentService.insertNewRow(dto);

        System.out.println(JSONObject.toJSONString(result1));
    }

    @Test
    public void insertNewCol() throws Exception {
        TableContentResult result = contentService.queryTableContentById(31L);
        TableContentDTO data = result.getData();
        TableContentDTO dto = new TableContentDTO();
        List<ReferenceInfoEntity> cols = new ArrayList<>();
        ReferenceInfoEntity entity = new ReferenceInfoEntity();
        entity.setReferenceType((byte) 1);
        entity.setReferenceIndex("col:33");
        entity.setReferenceLength(21);
        entity.setReferenceDataType(DataTypeEnum.STRING.getDataType());
        entity.setReferenceName("33");
        entity.setReferenceAlias("A33");
        cols.add(entity);
        dto.setCols(cols);
        Map<Long, CellInfoEntity> cellInfoEntityMap = new HashMap<>();
        CellInfoEntity cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:33");
        cellInfoEntity.setRowIndex("row:33");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("GGGG");
        cellInfoEntityMap.put(1L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:33");
        cellInfoEntity.setRowIndex("row:0");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("HHHH");
        cellInfoEntityMap.put(2L, cellInfoEntity);
        cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setColIndex("col:33");
        cellInfoEntity.setRowIndex("row:1");
        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
        cellInfoEntity.setCellValue("IIII");
        cellInfoEntityMap.put(3L, cellInfoEntity);
        dto.setCellInfoEntityMap(cellInfoEntityMap);
        dto.setTableInfoEntity(data.getTableInfoEntity());
        dto.setTableId(data.getTableId());
        TableContentResult result1 = contentService.insertNewCol(dto);

        System.out.println(JSONObject.toJSONString(result1));
    }

    @Test
    public void updateRows() {
    }

    @Test
    public void updateCols() throws Exception {

        TableContentResult result = contentService.queryTableContentById(31L);
        TableContentDTO data = result.getData();
        TableContentDTO dto = new TableContentDTO();
        List<ReferenceInfoEntity> cols = new ArrayList<>();
        ReferenceInfoEntity entity = new ReferenceInfoEntity();
        entity.setReferenceType((byte) 1);
        entity.setReferenceIndex("col:34");
        entity.setReferenceLength(21);
        entity.setReferenceDataType(DataTypeEnum.STRING.getDataType());
        entity.setReferenceName("33");
        entity.setReferenceAlias("A34");
        entity.setId(134L);
        entity.setTableId(31L);
        cols.add(entity);
        dto.setCols(cols);
//        Map<Long, CellInfoEntity> cellInfoEntityMap = new HashMap<>();
//        CellInfoEntity cellInfoEntity = new CellInfoEntity();
//        cellInfoEntity.setColIndex("col:33");
//        cellInfoEntity.setRowIndex("row:33");
//        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
//        cellInfoEntity.setCellValue("GGGG");
//        cellInfoEntity.setId(114L);
//        cellInfoEntityMap.put(114L, cellInfoEntity);
//        cellInfoEntity = new CellInfoEntity();
//        cellInfoEntity.setColIndex("col:33");
//        cellInfoEntity.setRowIndex("row:0");
//        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
//        cellInfoEntity.setCellValue("HHHH");
//        cellInfoEntity.setId(115L);
//        cellInfoEntityMap.put(115L, cellInfoEntity);
//        cellInfoEntity = new CellInfoEntity();
//        cellInfoEntity.setColIndex("col:33");
//        cellInfoEntity.setRowIndex("row:1");
//        cellInfoEntity.setCellType(DataTypeEnum.STRING.getDataType());
//        cellInfoEntity.setCellValue("IIII");
//        cellInfoEntity.setId(116L);
//        cellInfoEntityMap.put(116L, cellInfoEntity);
//        dto.setCellInfoEntityMap(cellInfoEntityMap);
        dto.setTableInfoEntity(data.getTableInfoEntity());
        dto.setTableId(data.getTableId());
        TableContentResult result1 = contentService.updateCols(dto);

        System.out.println(JSONObject.toJSONString(result1));
    }
}
