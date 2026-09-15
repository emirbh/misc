package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MatrixType;
import fpml.consolidated.shared.validation.MatrixTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.MatrixTypeValidator;
import fpml.consolidated.shared.validation.exists.MatrixTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MatrixType.class)
public class MatrixTypeMeta implements RosettaMetaData<MatrixType> {

	@Override
	public List<Validator<? super MatrixType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MatrixType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MatrixType> validator(ValidatorFactory factory) {
		return factory.<MatrixType>create(MatrixTypeValidator.class);
	}

	@Override
	public Validator<? super MatrixType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MatrixType>create(MatrixTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MatrixType> validator() {
		return new MatrixTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MatrixType> typeFormatValidator() {
		return new MatrixTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MatrixType, Set<String>> onlyExistsValidator() {
		return new MatrixTypeOnlyExistsValidator();
	}
}
