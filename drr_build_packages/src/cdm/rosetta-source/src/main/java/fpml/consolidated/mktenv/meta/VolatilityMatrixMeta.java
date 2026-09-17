package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.VolatilityMatrix;
import fpml.consolidated.mktenv.validation.VolatilityMatrixTypeFormatValidator;
import fpml.consolidated.mktenv.validation.VolatilityMatrixValidator;
import fpml.consolidated.mktenv.validation.exists.VolatilityMatrixOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityMatrix.class)
public class VolatilityMatrixMeta implements RosettaMetaData<VolatilityMatrix> {

	@Override
	public List<Validator<? super VolatilityMatrix>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityMatrix, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityMatrix> validator(ValidatorFactory factory) {
		return factory.<VolatilityMatrix>create(VolatilityMatrixValidator.class);
	}

	@Override
	public Validator<? super VolatilityMatrix> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityMatrix>create(VolatilityMatrixTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityMatrix> validator() {
		return new VolatilityMatrixValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityMatrix> typeFormatValidator() {
		return new VolatilityMatrixTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityMatrix, Set<String>> onlyExistsValidator() {
		return new VolatilityMatrixOnlyExistsValidator();
	}
}
