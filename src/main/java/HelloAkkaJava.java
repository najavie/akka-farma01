import actors.CowActor;
import actors.Messages;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.BroadcastPool;
import akka.routing.RoundRobinPool;

public class HelloAkkaJava {

    public static void main(String[] args) {
        // Create the 'helloakka' actor system
        final ActorSystem farma = ActorSystem.create("farma");
        final ActorRef krowa = farma.actorOf(Props.create(CowActor.class), "krowa");
        krowa.tell(Messages.EAT,ActorRef.noSender());
        final ActorRef krowy = farma.actorOf(new RoundRobinPool(3).props(Props.create(CowActor.class)));
        krowy.tell(Messages.EAT, ActorRef.noSender());
        final ActorRef krowyBroadcast = farma.actorOf(new BroadcastPool(3).props(Props.create(CowActor.class)),"Krowy-broadcast");
        krowyBroadcast.tell(Messages.EAT, ActorRef.noSender());
        farma.shutdown();

    }

}
