package cdm.event.common.validation.datarule;

import cdm.event.common.CollateralPosition;
import cdm.event.common.CollateralStatusEnum;
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
@RosettaDataRule("CollateralPositionCollateralPositionStatusSettledOrInTransitOnly")
@ImplementedBy(CollateralPositionCollateralPositionStatusSettledOrInTransitOnly.Default.class)
public interface CollateralPositionCollateralPositionStatusSettledOrInTransitOnly extends Validator<CollateralPosition> {
	
	String NAME = "CollateralPositionCollateralPositionStatusSettledOrInTransitOnly";
	String DEFINITION = "if collateralPositionStatus exists then collateralPositionStatus = CollateralStatusEnum -> SettledAmount or collateralPositionStatus = CollateralStatusEnum -> InTransitAmount";
	
	class Default implements CollateralPositionCollateralPositionStatusSettledOrInTransitOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPosition collateralPosition) {
			ComparisonResult result = executeDataRule(collateralPosition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPosition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPosition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralPosition collateralPosition) {
			try {
				if (exists(MapperS.of(collateralPosition).<CollateralStatusEnum>map("getCollateralPositionStatus", _collateralPosition -> _collateralPosition.getCollateralPositionStatus())).getOrDefault(false)) {
					return areEqual(MapperS.of(collateralPosition).<CollateralStatusEnum>map("getCollateralPositionStatus", _collateralPosition -> _collateralPosition.getCollateralPositionStatus()), MapperS.of(CollateralStatusEnum.SETTLED_AMOUNT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(collateralPosition).<CollateralStatusEnum>map("getCollateralPositionStatus", _collateralPosition -> _collateralPosition.getCollateralPositionStatus()), MapperS.of(CollateralStatusEnum.IN_TRANSIT_AMOUNT), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralPositionCollateralPositionStatusSettledOrInTransitOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPosition collateralPosition) {
			return Collections.emptyList();
		}
	}
}
