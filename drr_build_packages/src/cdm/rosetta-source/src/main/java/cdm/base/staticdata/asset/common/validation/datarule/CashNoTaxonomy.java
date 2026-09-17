package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Taxonomy;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("CashNoTaxonomy")
@ImplementedBy(CashNoTaxonomy.Default.class)
public interface CashNoTaxonomy extends Validator<Cash> {
	
	String NAME = "CashNoTaxonomy";
	String DEFINITION = "taxonomy is absent";
	
	class Default implements CashNoTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash cash) {
			ComparisonResult result = executeDataRule(cash);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Cash cash) {
			try {
				return notExists(MapperS.of(cash).<Taxonomy>mapC("getTaxonomy", _cash -> _cash.getTaxonomy()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashNoTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash cash) {
			return Collections.emptyList();
		}
	}
}
