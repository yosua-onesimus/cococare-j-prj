package controller.form.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCLogic.isNotNull;
import cococare.database.CCEntityBo;
import static cococare.database.CCEntityBo.INSTANCE;
import static cococare.datafile.CCFile.*;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import model.obj.dmp.DmpDocumentReference;
import model.obj.dmp.DmpEnum.ReferenceType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentReferenceListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getClass() {
        return _getDefaultToCustomClass();
    }

    @Override
    protected Class _getEntity() {
        return DmpDocumentReference.class;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        int column = tblEntity.getColumnCount();
        tblEntity.addField(column, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Action";
            }

            @Override
            public Object getCustomView(Object object) {
                final DmpDocumentReference documentReference = (DmpDocumentReference) object;
                CCLink link = new CCLink(documentReference.getValue());
                if (ReferenceType.ATTACHMENT.equals(documentReference.getReferenceType())) {
                    addListener(link, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                            CCEntityBo.INSTANCE.readTransientByteAValue(documentReference);
                            File file = showSaveDialog(new File(documentReference.getValue()));
                            if (isNotNull(file) && writeByteA(documentReference.getByteA(), file)) {
                                open(file);
                            }
                        }
                    });
                } else if (ReferenceType.LINK.equals(documentReference.getReferenceType())) {
                    link.toBookmark();
                } else if (ReferenceType.SHORTCUT.equals(documentReference.getReferenceType())) {
                    link.toShortcut();
                }
                return link;
            }

            @Override
            public Integer getColumnWidth() {
                return 150;
            }
        });
        tblEntity.setEditableColumn(true, column);
    }
}