package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.TradeValuationItem;
import fpml.consolidated.valuation.fpmlreporting.validation.TradeValuationItemTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.TradeValuationItemValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.datarule.TradeValuationItemChoice;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.TradeValuationItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeValuationItem.class)
public class TradeValuationItemMeta implements RosettaMetaData<TradeValuationItem> {

	@Override
	public List<Validator<? super TradeValuationItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeValuationItem>create(TradeValuationItemChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeValuationItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeValuationItem> validator(ValidatorFactory factory) {
		return factory.<TradeValuationItem>create(TradeValuationItemValidator.class);
	}

	@Override
	public Validator<? super TradeValuationItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeValuationItem>create(TradeValuationItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeValuationItem> validator() {
		return new TradeValuationItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeValuationItem> typeFormatValidator() {
		return new TradeValuationItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeValuationItem, Set<String>> onlyExistsValidator() {
		return new TradeValuationItemOnlyExistsValidator();
	}
}
