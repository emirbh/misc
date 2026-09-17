package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.RetrospectiveEffect;
import cdm.legaldocumentation.csa.validation.RetrospectiveEffectTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RetrospectiveEffectValidator;
import cdm.legaldocumentation.csa.validation.exists.RetrospectiveEffectOnlyExistsValidator;
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
@RosettaMeta(model=RetrospectiveEffect.class)
public class RetrospectiveEffectMeta implements RosettaMetaData<RetrospectiveEffect> {

	@Override
	public List<Validator<? super RetrospectiveEffect>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RetrospectiveEffect, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RetrospectiveEffect> validator(ValidatorFactory factory) {
		return factory.<RetrospectiveEffect>create(RetrospectiveEffectValidator.class);
	}

	@Override
	public Validator<? super RetrospectiveEffect> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RetrospectiveEffect>create(RetrospectiveEffectTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RetrospectiveEffect> validator() {
		return new RetrospectiveEffectValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RetrospectiveEffect> typeFormatValidator() {
		return new RetrospectiveEffectTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RetrospectiveEffect, Set<String>> onlyExistsValidator() {
		return new RetrospectiveEffectOnlyExistsValidator();
	}
}
