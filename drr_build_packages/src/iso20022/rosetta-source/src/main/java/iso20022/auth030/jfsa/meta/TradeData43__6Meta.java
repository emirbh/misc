package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeData43__6;
import iso20022.auth030.jfsa.validation.TradeData43__6TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeData43__6Validator;
import iso20022.auth030.jfsa.validation.exists.TradeData43__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__6.class)
public class TradeData43__6Meta implements RosettaMetaData<TradeData43__6> {

	@Override
	public List<Validator<? super TradeData43__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__6> validator(ValidatorFactory factory) {
		return factory.<TradeData43__6>create(TradeData43__6Validator.class);
	}

	@Override
	public Validator<? super TradeData43__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__6>create(TradeData43__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__6> validator() {
		return new TradeData43__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__6> typeFormatValidator() {
		return new TradeData43__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__6, Set<String>> onlyExistsValidator() {
		return new TradeData43__6OnlyExistsValidator();
	}
}
