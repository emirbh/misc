package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeData43__8;
import iso20022.auth030.jfsa.validation.TradeData43__8TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeData43__8Validator;
import iso20022.auth030.jfsa.validation.exists.TradeData43__8OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__8.class)
public class TradeData43__8Meta implements RosettaMetaData<TradeData43__8> {

	@Override
	public List<Validator<? super TradeData43__8>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__8, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__8> validator(ValidatorFactory factory) {
		return factory.<TradeData43__8>create(TradeData43__8Validator.class);
	}

	@Override
	public Validator<? super TradeData43__8> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__8>create(TradeData43__8TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__8> validator() {
		return new TradeData43__8Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__8> typeFormatValidator() {
		return new TradeData43__8TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__8, Set<String>> onlyExistsValidator() {
		return new TradeData43__8OnlyExistsValidator();
	}
}
