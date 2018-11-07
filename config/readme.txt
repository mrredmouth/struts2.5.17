1、三种action开发方式：
	方法有execute()方法；继承ActionSupport；实现Action接口。
	
2、jsp和action的数据传递：
	1）struts的：action设置全局变量，如果变量是对象的封装，有g/s，jsp中用“对象.属性”作为name。
	2）原生的：通过servlet的request，session，context传递。
	
3、动态代理模式
	代理对象不写死，根据传进来的对象，利用反射去调用各自对象的方法。
	ActionProxy，代理对象，拥有代理的方法和对象本身的方法。
	实现InvocationHandler接口，该接口是反射中重要的接口，可以动态调用对标对象中的方法。