package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PercentageRule;
import fpml.consolidated.doc.validation.PercentageRuleTypeFormatValidator;
import fpml.consolidated.doc.validation.PercentageRuleValidator;
import fpml.consolidated.doc.validation.exists.PercentageRuleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PercentageRule.class)
public class PercentageRuleMeta implements RosettaMetaData<PercentageRule> {

	@Override
	public List<Validator<? super PercentageRule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PercentageRule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PercentageRule> validator(ValidatorFactory factory) {
		return factory.<PercentageRule>create(PercentageRuleValidator.class);
	}

	@Override
	public Validator<? super PercentageRule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PercentageRule>create(PercentageRuleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PercentageRule> validator() {
		return new PercentageRuleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PercentageRule> typeFormatValidator() {
		return new PercentageRuleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PercentageRule, Set<String>> onlyExistsValidator() {
		return new PercentageRuleOnlyExistsValidator();
	}
}
