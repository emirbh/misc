package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyValuationAgent;
import cdm.legaldocumentation.csa.validation.LegacyValuationAgentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyValuationAgentValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyValuationAgentAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.exists.LegacyValuationAgentOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=LegacyValuationAgent.class)
public class LegacyValuationAgentMeta implements RosettaMetaData<LegacyValuationAgent> {

	@Override
	public List<Validator<? super LegacyValuationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyValuationAgent>create(LegacyValuationAgentAdditionalLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyValuationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyValuationAgent> validator(ValidatorFactory factory) {
		return factory.<LegacyValuationAgent>create(LegacyValuationAgentValidator.class);
	}

	@Override
	public Validator<? super LegacyValuationAgent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyValuationAgent>create(LegacyValuationAgentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationAgent> validator() {
		return new LegacyValuationAgentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationAgent> typeFormatValidator() {
		return new LegacyValuationAgentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyValuationAgent, Set<String>> onlyExistsValidator() {
		return new LegacyValuationAgentOnlyExistsValidator();
	}
}
