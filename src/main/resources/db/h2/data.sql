INSERT INTO wallets
  (id, account_num, balance)
VALUES
  (1, '0000', 2000),
  (2, '0001', 1000),
  (3, '0002', 1500),
  (4, '0003', 3000),
  (5, '0004', 4000);

INSERT INTO customers
  (id, name, phone, address, wallet_id)
VALUES
  (1, 'Tom', '0123456780', 'Cat House', 1),
  (2, 'Jerry', '0123456781', 'Mouse House', 2);

INSERT INTO staves
  (id, name, phone, wallet_id)
VALUES
  (1, 'Bob', '0123456783', 3),
  (2, 'Oggy', '0123456784', 4),
  (3, 'Jax', '0123456785', 5);

INSERT INTO services
  (id, name, fee)
VALUES
  (1, 'Tire Repair', 200),
  (2, 'Brake Repair', 100),
  (3, 'Oil Change', 50),
  (4, 'Check Engine Light', 100);
