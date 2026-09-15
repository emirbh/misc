package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.ContractType15__1;
import iso20022.auth030.mas.validation.ContractType15__1TypeFormatValidator;
import iso20022.auth030.mas.validation.ContractType15__1Validator;
import iso20022.auth030.mas.validation.exists.ContractType15__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ContractType15__1.class)
public class ContractType15__1Meta implements RosettaMetaData<ContractType15__1> {

	@Override
	public List<Validator<? super ContractType15__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractType15__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractType15__1> validator(ValidatorFactory factory) {
		return factory.<ContractType15__1>create(ContractType15__1Validator.class);
	}

	@Override
	public Validator<? super ContractType15__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractType15__1>create(ContractType15__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__1> validator() {
		return new ContractType15__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__1> typeFormatValidator() {
		return new ContractType15__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractType15__1, Set<String>> onlyExistsValidator() {
		return new ContractType15__1OnlyExistsValidator();
	}
}
