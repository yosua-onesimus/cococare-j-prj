package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.*;
import cococare.common.CCHighcharts.ChartType;
import cococare.common.CCHighcharts.Serial;
import cococare.common.CCHighcharts.Stacking;
import cococare.common.CCHighcharts.Type;
import cococare.common.*;
import cococare.common.barbecue.CCBarcode;
import cococare.common.comm.CCComm;
import cococare.common.ftp.CCFtp;
import cococare.common.mail.CCMail;
import cococare.common.mail.CCMail.MailServer;
import cococare.common.pdf.CCPdf;
import cococare.common.quartz.CCJob;
import cococare.common.quartz.CCQuartz;
import cococare.database.*;
import cococare.datafile.*;
import cococare.datafile.jxl.CCExcel;
import com.lowagie.text.PageSize;
import java.io.File;
import java.sql.Time;
import java.util.*;
import model.obj.lib.LibAuthor;
import model.obj.lib.LibBook;
import model.obj.lib.LibEnum.Gender;
import model.obj.lib.LibMember;
import model.obj.lib.LibPublisher;
import net.sourceforge.barbecue.Barcode;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.w3c.dom.Node;
//</editor-fold>

public class NoX_SimpleAndCleanCode {

//<editor-fold defaultstate="collapsed" desc=" BangunDatar ">
    private static class BangunDatar {

