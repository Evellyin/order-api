-- changeset evellyin:1
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- changeset evellyin:2
DO $$ BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'order_status') THEN
        CREATE TYPE order_status AS ENUM ('DELIVERED', 'IN_PROGRESS', 'CANCELED');
    END IF;
END $$;

-- changeset evellyin:3
DO $$ BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'payment_method_type') THEN
        CREATE TYPE payment_method_type AS ENUM ('CREDIT', 'DEBIT', 'PIX', 'PAYPAL', 'MONEY');
    END IF;
END $$;

-- changeset evellyin:4
CREATE TABLE IF NOT EXISTS customers (
    id UUID PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- changeset evellyin:5
CREATE TABLE IF NOT EXISTS restaurants (
    id UUID PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    cnpj VARCHAR(255) UNIQUE NOT NULL
);

-- changeset evellyin:6
CREATE TABLE IF NOT EXISTS orders (
    id UUID PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    customer_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    order_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status order_status NOT NULL,
    CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT fk_order_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

-- changeset evellyin:7
CREATE TABLE IF NOT EXISTS order_items (
    id UUID PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    order_id UUID NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_order_items_order FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- changeset evellyin:8
CREATE TABLE IF NOT EXISTS payments (
    id UUID PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    order_id UUID NOT NULL,
    payment_date DATE NOT NULL,
    payment_method payment_method_type NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_payment_order FOREIGN KEY (order_id) REFERENCES orders(id)
);