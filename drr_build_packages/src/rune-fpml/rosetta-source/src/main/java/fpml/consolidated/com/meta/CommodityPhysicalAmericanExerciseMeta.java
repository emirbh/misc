package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.validation.CommodityPhysicalAmericanExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalAmericanExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalAmericanExerciseChoice;
import fpml.consolidated.com.validation.exists.CommodityPhysicalAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalAmericanExercise.class)
public class CommodityPhysicalAmericanExerciseMeta implements RosettaMetaData<CommodityPhysicalAmericanExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalAmericanExercise>create(CommodityPhysicalAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalAmericanExercise>create(CommodityPhysicalAmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalAmericanExercise>create(CommodityPhysicalAmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> validator() {
		return new CommodityPhysicalAmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> typeFormatValidator() {
		return new CommodityPhysicalAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalAmericanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalAmericanExerciseOnlyExistsValidator();
	}
}
