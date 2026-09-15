package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ContractIdentifier;
import fpml.consolidated.doc.validation.datarule.ContractIdentifierChoice;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.validation.LetterOfCreditTypeFormatValidator;
import fpml.consolidated.loan.validation.LetterOfCreditValidator;
import fpml.consolidated.loan.validation.exists.LetterOfCreditOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LetterOfCredit.class)
public class LetterOfCreditMeta implements RosettaMetaData<LetterOfCredit> {

	@Override
	public List<Validator<? super LetterOfCredit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractIdentifier>create(ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LetterOfCredit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LetterOfCredit> validator(ValidatorFactory factory) {
		return factory.<LetterOfCredit>create(LetterOfCreditValidator.class);
	}

	@Override
	public Validator<? super LetterOfCredit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LetterOfCredit>create(LetterOfCreditTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCredit> validator() {
		return new LetterOfCreditValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCredit> typeFormatValidator() {
		return new LetterOfCreditTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCredit, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditOnlyExistsValidator();
	}
}
