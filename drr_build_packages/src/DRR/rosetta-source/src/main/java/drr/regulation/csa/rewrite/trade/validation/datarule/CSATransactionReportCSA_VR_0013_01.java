package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0013_01")
@ImplementedBy(CSATransactionReportCSA_VR_0013_01.Default.class)
public interface CSATransactionReportCSA_VR_0013_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0013_01";
	String DEFINITION = "if (nonReportable -> postUpiData -> Derived -> ReturnorPayoutTrigger exists and nonReportable -> postUpiData -> Derived -> ReturnorPayoutTrigger <> Contract_for_Difference_CFD_) or nonReportable -> returnorPayoutTrigger <> \"Contract_for_Difference_CFD_\" then expirationDate exists and expirationDate >= effectiveDate else expirationDate is absent";
	
	class Default implements CSATransactionReportCSA_VR_0013_01 {
	
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
				if (exists(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbReturnorPayoutTriggerEnum>map("getReturnorPayoutTrigger", annaDsbDerived -> annaDsbDerived.getReturnorPayoutTrigger())).andNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbReturnorPayoutTriggerEnum>map("getReturnorPayoutTrigger", annaDsbDerived -> annaDsbDerived.getReturnorPayoutTrigger()), MapperS.of(AnnaDsbReturnorPayoutTriggerEnum.CONTRACT_FOR_DIFFERENCE_CFD), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<String>map("getReturnorPayoutTrigger", cSANonReportable -> cSANonReportable.getReturnorPayoutTrigger()), MapperS.of("Contract_for_Difference_CFD_"), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<Date>map("getExpirationDate", _cSATransactionReport -> _cSATransactionReport.getExpirationDate())).andNullSafe(greaterThanEquals(MapperS.of(cSATransactionReport).<Date>map("getExpirationDate", _cSATransactionReport -> _cSATransactionReport.getExpirationDate()), MapperS.of(cSATransactionReport).<Date>map("getEffectiveDate", _cSATransactionReport -> _cSATransactionReport.getEffectiveDate()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(cSATransactionReport).<Date>map("getExpirationDate", _cSATransactionReport -> _cSATransactionReport.getExpirationDate()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0013_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
