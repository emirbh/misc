package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.TradeData43__5;
import iso20022.auth030.asic.validation.TradeData43__5TypeFormatValidator;
import iso20022.auth030.asic.validation.TradeData43__5Validator;
import iso20022.auth030.asic.validation.exists.TradeData43__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__5.class)
public class TradeData43__5Meta implements RosettaMetaData<TradeData43__5> {

	@Override
	public List<Validator<? super TradeData43__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__5> validator(ValidatorFactory factory) {
		return factory.<TradeData43__5>create(TradeData43__5Validator.class);
	}

	@Override
	public Validator<? super TradeData43__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__5>create(TradeData43__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__5> validator() {
		return new TradeData43__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__5> typeFormatValidator() {
		return new TradeData43__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__5, Set<String>> onlyExistsValidator() {
		return new TradeData43__5OnlyExistsValidator();
	}
}
