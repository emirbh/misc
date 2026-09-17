package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.loan.validation.BuyerSellerAmountsTypeFormatValidator;
import fpml.consolidated.loan.validation.BuyerSellerAmountsValidator;
import fpml.consolidated.loan.validation.exists.BuyerSellerAmountsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BuyerSellerAmounts.class)
public class BuyerSellerAmountsMeta implements RosettaMetaData<BuyerSellerAmounts> {

	@Override
	public List<Validator<? super BuyerSellerAmounts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BuyerSellerAmounts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BuyerSellerAmounts> validator(ValidatorFactory factory) {
		return factory.<BuyerSellerAmounts>create(BuyerSellerAmountsValidator.class);
	}

	@Override
	public Validator<? super BuyerSellerAmounts> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BuyerSellerAmounts>create(BuyerSellerAmountsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BuyerSellerAmounts> validator() {
		return new BuyerSellerAmountsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BuyerSellerAmounts> typeFormatValidator() {
		return new BuyerSellerAmountsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BuyerSellerAmounts, Set<String>> onlyExistsValidator() {
		return new BuyerSellerAmountsOnlyExistsValidator();
	}
}
