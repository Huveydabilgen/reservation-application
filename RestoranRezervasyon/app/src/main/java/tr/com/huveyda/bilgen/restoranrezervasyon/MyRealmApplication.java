package tr.com.huveyda.bilgen.restoranrezervasyon;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyRealmApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration=new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}