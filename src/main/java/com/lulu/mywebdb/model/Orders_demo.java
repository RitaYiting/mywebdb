package com.lulu.mywebdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders_demo {
    int orderNumber;
    Date orderDate;
    Date requiredDate;
    String comments;
    String customerName;

}
