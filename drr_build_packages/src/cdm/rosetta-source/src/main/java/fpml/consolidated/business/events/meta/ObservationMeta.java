package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.Observation;
import fpml.consolidated.business.events.validation.ObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.ObservationValidator;
import fpml.consolidated.business.events.validation.exists.ObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Observation.class)
public class ObservationMeta implements RosettaMetaData<Observation> {

	@Override
	public List<Validator<? super Observation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Observation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Observation> validator(ValidatorFactory factory) {
		return factory.<Observation>create(ObservationValidator.class);
	}

	@Override
	public Validator<? super Observation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Observation>create(ObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Observation> validator() {
		return new ObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Observation> typeFormatValidator() {
		return new ObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Observation, Set<String>> onlyExistsValidator() {
		return new ObservationOnlyExistsValidator();
	}
}
