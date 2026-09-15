package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.validation.FxAccrualTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrual.class)
public class FxAccrualMeta implements RosettaMetaData<FxAccrual> {

	@Override
	public List<Validator<? super FxAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrual> validator(ValidatorFactory factory) {
		return factory.<FxAccrual>create(FxAccrualValidator.class);
	}

	@Override
	public Validator<? super FxAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrual>create(FxAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrual> validator() {
		return new FxAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrual> typeFormatValidator() {
		return new FxAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrual, Set<String>> onlyExistsValidator() {
		return new FxAccrualOnlyExistsValidator();
	}
}
