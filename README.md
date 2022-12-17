# Receipt Composer

### Task Description
Разработать консольное приложение, реализующее функционал формирования
чека в магазине.
1. В данном задании важно показать понимание ООП, умение строить модели
(выделять классы, интерфейсы, их связи), разделять функционал между ними, а
также знать синтаксис самого языка. Обязательно применение паттернов
проектирования (Factory, Builder, Decorator). Обратить внимание на устойчивость
к изменениям в логике и избегать копипаста.
2. Использовать Java 17, gradle 7.5.
3. Приложение запускается java RunnerClassName <набор_параметров>, где набор
параметров в формате itemId-quantity (itemId - идентификатор товара, quantity -
его количество.
Например: java CheckRunner 3-1 2-5 5-1 card-1234 должен сформировать и
вывести в консоль чек содержащий в себе наименование товара с id=3 в
количестве 1шт, то же самое с id=2 в количестве 5 штук, id=5 - одна штука и т. д.
Card-1234 означает, что была предъявлена скидочная карта с номером 1234.
Необходимо вывести в консоль сформированный чек (вариант на рисунке),
содержащий в себе список товаров и их количество с ценой, а также
рассчитанную сумму с учетом скидки по предъявленной карте (если она есть).
4. Среди товаров предусмотреть акционные. Если их в чеке больше пяти, то
сделать скидку 10% по этой позиции. Данную информацию отразить в чеке.
5. Набор товаров и скидочных карт может задаваться прямо в коде, массивом или
коллекцией объектов. Их количество и номенклатура имеет тестовый характер,
поэтому наименование и количество свободные.
6. Реализовать обработку исключений (например, товара с id или файла не
существует и т. д.).
7. Реализовать вывод чека в файл.
8. Описать README.md файл (используемый стек, инструкцию по запуску,
описание эндпоинтов, если есть).
9. Использовать сборщик проекта gradle.
10. Исходники разместить в любом из публичных репозиториев (bitbucket, github,
gitlab).
11. Организовать чтение исходных данных (товары и скидочные карты, формат тот
же) из файлов (в таком случае можно передавать имя файла в набор
параметров команды java).
12. Покрыть функционал юнит-тестами (не менее 70%).
13. Замена хранения исходных данных (п.11) в файлах на PostgreSQL; сделать 2
таблицы (product и discount_card); DDL операции должны храниться в
src/main/resources в файле с расширением *.sql; настройки подключения к БД
хранить в application.properties.
14. Реализовать RESTFUL - интерфейс (например, получать чек по GET
http://localhost:8080/check?itemId=1&itemId=1). Реализация на выбор (Servlet,
Spring). UI реализовывать не нужно.15. *** Развернуть приложение и PostgreSQL в Docker
16. Расширить функционал на свое усмотрение.

Необязательно, но будет существенным плюсом. К этим пунктам лучше
приступать после качественного решения базовых задач с применением принципов
SOLID, декларативных подходов, оптимальных алгоритмов.

### Description to application


### How to run

There following possibility to run an application:

- run the application with the program arguments (for instance: 31-1 2-5 5-1 card-2, where 31-1 -> {item id}-{amount of items}; card-2 -> card-{card ID}
- run the application ang get an input parameters from the file *input_data.txt* located in a folder *resources*
- run the application and get the receipt by GET request via REST (described bellow)

### DATABASE

The DB has a following schema:

![shopDB](shop.png)

The SQL script *shop.sql* to create tables and fill with data located in a folder *resources*

### REST API description
It is possible to get the receipt by the following GET request via REST, for instance

http://localhost:8080/check?itemId=1&itemAmount=5&discountCardId=1

Use for this Postman application.

