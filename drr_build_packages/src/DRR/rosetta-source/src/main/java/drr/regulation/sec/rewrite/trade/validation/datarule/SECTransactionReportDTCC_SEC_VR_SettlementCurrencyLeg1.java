package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1";
	String DEFINITION = "if nonReportable -> postUpiData -> Attributes -> DeliveryType = CASH or dtccAdditionalFields -> settlementType = \"Cash\" then leg1 -> settlementCurrency exists else leg1 -> settlementCurrency is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", annaDsbAttributesRecord -> annaDsbAttributesRecord.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<String>map("getSettlementType", dTCCAdditionalFields -> dTCCAdditionalFields.getSettlementType()), MapperS.of("Cash"), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", sECLeg -> sECLeg.getSettlementCurrency()));
				}
				return notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", sECLeg -> sECLeg.getSettlementCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
