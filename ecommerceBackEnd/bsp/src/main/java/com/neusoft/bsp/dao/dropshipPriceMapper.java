package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.dropshipPrice;

public interface dropshipPriceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer drpId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    int insert(dropshipPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    int insertSelective(dropshipPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    dropshipPrice selectByPrimaryKey(Integer drpId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(dropshipPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drp_dropship_price
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(dropshipPrice record);
}