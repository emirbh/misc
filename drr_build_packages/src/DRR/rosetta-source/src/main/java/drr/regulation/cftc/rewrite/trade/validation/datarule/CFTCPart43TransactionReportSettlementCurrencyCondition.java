package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
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
@RosettaDataRule("CFTCPart43TransactionReportSettlementCurrencyCondition")
@ImplementedBy(CFTCPart43TransactionReportSettlementCurrencyCondition.Default.class)
public interface CFTCPart43TransactionReportSettlementCurrencyCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportSettlementCurrencyCondition";
	String DEFINITION = "if nonReportable -> postUpiData -> Attributes -> DeliveryType = CASH or nonReportable -> deliveryType = CASH then (leg1 -> settlementCurrency exists or leg2 -> settlementCurrency exists) else (leg1 -> settlementCurrency is absent and leg2 -> settlementCurrency is absent)";
	
	class Default implements CFTCPart43TransactionReportSettlementCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", annaDsbAttributesRecord -> annaDsbAttributesRecord.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency())).orNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency())));
				}
				return notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency())).andNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportSettlementCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
