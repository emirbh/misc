package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import cdm.observable.asset.fro.validation.ContractualDefinitionIdentifierTypeFormatValidator;
import cdm.observable.asset.fro.validation.ContractualDefinitionIdentifierValidator;
import cdm.observable.asset.fro.validation.exists.ContractualDefinitionIdentifierOnlyExistsValidator;
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
@RosettaMeta(model=ContractualDefinitionIdentifier.class)
public class ContractualDefinitionIdentifierMeta implements RosettaMetaData<ContractualDefinitionIdentifier> {

	@Override
	public List<Validator<? super ContractualDefinitionIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualDefinitionIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualDefinitionIdentifier> validator(ValidatorFactory factory) {
		return factory.<ContractualDefinitionIdentifier>create(ContractualDefinitionIdentifierValidator.class);
	}

	@Override
	public Validator<? super ContractualDefinitionIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualDefinitionIdentifier>create(ContractualDefinitionIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinitionIdentifier> validator() {
		return new ContractualDefinitionIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinitionIdentifier> typeFormatValidator() {
		return new ContractualDefinitionIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualDefinitionIdentifier, Set<String>> onlyExistsValidator() {
		return new ContractualDefinitionIdentifierOnlyExistsValidator();
	}
}
