package recivers

// retrun list or one entity of specific data from (website db kafka socet)
trait Reciver[A] {

  def getData(): A

  def getDataList(): List[A]
}
