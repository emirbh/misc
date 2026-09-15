package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.NoTouchLowerBarrierObservation;
import fpml.consolidated.business.events.validation.NoTouchLowerBarrierObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.NoTouchLowerBarrierObservationValidator;
import fpml.consolidated.business.events.validation.datarule.NoTouchLowerBarrierObservationChoice;
import fpml.consolidated.business.events.validation.exists.NoTouchLowerBarrierObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NoTouchLowerBarrierObservation.class)
public class NoTouchLowerBarrierObservationMeta implements RosettaMetaData<NoTouchLowerBarrierObservation> {

	@Override
	public List<Validator<? super NoTouchLowerBarrierObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NoTouchLowerBarrierObservation>create(NoTouchLowerBarrierObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchLowerBarrierObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NoTouchLowerBarrierObservation> validator(ValidatorFactory factory) {
		return factory.<NoTouchLowerBarrierObservation>create(NoTouchLowerBarrierObservationValidator.class);
	}

	@Override
	public Validator<? super NoTouchLowerBarrierObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NoTouchLowerBarrierObservation>create(NoTouchLowerBarrierObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchLowerBarrierObservation> validator() {
		return new NoTouchLowerBarrierObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchLowerBarrierObservation> typeFormatValidator() {
		return new NoTouchLowerBarrierObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchLowerBarrierObservation, Set<String>> onlyExistsValidator() {
		return new NoTouchLowerBarrierObservationOnlyExistsValidator();
	}
}
