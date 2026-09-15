package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.validation.CovenantObligationIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.CovenantObligationIdentifierValidator;
import fpml.consolidated.loan.validation.datarule.CovenantObligationIdentifierChoice;
import fpml.consolidated.loan.validation.exists.CovenantObligationIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CovenantObligationIdentifier.class)
public class CovenantObligationIdentifierMeta implements RosettaMetaData<CovenantObligationIdentifier> {

	@Override
	public List<Validator<? super CovenantObligationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CovenantObligationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CovenantObligationIdentifier> validator(ValidatorFactory factory) {
		return factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierValidator.class);
	}

	@Override
	public Validator<? super CovenantObligationIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationIdentifier> validator() {
		return new CovenantObligationIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationIdentifier> typeFormatValidator() {
		return new CovenantObligationIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CovenantObligationIdentifier, Set<String>> onlyExistsValidator() {
		return new CovenantObligationIdentifierOnlyExistsValidator();
	}
}
