package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMultipleExercise;
import fpml.consolidated.com.validation.CommodityMultipleExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMultipleExerciseValidator;
import fpml.consolidated.com.validation.exists.CommodityMultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMultipleExercise.class)
public class CommodityMultipleExerciseMeta implements RosettaMetaData<CommodityMultipleExercise> {

	@Override
	public List<Validator<? super CommodityMultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMultipleExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityMultipleExercise>create(CommodityMultipleExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityMultipleExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMultipleExercise>create(CommodityMultipleExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMultipleExercise> validator() {
		return new CommodityMultipleExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMultipleExercise> typeFormatValidator() {
		return new CommodityMultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMultipleExercise, Set<String>> onlyExistsValidator() {
		return new CommodityMultipleExerciseOnlyExistsValidator();
	}
}
