package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.TradeData43__7;
import iso20022.auth030.hkma.dtcc.validation.TradeData43__7TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.TradeData43__7Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.TradeData43__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__7.class)
public class TradeData43__7Meta implements RosettaMetaData<TradeData43__7> {

	@Override
	public List<Validator<? super TradeData43__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__7> validator(ValidatorFactory factory) {
		return factory.<TradeData43__7>create(TradeData43__7Validator.class);
	}

	@Override
	public Validator<? super TradeData43__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__7>create(TradeData43__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__7> validator() {
		return new TradeData43__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__7> typeFormatValidator() {
		return new TradeData43__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__7, Set<String>> onlyExistsValidator() {
		return new TradeData43__7OnlyExistsValidator();
	}
}
