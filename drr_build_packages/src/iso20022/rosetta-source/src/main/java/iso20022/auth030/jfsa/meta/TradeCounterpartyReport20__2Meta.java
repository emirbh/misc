package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeCounterpartyReport20__2;
import iso20022.auth030.jfsa.validation.TradeCounterpartyReport20__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeCounterpartyReport20__2Validator;
import iso20022.auth030.jfsa.validation.exists.TradeCounterpartyReport20__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeCounterpartyReport20__2.class)
public class TradeCounterpartyReport20__2Meta implements RosettaMetaData<TradeCounterpartyReport20__2> {

	@Override
	public List<Validator<? super TradeCounterpartyReport20__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeCounterpartyReport20__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCounterpartyReport20__2> validator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20__2>create(TradeCounterpartyReport20__2Validator.class);
	}

	@Override
	public Validator<? super TradeCounterpartyReport20__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyReport20__2>create(TradeCounterpartyReport20__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20__2> validator() {
		return new TradeCounterpartyReport20__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyReport20__2> typeFormatValidator() {
		return new TradeCounterpartyReport20__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCounterpartyReport20__2, Set<String>> onlyExistsValidator() {
		return new TradeCounterpartyReport20__2OnlyExistsValidator();
	}
}
