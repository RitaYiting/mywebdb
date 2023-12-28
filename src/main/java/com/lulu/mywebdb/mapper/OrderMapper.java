package com.lulu.mywebdb.mapper;

import com.lulu.mywebdb.model.Orders_List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.SQLException;

public class OrderMapper  implements RowMapper<Orders_List> {
    @Override
    public Orders_List mapRow(RestltSet rs, int rowNum) throws SQLException{
        Orders_List o = new Orders_List();
        o.setCustomerNumber("");
    }

}
