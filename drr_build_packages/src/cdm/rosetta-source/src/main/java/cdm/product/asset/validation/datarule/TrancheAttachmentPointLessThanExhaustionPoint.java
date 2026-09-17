package cdm.product.asset.validation.datarule;

import cdm.product.asset.Tranche;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TrancheAttachmentPointLessThanExhaustionPoint")
@ImplementedBy(TrancheAttachmentPointLessThanExhaustionPoint.Default.class)
public interface TrancheAttachmentPointLessThanExhaustionPoint extends Validator<Tranche> {
	
	String NAME = "TrancheAttachmentPointLessThanExhaustionPoint";
	String DEFINITION = "attachmentPoint <= exhaustionPoint";
	
	class Default implements TrancheAttachmentPointLessThanExhaustionPoint {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Tranche tranche) {
			ComparisonResult result = executeDataRule(tranche);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Tranche", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Tranche", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Tranche tranche) {
			try {
				return lessThanEquals(MapperS.of(tranche).<BigDecimal>map("getAttachmentPoint", _tranche -> _tranche.getAttachmentPoint()), MapperS.of(tranche).<BigDecimal>map("getExhaustionPoint", _tranche -> _tranche.getExhaustionPoint()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TrancheAttachmentPointLessThanExhaustionPoint {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Tranche tranche) {
			return Collections.emptyList();
		}
	}
}
