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
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
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
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0133_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0133_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0133_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0133_01";
	String DEFINITION = "if (nonReportable -> postUpiData -> Derived -> ReturnorPayoutTrigger exists and nonReportable -> postUpiData -> Derived -> ReturnorPayoutTrigger <> Contract_for_Difference_CFD_) or nonReportable -> returnorPayoutTrigger <> \"Contract_for_Difference_CFD_\" then finalContractualSettlementDate exists and finalContractualSettlementDate >= expirationDate else finalContractualSettlementDate is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0133_01 {
	
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
				if (exists(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbReturnorPayoutTriggerEnum>map("getReturnorPayoutTrigger", annaDsbDerived -> annaDsbDerived.getReturnorPayoutTrigger())).andNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbReturnorPayoutTriggerEnum>map("getReturnorPayoutTrigger", annaDsbDerived -> annaDsbDerived.getReturnorPayoutTrigger()), MapperS.of(AnnaDsbReturnorPayoutTriggerEnum.CONTRACT_FOR_DIFFERENCE_CFD), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<String>map("getReturnorPayoutTrigger", cSANonReportable -> cSANonReportable.getReturnorPayoutTrigger()), MapperS.of("Contract_for_Difference_CFD_"), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<Date>map("getFinalContractualSettlementDate", _cSATransactionReportTrade -> _cSATransactionReportTrade.getFinalContractualSettlementDate())).andNullSafe(greaterThanEquals(MapperS.of(cSATransactionReportTrade).<Date>map("getFinalContractualSettlementDate", _cSATransactionReportTrade -> _cSATransactionReportTrade.getFinalContractualSettlementDate()), MapperS.of(cSATransactionReportTrade).<Date>map("getExpirationDate", _cSATransactionReportTrade -> _cSATransactionReportTrade.getExpirationDate()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<Date>map("getFinalContractualSettlementDate", _cSATransactionReportTrade -> _cSATransactionReportTrade.getFinalContractualSettlementDate()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0133_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
