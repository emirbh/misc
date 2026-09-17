package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.AbsoluteTolerance;
import fpml.consolidated.com.validation.AbsoluteToleranceTypeFormatValidator;
import fpml.consolidated.com.validation.AbsoluteToleranceValidator;
import fpml.consolidated.com.validation.exists.AbsoluteToleranceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbsoluteTolerance.class)
public class AbsoluteToleranceMeta implements RosettaMetaData<AbsoluteTolerance> {

	@Override
	public List<Validator<? super AbsoluteTolerance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbsoluteTolerance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbsoluteTolerance> validator(ValidatorFactory factory) {
		return factory.<AbsoluteTolerance>create(AbsoluteToleranceValidator.class);
	}

	@Override
	public Validator<? super AbsoluteTolerance> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbsoluteTolerance>create(AbsoluteToleranceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbsoluteTolerance> validator() {
		return new AbsoluteToleranceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbsoluteTolerance> typeFormatValidator() {
		return new AbsoluteToleranceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbsoluteTolerance, Set<String>> onlyExistsValidator() {
		return new AbsoluteToleranceOnlyExistsValidator();
	}
}
