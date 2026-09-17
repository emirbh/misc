package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.validation.PositiveMoneyTypeFormatValidator;
import fpml.consolidated.shared.validation.PositiveMoneyValidator;
import fpml.consolidated.shared.validation.exists.PositiveMoneyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PositiveMoney.class)
public class PositiveMoneyMeta implements RosettaMetaData<PositiveMoney> {

	@Override
	public List<Validator<? super PositiveMoney>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PositiveMoney, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PositiveMoney> validator(ValidatorFactory factory) {
		return factory.<PositiveMoney>create(PositiveMoneyValidator.class);
	}

	@Override
	public Validator<? super PositiveMoney> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PositiveMoney>create(PositiveMoneyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PositiveMoney> validator() {
		return new PositiveMoneyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PositiveMoney> typeFormatValidator() {
		return new PositiveMoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PositiveMoney, Set<String>> onlyExistsValidator() {
		return new PositiveMoneyOnlyExistsValidator();
	}
}
