package drr.base.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportablePriceSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportablePriceSourceChoice")
@ImplementedBy(ReportablePriceSourceChoice.Default.class)
public interface ReportablePriceSourceChoice extends Validator<ReportablePriceSource> {
	
	String NAME = "ReportablePriceSourceChoice";
	String DEFINITION = "required choice assetIdentifier, otherId";
	
	class Default implements ReportablePriceSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportablePriceSource reportablePriceSource) {
			ComparisonResult result = executeDataRule(reportablePriceSource);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportablePriceSource", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportablePriceSource", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportablePriceSource reportablePriceSource) {
			try {
				return choice(MapperS.of(reportablePriceSource), Arrays.asList("assetIdentifier", "otherId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportablePriceSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportablePriceSource reportablePriceSource) {
			return Collections.emptyList();
		}
	}
}
