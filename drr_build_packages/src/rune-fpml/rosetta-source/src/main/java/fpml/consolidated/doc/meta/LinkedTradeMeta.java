package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.LinkedTrade;
import fpml.consolidated.doc.validation.LinkedTradeTypeFormatValidator;
import fpml.consolidated.doc.validation.LinkedTradeValidator;
import fpml.consolidated.doc.validation.exists.LinkedTradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LinkedTrade.class)
public class LinkedTradeMeta implements RosettaMetaData<LinkedTrade> {

	@Override
	public List<Validator<? super LinkedTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LinkedTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LinkedTrade> validator(ValidatorFactory factory) {
		return factory.<LinkedTrade>create(LinkedTradeValidator.class);
	}

	@Override
	public Validator<? super LinkedTrade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LinkedTrade>create(LinkedTradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LinkedTrade> validator() {
		return new LinkedTradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LinkedTrade> typeFormatValidator() {
		return new LinkedTradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LinkedTrade, Set<String>> onlyExistsValidator() {
		return new LinkedTradeOnlyExistsValidator();
	}
}
