package senders

// send or save list of data
trait Sender[A] {
  def send(obj: A)

  def sendList(list: List[A])
}
