package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.ContractType15__3;
import iso20022.auth030.mas.validation.ContractType15__3TypeFormatValidator;
import iso20022.auth030.mas.validation.ContractType15__3Validator;
import iso20022.auth030.mas.validation.exists.ContractType15__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ContractType15__3.class)
public class ContractType15__3Meta implements RosettaMetaData<ContractType15__3> {

	@Override
	public List<Validator<? super ContractType15__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractType15__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractType15__3> validator(ValidatorFactory factory) {
		return factory.<ContractType15__3>create(ContractType15__3Validator.class);
	}

	@Override
	public Validator<? super ContractType15__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractType15__3>create(ContractType15__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__3> validator() {
		return new ContractType15__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractType15__3> typeFormatValidator() {
		return new ContractType15__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractType15__3, Set<String>> onlyExistsValidator() {
		return new ContractType15__3OnlyExistsValidator();
	}
}
