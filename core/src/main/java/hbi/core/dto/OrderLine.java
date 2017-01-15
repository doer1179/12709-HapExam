package hbi.core.dto;

import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Yc on 2017/1/12.
 */
@Table(name = "hap_om_order_lines")
public class OrderLine extends BaseDTO {
    @Column
    @Id
    private Integer lineId;
    @Column
    private Integer headerId;
    @Column
    private Integer lineNumber;
    @Column
    private Integer inventoryItemId;
    @Transient
    private String itemDescription;
    @Transient
    private String itemUom;
    @Transient
    private String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    @Column
    private Integer orderdQuantity;
    @Column
    private String orderQuantityUom;
    @Column
    private Integer unitSellingPrice;
    @Column
    private String description;
    @Column
    private Integer companyId;
    @Column
    private String addition1;
    @Column
    private String addition2;
    @Column
    private String addition3;
    @Column
    private String addition4;
    @Column
    private String addition5;


    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Integer inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Integer getOrderdQuantity() {
        return orderdQuantity;
    }

    public void setOrderdQuantity(Integer orderdQuantity) {
        this.orderdQuantity = orderdQuantity;
    }

    public String getOrderdQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderdQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public Integer getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Integer unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }
}