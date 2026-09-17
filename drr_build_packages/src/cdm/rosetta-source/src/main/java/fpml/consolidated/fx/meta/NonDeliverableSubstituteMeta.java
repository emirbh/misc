package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.NonDeliverableSubstitute;
import fpml.consolidated.fx.validation.NonDeliverableSubstituteTypeFormatValidator;
import fpml.consolidated.fx.validation.NonDeliverableSubstituteValidator;
import fpml.consolidated.fx.validation.exists.NonDeliverableSubstituteOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
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
