package model.obj.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.jasperreports.CCReport;
import cococare.common.jasperreports.CCReportEnumInterface;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class StkReport extends CCReport {

//<editor-fold defaultstate="collapsed" desc=" enum Report ">
    public enum Report implements CCReportEnumInterface {

        ITEM_STOCK("Item Stock", "StkItemStock.jasper", "RptHeader.jasper");
        private String string;
        private String jasperFile;
        private String[] reqJasperFiles;

        private Report(String string, String jasperFile, String... reqJasperFiles) {
            this.string = string;
            this.jasperFile = jasperFile;
            this.reqJasperFiles = reqJasperFiles;
        }

        @Override
        public String toString() {
            return string;
        }

        @Override
        public String getJasperFile() {
            return jasperFile;
        }

        @Override
        public String[] getReqJasperFiles() {
            return reqJasperFiles;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public Class<? extends CCReportEnumInterface> getReportEnum() {
        return Report.class;
    }
//</editor-fold>
}