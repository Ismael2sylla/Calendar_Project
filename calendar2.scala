import scala.io.StdIn.readLine
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable.ListBuffer
import scala.util.{Try, Success, Failure}

// 1. Classe Calendar qui gère les événements
class Calendar {
  private var events: ListBuffer[String] = ListBuffer()

  // Ajouter un événement
  def addEvent(eventName: String, eventDate: String, eventLocation: String): Either[String, String] = {
    Try {
      val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
      val parsedDate: LocalDateTime = LocalDateTime.parse(eventDate, formatter)
      val newId = if (events.nonEmpty) events.length + 1 else 1
      val newEvent = s"Id = $newId, event name is: $eventName, event date is: $eventDate, location is: $eventLocation"
      events += newEvent
      s"A new event has been added! ID: $newId"
    } match {
      case Success(message) => Right(message)
      case Failure(exception) => Left(s"Error: ${exception.getMessage}")
    }
  }

  // Afficher tous les événements
  def showEvents(): Either[String, ListBuffer[String]] = {
    if (events.isEmpty) Left("No events found.")
    else Right(events)
  }

  // Modifier un événement
  def modifyEvent(eventId: Int, newEventName: String, newEventDate: String, newEventLocation: String): Either[String, String] = {
    Try {
      val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
      val parsedDate: LocalDateTime = LocalDateTime.parse(newEventDate, formatter)
      val updatedEvent = s"Id = $eventId, event name is: $newEventName, event date is: $newEventDate, location is: $newEventLocation"
      
      events.indexWhere(event => event.contains(s"Id = $eventId")) match {
        case -1 => throw new Exception("Event not found.")
        case idx => events.update(idx, updatedEvent)
      }

      s"Event ID: $eventId has been updated."
    } match {
      case Success(message) => Right(message)
      case Failure(exception) => Left(s"Error: ${exception.getMessage}")
    }
  }

  // Supprimer un événement
  def deleteEvent(eventId: Int): Either[String, String] = {
    Try {
      val index = events.indexWhere(event => event.contains(s"Id = $eventId"))
      if (index == -1) throw new Exception("Event not found.")
      events.remove(index)
      s"Event ID: $eventId has been deleted."
    } match {
      case Success(message) => Right(message)
      case Failure(exception) => Left(s"Error: ${exception.getMessage}")
    }
  }
}

// 2. Objet Singleton pour accéder à l'instance du calendrier
object CalendarSingleton {
  private val calendar = new Calendar

  def getInstance: Calendar = calendar
}

// 3. Interface en ligne de commande (CLI) modulée
object CalendarCLI {
  def start(): Unit = {
    val calendar = CalendarSingleton.getInstance

    println("Welcome to the Calendar app")
    println("Please enter your name:")
    val user = readLine()

    var continue = true

    while (continue) {
      println(s"******** Welcome $user, please choose an option ********")
      println("1/ Add a new event to my calendar")
      println("2/ Display all recorded events")
      println("3/ Modify an event")
      println("4/ Delete an event")
      println("5/ Quit")

      readLine() match {
        case "1" =>
          println("Enter event name:")
          val eventName = readLine()
          println("Enter event date (format: yyyy-MM-dd HH:mm):")
          val eventDate = readLine()
          println("Enter event location:")
          val eventLocation = readLine()

          calendar.addEvent(eventName, eventDate, eventLocation) match {
            case Right(message) => println(message)
            case Left(error) => println(error)
          }

        case "2" =>
          calendar.showEvents() match {
            case Right(events) =>
              if (events.isEmpty) println("No events found.")
              else events.foreach(println)
            case Left(error) => println(error)
          }

        case "3" =>
          println("Enter event ID to modify:")
          val eventId = readLine().toInt
          println("Enter new event name:")
          val newEventName = readLine()
          println("Enter new event date (format: yyyy-MM-dd HH:mm):")
          val newEventDate = readLine()
          println("Enter new event location:")
          val newEventLocation = readLine()

          calendar.modifyEvent(eventId, newEventName, newEventDate, newEventLocation) match {
            case Right(message) => println(message)
            case Left(error) => println(error)
          }

        case "4" =>
          println("Enter event ID to delete:")
          val eventId = readLine().toInt
          calendar.deleteEvent(eventId) match {
            case Right(message) => println(message)
            case Left(error) => println(error)
          }

        case "5" =>
          println("Goodbye!")
          continue = false

        case _ => println("Invalid option, please try again.")
      }
    }
  }
}

// 4. Point d'entrée de l'application
object Main extends App {
  CalendarCLI.start()
}
