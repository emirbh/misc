package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.validation.CommodityExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityExerciseChoice0;
import fpml.consolidated.com.validation.datarule.CommodityExerciseChoice1;
import fpml.consolidated.com.validation.exists.CommodityExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityExercise.class)
public class CommodityExerciseMeta implements RosettaMetaData<CommodityExercise> {

	@Override
	public List<Validator<? super CommodityExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityExercise>create(CommodityExerciseChoice0.class),
			factory.<CommodityExercise>create(CommodityExerciseChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityExercise>create(CommodityExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityExercise>create(CommodityExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExercise> validator() {
		return new CommodityExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExercise> typeFormatValidator() {
		return new CommodityExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExercise, Set<String>> onlyExistsValidator() {
		return new CommodityExerciseOnlyExistsValidator();
	}
}
