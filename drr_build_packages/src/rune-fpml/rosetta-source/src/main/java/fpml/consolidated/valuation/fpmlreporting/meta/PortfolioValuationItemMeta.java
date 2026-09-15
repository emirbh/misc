package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.PortfolioValuationItem;
import fpml.consolidated.valuation.fpmlreporting.validation.PortfolioValuationItemTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.PortfolioValuationItemValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.PortfolioValuationItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PortfolioValuationItem.class)
public class PortfolioValuationItemMeta implements RosettaMetaData<PortfolioValuationItem> {

	@Override
	public List<Validator<? super PortfolioValuationItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioValuationItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioValuationItem> validator(ValidatorFactory factory) {
		return factory.<PortfolioValuationItem>create(PortfolioValuationItemValidator.class);
	}

	@Override
	public Validator<? super PortfolioValuationItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioValuationItem>create(PortfolioValuationItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioValuationItem> validator() {
		return new PortfolioValuationItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioValuationItem> typeFormatValidator() {
		return new PortfolioValuationItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioValuationItem, Set<String>> onlyExistsValidator() {
		return new PortfolioValuationItemOnlyExistsValidator();
	}
}
