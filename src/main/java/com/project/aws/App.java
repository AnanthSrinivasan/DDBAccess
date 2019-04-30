package com.project.aws;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class App 
{
    public static void main( String[] args ) {
        DDBAccess ddbAccess = new DDBAccess();

        // 1. Create an Item into DDB table.
        ProductCatalog itemToRecord = createProductItem();
        ddbAccess.saveItem(itemToRecord);

        itemToRecord.setLotNumber(70005);
        ddbAccess.saveItem(itemToRecord);

        itemToRecord.setLotNumber(70003);
        ddbAccess.saveItem(itemToRecord);

        itemToRecord.setLotNumber(70004);
        ddbAccess.saveItem(itemToRecord);

        // 2. Fetch based on HashKey and RangeKey
        ProductCatalog itemToFetchFromHashAndRangeKeys = createProductItemWithHashAndRangeKeys();
        log.error("Item to fetch based on hashKey : {} - rangeKey : {}",
                itemToFetchFromHashAndRangeKeys.getProductId(), itemToFetchFromHashAndRangeKeys.getLotNumber());
        ProductCatalog item = ddbAccess.getItem(itemToFetchFromHashAndRangeKeys);
        log.error("Product item fetched :{}", item);

        // 3. Fetch item(s) based on HashKey
        ProductCatalog itemToFetchFromHashKey = createProductItemWithHashKey();
        log.error("Item to fetch based on hashKey : {}", itemToFetchFromHashKey.getProductId());
        List<ProductCatalog> itemsFetched = ddbAccess.getItems(itemToFetchFromHashKey);
        log.error("Items fetched :{}", itemsFetched);

    }

    private static ProductCatalog createProductItem() {
        // Setting expiry time of the product as 3 months time from now.
        ProductCatalog item = new ProductCatalog();
        item.setProductId("AE9QFENAED");
        item.setLotNumber(70002);
        item.setTitle("Cosmetics");
        item.setMfgDate(System.currentTimeMillis()/1000);
        item.setBestByDate(System.currentTimeMillis()/1000 + 86400*90);
        return item;
    }

    private static ProductCatalog createProductItemWithHashAndRangeKeys() {
        ProductCatalog item = new ProductCatalog();
        item.setProductId("AE9QFENAED");
        item.setLotNumber(70001);
        return item;
    }

    private static ProductCatalog createProductItemWithHashKey() {
        ProductCatalog item = new ProductCatalog();
        item.setProductId("AE9QFENAED");
        return item;
    }
}
