-- Для каждого производителя, выпускающего ПК-блокноты c объёмом жесткого диска не менее 10 Гбайт, найти скорости таких ПК-блокнотов.
-- Вывод: производитель, скорость.

SELECT DISTINCT maker,
                laptop.speed
FROM product
JOIN laptop ON product.model = laptop.model
WHERE laptop.hd >= 10

-- Найдите номера моделей и цены всех имеющихся в продаже продуктов (любого типа) производителя B (латинская буква).

SELECT DISTINCT pc.model,
                pc.price
FROM product
JOIN pc ON pc.model = product.model
WHERE product.maker = 'B'
UNION
SELECT DISTINCT laptop.model,
                laptop.price
FROM product
JOIN laptop ON laptop.model = product.model
WHERE product.maker = 'B'
UNION
SELECT DISTINCT printer.model,
                printer.price
FROM product
JOIN printer ON printer.model = product.model
WHERE product.maker = 'B'

-- Найдите производителя, выпускающего ПК, но не ПК-блокноты.

SELECT DISTINCT maker
FROM product
WHERE product.type = 'pc'
EXCEPT
SELECT DISTINCT maker
FROM product
WHERE product.type = 'laptop'

-- Найдите модели принтеров, имеющих самую высокую цену.
-- Вывести: model, price

SELECT product.model,
       printer.price
FROM product
JOIN printer ON product.model = printer.model
WHERE printer.price =
    (SELECT max(printer.price)
     FROM printer)

-- Найдите размеры жестких дисков, совпадающих у двух и более PC.
-- Вывести: HD

SELECT hd
FROM pc
GROUP BY hd
HAVING count(hd) >= 2

-- Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается только один раз, т.е. (i,j), но не (j,i),
-- Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.

SELECT DISTINCT a.model,
                b.model,
                a.speed,
                a.ram
FROM pc AS a,
     pc b
WHERE a.speed = b.speed
  AND a.ram = b.ram
  AND a.model > b.model

-- Найдите модели ПК-блокнотов, скорость которых меньше скорости каждого из ПК.
-- Вывести: type, model, speed

SELECT DISTINCT product.type,
                laptop.model,
                laptop.speed
FROM laptop
JOIN product ON laptop.model = product.model
WHERE speed < all
    (SELECT speed
     FROM pc)

-- Найдите производителей самых дешевых цветных принтеров.
-- Вывести: maker, price

SELECT DISTINCT product.maker,
                printer.price
FROM printer
JOIN product ON printer.model = product.model
WHERE price = ANY
    (SELECT min(printer.price)
     FROM printer
     WHERE color = 'y')
  AND printer.color = 'y'

-- Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов.
-- Вывести: maker, средний размер экрана.

SELECT product.maker,
       avg(screen) AS avg_scr
FROM laptop
JOIN product ON product.model = laptop.model
GROUP BY product.maker

-- Найдите производителей, выпускающих по меньшей мере три различных модели ПК.
-- Вывести: Maker, число моделей ПК.

SELECT product.maker,
       count(DISTINCT product.model) AS q
FROM product
FULL JOIN pc ON product.model = pc.model
WHERE TYPE = 'pc'
GROUP BY product.maker
HAVING count(DISTINCT product.model) >= 3

-- Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC.
-- Вывести: maker, максимальная цена.

SELECT product.maker,
       max(pc.price) AS price
FROM product
JOIN pc ON product.model = pc.model
WHERE product.model = pc.model
GROUP BY product.maker

-- Найдите производителей, которые производили бы как ПК со скоростью не менее 750 МГц, так и ПК-блокноты со скоростью не менее 750 МГц.
-- Вывести: Maker

SELECT maker
FROM product
JOIN pc ON product.model = pc.model
WHERE pc.speed >= 750
GROUP BY maker INTERSECT
SELECT maker
FROM product
JOIN laptop ON product.model = laptop.model
WHERE laptop.speed >= 750
GROUP BY maker

-- Перечислите номера моделей любых типов, имеющих самую высокую цену по всей имеющейся в базе данных продукции.

WITH res AS
  (SELECT DISTINCT pc.model,
                   pc.price
   FROM pc
   WHERE pc.price =
       (SELECT max(pc.price)
        FROM pc)
   UNION ALL SELECT DISTINCT laptop.model,
                             laptop.price
   FROM laptop
   WHERE laptop.price =
       (SELECT max(laptop.price)
        FROM laptop)
   UNION ALL SELECT DISTINCT printer.model,
                             printer.price
   FROM printer
   WHERE printer.price =
       (SELECT max(printer.price)
        FROM printer))
SELECT model
FROM res
WHERE price =
    (SELECT max(price)
     FROM res)

-- Найдите производителей принтеров, которые производят ПК с наименьшим объемом RAM и с самым быстрым процессором среди всех ПК, имеющих наименьший объем RAM.
-- Вывести: Maker

SELECT DISTINCT maker
FROM product
WHERE TYPE = 'printer'
  AND maker in
    (SELECT maker
     FROM product
     JOIN pc ON product.model = pc.model
     WHERE pc.ram =
         (SELECT min(pc.ram)
          FROM pc)
       AND pc.model in
         (SELECT model
          FROM pc
          WHERE speed =
              (SELECT max(speed)
               FROM
                 (SELECT speed
                  FROM pc
                  WHERE ram =
                      (SELECT min(ram)
                       FROM pc) ) AS a) ) )

-- Найдите среднюю цену ПК и ПК-блокнотов, выпущенных производителем A (латинская буква).
-- Вывести: одна общая средняя цена.

WITH res AS
  (SELECT pc.price
   FROM product
   JOIN pc ON product.model = pc.model
   WHERE TYPE = 'pc'
     AND maker = 'A'
   UNION ALL SELECT laptop.price
   FROM product
   JOIN laptop ON product.model = laptop.model
   WHERE TYPE = 'laptop'
     AND maker = 'A' )
SELECT avg(price) AS avg_res
FROM res

-- Найдите средний размер диска ПК каждого из тех производителей, которые выпускают и принтеры.
-- Вывести: maker, средний размер HD.

SELECT product.maker,
       avg(pc.hd)
FROM product,
     pc
WHERE product.model = pc.model
  AND maker in
    (SELECT maker
     FROM product
     WHERE TYPE = 'printer')
GROUP BY maker

-- Используя таблицу Product, определить количество производителей, выпускающих по одной модели.

SELECT count(maker)
FROM product
WHERE maker in
    (SELECT maker
     FROM product
     GROUP BY maker
     HAVING count(model) = 1)

