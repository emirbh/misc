package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.NoTouchUpperBarrierObservation;
import fpml.consolidated.business.events.validation.NoTouchUpperBarrierObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.NoTouchUpperBarrierObservationValidator;
import fpml.consolidated.business.events.validation.datarule.NoTouchUpperBarrierObservationChoice;
import fpml.consolidated.business.events.validation.exists.NoTouchUpperBarrierObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NoTouchUpperBarrierObservation.class)
public class NoTouchUpperBarrierObservationMeta implements RosettaMetaData<NoTouchUpperBarrierObservation> {

	@Override
	public List<Validator<? super NoTouchUpperBarrierObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NoTouchUpperBarrierObservation>create(NoTouchUpperBarrierObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NoTouchUpperBarrierObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NoTouchUpperBarrierObservation> validator(ValidatorFactory factory) {
		return factory.<NoTouchUpperBarrierObservation>create(NoTouchUpperBarrierObservationValidator.class);
	}

	@Override
	public Validator<? super NoTouchUpperBarrierObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NoTouchUpperBarrierObservation>create(NoTouchUpperBarrierObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchUpperBarrierObservation> validator() {
		return new NoTouchUpperBarrierObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NoTouchUpperBarrierObservation> typeFormatValidator() {
		return new NoTouchUpperBarrierObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoTouchUpperBarrierObservation, Set<String>> onlyExistsValidator() {
		return new NoTouchUpperBarrierObservationOnlyExistsValidator();
	}
}
