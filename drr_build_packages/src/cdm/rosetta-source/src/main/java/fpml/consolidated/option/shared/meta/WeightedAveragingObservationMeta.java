package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.WeightedAveragingObservation;
import fpml.consolidated.option.shared.validation.WeightedAveragingObservationTypeFormatValidator;
import fpml.consolidated.option.shared.validation.WeightedAveragingObservationValidator;
import fpml.consolidated.option.shared.validation.datarule.WeightedAveragingObservationChoice;
import fpml.consolidated.option.shared.validation.exists.WeightedAveragingObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeightedAveragingObservation.class)
public class WeightedAveragingObservationMeta implements RosettaMetaData<WeightedAveragingObservation> {

	@Override
	public List<Validator<? super WeightedAveragingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<WeightedAveragingObservation>create(WeightedAveragingObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeightedAveragingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeightedAveragingObservation> validator(ValidatorFactory factory) {
		return factory.<WeightedAveragingObservation>create(WeightedAveragingObservationValidator.class);
	}

	@Override
	public Validator<? super WeightedAveragingObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeightedAveragingObservation>create(WeightedAveragingObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeightedAveragingObservation> validator() {
		return new WeightedAveragingObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeightedAveragingObservation> typeFormatValidator() {
		return new WeightedAveragingObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeightedAveragingObservation, Set<String>> onlyExistsValidator() {
		return new WeightedAveragingObservationOnlyExistsValidator();
	}
}
