package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.validation.CashflowTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.CashflowTypeValidator;
import fpml.consolidated.shared.validation.exists.CashflowTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashflowType.class)
public class CashflowTypeMeta implements RosettaMetaData<CashflowType> {

	@Override
	public List<Validator<? super CashflowType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashflowType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashflowType> validator(ValidatorFactory factory) {
		return factory.<CashflowType>create(CashflowTypeValidator.class);
	}

	@Override
	public Validator<? super CashflowType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashflowType>create(CashflowTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashflowType> validator() {
		return new CashflowTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashflowType> typeFormatValidator() {
		return new CashflowTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowType, Set<String>> onlyExistsValidator() {
		return new CashflowTypeOnlyExistsValidator();
	}
}
