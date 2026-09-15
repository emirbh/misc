package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ContractualDefinitions;
import fpml.consolidated.shared.validation.ContractualDefinitionsTypeFormatValidator;
import fpml.consolidated.shared.validation.ContractualDefinitionsValidator;
import fpml.consolidated.shared.validation.exists.ContractualDefinitionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ContractualDefinitions.class)
public class ContractualDefinitionsMeta implements RosettaMetaData<ContractualDefinitions> {

	@Override
	public List<Validator<? super ContractualDefinitions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualDefinitions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualDefinitions> validator(ValidatorFactory factory) {
		return factory.<ContractualDefinitions>create(ContractualDefinitionsValidator.class);
	}

	@Override
	public Validator<? super ContractualDefinitions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualDefinitions>create(ContractualDefinitionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinitions> validator() {
		return new ContractualDefinitionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualDefinitions> typeFormatValidator() {
		return new ContractualDefinitionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualDefinitions, Set<String>> onlyExistsValidator() {
		return new ContractualDefinitionsOnlyExistsValidator();
	}
}
