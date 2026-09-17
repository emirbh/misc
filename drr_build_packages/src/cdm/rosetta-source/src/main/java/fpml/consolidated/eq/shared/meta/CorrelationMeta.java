package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import fpml.consolidated.eq.shared.Correlation;
import fpml.consolidated.eq.shared.validation.CorrelationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.CorrelationValidator;
import fpml.consolidated.eq.shared.validation.datarule.CalculationFromObservationChoice;
import fpml.consolidated.eq.shared.validation.exists.CorrelationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Correlation.class)
public class CorrelationMeta implements RosettaMetaData<Correlation> {

	@Override
	public List<Validator<? super Correlation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationFromObservation>create(CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Correlation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Correlation> validator(ValidatorFactory factory) {
		return factory.<Correlation>create(CorrelationValidator.class);
	}

	@Override
	public Validator<? super Correlation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Correlation>create(CorrelationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Correlation> validator() {
		return new CorrelationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Correlation> typeFormatValidator() {
		return new CorrelationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Correlation, Set<String>> onlyExistsValidator() {
		return new CorrelationOnlyExistsValidator();
	}
}
