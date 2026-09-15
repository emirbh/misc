package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeConfirmation2;
import iso20022.auth030.fca.validation.TradeConfirmation2TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeConfirmation2Validator;
import iso20022.auth030.fca.validation.exists.TradeConfirmation2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeConfirmation2.class)
public class TradeConfirmation2Meta implements RosettaMetaData<TradeConfirmation2> {

	@Override
	public List<Validator<? super TradeConfirmation2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeConfirmation2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeConfirmation2> validator(ValidatorFactory factory) {
		return factory.<TradeConfirmation2>create(TradeConfirmation2Validator.class);
	}

	@Override
	public Validator<? super TradeConfirmation2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeConfirmation2>create(TradeConfirmation2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation2> validator() {
		return new TradeConfirmation2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation2> typeFormatValidator() {
		return new TradeConfirmation2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeConfirmation2, Set<String>> onlyExistsValidator() {
		return new TradeConfirmation2OnlyExistsValidator();
	}
}
