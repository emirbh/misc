package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PaymentRule;
import fpml.consolidated.shared.validation.PaymentRuleTypeFormatValidator;
import fpml.consolidated.shared.validation.PaymentRuleValidator;
import fpml.consolidated.shared.validation.exists.PaymentRuleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentRule.class)
public class PaymentRuleMeta implements RosettaMetaData<PaymentRule> {

	@Override
	public List<Validator<? super PaymentRule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentRule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentRule> validator(ValidatorFactory factory) {
		return factory.<PaymentRule>create(PaymentRuleValidator.class);
	}

	@Override
	public Validator<? super PaymentRule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentRule>create(PaymentRuleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentRule> validator() {
		return new PaymentRuleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentRule> typeFormatValidator() {
		return new PaymentRuleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentRule, Set<String>> onlyExistsValidator() {
		return new PaymentRuleOnlyExistsValidator();
	}
}
