package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ReferenceLevelUnit;
import fpml.consolidated.com.validation.ReferenceLevelUnitTypeFormatValidator;
import fpml.consolidated.com.validation.ReferenceLevelUnitValidator;
import fpml.consolidated.com.validation.exists.ReferenceLevelUnitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceLevelUnit.class)
public class ReferenceLevelUnitMeta implements RosettaMetaData<ReferenceLevelUnit> {

	@Override
	public List<Validator<? super ReferenceLevelUnit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceLevelUnit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceLevelUnit> validator(ValidatorFactory factory) {
		return factory.<ReferenceLevelUnit>create(ReferenceLevelUnitValidator.class);
	}

	@Override
	public Validator<? super ReferenceLevelUnit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceLevelUnit>create(ReferenceLevelUnitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceLevelUnit> validator() {
		return new ReferenceLevelUnitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceLevelUnit> typeFormatValidator() {
		return new ReferenceLevelUnitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceLevelUnit, Set<String>> onlyExistsValidator() {
		return new ReferenceLevelUnitOnlyExistsValidator();
	}
}
