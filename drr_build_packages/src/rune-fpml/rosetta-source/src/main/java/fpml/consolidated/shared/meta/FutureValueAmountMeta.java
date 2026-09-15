package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.validation.FutureValueAmountTypeFormatValidator;
import fpml.consolidated.shared.validation.FutureValueAmountValidator;
import fpml.consolidated.shared.validation.exists.FutureValueAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FutureValueAmount.class)
public class FutureValueAmountMeta implements RosettaMetaData<FutureValueAmount> {

	@Override
	public List<Validator<? super FutureValueAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FutureValueAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FutureValueAmount> validator(ValidatorFactory factory) {
		return factory.<FutureValueAmount>create(FutureValueAmountValidator.class);
	}

	@Override
	public Validator<? super FutureValueAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FutureValueAmount>create(FutureValueAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FutureValueAmount> validator() {
		return new FutureValueAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FutureValueAmount> typeFormatValidator() {
		return new FutureValueAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FutureValueAmount, Set<String>> onlyExistsValidator() {
		return new FutureValueAmountOnlyExistsValidator();
	}
}
