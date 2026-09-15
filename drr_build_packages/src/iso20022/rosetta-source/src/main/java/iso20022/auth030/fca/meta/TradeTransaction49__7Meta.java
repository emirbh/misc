package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeTransaction49__7;
import iso20022.auth030.fca.validation.TradeTransaction49__7TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeTransaction49__7Validator;
import iso20022.auth030.fca.validation.exists.TradeTransaction49__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction49__7.class)
public class TradeTransaction49__7Meta implements RosettaMetaData<TradeTransaction49__7> {

	@Override
	public List<Validator<? super TradeTransaction49__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction49__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction49__7> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction49__7>create(TradeTransaction49__7Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction49__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction49__7>create(TradeTransaction49__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction49__7> validator() {
		return new TradeTransaction49__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction49__7> typeFormatValidator() {
		return new TradeTransaction49__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction49__7, Set<String>> onlyExistsValidator() {
		return new TradeTransaction49__7OnlyExistsValidator();
	}
}
