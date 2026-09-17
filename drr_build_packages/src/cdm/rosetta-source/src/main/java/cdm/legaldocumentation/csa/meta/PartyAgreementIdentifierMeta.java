package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.PartyAgreementIdentifier;
import cdm.legaldocumentation.csa.validation.PartyAgreementIdentifierTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.PartyAgreementIdentifierValidator;
import cdm.legaldocumentation.csa.validation.exists.PartyAgreementIdentifierOnlyExistsValidator;
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
@RosettaMeta(model=PartyAgreementIdentifier.class)
public class PartyAgreementIdentifierMeta implements RosettaMetaData<PartyAgreementIdentifier> {

	@Override
	public List<Validator<? super PartyAgreementIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyAgreementIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyAgreementIdentifier> validator(ValidatorFactory factory) {
		return factory.<PartyAgreementIdentifier>create(PartyAgreementIdentifierValidator.class);
	}

	@Override
	public Validator<? super PartyAgreementIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyAgreementIdentifier>create(PartyAgreementIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyAgreementIdentifier> validator() {
		return new PartyAgreementIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyAgreementIdentifier> typeFormatValidator() {
		return new PartyAgreementIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyAgreementIdentifier, Set<String>> onlyExistsValidator() {
		return new PartyAgreementIdentifierOnlyExistsValidator();
	}
}
