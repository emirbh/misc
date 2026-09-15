package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ContractualSupplement;
import fpml.consolidated.shared.validation.ContractualSupplementTypeFormatValidator;
import fpml.consolidated.shared.validation.ContractualSupplementValidator;
import fpml.consolidated.shared.validation.exists.ContractualSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ContractualSupplement.class)
public class ContractualSupplementMeta implements RosettaMetaData<ContractualSupplement> {

	@Override
	public List<Validator<? super ContractualSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualSupplement> validator(ValidatorFactory factory) {
		return factory.<ContractualSupplement>create(ContractualSupplementValidator.class);
	}

	@Override
	public Validator<? super ContractualSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualSupplement>create(ContractualSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualSupplement> validator() {
		return new ContractualSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualSupplement> typeFormatValidator() {
		return new ContractualSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualSupplement, Set<String>> onlyExistsValidator() {
		return new ContractualSupplementOnlyExistsValidator();
	}
}
