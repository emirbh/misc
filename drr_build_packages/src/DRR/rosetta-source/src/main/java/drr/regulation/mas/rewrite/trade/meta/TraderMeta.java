package drr.regulation.mas.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.mas.rewrite.trade.Trader;
import drr.regulation.mas.rewrite.trade.validation.TraderTypeFormatValidator;
import drr.regulation.mas.rewrite.trade.validation.TraderValidator;
import drr.regulation.mas.rewrite.trade.validation.exists.TraderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=Trader.class)
public class TraderMeta implements RosettaMetaData<Trader> {

	@Override
	public List<Validator<? super Trader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Trader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Trader> validator(ValidatorFactory factory) {
		return factory.<Trader>create(TraderValidator.class);
	}

	@Override
	public Validator<? super Trader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Trader>create(TraderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Trader> validator() {
		return new TraderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Trader> typeFormatValidator() {
		return new TraderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Trader, Set<String>> onlyExistsValidator() {
		return new TraderOnlyExistsValidator();
	}
}
