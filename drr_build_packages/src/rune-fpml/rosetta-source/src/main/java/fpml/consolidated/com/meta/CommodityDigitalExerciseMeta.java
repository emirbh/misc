package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDigitalExercise;
import fpml.consolidated.com.validation.CommodityDigitalExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDigitalExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityDigitalExerciseChoice0;
import fpml.consolidated.com.validation.datarule.CommodityDigitalExerciseChoice1;
import fpml.consolidated.com.validation.exists.CommodityDigitalExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDigitalExercise.class)
public class CommodityDigitalExerciseMeta implements RosettaMetaData<CommodityDigitalExercise> {

	@Override
	public List<Validator<? super CommodityDigitalExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityDigitalExercise>create(CommodityDigitalExerciseChoice0.class),
			factory.<CommodityDigitalExercise>create(CommodityDigitalExerciseChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDigitalExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityDigitalExercise>create(CommodityDigitalExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityDigitalExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDigitalExercise>create(CommodityDigitalExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigitalExercise> validator() {
		return new CommodityDigitalExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigitalExercise> typeFormatValidator() {
		return new CommodityDigitalExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalExercise, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalExerciseOnlyExistsValidator();
	}
}
