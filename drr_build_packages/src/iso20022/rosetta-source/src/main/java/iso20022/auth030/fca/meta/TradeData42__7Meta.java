package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeData42__7;
import iso20022.auth030.fca.validation.TradeData42__7TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeData42__7Validator;
import iso20022.auth030.fca.validation.exists.TradeData42__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__7.class)
public class TradeData42__7Meta implements RosettaMetaData<TradeData42__7> {

	@Override
	public List<Validator<? super TradeData42__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__7> validator(ValidatorFactory factory) {
		return factory.<TradeData42__7>create(TradeData42__7Validator.class);
	}

	@Override
	public Validator<? super TradeData42__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__7>create(TradeData42__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__7> validator() {
		return new TradeData42__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__7> typeFormatValidator() {
		return new TradeData42__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__7, Set<String>> onlyExistsValidator() {
		return new TradeData42__7OnlyExistsValidator();
	}
}
