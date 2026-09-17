package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import fpml.consolidated.fx.validation.FxAverageRateObservationScheduleTypeFormatValidator;
import fpml.consolidated.fx.validation.FxAverageRateObservationScheduleValidator;
import fpml.consolidated.fx.validation.exists.FxAverageRateObservationScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAverageRateObservationSchedule.class)
public class FxAverageRateObservationScheduleMeta implements RosettaMetaData<FxAverageRateObservationSchedule> {

	@Override
	public List<Validator<? super FxAverageRateObservationSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAverageRateObservationSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAverageRateObservationSchedule> validator(ValidatorFactory factory) {
		return factory.<FxAverageRateObservationSchedule>create(FxAverageRateObservationScheduleValidator.class);
	}

	@Override
	public Validator<? super FxAverageRateObservationSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAverageRateObservationSchedule>create(FxAverageRateObservationScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageRateObservationSchedule> validator() {
		return new FxAverageRateObservationScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageRateObservationSchedule> typeFormatValidator() {
		return new FxAverageRateObservationScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageRateObservationSchedule, Set<String>> onlyExistsValidator() {
		return new FxAverageRateObservationScheduleOnlyExistsValidator();
	}
}
