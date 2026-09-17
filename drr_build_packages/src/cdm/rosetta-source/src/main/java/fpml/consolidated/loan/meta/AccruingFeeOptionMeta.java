package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingFeeOption;
import fpml.consolidated.loan.validation.AccruingFeeOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingFeeOptionValidator;
import fpml.consolidated.loan.validation.exists.AccruingFeeOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingFeeOption.class)
public class AccruingFeeOptionMeta implements RosettaMetaData<AccruingFeeOption> {

	@Override
	public List<Validator<? super AccruingFeeOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingFeeOption> validator(ValidatorFactory factory) {
		return factory.<AccruingFeeOption>create(AccruingFeeOptionValidator.class);
	}

	@Override
	public Validator<? super AccruingFeeOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingFeeOption>create(AccruingFeeOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeOption> validator() {
		return new AccruingFeeOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeOption> typeFormatValidator() {
		return new AccruingFeeOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeOption, Set<String>> onlyExistsValidator() {
		return new AccruingFeeOptionOnlyExistsValidator();
	}
}
