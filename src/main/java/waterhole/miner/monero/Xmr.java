package waterhole.miner.monero;

import android.util.Log;
import java.io.ObjectStreamException;

public final class Xmr {

    static {
        try {
            System.loadLibrary("monero-miner");
        } catch (Exception e) {
            Log.e("xmr", e.getMessage());
        }
    }

    native void startMine(int thread, int cpuUses, MineCallback callback);

    private Xmr() {
    }

    public static Xmr instance() {
        return Holder.instance;
    }

    private static class Holder {
        private static Xmr instance = new Xmr();
    }

    private Object readResolve() throws ObjectStreamException {
        return instance();
    }
}
