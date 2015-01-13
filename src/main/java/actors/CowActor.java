package actors;

import akka.actor.UntypedActor;

/**
 * Created by krzysztof on 1/13/15.
 */
public class CowActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof Messages) {
            switch ((Messages) message) {
                case EAT:
                    System.out.println("Krowa: "+getSelf().path()+" wątek: "+Thread.currentThread().getId()+" omnomonmonmon");
                    Thread.sleep(1000);
                    break;
                default:
                    unhandled("This message is unhandled");
            }
        } else {
            unhandled("Unknown type of message");
        }
    }
}
