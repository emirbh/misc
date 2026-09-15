package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.NotionalStepRule;
import fpml.consolidated.ird.validation.NotionalStepRuleTypeFormatValidator;
import fpml.consolidated.ird.validation.NotionalStepRuleValidator;
import fpml.consolidated.ird.validation.datarule.NotionalStepRuleChoice;
import fpml.consolidated.ird.validation.exists.NotionalStepRuleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotionalStepRule.class)
public class NotionalStepRuleMeta implements RosettaMetaData<NotionalStepRule> {

	@Override
	public List<Validator<? super NotionalStepRule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NotionalStepRule>create(NotionalStepRuleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NotionalStepRule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalStepRule> validator(ValidatorFactory factory) {
		return factory.<NotionalStepRule>create(NotionalStepRuleValidator.class);
	}

	@Override
	public Validator<? super NotionalStepRule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalStepRule>create(NotionalStepRuleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalStepRule> validator() {
		return new NotionalStepRuleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalStepRule> typeFormatValidator() {
		return new NotionalStepRuleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalStepRule, Set<String>> onlyExistsValidator() {
		return new NotionalStepRuleOnlyExistsValidator();
	}
}
