package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ContractType15__2;
import iso20022.auth030.asic.validation.ContractType15__2TypeFormatValidator;
import iso20022.auth030.asic.validation.ContractType15__2Validator;
import iso20022.auth030.asic.validation.exists.ContractType15__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ContractType15__2.class)
public class ContractType15__2Meta implements RosettaMetaData<ContractType15__2> {

	@Override
	public List<Validator<? super ContractType15__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractType15__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractType15__2> validator(ValidatorFactory factory) {
		return factory.<ContractType15__2>create(ContractType15__2Validator.class);
	}

	@Override
	public Validator<? super ContractType15__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractType15__2>create(ContractType15__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__2> validator() {
		return new ContractType15__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__2> typeFormatValidator() {
		return new ContractType15__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractType15__2, Set<String>> onlyExistsValidator() {
		return new ContractType15__2OnlyExistsValidator();
	}
}
