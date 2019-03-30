停车
given: 一个有空位的停车场
when: 去停车
then: 停车成功，拿到停车票据

given: 一个没有空位的停车场
when: 去停车
then: 停车失败

given：一个有一个停车位的停车场
when: 连续停两辆车
then: 第一辆车停车成功，拿到票据。第二辆车停车失败

given：一个有两个停车位的停车场
when: 连续停两辆车
then: 两辆车都能停车成功，拿到不一样的票据。

取车
given: 一个停车场，里面有车辆A
when: 我拿着该车的停车票据要取车
then: 取车成功

given: 一个停车场，里面没有我的车
when: 我去取车
then: 取车失败

given: 一个停车场，里面有车辆A,
when: 拿着非车A的票据去取车
then: 取车失败

