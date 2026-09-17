package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OrganizationIdentifier;
import fpml.consolidated.shared.validation.OrganizationIdentifierTypeFormatValidator;
import fpml.consolidated.shared.validation.OrganizationIdentifierValidator;
import fpml.consolidated.shared.validation.exists.OrganizationIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OrganizationIdentifier.class)
public class OrganizationIdentifierMeta implements RosettaMetaData<OrganizationIdentifier> {

	@Override
	public List<Validator<? super OrganizationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganizationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganizationIdentifier> validator(ValidatorFactory factory) {
		return factory.<OrganizationIdentifier>create(OrganizationIdentifierValidator.class);
	}

	@Override
	public Validator<? super OrganizationIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganizationIdentifier>create(OrganizationIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganizationIdentifier> validator() {
		return new OrganizationIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganizationIdentifier> typeFormatValidator() {
		return new OrganizationIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganizationIdentifier, Set<String>> onlyExistsValidator() {
		return new OrganizationIdentifierOnlyExistsValidator();
	}
}
