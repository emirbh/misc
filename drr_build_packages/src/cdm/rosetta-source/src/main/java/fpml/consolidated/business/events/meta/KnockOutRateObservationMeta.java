package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.KnockOutRateObservation;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.business.events.validation.KnockOutRateObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.KnockOutRateObservationValidator;
import fpml.consolidated.business.events.validation.datarule.TriggerRateObservationChoice;
import fpml.consolidated.business.events.validation.exists.KnockOutRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KnockOutRateObservation.class)
public class KnockOutRateObservationMeta implements RosettaMetaData<KnockOutRateObservation> {

	@Override
	public List<Validator<? super KnockOutRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TriggerRateObservation>create(TriggerRateObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KnockOutRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KnockOutRateObservation> validator(ValidatorFactory factory) {
		return factory.<KnockOutRateObservation>create(KnockOutRateObservationValidator.class);
	}

	@Override
	public Validator<? super KnockOutRateObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KnockOutRateObservation>create(KnockOutRateObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KnockOutRateObservation> validator() {
		return new KnockOutRateObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KnockOutRateObservation> typeFormatValidator() {
		return new KnockOutRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KnockOutRateObservation, Set<String>> onlyExistsValidator() {
		return new KnockOutRateObservationOnlyExistsValidator();
	}
}
