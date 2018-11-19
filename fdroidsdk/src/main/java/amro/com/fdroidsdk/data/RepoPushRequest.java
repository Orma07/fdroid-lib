package amro.com.fdroidsdk.data;


import android.support.annotation.Nullable;

/**
 * Represents action requests embedded in the index XML received from a repo.
 * When {@link #versionCode} is {@code null}, that means that the
 * {@code versionCode} was not specified by the server, and F-Droid should
 * install the best available version.
 */
public class RepoPushRequest {
    public static final String TAG = "RepoPushRequest";

    public static final String INSTALL = "install";
    public static final String UNINSTALL = "uninstall";

    public final String request;
    public final String packageName;
    @Nullable
    public final Integer versionCode;

    public RepoPushRequest(String request, String packageName, @Nullable String versionCode) {
        this.request = request;
        this.packageName = packageName;

        Integer i;
        try {
            i = Integer.parseInt(versionCode);
        } catch (NumberFormatException e) {
            i = null;
        }
        this.versionCode = i;
    }

    @Override
    public String toString() {
        return request + " " + packageName + " " + versionCode;
    }
}
