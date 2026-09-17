package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.legaldocumentation.transaction.additionalterms.validation.NonDeliverableSubstituteTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.NonDeliverableSubstituteValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.NonDeliverableSubstituteOnlyExistsValidator;
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
@RosettaMeta(model=NonDeliverableSubstitute.class)
public class NonDeliverableSubstituteMeta implements RosettaMetaData<NonDeliverableSubstitute> {

	@Override
	public List<Validator<? super NonDeliverableSubstitute>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonDeliverableSubstitute, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonDeliverableSubstitute> validator(ValidatorFactory factory) {
		return factory.<NonDeliverableSubstitute>create(NonDeliverableSubstituteValidator.class);
	}

	@Override
	public Validator<? super NonDeliverableSubstitute> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonDeliverableSubstitute>create(NonDeliverableSubstituteTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonDeliverableSubstitute> validator() {
		return new NonDeliverableSubstituteValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonDeliverableSubstitute> typeFormatValidator() {
		return new NonDeliverableSubstituteTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonDeliverableSubstitute, Set<String>> onlyExistsValidator() {
		return new NonDeliverableSubstituteOnlyExistsValidator();
	}
}
