package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ConditionsPrecedent;
import cdm.legaldocumentation.csa.validation.ConditionsPrecedentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ConditionsPrecedentValidator;
import cdm.legaldocumentation.csa.validation.datarule.ConditionsPrecedentCustomProvision;
import cdm.legaldocumentation.csa.validation.exists.ConditionsPrecedentOnlyExistsValidator;
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
@RosettaMeta(model=ConditionsPrecedent.class)
public class ConditionsPrecedentMeta implements RosettaMetaData<ConditionsPrecedent> {

	@Override
	public List<Validator<? super ConditionsPrecedent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConditionsPrecedent>create(ConditionsPrecedentCustomProvision.class)
		);
	}
	
	@Override
	public List<Function<? super ConditionsPrecedent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConditionsPrecedent> validator(ValidatorFactory factory) {
		return factory.<ConditionsPrecedent>create(ConditionsPrecedentValidator.class);
	}

	@Override
	public Validator<? super ConditionsPrecedent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConditionsPrecedent>create(ConditionsPrecedentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConditionsPrecedent> validator() {
		return new ConditionsPrecedentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConditionsPrecedent> typeFormatValidator() {
		return new ConditionsPrecedentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConditionsPrecedent, Set<String>> onlyExistsValidator() {
		return new ConditionsPrecedentOnlyExistsValidator();
	}
}
