package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.validation.NonNegativeMoneyTypeFormatValidator;
import fpml.consolidated.shared.validation.NonNegativeMoneyValidator;
import fpml.consolidated.shared.validation.exists.NonNegativeMoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonNegativeMoney.class)
public class NonNegativeMoneyMeta implements RosettaMetaData<NonNegativeMoney> {

	@Override
	public List<Validator<? super NonNegativeMoney>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeMoney, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeMoney> validator(ValidatorFactory factory) {
		return factory.<NonNegativeMoney>create(NonNegativeMoneyValidator.class);
	}

	@Override
	public Validator<? super NonNegativeMoney> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeMoney>create(NonNegativeMoneyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeMoney> validator() {
		return new NonNegativeMoneyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeMoney> typeFormatValidator() {
		return new NonNegativeMoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeMoney, Set<String>> onlyExistsValidator() {
		return new NonNegativeMoneyOnlyExistsValidator();
	}
}
