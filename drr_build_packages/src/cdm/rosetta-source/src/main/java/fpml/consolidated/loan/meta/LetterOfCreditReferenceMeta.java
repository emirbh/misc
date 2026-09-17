package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.validation.LetterOfCreditReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LetterOfCreditReferenceValidator;
import fpml.consolidated.loan.validation.exists.LetterOfCreditReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LetterOfCreditReference.class)
public class LetterOfCreditReferenceMeta implements RosettaMetaData<LetterOfCreditReference> {

	@Override
	public List<Validator<? super LetterOfCreditReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LetterOfCreditReference> validator(ValidatorFactory factory) {
		return factory.<LetterOfCreditReference>create(LetterOfCreditReferenceValidator.class);
	}

	@Override
	public Validator<? super LetterOfCreditReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LetterOfCreditReference>create(LetterOfCreditReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditReference> validator() {
		return new LetterOfCreditReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditReference> typeFormatValidator() {
		return new LetterOfCreditReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditReference, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditReferenceOnlyExistsValidator();
	}
}
