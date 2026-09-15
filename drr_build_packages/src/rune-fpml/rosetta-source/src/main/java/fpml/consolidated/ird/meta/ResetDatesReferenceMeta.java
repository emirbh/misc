package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ResetDatesReference;
import fpml.consolidated.ird.validation.ResetDatesReferenceTypeFormatValidator;
import fpml.consolidated.ird.validation.ResetDatesReferenceValidator;
import fpml.consolidated.ird.validation.exists.ResetDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetDatesReference.class)
public class ResetDatesReferenceMeta implements RosettaMetaData<ResetDatesReference> {

	@Override
	public List<Validator<? super ResetDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetDatesReference> validator(ValidatorFactory factory) {
		return factory.<ResetDatesReference>create(ResetDatesReferenceValidator.class);
	}

	@Override
	public Validator<? super ResetDatesReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetDatesReference>create(ResetDatesReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetDatesReference> validator() {
		return new ResetDatesReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetDatesReference> typeFormatValidator() {
		return new ResetDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetDatesReference, Set<String>> onlyExistsValidator() {
		return new ResetDatesReferenceOnlyExistsValidator();
	}
}
