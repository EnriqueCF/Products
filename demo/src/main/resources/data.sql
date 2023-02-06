INSERT INTO PRODUCT (id,sequence) SELECT * FROM CSVREAD('C:\DEV\00 - repos\Otros\Products\demo\src\main\resources\product.csv');
INSERT INTO STOCK (sizeId,quantity) SELECT * FROM CSVREAD('C:\DEV\00 - repos\Otros\Products\demo\src\main\resources\stock.csv');
INSERT INTO SIZE (id, productId, backSoon, special) SELECT * FROM CSVREAD('C:\DEV\00 - repos\Otros\Products\demo\src\main\resources\size.csv');
