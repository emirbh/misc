package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeConfirmation5;
import iso20022.auth030.jfsa.validation.TradeConfirmation5TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeConfirmation5Validator;
import iso20022.auth030.jfsa.validation.exists.TradeConfirmation5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeConfirmation5.class)
public class TradeConfirmation5Meta implements RosettaMetaData<TradeConfirmation5> {

	@Override
	public List<Validator<? super TradeConfirmation5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeConfirmation5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeConfirmation5> validator(ValidatorFactory factory) {
		return factory.<TradeConfirmation5>create(TradeConfirmation5Validator.class);
	}

	@Override
	public Validator<? super TradeConfirmation5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeConfirmation5>create(TradeConfirmation5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation5> validator() {
		return new TradeConfirmation5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation5> typeFormatValidator() {
		return new TradeConfirmation5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeConfirmation5, Set<String>> onlyExistsValidator() {
		return new TradeConfirmation5OnlyExistsValidator();
	}
}
