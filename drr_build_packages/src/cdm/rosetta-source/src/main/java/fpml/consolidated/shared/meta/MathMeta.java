package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.validation.MathTypeFormatValidator;
import fpml.consolidated.shared.validation.MathValidator;
import fpml.consolidated.shared.validation.exists.MathOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=fpml.consolidated.shared.Math.class)
public class MathMeta implements RosettaMetaData<fpml.consolidated.shared.Math> {

	@Override
	public List<Validator<? super fpml.consolidated.shared.Math>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super fpml.consolidated.shared.Math, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super fpml.consolidated.shared.Math> validator(ValidatorFactory factory) {
		return factory.<fpml.consolidated.shared.Math>create(MathValidator.class);
	}

	@Override
	public Validator<? super fpml.consolidated.shared.Math> typeFormatValidator(ValidatorFactory factory) {
		return factory.<fpml.consolidated.shared.Math>create(MathTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super fpml.consolidated.shared.Math> validator() {
		return new MathValidator();
	}

	@Deprecated
	@Override
	public Validator<? super fpml.consolidated.shared.Math> typeFormatValidator() {
		return new MathTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super fpml.consolidated.shared.Math, Set<String>> onlyExistsValidator() {
		return new MathOnlyExistsValidator();
	}
}
