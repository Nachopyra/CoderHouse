CREATE TABLE IF NOT EXISTS clients
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    lastname VARCHAR(75) NOT NULL,
    docnumber VARCHAR(11) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS invoice
(
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(75) NOT NULL,
    created_at DATETIME NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE IF NOT EXISTS product
(
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(150) NOT NULL,
    code VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    price DECIMAL(10,2),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS invoice_detail
(
    invoice_detail_id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL,
    product_id INT NOT NULL,
    amount INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    invoice_id INT,

    PRIMARY KEY (invoice_detail_id),
    FOREIGN KEY (invoice_id) REFERENCES clients(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

