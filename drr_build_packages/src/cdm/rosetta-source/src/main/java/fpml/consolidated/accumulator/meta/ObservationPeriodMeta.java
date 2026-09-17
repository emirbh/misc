package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.ObservationPeriod;
import fpml.consolidated.accumulator.validation.ObservationPeriodTypeFormatValidator;
import fpml.consolidated.accumulator.validation.ObservationPeriodValidator;
import fpml.consolidated.accumulator.validation.exists.ObservationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationPeriod.class)
public class ObservationPeriodMeta implements RosettaMetaData<ObservationPeriod> {

	@Override
	public List<Validator<? super ObservationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationPeriod> validator(ValidatorFactory factory) {
		return factory.<ObservationPeriod>create(ObservationPeriodValidator.class);
	}

	@Override
	public Validator<? super ObservationPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationPeriod>create(ObservationPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationPeriod> validator() {
		return new ObservationPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationPeriod> typeFormatValidator() {
		return new ObservationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationPeriod, Set<String>> onlyExistsValidator() {
		return new ObservationPeriodOnlyExistsValidator();
	}
}
