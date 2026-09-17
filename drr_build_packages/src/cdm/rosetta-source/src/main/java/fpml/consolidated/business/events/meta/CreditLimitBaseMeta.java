package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitBase;
import fpml.consolidated.business.events.validation.CreditLimitBaseTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditLimitBaseValidator;
import fpml.consolidated.business.events.validation.exists.CreditLimitBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditLimitBase.class)
public class CreditLimitBaseMeta implements RosettaMetaData<CreditLimitBase> {

	@Override
	public List<Validator<? super CreditLimitBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditLimitBase> validator(ValidatorFactory factory) {
		return factory.<CreditLimitBase>create(CreditLimitBaseValidator.class);
	}

	@Override
	public Validator<? super CreditLimitBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditLimitBase>create(CreditLimitBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitBase> validator() {
		return new CreditLimitBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitBase> typeFormatValidator() {
		return new CreditLimitBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitBase, Set<String>> onlyExistsValidator() {
		return new CreditLimitBaseOnlyExistsValidator();
	}
}
