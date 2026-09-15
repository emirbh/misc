package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.quantity.functions.NotionalQuantityScheduleEndDate_Validation;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0038_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0038_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0038_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0038_01";
	String DEFINITION = "if nonReportable -> postUpiData -> Header -> AssetClass = Commodities or dtccAdditionalFields -> primaryAssetClass = Commodity then (common.quantity.NotionalQuantityScheduleEndDate_Validation( leg1 -> notionalQuantitySchedule ) and common.quantity.NotionalQuantityScheduleEndDate_Validation( leg2 -> notionalQuantitySchedule )) else leg1 -> notionalQuantitySchedule -> endDate is absent and leg2 -> notionalQuantitySchedule -> endDate is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0038_01 {
	
		@Inject protected NotionalQuantityScheduleEndDate_Validation notionalQuantityScheduleEndDate_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All)).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleEndDate_Validation.evaluate(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleEndDate_Validation.evaluate(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).getMulti()))));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0038_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
