```
given: 小弟只有一个停车场, 有空位
when: 要小弟停一辆车
then: 小弟停车成功，拿到票据

given：小弟只有一个停车场， 没有空位
when：要小弟停一辆车
then： 小弟停车失败

given：小弟有一个停车场，两个空位
when: 要小弟连续停两辆车
then: 小弟两辆车都能停车成功，拿到不一样的票据。

given：小弟有一个停车场，一个空位
when: 要小弟连续停两辆车
then: 小弟第一辆车停车成功，拿到票据。第二辆车停车失败

given: 小弟只有一个停车场，我的车停在里面
when：我拿着该车对应的票据找小弟来取车
then： 小弟取车成功

given: 小弟只有一个停车场，我的车停在里面
when：我拿着非法的票据找小弟来取车
then： 小弟取车失败

given: 小弟只有一个停车场，我的车没有停在里面
when：我拿着非法的票据找小弟来取车
then： 小弟取车失败

given: 小弟只有一个停车场，我的车停在里面，我拿着该车的票据将车取出
when：我拿着取过的票据取车
then： 小弟取车失败

```

```
given: 小弟有两个停车场，两个都有空位
when：要小弟停一辆车
then: 小弟将车停在第一个停车场，拿到票据

given: 小弟有两个停车场，各有一个空位
when：要小弟停两辆车
then: 小弟将第一辆车停在第一个停车场，拿到票据，第二辆车停在第二个停车场，拿到票据

given: 小弟有两个停车场，只有一个有空位
when：要小弟停一辆车
then: 小弟停车成功，拿到票据

given: 小弟有两个停车场，两个都没有空位
when：要小弟停一辆车
then: 小弟停车失败

given：小弟有两个停车场，我的车停在里面
when: 我拿着该车对应的票据找小弟取车
then：小弟取车成功

given：小弟有两个停车场，我的车没有停在里面
when: 我拿着无效的票据找小弟取车
then：小弟取车失败

given：小弟有两个停车场，我的车停在里面
when: 我拿着该车对应的票据找小弟连续取车两次
then：小弟第一次取车成功，第二次取车失败
```

聪明小弟
```
given: 两个停车场，第一个有一个空余车位，第二个有两个空位车位
when：让聪明的小弟帮忙停车
then: 聪明小弟将车停在第二个停车场，并拿到票据

given: 两个停车场，第一个有两个个空余车位，第二个有一个空位车位
when：让聪明的小弟帮忙停车
then: 聪明小弟将车停在第一个停车场，并拿到票据

given: 两个停车场，各有一个空位
when: 让聪明小弟帮忙停车
then: 聪明小弟将车停在第一个停车场，并拿到票据

given：聪明小弟有两个停车场，我的车停在里面
when: 我拿着该车对应的票据找小弟取车
then：小弟取车成功

given：聪明小弟有两个停车场，我的车没有停在里面
when: 我拿着无效的票据找小弟取车
then：小弟取车失败

given：聪明小弟有两个停车场，我的车停在里面
when: 我拿着该车对应的票据找小弟连续取车两次
then：小弟第一次取车成功，第二次取车失败

```
