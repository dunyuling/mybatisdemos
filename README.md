Main
interface-> XInterface
MapperProxy.invoke implements InvokeHandler
    在invoke方法中打印出(接口全名称与方法名)
SqlSession->getMapper()(XInterface)
    在getMapper()创建代理实例并做强转
