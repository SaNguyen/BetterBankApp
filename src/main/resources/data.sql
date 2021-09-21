INSERT INTO `BetterBank`.`transaction`
(
    `account_number`,
    `amount`,
    `currency`,
    `date`,
    `merchant_logo`,
    `merchant_name`,
    `type`)
VALUES
    (
        '111',
        56,
        'USD',
        now(),
        null,
        'XYZ',
        'debit'

    );

INSERT INTO `BetterBank`.`transaction`
(
    `account_number`,
    `amount`,
    `currency`,
    `date`,
    `merchant_logo`,
    `merchant_name`,
    `type`)
VALUES
    (
        '111',
        100,
        'USD',
        now(),
        null,
        'XYZ',
        'credit'

    )