import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.basic.DatabasePublisher
import slick.jdbc.SQLiteProfile.api._

@main def hello(): Unit =
    // First declare our Scala object
  final case class Coffee(name: String, price: Double)

  // Next define how Slick maps from a database table to Scala objects
  class Coffees(tag: Tag) extends Table[Coffee](tag, "COFFEES") {
    def name  = column[String]("NAME")
    def price = column[Double]("PRICE")
    def * = (name, price).mapTo[Coffee]
  }

  // The `TableQuery` object gives us access to Slick's rich query API
  val coffees = TableQuery[Coffees]

  // Inserting is done by appending to our query object
  // as if it were a regular Scala collection
  // SQL: insert into COFFEES (NAME, PRICE) values ('Latte', 2.50)
  coffees += Coffee("Latte", 2.50)

  // Fetching data is also done using the query object
  // SQL: select NAME from COFFEES
  coffees.map(_.name).result.map(x => x.foreach(y => println(y)))

  // More complex queries can be chained together
  // SQL: select NAME, PRICE from COFFEES where PRICE < 10.0 order by NAME
  coffees.filter(_.price < 10.0).sortBy(_.name)

  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"
