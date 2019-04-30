package com.project.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName="ProductCatalog")
public class ProductCatalog {

    @DynamoDBHashKey(attributeName="productId")
    private String productId;

    @DynamoDBRangeKey(attributeName="lotNumber")
    private long lotNumber;

    @DynamoDBAttribute(attributeName="title")
    private String title;

    @DynamoDBAttribute(attributeName="bestByDate")
    private long bestByDate;

    @DynamoDBAttribute(attributeName="mfgDate")
    private long mfgDate;
}
