package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingFacilityFeeAccrual;
import fpml.consolidated.loan.validation.LoanTradingFacilityFeeAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingFacilityFeeAccrualValidator;
import fpml.consolidated.loan.validation.exists.LoanTradingFacilityFeeAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingFacilityFeeAccrual.class)
public class LoanTradingFacilityFeeAccrualMeta implements RosettaMetaData<LoanTradingFacilityFeeAccrual> {

	@Override
	public List<Validator<? super LoanTradingFacilityFeeAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingFacilityFeeAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingFacilityFeeAccrual> validator(ValidatorFactory factory) {
		return factory.<LoanTradingFacilityFeeAccrual>create(LoanTradingFacilityFeeAccrualValidator.class);
	}

	@Override
	public Validator<? super LoanTradingFacilityFeeAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingFacilityFeeAccrual>create(LoanTradingFacilityFeeAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingFacilityFeeAccrual> validator() {
		return new LoanTradingFacilityFeeAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingFacilityFeeAccrual> typeFormatValidator() {
		return new LoanTradingFacilityFeeAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingFacilityFeeAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingFacilityFeeAccrualOnlyExistsValidator();
	}
}
