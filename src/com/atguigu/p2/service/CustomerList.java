package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
    private Customer[] customers; //用来保存客户对象的数组
    private int total = 0;

    /**
    * @Description: 用来初始化数组的构造器。
    * @Param: [totalCustomer] 指定数组的长度。
    * @return: 
    */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
    * @Description: 将指定客户添加到数组中。
    * @Param: [customer]
    * @return: true: 添加成功 false: 失败
    */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
    * @Description: 修改指定索引位置的客户信息。
    * @Param: [index, cust]
    * @return: true: 添加成功 false: 失败
    */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
    * @Description: 删除指定索引位置上的客户。
    * @Param: [index]
    * @return: true: 添加成功 false: 失败
    */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        //不能直接置为 null，因为数组连续存储
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
    * @Description: 获取所有的客户信息。
    * @Param: []
    * @return: com.atguigu.p2.bean.Customer[]
    */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
    * @Description: 获取指定索引位置上的客户。
    * @Param: [index]
    * @return: 如果找到了元素，则返回；否则，返回 null。
    */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
    * @Description: 获取存储的客户的数量。
    * @Param: []
    * @return: int
    */
    public int getTotal() {
        return total;
    }
}
