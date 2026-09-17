package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.validation.CommodityPhysicalExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalExerciseChoice;
import fpml.consolidated.com.validation.exists.CommodityPhysicalExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalExercise.class)
public class CommodityPhysicalExerciseMeta implements RosettaMetaData<CommodityPhysicalExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalExercise>create(CommodityPhysicalExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalExercise>create(CommodityPhysicalExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalExercise>create(CommodityPhysicalExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalExercise> validator() {
		return new CommodityPhysicalExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalExercise> typeFormatValidator() {
		return new CommodityPhysicalExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalExerciseOnlyExistsValidator();
	}
}
