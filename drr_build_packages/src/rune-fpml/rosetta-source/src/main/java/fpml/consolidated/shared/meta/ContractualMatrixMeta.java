package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ContractualMatrix;
import fpml.consolidated.shared.validation.ContractualMatrixTypeFormatValidator;
import fpml.consolidated.shared.validation.ContractualMatrixValidator;
import fpml.consolidated.shared.validation.exists.ContractualMatrixOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ContractualMatrix.class)
public class ContractualMatrixMeta implements RosettaMetaData<ContractualMatrix> {

	@Override
	public List<Validator<? super ContractualMatrix>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualMatrix, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualMatrix> validator(ValidatorFactory factory) {
		return factory.<ContractualMatrix>create(ContractualMatrixValidator.class);
	}

	@Override
	public Validator<? super ContractualMatrix> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualMatrix>create(ContractualMatrixTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualMatrix> validator() {
		return new ContractualMatrixValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualMatrix> typeFormatValidator() {
		return new ContractualMatrixTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualMatrix, Set<String>> onlyExistsValidator() {
		return new ContractualMatrixOnlyExistsValidator();
	}
}
