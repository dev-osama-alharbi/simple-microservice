CREATE TABLE client (
  id INT AUTO_INCREMENT NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   phone_number VARCHAR(255) NOT NULL,
   price DECIMAL(10, 2) NOT NULL,
   is_admin BIT NOT NULL,
   is_delete BIT NOT NULL,
   CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT NOT NULL,
   title VARCHAR(255) NOT NULL,
   quantity INT NOT NULL,
   price DECIMAL(10, 2) NOT NULL,
   is_delete BIT NOT NULL,
   CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE payment (
  id INT AUTO_INCREMENT NOT NULL,
   datetime datetime NOT NULL,
   quantity INT NOT NULL,
   price DECIMAL(10, 2) NOT NULL,
   client_id INT NOT NULL,
   order_id INT NOT NULL,
   CONSTRAINT pk_payment PRIMARY KEY (id)
);

ALTER TABLE payment ADD CONSTRAINT FK_PAYMENT_ON_CLIENT FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE payment ADD CONSTRAINT FK_PAYMENT_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);

