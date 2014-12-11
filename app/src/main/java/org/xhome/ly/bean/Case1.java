package org.xhome.ly.bean;

import android.database.Cursor;


import org.xhome.ly.dao.Case1DataHelper;

import java.util.HashMap;

/**
 * Created by liurongchan on 14/12/1.
 */
public class Case1 {

    private static final HashMap<Integer, Case1> CACHE = new HashMap<Integer, Case1>();

    private static void addToCache(Case1 case1) {
        CACHE.put(case1.id, case1);
    }

    private static Case1 getFromCache(int id) {
        return CACHE.get(id);
    }

public static Case1 fromCursor(Cursor cursor) {
    int id = cursor.getInt(cursor.getColumnIndex(Case1DataHelper.Case1DB.ID));
    Case1 case1 = getFromCache(id);
    if (case1 != null) {
        return case1;
    }
    case1 = new Case1();
    case1._id = cursor.getInt(cursor.getColumnIndex(Case1DataHelper.Case1DB._ID));
    case1.setId(cursor.getInt(cursor.getColumnIndex(Case1DataHelper.Case1DB.ID)));
    case1.setName(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.NAME)));
    case1.setInterrogationRecordId(cursor.getInt(cursor.getColumnIndex(Case1DataHelper.Case1DB.INTERROGATOPM_RECORD_ID)));
    case1.setOperationData(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.OPERATION_DATA)));
    case1.setOperatorName(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.OPERATOR_NAME)));
    case1.setOperatorDetail(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.OPERATOR_DETAIL)));
    case1.setVtType(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.VT_TYPE)));
    case1.setVtCourseDisease(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.VT_COURSE_DISEASE)));
    case1.setArrhythmiaDiagnose(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ARRHYTHMIA_DIAGNOSE)));
    case1.setElectrophysiologyDiagnose(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ELECTROPHYSIOLOGY_DIAGNOSE)));
    case1.setPostoperationDiagnose(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.POSTOPERATION_DIAGNOSE)));
    case1.setMechanism(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.MECHAISM)));
    case1.setPart(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.PART)));
    case1.setLaBore(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.LA_BORE)));
    case1.setLvBore(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.LV_BORE)));
    case1.setLvefBore(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.LVEF_BORE)));
    case1.setRaBore(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.RA_BORE)));
    case1.setRvBore(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.RV_BORE)));
    case1.setUcgRemarks(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.UCG_REMARKS)));
    case1.setEcgType(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ECG_TYPE)));
    case1.setElectricalOffset(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ELECTRICAL_OFFSET)));
    case1.setPreopreativeExamination(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.PREOPREATIVE_EXAMINATION)));
    case1.setAntiArrhythmiaDrugs(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ANTI_ARRHYTHMIA_DRUGS)));
    case1.setInvaliDantiArrhythmiaDrugs(cursor. getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.INVALI_DANTI_ARRHYTHMIA_DRUGS)));
    case1.setMergerArrhythmia(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.MERGER_ARRHYTHMIA)));
    case1.setImagingInsideHeart(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.IMAGING_INSIDE_HERAT)));
    case1.setInducedWay(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.INDUCED_WAY)));
    case1.setCheckMedication(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.CHECK_MEDICATION)));
    case1.setTachycardiaRegulation(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.TACHYCARDIA_REGULATION)));
    case1.setCcl(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.CCL)));
    case1.setInspectionMethod(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.INSPECTION_METHOD)));
    case1.setDiastolicPotential(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.DIASTOLIC_POTENTIAL)));
    case1.setpPotentialExamination(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.P_POTENTIAL_EXAMINATION)));
    case1.setAblationProcedure(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_PROCEDURE)));
    case1.setAblationLines(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_LINES)));
    case1.setTargetPosition(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.TARGET_POSITION)));
    case1.setAblationEnergy(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_ENERGY)));
    case1.setAblationJudgement(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_JUDGEMENT)));
    case1.setAblationEndPoint(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_END_POINT)));
    case1.setEffectiveTargetSite(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.ECFFECTIVE_TARGET_SITE)));
    case1.setDischargeTime(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.DISCHARGE_TIME)));
    case1.setXrayExposureTime(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.XRAY_EXPOSURE_TIME)));
    case1.setAblationTimes(cursor.getInt(cursor.getColumnIndex(Case1DataHelper.Case1DB.ABLATION_TIMES)));
    case1.setIntraoperativeCableRate(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.INTRAOPERATIVE_CABLE_RATE)));
    case1.setBeforeHeartRate(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.BEFORE_HEART_RATE)));
    case1.setBeforeVt(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.BEFORE_VT)));
    case1.setBeforeRont(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.BEFORE_RONT)));
    case1.setBeforeRemarks(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.BEFORE_REMARKS)));
    case1.setInHeartRate(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.IN_HEART_RATE)));
    case1.setInVt(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.IN_VT)));
    case1.setInRont(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.IN_RONT)));
    case1.setInRemarks(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.IN_REMARKS)));
    case1.setOperationNumber(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.OPERATION_NUMBER)));
    case1.setCaseNumber(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.CASE_NUMBER)));
    case1.setVtFrequency(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.VT_FREQUENCY)));
    case1.setVtEveryAttackTime(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.VT_EVERY_ATTACK_TIME)));
    case1.setVtLastAttackTime(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.VT_LAST_ATTACK_TIME)));
    case1.setCardioversionMethod(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.CARDIOVERSION_METHOD)));
    case1.setCardioversionMedication(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.CARDIOVERSION_MEDICATION)));
    case1.setComplication(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.COMPLICATION)));
    case1.setGlobalRemarks(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.GLOBAL_REMARKS)));
    case1.setKeyword1(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.KEYWORD1)));
    case1.setKeyword2(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.KEYWORD2)));
    case1.setKeyword3(cursor.getString(cursor.getColumnIndex(Case1DataHelper.Case1DB.KEYWORD3)));

    addToCache(case1);
    return case1;
}

    public int _id;

    private Integer id;

    private String name;

    private Integer interrogationRecordId;

    private String operationData;

    private String operatorName;

    private String operatorDetail;

    private String vtType;

    private String vtCourseDisease;

    private String arrhythmiaDiagnose;

    private String electrophysiologyDiagnose;

    private String postoperationDiagnose;

    private String mechanism;

    private String part;

    private String laBore;

    private String lvBore;

    private String lvefBore;

    private String raBore;

    private String rvBore;

    private String ucgRemarks;

    private String ecgType;

    private String electricalOffset;

    private String preopreativeExamination;

    private String antiArrhythmiaDrugs;

    private String invaliDantiArrhythmiaDrugs;

    private String mergerArrhythmia;

    private String imagingInsideHeart;

    private String inducedWay;

    private String checkMedication;

    private String tachycardiaRegulation;

    private String ccl;

    private String inspectionMethod;

    private String diastolicPotential;

    private String pPotentialExamination;

    private String ablationProcedure;

    private String ablationLines;

    private String targetPosition;

    private String ablationEnergy;

    private String ablationJudgement;

    private String ablationEndPoint;

    private String effectiveTargetSite;

    private String dischargeTime;

    private String xrayExposureTime;

    private Integer ablationTimes;

    private String intraoperativeCableRate;

    private String beforeHeartRate;

    private String beforeVt;

    private String beforeRont;

    private String beforeRemarks;

    private String inHeartRate;

    private String inVt;

    private String inRont;

    private String inRemarks;

    private String operationNumber;

    private String caseNumber;

    private String vtFrequency;

    private String vtEveryAttackTime;

    private String vtLastAttackTime;

    private String cardioversionMethod;

    private String cardioversionMedication;

    private String complication;

    private String globalRemarks;

    private String keyword1;

    private String keyword2;

    private String keyword3;


    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getVtFrequency() {
        return vtFrequency;
    }

    public void setVtFrequency(String vtFrequency) {
        this.vtFrequency = vtFrequency;
    }

    public String getVtEveryAttackTime() {
        return vtEveryAttackTime;
    }

    public void setVtEveryAttackTime(String vtEveryAttackTime) {
        this.vtEveryAttackTime = vtEveryAttackTime;
    }

    public String getVtLastAttackTime() {
        return vtLastAttackTime;
    }

    public void setVtLastAttackTime(String vtLastAttackTime) {
        this.vtLastAttackTime = vtLastAttackTime;
    }

    public String getCardioversionMethod() {
        return cardioversionMethod;
    }

    public void setCardioversionMethod(String cardioversionMethod) {
        this.cardioversionMethod = cardioversionMethod;
    }

    public String getCardioversionMedication() {
        return cardioversionMedication;
    }

    public void setCardioversionMedication(String cardioversionMedication) {
        this.cardioversionMedication = cardioversionMedication;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getInterrogationRecordId() {
        return interrogationRecordId;
    }

    public void setInterrogationRecordId(Integer interrogationRecordId) {
        this.interrogationRecordId = interrogationRecordId;
    }

    public String getOperationData() {
        return operationData;
    }

    public void setOperationData(String operationData) {
        this.operationData = operationData;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorDetail() {
        return operatorDetail;
    }

    public void setOperatorDetail(String operatorDetail) {
        this.operatorDetail = operatorDetail == null ? null : operatorDetail.trim();
    }

    public String getVtType() {
        return vtType;
    }

    public void setVtType(String vtType) {
        this.vtType = vtType == null ? null : vtType.trim();
    }

    public String getVtCourseDisease() {
        return vtCourseDisease;
    }

    public void setVtCourseDisease(String vtCourseDisease) {
        this.vtCourseDisease = vtCourseDisease == null ? null : vtCourseDisease.trim();
    }

    public String getArrhythmiaDiagnose() {
        return arrhythmiaDiagnose;
    }

    public void setArrhythmiaDiagnose(String arrhythmiaDiagnose) {
        this.arrhythmiaDiagnose = arrhythmiaDiagnose == null ? null : arrhythmiaDiagnose.trim();
    }

    public String getElectrophysiologyDiagnose() {
        return electrophysiologyDiagnose;
    }

    public void setElectrophysiologyDiagnose(String electrophysiologyDiagnose) {
        this.electrophysiologyDiagnose = electrophysiologyDiagnose == null ? null : electrophysiologyDiagnose.trim();
    }

    public String getPostoperationDiagnose() {
        return postoperationDiagnose;
    }

    public void setPostoperationDiagnose(String postoperationDiagnose) {
        this.postoperationDiagnose = postoperationDiagnose == null ? null : postoperationDiagnose.trim();
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism == null ? null : mechanism.trim();
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part == null ? null : part.trim();
    }

    public String getLaBore() {
        return laBore;
    }

    public void setLaBore(String laBore) {
        this.laBore = laBore == null ? null : laBore.trim();
    }

    public String getLvBore() {
        return lvBore;
    }

    public void setLvBore(String lvBore) {
        this.lvBore = lvBore == null ? null : lvBore.trim();
    }

    public String getLvefBore() {
        return lvefBore;
    }

    public void setLvefBore(String lvefBore) {
        this.lvefBore = lvefBore == null ? null : lvefBore.trim();
    }

    public String getRaBore() {
        return raBore;
    }

    public void setRaBore(String raBore) {
        this.raBore = raBore == null ? null : raBore.trim();
    }

    public String getRvBore() {
        return rvBore;
    }

    public void setRvBore(String rvBore) {
        this.rvBore = rvBore == null ? null : rvBore.trim();
    }

    public String getUcgRemarks() {
        return ucgRemarks;
    }

    public void setUcgRemarks(String ucgRemarks) {
        this.ucgRemarks = ucgRemarks == null ? null : ucgRemarks.trim();
    }

    public String getEcgType() {
        return ecgType;
    }

    public void setEcgType(String ecgType) {
        this.ecgType = ecgType == null ? null : ecgType.trim();
    }

    public String getElectricalOffset() {
        return electricalOffset;
    }

    public void setElectricalOffset(String electricalOffset) {
        this.electricalOffset = electricalOffset == null ? null : electricalOffset.trim();
    }

    public String getPreopreativeExamination() {
        return preopreativeExamination;
    }

    public void setPreopreativeExamination(String preopreativeExamination) {
        this.preopreativeExamination = preopreativeExamination == null ? null : preopreativeExamination.trim();
    }

    public String getAntiArrhythmiaDrugs() {
        return antiArrhythmiaDrugs;
    }

    public void setAntiArrhythmiaDrugs(String antiArrhythmiaDrugs) {
        this.antiArrhythmiaDrugs = antiArrhythmiaDrugs == null ? null : antiArrhythmiaDrugs.trim();
    }

    public String getInvaliDantiArrhythmiaDrugs() {
        return invaliDantiArrhythmiaDrugs;
    }

    public void setInvaliDantiArrhythmiaDrugs(String invaliDantiArrhythmiaDrugs) {
        this.invaliDantiArrhythmiaDrugs = invaliDantiArrhythmiaDrugs == null ? null : invaliDantiArrhythmiaDrugs.trim();
    }

    public String getMergerArrhythmia() {
        return mergerArrhythmia;
    }

    public void setMergerArrhythmia(String mergerArrhythmia) {
        this.mergerArrhythmia = mergerArrhythmia == null ? null : mergerArrhythmia.trim();
    }

    public String getImagingInsideHeart() {
        return imagingInsideHeart;
    }

    public void setImagingInsideHeart(String imagingInsideHeart) {
        this.imagingInsideHeart = imagingInsideHeart == null ? null : imagingInsideHeart.trim();
    }

    public String getInducedWay() {
        return inducedWay;
    }

    public void setInducedWay(String inducedWay) {
        this.inducedWay = inducedWay == null ? null : inducedWay.trim();
    }

    public String getCheckMedication() {
        return checkMedication;
    }

    public void setCheckMedication(String checkMedication) {
        this.checkMedication = checkMedication == null ? null : checkMedication.trim();
    }

    public String getTachycardiaRegulation() {
        return tachycardiaRegulation;
    }

    public void setTachycardiaRegulation(String tachycardiaRegulation) {
        this.tachycardiaRegulation = tachycardiaRegulation == null ? null : tachycardiaRegulation.trim();
    }

    public String getCcl() {
        return ccl;
    }

    public void setCcl(String ccl) {
        this.ccl = ccl == null ? null : ccl.trim();
    }

    public String getInspectionMethod() {
        return inspectionMethod;
    }

    public void setInspectionMethod(String inspectionMethod) {
        this.inspectionMethod = inspectionMethod == null ? null : inspectionMethod.trim();
    }

    public String getDiastolicPotential() {
        return diastolicPotential;
    }

    public void setDiastolicPotential(String diastolicPotential) {
        this.diastolicPotential = diastolicPotential == null ? null : diastolicPotential.trim();
    }

    public String getpPotentialExamination() {
        return pPotentialExamination;
    }

    public void setpPotentialExamination(String pPotentialExamination) {
        this.pPotentialExamination = pPotentialExamination == null ? null : pPotentialExamination.trim();
    }

    public String getAblationProcedure() {
        return ablationProcedure;
    }

    public void setAblationProcedure(String ablationProcedure) {
        this.ablationProcedure = ablationProcedure == null ? null : ablationProcedure.trim();
    }

    public String getAblationLines() {
        return ablationLines;
    }

    public void setAblationLines(String ablationLines) {
        this.ablationLines = ablationLines == null ? null : ablationLines.trim();
    }

    public String getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(String targetPosition) {
        this.targetPosition = targetPosition == null ? null : targetPosition.trim();
    }

    public String getAblationEnergy() {
        return ablationEnergy;
    }

    public void setAblationEnergy(String ablationEnergy) {
        this.ablationEnergy = ablationEnergy == null ? null : ablationEnergy.trim();
    }

    public String getAblationJudgement() {
        return ablationJudgement;
    }

    public void setAblationJudgement(String ablationJudgement) {
        this.ablationJudgement = ablationJudgement == null ? null : ablationJudgement.trim();
    }

    public String getAblationEndPoint() {
        return ablationEndPoint;
    }

    public void setAblationEndPoint(String ablationEndPoint) {
        this.ablationEndPoint = ablationEndPoint == null ? null : ablationEndPoint.trim();
    }

    public String getEffectiveTargetSite() {
        return effectiveTargetSite;
    }

    public void setEffectiveTargetSite(String effectiveTargetSite) {
        this.effectiveTargetSite = effectiveTargetSite == null ? null : effectiveTargetSite.trim();
    }

    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime == null ? null : dischargeTime.trim();
    }

    public String getXrayExposureTime() {
        return xrayExposureTime;
    }

    public void setXrayExposureTime(String xrayExposureTime) {
        this.xrayExposureTime = xrayExposureTime == null ? null : xrayExposureTime.trim();
    }

    public Integer getAblationTimes() {
        return ablationTimes;
    }

    public void setAblationTimes(Integer ablationTimes) {
        this.ablationTimes = ablationTimes;
    }

    public String getIntraoperativeCableRate() {
        return intraoperativeCableRate;
    }

    public void setIntraoperativeCableRate(String intraoperativeCableRate) {
        this.intraoperativeCableRate = intraoperativeCableRate == null ? null : intraoperativeCableRate.trim();
    }

    public String getBeforeHeartRate() {
        return beforeHeartRate;
    }

    public void setBeforeHeartRate(String beforeHeartRate) {
        this.beforeHeartRate = beforeHeartRate == null ? null : beforeHeartRate.trim();
    }

    public String getBeforeVt() {
        return beforeVt;
    }

    public void setBeforeVt(String beforeVt) {
        this.beforeVt = beforeVt == null ? null : beforeVt.trim();
    }

    public String getBeforeRont() {
        return beforeRont;
    }

    public void setBeforeRont(String beforeRont) {
        this.beforeRont = beforeRont == null ? null : beforeRont.trim();
    }

    public String getBeforeRemarks() {
        return beforeRemarks;
    }

    public void setBeforeRemarks(String beforeRemarks) {
        this.beforeRemarks = beforeRemarks == null ? null : beforeRemarks.trim();
    }

    public String getInHeartRate() {
        return inHeartRate;
    }

    public void setInHeartRate(String inHeartRate) {
        this.inHeartRate = inHeartRate == null ? null : inHeartRate.trim();
    }

    public String getInVt() {
        return inVt;
    }

    public void setInVt(String inVt) {
        this.inVt = inVt == null ? null : inVt.trim();
    }

    public String getInRont() {
        return inRont;
    }

    public void setInRont(String inRont) {
        this.inRont = inRont == null ? null : inRont.trim();
    }

    public String getInRemarks() {
        return inRemarks;
    }

    public void setInRemarks(String inRemarks) {
        this.inRemarks = inRemarks == null ? null : inRemarks.trim();
    }



    public String getGlobalRemarks() {
        return globalRemarks;
    }

    public void setGlobalRemarks(String globalRemarks) {
        this.globalRemarks = globalRemarks == null ? null : globalRemarks.trim();
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1 == null ? null : keyword1.trim();
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2 == null ? null : keyword2.trim();
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3 == null ? null : keyword3.trim();
    }
}
