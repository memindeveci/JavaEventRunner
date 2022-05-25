package dev.meh.Events;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;


public class EventManager {

    private static EventManager instance = null;

    private final Queue<Listener> listeners = new LinkedList<>();
    private final Queue<EventHandler> handlers = new LinkedList<>();

    private EventManager() {

    }

    public static EventManager getInstance() {
        if (instance == null)
            instance = new EventManager();
        return instance;
    }


    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    public void registerHandler(EventHandler handler)
    {
        handlers.add(handler);
    }

    // As of NOW, I guess it is blocking.
    // TODO: 1) Make this non-blocking.
    public void pollEvents()
    {
        for (EventHandler handler: handlers)
        {
            if (handler.getCondition())
            {
                callBaseEvent(handler); // the event handler will already register himself, so no need to create a new baseEvent i guess?
            }
        }
    }

    private void callBaseEvent(EventHandler cls) {
        for (Listener listener: listeners) {
            for (Method m : listener.getClass().getMethods()) {
                if (m.isAnnotationPresent(EventListener.class)) {
                    Class<?>[] params = m.getParameterTypes();
                    if (params.length == 1) {
                        if (params[0].isInstance(cls)) { // if there is a PlayerChatEvent argument in the method
                            try {
                                m.invoke(listener, cls);
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
