//catalogDB
db.product.createIndex({"productId":1}, {unique:true});
db.category.createIndex({"categoryId":1}, {unique:true});
db.sku.createIndex({"skuId":1}, {unique:true});
db.vku.createIndex({"vkuId":1}, {unique:true});
db.catalog.createIndex({"catalogId":1}, {unique:true});


//coreDB
db.commonConfig.createIndex({"propName":1}, {unique:true});
db.shippingMethod.createIndex({"shippingMethodId":1}, {unique:true});




