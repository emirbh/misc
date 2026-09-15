package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FallbackRateObservation;
import fpml.consolidated.shared.validation.FallbackRateObservationTypeFormatValidator;
import fpml.consolidated.shared.validation.FallbackRateObservationValidator;
import fpml.consolidated.shared.validation.exists.FallbackRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FallbackRateObservation.class)
public class FallbackRateObservationMeta implements RosettaMetaData<FallbackRateObservation> {

	@Override
	public List<Validator<? super FallbackRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FallbackRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FallbackRateObservation> validator(ValidatorFactory factory) {
		return factory.<FallbackRateObservation>create(FallbackRateObservationValidator.class);
	}

	@Override
	public Validator<? super FallbackRateObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FallbackRateObservation>create(FallbackRateObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FallbackRateObservation> validator() {
		return new FallbackRateObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FallbackRateObservation> typeFormatValidator() {
		return new FallbackRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FallbackRateObservation, Set<String>> onlyExistsValidator() {
		return new FallbackRateObservationOnlyExistsValidator();
	}
}
