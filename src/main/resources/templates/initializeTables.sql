CREATE TABLE category (
category_id int NOT NULL,
category_name text NOT NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE artpiece (
artpiece_id int NOT NULL,
name text NOT NULL,
price REAL NOT NULL,
description text NOT NULL,
category_id int NOT NULL,
PRIMARY KEY(artpiece_id),
CONSTRAINT fk_category
FOREIGN KEY(category_id)
REFERENCES category(category_id)
);

CREATE TABLE image (
image_id int NOT NULL,
link text NOT NULL,
artpiece_id int NOT NULL,
PRIMARY KEY(image_id),
CONSTRAINT fk_artpiece
FOREIGN KEY(artpiece_id)
REFERENCES artpiece(artpiece_id)
);

CREATE TABLE artorder (
order_id int NOT NULL,
total REAL NOT NULL,
customer_email text NOT NULL,
ordered_at_timestamp BIGINT NOT NULL,
fullfilled boolean NOT NULL,
PRIMARY KEY(order_id)
);

CREATE TABLE orderitem (
orderitem_id int NOT NULL,
amount INT NOT NULL,
order_id INT NOT NULL,
PRIMARY KEY(orderitem_id),
CONSTRAINT fk_order
FOREIGN KEY(order_id)
REFERENCES artorder(order_id)
);

CREATE TABLE orderartpiece (
orderitem_id int NOT NULL,
artpiece_id int NOT NULL,
PRIMARY KEY (orderitem_id, artpiece_id),
CONSTRAINT fk_orderitem FOREIGN KEY(orderitem_id) REFERENCES orderitem(orderitem_id),
CONSTRAINT fk_artpiece FOREIGN KEY(artpiece_id) REFERENCES artpiece(artpiece_id)
);
