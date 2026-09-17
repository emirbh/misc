package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.validation.NotionalAmountTypeFormatValidator;
import fpml.consolidated.shared.validation.NotionalAmountValidator;
import fpml.consolidated.shared.validation.exists.NotionalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotionalAmount.class)
public class NotionalAmountMeta implements RosettaMetaData<NotionalAmount> {

	@Override
	public List<Validator<? super NotionalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalAmount> validator(ValidatorFactory factory) {
		return factory.<NotionalAmount>create(NotionalAmountValidator.class);
	}

	@Override
	public Validator<? super NotionalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalAmount>create(NotionalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount> validator() {
		return new NotionalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmount> typeFormatValidator() {
		return new NotionalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmount, Set<String>> onlyExistsValidator() {
		return new NotionalAmountOnlyExistsValidator();
	}
}
