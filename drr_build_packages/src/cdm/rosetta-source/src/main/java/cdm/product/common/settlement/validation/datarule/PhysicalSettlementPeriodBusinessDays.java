package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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
@RosettaDataRule("PhysicalSettlementPeriodBusinessDays")
@ImplementedBy(PhysicalSettlementPeriodBusinessDays.Default.class)
public interface PhysicalSettlementPeriodBusinessDays extends Validator<PhysicalSettlementPeriod> {
	
	String NAME = "PhysicalSettlementPeriodBusinessDays";
	String DEFINITION = "if businessDays exists then businessDays >= 0";
	
	class Default implements PhysicalSettlementPeriodBusinessDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
			ComparisonResult result = executeDataRule(physicalSettlementPeriod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementPeriod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementPeriod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PhysicalSettlementPeriod physicalSettlementPeriod) {
			try {
				if (exists(MapperS.of(physicalSettlementPeriod).<Integer>map("getBusinessDays", _physicalSettlementPeriod -> _physicalSettlementPeriod.getBusinessDays())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(physicalSettlementPeriod).<Integer>map("getBusinessDays", _physicalSettlementPeriod -> _physicalSettlementPeriod.getBusinessDays()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PhysicalSettlementPeriodBusinessDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
			return Collections.emptyList();
		}
	}
}
