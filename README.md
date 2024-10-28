# LABA-2nd-Part

### Summary

1. DAO classes in `src/main/java/dao`
2. Service Layer in `src/main/java/servicelayer`
3. XML & XSD schema in `src/main/resources/xml | xsd`
4. XML validated using XSD schema in `src/main/java/utils/xml/XMLValidator.java`
5. XML parser in `src/main/java/utils/xml/StAXParser.java`
6. JAXB annotations added in `src/main/java/model`
7. JAXB parsers in `src/main/java/jaxb`
8. JSON file for 5 classes in `src/main/resources/schema.json`
9. JSON annotations added in `src/main/java/model`
10. JSON parsers in `src/main/java/jackson`
11. MyBatis mappers in `src/main/java/mybatis`

### Main method output: 
```
04:07:19.893 [main] INFO  org.laba.Main - LOADING SOME DATA FROM THE DATABASE...
04:07:20.974 [main] INFO  org.laba.Main - LOADED COUNTRY 'USA' FROM DATABASE
04:07:20.980 [main] INFO  org.laba.Main - LOADED STORE 'Just Sports' FROM DATABASE
04:07:20.985 [main] INFO  org.laba.Main - LOADED USER 'Franco' FROM DATABASE
04:07:20.989 [main] INFO  org.laba.Main - LOADED CATEGORY 'Automotive' FROM DATABASE
04:07:20.994 [main] INFO  org.laba.Main - LOADED PAYMENT 'Cash' FROM DATABASE
04:07:21.007 [main] INFO  org.laba.Main - INSERTED PRODUCT 'Toyota AE86' INTO THE DATABASE
04:07:21.021 [main] INFO  org.laba.Main - INSERTED ORDER NO.1 INTO THE DATABASE
```