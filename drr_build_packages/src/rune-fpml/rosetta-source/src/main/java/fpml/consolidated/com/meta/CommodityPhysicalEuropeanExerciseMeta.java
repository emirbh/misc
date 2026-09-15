package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.com.validation.CommodityPhysicalEuropeanExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPhysicalEuropeanExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityPhysicalEuropeanExerciseChoice;
import fpml.consolidated.com.validation.exists.CommodityPhysicalEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPhysicalEuropeanExercise.class)
public class CommodityPhysicalEuropeanExerciseMeta implements RosettaMetaData<CommodityPhysicalEuropeanExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPhysicalEuropeanExercise>create(CommodityPhysicalEuropeanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalEuropeanExercise>create(CommodityPhysicalEuropeanExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPhysicalEuropeanExercise>create(CommodityPhysicalEuropeanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> validator() {
		return new CommodityPhysicalEuropeanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> typeFormatValidator() {
		return new CommodityPhysicalEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalEuropeanExerciseOnlyExistsValidator();
	}
}
