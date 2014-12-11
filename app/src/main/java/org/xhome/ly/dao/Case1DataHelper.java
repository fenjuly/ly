package org.xhome.ly.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.BaseDataHelper;
import org.xhome.ly.dao.DataProvider;
import org.xhome.ly.dao.database.Column;
import org.xhome.ly.dao.database.SQLiteTable;

/**
 * Created by liurongchan on 14/12/1.
 */
public class Case1DataHelper extends BaseDataHelper {

    public Case1DataHelper(Context context) {
        super(context);
    }

    @Override
    protected Uri getContentUri() {
        return DataProvider.CASE1_CONTENT_URI;
    }

    private ContentValues getContentValues(Case1 case1) {
        ContentValues values = new ContentValues();

        values.put(Case1DB.ID, case1.getId());
        values.put(Case1DB.NAME, case1.getName());
        values.put(Case1DB.INTERROGATOPM_RECORD_ID, case1.getInterrogationRecordId());
        values.put(Case1DB.OPERATION_DATA, case1.getOperationData());
        values.put(Case1DB.OPERATOR_NAME, case1.getOperatorName());
        values.put(Case1DB.OPERATOR_DETAIL, case1.getOperatorDetail());
        values.put(Case1DB.VT_TYPE, case1.getVtType());
        values.put(Case1DB.VT_COURSE_DISEASE, case1.getVtCourseDisease());
        values.put(Case1DB.ARRHYTHMIA_DIAGNOSE, case1.getArrhythmiaDiagnose());
        values.put(Case1DB.ELECTROPHYSIOLOGY_DIAGNOSE, case1.getElectrophysiologyDiagnose());
        values.put(Case1DB.POSTOPERATION_DIAGNOSE, case1.getPostoperationDiagnose());
        values.put(Case1DB.MECHAISM, case1.getMechanism());
        values.put(Case1DB.PART, case1.getPart());
        values.put(Case1DB.LA_BORE, case1.getLaBore());
        values.put(Case1DB.LV_BORE, case1.getLvBore());
        values.put(Case1DB.LVEF_BORE, case1.getLvefBore());
        values.put(Case1DB.RA_BORE, case1.getRaBore());
        values.put(Case1DB.RV_BORE, case1.getRvBore());
        values.put(Case1DB.UCG_REMARKS, case1.getUcgRemarks());
        values.put(Case1DB.ECG_TYPE, case1.getEcgType());
        values.put(Case1DB.ELECTRICAL_OFFSET, case1.getElectricalOffset());
        values.put(Case1DB.PREOPREATIVE_EXAMINATION, case1.getPreopreativeExamination());
        values.put(Case1DB.ANTI_ARRHYTHMIA_DRUGS, case1.getAntiArrhythmiaDrugs());
        values.put(Case1DB.INVALI_DANTI_ARRHYTHMIA_DRUGS, case1.getInvaliDantiArrhythmiaDrugs());
        values.put(Case1DB.MERGER_ARRHYTHMIA, case1.getMergerArrhythmia());
        values.put(Case1DB.IMAGING_INSIDE_HERAT, case1.getImagingInsideHeart());
        values.put(Case1DB.INDUCED_WAY, case1.getInducedWay());
        values.put(Case1DB.CHECK_MEDICATION, case1.getCheckMedication());
        values.put(Case1DB.TACHYCARDIA_REGULATION, case1.getTachycardiaRegulation());
        values.put(Case1DB.CCL, case1.getCcl());
        values.put(Case1DB.INSPECTION_METHOD, case1.getInspectionMethod());
        values.put(Case1DB.DIASTOLIC_POTENTIAL, case1.getDiastolicPotential());
        values.put(Case1DB.P_POTENTIAL_EXAMINATION, case1.getpPotentialExamination());
        values.put(Case1DB.ABLATION_PROCEDURE, case1.getAblationProcedure());
        values.put(Case1DB.ABLATION_LINES, case1.getAblationLines());
        values.put(Case1DB.TARGET_POSITION, case1.getTargetPosition());
        values.put(Case1DB.ABLATION_ENERGY, case1.getAblationEnergy());
        values.put(Case1DB.ABLATION_JUDGEMENT, case1.getAblationJudgement());
        values.put(Case1DB.ABLATION_END_POINT, case1.getAblationEndPoint());
        values.put(Case1DB.ECFFECTIVE_TARGET_SITE, case1.getEffectiveTargetSite());
        values.put(Case1DB.DISCHARGE_TIME, case1.getDischargeTime());
        values.put(Case1DB.XRAY_EXPOSURE_TIME, case1.getXrayExposureTime());
        values.put(Case1DB.ABLATION_TIMES, case1.getAblationTimes());
        values.put(Case1DB.INTRAOPERATIVE_CABLE_RATE, case1.getIntraoperativeCableRate());
        values.put(Case1DB.BEFORE_HEART_RATE, case1.getBeforeHeartRate());
        values.put(Case1DB.BEFORE_VT, case1.getBeforeVt());
        values.put(Case1DB.BEFORE_RONT, case1.getBeforeRont());
        values.put(Case1DB.BEFORE_REMARKS, case1.getBeforeRemarks());
        values.put(Case1DB.IN_HEART_RATE, case1.getInHeartRate());
        values.put(Case1DB.IN_VT, case1.getInVt());
        values.put(Case1DB.IN_RONT, case1.getInRont());
        values.put(Case1DB.IN_REMARKS, case1.getInRemarks());

        values.put(Case1DB.OPERATION_NUMBER, case1.getOperationNumber());
        values.put(Case1DB.CASE_NUMBER, case1.getCaseNumber());
        values.put(Case1DB.VT_FREQUENCY, case1.getVtFrequency());
        values.put(Case1DB.VT_EVERY_ATTACK_TIME, case1.getVtEveryAttackTime());
        values.put(Case1DB.VT_LAST_ATTACK_TIME, case1.getVtLastAttackTime());
        values.put(Case1DB.CARDIOVERSION_METHOD, case1.getCardioversionMethod());
        values.put(Case1DB.CARDIOVERSION_MEDICATION, case1.getCardioversionMedication());
        values.put(Case1DB.COMPLICATION, case1.getComplication());


        values.put(Case1DB.GLOBAL_REMARKS, case1.getGlobalRemarks());
        values.put(Case1DB.KEYWORD1, case1.getKeyword1());
        values.put(Case1DB.KEYWORD2, case1.getKeyword2());
        values.put(Case1DB.KEYWORD3, case1.getKeyword3());

        return values;
    }


