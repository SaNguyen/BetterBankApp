create table transaction (
      id bigint not null,
      account_number integer,
      amount double precision,
      currency varchar(255),
      date datetime,
      merchant_logo varchar(255),
      merchant_name varchar(255),
      type varchar(255),
      primary key (id)
) engine=InnoDB;

INSERT INTO transaction
(
    id,
    account_number,
    amount,
    currency,
    date,
    merchant_logo,
    merchant_name,
    type)
VALUES
    (
        1,
        '111',
        100.0,
        'USD',
        now(),
        'images/acme-logo.png',
        'acme',
        'credit'
    );

