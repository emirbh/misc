package fpml.consolidated.fpmlreturn.swaps.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.EarlyTerminationDateEnum;
import fpml.consolidated.fpmlenum.FeeElectionEnum;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquitySwapTransactionSupplementChoice1")
@ImplementedBy(EquitySwapTransactionSupplementChoice1.Default.class)
public interface EquitySwapTransactionSupplementChoice1 extends Validator<EquitySwapTransactionSupplement> {
	
	String NAME = "EquitySwapTransactionSupplementChoice1";
	String DEFINITION = "optionalEarlyTermination is absent and optionalEarlyTerminationDate is absent and optionalEarlyTerminationElectingPartyReference is absent and breakFundingRecovery is absent and breakFeeElection is absent and breakFeeRate is absent or mutualEarlyTermination is absent";
	
	class Default implements EquitySwapTransactionSupplementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			ComparisonResult result = executeDataRule(equitySwapTransactionSupplement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquitySwapTransactionSupplement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquitySwapTransactionSupplement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			try {
				return notExists(MapperS.of(equitySwapTransactionSupplement).<Boolean>map("getOptionalEarlyTermination", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getOptionalEarlyTermination())).andNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<EarlyTerminationDateEnum>map("getOptionalEarlyTerminationDate", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getOptionalEarlyTerminationDate()))).andNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<PartyReference>map("getOptionalEarlyTerminationElectingPartyReference", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getOptionalEarlyTerminationElectingPartyReference()))).andNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<Boolean>map("getBreakFundingRecovery", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getBreakFundingRecovery()))).andNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<FeeElectionEnum>map("getBreakFeeElection", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getBreakFeeElection()))).andNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<BigDecimal>map("getBreakFeeRate", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getBreakFeeRate()))).orNullSafe(notExists(MapperS.of(equitySwapTransactionSupplement).<Boolean>map("getMutualEarlyTermination", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getMutualEarlyTermination())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquitySwapTransactionSupplementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement equitySwapTransactionSupplement) {
			return Collections.emptyList();
		}
	}
}
