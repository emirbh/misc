package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.WeightedAveragingObservation;
import cdm.product.common.schedule.validation.WeightedAveragingObservationTypeFormatValidator;
import cdm.product.common.schedule.validation.WeightedAveragingObservationValidator;
import cdm.product.common.schedule.validation.datarule.WeightedAveragingObservationPositiveObservationNumber;
import cdm.product.common.schedule.validation.datarule.WeightedAveragingObservationPositiveWeight;
import cdm.product.common.schedule.validation.datarule.WeightedAveragingObservationWeightedAveragingObservationChoice;
import cdm.product.common.schedule.validation.exists.WeightedAveragingObservationOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=WeightedAveragingObservation.class)
public class WeightedAveragingObservationMeta implements RosettaMetaData<WeightedAveragingObservation> {

	@Override
	public List<Validator<? super WeightedAveragingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<WeightedAveragingObservation>create(WeightedAveragingObservationWeightedAveragingObservationChoice.class),
			factory.<WeightedAveragingObservation>create(WeightedAveragingObservationPositiveObservationNumber.class),
			factory.<WeightedAveragingObservation>create(WeightedAveragingObservationPositiveWeight.class)
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
