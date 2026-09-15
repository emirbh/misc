package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.SettledEntityMatrix;
import fpml.consolidated.cd.validation.SettledEntityMatrixTypeFormatValidator;
import fpml.consolidated.cd.validation.SettledEntityMatrixValidator;
import fpml.consolidated.cd.validation.exists.SettledEntityMatrixOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettledEntityMatrix.class)
public class SettledEntityMatrixMeta implements RosettaMetaData<SettledEntityMatrix> {

	@Override
	public List<Validator<? super SettledEntityMatrix>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettledEntityMatrix, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettledEntityMatrix> validator(ValidatorFactory factory) {
		return factory.<SettledEntityMatrix>create(SettledEntityMatrixValidator.class);
	}

	@Override
	public Validator<? super SettledEntityMatrix> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettledEntityMatrix>create(SettledEntityMatrixTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettledEntityMatrix> validator() {
		return new SettledEntityMatrixValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettledEntityMatrix> typeFormatValidator() {
		return new SettledEntityMatrixTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettledEntityMatrix, Set<String>> onlyExistsValidator() {
		return new SettledEntityMatrixOnlyExistsValidator();
	}
}
