package com.project.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;

public class DDBAccess {

    private DynamoDBMapper ddbMapper =
            new DynamoDBMapper((AmazonDynamoDB) AmazonDynamoDBClientBuilder.standard().build());

    public ProductCatalog getItem(ProductCatalog item) {
        return ddbMapper.load(ProductCatalog.class, item.getProductId(), item.getLotNumber());
    }

    public void saveItem(ProductCatalog item) {
        ddbMapper.save(item);
    }

    public List<ProductCatalog> getItems(ProductCatalog item) {
        return ddbMapper.query(ProductCatalog.class, new DynamoDBQueryExpression().withHashKeyValues(item));
    }
}
