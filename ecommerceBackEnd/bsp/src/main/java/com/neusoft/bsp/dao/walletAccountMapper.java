package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.walletAccount;

public interface walletAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer buyerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    int insert(walletAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    int insertSelective(walletAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    walletAccount selectByPrimaryKey(Integer buyerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(walletAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table waa_wallet_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(walletAccount record);
}