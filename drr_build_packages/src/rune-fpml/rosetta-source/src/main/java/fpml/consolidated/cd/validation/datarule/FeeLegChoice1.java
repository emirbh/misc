package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.SinglePayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FeeLegChoice1")
@ImplementedBy(FeeLegChoice1.Default.class)
public interface FeeLegChoice1 extends Validator<FeeLeg> {
	
	String NAME = "FeeLegChoice1";
	String DEFINITION = "initialPayment exists or singlePayment exists or periodicPayment exists";
	
	class Default implements FeeLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg feeLeg) {
			ComparisonResult result = executeDataRule(feeLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FeeLeg feeLeg) {
			try {
				return exists(MapperS.of(feeLeg).<InitialPayment>map("getInitialPayment", _feeLeg -> _feeLeg.getInitialPayment())).orNullSafe(exists(MapperS.of(feeLeg).<SinglePayment>mapC("getSinglePayment", _feeLeg -> _feeLeg.getSinglePayment()))).orNullSafe(exists(MapperS.of(feeLeg).<PeriodicPayment>map("getPeriodicPayment", _feeLeg -> _feeLeg.getPeriodicPayment())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeeLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg feeLeg) {
			return Collections.emptyList();
		}
	}
}
