package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
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
@RosettaDataRule("CSATransactionReportCSA_VR_0135_01")
@ImplementedBy(CSATransactionReportCSA_VR_0135_01.Default.class)
public interface CSATransactionReportCSA_VR_0135_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0135_01";
	String DEFINITION = "if nonReportable -> postUpiData -> Attributes -> DeliveryType = CASH or nonReportable -> deliveryType = CASH then (leg1 -> settlementCurrency exists or leg2 -> settlementCurrency exists) else (leg1 -> settlementCurrency is absent and leg2 -> settlementCurrency is absent)";
	
	class Default implements CSATransactionReportCSA_VR_0135_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", annaDsbAttributesRecord -> annaDsbAttributesRecord.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", cSANonReportable -> cSANonReportable.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency())).orNullSafe(exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency())));
				}
				return notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency())).andNullSafe(notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0135_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
