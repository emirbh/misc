package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegalActionIdentifier;
import fpml.consolidated.loan.validation.LegalActionIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.LegalActionIdentifierValidator;
import fpml.consolidated.loan.validation.datarule.LegalActionIdentifierChoice;
import fpml.consolidated.loan.validation.exists.LegalActionIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegalActionIdentifier.class)
public class LegalActionIdentifierMeta implements RosettaMetaData<LegalActionIdentifier> {

	@Override
	public List<Validator<? super LegalActionIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegalActionIdentifier>create(LegalActionIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LegalActionIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalActionIdentifier> validator(ValidatorFactory factory) {
		return factory.<LegalActionIdentifier>create(LegalActionIdentifierValidator.class);
	}

	@Override
	public Validator<? super LegalActionIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalActionIdentifier>create(LegalActionIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalActionIdentifier> validator() {
		return new LegalActionIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalActionIdentifier> typeFormatValidator() {
		return new LegalActionIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalActionIdentifier, Set<String>> onlyExistsValidator() {
		return new LegalActionIdentifierOnlyExistsValidator();
	}
}
