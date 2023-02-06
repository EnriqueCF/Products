INSERT INTO PRODUCT (id,sequence) SELECT * FROM CSVREAD('classpath:product.csv');
INSERT INTO STOCK (sizeId,quantity) SELECT * FROM CSVREAD('classpath:stock.csv');
INSERT INTO SIZE (id, productId, backSoon, special) SELECT * FROM CSVREAD('classpath:size.csv');
