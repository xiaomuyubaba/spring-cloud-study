package com.lijin.study.springcloud.service.dao.model;

import java.math.BigDecimal;
import java.util.Date;

public class Pay {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.pay_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private String payNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.order_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.user_id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.amount
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private BigDecimal amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.deleted
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private Byte deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.create_time
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pay.update_tIme
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.id
     *
     * @return the value of t_pay.id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.id
     *
     * @param id the value for t_pay.id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.pay_no
     *
     * @return the value of t_pay.pay_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.pay_no
     *
     * @param payNo the value for t_pay.pay_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.order_no
     *
     * @return the value of t_pay.order_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.order_no
     *
     * @param orderNo the value for t_pay.order_no
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.user_id
     *
     * @return the value of t_pay.user_id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.user_id
     *
     * @param userId the value for t_pay.user_id
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.amount
     *
     * @return the value of t_pay.amount
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.amount
     *
     * @param amount the value for t_pay.amount
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.deleted
     *
     * @return the value of t_pay.deleted
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.deleted
     *
     * @param deleted the value for t_pay.deleted
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.create_time
     *
     * @return the value of t_pay.create_time
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.create_time
     *
     * @param createTime the value for t_pay.create_time
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pay.update_tIme
     *
     * @return the value of t_pay.update_tIme
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pay.update_tIme
     *
     * @param updateTime the value for t_pay.update_tIme
     *
     * @mbg.generated Thu Dec 19 21:25:42 CST 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}