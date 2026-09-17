package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralValuationAgent;
import cdm.legaldocumentation.csa.validation.CollateralValuationAgentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralValuationAgentValidator;
import cdm.legaldocumentation.csa.validation.exists.CollateralValuationAgentOnlyExistsValidator;
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
@RosettaMeta(model=CollateralValuationAgent.class)
public class CollateralValuationAgentMeta implements RosettaMetaData<CollateralValuationAgent> {

	@Override
	public List<Validator<? super CollateralValuationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralValuationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValuationAgent> validator(ValidatorFactory factory) {
		return factory.<CollateralValuationAgent>create(CollateralValuationAgentValidator.class);
	}

	@Override
	public Validator<? super CollateralValuationAgent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralValuationAgent>create(CollateralValuationAgentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuationAgent> validator() {
		return new CollateralValuationAgentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuationAgent> typeFormatValidator() {
		return new CollateralValuationAgentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuationAgent, Set<String>> onlyExistsValidator() {
		return new CollateralValuationAgentOnlyExistsValidator();
	}
}
