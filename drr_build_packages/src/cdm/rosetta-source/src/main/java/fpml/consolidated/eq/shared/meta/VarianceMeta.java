package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.eq.shared.validation.VarianceTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.VarianceValidator;
import fpml.consolidated.eq.shared.validation.datarule.CalculationFromObservationChoice;
import fpml.consolidated.eq.shared.validation.datarule.VarianceChoice;
import fpml.consolidated.eq.shared.validation.exists.VarianceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Variance.class)
public class VarianceMeta implements RosettaMetaData<Variance> {

	@Override
	public List<Validator<? super Variance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationFromObservation>create(CalculationFromObservationChoice.class),
			factory.<Variance>create(VarianceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Variance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Variance> validator(ValidatorFactory factory) {
		return factory.<Variance>create(VarianceValidator.class);
	}

	@Override
	public Validator<? super Variance> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Variance>create(VarianceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Variance> validator() {
		return new VarianceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Variance> typeFormatValidator() {
		return new VarianceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Variance, Set<String>> onlyExistsValidator() {
		return new VarianceOnlyExistsValidator();
	}
}
