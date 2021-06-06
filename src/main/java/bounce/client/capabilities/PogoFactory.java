package bounce.client.capabilities;

import java.util.concurrent.Callable;

public class PogoFactory implements Callable<IPogoCapability> {
    @Override
    public IPogoCapability call() throws Exception {
        IPogoCapability cap = new PogoCapability();
        return cap;
    }
}
