package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityStartingDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityStartingDateChoice")
@ImplementedBy(CommodityStartingDateChoice.Default.class)
public interface CommodityStartingDateChoice extends Validator<CommodityStartingDate> {
	
	String NAME = "CommodityStartingDateChoice";
	String DEFINITION = "one-of";
	
	class Default implements CommodityStartingDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStartingDate commodityStartingDate) {
			ComparisonResult result = executeDataRule(commodityStartingDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStartingDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStartingDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityStartingDate commodityStartingDate) {
			try {
				return choice(MapperS.of(commodityStartingDate), Arrays.asList("dateRelativeTo", "adjustableDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityStartingDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStartingDate commodityStartingDate) {
			return Collections.emptyList();
		}
	}
}
