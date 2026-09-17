package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.validation.ReplacementValueTypeFormatValidator;
import fpml.consolidated.ird.validation.ReplacementValueValidator;
import fpml.consolidated.ird.validation.datarule.ReplacementValueChoice;
import fpml.consolidated.ird.validation.exists.ReplacementValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReplacementValue.class)
public class ReplacementValueMeta implements RosettaMetaData<ReplacementValue> {

	@Override
	public List<Validator<? super ReplacementValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReplacementValue>create(ReplacementValueChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReplacementValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReplacementValue> validator(ValidatorFactory factory) {
		return factory.<ReplacementValue>create(ReplacementValueValidator.class);
	}

	@Override
	public Validator<? super ReplacementValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReplacementValue>create(ReplacementValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValue> validator() {
		return new ReplacementValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValue> typeFormatValidator() {
		return new ReplacementValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReplacementValue, Set<String>> onlyExistsValidator() {
		return new ReplacementValueOnlyExistsValidator();
	}
}
