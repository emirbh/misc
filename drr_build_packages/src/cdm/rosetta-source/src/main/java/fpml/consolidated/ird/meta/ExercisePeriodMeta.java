package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ExercisePeriod;
import fpml.consolidated.ird.validation.ExercisePeriodTypeFormatValidator;
import fpml.consolidated.ird.validation.ExercisePeriodValidator;
import fpml.consolidated.ird.validation.exists.ExercisePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExercisePeriod.class)
public class ExercisePeriodMeta implements RosettaMetaData<ExercisePeriod> {

	@Override
	public List<Validator<? super ExercisePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExercisePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExercisePeriod> validator(ValidatorFactory factory) {
		return factory.<ExercisePeriod>create(ExercisePeriodValidator.class);
	}

	@Override
	public Validator<? super ExercisePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExercisePeriod>create(ExercisePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExercisePeriod> validator() {
		return new ExercisePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExercisePeriod> typeFormatValidator() {
		return new ExercisePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExercisePeriod, Set<String>> onlyExistsValidator() {
		return new ExercisePeriodOnlyExistsValidator();
	}
}