    public Case1 query(long id) {
        Case1 case1 = null;
        Cursor cursor = query(null, Case1DB._ID + "= ?",
                new String[] {
                         String.valueOf(id)
                }, null);
        if (cursor.moveToFirst()) {
            case1 = Case1.fromCursor(cursor);
        }
        cursor.close();
        return case1;
    }

    public Uri insert(Case1 case1) {
       return insert(getContentValues(case1));
    }

    public void delete(Case1 case1) {
        delete(getContentUri(), Case1DB._ID + "=?" , new String[] {
                String.valueOf(case1._id)
        });
    }

    public void update(Case1 case1) {
        update(getContentValues(case1), Case1DB._ID + "=?", new String[]{
                String.valueOf(case1._id)
        });
    }

    public static final class Case1DB implements BaseColumns {
        private Case1DB() {
        }

        public static final String TABLE_NAME = "case1";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String INTERROGATOPM_RECORD_ID = "interrogation_record_id";
        public static final String OPERATION_DATA = "operation_data";
        public static final String OPERATOR_NAME = "operator_name";
        public static final String OPERATOR_DETAIL = "operator_detail";
        public static final String VT_TYPE = "vt_type";
        public static final String VT_COURSE_DISEASE = "vt_course_disease";
        public static final String ARRHYTHMIA_DIAGNOSE = "arrhythmia_diagnose";
        public static final String ELECTROPHYSIOLOGY_DIAGNOSE = "electrophysiology_diagnose";
        public static final String POSTOPERATION_DIAGNOSE = "postoperation_diagnose";
        public static final String MECHAISM = "mechanism";
        public static final String PART = "part";
        public static final String LA_BORE = "la_bore";
        public static final String LV_BORE = "lv_bore";
        public static final String LVEF_BORE = "lvef_bore";
        public static final String RA_BORE = "ra_bore";
        public static final String RV_BORE = "rv_bore";
        public static final String UCG_REMARKS = "ucg_remarks";
        public static final String ECG_TYPE = "ecg_type";
        public static final String ELECTRICAL_OFFSET = "electrical_offset";
        public static final String PREOPREATIVE_EXAMINATION = "preopreative_examination";
        public static final String ANTI_ARRHYTHMIA_DRUGS = "anti_arrhythmia_drugs";
        public static final String INVALI_DANTI_ARRHYTHMIA_DRUGS = "invali_danti_arrhythmia_drugs";
        public static final String MERGER_ARRHYTHMIA = "merger_arrhythmia";
        public static final String IMAGING_INSIDE_HERAT = "imaging_inside_heart";
        public static final String INDUCED_WAY = "induced_way";
        public static final String CHECK_MEDICATION = "check_medication";
        public static final String TACHYCARDIA_REGULATION = "tachycardia_regulation";
        public static final String CCL = "ccl";
        public static final String INSPECTION_METHOD = "inspection_method";
        public static final String DIASTOLIC_POTENTIAL = "diastolic_potential";
        public static final String P_POTENTIAL_EXAMINATION = "p_potential_examination";
        public static final String ABLATION_PROCEDURE = "ablation_procedure";
        public static final String ABLATION_LINES = "ablation_lines";
        public static final String TARGET_POSITION = "target_position";
        public static final String ABLATION_ENERGY = "ablation_energy";
        public static final String ABLATION_JUDGEMENT = "ablation_judgement";
        public static final String ABLATION_END_POINT = "ablation_end_point";
        public static final String ECFFECTIVE_TARGET_SITE = "effective_target_site";
        public static final String DISCHARGE_TIME = "discharge_time";
        public static final String XRAY_EXPOSURE_TIME = "xray_exposure_time";
        public static final String ABLATION_TIMES = "ablation_times";
        public static final String INTRAOPERATIVE_CABLE_RATE = "intraoperative_cable_rate";
        public static final String BEFORE_HEART_RATE = "before_heart_rate";
        public static final String BEFORE_VT = "before_vt";
        public static final String BEFORE_RONT = "before_ront";
        public static final String BEFORE_REMARKS = "before_remarks";
        public static final String IN_HEART_RATE = "in_heart_rate";
        public static final String IN_VT = "in_vt";
        public static final String IN_RONT = "in_ront";
        public static final String IN_REMARKS = "in_remarks";

