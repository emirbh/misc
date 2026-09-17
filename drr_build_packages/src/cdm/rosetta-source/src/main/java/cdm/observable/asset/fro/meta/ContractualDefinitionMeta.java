package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.validation.ContractualDefinitionTypeFormatValidator;
import cdm.observable.asset.fro.validation.ContractualDefinitionValidator;
import cdm.observable.asset.fro.validation.datarule.ContractualDefinitionChoice;
import cdm.observable.asset.fro.validation.exists.ContractualDefinitionOnlyExistsValidator;
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
@RosettaMeta(model=ContractualDefinition.class)
public class ContractualDefinitionMeta implements RosettaMetaData<ContractualDefinition> {

	@Override
	public List<Validator<? super ContractualDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractualDefinition>create(ContractualDefinitionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ContractualDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualDefinition> validator(ValidatorFactory factory) {
		return factory.<ContractualDefinition>create(ContractualDefinitionValidator.class);
	}

	@Override
	public Validator<? super ContractualDefinition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualDefinition>create(ContractualDefinitionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinition> validator() {
		return new ContractualDefinitionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinition> typeFormatValidator() {
		return new ContractualDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualDefinition, Set<String>> onlyExistsValidator() {
		return new ContractualDefinitionOnlyExistsValidator();
	}
}
