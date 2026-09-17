package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CashCTSTimeEnum;
import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
import cdm.legaldocumentation.csa.SecuritiesCTSTimeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("LegacyTransferSettlementTimingOtherValues")
@ImplementedBy(LegacyTransferSettlementTimingOtherValues.Default.class)
public interface LegacyTransferSettlementTimingOtherValues extends Validator<LegacyTransferSettlementTiming> {
	
	String NAME = "LegacyTransferSettlementTimingOtherValues";
	String DEFINITION = "if cashCollateralTransferSettlementTime = CashCTSTimeEnum -> Other or securititesCollateralTransferSettlementTime = SecuritiesCTSTimeEnum -> Other then additionalLanguage exists";
	
	class Default implements LegacyTransferSettlementTimingOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyTransferSettlementTiming legacyTransferSettlementTiming) {
			ComparisonResult result = executeDataRule(legacyTransferSettlementTiming);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyTransferSettlementTiming", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyTransferSettlementTiming", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyTransferSettlementTiming legacyTransferSettlementTiming) {
			try {
				if (areEqual(MapperS.of(legacyTransferSettlementTiming).<CashCTSTimeEnum>map("getCashCollateralTransferSettlementTime", _legacyTransferSettlementTiming -> _legacyTransferSettlementTiming.getCashCollateralTransferSettlementTime()), MapperS.of(CashCTSTimeEnum.OTHER), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(legacyTransferSettlementTiming).<SecuritiesCTSTimeEnum>map("getSecurititesCollateralTransferSettlementTime", _legacyTransferSettlementTiming -> _legacyTransferSettlementTiming.getSecurititesCollateralTransferSettlementTime()), MapperS.of(SecuritiesCTSTimeEnum.OTHER), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(legacyTransferSettlementTiming).<String>map("getAdditionalLanguage", _legacyTransferSettlementTiming -> _legacyTransferSettlementTiming.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyTransferSettlementTimingOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyTransferSettlementTiming legacyTransferSettlementTiming) {
			return Collections.emptyList();
		}
	}
}
