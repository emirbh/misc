package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MoneyBase;
import fpml.consolidated.shared.validation.MoneyBaseTypeFormatValidator;
import fpml.consolidated.shared.validation.MoneyBaseValidator;
import fpml.consolidated.shared.validation.exists.MoneyBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MoneyBase.class)
public class MoneyBaseMeta implements RosettaMetaData<MoneyBase> {

	@Override
	public List<Validator<? super MoneyBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MoneyBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MoneyBase> validator(ValidatorFactory factory) {
		return factory.<MoneyBase>create(MoneyBaseValidator.class);
	}

	@Override
	public Validator<? super MoneyBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MoneyBase>create(MoneyBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MoneyBase> validator() {
		return new MoneyBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MoneyBase> typeFormatValidator() {
		return new MoneyBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MoneyBase, Set<String>> onlyExistsValidator() {
		return new MoneyBaseOnlyExistsValidator();
	}
}
