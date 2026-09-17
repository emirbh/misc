package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.doc.validation.TradeCategoryTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeCategoryValidator;
import fpml.consolidated.doc.validation.exists.TradeCategoryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeCategory.class)
public class TradeCategoryMeta implements RosettaMetaData<TradeCategory> {

	@Override
	public List<Validator<? super TradeCategory>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeCategory, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCategory> validator(ValidatorFactory factory) {
		return factory.<TradeCategory>create(TradeCategoryValidator.class);
	}

	@Override
	public Validator<? super TradeCategory> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCategory>create(TradeCategoryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCategory> validator() {
		return new TradeCategoryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCategory> typeFormatValidator() {
		return new TradeCategoryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCategory, Set<String>> onlyExistsValidator() {
		return new TradeCategoryOnlyExistsValidator();
	}
}
