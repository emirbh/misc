package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractTradingAccrual;
import fpml.consolidated.loan.validation.AbstractTradingAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractTradingAccrualValidator;
import fpml.consolidated.loan.validation.exists.AbstractTradingAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractTradingAccrual.class)
public class AbstractTradingAccrualMeta implements RosettaMetaData<AbstractTradingAccrual> {

	@Override
	public List<Validator<? super AbstractTradingAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractTradingAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractTradingAccrual> validator(ValidatorFactory factory) {
		return factory.<AbstractTradingAccrual>create(AbstractTradingAccrualValidator.class);
	}

	@Override
	public Validator<? super AbstractTradingAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractTradingAccrual>create(AbstractTradingAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractTradingAccrual> validator() {
		return new AbstractTradingAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractTradingAccrual> typeFormatValidator() {
		return new AbstractTradingAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractTradingAccrual, Set<String>> onlyExistsValidator() {
		return new AbstractTradingAccrualOnlyExistsValidator();
	}
}
