DROP TABLE IF EXISTS product;
create table product
(
    id              serial                         not null
        constraint product_pk
            primary key,
    product_name    varchar(50)                    not null,
    is_auction_item boolean          default false not null,
    price           double precision default 0     not null
);

DROP TABLE IF EXISTS discount_card;
create table discount_card
(
    id       serial not null
        constraint discount_card_pk
            primary key,
    discount integer
);

-- INSERT INTO public.product (id, product_name, is_auction_item, price) VALUES (5, 'yougurt', false, 2.1);
-- INSERT INTO public.product (id, product_name, is_auction_item, price) VALUES (3, 'beer', false, 1.8);
-- INSERT INTO public.product (id, product_name, is_auction_item, price) VALUES (1, 'milk', true, 2.3);
-- INSERT INTO public.product (id, product_name, is_auction_item, price) VALUES (4, 'cheese', false, 2.3);
-- INSERT INTO public.product (id, product_name, is_auction_item, price) VALUES (2, 'oil', true, 6.2);
--
-- INSERT INTO public.discount_card (id, discount) VALUES (1, 10);
-- INSERT INTO public.discount_card (id, discount) VALUES (2, 15);
-- INSERT INTO public.discount_card (id, discount) VALUES (3, 20);