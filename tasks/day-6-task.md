停车经理、经理管小弟、经理还有自己的停车场，小弟管理的停车场是互斥的
**停车**

given:一个停车经理，没有停车小弟，经理有一个停车场，有空位
when:让停车经理停车
then:停车经理停车成功，拿到票据

given:一个停车经理，管理2个停车小弟，每个小弟有一个停车场，每个停车场都有空位
when:让停车经理停车
then:停车经理使唤停车小弟停车成功，拿到票据

given:一个停车经理，管理2个停车小弟，每个小弟有一个停车场，只有一个小弟的停车场有空位
when:让停车经理停车
then:停车经理使唤停车小弟停车成功，拿到票据

given:一个停车经理，管理2个停车小弟，每个小弟有一个停车场，每个停车场都没有空位，经理有一个停车场，有空位
when:让停车经理停车
then:停车经理停车成功，拿到票据

given:一个停车经理，管理1个停车小弟，小弟有一个停车场，经理有一个停车场，各有一个空位
when:让停车经理连续停2辆车
then:第一辆车停车经理使唤小弟停车成功，拿到票据，第二辆车停车经理停车成功，拿到票据

given:一个停车经理，管理2个停车小弟，每个小弟有一个停车场，每个停车场都没有空位，经理有一个停车场，没有空位
when:让停车经理停车
then:停车经理停车失败


**取车**
经理自己可以取车，小弟取自己停车场里的车