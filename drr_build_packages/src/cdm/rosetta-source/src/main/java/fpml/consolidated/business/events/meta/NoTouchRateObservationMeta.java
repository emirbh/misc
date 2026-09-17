package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.NoTouchRateObservation;
import fpml.consolidated.business.events.validation.NoTouchRateObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.NoTouchRateObservationValidator;
import fpml.consolidated.business.events.validation.datarule.NoTouchRateObservationChoice0;
import fpml.consolidated.business.events.validation.datarule.NoTouchRateObservationChoice1;
import fpml.consolidated.business.events.validation.exists.NoTouchRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NoTouchRateObservation.class)
public class NoTouchRateObservationMeta implements RosettaMetaData<NoTouchRateObservation> {

	@Override
	public List<Validator<? super NoTouchRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NoTouchRateObservation>create(NoTouchRateObservationChoice0.class),
			factory.<NoTouchRateObservation>create(NoTouchRateObservationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NoTouchRateObservation> validator(ValidatorFactory factory) {
		return factory.<NoTouchRateObservation>create(NoTouchRateObservationValidator.class);
	}

	@Override
	public Validator<? super NoTouchRateObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NoTouchRateObservation>create(NoTouchRateObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchRateObservation> validator() {
		return new NoTouchRateObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchRateObservation> typeFormatValidator() {
		return new NoTouchRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchRateObservation, Set<String>> onlyExistsValidator() {
		return new NoTouchRateObservationOnlyExistsValidator();
	}
}