        public static final String OPERATION_NUMBER = "operation_number";
        public static final String CASE_NUMBER = "case_number";
        public static final String VT_FREQUENCY = "vt_frequency";
        public static final String VT_EVERY_ATTACK_TIME = "vt_every_attack_time";
        public static final String VT_LAST_ATTACK_TIME = "vt_last_attack_time";
        public static final String CARDIOVERSION_METHOD = "cardioversion_method";
        public static final String CARDIOVERSION_MEDICATION = "cardioversion_medication";
        public static final String COMPLICATION = "complication";


        public static final String GLOBAL_REMARKS = "global_remarks";
        public static final String KEYWORD1 = "keyword1";
        public static final String KEYWORD2 = "keyword2";
        public static final String KEYWORD3 = "keyword3";

        public static final SQLiteTable TABLE = new SQLiteTable(TABLE_NAME)
                .addColumn(ID, Column.DataType.INTEGER)
                .addColumn(NAME, Column.DataType.TEXT)
                .addColumn(INTERROGATOPM_RECORD_ID, Column.DataType.INTEGER)
                .addColumn(OPERATION_DATA, Column.DataType.TEXT)
                .addColumn(OPERATOR_NAME, Column.DataType.TEXT)
                .addColumn(OPERATOR_DETAIL, Column.DataType.TEXT)
                .addColumn(VT_TYPE, Column.DataType.TEXT)
                .addColumn(VT_COURSE_DISEASE, Column.DataType.TEXT)
                .addColumn(ARRHYTHMIA_DIAGNOSE, Column.DataType.TEXT)
                .addColumn(ELECTROPHYSIOLOGY_DIAGNOSE, Column.DataType.TEXT)
                .addColumn(POSTOPERATION_DIAGNOSE, Column.DataType.TEXT)
                .addColumn(MECHAISM, Column.DataType.TEXT)
                .addColumn(PART, Column.DataType.TEXT)
                .addColumn(LA_BORE, Column.DataType.TEXT)
                .addColumn(LV_BORE, Column.DataType.TEXT)
                .addColumn(LVEF_BORE, Column.DataType.TEXT)
                .addColumn(RA_BORE, Column.DataType.TEXT)
                .addColumn(RV_BORE, Column.DataType.TEXT)
                .addColumn(UCG_REMARKS, Column.DataType.TEXT)
                .addColumn(ECG_TYPE, Column.DataType.TEXT)
                .addColumn(ELECTRICAL_OFFSET, Column.DataType.TEXT)
                .addColumn(PREOPREATIVE_EXAMINATION, Column.DataType.TEXT)
                .addColumn(ANTI_ARRHYTHMIA_DRUGS, Column.DataType.TEXT)
                .addColumn(INVALI_DANTI_ARRHYTHMIA_DRUGS, Column.DataType.TEXT)
                .addColumn(MERGER_ARRHYTHMIA, Column.DataType.TEXT)
                .addColumn(IMAGING_INSIDE_HERAT, Column.DataType.TEXT)
                .addColumn(INDUCED_WAY, Column.DataType.TEXT)
                .addColumn(CHECK_MEDICATION, Column.DataType.TEXT)
                .addColumn(TACHYCARDIA_REGULATION, Column.DataType.TEXT)
                .addColumn(CCL, Column.DataType.TEXT)
                .addColumn(INSPECTION_METHOD, Column.DataType.TEXT)
                .addColumn(DIASTOLIC_POTENTIAL, Column.DataType.TEXT)
                .addColumn(P_POTENTIAL_EXAMINATION, Column.DataType.TEXT)
                .addColumn(ABLATION_PROCEDURE, Column.DataType.TEXT)
                .addColumn(ABLATION_LINES, Column.DataType.TEXT)
                .addColumn(TARGET_POSITION, Column.DataType.TEXT)
                .addColumn(ABLATION_ENERGY, Column.DataType.TEXT)
                .addColumn(ABLATION_JUDGEMENT, Column.DataType.TEXT)
                .addColumn(ABLATION_END_POINT, Column.DataType.TEXT)
                .addColumn(ECFFECTIVE_TARGET_SITE, Column.DataType.TEXT)
                .addColumn(DISCHARGE_TIME, Column.DataType.TEXT)
                .addColumn(XRAY_EXPOSURE_TIME, Column.DataType.TEXT)
                .addColumn(ABLATION_TIMES, Column.DataType.INTEGER)
                .addColumn(INTRAOPERATIVE_CABLE_RATE, Column.DataType.TEXT)
                .addColumn(BEFORE_HEART_RATE, Column.DataType.TEXT)
                .addColumn(BEFORE_VT, Column.DataType.TEXT)
                .addColumn(BEFORE_RONT, Column.DataType.TEXT)
                .addColumn(BEFORE_REMARKS, Column.DataType.TEXT)
                .addColumn(IN_HEART_RATE, Column.DataType.TEXT)
                .addColumn(IN_VT, Column.DataType.TEXT)
                .addColumn(IN_RONT, Column.DataType.TEXT)
                .addColumn(IN_REMARKS, Column.DataType.TEXT)
                .addColumn(OPERATION_NUMBER, Column.DataType.TEXT)
                .addColumn(CASE_NUMBER, Column.DataType.TEXT)
                .addColumn(VT_FREQUENCY, Column.DataType.TEXT)
                .addColumn(VT_EVERY_ATTACK_TIME, Column.DataType.TEXT)
                .addColumn(VT_LAST_ATTACK_TIME, Column.DataType.TEXT)
                .addColumn(CARDIOVERSION_METHOD, Column.DataType.TEXT)
                .addColumn(CARDIOVERSION_MEDICATION, Column.DataType.TEXT)
                .addColumn(COMPLICATION, Column.DataType.TEXT)
                .addColumn(GLOBAL_REMARKS, Column.DataType.TEXT)
                .addColumn(KEYWORD1, Column.DataType.TEXT)
                .addColumn(KEYWORD2, Column.DataType.TEXT)
                .addColumn(KEYWORD3, Column.DataType.TEXT)
                ;
    }
}
