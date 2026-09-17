package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityExercisePeriods;
import fpml.consolidated.com.validation.CommodityExercisePeriodsTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityExercisePeriodsValidator;
import fpml.consolidated.com.validation.exists.CommodityExercisePeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityExercisePeriods.class)
public class CommodityExercisePeriodsMeta implements RosettaMetaData<CommodityExercisePeriods> {

	@Override
	public List<Validator<? super CommodityExercisePeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityExercisePeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityExercisePeriods> validator(ValidatorFactory factory) {
		return factory.<CommodityExercisePeriods>create(CommodityExercisePeriodsValidator.class);
	}

	@Override
	public Validator<? super CommodityExercisePeriods> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityExercisePeriods>create(CommodityExercisePeriodsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExercisePeriods> validator() {
		return new CommodityExercisePeriodsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExercisePeriods> typeFormatValidator() {
		return new CommodityExercisePeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExercisePeriods, Set<String>> onlyExistsValidator() {
		return new CommodityExercisePeriodsOnlyExistsValidator();
	}
}
