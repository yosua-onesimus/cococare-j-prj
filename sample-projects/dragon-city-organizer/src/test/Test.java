package test;

import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import model.bo.DragonHabitatOptimizationBo;
import model.mdl.DragonCityOrganizerModule;

public class Test {

    public static void main(String[] args) {
        CCHibernate hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(CCFile.getFileSystConfFile("dtbs.conf"));
        DragonCityOrganizerModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();

        new DragonHabitatOptimizationBo().execute();
    }
}