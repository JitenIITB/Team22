TYPE=VIEW
query=select `mydb`.`priceclose`.`idPriceClose` AS `idPriceClose`,`mydb`.`priceclose`.`PriceClose` AS `PriceClose`,`mydb`.`ticker`.`tickerName` AS `tickerName`,`mydb`.`marketdays`.`marketdays` AS `marketdays` from `mydb`.`priceclose` join `mydb`.`ticker` join `mydb`.`marketdays` where ((`mydb`.`priceclose`.`MarketDays_idMarketDays` = `mydb`.`marketdays`.`idMarketDays`) and (`mydb`.`ticker`.`idticker` = `mydb`.`priceclose`.`ticker_idticker`))
md5=a463c04a4ec740dc95459e7ba7f90212
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2016-08-30 12:40:09
create-version=1
source=select idPriceClose,PriceClose,tickerName,marketdays from priceclose, ticker, marketdays\nwhere priceclose.MarketDays_idMarketDays = marketdays.idMarketDays AND ticker.idticker = priceclose.ticker_idticker
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `mydb`.`priceclose`.`idPriceClose` AS `idPriceClose`,`mydb`.`priceclose`.`PriceClose` AS `PriceClose`,`mydb`.`ticker`.`tickerName` AS `tickerName`,`mydb`.`marketdays`.`marketdays` AS `marketdays` from `mydb`.`priceclose` join `mydb`.`ticker` join `mydb`.`marketdays` where ((`mydb`.`priceclose`.`MarketDays_idMarketDays` = `mydb`.`marketdays`.`idMarketDays`) and (`mydb`.`ticker`.`idticker` = `mydb`.`priceclose`.`ticker_idticker`))
