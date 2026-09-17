package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MatrixTerm;
import fpml.consolidated.shared.validation.MatrixTermTypeFormatValidator;
import fpml.consolidated.shared.validation.MatrixTermValidator;
import fpml.consolidated.shared.validation.exists.MatrixTermOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MatrixTerm.class)
public class MatrixTermMeta implements RosettaMetaData<MatrixTerm> {

	@Override
	public List<Validator<? super MatrixTerm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MatrixTerm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MatrixTerm> validator(ValidatorFactory factory) {
		return factory.<MatrixTerm>create(MatrixTermValidator.class);
	}

	@Override
	public Validator<? super MatrixTerm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MatrixTerm>create(MatrixTermTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MatrixTerm> validator() {
		return new MatrixTermValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MatrixTerm> typeFormatValidator() {
		return new MatrixTermTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MatrixTerm, Set<String>> onlyExistsValidator() {
		return new MatrixTermOnlyExistsValidator();
	}
}
