package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.validation.MoneyTypeFormatValidator;
import fpml.consolidated.shared.validation.MoneyValidator;
import fpml.consolidated.shared.validation.exists.MoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Money.class)
public class MoneyMeta implements RosettaMetaData<Money> {

	@Override
	public List<Validator<? super Money>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Money, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Money> validator(ValidatorFactory factory) {
		return factory.<Money>create(MoneyValidator.class);
	}

	@Override
	public Validator<? super Money> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Money>create(MoneyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Money> validator() {
		return new MoneyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Money> typeFormatValidator() {
		return new MoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Money, Set<String>> onlyExistsValidator() {
		return new MoneyOnlyExistsValidator();
	}
}