        private String luasPersegi = "L=s*s";
        private String luasSegitiga = "L=a*t/2";
        private String luasTrapesium = "L=(s1+s2)*t/2";
        private double s = 4;
        private double a = 8;
        private double t = 6;
        private double s1 = 4;
        private double s2 = 8;
        private double L;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" SimpleJob ">
    public static class SimpleJob extends CCJob {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            println(
                    CCFormat.getString(new Date(), CCFinal.FORMAT_DATE_TIME)
                    + " " + getValue(jobExecutionContext, "member.firstName")
                    + " " + getValue(jobExecutionContext, "member.lastName"));
        }
    }
//</editor-fold>
    //
//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static String _ = " -> ";
    private static String string1 = "yOSUA  oNESIMUS  sUHERU";
    private static String string2 = "SEQ";
    private static String phoneNumber = "085640038118";
    private static String email = "arrow_405@yahoo.com";
    private static String ip = "127.0.0.1";
    private static Double double1 = 1234567.89D;
    private static Float float1 = 0.1234F;
    private static Date date1 = CCFormat.getDate("17/03/2012", CCFinal.FORMAT_DATE);
    private static Time time1 = CCFormat.getTime("12:34:56", CCFinal.FORMAT_TIME);
    private static BangunDatar bangunDatar = new BangunDatar();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleClassManipulation ">
    public static void sampleClassManipulation() {
        Object author = CCClass.newObject(LibAuthor.class);
        CCClass.setValue(author, "code", "A001");
        CCClass.setValue(author, "name", "Yosua Onesimus");
        println("Author: Code:" + CCClass.getValue(author, "code") + ";Name:" + CCClass.getValue(author, "name") + ";");
        ______________________________________________________________________();
        Object authorAlsoPublisher = CCClass.newObject(LibPublisher.class);
        CCClass.copy(author, authorAlsoPublisher);
        Object book = CCClass.newObject(LibBook.class);
        CCClass.invoke(book, "setCode(?)", "B001");
        CCClass.invoke(book, "setTitle(?)", "Judul Buku B001");
        CCClass.invoke(book, "getBookType().setCode(?)", "BT001");
        CCClass.invoke(book, "getBookType().setName(?)", "Jenis Buku BT001");
        CCClass.invoke(book, "setAuthor(?)", author);
        CCClass.invoke(book, "getAuthor().setName(?)", "Yosua The Author");
        CCClass.invoke(book, "setPublisher(?)", authorAlsoPublisher);
        println(CCClass.getLabel(LibBook.class) + ": " + CCClass.getAssociativeArray(book, null));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleFormat ">
//<editor-fold defaultstate="collapsed" desc=" sampleStringOperation ">
    public static void sampleFormat_sampleStringOperation() {
        println(string1 + _ + (string1 = CCFormat.trimAll(string1)));
        println(string1 + _ + CCFormat.toSentenceCase(string1));
        println(string1 + _ + CCFormat.toTitleCase(string1));
        ______________________________________________________________________();
        println(string1 + _ + CCFormat.pack(string1, "_", 2 * string1.length()));
        println(string1 + _ + CCFormat.pack(string1, "_", -2 * string1.length()));
        ______________________________________________________________________();
        println(string2 + _ + (string2 += CCFormat.sequence(1, 3)));
        println(string2 + _ + (string2 = CCFormat.nextSequence(string2)));
        println(string2 + _ + CCFormat.nextSequence(string2));
        ______________________________________________________________________();
        println(string1 + _ + CCFormat.maxLength(string1, string1.length() / 2));
        println(string1 + _ + CCFormat.maxLength(string1, string1.length() / -2));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleNumberFormat ">
    public static void sampleFormat_sampleNumberFormat() {
        println(double1 + _ + CCFormat.formatCurrency(double1));
        println(double1 + _ + CCFormat.formatInteger(double1));
        println(double1 + _ + CCFormat.formatNumber(double1));
        println(double1 + _ + CCFormat.formatPercent(double1));
        println(double1 + _ + CCFormat.formatDecimal(double1));
        println(double1 + _ + CCFormat.formatNumeric(double1));
        ______________________________________________________________________();
        println(float1 + _ + CCFormat.formatCurrency(float1));
        println(float1 + _ + CCFormat.formatInteger(float1));
        println(float1 + _ + CCFormat.formatNumber(float1));
        println(float1 + _ + CCFormat.formatPercent(float1));
        println(float1 + _ + CCFormat.formatDecimal(float1));
        println(float1 + _ + CCFormat.formatNumeric(float1));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleStringConversion ">
    public static void sampleFormat_sampleStringConversion() {
        println(double1 + _ + CCFormat.getString(double1));
        println(float1 + _ + CCFormat.getString(float1));
        println(date1 + _ + CCFormat.getString(date1));
        println(time1 + _ + CCFormat.getString(time1));
        ______________________________________________________________________();
        println(double1 + _ + CCFormat.getString4View(double1));
        println(float1 + _ + CCFormat.getString4View(float1));
        println(date1 + _ + CCFormat.getString4View(date1));
        println(time1 + _ + CCFormat.getString4View(time1));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleDateTimeConversion ">
    public static void sampleFormat_sampleDateTimeConversion() {
        println(date1 + _ + CCFormat.getString(date1, CCFinal.FORMAT_DATE));
        println(date1 + _ + CCFormat.getDayOfWeek(date1) + _ + CCFormat.getDayName(CCFormat.getDayOfWeek(date1)));
        println(date1 + _ + CCFormat.getDay(date1));
        println(date1 + _ + CCFormat.getMonth(date1) + _ + CCFormat.getMonthName(CCFormat.getMonth(date1)));
        println(date1 + _ + CCFormat.getYear(date1));
        ______________________________________________________________________();
        println(date1 + _ + CCFormat.getMinDateTime(date1) + _ + CCFormat.getMaxDateTime(date1));
        println(date1 + _ + CCFormat.getMinMonthDateTime(date1) + _ + CCFormat.getMaxMonthDateTime(date1));
        ______________________________________________________________________();
        println(date1 + _ + CCFormat.getPrevMonth(date1) + _ + CCFormat.getNextMonth(date1));
        println(date1 + _ + CCFormat.getPrevYear(date1) + _ + CCFormat.getNextYear(date1));
        ______________________________________________________________________();
        println(time1 + _ + CCFormat.getString(time1, CCFinal.FORMAT_TIME));
        ______________________________________________________________________();
        println(date1 + _ + CCFormat.copyTime(date1, time1));
        println(date1 + _ + CCFormat.fillTime(date1));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleTerbilang ">
    public static void sampleFormat_sampleTerbilang() {
        for (double d = double1 - 3; d < double1 + 3; d++) {
            println(d + _ + CCFormat.terbilang(d));
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleSpellOut ">
    public static void sampleFormat_sampleSpellOut() {
        for (double d = double1 - 3; d < double1 + 3; d++) {
            println(d + _ + CCFormat.spellOut(d));
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleRomanNumerals ">
    public static void sampleFormat_sampleRomanNumerals() {
        for (int i = 97; i < 103; i++) {
            println(i + _ + CCFormat.roman(i));
        }
    }
//</editor-fold>
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleHighcharts ">
    public static void sampleHighcharts_sampleBasicLine() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getTitle().setText("Monthly Average Temperature");
        highcharts.getSubtitle().setText("Source: WorldClimate.com");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        highcharts.getyAxis().getTitle().setText("Temperature (°C)");
        highcharts.getTooltip().setValueSuffix("°C");
        Serial serial = highcharts.newSerial();
        serial.setName("Tokyo");
        serial.getData().addAll(Arrays.asList(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("New York");
        serial.getData().addAll(Arrays.asList(-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Berlin");
        serial.getData().addAll(Arrays.asList(-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("London");
        serial.getData().addAll(Arrays.asList(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleSplineWithInvertedAxes() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.spline);
        highcharts.getChart().setInverted(true);
        highcharts.getTitle().setText("Atmosphere Temperature by Altitude");
        highcharts.getSubtitle().setText("According to the Standard Atmosphere Model");
        highcharts.getxAxis().getTitle().setText("Altitude");
        highcharts.getxAxis().getLabels().setFormatter("this.value + 'km'");
        highcharts.getxAxis().setReversed(false);
        highcharts.getyAxis().getTitle().setText("Temperature");
        highcharts.getyAxis().getLabels().setFormatter("this.value + '°C'");
        highcharts.getLegend().setEnabled(false);
        highcharts.getTooltip().setHeaderFormat("<b>{series.name}</b><br/>");
        highcharts.getTooltip().setPointFormat("{point.x} km: {point.y}°C");
        Serial serial = highcharts.newSerial();
        serial.setName("Temperature");
        serial.getData().add(highcharts.newList(0, 15));
        serial.getData().add(highcharts.newList(10, -50));
        serial.getData().add(highcharts.newList(20, -56.5));
        serial.getData().add(highcharts.newList(30, -46.5));
        serial.getData().add(highcharts.newList(40, -22.1));
        serial.getData().add(highcharts.newList(50, -2.5));
        serial.getData().add(highcharts.newList(60, -27.7));
        serial.getData().add(highcharts.newList(70, -55.7));
        serial.getData().add(highcharts.newList(80, -76.5));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleTimeDataWithIrregularIntervals() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.spline);
        highcharts.getTitle().setText("Snow depth at Vikjafjellet, Norway");
        highcharts.getSubtitle().setText("Irregular time data in Highcharts JS");
        highcharts.getxAxis().getTitle().setText("Date");
        highcharts.getxAxis().getLabels().setFormatter("new Date(this.value).toDateString().substring(4, 7)");
        highcharts.getxAxis().setType(Type.datetime);
        highcharts.getyAxis().getTitle().setText("Snow depth (m)");
        highcharts.getTooltip().setHeaderFormat("<b>{series.name}</b><br>");
        highcharts.getTooltip().setPointFormat("{point.x:%e. %b}: {point.y:.2f} m");
        Serial serial = highcharts.newSerial();
        serial.setName("Winter 2012-2013");
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 9, 21), 0));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 10, 4), 0.28));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 10, 9), 0.25));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 10, 27), 0.2));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 2), 0.28));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 26), 0.28));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 29), 0.47));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 11), 0.79));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 26), 0.72));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 3), 1.02));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 11), 1.12));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 25), 1.2));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 2, 11), 1.18));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 11), 1.19));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 1), 1.85));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 5), 2.22));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 19), 1.15));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 3), 0));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Winter 2013-2014");
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 9, 29), 0));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 10, 9), 0.4));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 1), 0.25));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 1), 1.66));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 10), 1.8));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 19), 1.76));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 2, 25), 2.62));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 19), 2.41));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 30), 2.05));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 14), 1.7));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 24), 1.1));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 10), 0));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Winter 2014-2015");
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 10, 25), 0));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 6), 0.25));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 20), 1.41));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1970, 11, 25), 1.64));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 4), 1.6));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 17), 2.55));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 0, 24), 2.62));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 4), 2.5));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 1, 14), 2.42));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 2, 6), 2.74));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 2, 14), 2.62));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 2, 24), 2.6));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 2), 2.81));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 12), 2.63));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 3, 28), 2.77));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 5), 2.68));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 10), 2.56));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 15), 2.39));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 4, 20), 2.3));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 5), 2));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 10), 1.85));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 15), 1.49));
        serial.getData().add(highcharts.newList(CCFormat.getDate(1971, 5, 23), 1.08));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleBasicArea() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.area);
        highcharts.getTitle().setText("US and USSR nuclear stockpiles");
        highcharts.getSubtitle().setText("Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">thebulletin.metapress.com</a>");
        highcharts.getxAxis().getLabels().setFormatter("this.value");
        highcharts.getyAxis().getTitle().setText("Nuclear weapon states");
        highcharts.getyAxis().getLabels().setFormatter("this.value / 1000 + 'k'");
        highcharts.getTooltip().setPointFormat("{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}");
        Serial serial = highcharts.newSerial();
        serial.setName("USA");
        serial.getData().addAll(Arrays.asList(
                null, null, null, null, null, 6, 11, 32, 110, 235, 369, 640,
                1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126,
                27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662,
                26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
                24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586,
                22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950,
                10871, 10824, 10577, 10527, 10475, 10421, 10358, 10295, 10104));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("USSR/Russia");
        serial.getData().addAll(Arrays.asList(
                null, null, null, null, null, null, null, null, null, null,
                5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322,
                4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478,
                15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049,
                33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000,
                35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
                21000, 20000, 19000, 18000, 18000, 17000, 16000));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleStackedArea() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.area);
        highcharts.getTitle().setText("Historic and Estimated Worldwide Population Growth by Region");
        highcharts.getSubtitle().setText("Source: Wikipedia.org");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList("1750", "1800", "1850", "1900", "1950", "1999", "2050"));
        highcharts.getyAxis().getTitle().setText("Billions");
        highcharts.getyAxis().getLabels().setFormatter("this.value / 1000");
        highcharts.getTooltip().setValueSuffix(" millions");
        highcharts.getTooltip().setShared(true);
        highcharts.getPlotOptions().getSeries().setStacking(Stacking.normal);
        Serial serial = highcharts.newSerial();
        serial.setName("Asia");
        serial.getData().addAll(Arrays.asList(502, 635, 809, 947, 1402, 3634, 5268));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Africa");
        serial.getData().addAll(Arrays.asList(106, 107, 111, 133, 221, 767, 1766));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Europe");
        serial.getData().addAll(Arrays.asList(163, 203, 276, 408, 547, 729, 628));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("America");
        serial.getData().addAll(Arrays.asList(18, 31, 54, 156, 339, 818, 1201));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Oceania");
        serial.getData().addAll(Arrays.asList(2, 2, 2, 6, 13, 30, 46));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleBasicBar() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.bar);
        highcharts.getTitle().setText("Historic World Population by Region");
        highcharts.getSubtitle().setText("Source: <a href=\"https://en.wikipedia.org/wiki/World_population\">Wikipedia.org</a>");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList("Africa", "America", "Asia", "Europe", "Oceania"));
        highcharts.getyAxis().getTitle().setText("Population (millions)");
        highcharts.getTooltip().setValueSuffix(" millions");
        Serial serial = highcharts.newSerial();
        serial.setName("Year 1800");
        serial.getData().addAll(Arrays.asList(107, 31, 635, 203, 2));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Year 1900");
        serial.getData().addAll(Arrays.asList(133, 156, 947, 408, 6));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Year 2012");
        serial.getData().addAll(Arrays.asList(1052, 954, 4250, 740, 38));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleStackedBar() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.bar);
        highcharts.getTitle().setText("Stacked bar chart");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList("Apples", "Oranges", "Pears", "Grapes", "Bananas"));
        highcharts.getyAxis().getTitle().setText("Total fruit consumption");
        highcharts.getLegend().setReversed(true);
        highcharts.getPlotOptions().getSeries().setStacking(Stacking.normal);
        Serial serial = highcharts.newSerial();
        serial.setName("John");
        serial.getData().addAll(Arrays.asList(5, 3, 4, 7, 2));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Jane");
        serial.getData().addAll(Arrays.asList(2, 2, 3, 2, 1));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Joe");
        serial.getData().addAll(Arrays.asList(3, 4, 4, 2, 5));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleBasicColumn() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.column);
        highcharts.getTitle().setText("Monthly Average Rainfall");
        highcharts.getSubtitle().setText("Source: WorldClimate.com");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        highcharts.getxAxis().setCrosshair(true);
        highcharts.getyAxis().getTitle().setText("Rainfall (mm)");
        highcharts.getTooltip().setHeaderFormat("<span style=\"font-size:10px\">{point.key}</span><table>");
        highcharts.getTooltip().setPointFormat("<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td><td style=\"padding:0\"><b>{point.y:.1f} mm</b></td></tr>");
        highcharts.getTooltip().setFooterFormat("</table>");
        highcharts.getTooltip().setShared(true);
        highcharts.getTooltip().setUseHTML(true);
        Serial serial = highcharts.newSerial();
        serial.setName("Tokyo");
        serial.getData().addAll(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("New York");
        serial.getData().addAll(Arrays.asList(83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("London");
        serial.getData().addAll(Arrays.asList(48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Berlin");
        serial.getData().addAll(Arrays.asList(42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleStackedColumn() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.column);
        highcharts.getTitle().setText("Stacked column chart");
        highcharts.getxAxis().getCategories().addAll(Arrays.asList("Apples", "Oranges", "Pears", "Grapes", "Bananas"));
        highcharts.getyAxis().getTitle().setText("Total fruit consumption");
        highcharts.getyAxis().getStackLabels().setEnabled(true);
        highcharts.getTooltip().setHeaderFormat("<b>{point.x}</b><br/>");
        highcharts.getTooltip().setPointFormat("{series.name}: {point.y}<br/>Total: {point.stackTotal}");
        highcharts.getPlotOptions().getSeries().setStacking(Stacking.normal);
        Serial serial = highcharts.newSerial();
        serial.setName("John");
        serial.getData().addAll(Arrays.asList(5, 3, 4, 7, 2));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Jane");
        serial.getData().addAll(Arrays.asList(2, 2, 3, 2, 1));
        highcharts.getSeries().add(serial);
        serial = highcharts.newSerial();
        serial.setName("Joe");
        serial.getData().addAll(Arrays.asList(3, 4, 4, 2, 5));
        highcharts.getSeries().add(serial);
        println(highcharts.compile());
    }

    public static void sampleHighcharts_sampleStackedAndGroupedColumn() {
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleLogic ">
    public static void sampleLogic() {
        String strNull = null;
        String strEmpty = "";
        println("strNull" + _ + CCLogic.isNull(strNull) + "," + CCLogic.isNullOrEmpty(strNull));
        println("strEmpty" + _ + CCLogic.isNull(strEmpty) + "," + CCLogic.isNullOrEmpty(strEmpty));
        ______________________________________________________________________();
        List lstNull = null;
        List lstEmpty = new ArrayList();
        println("lstNull" + _ + CCLogic.isNull(lstNull) + "," + CCLogic.isNullOrEmpty(lstNull));
        println("lstEmpty" + _ + CCLogic.isNull(lstEmpty) + "," + CCLogic.isNullOrEmpty(lstEmpty));
        ______________________________________________________________________();
        println(strNull + "|" + strEmpty + "|" + string2 + _ + CCLogic.coalesce(strNull, strEmpty, string2));
        ______________________________________________________________________();
        println(phoneNumber + _ + CCLogic.isPhoneNumber(phoneNumber));
        println(email + _ + CCLogic.isEmail(email));
        println(ip + _ + CCLogic.isIp(ip));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleMath ">
    public static void sampleMath() {
        println("((9+8-7)*6/5)^4" + _ + CCMath.calculate("((9+8-7)*6/5)^4"));
        println("((9+x-7)*y/5)^z" + _ + CCMath.calculate("((9+x-7)*y/5)^z", "x=8;y=6;z=4;"));
        println("((9+x-7)*y/5)^z" + _ + CCMath.calculate("((9+x-7)*y/5)^z", "x=8", "y=6", "z=4"));
        println("L=s*s" + _ + "L=" + CCMath.expression("s*s", bangunDatar) + _ + "L=" + CCMath.calculate("s*s", bangunDatar));
        ______________________________________________________________________();
        println(bangunDatar.luasPersegi + _ + ((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasPersegi)).L);
        println(bangunDatar.luasSegitiga + _ + ((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasSegitiga)).L);
        println(bangunDatar.luasTrapesium + _ + ((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasTrapesium)).L);
        ______________________________________________________________________();
        println(CCMath.expression(bangunDatar.luasTrapesium, bangunDatar) + _ + CCMath.solved(bangunDatar, bangunDatar.luasTrapesium));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleBarcode ">
    public static void sampleBarcode() {
        Barcode barcode = CCBarcode.newCode128("Yosua Onesimus");
        CCBarcode.saveJPEG(barcode, new File("D:\\barcode.jpeg"));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleComm ">
    public static void sampleComm() {
        println("Paralel Ports: ");
        for (String paralelPort : CCComm.getParalelPorts()) {
            println(paralelPort);
        }
        ______________________________________________________________________();
        println("Serial Ports: ");
        for (String serialPort : CCComm.getSerialPorts()) {
            println(serialPort);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleFtp ">
    public static void sampleFtp() {
        CCFtp ftp = new CCFtp();
        ftp.connect("127.0.0.1", 21);
        ftp.login("yosuaonesimus", "06061984");

        String workingDirectory = "\\sampleFtp_workingDirectory";
        ftp.changeWorkingDirectory(workingDirectory);

        String directory = "sampleFtp_directory";
        ftp.makeDirectory(directory);
        ftp.changeWorkingDirectory(directory);

        String fileName = "sampleFtp_file.txt";
        ftp.storeFile("D:\\" + fileName);

        ftp.deleteFile(fileName);

        ftp.changeWorkingDirectory(workingDirectory);
        ftp.removeDirectory(directory);

        ftp.logout();
        ftp.disconnect();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleJasper ">
    public static void sampleJasper() {
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleMail ">
    public static void sampleMail() {
        CCMail mail = new CCMail();
        mail.setPropertyMailSmtpHost(null);
        mail.setPropertyTimeout(45000);
        mail.initSession(true);
//        mail.setAddressFrom("your.mail@gmail.com");
//        MailServer.gmailCom.setUser("your.mail");
//        MailServer.gmailCom.setPassword("your.pass");
        if (mail.connect4Send(MailServer.gmailCom)) {
            mail.sendMessage(
                    new String[]{
                "arrow_405@yahoo.com",
                "yosuaonesimus@gmail.com"}, //to
                    null, //cc
                    null, //bcc
                    "This is a subject from a sample mail",
                    "This is a text from a sample mail",
                    false);
            mail.close4Send();
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" samplePdf ">
    public static void samplePdf() {
        CCPdf pdf = new CCPdf();
        pdf.createDocument(PageSize.A4.rotate(), new File("D:\\members.pdf"));
        pdf.openDocument();

        List<LibMember> members = new ArrayList();
        members.add(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        members.add(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        members.add(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));
        pdf.initEntity(LibMember.class, true);
        pdf.newTableEntity();
        pdf.writeTableHeaderEntity();
        pdf.writeTableContentEntity(members);
        pdf.addElementTable();

        pdf.closeDocument();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleQuartz ">
    public static void sampleQuartz() {
        HashMap<String, Object> parameter = new HashMap();
        parameter.put("member.firstName", "Yosua");
        parameter.put("member.lastName", "Onesimus");
        CCQuartz.start(SimpleJob.class, parameter, "0/3 * * * * ?");
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleDatabase ">
    public static void sampleDatabase() {
        CCDatabaseConfig databaseConfig = new CCDatabaseConfig().
                withHost("localhost").withPort("3306").
                withUsername("root").withPassword("1234").
                withDatabase("coco_trial");

        final CCDatabase database = new CCDatabase();
        database.getConnection(databaseConfig, false);

        CCDatabaseDao databaseDao = new CCDatabaseDao() {
            @Override
            protected CCDatabase getCCDatabase() {
                return database;
            }

            @Override
            protected Class<? extends CCEntity> getEntity() {
                return LibMember.class;
            }
        };
        databaseDao.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        databaseDao.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        databaseDao.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));

        List<LibMember> members = databaseDao.getList();
        for (LibMember member : members) {
            println("Member: Code:" + member.getCode() + ";Full Name:" + member.getFullName() + ";Birth Date:" + CCFormat.getString(member.getBirthDate()) + ";Gender:" + member.getGender() + ";");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleHibernate ">
    public static void sampleHibernate() {
        CCDatabaseConfig databaseConfig = new CCDatabaseConfig().
                withHost("localhost").withPort("3306").
                withUsername("root").withPassword("1234").
                withDatabase("coco_trial");

        final CCHibernate hibernate = new CCHibernate();
        hibernate.addAnnotatedClass(LibMember.class);
        hibernate.addDatabaseConfig(databaseConfig);

        CCHibernateDao hibernateDao = new CCHibernateDao() {
            @Override
            protected CCHibernate getCCHibernate() {
                return hibernate;
            }

            @Override
            protected List<CCHibernateFilter> getFilters() {
                return new ArrayList();
            }

            @Override
            protected Class getEntity() {
                return LibMember.class;
            }
        };
        hibernateDao.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        hibernateDao.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        hibernateDao.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));

        List<LibMember> members = hibernateDao.getList();
        for (LibMember member : members) {
            println("Member: Code:" + member.getCode() + ";Full Name:" + member.getFullName() + ";Birth Date:" + CCFormat.getString(member.getBirthDate()) + ";Gender:" + member.getGender() + ";");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleCsv ">
    public static void sampleCsv() {
        CCCsv csv = new CCCsv();
        csv.newList();
        csv.addRowEntity(0, newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        csv.addRowEntity(1, newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        csv.addRowEntity(2, newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));

        csv.write(new File("D:\\members.csv"));

        CCCsv csv2 = new CCCsv();
        csv2.read(new File("D:\\members.csv"));

        for (String member : csv2.getRows()) {
            println("Member: " + member);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleDataFile ">
    public static void sampleDatafile() {
        CCDataFile dataFile = new CCDataFile(LibMember.class);
        dataFile.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        dataFile.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        dataFile.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));

        List<LibMember> members = dataFile.getList(null, null);
        for (LibMember member : members) {
            println("Member: Code:" + member.getCode() + ";Full Name:" + member.getFullName() + ";Birth Date:" + CCFormat.getString(member.getBirthDate()) + ";Gender:" + member.getGender() + ";");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleXml ">
    public static void sampleXml() {
        CCDom dom = new CCDom();
        dom.newRoot("root");

        Node attributeBase = dom.appendChildNode(dom.getRoot(), "attributeBase");
        Node member = dom.appendChildNode(attributeBase, "member");
        dom.setAttribute(member, "firstName", "Yosua");
        dom.setAttribute(member, "lastName", "Onesimus");

        Node elementBase = dom.appendChildNode(dom.getRoot(), "elementBase");
        member = dom.appendChildNode(elementBase, "member");
        Node firstName = dom.appendChildNode(member, "firstName");
        dom.appendChildTextNode(firstName, "Sari");
        Node lastName = dom.appendChildNode(member, "lastName");
        dom.appendChildTextNode(lastName, "Heriati");

        dom.transform(new File("D:\\member.xml"));

        CCDom dom2 = new CCDom();
        dom2.read(new File("D:\\member.xml"));

        attributeBase = dom2.getNodeByTagName(dom2.getRoot(), "attributeBase");
        member = dom2.getNodeByTagName(attributeBase, "member");
        println(dom2.getAttribute(member, "firstName"));
        println(dom2.getAttribute(member, "lastName"));

        elementBase = dom2.getNodeByTagName(dom2.getRoot(), "elementBase");
        member = dom2.getNodeByTagName(elementBase, "member");
        println(dom2.getNodeValue(member, "firstName"));
        println(dom2.getNodeValue(member, "lastName"));
    }

    public static void sampleXml2() {
        CCDom dom = new CCDom();

        List<LibMember> members = new ArrayList();
        members.add(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        members.add(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        members.add(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));
        dom.writeEntity("root", members);

        dom.transform(new File("D:\\members.xml"));

        CCDom dom2 = new CCDom();
        dom2.read(new File("D:\\members.xml"));

        members = dom2.readEntity(LibMember.class);
        for (LibMember member : members) {
            println("Member: Code:" + member.getCode() + ";Full Name:" + member.getFullName() + ";Birth Date:" + CCFormat.getString(member.getBirthDate()) + ";Gender:" + member.getGender() + ";");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleFile ">
    public static void sampleFile() {
        File fileName = new File("D:\\sampleFile_file.txt");
        File fileName2 = new File("D:\\sampleFile_file2.txt");
        File fileName3 = new File("D:\\sampleFile_file3.txt");
        File zipName = new File("D:\\sampleFile_zip.zip");
        File folderName = new File("D:\\sampleFile_folder");

        System.out.println("fileName[2|3].exists()" + _ + fileName2.exists() + _ + fileName3.exists());
        CCFile.copy(fileName, fileName2);
        System.out.println("fileName[2|3].exists()" + _ + fileName2.exists() + _ + fileName3.exists());
        CCFile.rename(fileName2, fileName3);
        System.out.println("fileName[2|3].exists()" + _ + fileName2.exists() + _ + fileName3.exists());
        CCFile.delete(fileName3);
        System.out.println("fileName[2|3].exists()" + _ + fileName2.exists() + _ + fileName3.exists());

        System.out.println("zipName.exists()" + _ + zipName.exists());
        CCFile.zip(zipName, fileName);
        System.out.println("zipName.exists()" + _ + zipName.exists());

        System.out.println("folderName.exists()" + _ + folderName.exists());
        CCFile.unzip(zipName, folderName);
        System.out.println("folderName.exists()" + _ + folderName.exists());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleImage ">
    public static void sampleImage() {
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleProperties ">
    public static void sampleProperties() {
        CCProperties properties = new CCProperties();
        properties.setValue(bangunDatar, false);
        properties.storeExtern(new File("D:\\bangunDatar.prop"));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleFoxPro ">
    public static void sampleFoxPro() {
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleExcel ">
    public static void sampleExcel() {
        CCExcel excel = new CCExcel();
        excel.newWorkbook();

        excel.newSheet("common");
        excel.writeColumn(1, 2, "6", "11", "16");
        excel.writeColumn(5, 2, "10", "15", "20");
        excel.writeRow(1, 1, "1", "2", "3", "4", "5");
        excel.writeRow(1, 5, "21", "22", "23", "24", "25");
        excel.writeCell(2, 2, "x");
        excel.writeCell(3, 3, "y");
        excel.writeCell(4, 4, "z");

        excel.newSheet("row");
        excel.initEntity(BangunDatar.class, true);
        excel.writeRowEntityHeader();
        excel.writeRowEntity(bangunDatar);

        excel.newSheet("column");
        excel.initEntity(BangunDatar.class, true);
        excel.writeColumnEntityHeader();
        excel.writeColumnEntity(bangunDatar);

        excel.saveAndCloseWorkbook(new File("D:\\bangunDatar.xls"));
    }

    public static void sampleExcel2() {
        CCExcel excel = new CCExcel();
        excel.newWorkbook();

        List<LibMember> members = new ArrayList();
        members.add(newMember("M001", "Yosua Onesimus", "06/06/1984", Gender.MALE));
        members.add(newMember("M002", "Sari Heriati", "17/03/1984", Gender.FEMALE));
        members.add(newMember("M003", "Delvin Acelin", "02/09/2014", Gender.MALE));
        excel.newSheet(LibMember.class.getSimpleName());
        excel.initEntity(LibMember.class, false);
        excel.writeRowEntityHeader();
        excel.writeRowEntity(members);

        excel.saveAndCloseWorkbook(new File("D:\\members.xls"));

        CCExcel excel2 = new CCExcel();
        excel2.openWorkbook(new File("D:\\members.xls"));

        excel2.getSheet(LibMember.class.getSimpleName());
        excel2.initEntity(LibMember.class, false);
        members = excel2.readRowEntity(1, excel2.getRowCount() - 1);
        for (LibMember member : members) {
            println("Member: Code:" + member.getCode() + ";Full Name:" + member.getFullName() + ";Birth Date:" + CCFormat.getString(member.getBirthDate()) + ";Gender:" + member.getGender() + ";");
        }
    }
//</editor-fold>

    public static void main(String[] args) {
        sampleMail();
    }
}